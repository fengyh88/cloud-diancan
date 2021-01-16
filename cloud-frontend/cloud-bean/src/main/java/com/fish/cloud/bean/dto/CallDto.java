package com.fish.cloud.bean.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 呼叫表
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
public class CallDto {
    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 桌号Id
     */
	private Long tableId;
    /**
     * 公告标题
     */
	private String title;
    /**
     * 公告内容
     */
	private String content;
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

}
