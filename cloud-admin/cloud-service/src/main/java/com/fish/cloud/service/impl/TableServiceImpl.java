package com.fish.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.TableDto;
import com.fish.cloud.bean.model.Table;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.ImgUrlUtil;
import com.fish.cloud.repo.TableMapper;
import com.fish.cloud.service.ITableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 台桌
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
@Slf4j
public class TableServiceImpl extends ServiceImpl<TableMapper, Table> implements ITableService {

    @Override
    public List<TableDto> all() {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Table>()
                .eq(Table::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Table::getStatus, 1));
        List<TableDto> dtoList = models.stream().map(model -> {
            TableDto dto = new TableDto();
            BeanUtil.copyProperties(model, dto);
            dto.setBarcode(ImgUrlUtil.getFullPathImgUrl(dto.getBarcode()));
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TupleRet updateBarcode(Long tableId, String barcode) {
        var model = baseMapper.selectById(tableId);
        if (ObjectUtil.isNull(model)){
            return TupleRet.failed("台桌不存在");
        }
        model.setBarcode(barcode);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet status(Long tableId, Integer status) {
        var model = baseMapper.selectById(tableId);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("台桌不存在");
        }

        try {
            model.setStatus(status);
            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }

}
