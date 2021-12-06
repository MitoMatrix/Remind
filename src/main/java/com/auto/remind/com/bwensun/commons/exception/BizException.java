package com.auto.remind.com.bwensun.commons.exception;

/**
 * 业务异常
 *
 * @author 郑建雄
 * @date 2021/11/21
 */
public class BizException extends BaseException{

    public BizException(String code, String message) {
        super(code, message);
    }


}
