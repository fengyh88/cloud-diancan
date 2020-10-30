package com.fish.cloud.api.controller;

import com.fish.cloud.bean.model.MemGrade;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IMemGradeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 会员等级(全局会员)
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@RestController
@RequestMapping("/memGrade")
public class MemGradeController {

    @Autowired
    private IMemGradeService memGradeService;

    @ApiOperation("详情")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true)
    @GetMapping(value = "/detail")
    public ApiResult<MemGrade> detail(@RequestParam(value = "id") long id) {
        var dto = memGradeService.detail(id);
        return ApiResult.success(dto);
    }
}
