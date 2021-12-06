package com.auto.remind.com.bwensun.commons.exception;

import lombok.AllArgsConstructor;

/**
 * 异常类型
 *
 * @author 郑建雄
 * @date 2021/3/12
 */
@AllArgsConstructor
public enum ExceptionTypeEnum {
    /**
     * 业务异常
     */
    BIZ_EXCEPTION("业务异常"),

    /**
     * 认证异常
     */
    AUTH_EXCEPTION("认证异常"),

    /**
     * sentinel 异常
     */
    SENTINEL_EXCEPTION("SENTINEL异常"),

    /**
     * 参数校验异常
     */
    PARAM_VALIDATE_EXCEPTION("参数校验异常"),

    /**
     * 其他异常
     */
    OTHER_EXCEPTION("其他异常"),
    ;

    public final String desc;
}
