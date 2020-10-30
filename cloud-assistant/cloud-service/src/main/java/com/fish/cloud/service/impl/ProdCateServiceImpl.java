package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.ProdCate;
import com.fish.cloud.bean.param.ProdCateAddParam;
import com.fish.cloud.common.util.SecurityUtil;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.repo.ProdCateMapper;
import com.fish.cloud.service.IProdCateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class ProdCateServiceImpl extends ServiceImpl<ProdCateMapper, ProdCate> implements IProdCateService {

    @Override
    public Boolean updateStatus(Long id, Integer status) {
        ProdCate model = baseMapper.selectById(id);
        if (null == model){
            return true;
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return true;
    }

    @Override
    public TupleRet addOrEdit(ProdCateAddParam prodCateAddParam) {
        try {
            var existModel =  baseMapper.selectById(prodCateAddParam.getId());
            if (null == existModel) {
                //不存在，则新增
                var model = new ProdCate();
                model.setShopId(SecurityUtil.getAdmin().getShopId());
                model.setCateName(prodCateAddParam.getCateName());

                String picUrl = prodCateAddParam.getPicUrl();
                if (!picUrl.startsWith("OTA")) {
                    picUrl = picUrl.substring(picUrl.indexOf("OTA"));
                }
                model.setImg(picUrl);

                model.setSeq(prodCateAddParam.getSeq());
                model.setStatus(1);
                baseMapper.insert(model);
            }
            else {
                //已存在，则编辑
                existModel.setCateName(prodCateAddParam.getCateName());

                String picUrl = prodCateAddParam.getPicUrl();
                if (!picUrl.startsWith("OTA")) {
                    picUrl = picUrl.substring(picUrl.indexOf("OTA"));
                }
                existModel.setImg(picUrl);

                existModel.setSeq(prodCateAddParam.getSeq());
                baseMapper.updateById(existModel);
            }
        } catch (Exception ex) {
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }
}
