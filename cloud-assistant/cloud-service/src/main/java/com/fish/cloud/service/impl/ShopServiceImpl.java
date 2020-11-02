package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.ShopDto;
import com.fish.cloud.bean.model.Shop;
import com.fish.cloud.bean.param.ShopEditParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.repo.ShopMapper;
import com.fish.cloud.service.IShopImgService;
import com.fish.cloud.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Autowired
    private IShopImgService shopImgService;

    /**
     * 详情
     * @return
     */
    @Override
    public TupleRet<ShopDto> detail() {
        try {
            var model = baseMapper.selectOne(new LambdaQueryWrapper<Shop>()
                    .eq(Shop::getShopId, ApiContextHolder.getAuthDto().getShopId())
                    .eq(Shop::getStatus, 1));
            if (ObjectUtils.isEmpty(model)) {
                return TupleRet.failed("未查询到店铺信息");
            }
            // dto
            var dto = new ShopDto();
            BeanUtils.copyProperties(model, dto);
            // 图片
            var imgList = shopImgService.listByShopId(ApiContextHolder.getAuthDto().getShopId());
            dto.setImgList(imgList);
            return TupleRet.success(dto);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed("查询错误");
        }
    }

    /**
     * 编辑
     * @param shopEditParam
     * @return
     */
    @Override
    public TupleRet edit(ShopEditParam shopEditParam) {
        try {
            var model = baseMapper.selectById(ApiContextHolder.getAuthDto().getShopId());
            if (ObjectUtils.isEmpty(model)){
                return TupleRet.failed("未查询到店铺信息");
            }

            //编辑
            model.setShopName(shopEditParam.getShopName());
            model.setShopType(shopEditParam.getShopType());
            model.setIndustry(shopEditParam.getIndustry());
            model.setBrief(shopEditParam.getBrief());
            model.setNotice(shopEditParam.getNotice());
            model.setTel(shopEditParam.getTel());
            model.setAddress(shopEditParam.getAddress());
            model.setLat(shopEditParam.getLat());
            model.setLng(shopEditParam.getLng());
            model.setPcaCode(shopEditParam.getPcaCode());
            model.setPcaName(shopEditParam.getPcaName());
            model.setAddress(shopEditParam.getAddress());
            model.setOpenTime(shopEditParam.getOpenTime());
            model.setCloseTime(shopEditParam.getCloseTime());
            model.setStatus(shopEditParam.getStatus());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }

}
