package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import com.fish.cloud.bean.dto.CallDto;
import com.fish.cloud.bean.param.CallAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ICallService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/call")
public class CallController {

    @Autowired
    private ICallService callService;

    @ApiOperation("添加")
    @ApiImplicitParam(name = "callAddParam", value = "添加信息", required = true)
    @PostMapping(value = "/add")
    public ApiResult add(@RequestBody CallAddParam callAddParam) {
        var ret = callService.add(callAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("获取当前台桌列表")
    @GetMapping(value = "/listByCurTable")
    public ApiResult<List<CallDto>> listByCurTable() {
        var models = callService.listByCurTable();
        List<CallDto> dtoList = models.stream().map(model -> {
            var dto = new CallDto();
            BeanUtil.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }
}
