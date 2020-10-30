package com.fish.cloud.bean.exception;

import org.springframework.http.HttpStatus;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 23:48
 * @Version 1.0
 */
public class MyException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = -4137688758944857209L;

    /**
     * http状态码
     */
    private Integer httpStatusCode;

    /**
     * @param httpStatus http状态码
     */
    public MyException(HttpStatus httpStatus, String msg) {
        super(msg);
        this.httpStatusCode = httpStatus.value();
    }


    public MyException(String msg) {
        super(msg);
        this.httpStatusCode = HttpStatus.BAD_REQUEST.value();
    }


    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

}
