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
 * 文章类目
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_article_cate")
public class ArticleCate extends Model<ArticleCate> {

    private static final long serialVersionUID = 1L;

    /**
     * 类目Id
     */
	@TableId(value="cate_id", type= IdType.AUTO)
	private Long cateId;
    /**
     * 店铺ID 0表示全局
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 父节点
     */
	@TableField("p_id")
	private Long pId;
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
	private String pic;
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

	public ArticleCate setCateId(Long cateId) {
		this.cateId = cateId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public ArticleCate setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Long getPId() {
		return pId;
	}

	public ArticleCate setPId(Long pId) {
		this.pId = pId;
		return this;
	}

	public String getCateName() {
		return cateName;
	}

	public ArticleCate setCateName(String cateName) {
		this.cateName = cateName;
		return this;
	}

	public String getIcon() {
		return icon;
	}

	public ArticleCate setIcon(String icon) {
		this.icon = icon;
		return this;
	}

	public String getPic() {
		return pic;
	}

	public ArticleCate setPic(String pic) {
		this.pic = pic;
		return this;
	}

	public Integer getGrade() {
		return grade;
	}

	public ArticleCate setGrade(Integer grade) {
		this.grade = grade;
		return this;
	}

	public Integer getSeq() {
		return seq;
	}

	public ArticleCate setSeq(Integer seq) {
		this.seq = seq;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ArticleCate setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ArticleCate setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public ArticleCate setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.cateId;
	}

}
