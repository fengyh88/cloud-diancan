package com.fish.cloud.bean.param;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 呼叫表
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Data
@NoArgsConstructor
public class CallAddParam {

    /**
     * 用户Id
     */
	private Long userId;
    /**
     * 台桌Id
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

}
