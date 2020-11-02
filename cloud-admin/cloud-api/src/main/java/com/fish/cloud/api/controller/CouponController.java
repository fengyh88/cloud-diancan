package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.CallDto;
import com.fish.cloud.bean.dto.CouponDto;
import com.fish.cloud.bean.model.Call;
import com.fish.cloud.bean.model.Coupon;
import com.fish.cloud.bean.param.CouponParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.service.ICouponService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 优惠券
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Controller
@RequestMapping("/api/coupon")
public class CouponController {
    @Autowired
    private ICouponService couponService;

    /**
     * 分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页", notes = "分页")
    @GetMapping("/page")
    @ResponseBody
    public ApiResult<IPage<CouponDto>> page(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                            @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
                                            CouponParam couponParam) {
        // 筛选
        LambdaQueryWrapper<Coupon> queryWrapper = new LambdaQueryWrapper<Coupon>()
                .eq(0 != couponParam.getDiscountType(), Coupon::getDiscountType, couponParam.getDiscountType())
                .eq(0 != couponParam.getStatus(), Coupon::getStatus, couponParam.getStatus());

        // 是否过期需要单独筛选，且只有指定有效期过期的才可以
        if (1 == couponParam.getExpired()) {
            // 如果筛选 1未过期
            queryWrapper.le(Coupon::getEndTime, DateTimeUtil.getCurrentDateTime());
        } else if (2 == couponParam.getExpired()) {
            // 如果筛选 2已过期
            queryWrapper.ge(Coupon::getEndTime, DateTimeUtil.getCurrentDateTime());
        }

        // 分页列表
        IPage<Coupon> modelList = couponService.page(new Page<Coupon>(pageNo, pageSize), queryWrapper);
        // 转换
        IPage<CouponDto> dtoList = modelList.convert(model -> Convert.convert(CouponDto.class, model));
        // 返回
        return ApiResult.success(dtoList);
    }
}
