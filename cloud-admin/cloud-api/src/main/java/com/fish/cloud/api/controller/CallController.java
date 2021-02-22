package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.CallDto;
import com.fish.cloud.bean.dto.TableDto;
import com.fish.cloud.bean.model.Call;
import com.fish.cloud.bean.model.Emp;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.service.ICallService;
import com.fish.cloud.service.IEmpService;
import com.fish.cloud.service.ITableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 呼叫
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "呼叫")
@RestController
@RequestMapping("/call")
public class CallController {
    @Autowired
    private ICallService callService;
    @Autowired
    private ITableService tableService;
    @Autowired
    private IEmpService empService;

    @ApiOperation("获取呼叫列表")
    @GetMapping(value = "/listCalling")
    public ApiResult<List<CallDto>> listCalling() {
        var models = callService.list(new LambdaQueryWrapper<Call>()
                .eq(Call::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Call::getStatus, 1));
        // 获取列表备用
        var empList = empService.all();
        var tableList = tableService.all();
        // dto
        List<CallDto> dtoList = models.stream().map(model -> {
            var dto = new CallDto();
            BeanUtils.copyProperties(model, dto);
            Optional<Emp> empOptional = empList.stream().filter(emp -> emp.getEmpId().equals(dto.getEmpId())).findFirst();
            if (empOptional.isPresent()){
                dto.setEmpText(empOptional.get().getEmpName());
            }
            Optional<TableDto> tableDtoOptional = tableList.stream().filter(table -> table.getTableId() == dto.getTableId()).findFirst();
            if (tableDtoOptional.isPresent()){
                dto.setTableText(tableDtoOptional.get().getTableName());
            }
            return dto;
        }).collect(Collectors.toList());
        // 返回
        return ApiResult.success(dtoList);
    }

    /**
     * 获取已读列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "获取已读列表", notes = "获取已读列表")
    @GetMapping("/pageReaded")
    @ResponseBody
    public ApiResult<IPage<CallDto>> pageReaded(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                              @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize) {
        IPage<Call> modelPage = callService.page(new Page<Call>(pageNo, pageSize), new LambdaQueryWrapper<Call>()
                .eq(Call::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .in(Call::getStatus, new int[]{2, 0}) // 包含已读和已过期的
                .ge(Call::getUpdateTime, DateTimeUtil.getCurrentDateTimeFormat("yyyy-MM-dd 00:00:00"))); // 仅显示当天的
        // 转换
        IPage<CallDto> dtoPage = modelPage.convert(call -> Convert.convert(CallDto.class, call));
        // 获取列表备用
        var empList = empService.all();
        var tableList = tableService.all();
        // 字典转换
        dtoPage.getRecords().stream().forEach(dto -> {
            Optional<Emp> empOptional = empList.stream().filter(emp -> emp.getEmpId().equals(dto.getEmpId())).findFirst();
            if (empOptional.isPresent()){
                dto.setEmpText(empOptional.get().getEmpName());
            }
            Optional<TableDto> tableDtoOptional = tableList.stream().filter(table -> table.getTableId() == dto.getTableId()).findFirst();
            if (tableDtoOptional.isPresent()){
                dto.setTableText(tableDtoOptional.get().getTableName());
            }
        });
        // 返回
        return ApiResult.success(dtoPage);
    }

    @ApiOperation("更改状态为已读")
    @GetMapping(value = "/read")
    public ApiResult read(@RequestParam("id") long id) {
        var ret = callService.read(id);
        return ApiResult.fromTupleRet(ret);
    }
}
