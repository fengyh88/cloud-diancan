package com.fish.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.ProdImgDto;
import com.fish.cloud.bean.dto.ShopImgDto;
import com.fish.cloud.bean.model.ProdImg;
import com.fish.cloud.bean.param.ProdImgAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.ImgUrlUtil;
import com.fish.cloud.repo.ProdImgMapper;
import com.fish.cloud.service.IProdImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<ProdImgDto> listByProdId(Long prodId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ProdImg>()
                .eq(ProdImg::getLinkType, 1)
                .eq(ProdImg::getLinkId, prodId));
        List<ProdImgDto> dtoList = models.stream().map(model -> {
            var dto = new ProdImgDto();
            BeanUtil.copyProperties(model, dto);
            dto.setImgUrl(ImgUrlUtil.getFullPathImgUrl(dto.getImgUrl()));
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public ProdImgDto getMainImgByProdId(Long prodId) {
        var model = baseMapper.selectOne(new LambdaQueryWrapper<ProdImg>()
                .eq(ProdImg::getLinkType, 1)
                .eq(ProdImg::getLinkId, prodId)
                .eq(ProdImg::getLinkCate, 1));
        var dto = new ProdImgDto();
        BeanUtil.copyProperties(model, dto);
        dto.setImgUrl(ImgUrlUtil.getFullPathImgUrl(dto.getImgUrl()));
        return dto;
    }


    @Override
    public List<ProdImgDto> listBySkuId(Long skuId) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<ProdImg>()
                .eq(ProdImg::getLinkType, 2)
                .eq(ProdImg::getLinkId, skuId));
        List<ProdImgDto> dtoList = models.stream().map(model -> {
            var dto = new ProdImgDto();
            BeanUtil.copyProperties(model, dto);
            dto.setImgUrl(ImgUrlUtil.getFullPathImgUrl(dto.getImgUrl()));
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public ProdImgDto getMainImgBySkuId(Long skuId) {
        var model = baseMapper.selectOne(new LambdaQueryWrapper<ProdImg>()
                .eq(ProdImg::getLinkType, 2)
                .eq(ProdImg::getLinkId, skuId)
                .eq(ProdImg::getLinkCate, 1));
        var dto = new ProdImgDto();
        BeanUtil.copyProperties(model, dto);
        dto.setImgUrl(ImgUrlUtil.getFullPathImgUrl(dto.getImgUrl()));
        return dto;
    }

    @Override
    public TupleRet addOrEdit(ProdImgAddParam prodImgAddParam) {
        var modelDb = baseMapper.selectById(prodImgAddParam.getImgId());
        if (ObjectUtils.isEmpty(modelDb)) {
            // 添加
            var model = new ProdImg();
            BeanUtil.copyProperties(prodImgAddParam, model);
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
            BeanUtil.copyProperties(prodImgAddParam, modelDb);
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
