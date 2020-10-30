package com.fish.cloud.api.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fish.cloud.bean.model.Prod;
import com.fish.cloud.bean.param.ProdAddParam;
import com.fish.cloud.bean.param.ProdByCateParam;
import com.fish.cloud.bean.param.ProdParam;
import com.fish.cloud.common.util.CommonResult;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.service.IProdService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@RestController
@RequestMapping("/api/prod")
public class ProdController {
    @Autowired
    private IProdService prodService;

    @ApiOperation("根据商品分类查询列表")
    @PostMapping(value = "/listByCate")
    public CommonResult<List<Prod>> listByCat(@RequestBody ProdByCateParam prodByCateParam) {
        List<Prod> prods = prodService.list(new LambdaQueryWrapper<Prod>()
                .eq(prodByCateParam.getShopId() != null, Prod::getShopId, prodByCateParam.getShopId())
                .eq(prodByCateParam.getCateId() != null, Prod::getCateId, prodByCateParam.getCateId())
                .like(StrUtil.isNotBlank(prodByCateParam.getProdName()), Prod::getProdName, prodByCateParam.getProdName())
                .orderByDesc(Prod::getPutonTime));
        return CommonResult.success(prods);
    }

    @ApiOperation("商品详情")
    @GetMapping(value = "/detail")
    public CommonResult<Prod> detail(@RequestParam(value = "id") long id) {
        Prod prod = prodService.getById(id);
        return CommonResult.success(prod);
    }

    @ApiOperation("新增或编辑")
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    public TupleRet addOrEdit(@RequestBody ProdAddParam prodAddParam) {
        return prodService.addOrEdit(prodAddParam);
    }

    @ApiOperation("更改状态，上架下架")
    @GetMapping(value = "/updateStatus")
    public TupleRet updateStatus(@RequestParam(value = "id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{0, 1}, status)) {
            return TupleRet.failed("status传值需为1上架或者0下架");
        }
        return prodService.updateStatus(id, status);
    }

    @ApiOperation("更新库存")
    @GetMapping(value = "/updateStock")
    public TupleRet updateStock(@RequestParam(value = "id") long id, @RequestParam("num") Integer num) {
        return prodService.updateStock(id, num);
    }
}
