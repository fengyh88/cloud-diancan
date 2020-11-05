package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.Table;
import com.fish.cloud.bean.param.TableAddParam;
import com.fish.cloud.bean.param.TableEditParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.TableMapper;
import com.fish.cloud.service.ITableManageService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 台桌
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class TableManageServiceImpl extends ServiceImpl<TableMapper, Table> implements ITableManageService {

    /**
     * 更新状态，正常禁用删除
     * @param id
     * @param status
     * @return
     */
    @Override
    public TupleRet status(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("台桌不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(TableAddParam tableAddParam) {
        if (existByTableCode(tableAddParam.getTableCode())) {
            return TupleRet.failed("编码不得重复");
        }

        try {
            var model = new Table();
            BeanUtils.copyProperties(tableAddParam,model);
            model.setShopId(ApiContextHolder.getAuthDto().getShopId());
            model.setStatus(1);
            model.setCreatedTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public TupleRet edit(TableEditParam tableEditParam) {
        var modelDb = baseMapper.selectById(tableEditParam.getTableId());
        if (ObjectUtils.isEmpty(modelDb)) {
            return TupleRet.failed("台桌不存在");
        }
        if (existByTableCode(tableEditParam.getTableCode())) {
            return TupleRet.failed("编码不得重复");
        }

        try {
            BeanUtils.copyProperties(tableEditParam,modelDb);

            baseMapper.updateById(modelDb);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    private boolean existByTableCode(String tableCode) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Table>()
                .eq(Table::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Table::getTableCode, tableCode)
                .ne(Table::getStatus,-1));
        if (count > 0) {
            return true;
        }
        return false;
    }
}
