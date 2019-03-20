package com.qiyun.dto;

import com.qiyun.model2.RecommendPlan;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RecommendPlanDTO extends RecommendPlan{
    /**
     * 头像
     */
    private String picture;
    /**
     * 昵称
     */
    private String userName;
    /**
     * 截止时间
     */
    private Date endTime;
    /**
     * 近俩周战绩
     */
    private String Record;
    /**
     * 中奖率（近两周）
     */
    private BigDecimal rateOfReturn;
    /**
     * 赛事列表
     */
    private List<RecommendMatchMappingDTO> matchList;
}
