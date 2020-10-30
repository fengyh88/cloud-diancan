package com.fish.cloud.common.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtil {

    /**
     * 获取汉字的拼音
     * @param hanzi
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public static String getPinyin(String hanzi) throws BadHanyuPinyinOutputFormatCombination {
        char[] charArray = hanzi.toCharArray();
        StringBuilder pinyin = new StringBuilder();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        //设置大小写格式
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        //设置声调格式：
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < charArray.length; i++) {
            //匹配中文,非中文转换会转换成null
            if (Character.toString(charArray[i]).matches("[\\u4E00-\\u9FA5]+")) {
                String[] hanyuPinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(charArray[i],defaultFormat);
                String string =hanyuPinyinStringArray[0];
                pinyin.append(string);
            } else {
                pinyin.append(charArray[i]);
            }
        }
        return pinyin.toString();
    }
}
