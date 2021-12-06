package com.auto.remind.com.bwensun.domain.dto.xinzhi;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 天气对象
 *
 * @author 郑建雄
 * @date 2021/11/23
 */
@Data
@Accessors(chain = true)
public class WeatherDTO {

    private String location;

    private String text;

    private String temperature;

    private String lastUpdate;
}
