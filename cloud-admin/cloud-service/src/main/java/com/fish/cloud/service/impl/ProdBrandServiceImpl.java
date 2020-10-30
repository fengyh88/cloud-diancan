package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fish.cloud.bean.model.ProdBrand;
import com.fish.cloud.bean.param.ProdBrandAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.CommonStrUtil;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.PinyinUtil;
import com.fish.cloud.repo.ProdBrandMapper;
import com.fish.cloud.service.IProdBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class ProdBrandServiceImpl extends ServiceImpl<ProdBrandMapper, ProdBrand> implements IProdBrandService {

    @Override
    public List<ProdBrand> all(String shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ProdBrand>()
                .eq(ProdBrand::getShopId, shopId)
                .ne(ProdBrand::getStatus, -1));
        return models;
    }

    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("品牌不存在");
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
    public TupleRet add(String shopId, ProdBrandAddParam prodBrandAddParam) {
        try {
            var model = new ProdBrand();
            model.setShopId(shopId);
            model.setBrandName(prodBrandAddParam.getBrandName());
            model.setLogo(prodBrandAddParam.getLogo());
            model.setImg(prodBrandAddParam.getImg());
            model.setFirstChar(CommonStrUtil.firstCharUpper(PinyinUtil.getPinyin(prodBrandAddParam.getBrandName())));
            model.setBrief(prodBrandAddParam.getBrief());
            model.setContent(prodBrandAddParam.getContent());
            model.setRemark(prodBrandAddParam.getRemark());
            model.setSeq(prodBrandAddParam.getSeq());
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
    public TupleRet edit(String shopId, ProdBrandAddParam prodBrandAddParam) {
        var model = baseMapper.selectById(prodBrandAddParam.getBrandId());
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("品牌不存在");
        }

        try {
            model.setShopId(shopId);
            model.setBrandName(prodBrandAddParam.getBrandName());
            model.setLogo(prodBrandAddParam.getLogo());
            model.setImg(prodBrandAddParam.getImg());
            model.setFirstChar(CommonStrUtil.firstCharUpper(PinyinUtil.getPinyin(prodBrandAddParam.getBrandName())));
            model.setBrief(prodBrandAddParam.getBrief());
            model.setContent(prodBrandAddParam.getContent());
            model.setRemark(prodBrandAddParam.getRemark());
            model.setSeq(prodBrandAddParam.getSeq());
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());
            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

}
