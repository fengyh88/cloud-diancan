package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.Prod;
import com.fish.cloud.bean.param.ProdAddParam;
import com.fish.cloud.common.util.SecurityUtil;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.repo.ProdMapper;
import com.fish.cloud.service.IProdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class ProdServiceImpl extends ServiceImpl<ProdMapper, Prod> implements IProdService {
    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        Prod model = baseMapper.selectById(id);
        if (null == model){
            return TupleRet.failed("商品不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet updateStock(long id, Integer num) {
        Prod model = baseMapper.selectById(id);
        if (null == model){
            return TupleRet.failed("商品不存在");
        }

        //增加库存
        model.setStock(model.getStock() + num);
        model.setSold(model.getSold() - num);

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            //logger.error(e.getMessage());
            return TupleRet.failed("更新失败");
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet addOrEdit(ProdAddParam prodAddParam) {
        try {
            var existModel =  baseMapper.selectById(prodAddParam.getProdId());
            if (null == existModel) {
                //不存在，则新增
                var model = new Prod();
                model.setShopId(SecurityUtil.getAdmin().getShopId());
                model.setCateId(prodAddParam.getCateId());

                model.setStatus(1);
                baseMapper.insert(model);
            }
            else {
                //已存在，则编辑
                existModel.setCateId(prodAddParam.getCateId());

                baseMapper.updateById(existModel);
            }
        } catch (Exception ex) {
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }
}
