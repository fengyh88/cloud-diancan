package com.fish.cloud.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.ArticleCate;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IArticleCateService;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 文章类目
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@RestController
@RequestMapping("/articleCate")
public class ArticleCateController {
    @Autowired
    private IArticleCateService articleCateService;

    @ApiOperation("全部")
    @GetMapping("/all")
    public ApiResult<List<ArticleCate>> all() {
        var models = articleCateService.list(new LambdaQueryWrapper<ArticleCate>()
                .eq(ArticleCate::getShopId, ApiContextHolder.getShopId())
                .eq(ArticleCate::getStatus, 1)
                .eq(ArticleCate::getGrade, 1));
        return ApiResult.success(models);
    }
}
