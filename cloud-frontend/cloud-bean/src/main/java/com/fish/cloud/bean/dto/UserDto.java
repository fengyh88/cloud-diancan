package com.fish.cloud.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String user_id;
    @ApiModelProperty(name = "wechatOpenId")
    private String wechatOpenId;
    @ApiModelProperty(name = "")
    private String accessToken;
    @ApiModelProperty(name = "昵称")
    private String nickname;
    @ApiModelProperty(name = "头像地址")
    private String avatarUrl;
}
