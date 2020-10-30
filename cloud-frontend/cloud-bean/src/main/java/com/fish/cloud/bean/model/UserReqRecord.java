package com.fish.cloud.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 用户请求记录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Data
@TableName("cloud_user_req_record")
public class UserReqRecord extends Model<UserReqRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户Id
     */
	@TableField("user_id")
	private String userId;
    /**
     * 用户名
     */
	@TableField("user_name")
	private String userName;
    /**
     * IP地址
     */
	private String ip;
    /**
     * 用户操作
     */
	private String oper;
    /**
     * 请求方法
     */
	private String method;
    /**
     * 请求参数
     */
	private String params;
    /**
     * 执行时长(毫秒)
     */
	private Long time;
    /**
     * 创建时间
     */
	@TableField("create_time")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
