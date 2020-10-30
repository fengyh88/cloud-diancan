package com.fish.cloud.common.util;

import com.fish.cloud.bean.config.ConstConf;
import org.springframework.util.ObjectUtils;

public class ImgUrlUtil {
    public static String getFullPathImgUrl(Object imgUrl) {
        return ObjectUtils.isEmpty(imgUrl) ? "" : ConstConf.BASE_URL + imgUrl.toString();
    }
}
