package com.fish.cloud.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.ProdDto;
import com.fish.cloud.bean.model.Prod;
import com.fish.cloud.bean.model.ProdProp;
import com.fish.cloud.bean.model.ProdSku;
import com.fish.cloud.bean.param.ProdAddParam;
import com.fish.cloud.bean.param.ProdByCateParam;
import com.fish.cloud.bean.param.ProdEditParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.PinyinUtil;
import com.fish.cloud.repo.ProdMapper;
import com.fish.cloud.service.IProdPropService;
import com.fish.cloud.service.IProdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.service.IProdSkuService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class ProdServiceImpl extends ServiceImpl<ProdMapper, Prod> implements IProdService {

    @Autowired
    private IProdSkuService prodSkuService;
    @Autowired
    private IProdPropService prodPropService;

    @Override
    public IPage<ProdDto> pageByCate(Integer pageNo, Integer pageSize, ProdByCateParam prodByCateParam){
        // 分页
        var models = baseMapper.selectPage(new Page<Prod>(pageNo, pageSize), new LambdaQueryWrapper<Prod>()
                .eq(Prod::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .and(wrapper -> wrapper.like(StrUtil.isNotEmpty(prodByCateParam.getKeyword()), Prod::getProdCode, prodByCateParam.getKeyword())
                        .or()
                        .like(StrUtil.isNotEmpty(prodByCateParam.getKeyword()), Prod::getProdName, prodByCateParam.getKeyword())
                        .or()
                        .like(StrUtil.isNotEmpty(prodByCateParam.getKeyword()), Prod::getPinyin, prodByCateParam.getKeyword()))
                .eq(Prod::getStatus, 1)
                .orderByDesc(Prod::getPutonTime));

        // dto
        IPage<ProdDto> dtoList = models.convert(model -> Convert.convert(ProdDto.class, model));

        // 设置列表
         dtoList.getRecords().stream().forEach(dto -> {
             // 规格
             List<ProdSku> prodSkuList =  prodSkuService.listByProdId(dto.getProdId());
             dto.setProdSkuList(prodSkuList);
             // 属性
             List<ProdProp> prodPropList =  prodPropService.listByProdId(dto.getProdId());
             dto.setProdPropList(prodPropList);

         });
        return dtoList;
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
    public TupleRet add(ProdAddParam prodAddParam) {
        Integer count = baseMapper.selectCount(new LambdaQueryWrapper<Prod>()
                .eq(Prod::getProdCode, prodAddParam.getProdCode())
                .eq(Prod::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Prod::getStatus, 1));
        if (count > 0) {
            TupleRet.failed("编码不得重复");
        }

        try {
            Prod model = new Prod();
            BeanUtils.copyProperties(prodAddParam, model);
            model.setPinyin(PinyinUtil.getPinyin(model.getProdName()));
            model.setShopId(ApiContextHolder.getAuthDto().getShopId());
            model.setStock(0); // 默认库存0
            model.setStatus(1);
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
    public TupleRet edit(ProdEditParam prodEditParam) {
        Prod model = baseMapper.selectById(prodEditParam.getProdId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("商品不存在");
        }

        Integer count = baseMapper.selectCount(new LambdaQueryWrapper<Prod>()
                .eq(Prod::getProdCode, prodEditParam.getProdCode())
                .eq(Prod::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .ne(Prod::getProdId, prodEditParam.getProdId())
                .eq(Prod::getStatus, 1));
        if (count > 0) {
            return TupleRet.failed("编码不得重复");
        }

        try {
            BeanUtils.copyProperties(model,prodEditParam);
            model.setPinyin(PinyinUtil.getPinyin(model.getProdName()));
            model.setShopId(ApiContextHolder.getAuthDto().getShopId());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }
}
