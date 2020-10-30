package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 会员等级
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_mem_grade")
public class MemGrade extends Model<MemGrade> {

    private static final long serialVersionUID = 1L;

    /**
     * grade_Id
     */
	@TableId(value="grade_id", type= IdType.AUTO)
	private Long gradeId;
    /**
     * 店铺ID 0为全局
     */
	@TableField("shop_id")
	private Long shopId;
	private Integer grade;
    /**
     * 等级名称
     */
	@TableField("grade_name")
	private String gradeName;
    /**
     * 图片
     */
	private String img;
    /**
     * 简要描述
     */
	private String brief;
    /**
     * 会员完成订单金额满足则升级
     */
	private BigDecimal money;
    /**
     * 折扣
     */
	private BigDecimal discount;
    /**
     * 状态 0禁用 1启用 -1删除
     */
	private Integer status;
    /**
     * 建立时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getGradeId() {
		return gradeId;
	}

	public MemGrade setGradeId(Long gradeId) {
		this.gradeId = gradeId;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public MemGrade setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Integer getGrade() {
		return grade;
	}

	public MemGrade setGrade(Integer grade) {
		this.grade = grade;
		return this;
	}

	public String getGradeName() {
		return gradeName;
	}

	public MemGrade setGradeName(String gradeName) {
		this.gradeName = gradeName;
		return this;
	}

	public String getImg() {
		return img;
	}

	public MemGrade setImg(String img) {
		this.img = img;
		return this;
	}

	public String getBrief() {
		return brief;
	}

	public MemGrade setBrief(String brief) {
		this.brief = brief;
		return this;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public MemGrade setMoney(BigDecimal money) {
		this.money = money;
		return this;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public MemGrade setDiscount(BigDecimal discount) {
		this.discount = discount;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public MemGrade setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public MemGrade setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.gradeId;
	}

}
