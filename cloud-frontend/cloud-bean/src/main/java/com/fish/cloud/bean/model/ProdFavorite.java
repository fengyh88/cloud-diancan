package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户喜欢
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Data
@TableName("cloud_prod_favorite")
public class ProdFavorite extends Model<ProdFavorite> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="favorite_id", type= IdType.AUTO)
	private Long favoriteId;
    /**
     * 用户Id
     */
	@TableField("user_id")
	private String userId;
	/**
	 * 店铺Id
	 */
	@TableField("shop_id")
	private String shopId;
    /**
     * 商品Id
     */
	@TableField("prod_id")
	private String prodId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;

	@Override
	protected Serializable pkVal() {
		return this.favoriteId;
	}

}
