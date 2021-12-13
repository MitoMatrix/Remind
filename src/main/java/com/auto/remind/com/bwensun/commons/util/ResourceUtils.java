package com.auto.remind.com.bwensun.commons.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 资源访问工具
 *
 * @author 郑建雄
 * @date 2021/12/13
 */
@Slf4j
public class ResourceUtils {

    private ResourceUtils() {
    }

    public static String readAsString(String path) {
        final ClassPathResource classPathResource = new ClassPathResource(path);
        final InputStream inputStream;
        try {
            inputStream = classPathResource.getInputStream();
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            log.error("【ResourceUtils-readresString】 读取文件异常", e);
        }
        return "";
    }
}
