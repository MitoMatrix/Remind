package com.auto.remind.com.bwensun.commons.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Remind Properties
 *
 * @author 郑建雄
 * @date 2021/12/13
 */
@ConfigurationProperties(prefix = RemindProperties.PREFIX)
@Getter
@Setter
@Component
public class RemindProperties {

    public static final String PREFIX = "remind";

    private String boostCron;
}
