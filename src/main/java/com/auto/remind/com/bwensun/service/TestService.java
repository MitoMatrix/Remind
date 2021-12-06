package com.auto.remind.com.bwensun.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 郑建雄
 */
@Service
@Slf4j
public class TestService {

    @SentinelResource(value = "sayHello" ,blockHandler = "blockHandlerForGetUser")
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public String blockHandlerForGetUser(String name, BlockException exception) {
        log.info("接受参数：{}", name);
        return "系统繁忙";
    }
}