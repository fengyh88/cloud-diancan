package com.fish.cloud.api.controller;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.UserAddr;
import com.fish.cloud.bean.param.UserAddrAddParam;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IUserAddrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "用户收货地址")
@RestController
@RequestMapping("/userAddr")
public class UserAddrController {
    @Autowired
    private IUserAddrService userAddrService;

    @ApiOperation("全部")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ApiResult<List<UserAddr>> all() {
        var dtos = userAddrService.list(new LambdaQueryWrapper<UserAddr>()
                .eq(UserAddr::getUserId, ApiContextHolder.getAuthDto().getUserId()));
        return ApiResult.success(dtos);
    }

    @ApiOperation("默认地址")
    @RequestMapping(value = "/getDefault",method = RequestMethod.GET)
    public ApiResult<UserAddr> getDefault() {
        var dto = userAddrService.getOne(new LambdaQueryWrapper<UserAddr>()
                .eq(UserAddr::getUserId, ApiContextHolder.getAuthDto().getUserId())
                .eq(UserAddr::getStatus, 1)
                .eq(UserAddr::getIsDefault, 1));
        return ApiResult.success(dto);
    }

    @ApiOperation("设为默认收货地址")
    @PostMapping(value = "/setDefault")
    public ApiResult setDefault(@RequestBody JSONObject obj) {
        String addrId = obj.getStr("addrId", "0");
        var ret = userAddrService.updateDefault(addrId, ApiContextHolder.getAuthDto().getUserId());
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("更新状态")
    @GetMapping(value = "/updateStatus")
    public ApiResult updateStatus(@RequestBody JSONObject obj) {
        Long addrId = obj.getLong("addrId", 0L);
        Integer status = obj.getInt("status", 0);
        var ret = userAddrService.updateStatus(addrId, status);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("添加")
    @ApiImplicitParam(name = "userAddrAddParam", value = "用户收货地址信息", required = true)
    @PostMapping(value = "/add")
    public ApiResult add(@RequestBody UserAddrAddParam userAddrAddParam){
        var ret = userAddrService.add(ApiContextHolder.getAuthDto().getUserId(), userAddrAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("编辑")
    @ApiImplicitParam(name = "userAddrAddParam", value = "用户收货地址信息", required = true)
    @PostMapping(value = "/edit")
    public ApiResult edit(@RequestBody UserAddrAddParam userAddrAddParam){
        var ret = userAddrService.edit(ApiContextHolder.getAuthDto().getUserId(), userAddrAddParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("删除")
    @ApiImplicitParam(name = "obj", value = "addrId", required = true)
    @PostMapping(value = "/delete")
    public ApiResult delete(@RequestBody JSONObject obj){
        String addrId = obj.getStr("addrId", "0");
        var ret = userAddrService.delete(addrId);
        return ApiResult.fromTupleRet(ret);
    }
}
