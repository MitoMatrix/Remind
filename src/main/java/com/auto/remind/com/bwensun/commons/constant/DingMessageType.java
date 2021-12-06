package com.auto.remind.com.bwensun.commons.constant;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * 钉钉消息类型
 *
 * @author 郑建雄
 * @date 2021/11/23
 */
public enum DingMessageType {


    /**
     * 未定义
     */
    UNDEFINED("undefined", "未定义"),

    /**
     * 简单消息
     */
    SIMPLE("simple", "简单消息"),

    /**
     * 链接风格
     */
    LINK("link", "链接风格"),

    /**
     * MD格式
     */
    MARKDOWN("markdown", "markdown风格");

    DingMessageType(String code, String meaning) {
        this.code = code;
        this.meaning = meaning;
    }

    public final String code;

    public final String meaning;

    public static DingMessageType getEnum(@NotNull String code) {
        return Arrays.stream(values()).filter(tag -> code.equals(tag.code)).findFirst().orElse(UNDEFINED);
    }

}
