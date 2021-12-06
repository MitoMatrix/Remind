package com.auto.remind.com.bwensun.commons.exception;

/**
 * 远程调用异常
 *
 * @author 郑建雄
 * @date 2021/11/22
 */
public class RpcException extends BaseException{

    public RpcException() {
        super(ExceptionEnum.RPC_EXCEPTION.code, ExceptionEnum.RPC_EXCEPTION.message);
    }
}
