package com.fish.cloud.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * 店铺图
 * </p>
 *
 * @author fengyh
 * @since 2020-10-31
 */
@NoArgsConstructor
@Data
public class ShopImgDto {

	private Long imgId;
    /**
     * 图片地址
     */
	private String imgUrl;
    /**
     * 图片类型
     */
	private String imgType;
    /**
     * 图片大小
     */
	private Integer imgSize;
    /**
     * 上传时间
     */
	private Date uploadTime;
    /**
     * 图片关联表类型：1 店铺表
     */
	private Integer linkType;
    /**
     * 图片关联的表主键Id
     */
	private Long linkId;
    /**
     * 1 店铺表(1 主图 2 轮播图 3 详情图 )
     */
	private Integer linkCate;

}
