package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Prod;
import com.fish.cloud.repo.ProdMapper;
import com.fish.cloud.service.IProdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class ProdServiceImpl extends ServiceImpl<ProdMapper, Prod> implements IProdService {
	
}
