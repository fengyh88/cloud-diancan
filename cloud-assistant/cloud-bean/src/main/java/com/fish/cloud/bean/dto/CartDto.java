package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CartDto {

    /**
     * 主键
     */
    private Long cartId;
    /**
     * 店铺Id
     */
    private String shopId;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 商品Id
     */
    private Long prodId;
    /**
     * SkuId
     */
    private String skuId;
    /**
     * 购物车商品个数
     */
    private Integer num;
    /**
     * 购物时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cartTime;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 商品编码
     */
    private String prodCode;
    /**
     * 商品名称
     */
    private String prodName;
    /**
     * 拼音简码
     */
    private String pinyin;
    /**
     * 商品分类
     */
    private Long cateId;
    /**
     * 品牌Id
     */
    private Long brandId;
    /**
     * 原价
     */
    private BigDecimal oriPrice;
    /**
     * 现价
     */
    private BigDecimal price;
    /**
     * 会员价
     */
    private BigDecimal memPrice;
    /**
     * 单位Id
     */
    private String unitId;
    /**
     * 单位
     */
    private String unitName;
    /**
     * 简要描述,卖点等
     */
    private String brief;
    /**
     * 销量
     */
    private Integer sold;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 默认是1，表示正常状态, -1表示删除, 0下架
     */
    private Integer status;

    /**
     * 主图
     */
    private String img;
}
