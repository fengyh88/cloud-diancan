package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
public class ProdCateDto {

    /**
     * 类目Id
     */
	private Long cateId;
    /**
     * 类目名称
     */
	private String cateName;
    /**
     * 类目图标
     */
	private String icon;
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
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
    /**
     * 更新时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

}
