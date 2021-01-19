package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.ShopDto;
import com.fish.cloud.bean.dto.WechatPlatformDto;
import com.fish.cloud.bean.model.Shop;
import com.fish.cloud.bean.model.WechatPlatform;
import com.fish.cloud.bean.param.*;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IWechatPlatformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 微信公众平台配置
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "微信公众平台配置")
@Controller
@RequestMapping("/wechatPlatform")
public class WechatPlatformController {
    @Autowired
    private IWechatPlatformService wechatPlatformService;

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
    public ApiResult<IPage<WechatPlatformDto>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize) {
        IPage<WechatPlatform> modelPage = wechatPlatformService.page(new Page<WechatPlatform>(pageNo, pageSize), new LambdaQueryWrapper<WechatPlatform>().ne(WechatPlatform::getStatus, -1));
        IPage<WechatPlatformDto> dtoPage = modelPage.convert(model -> Convert.convert(WechatPlatformDto.class, model));
        return ApiResult.success(dtoPage);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "shopAddParam", value = "添加", required = true)
    @PostMapping(value = "/add")
    public ApiResult add(@RequestBody WechatPlatformAddParam wechatPlatformAddParam) {
        var ret = wechatPlatformService.add(wechatPlatformAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "shopEditParam", value = "店铺", required = true)
    @PostMapping(value = "/edit")
    public ApiResult edit(@RequestBody WechatPlatformEditParam wechatPlatformEditParam) {
        var ret = wechatPlatformService.edit(wechatPlatformEditParam);
        return ApiResult.fromTupleRet(ret);
    }

}
