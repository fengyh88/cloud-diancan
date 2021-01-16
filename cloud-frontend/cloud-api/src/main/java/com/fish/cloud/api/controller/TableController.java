package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import com.fish.cloud.bean.dto.TableDto;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ITableService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
@RequestMapping("/table")
public class TableController {
    @Autowired
    private ITableService tableService;

    @ApiOperation("根据编码获取信息")
    @ApiImplicitParam(name = "tableCode", value = "编码", required = true)
    @GetMapping(value = "/getByTableCode")
    public ApiResult<TableDto> getByTableCode(String tableCode) {
        var model = tableService.getByTableCode(tableCode);
        TableDto dto = new TableDto();
        BeanUtil.copyProperties(model, dto);
        return ApiResult.success(dto);
    }
}
