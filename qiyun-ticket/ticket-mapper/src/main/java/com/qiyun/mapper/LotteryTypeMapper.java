package com.qiyun.mapper;

import com.qiyun.DTO.LotteryBusinessDTO;
import com.qiyun.model.LotteryType;
import com.qiyun.model.LotteryTypeExample;

import java.util.List;

public interface LotteryTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(LotteryType record);

    int insertSelective(LotteryType record);

    List<LotteryType> selectByExample(LotteryTypeExample example);

    LotteryType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LotteryType record);

    int updateByPrimaryKey(LotteryType record);

    /**
     * 获取彩票及其可用出票商列表
     * @return
     */
//    List<LotteryBusinessDTO> getLotteryBusinessList(@Param("offset") int offset, @Param("pageSize") int pageSize);
    List<LotteryBusinessDTO> getLotteryBusinessList();
}