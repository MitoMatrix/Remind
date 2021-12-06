package com.auto.remind.com.bwensun.commons.util;

import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 钉钉加签服务
 *
 * @author 郑建雄
 */
public class DingEncoder {

    public static final String PATTERN = "&timestamp=%s&sign=%s";


    public static final String SECRET = "SEC30089a18213fa483b89f576257ff4787e8efe30b566aa5a05f600bb405b19df7";

    private DingEncoder() {
    }

    @SneakyThrows
    public static String encode() {
        Long timestamp = System.currentTimeMillis();
        String stringToSign = timestamp + "\n" + SECRET;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(SECRET.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), StandardCharsets.UTF_8);
        return String.format(PATTERN, timestamp, sign);
    }
}