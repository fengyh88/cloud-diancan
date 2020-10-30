package com.fish.cloud.api.controller;

import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.service.IWechatService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wechat")
public class WechatController {
    @Autowired
    private IWechatService wechatService;

    @ApiOperation("生成微信小程序菊花码")
    @RequestMapping(value = "/generateMiniProgramBarCode",method = RequestMethod.POST)
    public TupleRet generateMiniProgramBarCode(Long shopId) {
        return wechatService.generateMiniProgramBarCode(shopId);
    }
}
