package com.qiyun.service;

import com.qiyun.dto.WithdrawCashDTO;
import com.qiyun.model2.MemberClouds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberCloudsService {
    MemberClouds getByAccount(String account);

    int update(MemberClouds memberClouds);

    int insertSelective(MemberClouds memberClouds);

    /**
     * 提现列表
     * @return
     * @param offset
     * @param pageSize
     */
    List<WithdrawCashDTO> getCashList(int offset, int pageSize);

    /**
     * 判断该账户是否具有快速审核的资格
     * @param account
     * @return
     */
    int isFast(String account);

    /**
     * 获取该账户可用云朵数
     * @param account
     * @return
     */
    Integer getClounds(String account);

    /**
     * 快速审核
     * @param account
     * @return
     */
    int QuickReview(String account);
}
