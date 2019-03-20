package com.qiyun.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BuyRecordDTO {
    /**
     * 头像
     */
    private String picture;
    /**
     * 昵称
     */
    private String userName;
    /**
     * 近期战绩
     */
    private String Record;
    /**
     * 赛事列表
     */
    private List<RecommendMatchMappingDTO> matchList;

}
