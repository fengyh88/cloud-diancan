package com.fish.cloud.bean.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 优惠券
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
public class CouponDto {
    /**
     * 优惠券Id
     */
	private Long couponId;
    /**
     * 店铺Id
     */
	private Long shopId;
    /**
     * 优惠券名称
     */
	private String couponName;
    /**
     * 简介
     */
	private String intro;
    /**
     * 图片
     */
	private String img;
    /**
     * 优惠券类型：1=折扣，2=满减
     */
	private Integer discountType;
    /**
     * 最低消费金额
     */
	private BigDecimal minAmount;
    /**
     * 优惠金额
     */
	private BigDecimal subAmount;
    /**
     * 折扣率
     */
	private BigDecimal discount;
    /**
     * 到期类型：1=领取后N天过期，2=指定有效期
     */
	private Integer expireType;
    /**
     * 有效天数，expire_type=1时
     */
	private Integer expireDay;
    /**
     * 有效期开始时间
     */
	private Date beginTime;
    /**
     * 有效期结束时间
     */
	private Date endTime;
    /**
     * 发放总数量
     */
	private Integer totalNum;
    /**
     * 适用商品分类列
     */
	private String prodCateList;
    /**
     * 适用商品列
     */
	private String prodList;
    /**
     * 售价
     */
	private BigDecimal price;
    /**
     * 排序
     */
	private Integer seq;
    /**
     * 0 禁用 1 启用 -1删除
     */
	private Integer status;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 更新时间
     */
	private Date updateTime;
}
