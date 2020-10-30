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
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_prod_cate")
public class ProdCate extends Model<ProdCate> {

    private static final long serialVersionUID = 1L;

    /**
     * 类目Id
     */
	@TableId(value="cate_id", type= IdType.AUTO)
	private Long cateId;
    /**
     * 店铺Id
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 类目名称
     */
	@TableField("cate_name")
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
	@TableField("p_id")
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
     * 默认是1，表示正常状态,0为下线状态
     */
	private Integer status;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;


	public Long getCateId() {
		return cateId;
	}

	public ProdCate setCateId(Long cateId) {
		this.cateId = cateId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public ProdCate setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public String getCateName() {
		return cateName;
	}

	public ProdCate setCateName(String cateName) {
		this.cateName = cateName;
		return this;
	}

	public String getIcon() {
		return icon;
	}

	public ProdCate setIcon(String icon) {
		this.icon = icon;
		return this;
	}

	public String getImg() {
		return img;
	}

	public ProdCate setImg(String img) {
		this.img = img;
		return this;
	}

	public Long getPId() {
		return pId;
	}

	public ProdCate setPId(Long pId) {
		this.pId = pId;
		return this;
	}

	public Integer getGrade() {
		return grade;
	}

	public ProdCate setGrade(Integer grade) {
		this.grade = grade;
		return this;
	}

	public Integer getSeq() {
		return seq;
	}

	public ProdCate setSeq(Integer seq) {
		this.seq = seq;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ProdCate setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ProdCate setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public ProdCate setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.cateId;
	}

}
