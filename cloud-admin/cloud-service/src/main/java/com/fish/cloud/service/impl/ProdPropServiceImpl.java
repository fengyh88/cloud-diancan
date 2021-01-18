package com.fish.cloud.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.ProdProp;
import com.fish.cloud.bean.model.ProdProp;
import com.fish.cloud.bean.param.ProdPropAddParam;
import com.fish.cloud.bean.param.ProdPropEditParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.ProdPropMapper;
import com.fish.cloud.service.IProdPropService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 商品属性
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class ProdPropServiceImpl extends ServiceImpl<ProdPropMapper, ProdProp> implements IProdPropService {

    @Override
    public List<ProdProp> listByProdId(Long prodId) {
        return baseMapper.selectList(new LambdaQueryWrapper<ProdProp>()
                .eq(ProdProp::getProdId, prodId)
                .eq(ProdProp::getStatus, 1));
    }

    @Override
    public String getProdPropTextByProdId(Long prodId) {
        var models = listByProdId(prodId);
        StringBuilder sb = new StringBuilder();
        for (ProdProp model : models) {
            sb.append(model.getPropName() + "(" + model.getPropValue() + ");");
        }
        String text = StrUtil.removeSuffix(sb.toString(), ";");
        return text;
    }

    @Override
    public TupleRet status(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("商品属性不存在");
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
    public TupleRet add(ProdPropAddParam prodPropAddParam) {
        try {
            var model = new ProdProp();
            BeanUtils.copyProperties(prodPropAddParam, model);
            model.setShopId(ApiContextHolder.getAuthDto().getShopId());
            model.setStatus(1);

            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet edit(ProdPropEditParam prodPropEditParam) {
        var model = baseMapper.selectById(prodPropEditParam.getPropId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("商品属性不存在");
        }

        try {
            BeanUtils.copyProperties(model,prodPropEditParam);
            model.setStatus(1);
            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }
}
