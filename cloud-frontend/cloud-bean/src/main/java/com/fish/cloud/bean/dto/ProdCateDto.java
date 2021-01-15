package com.fish.cloud.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
public class ProdCateDto {

    /**
     * 类目Id
     */
	private Long cateId;
    /**
     * 店铺Id
     */
	private Long shopId;
    /**
     * 类目名称
     */
	private String cateName;
    /**
     * 类目图标
     */
	private String icon;
    /**
     * 类目的显示图片
     */
	private String img;
    /**
     * 父节点
     */
	private Long pId;
    /**
     * 分类层级
     */
	private Integer grade;
    /**
     * 排序
     */
	private Integer seq;
    /**
     * 默认是1 正常状态,0 禁用状态 -1 删除状态
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
