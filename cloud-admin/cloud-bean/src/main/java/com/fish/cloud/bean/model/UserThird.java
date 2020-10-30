package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@TableName("cloud_user_third")
public class UserThird extends Model<UserThird> {

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

	public UserThird setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	public UserThird setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public Integer getThirdId() {
		return thirdId;
	}

	public UserThird setThirdId(Integer thirdId) {
		this.thirdId = thirdId;
		return this;
	}

	public String getThirdUserId() {
		return thirdUserId;
	}

	public UserThird setThirdUserId(String thirdUserId) {
		this.thirdUserId = thirdUserId;
		return this;
	}

	public String getThirdUnionId() {
		return thirdUnionId;
	}

	public UserThird setThirdUnionId(String thirdUnionId) {
		this.thirdUnionId = thirdUnionId;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public UserThird setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getNickName() {
		return nickName;
	}

	public UserThird setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	public String getImg() {
		return img;
	}

	public UserThird setImg(String img) {
		this.img = img;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
