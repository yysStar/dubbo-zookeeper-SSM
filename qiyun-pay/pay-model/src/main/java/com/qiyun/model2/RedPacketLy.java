package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RedPacketLy implements Serializable {
    private Integer id;

    private Integer logId;

    private String content;

    private Date lyTime;

    private String spare;

}