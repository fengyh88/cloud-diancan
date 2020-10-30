package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.ProdComment;
import com.fish.cloud.repo.ProdCommentMapper;
import com.fish.cloud.service.IProdCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评论
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class ProdCommentServiceImpl extends ServiceImpl<ProdCommentMapper, ProdComment> implements IProdCommentService {
	
}
