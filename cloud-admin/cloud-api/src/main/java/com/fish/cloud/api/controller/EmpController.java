package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.EmpDto;
import com.fish.cloud.bean.model.Emp;
import com.fish.cloud.bean.param.EmpAddParam;
import com.fish.cloud.bean.param.EmpParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IEmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "员工")
@Controller
@RequestMapping("/api/emp")
public class EmpController {
    @Autowired
    private IEmpService empService;

    /**
     * 分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页", notes = "分页")
    @GetMapping("/page")
    @ResponseBody
    public ApiResult<IPage<EmpDto>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
                                         EmpParam empParam) {
        // 分页
        var models = empService.page(new Page<Emp>(pageNo, pageSize), new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(0L != empParam.getDeptId(), Emp::getDeptId, empParam.getDeptId())
                .eq(0L != empParam.getDutyId(), Emp::getDutyId, empParam.getDutyId())
                .and(StrUtil.isNotEmpty(empParam.getKeywords()), empLambdaQueryWrapper -> empLambdaQueryWrapper
                        .like(Emp::getEmpNumber, empParam.getKeywords())
                        .or()
                        .like(Emp::getEmpName, empParam.getKeywords())
                        .or()
                        .like(Emp::getEmail, empParam.getKeywords())
                        .or()
                        .like(Emp::getMobile, empParam.getKeywords()))
                .eq(Emp::getStatus, 1));
        // dto
        IPage<EmpDto> dtoList = models.convert(model -> Convert.convert(EmpDto.class, model));
        return ApiResult.success(dtoList);
    }

    @ApiOperation(value = "列表", notes = "列表")
    @ApiImplicitParam(name = "empParam", value = "员工入参", required = true)
    @GetMapping(value = "/list")
    public ApiResult<List<EmpDto>> list(EmpParam empParam) {
        // 列表
        var models = empService.list(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .and(StrUtil.isNotEmpty(empParam.getKeywords()), empLambdaQueryWrapper -> empLambdaQueryWrapper
                        .like(Emp::getEmpNumber, empParam.getKeywords())
                        .or()
                        .like(Emp::getEmpName, empParam.getKeywords())
                        .or()
                        .like(Emp::getEmail, empParam.getKeywords())
                        .or()
                        .like(Emp::getMobile, empParam.getKeywords()))
                .eq(Emp::getStatus, 1));
        // dto
        List<EmpDto> dtoList = models.stream().map(model -> {
            EmpDto dto = new EmpDto();
            BeanUtils.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }

    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    @GetMapping(value = "/detail")
    public ApiResult<EmpDto> detail(@RequestParam(value = "id") long id) {
        var model = empService.getById(id);
        var dto = new EmpDto();
        BeanUtils.copyProperties(model, dto);
        return ApiResult.success(dto);
    }

    @ApiOperation("更改状态，正常禁用删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "员工Id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 0禁用 1启用", required = true)
    })
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 0, 1}, status)) {
            return ApiResult.failed("需传入-1删除 0禁用 1启用");
        }
        var ret = empService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "empAddParam", value = "员工信息", required = true)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody EmpAddParam empAddParam) {
        var ret = empService.add(empAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "empAddParam", value = "员工信息", required = true)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ApiResult edit(@RequestBody EmpAddParam empAddParam) {
        var ret = empService.edit(empAddParam);
        return ApiResult.fromTupleRet(ret);
    }
}
