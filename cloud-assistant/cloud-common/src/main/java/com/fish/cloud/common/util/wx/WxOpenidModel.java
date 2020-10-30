package com.fish.cloud.common.util.wx;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WxOpenidModel {
    private String openId;
    private String sessionKey;
}
