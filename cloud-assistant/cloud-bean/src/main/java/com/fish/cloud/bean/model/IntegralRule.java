package com.fish.cloud.bean.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 积分规则
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_integral_rule")
public class IntegralRule extends Model<IntegralRule> {

    private static final long serialVersionUID = 1L;

    /**
     * rule_code
     */
    @TableId("rule_code")
	private String ruleCode;
    /**
     * 店铺id 0表示全局
     */
	@TableField("shop_id")
	private Long shopId;
    /**
     * 1 增加积分 0 减少积分
     */
	@TableField("rule_type")
	private Integer ruleType;
    /**
     * 增/减积分数量
     */
	@TableField("integral_num")
	private Integer integralNum;
    /**
     * 积分规则名称
     */
	@TableField("rule_name")
	private String ruleName;
    /**
     * 描述
     */
	private String des;
    /**
     * 0 禁用 1 启用 -1删除
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


	public String getRuleCode() {
		return ruleCode;
	}

	public IntegralRule setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
		return this;
	}

	public Long getShopId() {
		return shopId;
	}

	public IntegralRule setShopId(Long shopId) {
		this.shopId = shopId;
		return this;
	}

	public Integer getRuleType() {
		return ruleType;
	}

	public IntegralRule setRuleType(Integer ruleType) {
		this.ruleType = ruleType;
		return this;
	}

	public Integer getIntegralNum() {
		return integralNum;
	}

	public IntegralRule setIntegralNum(Integer integralNum) {
		this.integralNum = integralNum;
		return this;
	}

	public String getRuleName() {
		return ruleName;
	}

	public IntegralRule setRuleName(String ruleName) {
		this.ruleName = ruleName;
		return this;
	}

	public String getDes() {
		return des;
	}

	public IntegralRule setDes(String des) {
		this.des = des;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public IntegralRule setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public IntegralRule setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public IntegralRule setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.ruleCode;
	}

}
