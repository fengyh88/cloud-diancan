package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.ProdDetailDto;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Prod;
import com.fish.cloud.bean.param.ProdAddParam;
import com.fish.cloud.bean.param.ProdByCateParam;
import com.fish.cloud.bean.param.ProdEditParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.IdUtil;
import com.fish.cloud.common.util.PinyinUtil;
import com.fish.cloud.common.util.SecurityUtil;
import com.fish.cloud.repo.ProdMapper;
import com.fish.cloud.service.IProdImgService;
import com.fish.cloud.service.IProdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class ProdServiceImpl extends ServiceImpl<ProdMapper, Prod> implements IProdService {


    @Override
    public List<ProdDto> listByCate(String shopId, ProdByCateParam prodByCateParam) {
        var models = baseMapper.listByCate(shopId, prodByCateParam);
        return models;
    }

    @Override
    public ProdDetailDto detail(String id) {
        var model = baseMapper.detail(id);
        return model;
    }

    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("商品不存在");
        }

        try {
            model.setStatus(status);
            //上架状态则写入上架时间
            if (1 == status){
                model.setPutonTime(DateTimeUtil.getCurrentDateTime());
            }
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("更新失败");
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet updateStock(Long id, Integer num) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("商品不存在");
        }

        try {
            model.setStock(model.getStock() + num);
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("更新失败");
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet add(String shopId, String empId, ProdAddParam prodAddParam) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Prod>()
                .eq(Prod::getProdCode, prodAddParam.getProdCode())
                .eq(Prod::getShopId, shopId)
                .ne(Prod::getStatus, -1));
        if (count > 0) {
            TupleRet.failed("编码不得重复");
        }

        try {
            var model = new Prod();
            model.setProdId(IdUtil.getLongIdByUUId());
            model.setProdCode(prodAddParam.getProdCode());
            model.setProdName(prodAddParam.getProdName());
            model.setPinyin(PinyinUtil.getPinyin(model.getProdName()));
            model.setShopId(shopId);
            model.setCateId(prodAddParam.getCateId());
            model.setBrandId(prodAddParam.getBrandId());
            model.setOriPrice(prodAddParam.getOriPrice());
            model.setPrice(prodAddParam.getPrice());
            model.setMemPrice(prodAddParam.getMemPrice());
            model.setUnitId(prodAddParam.getUnitId());
            model.setBrief(prodAddParam.getBrief());
            model.setContent(prodAddParam.getContent());
            model.setStock(0); // 默认库存0
            model.setStatus(1);
            model.setImg(prodAddParam.getImg());
            model.setCreateTime(DateTimeUtil.getCurrentDateTime());
            model.setPutonTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet edit(String shopId, String empId, ProdEditParam prodEditParam) {
        var model = baseMapper.selectById(prodEditParam.getProdId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("商品不存在");
        }

        var count = baseMapper.selectCount(new LambdaQueryWrapper<Prod>()
                .eq(Prod::getProdCode, prodEditParam.getProdCode())
                .eq(Prod::getShopId, shopId)
                .ne(Prod::getProdId, prodEditParam.getProdId())
                .ne(Prod::getStatus, -1));
        if (count > 0) {
            return TupleRet.failed("编码不得重复");
        }

        try {
            model.setProdCode(prodEditParam.getProdCode());
            model.setProdName(prodEditParam.getProdName());
            model.setPinyin(PinyinUtil.getPinyin(model.getProdName()));
            model.setShopId(shopId);
            model.setCateId(prodEditParam.getCateId());
            model.setBrandId(prodEditParam.getBrandId());
            model.setOriPrice(prodEditParam.getOriPrice());
            model.setPrice(prodEditParam.getPrice());
            model.setMemPrice(prodEditParam.getMemPrice());
            model.setUnitId(prodEditParam.getUnitId());
            model.setBrief(prodEditParam.getBrief());
            model.setContent(prodEditParam.getContent());
            model.setImg(prodEditParam.getImg());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }

}
