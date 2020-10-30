package com.fish.cloud.api.controller;

import com.fish.cloud.bean.param.ShopAddParam;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.service.IShopService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 店铺
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@RestController
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    private IShopService shopService;

    @ApiOperation("详情")
    @GetMapping(value = "/detail")
    public TupleRet detail(@RequestParam(name = "id") long id) {
        return shopService.detail(id);
    }

    @ApiOperation("新增或编辑")
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    public TupleRet addOrEdit(@RequestBody ShopAddParam shopAddParam) {
        return shopService.addOrEdit(shopAddParam);
    }

    @ApiOperation("更新状态")
    @GetMapping(value = "/updateStatus/{id}/{status}")
    public TupleRet updateStatus(@PathVariable("id") long id,@PathVariable("status") Integer status){
        return shopService.updateStatus(id,status);
    }
    @ApiOperation("生成商家编码")
    @GetMapping(value = "/assistant/generate")
    public TupleRet assistantGenerate() {
        return shopService.generateCode();
    }
}
