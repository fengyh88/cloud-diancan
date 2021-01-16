package com.fish.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.dto.ShopImgDto;
import com.fish.cloud.bean.model.ShopImg;
import com.fish.cloud.common.util.ImgUrlUtil;
import com.fish.cloud.repo.ShopImgMapper;
import com.fish.cloud.service.IShopImgService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<ShopImgDto> listByShopId(Long shopId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ShopImg>()
                .eq(ShopImg::getLinkType, 1)
                .eq(ShopImg::getLinkId, shopId));
        List<ShopImgDto> dtoList = models.stream().map(model -> {
            ShopImgDto dto = new ShopImgDto();
            BeanUtil.copyProperties(model,dto);
            dto.setImgUrl(ImgUrlUtil.getFullPathImgUrl(dto.getImgUrl()));
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }
}
