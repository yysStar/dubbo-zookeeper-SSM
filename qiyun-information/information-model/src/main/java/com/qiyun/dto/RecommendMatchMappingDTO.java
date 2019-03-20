package com.qiyun.dto;

import com.qiyun.model2.RecommendMatchMapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RecommendMatchMappingDTO extends RecommendMatchMapping{
    /**
     * 周几
     */
    private int week;
    /**
     * 主队得分
     */
    private int homeScore;
    /**
     * 客队得分
     */
    private int guestScore;
}
