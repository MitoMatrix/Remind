package com.auto.remind.com.bwensun.domain.base;

/**
 * 统一结果返回
 *
 * @author 郑建雄
 * @date 2021/4/20
 */
@SuppressWarnings("unused")
public class Result<T> {

    public static final Void VOI = null;

    /**
     * 结果是否成功
     */
    public final boolean success;

    /**
     * 结果信息
     */
    public final String message;

    /**
     * 返回状态码
     */
    public final String code;

    /**
     * 返回对象
     */
    public final T data;

    public Result(boolean success, String code, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public static Result<Void> ok() {
        return new Result<>(true, "200", "ok", VOI);
    }

    public static<T> Result<T> ok(T data) {
        return new Result<>(true, "200","ok", data);
    }

    public static Result<Void> error(String message) {
        return new Result<>(false, "500", message, VOI);
    }

    public static Result<Void> error( String code, String message) {
        return new Result<>(false, code, message, VOI);
    }
}
