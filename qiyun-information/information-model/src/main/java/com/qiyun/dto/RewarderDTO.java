package com.qiyun.dto;

import com.qiyun.model2.MemberRewardMapping;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class RewarderDTO {
    private List<MemberRewardMapping> Rewarders;
}
