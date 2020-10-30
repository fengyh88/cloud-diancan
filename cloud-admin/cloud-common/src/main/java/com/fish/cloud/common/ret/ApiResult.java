package com.fish.cloud.common.ret;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description
 * @Author fengyh
 * @Date 2020/3/8 22:42
 * @Version 1.0
 */

@Getter
@Setter
public class ApiResult<T> {

    private long code;
    private String message;
    private T data;

    protected ApiResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     */
    public static <T> ApiResult<T> success() {
        return new ApiResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> ApiResult<T> success(T data, String message) {
        return new ApiResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> ApiResult<T> failed(IErrorCode errorCode) {
        return new ApiResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ApiResult<T> failed(String message) {
        return new ApiResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ApiResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ApiResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ApiResult<T> validateFailed(String message) {
        return new ApiResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ApiResult<T> unauthorized(T data) {
        return new ApiResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ApiResult<T> unauthorized() {
        return new ApiResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);
    }
    /**
     * 未授权返回结果
     */
    public static <T> ApiResult<T> forbidden(T data) {
        return new ApiResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    /**
     * 接口未实现
     */
    public static <T> ApiResult<T> notImplement() {
        return new ApiResult<T>(ResultCode.NOT_IMPLEMENT.getCode(), ResultCode.NOT_IMPLEMENT.getMessage(), null);
    }

    public static ApiResult fromTupleRet(TupleRet tupleRet){
        if (tupleRet.getSuccess()){
            return ApiResult.success(tupleRet.getData(),tupleRet.getMessage());
        } else {
            return ApiResult.failed(tupleRet.getMessage());
        }
    }
}
