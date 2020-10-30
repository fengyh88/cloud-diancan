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
 * 用户收藏
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
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
     * 商品Id
     */
	@TableField("prod_id")
	private Long prodId;
    /**
     * 收藏时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getCollectionId() {
		return collectionId;
	}

	public ProdCollection setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public ProdCollection setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Long getProdId() {
		return prodId;
	}

	public ProdCollection setProdId(Long prodId) {
		this.prodId = prodId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ProdCollection setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.collectionId;
	}

}
