package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Shop;
import com.fish.cloud.bean.param.ShopAddParam;
import com.fish.cloud.common.util.IdUtil;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.repo.ShopMapper;
import com.fish.cloud.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Override
    public TupleRet detail(Long id) {
        try {
            Shop model = baseMapper.selectById(id);
            if (null == model) {
                return TupleRet.failed("未查询到店铺信息");
            }

//            //wifi信息
//            List<StoreWifiModel> storeWifiModels = storeWifiService.getSoreWifiModelsByStoreId(id);
//            storeRes.setStoreWifis(storeWifiModels);
//
//            //pic信息
//            List<StorePicModel> storePicModels = storePicService.getListByStoreId(id);
//            storeRes.setStorePics(storePicModels);
//
//            //客服信息
//            List<StoreCsModel> storeCsModels = storeCsService.getStoreCsModelsByStoreId(id);
//            storeRes.setStoreCsList(storeCsModels);

            return TupleRet.success(model);
        } catch (Exception ex) {
            // logger.error(ex.getStackTrace());
            TupleRet.failed(ex.getStackTrace().toString());
        }

        return TupleRet.failed("查询数据错误");
    }

    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (null == model){
            return TupleRet.failed("商家不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet addOrEdit(ShopAddParam shopAddParam) {
        try {
            Shop existModel = baseMapper.selectById(shopAddParam.getShopId());
            if (null == existModel) {
                //新增
                Shop model = new Shop();
                model.setShopId(Long.valueOf(IdUtil.getIdByUUId()));
                model.setShopName(shopAddParam.getShopName());
                model.setBrief(shopAddParam.getBrief());
                model.setAddress(shopAddParam.getAddress());
                model.setLat(shopAddParam.getLat());
                model.setLng(shopAddParam.getLng());
                model.setStatus(1);

                baseMapper.insert(model);
            }
            //编辑
            existModel.setShopName(shopAddParam.getShopName());
            existModel.setBrief(shopAddParam.getBrief());
            existModel.setAddress(shopAddParam.getAddress());
            existModel.setLat(shopAddParam.getLat());
            existModel.setLng(shopAddParam.getLng());
            existModel.setStatus(1);

            baseMapper.updateById(existModel);
        } catch (Exception ex) {
            //logger.error(ex.getStackTrace());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public Shop getByCode(String code) {
        return null;
    }

    @Override
    public TupleRet generateCode() {
        String codeUUID = IdUtil.getIdByUUId();
        return TupleRet.success(codeUUID);
    }
}
