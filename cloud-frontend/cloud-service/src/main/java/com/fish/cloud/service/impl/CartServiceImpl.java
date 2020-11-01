package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Cart;
import com.fish.cloud.repo.CartMapper;
import com.fish.cloud.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {
	
}
