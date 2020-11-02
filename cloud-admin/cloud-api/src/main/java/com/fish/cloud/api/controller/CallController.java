package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.CallDto;
import com.fish.cloud.bean.model.Call;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ICallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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
@Controller
@RequestMapping("/api/call")
public class CallController {
    @Autowired
    private ICallService callService;

    @ApiOperation("获取呼叫列表")
    @GetMapping(value = "/listCalling")
    public ApiResult<List<CallDto>> listCalling() {
        // model
        var models = callService.list(new LambdaQueryWrapper<Call>()
                .eq(Call::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Call::getStatus, 1));
        // dto
        List<CallDto> dtoList = models.stream().map(model -> {
            CallDto dto = new CallDto();
            BeanUtils.copyProperties(model, dto);
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
    @GetMapping("/pageRead")
    @ResponseBody
    public ApiResult<IPage<CallDto>> pageRead(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                   @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize) {
        // 获取分页列表
        IPage<Call> p = callService.page(new Page<Call>(pageNo, pageSize), new LambdaQueryWrapper<Call>()
                .eq(Call::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Call::getStatus, 2)
                .eq(Call::getEmpId, ApiContextHolder.getAuthDto().getEmpId()));
        // 转换
        IPage<CallDto> r = p.convert(call -> Convert.convert(CallDto.class, call));
        // 返回
        return ApiResult.success(r);
    }

    @ApiOperation("更改状态，状态 -1删除 2已读")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
            @ApiImplicitParam(name = "status", value = "状态 -1删除 2已读", required = true)
    })
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{-1, 2}, status)) {
            return ApiResult.failed("需传入状态 -1删除 2已读");
        }
        var ret = callService.updateStatus(id, status);
        return ApiResult.fromTupleRet(ret);
    }
}
