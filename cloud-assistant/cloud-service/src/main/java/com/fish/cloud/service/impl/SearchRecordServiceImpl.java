package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.SearchRecord;
import com.fish.cloud.repo.SearchRecordMapper;
import com.fish.cloud.service.ISearchRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 搜索记录
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class SearchRecordServiceImpl extends ServiceImpl<SearchRecordMapper, SearchRecord> implements ISearchRecordService {
	
}
