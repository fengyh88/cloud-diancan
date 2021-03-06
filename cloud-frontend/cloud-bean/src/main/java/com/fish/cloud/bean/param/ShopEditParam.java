package com.fish.cloud.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel
@Data
public class ShopEditParam {
    @ApiModelProperty(value = "店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一")
    private String shopName;

    @ApiModelProperty(value = "店铺类型")
    private Integer shopType;

    @ApiModelProperty(value = "店铺行业(餐饮、生鲜果蔬、鲜花等)")
    private Integer industry;

    @ApiModelProperty(value = "店铺简介(可修改)")
    private String brief;

    @ApiModelProperty(value = "店铺公告(可修改)")
    private String notice;

    @ApiModelProperty(value = "店铺联系电话")
    private String tel;

    @ApiModelProperty(value = "店铺所在纬度(可修改)")
    private String lat;

    @ApiModelProperty(value = "店铺所在经度(可修改)")
    private String lng;

    @ApiModelProperty(value = "店铺省市区代码，用于回显")
    private String pcaCode;

    @ApiModelProperty(value = "店铺所在省市区（描述）")
    private String pcaName;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "每天营业时间(可修改)")
    private String openTime;

    @ApiModelProperty(value = "每天关店时间(可修改)")
    private String closeTime;

    @ApiModelProperty(value = "满X包邮")
    private BigDecimal freeDvy;

    @ApiModelProperty(value = "满X起送")
    private BigDecimal freeGo;

    @ApiModelProperty(value = "店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改")
    private Integer status;
}
