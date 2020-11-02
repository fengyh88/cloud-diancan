package com.fish.cloud.api.exception;

import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.common.ret.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@ApiIgnore
public class ApiExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ApiResult<?> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ApiResult<?> r = null;
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            r = ApiResult.failed(ResultCode.VALIDATE_FAILED);
        } else {
            r = ApiResult.failed(ResultCode.FAILED);
        }
        r.setMessage(e.getMessage());
        r.setData(null);
        return r;
    }
}

