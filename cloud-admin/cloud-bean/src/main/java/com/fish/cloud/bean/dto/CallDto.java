package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 * 呼叫
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
public class CallDto {
    /**
     * Id
     */
	private Long id;
    /**
     * 店铺Id
     */
	private Long shopId;
    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 桌号Id
     */
	private Long resId;
    /**
     * 公告标题
     */
	private String title;
    /**
     * 公告内容
     */
	private String content;
    /**
     * 状态(1:呼叫 2:已读)
     */
	private Integer status;
    /**
     * 已读员工Id
     */
	private Long empId;
    /**
     * 创建时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
}
