package com.fish.cloud.bean.param;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * 呼叫表
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public class CallAddParam {

    /**
     * 用户Id
     */
	@TableField("user_id")
	private Long userId;
    /**
     * 台桌Id
     */
	@TableField("table_id")
	private Long tableId;
    /**
     * 公告标题
     */
	private String title;
    /**
     * 公告内容
     */
	private String content;

}
