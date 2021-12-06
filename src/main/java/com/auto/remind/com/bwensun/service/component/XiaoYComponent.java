package com.auto.remind.com.bwensun.service.component;

import com.auto.remind.com.bwensun.commons.exception.RpcException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * 小Y API调用组件
 *
 * @author 郑建雄
 * @date 2021/11/23
 */
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel", "unused"})
@Slf4j
@Component
public class XiaoYComponent {

    public static final String LICK_DOG = "https://api.ixiaowai.cn/tgrj/index.php";

    public static final String COVER = "https://picsum.photos";

    public static final String RANDOM_SENTENCE = "https://api.ixiaowai.cn/ylapi/index.php/";

    public static final String Y_COVER = "https://api.ixiaowai.cn/gqapi/gqapi.php";


    public String lickDogWords() {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(LICK_DOG))
                .GET()
                .build();
        try {
            final HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            throw new RpcException();
        }
    }

    public String conver() {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Y_COVER))
                .GET()
                .build();
        try {
            final HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.headers().firstValue("location").orElseThrow(
                    RpcException::new
            );
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            throw new RpcException();
        }
    }

    public String randomSentence() {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(RANDOM_SENTENCE))
                .GET()
                .build();
        try {
            final HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            throw new RpcException();
        }
    }
}
