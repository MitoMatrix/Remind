package com.auto.remind.com.bwensun.domain.dto.xinzhi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 描述
 *
 * @author 郑建雄
 * @date 2021/11/23
 */
@Data
public class Result {

    private Location location;

    private Now now;

    @JsonProperty("last_update")
    private String lastUpdate;
}
