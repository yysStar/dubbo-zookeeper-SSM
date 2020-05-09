package com.qiyun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FootballTechnic implements Serializable {

    //比赛ID
    private String id;

    //技术统计类型,主队技术统计,客队技术统计
    private String connect;

}
