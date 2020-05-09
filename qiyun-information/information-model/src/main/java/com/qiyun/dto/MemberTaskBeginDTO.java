package com.qiyun.dto;

import com.qiyun.model2.MemberTaskBegin;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 任务列表展示
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberTaskBeginDTO extends MemberTaskBegin {
    /**
     * 任务对应的推荐
     */
    private List<RecommendPlanDTO> planList;
}
