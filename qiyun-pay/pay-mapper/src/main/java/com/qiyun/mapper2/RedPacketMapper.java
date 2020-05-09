package com.qiyun.mapper2;

import com.qiyun.dto.MyTotalRedRacketDTO;
import com.qiyun.dto.PlanDTO;
import com.qiyun.dto.RedPacketDTO;
import com.qiyun.dto.RedPacketDetailsDTO;
import com.qiyun.model2.RedPacket;
import com.qiyun.model2.RedPacketExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RedPacketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RedPacket record);

    int insertSelective(RedPacket record);

    List<RedPacket> selectByExample(RedPacketExample example);

    RedPacket selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RedPacket record);

    int updateByPrimaryKey(RedPacket record);

    List<RedPacketDTO> selectAll();

    RedPacketDetailsDTO selectDetailsByPrimaryKey(int id);

    List<RedPacketDTO> selectByAccount(String account);

    MyTotalRedRacketDTO selectTotalMoney(String account);

    RedPacketDTO selectNowByAccount(String account);

    /**
     * 进行中订单
     * @param account
     * @param s
     * @return
     */
    List<PlanDTO> selectPlayingPlan(@Param("account")String account);

    /**
     * 中奖订单
     * @param account
     * @param s
     * @return
     */
    List<PlanDTO> selectBingoPlan(@Param("account")String account);

    int getJump(@Param("id")int id);

    String getAccount(@Param("id")int id);

    Integer getFollow(@Param("account")String account);

    int getAmount(@Param("planNo")int planNo);

    int getMultiple(@Param("planNo")int planNo);

    Integer getType(@Param("account")String account);

    Integer getCyMultiple(@Param("account")String account);

    Integer getRed(@Param("account")String account);

    String getUsername(@Param("account")String account);

    String getPICTURE(@Param("account")String account);

    Integer getCount(@Param("redPacketId")int redPacketId);

    Integer getNew();
}