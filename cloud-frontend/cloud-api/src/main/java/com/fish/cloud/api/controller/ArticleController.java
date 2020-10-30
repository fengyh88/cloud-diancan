package com.fish.cloud.api.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.api.context.ApiContextHolder;
import com.fish.cloud.bean.model.Article;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IArticleService;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 文章
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @ApiOperation("按类目查询列表")
    @GetMapping("/listByCateId")
    public ApiResult<List<Article>> listByCateId(@RequestBody String cateId) {
        var dtos = articleService.list(new LambdaQueryWrapper<Article>()
                .eq(Article::getShopId, ApiContextHolder.getShopId())
                .eq(StrUtil.isNotEmpty(cateId), Article::getCateId, cateId)
                .eq(Article::getStatus, 1));
        return ApiResult.success(dtos);
    }

    @ApiOperation("详情")
    @GetMapping(value = "/detail/{id}")
    public ApiResult<Article> detail(@PathVariable(value = "id") Long id) {
        var dto = articleService.getOne(new LambdaQueryWrapper<Article>()
                .eq(Article::getArticleId, id)
                .eq(Article::getStatus, 1),false);
        return ApiResult.success(dto);
    }
}
