package com.fish.cloud.service.impl;

import com.fish.cloud.bean.dto.ShopDto;
import com.fish.cloud.bean.model.Shop;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.repo.ShopMapper;
import com.fish.cloud.service.IShopImgService;
import com.fish.cloud.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Autowired
    private IShopImgService shopImgService;

    /**
     * 详情
     * @param id
     * @return
     */
    @Override
    public TupleRet<ShopDto> detail(String id) {
        try {
            var model = baseMapper.detail(id);
            if (ObjectUtils.isEmpty(model)) {
                return TupleRet.failed("未查询到店铺信息");
            }

            //图片信息
            var shopImgs = shopImgService.listByShopId(id);
            model.setImgs(shopImgs);
            return TupleRet.success(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed("查询错误");
        }
    }
}
