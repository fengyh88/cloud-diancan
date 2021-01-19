package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@ApiModel
@Data
public class ShopDto {

    @ApiModelProperty(value = "店铺Id")
    private String shopId;

    @ApiModelProperty(value = "店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一")
    private String shopName;

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

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "每天营业时间(可修改)")
    private String openTime;

    @ApiModelProperty(value = "每天关店时间(可修改)")
    private String closeTime;

    @ApiModelProperty(value = "店铺状态(-1删除 0停业中 1营业中)")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "图片列表")
    private List<ShopImgDto> imgList;
}
