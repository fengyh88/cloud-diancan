package com.fish.cloud.service.impl;

import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.IdUtil;
import com.fish.cloud.common.util.QiniuUtil;
import com.fish.cloud.service.IImgStorageService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 图片存储
 */
@Slf4j
@Service
public class ImgStorageServiceImpl implements IImgStorageService {
    @Override
    public TupleRet store(MultipartFile file) throws IOException {
        // 获取原始文件名称(包含格式)
        String originalFileName = file.getOriginalFilename();
        // 获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        //获 取文件名称（不包含格式）
        // String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));
        String fileName = DateTimeUtil.getCurrentDateTimeFormat() + IdUtil.getRandomString(4) + "." + type;
        // 获取文件流
        FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
        // 七牛上传后返回
        var ret = QiniuUtil.uploadQnImg(fileInputStream, fileName);
        return ret;
    }
}
