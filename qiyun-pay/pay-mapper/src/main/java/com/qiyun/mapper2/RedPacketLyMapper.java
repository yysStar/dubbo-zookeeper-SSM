package com.qiyun.mapper2;

import com.qiyun.model2.RedPacketLy;
import com.qiyun.model2.RedPacketLyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RedPacketLyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RedPacketLy record);

    int insertSelective(RedPacketLy record);

    List<RedPacketLy> selectByExample(RedPacketLyExample example);

    RedPacketLy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RedPacketLy record);

    int updateByPrimaryKey(RedPacketLy record);

    String getLyById(Integer id);
}