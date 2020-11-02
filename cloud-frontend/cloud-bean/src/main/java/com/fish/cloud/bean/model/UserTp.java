package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 用户第三方信息
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@TableName("cloud_user_tp")
public class UserTp extends Model<UserTp> {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 本系统userId
     */
	@TableField("user_id")
	private String userId;
    /**
     * 第三方系统id 1：微信小程序
     */
	@TableField("third_id")
	private Integer thirdId;
    /**
     * 第三方系统userId
     */
	@TableField("third_user_id")
	private String thirdUserId;
    /**
     * 第三方系统unionId
     */
	@TableField("third_union_id")
	private String thirdUnionId;
    /**
     * 手机号
     */
	private String mobile;
    /**
     * 第三方系统昵称
     */
	@TableField("nick_name")
	private String nickName;
    /**
     * 第三方系统头像
     */
	private String img;


	public Long getId() {
		return id;
	}

	public UserTp setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public UserTp setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Integer getThirdId() {
		return thirdId;
	}

	public UserTp setThirdId(Integer thirdId) {
		this.thirdId = thirdId;
		return this;
	}

	public String getThirdUserId() {
		return thirdUserId;
	}

	public UserTp setThirdUserId(String thirdUserId) {
		this.thirdUserId = thirdUserId;
		return this;
	}

	public String getThirdUnionId() {
		return thirdUnionId;
	}

	public UserTp setThirdUnionId(String thirdUnionId) {
		this.thirdUnionId = thirdUnionId;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public UserTp setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getNickName() {
		return nickName;
	}

	public UserTp setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	public String getImg() {
		return img;
	}

	public UserTp setImg(String img) {
		this.img = img;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
