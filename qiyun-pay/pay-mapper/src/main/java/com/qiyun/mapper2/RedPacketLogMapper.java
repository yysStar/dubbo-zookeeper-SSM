package com.qiyun.mapper2;

import com.qiyun.dto.GrabRedRacketDTO;
import com.qiyun.dto.MyTotalRedRacketDTO;
import com.qiyun.model2.RedPacketLog;
import com.qiyun.model2.RedPacketLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RedPacketLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RedPacketLog record);

    int insertSelective(RedPacketLog record);

    List<RedPacketLog> selectByExample(RedPacketLogExample example);

    RedPacketLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RedPacketLog record);

    int updateByPrimaryKey(RedPacketLog record);

    RedPacketLog selectByPacketId(@Param("redpacketId") int redpacketId, @Param("account") String account);

    List<GrabRedRacketDTO> selectAll();

    List<GrabRedRacketDTO> selectMyList(String account);

    MyTotalRedRacketDTO selectTotalMoney(String account);
}