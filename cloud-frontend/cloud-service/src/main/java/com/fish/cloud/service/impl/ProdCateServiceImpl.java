package com.fish.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.dto.ProdCateDto;
import com.fish.cloud.bean.model.ProdCate;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.repo.ProdCateMapper;
import com.fish.cloud.service.IProdCateService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<ProdCateDto> all() {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ProdCate>()
                .eq(ProdCate::getShopId, ApiContextHolder.getShopId())
                .eq(ProdCate::getStatus, 1));
        List<ProdCateDto> dtoList = models.stream().map(model->{
            ProdCateDto dto = new ProdCateDto();
            BeanUtil.copyProperties(model,dto);
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }
}
