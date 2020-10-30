package com.fish.cloud.common.ret;

import com.fish.cloud.common.ret.IErrorCode;

/**
 * @Description 枚举了一些常用API操作码
 * @Author fengyh
 * @Date 2020/3/8 22:42
 * @Version 1.0
 */
public enum ResultCode implements IErrorCode {

    SUCCESS(200,"操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    NOT_IMPLEMENT(600,"接口未实现");

    private Long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
