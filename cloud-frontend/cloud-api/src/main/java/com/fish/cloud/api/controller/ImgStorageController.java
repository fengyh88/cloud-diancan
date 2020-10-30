package com.fish.cloud.api.controller;

import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IImgStorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>
 * 图片存储
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "图片存储")
@RestController
@RequestMapping("/imgStorage")
public class ImgStorageController {
    @Autowired
    private IImgStorageService imgStorageService;

    @ApiOperation("上传")
    @ApiImplicitParam(name = "file", value = "file", required = true)
    @PostMapping("/upload")
    public ApiResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            return ApiResult.failed("文件不存在");
        }
        var ret = imgStorageService.store(file);
        return ApiResult.fromTupleRet(ret);
    }
}
