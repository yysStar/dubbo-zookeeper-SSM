package com.qiyun.dto;

import com.qiyun.model2.ChampionPlanMatch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChampionPlanMatchDTO extends ChampionPlanMatch {
    private String teamName;
}
