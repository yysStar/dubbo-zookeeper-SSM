package com.qiyun.service;

import com.github.pagehelper.PageInfo;
import com.qiyun.DTO.LotteryBusinessDTO;
import com.qiyun.model.LotteryType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LotteryTypeService {
//    List<LotteryBusinessDTO> getLotteryBusinessList(int offset, int pageSize);

    PageInfo<LotteryBusinessDTO> getPageLotteryBusinessList(int offset, int pageSize);

    LotteryType getById(int typeId);

    void updateByPrimaryKeySelective(LotteryType lotteryType);
}
