package com.fish.cloud.api.controller;

import cn.hutool.core.bean.BeanUtil;
import com.fish.cloud.bean.dto.TableDto;
import com.fish.cloud.bean.param.TableStorageParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.token.AuthTableDto;
import com.fish.cloud.common.util.ImgUrlUtil;
import com.fish.cloud.service.ITableService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("根据Id获取信息")
    @ApiImplicitParam(name = "tableId", value = "台桌Id", required = true)
    @GetMapping(value = "/getByTableId")
    public ApiResult<TableDto> getByTableId(@RequestParam Long tableId) {
        var model = tableService.getByTableId(tableId);
        TableDto dto = new TableDto();
        BeanUtil.copyProperties(model, dto);
        return ApiResult.success(dto);
    }

    @ApiOperation("存储选择的台桌")
    @ApiImplicitParam(name = "tableStorageParam", value = "选择的台桌信息", required = true)
    @RequestMapping(value = "/storage", method = RequestMethod.POST)
    public ApiResult storage(@RequestBody TableStorageParam tableStorageParam) {
        AuthTableDto authTableDto = new AuthTableDto();
        authTableDto.setTableId(tableStorageParam.getTableId());
        authTableDto.setPeople(tableStorageParam.getPeople());
        ApiContextHolder.setAuthTableDto(authTableDto);
        return ApiResult.success();
    }
}
