package com.fish.cloud.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @ApiModelProperty(name = "id")
    private String userId;
    @ApiModelProperty(name = "手机号")
    private String mobile;
    @ApiModelProperty(name = "昵称")
    private String nickName;
    @ApiModelProperty(name = "头像地址")
    private String img;
    @ApiModelProperty(name = "M(男) or F(女)")
    private String gender;
    @ApiModelProperty(name = "国家")
    private String country;
    @ApiModelProperty(name = "省")
    private String province;
    @ApiModelProperty(name = "市")
    private String city;
    @ApiModelProperty(name = "wechatOpenId")
    private String wechatOpenId;
    @ApiModelProperty(name = "会员等级")
    private String gradeId;
    @ApiModelProperty(name = "当前积分")
    private String currentIntegral;
}
