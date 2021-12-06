package com.auto.remind.com.bwensun.service.component;

import com.alibaba.fastjson.JSON;
import com.auto.remind.com.bwensun.commons.constant.DingMessageType;
import com.auto.remind.com.bwensun.commons.exception.BizException;
import com.auto.remind.com.bwensun.commons.exception.ExceptionEnum;
import com.auto.remind.com.bwensun.commons.util.DingEncoder;
import com.auto.remind.com.bwensun.domain.dto.ding.DingRequestDTO;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 钉钉调用组件
 *
 * @author 郑建雄
 * @date 2021/11/22
 */
@Component
@Slf4j
public class DingComponent {

    public static final String URL = "https://oapi.dingtalk.com/robot/send?access_token=5de3cd0d4c2a9d300b1da08ac46626279be362ac0a8e7795e0223f5a08d1f51f";

    /**
     * 获取DingTalkClient
     */
    private static DingTalkClient getDingTalkClient(DingRequestDTO param) {
        final String encode = DingEncoder.encode();
        return new DefaultDingTalkClient(param.getUrl().concat(encode));
    }

    public void doSend(DingRequestDTO param) {
        //获取一个client
        DingTalkClient client = getDingTalkClient(param);
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        //设置at属性
        setRequestAt(request, param);
        //设置消息内容
        setRequestMsg(request, param);
        //发送消息
        try {
            log.info("【OapiRobot】开始执行OapiRobot调用，request:{}", JSON.toJSONString(request));
            OapiRobotSendResponse response = client.execute(request);
            log.info("【OapiRobot】结束执行OapiRobot调用，response:{}", JSON.toJSONString(response));
        } catch (Exception e) {
            log.error("【OapiRobot】调用异常", e);
        }
    }

    /**
     * 设置at属性
     */
    private void setRequestAt(OapiRobotSendRequest request, DingRequestDTO param) {
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(param.getAtMobiles());
        at.setIsAtAll(param.getAtAll());
        request.setAt(at);
    }

    /**
     * 设置消息属性
     */
    private void setRequestMsg(OapiRobotSendRequest request, DingRequestDTO param) {
        switch (param.getMsgType()) {
            case SIMPLE:
                request.setMsgtype(DingMessageType.SIMPLE.code);
                request.setText(param.getText());
                break;
            case LINK:
                request.setMsgtype(DingMessageType.LINK.code);
                request.setLink(param.getLink());
                break;
            case MARKDOWN:
                request.setMsgtype(DingMessageType.MARKDOWN.code);
                request.setMarkdown(param.getMarkdown());
                break;
            default:
                throw BizException.of(ExceptionEnum.INTERNAL_ERROR);
        }
    }
}
