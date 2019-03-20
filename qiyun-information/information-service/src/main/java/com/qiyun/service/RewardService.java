package com.qiyun.service;

import com.qiyun.dto.RewarderDTO;
import com.qiyun.model2.MemberRewardMapping;

import java.util.List;

public interface RewardService {
    /**
     * 获取打赏者的列表
     * @param beRewarderId 被打赏人的账户
     * @return 打赏列表
     */
    List<MemberRewardMapping> getRewarder(String beRewarderId);

    /**
     * 点击打赏时调用的方法
     * @param cloud 打赏云朵的数量
     * @param beRewarderId  被打赏人的账户
     * @param rewarderId    打赏人的账户
     * @return  打赏的结果
     */
    Integer Reward(int cloud,String beRewarderId,String rewarderId);
}
