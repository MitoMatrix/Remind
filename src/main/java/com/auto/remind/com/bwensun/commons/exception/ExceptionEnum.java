package com.auto.remind.com.bwensun.commons.exception;

/**
 * 异常枚举维护
 *
 * @author 郑建雄
 * @date 2021/4/25
 */
@SuppressWarnings("unused")
public enum ExceptionEnum {

    /* ============== 基础错误码 start =================  */
    /**
     * 接口限流
     */
    FLOW_EXCEPTION("101", "接口限流"),

    /**
     * 服务降级
     */
    DEGRADE_EXCEPTION("102", "服务降级"),

    /**
     * 热点参数限流
     */
    PARAM_FLOW_EXCEPTION("103", "热点参数限流"),

    /**
     * 授权规则不通过
     */
    AUTHORITY_EXCEPTION("104", "授权规则不通过"),

    /**
     * 系统规则限流或降级
     */
    SYSTEM_BLOCK_EXCEPTION("105", "系统规则限流或降级"),

    /**
     * 限流
     */
    BLOCK_EXCEPTION("106", "限流"),

    /**
     * RPC调用异常
     */
    RPC_EXCEPTION("107", "RPC调用异常"),


    /* ============= 基础错误码-HTTP状态码 start ============ */

    /**
     * 内部服务器错误
     */
    INTERNAL_ERROR("500", "内部服务器错误"),

    /**
     * 认证异常
     */
    AUTH_EXCEPTION("401", "认证异常"),



    /* ========================= 基础错误码-HTTP状态码 end ========================= */
    /* ============== 基础错误码 end =================  */

    /* ============== 业务错误码 start =================  */
    /**
     * 用户不存在
     */
    USER_NOT_EXIST("1001", "用户不存在"),

    /**
     * 用户已冻结
     */
    USER_FROZEN("1002", "用户已冻结"),

    /**
     * 用户已删除
     */
    USER_DELETED("1003", "用户已删除"),

    /**
     * 用户名或密码错误
     */
    USER_PASSWORD_NOT_MATCH("1004", "用户名或密码错误"),

    /**
     * 验证码错误
     */
    CAPTCHA_ERROR("1005", "验证码错误"),

    /* ============== 业务错误码 end =================  */;

    public final String code;

    public final String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
