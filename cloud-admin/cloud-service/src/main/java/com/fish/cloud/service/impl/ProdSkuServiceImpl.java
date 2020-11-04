package com.fish.cloud.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.Prod;
import com.fish.cloud.bean.model.ProdSku;
import com.fish.cloud.bean.param.ProdSkuAddParam;
import com.fish.cloud.bean.param.ProdSkuEditParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.PinyinUtil;
import com.fish.cloud.repo.ProdSkuMapper;
import com.fish.cloud.service.IProdSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 单品SKU
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class ProdSkuServiceImpl extends ServiceImpl<ProdSkuMapper, ProdSku> implements IProdSkuService {

    @Override
    public List<ProdSku> listByProdId(Long prodId) {
        return baseMapper.selectList(new LambdaQueryWrapper<ProdSku>()
                .eq(ProdSku::getProdId, prodId)
                .eq(ProdSku::getStatus, 1));
    }

    @Override
    public String getProdSkuTextByProdId(Long prodId) {
        var models = listByProdId(prodId);
        StringBuilder sb = new StringBuilder();
        for (ProdSku model : models) {
            sb.append(model.getSkuName() + "(" + model.getPrice() + "元)");
        }
        return sb.toString();
    }

    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("商品SKU不存在");
        }

        try {
            model.setStatus(status);
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("更新失败");
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet add(ProdSkuAddParam prodSkuAddParam) {
        Integer count = baseMapper.selectCount(new LambdaQueryWrapper<ProdSku>()
                .eq(ProdSku::getSkuName, prodSkuAddParam.getSkuName())
                .eq(ProdSku::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(ProdSku::getStatus, 1));
        if (count > 0) {
            TupleRet.failed("名称不得重复");
        }

        try {
            var model = new ProdSku();
            BeanUtils.copyProperties(prodSkuAddParam, model);
            model.setShopId(ApiContextHolder.getAuthDto().getShopId());
            model.setVStock(0);
            model.setStock(0); // 默认库存0
            model.setStatus(1);
            model.setCreateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet edit(ProdSkuEditParam prodSkuEditParam) {
        var model = baseMapper.selectById(prodSkuEditParam.getSkuId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("商品SKU不存在");
        }

        Integer count = baseMapper.selectCount(new LambdaQueryWrapper<ProdSku>()
                .eq(ProdSku::getSkuName, prodSkuEditParam.getSkuName())
                .eq(ProdSku::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .ne(ProdSku::getSkuId, prodSkuEditParam.getSkuId())
                .eq(ProdSku::getStatus, 1));
        if (count > 0) {
            return TupleRet.failed("名称不得重复");
        }

        try {
            BeanUtils.copyProperties(model,prodSkuEditParam);
            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }
}
