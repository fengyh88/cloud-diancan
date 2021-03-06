package com.fish.cloud.service.impl;

import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.common.util.IdUtil;
import com.fish.cloud.common.util.QiniuUtil;
import com.fish.cloud.service.IImgStorageService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 图片存储
 */
@Slf4j
@Service
public class ImgStorageServiceImpl implements IImgStorageService {

    @Value("${img.upload-folder}")
    private String fileBasePath;

    @Value("${img.show-prefix}")
    private String showPrefix;

    @Override
    public TupleRet store(MultipartFile file) throws IOException {
        // 获取原始文件名称(包含格式)
        String originalFileName = file.getOriginalFilename();
        // 获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        //获 取文件名称（不包含格式）
        String fileName = DateTimeUtil.getCurrentDateTimeFormat() + IdUtil.getRandomString(4) + "." + type;
        //图片保存路径
        String fileFullName = fileBasePath + File.separator + fileName;
        File saveFile = new File(fileFullName);
        if (!saveFile.getParentFile().exists()) {
            saveFile.getParentFile().mkdirs();
        }
        try {
            //将临时存储的文件移动到真实存储路径下
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回图片访问地址
        return TupleRet.success(showPrefix + File.separator + fileName);
    }
}
