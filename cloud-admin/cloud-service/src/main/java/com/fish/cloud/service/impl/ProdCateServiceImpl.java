package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.ProdCate;
import com.fish.cloud.bean.param.ProdCateAddParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.ProdCateMapper;
import com.fish.cloud.service.IProdCateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class ProdCateServiceImpl extends ServiceImpl<ProdCateMapper, ProdCate> implements IProdCateService {

    @Override
    public List<ProdCate> all() {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ProdCate>()
                .eq(ProdCate::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(ProdCate::getStatus, 1));
        return models;
    }

    @Override
    public TupleRet status(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("品类不存在");
        }

        try {
            model.setStatus(status);
            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet add(ProdCateAddParam prodCateAddParam) {
        try {
            ProdCate model = new ProdCate();
            BeanUtils.copyProperties(prodCateAddParam, model);
            model.setShopId(ApiContextHolder.getAuthDto().getShopId());
            model.setStatus(1);
            model.setCreateTime(DateTimeUtil.getCurrentDateTime());
            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.successMsg("添加成功");
    }

    @Override
    public TupleRet edit(ProdCateAddParam prodCateAddParam) {
        var model =  baseMapper.selectById(prodCateAddParam.getCateId());
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("品类不存在");
        }

        try {
            BeanUtils.copyProperties(prodCateAddParam, model);
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());
            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.successMsg("编辑成功");
    }
}
