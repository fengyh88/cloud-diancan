package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.ShopImg;
import com.fish.cloud.bean.param.ShopImgAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.ShopImgMapper;
import com.fish.cloud.service.IShopImgService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 店铺图
 * </p>
 *
 * @author fengyh
 * @since 2020-10-31
 */
@Slf4j
@Service
public class ShopImgServiceImpl extends ServiceImpl<ShopImgMapper, ShopImg> implements IShopImgService {

    /**
     * 根据店铺Id查询列表
     *
     * @param shopId
     * @return
     */
    @Override
    public List<ShopImg> listByShopId(Long shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ShopImg>()
                .eq(ShopImg::getLinkType, 1)
                .eq(ShopImg::getLinkId, shopId));
        return models;
    }

    @Override
    public TupleRet addOrEdit(ShopImgAddParam shopImgAddParam) {
        var modelDb = baseMapper.selectById(shopImgAddParam.getImgId());
        if (ObjectUtils.isEmpty(modelDb)) {
            //新增
            var model = new ShopImg();
            model.setImgSize(shopImgAddParam.getImgSize());
            model.setImgType(shopImgAddParam.getImgType());
            model.setImgUrl(shopImgAddParam.getImgUrl());
            model.setLinkType(1);
            model.setLinkId(shopImgAddParam.getLinkId());
            model.setLinkCate(shopImgAddParam.getLinkCate());
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
            modelDb.setImgSize(shopImgAddParam.getImgSize());
            modelDb.setImgType(shopImgAddParam.getImgType());
            modelDb.setImgUrl(shopImgAddParam.getImgUrl());
            modelDb.setLinkType(1);
            modelDb.setLinkId(shopImgAddParam.getLinkId());
            modelDb.setLinkCate(shopImgAddParam.getLinkCate());
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
