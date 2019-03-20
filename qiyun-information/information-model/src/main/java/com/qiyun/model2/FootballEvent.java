package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FootballEvent implements Serializable {
    private Integer scheduleId;

    private String mark;

    private String type;

    private String time;

    private String name;

    private String qId;

    private String gName;

    private String version;

}