package com.fish.cloud.common.util.wx;

import lombok.Data;

@Data
public class WxUserInfoModel {
    private String openId;
    private String nickName;
    private String gender;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
}
