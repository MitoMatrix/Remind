package com.auto.remind.com.bwensun.service.impl;

import com.auto.remind.com.bwensun.commons.constant.DingMessageType;
import com.auto.remind.com.bwensun.commons.exception.BaseException;
import com.auto.remind.com.bwensun.commons.exception.ExceptionEnum;
import com.auto.remind.com.bwensun.domain.dto.ding.DingRequestDTO;
import com.auto.remind.com.bwensun.domain.dto.xinzhi.WeatherDTO;
import com.auto.remind.com.bwensun.service.BoostService;
import com.auto.remind.com.bwensun.service.component.DingComponent;
import com.auto.remind.com.bwensun.service.component.XiaoYComponent;
import com.auto.remind.com.bwensun.service.component.XinZhiComponent;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/11/22
 */
@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
@Service
@Slf4j
public class BoostServiceImpl implements BoostService {

    public static final String URL = "https://oapi.dingtalk.com/robot/send?access_token=5de3cd0d4c2a9d300b1da08ac46626279be362ac0a8e7795e0223f5a08d1f51f";

    @Resource
    private DingComponent dingComponent;

    @Resource
    private XiaoYComponent xiaoYComponent;

    @Resource
    private XinZhiComponent xinZhiComponent;

    @SneakyThrows
    @Override
    public void boostService() {
        final DingRequestDTO request = new DingRequestDTO();
        //设置url
        request.setUrl(URL);
        //设置at属性
        request.setAtAll(Boolean.FALSE);
        request.setAtMobiles(Lists.newArrayList("17612587856"));
        //设置内容
        final OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("Moring Post");
        final String text = renderingTemplate(readMarkDow());
        markdown.setText(text);
        request.setMarkdown(markdown);
        request.setAtAll(false);
        request.setMsgType(DingMessageType.MARKDOWN);
        dingComponent.doSend(request);
    }

    private String renderingTemplate(String template) {
        final String converUrl = xiaoYComponent.conver();
        final String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        final WeatherDTO weather = xinZhiComponent.weather("maanshan");
        final String words = xiaoYComponent.randomSentence();
        //封面
        template = template.replace("{cover}", converUrl);
        //日期
        template = template.replace("{date}", date);
        //地点
        template = template.replace("{location}", weather.getLocation());
        //天气
        template = template.replace("{weather}", weather.getText());
        //气温
        template = template.replace("{temperature}", weather.getTemperature());
        //发布时间
        template = template.replace("{release}", weather.getLastUpdate());
        //一句话
        template = template.replace("{words}", words);
        return template;
    }

    private String readMarkDow() {
        try {
            final File file = ResourceUtils.getFile("classpath:templates/morningPost.md");
            return FileUtils.readFileToString(file, StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            log.error("【boostService】读取文件失败", e);
            throw BaseException.of(ExceptionEnum.INTERNAL_ERROR);
        }
    }
}
