package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.Cart;
import com.fish.cloud.bean.param.CartAddParam;
import com.fish.cloud.bean.param.CartEditParam;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.SecurityUtil;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.repo.CartMapper;
import com.fish.cloud.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    @Override
    public TupleRet<List<Cart>> all() {
        List<Cart> carts = baseMapper.selectList(new LambdaQueryWrapper<Cart>()
                .eq(Cart::getUserId, SecurityUtil.getAdmin().getEmpId())
                .eq(Cart::getShopId, SecurityUtil.getAdmin().getShopId()));
        return TupleRet.success(carts);
    }

    @Override
    public TupleRet<Integer> countGoods() {
        Integer count = baseMapper.selectCount(new LambdaQueryWrapper<Cart>()
                .eq(Cart::getUserId, SecurityUtil.getAdmin().getEmpId())
                .eq(Cart::getShopId, SecurityUtil.getAdmin().getShopId()));
        return TupleRet.success(count);
    }

    @Override
    public TupleRet add(CartAddParam cartAddParam) {
        Cart existModel = baseMapper.selectOne(new LambdaQueryWrapper<Cart>()
                .eq(Cart::getUserId, SecurityUtil.getAdmin().getEmpId())
                .eq(Cart::getShopId, SecurityUtil.getAdmin().getShopId())
                .eq(Cart::getProdId, cartAddParam.getProdId()));
        //如果已经加入过购物车，则商品数量
        if (null != existModel) {
            existModel.setNum(existModel.getNum() + cartAddParam.getNum());
            try {
                baseMapper.updateById(existModel);
                return TupleRet.success("添加成功");
            } catch (Exception e) {
                //logger.error(e.getStackTrace());
                return TupleRet.failed("操作失败，请稍后重试");
            }
        }

        Cart model = new Cart();
        model.setShopId(SecurityUtil.getAdmin().getShopId());
        model.setUserId(SecurityUtil.getAdmin().getEmpId());
        model.setProdId(cartAddParam.getProdId());
        model.setNum(cartAddParam.getNum());
        model.setCartTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.insert(model);
        } catch (Exception e) {
            // logger.error(e.getStackTrace());
            return TupleRet.failed("操作失败，请稍后重试");
        }

        return TupleRet.success("添加成功");
    }

    @Override
    public TupleRet delete(Long id) {
        Cart existModel = baseMapper.selectById(id);
        if (null == existModel) {
            return TupleRet.failed("购物车不存在此商品");
        }

        try {
            baseMapper.deleteById(id);
        } catch (Exception e) {
            //logger.error(e.getMessage());
            return TupleRet.failed("删除失败");
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet batchDelete(List<Long> ids) {
        try {
            baseMapper.deleteBatchIds(ids);
        } catch (Exception e) {
            //logger.error(e.getMessage());
            return TupleRet.failed("删除失败");
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet edit(CartEditParam cartEditParam) {
        Cart existModel = baseMapper.selectById(cartEditParam.getCartId());
        if (null == existModel) {
            return TupleRet.failed("购物车不存在此商品");
        }
        existModel.setNum(cartEditParam.getNum());

        try {
            baseMapper.updateById(existModel);
        } catch (Exception e) {
            //logger.error(e.getMessage());
            return TupleRet.failed("编辑失败");
        }

        return TupleRet.success();
    }
}
