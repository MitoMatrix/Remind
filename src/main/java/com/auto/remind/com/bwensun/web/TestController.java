package com.auto.remind.com.bwensun.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.auto.remind.com.bwensun.commons.exception.BizException;
import com.auto.remind.com.bwensun.commons.exception.ExceptionEnum;
import com.auto.remind.com.bwensun.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试控制器
 *
 * @author 郑建雄
 * @date 2021/11/20
 */
@RestController
@Slf4j
public class TestController {

    @Resource
    private TestService service;

    @GetMapping(value = "/hello/{name}")
    public String apiHello(@PathVariable String name) {
        return service.sayHello(name);
    }

    @GetMapping(value = "/test/flowControl")
    @SentinelResource(value = "flowControl")
    public String flowControl() {
        log.info("flowControl");
        return "flowControl";
    }

    @GetMapping(value = "/test/fuseControl")
    @SentinelResource(value = "/test/fuseControl")
    public String fuseControl() {
        log.info("fuseControl");
        throw BizException.of(ExceptionEnum.INTERNAL_ERROR);
    }

    @GetMapping(value = "/test/param/flow")
    @SentinelResource(value = "/test/param/flow")
    public String paramFlowControl(String name) {
        log.info("paramFlowControl, param:{}", name);
        return name;
    }
}
