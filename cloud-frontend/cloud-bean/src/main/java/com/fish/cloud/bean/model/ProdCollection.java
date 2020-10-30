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
 * 用户收藏
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Data
@TableName("cloud_prod_collection")
public class ProdCollection extends Model<ProdCollection> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="collection_id", type= IdType.AUTO)
	private Long collectionId;
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
     * 收藏时间
     */
	@TableField("create_time")
	private Date createTime;

	@Override
	protected Serializable pkVal() {
		return this.collectionId;
	}

}
