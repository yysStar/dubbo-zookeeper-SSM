package com.qiyun.mapper;

import com.qiyun.model.PayChannel;
import com.qiyun.model.PayChannelQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayChannelMapper {
    int countByExample(PayChannelQuery example);

    int deleteByExample(PayChannelQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayChannel record);

    int insertSelective(PayChannel record);

    List<PayChannel> selectByExample(PayChannelQuery example);

    PayChannel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayChannel record, @Param("example") PayChannelQuery example);

    int updateByExample(@Param("record") PayChannel record, @Param("example") PayChannelQuery example);

    int updateByPrimaryKeySelective(PayChannel record);

    int updateByPrimaryKey(PayChannel record);
}