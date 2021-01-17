package com.fish.cloud.bean.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 * 岗位
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@NoArgsConstructor
@Data
public class DutyDto {

    /**
     * Id
     */
	private Long dutyId;
    /**
     * 名称
     */
	private String dutyName;
    /**
     * 店铺Id
     */
	private Long shopId;
	/**
	 * 状态  0：禁用   1：启用
	 */
	private Integer status;
    /**
     * 建立时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
    /**
     * 更新时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

}
