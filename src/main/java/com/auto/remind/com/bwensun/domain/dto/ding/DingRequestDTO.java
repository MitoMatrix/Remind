package com.auto.remind.com.bwensun.domain.dto.ding;

import com.auto.remind.com.bwensun.commons.constant.DingMessageType;
import com.dingtalk.api.request.OapiRobotSendRequest;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 钉钉请求对象
 *
 * @author 郑建雄
 * @date 2021/11/22
 */
@Data
public class DingRequestDTO {

    /**
     * 目标的URL
     */
    private String url;

    /**
     * 消息类型
     */
    private DingMessageType msgType;

    /**
     * 是否通知所有人
     */
    private Boolean atAll;

    /**
     * 艾特人的电话号码
     */
    private List<String> atMobiles;

    /**
     * md相关
     */
    private OapiRobotSendRequest.Markdown markdown;

    /**
     * 简单文本
     */
    private OapiRobotSendRequest.Text text;

    /**
     * link相关
     */
    private OapiRobotSendRequest.Link link;

    public DingRequestDTO() {
        this.atAll = Boolean.FALSE;
    }
}
