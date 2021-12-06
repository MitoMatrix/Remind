package com.auto.remind.com.bwensun.service.component;

import com.auto.remind.com.bwensun.commons.exception.BizException;
import com.auto.remind.com.bwensun.commons.exception.ExceptionEnum;
import com.auto.remind.com.bwensun.domain.dto.xinzhi.Location;
import com.auto.remind.com.bwensun.domain.dto.xinzhi.Now;
import com.auto.remind.com.bwensun.domain.dto.xinzhi.WeatherDTO;
import com.auto.remind.com.bwensun.domain.dto.xinzhi.XinzhiWeather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 心知天气API调用组件
 *
 * @author 郑建雄
 * @date 2021/11/23
 */
@Slf4j
@Component
public class XinZhiComponent {

    private static final String WEATHER = "https://api.seniverse.com/v3/weather/now.json?key=S5IX2Z3FcTaetDIrd&location=%s&language=zh-Hans&unit=c";

    @Resource
    private RestTemplate restTemplate;

    public WeatherDTO weather(String location) {
        final String url = String.format(WEATHER, location);
        final XinzhiWeather xinzhiWeather = restTemplate.getForObject(url, XinzhiWeather.class, "");
        final Now now = Optional
                .ofNullable(xinzhiWeather)
                .orElseThrow(() -> BizException.of(ExceptionEnum.INTERNAL_ERROR))
                .getResults()
                .get(0)
                .getNow();
        final Location locationDto = Optional
                .of(xinzhiWeather)
                .orElseThrow(() -> BizException.of(ExceptionEnum.INTERNAL_ERROR))
                .getResults()
                .get(0)
                .getLocation();
        final String lastUpdate = Optional
                .of(xinzhiWeather)
                .orElseThrow(() -> BizException.of(ExceptionEnum.INTERNAL_ERROR))
                .getResults()
                .get(0)
                .getLastUpdate()
                .substring(0, 19)
                .replace("T", " ");
        return new WeatherDTO()
                .setLocation(locationDto.getName())
                .setText(now.getText())
                .setTemperature(now.getTemperature())
                .setLastUpdate(lastUpdate);
    }
}
