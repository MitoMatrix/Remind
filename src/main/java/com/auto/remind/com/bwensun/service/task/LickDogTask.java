package com.auto.remind.com.bwensun.service.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 舔狗嘲讽服务
 *
 * @author 郑建雄
 * @date 2021/11/25
 */
@Component
@Slf4j
public class LickDogTask {

    @Scheduled(cron = "0 0 23 * * ?")
    public void doBoost() {
        log.info("舔狗服务");
    }
}
