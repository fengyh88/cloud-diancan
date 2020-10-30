package com.fish.cloud.common.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class IdUtil {

    public static String getIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().substring(0,4).hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
//         0 代表前面补充0
//         4 代表长度为4
//         d 代表参数为正数型
        return String.format("%01d", hashCodeV);
    }

    public static Long getLongIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().substring(0,4).hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
//         0 代表前面补充0
//         4 代表长度为4
//         d 代表参数为正数型
        String id =  String.format("%01d", hashCodeV);
        return Long.parseLong(id);
    }

    private static String getOrderNoByTime(Integer storeId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());

        return newDate;
        //订单规则改变
        //String store = frontCompWithZore(storeId, 4);
        //String result = randomLen(3);
        //return newDate + store + result;
    }

    private static String frontCompWithZore(int sourceDate,int formatLength) {
        //0 指前面补充零
        // formatLength 字符总长度为 formatLength
        // d 代表为正数。
        String newString = String.format("%0" + formatLength + "d", sourceDate);
        return newString;
    }

    private static String randomLen(int len) {
        String result = "";
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            result += random.nextInt(10);
        }
        return result;
    }

    /**
     * 生成的字符串每个位置都有可能是str中的一个字母或数字
     * @param length length用户要求产生字符串的长度
     * @return
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 可以指定某个位置是a-z、A-Z或是0-9
     * @param length
     * @return
     */
    private static String getRandomString2(int length){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(3);
            long result=0;
            switch(number){
                case 0:
                    result=Math.round(Math.random()*25+65);
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:
                    result=Math.round(Math.random()*25+97);
                    sb.append(String.valueOf((char)result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }


        }
        return sb.toString();
    }

    private static String getRandomString3(int length){
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
