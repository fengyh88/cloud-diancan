package com.fish.cloud.common.util;

import com.fish.cloud.bean.config.ConstConf;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;

public class ImgUrlUtil {

    @Value("${img.show-prefix}")
    private static String showPrefix;

    public static String getFullPathImgUrl(String imgUrl) {
        return ObjectUtils.isEmpty(imgUrl) ? "" : showPrefix + imgUrl;
    }
}
