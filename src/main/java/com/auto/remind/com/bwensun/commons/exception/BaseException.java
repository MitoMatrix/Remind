package com.auto.remind.com.bwensun.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 业务异常类
 *
 * @author lkz
 * @date 2020/11/24 17:40
 **/
@Getter
@ToString(callSuper = true)
@AllArgsConstructor
public class BaseException extends RuntimeException {

    /**
     * 异常状态码 设置为final不允许直接修改
     */
    public final String code;

    /**
     * 异常信息
     */
    public final String message;

    /**
     * 通过code和message构建业务异常
     */
    public static BaseException of(String code, String message) {
        return new BaseException(code, message);
    }

    /**
     * 通过异常枚举构建业务异常
     */
    public static BaseException of(ExceptionEnum exception) {
        return new BaseException(exception.code, exception.message);
    }
}
