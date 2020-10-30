package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户喜欢
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
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
     * 商品Id
     */
	@TableField("prod_id")
	private Long prodId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getFavoriteId() {
		return favoriteId;
	}

	public ProdFavorite setFavoriteId(Long favoriteId) {
		this.favoriteId = favoriteId;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public ProdFavorite setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Long getProdId() {
		return prodId;
	}

	public ProdFavorite setProdId(Long prodId) {
		this.prodId = prodId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ProdFavorite setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.favoriteId;
	}

}
