package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.ProdImg;
import com.fish.cloud.bean.param.ProdImgAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.ProdImgMapper;
import com.fish.cloud.service.IProdImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 商品图
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class ProdImgServiceImpl extends ServiceImpl<ProdImgMapper, ProdImg> implements IProdImgService {

    /**
     * 根据商品Id获取商品图片列表
     * @param prodId
     * @return
     */
    @Override
    public List<ProdImg> listByProdId(String prodId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ProdImg>()
                .eq(ProdImg::getImgType, 1)
                .eq(ProdImg::getLinkId, prodId));
        return models;
    }

    @Override
    public List<ProdImg> listBySkuId(String skuId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ProdImg>()
                .eq(ProdImg::getImgType, 2)
                .eq(ProdImg::getLinkId, skuId));
        return models;
    }

    @Override
    public TupleRet addOrEdit(ProdImgAddParam prodImgAddParam) {
        var modelDb = baseMapper.selectById(prodImgAddParam.getImgId());
        if (ObjectUtils.isEmpty(modelDb)) {
            //新增
            var model = new ProdImg();
            model.setImgSize(prodImgAddParam.getImgSize());
            model.setImgType(prodImgAddParam.getImgType());
            model.setImgUrl(prodImgAddParam.getImgUrl());
            model.setLinkType(prodImgAddParam.getLinkType());
            model.setLinkId(prodImgAddParam.getLinkId());
            model.setLinkCate(prodImgAddParam.getLinkCate());
            model.setUploadTime(DateTimeUtil.getCurrentDateTime());

            try {
                baseMapper.insert(model);
                return TupleRet.success(model.getImgId());
            } catch (Exception ex) {
                log.error(ex.getMessage());
                return TupleRet.failed(ex.getMessage());
            }
        } else {
            //编辑
            modelDb.setImgSize(prodImgAddParam.getImgSize());
            modelDb.setImgType(prodImgAddParam.getImgType());
            modelDb.setImgUrl(prodImgAddParam.getImgUrl());
            modelDb.setLinkType(prodImgAddParam.getLinkType());
            modelDb.setLinkId(prodImgAddParam.getLinkId());
            modelDb.setLinkCate(prodImgAddParam.getLinkCate());
            modelDb.setUploadTime(DateTimeUtil.getCurrentDateTime());

            try {
                baseMapper.updateById(modelDb);
                return TupleRet.success(modelDb.getImgId());
            } catch (Exception ex) {
                log.error(ex.getMessage());
                return TupleRet.failed(ex.getMessage());
            }
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public TupleRet delete(Long id) {
        try {
            baseMapper.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("删除失败");
        }
        return TupleRet.success();
    }
}
