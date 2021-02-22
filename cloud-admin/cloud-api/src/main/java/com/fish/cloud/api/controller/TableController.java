package com.fish.cloud.api.controller;

import com.fish.cloud.bean.dto.TableDto;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.ITableService;
import com.fish.cloud.service.IWechatPlatformService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 台桌
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "台桌")
@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    private IWechatPlatformService wechatPlatformService;

    @Autowired
    private ITableService tableService;

    @ApiOperation("全部列表")
    @GetMapping(value = "/all")
    public ApiResult<List<TableDto>> all() {
        var dtoList = tableService.all();
        return ApiResult.success(dtoList);
    }

    @ApiOperation("生成微信小程序菊花码")
    @RequestMapping(value = "/generateMiniProgramBarCode",method = RequestMethod.GET)
    public ApiResult generateMiniProgramBarCode(@RequestParam Long tableId) {
        var ret = wechatPlatformService.generateMiniProgramBarCode(tableId);
        return ApiResult.fromTupleRet(ret);
    }
}
