package com.fish.cloud.common.util;

public class CommonStrUtil {

    /**
     * 获取字符串首字母，且变大写
     * @param fullStr
     * @return
     */
    public static String firstCharUpper(String fullStr) {
        return fullStr.substring(0,1).toUpperCase();
    }
}
