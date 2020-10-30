package com.fish.cloud.service;

import com.fish.cloud.common.util.TupleRet;

public interface IWechatService {
    /**
     * 生成微信小程序菊花码
     * @param
     * @return
     */
    public TupleRet generateMiniProgramBarCode(Long shopId);
}
