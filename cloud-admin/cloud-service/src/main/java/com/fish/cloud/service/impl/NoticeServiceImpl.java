package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Notice;
import com.fish.cloud.repo.NoticeMapper;
import com.fish.cloud.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知公告
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {
	
}
