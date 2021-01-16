package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.Table;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.repo.TableMapper;
import com.fish.cloud.service.ITableService;
import lombok.var;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 台桌
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class TableServiceImpl extends ServiceImpl<TableMapper, Table> implements ITableService {

    @Override
    public Table getByTableCode(String tableCode) {
        var model = baseMapper.selectOne(new LambdaQueryWrapper<Table>()
                .eq(Table::getShopId, ApiContextHolder.getShopId())
                .eq(Table::getTableCode, tableCode)
                .notIn(Table::getStatus, new Integer[]{-1, 0}));
        return model;
    }

    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

}
