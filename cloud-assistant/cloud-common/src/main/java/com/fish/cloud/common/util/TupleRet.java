package com.fish.cloud.common.util;

import lombok.Data;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 23:59
 * @Version 1.0
 */
@Data
public class TupleRet<T> {
    private Boolean isSuccess;
    private String message;
    private T data;

    protected TupleRet(Boolean isSuccess, String message, T data) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }
    /**
     * 成功返回结果
     */
    public static <T> TupleRet<T> success() {
        return new TupleRet<T>(true, "",null);
    }
    /**
     * 成功返回结果
     */
    public static <T> TupleRet<T> success(String message) {
        return new TupleRet<T>(true, message,null);
    }
    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> TupleRet<T> success(T data) {
        return new TupleRet<T>(true,"", data);
    }




    /**
     * 失败返回结果
     */
    public static <T> TupleRet<T> failed() {
        return new TupleRet<T>(false, "",null);
    }

    public static <T> TupleRet<T> failed(String message) {
        return new TupleRet<T>(false, message,null);
    }
    public static <T> TupleRet<T> failed(T data) {
        return new TupleRet<T>(false,"", data);
    }
}
