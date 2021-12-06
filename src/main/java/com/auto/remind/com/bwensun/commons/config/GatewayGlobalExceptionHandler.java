package com.auto.remind.com.bwensun.commons.config;

import com.auto.remind.com.bwensun.commons.exception.BizException;
import com.auto.remind.com.bwensun.commons.exception.ExceptionTypeEnum;
import com.auto.remind.com.bwensun.domain.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 全局异常处理
 *
 * @author 郑建雄
 * @date 2021/3/12
 */
@Slf4j
@ControllerAdvice
@Order(0)
public class GatewayGlobalExceptionHandler {


    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Result<Void> businessException(HttpServletRequest request, BizException e) {
        handlerException(ExceptionTypeEnum.BIZ_EXCEPTION.desc, request, e);
        return Result.error(e.code, e.message);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Void> otherException(HttpServletRequest request, Exception e) {
        handlerException(ExceptionTypeEnum.OTHER_EXCEPTION.desc, request, e);
        return Result.error(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "内部服务器错误");
    }

    /**
     * 打印下日志
     */
    private void handlerException(String exceptionType, HttpServletRequest request, Exception e) {
        log.error("【{}】 请求路径：{}", exceptionType, request.getRequestURL(), e);
    }
}
