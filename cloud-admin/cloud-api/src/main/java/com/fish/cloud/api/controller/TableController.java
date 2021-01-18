package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.TableDto;
import com.fish.cloud.bean.model.Table;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ITableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "台桌")
@Controller
@RequestMapping("/table")
public class TableController {
    @Autowired
    private ITableService tableService;

    @ApiOperation("列表")
    @GetMapping(value = "/list")
    public ApiResult<List<TableDto>> list() {
        var models = tableService.list(new LambdaQueryWrapper<Table>()
                .eq(Table::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Table::getStatus, 1));
        List<TableDto> dtoList = models.stream().map(model -> {
            TableDto dto = new TableDto();
            BeanUtil.copyProperties(model, dto);
            return dto;
        }).collect(Collectors.toList());
        return ApiResult.success(dtoList);
    }

}
