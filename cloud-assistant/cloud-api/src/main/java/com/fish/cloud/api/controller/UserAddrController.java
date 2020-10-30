package com.fish.cloud.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.UserAddr;
import com.fish.cloud.bean.param.AddrAddParam;
import com.fish.cloud.common.util.SecurityUtil;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.service.IUserAddrService;
import io.swagger.annotations.ApiOperation;
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
@RestController
@RequestMapping("/api/userAddr")
public class UserAddrController {
    @Autowired
    private IUserAddrService userAddrService;

    @ApiOperation("列表")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public TupleRet<List<UserAddr>> all() {
        List<UserAddr> userAddrs = userAddrService.list(new LambdaQueryWrapper<UserAddr>()
        .eq(UserAddr::getUserId, SecurityUtil.getAdmin().getEmpId()));
        return  TupleRet.success(userAddrs);
    }

    @ApiOperation("详情")
    @GetMapping(value = "/detail/{id}")
    public TupleRet<UserAddr> detail(@PathVariable("id") long id){
        UserAddr userAddr = userAddrService.getById(id);
        return TupleRet.success(userAddr);
    }

    @ApiOperation("添加")
    @PostMapping(value = "/add")
    public TupleRet add(@RequestBody AddrAddParam addrAddParam) {
        return userAddrService.add(addrAddParam);
    }

    @ApiOperation("更新状态")
    @GetMapping(value = "/updateStatus/{id}/{status}")
    public TupleRet updateStatus(@PathVariable("id") long id,@PathVariable("status") Integer status){
        Boolean success = userAddrService.updateStatus(id,status);
        return TupleRet.success(success);
    }


    @ApiOperation("设为默认收货地址")
    @GetMapping(value = "/setDefault/{id}")
    public TupleRet setDefault(@PathVariable("id") long id){
        return userAddrService.setDefault(id);
    }
}
