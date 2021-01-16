package com.fish.cloud.common.util;

import java.util.Arrays;
import java.util.List;

public class StrUtil {
    public static List<String> splitToList(String source, String sep){
        String[] tarArray = cn.hutool.core.util.StrUtil.split(source,sep);
        return Arrays.asList(tarArray);
    }
}
