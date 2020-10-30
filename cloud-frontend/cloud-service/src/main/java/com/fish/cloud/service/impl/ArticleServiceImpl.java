package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Article;
import com.fish.cloud.repo.ArticleMapper;
import com.fish.cloud.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
	
}
