package com.fish.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.dto.ShopImgDto;
import com.fish.cloud.bean.model.ShopImg;
import com.fish.cloud.bean.param.ShopImgAddParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.ImgUrlUtil;
import com.fish.cloud.repo.ShopImgMapper;
import com.fish.cloud.service.IShopImgService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

    @Override
    public TupleRet add(ShopImgAddParam shopImgAddParam) {
        var modelDb = baseMapper.selectById(shopImgAddParam.getImgId());
        if (ObjectUtils.isEmpty(modelDb)) {
            //新增
            var model = new ShopImg();
            BeanUtils.copyProperties(shopImgAddParam, model);
            model.setLinkType(1); // 1 店铺表
            model.setLinkId(ApiContextHolder.getAuthDto().getShopId());
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
            BeanUtils.copyProperties(shopImgAddParam, modelDb);
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
