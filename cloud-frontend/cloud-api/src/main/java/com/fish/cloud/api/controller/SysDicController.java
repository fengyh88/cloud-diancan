package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import com.fish.cloud.bean.dto.SysDicDto;
import com.fish.cloud.bean.model.SysDic;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ISysDicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统字典
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "系统字典")
@Controller
@RequestMapping("/sys/dic")
public class SysDicController {
    @Autowired
    private ISysDicService sysDicService;

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public ApiResult<List<SysDicDto>> all() {
        var models = sysDicService.all();
        List<SysDicDto> dtoList = models.stream().map(model -> {
            SysDicDto dto = new SysDicDto();
            BeanUtil.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }
}
