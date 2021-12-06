package com.auto.remind.com.bwensun.commons.util;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * sentinel限流、降级处理类
 *
 * @author 郑建雄
 */
@Slf4j
@SuppressWarnings("unused")
public class SentinelUtils {

    private SentinelUtils() {
    }

    public static SentinelClientHttpResponse handleException(HttpRequest request,
                                                             byte[] body, ClientHttpRequestExecution execution, BlockException ex) {

        log.error("fallback: 服务被限流");
        return new SentinelClientHttpResponse("系统正忙，请稍后重试");
    }

    public static SentinelClientHttpResponse defaultFallbackMethod(HttpRequest request,
                                                                   byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
        log.error("fallback: 服务被降级");
        return new SentinelClientHttpResponse("系统正忙，请稍后重试1");
    }

}