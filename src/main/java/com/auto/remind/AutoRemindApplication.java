package com.auto.remind;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.auto.remind.com.bwensun.commons.util.SentinelUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * @author 郑建雄
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class AutoRemindApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoRemindApplication.class, args);
    }

    @Bean
    @SentinelRestTemplate(fallbackClass = SentinelUtils.class,
            fallback = "defaultFallbackMethod",
            blockHandlerClass = SentinelUtils.class,
            blockHandler = "handleException")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
