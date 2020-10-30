package com.fish.cloud.api.controller;

import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.Dvy;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IDvyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 送货方式
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "送货方式")
@RestController
@RequestMapping("/dvy")
public class DvyController {
    @Autowired
    private IDvyService dvyService;

    @ApiOperation("获取送货方式")
    @GetMapping(value = "/get")
    public ApiResult<Dvy> get() {
        var dto = dvyService.getByShopId(ApiContextHolder.getShopId());
        return ApiResult.success(dto);
    }
}
