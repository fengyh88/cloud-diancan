package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.SearchHot;
import com.fish.cloud.repo.SearchHotMapper;
import com.fish.cloud.service.ISearchHotService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 热搜
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class SearchHotServiceImpl extends ServiceImpl<SearchHotMapper, SearchHot> implements ISearchHotService {
	
}
