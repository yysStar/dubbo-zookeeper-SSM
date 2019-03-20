package com.qiyun.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketballLiveExplain1 implements Serializable {

    private List<BasketballLiveExplain2> basketballExplain2;
}
