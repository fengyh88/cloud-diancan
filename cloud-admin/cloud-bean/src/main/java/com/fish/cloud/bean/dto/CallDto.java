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
	 * 用户Id
	 */
	private Long userId;
	/**
	 * 桌号Id
	 */
	private Long tableId;

	private String tableText;

	/**
	 * 公告标题
	 */
	private String title;
	/**
	 * 公告内容
	 */
	private String content;

	private Long empId;

	private String empText;
	/**
	 * 状态(1:呼叫 2:已读 0：过期)
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
	private Date createdTime;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
	private Date updateTime;
}
