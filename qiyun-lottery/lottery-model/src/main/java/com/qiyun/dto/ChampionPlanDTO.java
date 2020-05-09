package com.qiyun.dto;

import com.qiyun.model2.ChampionPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChampionPlanDTO extends ChampionPlan {
    List<ChampionPlanMatchDTO> planMatchList;
}
