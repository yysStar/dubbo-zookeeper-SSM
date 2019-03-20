package com.qiyun.mapper2;

import com.qiyun.dto.RewarderDTO;

import java.util.List;

public interface RewardMapper {

    //通过传入的被打赏者id去查询打赏者列表
    List<RewarderDTO> selectByReward(Integer id);



}
