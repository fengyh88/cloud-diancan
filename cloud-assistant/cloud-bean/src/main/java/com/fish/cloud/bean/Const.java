package com.fish.cloud.bean;

public class Const {
    /**
     * 删除状态：已删除
     */
    public static final Integer DELETE_STATUS_TRUE = 1;
    /**
     * 删除状态：未删除
     */
    public static final Integer DELETE_STATUS_FALSE = 0;
    /**
     * 默认状态：默认地址
     */
    public static final Integer DEFAULT_STATUS_TRUE = 1;
    /**
     * 默认状态：非默认地址
     */
    public static final Integer DEFAULT_STATUS_FALSE = 0;

    /**
     * 分页，默认每页条数
     */
    public static final Integer PAGE_SIZE_DEFAULT = 15;

    /**
     * baseUrl,用来拼接图片，考虑是否配置到数据库？
     */
    public static final String BASE_URL = "https://www.linkeo.cloud:8443/adminapi/";
    //public static final String BASE_URL = "https://www.hongmengbusiness.com:8443/adminapi/";
    //public static final String BASE_URL = "http://localhost:8080/";
}
