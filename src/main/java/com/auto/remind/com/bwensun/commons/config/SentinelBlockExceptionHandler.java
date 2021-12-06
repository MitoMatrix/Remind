package com.auto.remind.com.bwensun.commons.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.auto.remind.com.bwensun.commons.exception.ExceptionEnum;
import com.auto.remind.com.bwensun.domain.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 郑建雄
 */
@Slf4j
@ControllerAdvice
@Order(-1)
public class SentinelBlockExceptionHandler {


    @ExceptionHandler(FlowException.class)
    @ResponseBody
    public Result<Void> flowException(HttpServletRequest request, FlowException e) {
        handlerException(request, e);
        return Result.error(ExceptionEnum.FLOW_EXCEPTION.code, ExceptionEnum.FLOW_EXCEPTION.message);
    }

    @ExceptionHandler(DegradeException.class)
    @ResponseBody
    public Result<Void> degradeException(HttpServletRequest request, DegradeException e) {
        handlerException(request, e);
        return Result.error(ExceptionEnum.DEGRADE_EXCEPTION.code, ExceptionEnum.DEGRADE_EXCEPTION.message);
    }

    @ExceptionHandler(ParamFlowException.class)
    @ResponseBody
    public Result<Void> paramFlowException(HttpServletRequest request, ParamFlowException e) {
        handlerException(request, e);
        return Result.error(ExceptionEnum.PARAM_FLOW_EXCEPTION.code, ExceptionEnum.PARAM_FLOW_EXCEPTION.message);
    }

    @ExceptionHandler(AuthorityException.class)
    @ResponseBody
    public Result<Void> authorityException(HttpServletRequest request, AuthorityException e) {
        handlerException(request, e);
        return Result.error(ExceptionEnum.AUTHORITY_EXCEPTION.code, ExceptionEnum.AUTHORITY_EXCEPTION.message);
    }

    @ExceptionHandler(SystemBlockException.class)
    @ResponseBody
    public Result<Void> systemBlockException(HttpServletRequest request, SystemBlockException e) {
        handlerException(request, e);
        return Result.error(ExceptionEnum.SYSTEM_BLOCK_EXCEPTION.code, ExceptionEnum.SYSTEM_BLOCK_EXCEPTION.message);
    }

    /**
     * 打印下日志
     */
    private void handlerException(HttpServletRequest request, BlockException e) {
        log.warn("【BlockException】url: {},  RuleLimitApp: {} , Rule: {}", request.getRequestURI(), e.getRuleLimitApp(), e.getRule());
    }
}