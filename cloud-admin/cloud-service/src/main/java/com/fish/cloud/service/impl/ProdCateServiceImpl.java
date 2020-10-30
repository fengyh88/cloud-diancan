package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.ProdCate;
import com.fish.cloud.bean.param.ProdCateAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.ProdCateMapper;
import com.fish.cloud.service.IProdCateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class ProdCateServiceImpl extends ServiceImpl<ProdCateMapper, ProdCate> implements IProdCateService {

    @Override
    public List<ProdCate> all(String shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ProdCate>()
                .eq(ProdCate::getShopId, shopId)
                .ne(ProdCate::getStatus, -1));
        return models;
    }

    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("类目不存在");
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
    public TupleRet add(String shopId, ProdCateAddParam prodCateAddParam) {
        try {
            var model = new ProdCate();
            model.setShopId(shopId);
            model.setCateName(prodCateAddParam.getCateName());
            model.setIcon(prodCateAddParam.getIcon());
            model.setImg(prodCateAddParam.getImg());
            model.setPId(prodCateAddParam.getPId());
            model.setGrade(prodCateAddParam.getGrade());
            model.setSeq(prodCateAddParam.getSeq());
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
    public TupleRet edit(String shopId, ProdCateAddParam prodCateAddParam) {
        var model =  baseMapper.selectById(prodCateAddParam.getId());
        if (ObjectUtils.isEmpty(model)){
           return TupleRet.failed("类目不存在");
        }

        try {
            model.setShopId(shopId);
            model.setCateName(prodCateAddParam.getCateName());
            model.setIcon(prodCateAddParam.getIcon());
            model.setImg(prodCateAddParam.getImg());
            model.setPId(prodCateAddParam.getPId());
            model.setGrade(prodCateAddParam.getGrade());
            model.setSeq(prodCateAddParam.getSeq());
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());
            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

}
