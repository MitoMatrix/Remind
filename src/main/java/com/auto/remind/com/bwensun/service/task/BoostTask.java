package com.auto.remind.com.bwensun.service.task;

import com.auto.remind.com.bwensun.service.BoostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 勉励服务
 *
 * @author 郑建雄
 * @date 2021/11/22
 */
@Component
@Slf4j
public class BoostTask {

    @Resource
    private BoostService boostService;

    @Scheduled(cron = "0 30 8 * * ?")
    public void doBoost(){
        boostService.boostService();
    }
}
