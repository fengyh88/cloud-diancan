package com.fish.cloud.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.CartDto;
import com.fish.cloud.bean.model.Cart;
import com.fish.cloud.bean.param.CartAddParam;
import com.fish.cloud.bean.param.CartEditParam;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.repo.CartMapper;
import com.fish.cloud.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    /**
     * 全部
     * @param shopId
     * @param userId
     * @return
     */
    @Override
    public List<CartDto> all(String shopId, String userId) {
        var models = baseMapper.all(shopId,userId);
        return models;
    }

    @Override
    public List<CartDto> listByCartIds(List<String> cartIds) {
        return baseMapper.listByCartIds(cartIds);
    }


    /**
     * 统计购物车中商品数量
     * @param shopId
     * @param userId
     * @return
     */
    @Override
    public Integer countProd(String shopId, String userId) {
        Integer count = baseMapper.selectCount(new LambdaQueryWrapper<Cart>()
                .eq(Cart::getUserId, userId)
                .eq(StrUtil.isNotEmpty(shopId) && shopId != "0", Cart::getShopId, shopId));
        return count;
    }

    /**
     * 添加
     * @param shopId
     * @param userId
     * @param cartAddParam
     * @return
     */
    @Override
    public TupleRet<String> add(String shopId, String userId, CartAddParam cartAddParam) {
        var existModel = baseMapper.selectOne(new LambdaQueryWrapper<Cart>()
                .eq(Cart::getUserId, userId)
                .eq(Cart::getShopId, shopId)
                .eq(Cart::getProdId, cartAddParam.getProdId())
                .eq(Cart::getSkuId, cartAddParam.getSkuId()));
        //如果已经加入过购物车，则增减商品数量
        if (!ObjectUtils.isEmpty(existModel)) {
            existModel.setNum(existModel.getNum() + cartAddParam.getNum());
            try {
                baseMapper.updateById(existModel);
                return TupleRet.success(existModel.getCartId().toString());
            } catch (Exception e) {
                log.error(e.getMessage());
                return TupleRet.failed("操作失败，请稍后重试");
            }
        }

        // 添加
        var model = new Cart();
        model.setShopId(shopId);
        model.setUserId(userId);
        model.setProdId(cartAddParam.getProdId());
        model.setSkuId(cartAddParam.getSkuId());
        model.setNum(cartAddParam.getNum());
        model.setCartTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.insert(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("操作失败，请稍后重试");
        }

        return TupleRet.success(model.getCartId().toString());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public TupleRet delete(String id) {
        var existModel = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(existModel)) {
            return TupleRet.failed("购物车不存在此商品");
        }

        try {
            baseMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("删除失败");
        }

        return TupleRet.success();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public TupleRet batchDelete(List<Long> ids) {
        try {
           baseMapper.deleteBatchIds(ids);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("删除失败");
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet clear(String shopId, String userId) {
        try {
            baseMapper.delete(new LambdaQueryWrapper<Cart>()
                    .eq(Cart::getUserId, userId)
                    .eq(Cart::getShopId, shopId));
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("清空失败");
        }

        return TupleRet.success();
    }


    /**
     * 编辑
     * @param cartEditParam
     * @return
     */
    @Override
    public TupleRet edit(CartEditParam cartEditParam) {
        var existModel = baseMapper.selectById(cartEditParam.getCartId());
        if (ObjectUtils.isEmpty(existModel)) {
            return TupleRet.failed("购物车不存在此商品");
        }
        existModel.setNum(cartEditParam.getNum());

        try {
            baseMapper.updateById(existModel);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("编辑失败");
        }

        return TupleRet.success();
    }

    /**
     * 清空某个用户购物车数据
     * @param userId
     * @param shopId
     * @return
     */
    @Override
    public TupleRet clearByUserIdAndShopId(String userId, String shopId) {
        try {
            baseMapper.delete(new LambdaQueryWrapper<Cart>()
                    .eq(Cart::getUserId, userId)
                    .eq(Cart::getShopId, shopId));
        } catch (Exception ex){
            log.error(ex.getMessage());
            return TupleRet.failed("清空购物车数据失败");
        }

         return TupleRet.success();
    }

}
