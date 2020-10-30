package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.ProdCollectionDto;
import com.fish.cloud.bean.dto.ProdFavoriteDto;
import com.fish.cloud.bean.model.ProdCollection;
import com.fish.cloud.bean.model.ProdFavorite;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.ProdCollectionMapper;
import com.fish.cloud.service.IProdCollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 用户收藏
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class ProdCollectionServiceImpl extends ServiceImpl<ProdCollectionMapper, ProdCollection> implements IProdCollectionService {

    @Override
    public List<ProdCollectionDto> all(String userId, String shopId) {
        return baseMapper.all(shopId, userId);
    }

    @Override
    public TupleRet add(String userId, String prodId, String shopId) {
        var model = new ProdCollection();
        model.setUserId(userId);
        model.setProdId(prodId);
        model.setShopId(shopId);
        model.setCreateTime(DateTimeUtil.getCurrentDateTime());
        try {
            baseMapper.insert(model);
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            return TupleRet.failed("添加失败");
        }
        return TupleRet.success();
    }

    @Override
    public TupleRet delete(String collectionId) {
        var model = baseMapper.selectById(collectionId);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("不存在");
        }
        baseMapper.deleteById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet cancel(String userId, String prodId) {
        baseMapper.delete(new LambdaQueryWrapper<ProdCollection>()
                .eq(ProdCollection::getUserId, userId)
                .eq(ProdCollection::getProdId, prodId));
        return TupleRet.success();
    }
}
