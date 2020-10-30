package com.fish.cloud.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    /**
     * @param patt    匹配正则
     * @param replace 替换成的内容
     * @param source  原始字符串
     * @return
     */
    public static String replaceAll(String patt, String replace, String source) {
        Pattern r = Pattern.compile(patt);
        Matcher m = r.matcher(source);
        return m.replaceAll(replace);
       /* m.reset();
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            // 将匹配之前的字符串复制到sb,再将匹配结果替换为："favour"，并追加到sb
            m.appendReplacement(sb, replace);
        }
        m.appendTail(sb);*/
    }
}
