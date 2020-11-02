package com.fish.cloud.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static Date getCurrentDateTime(){
        Date currentTime = new Date();
        return currentTime;
    }
    public static String getCurrentDateTimeFormat(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(d);
    }
}
