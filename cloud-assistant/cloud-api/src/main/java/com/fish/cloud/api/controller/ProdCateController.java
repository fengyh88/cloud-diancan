package com.fish.cloud.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.ProdCate;
import com.fish.cloud.bean.param.ProdCateAddParam;
import com.fish.cloud.common.util.CommonResult;
import com.fish.cloud.common.util.SecurityUtil;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.service.IProdCateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 商品类目
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@RestController
@RequestMapping("/api/prodCate")
public class ProdCateController {
    @Autowired
    private IProdCateService prodCateService;

    /**
     * 全部
     * @return
     */
    @GetMapping("/all")
    public TupleRet<List<ProdCate>> all() {
        List<ProdCate> prodCates = prodCateService.list(new LambdaQueryWrapper<ProdCate>()
        .eq(ProdCate::getShopId, SecurityUtil.getAdmin().getShopId()));
        return TupleRet.success(prodCates);
    }

    @ApiOperation("更新状态")
    @GetMapping(value = "/updateStatus/{id}/{status}")
    public TupleRet updateStatus(@PathVariable("id") long id,@PathVariable("status") Integer status){
        Boolean success = prodCateService.updateStatus(id,status);
        return TupleRet.success(success);
    }

    @ApiOperation("新增或编辑")
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    public TupleRet addOrEdit(@RequestBody ProdCateAddParam prodCateAddParam) {
        return prodCateService.addOrEdit(prodCateAddParam);
    }

}
