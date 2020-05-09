package com.qiyun.mapper2;

import com.qiyun.dto.EvenTheRedMemberDTO;
import com.qiyun.dto.MemberForRedDTO;
import com.qiyun.model2.LotteryPlan2;
import com.qiyun.model2.LotteryPlanOrder2;
import com.qiyun.model2.LotteryPlanOrder2Query;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface LotteryPlanOrder2Mapper {
    int countByExample(LotteryPlanOrder2Query example);

    int deleteByExample(LotteryPlanOrder2Query example);

    int deleteByPrimaryKey(Integer orderNo);

    int insert(LotteryPlanOrder2 record);

    int insertSelective(LotteryPlanOrder2 record);

    List<LotteryPlanOrder2> selectByExample(LotteryPlanOrder2Query example);

    LotteryPlanOrder2 selectByPrimaryKey(Integer orderNo);

    int updateByExampleSelective(@Param("record") LotteryPlanOrder2 record, @Param("example") LotteryPlanOrder2Query example);

    int updateByExample(@Param("record") LotteryPlanOrder2 record, @Param("example") LotteryPlanOrder2Query example);

    int updateByPrimaryKeySelective(LotteryPlanOrder2 record);

    int updateByPrimaryKey(LotteryPlanOrder2 record);

    List<Map<String,Object>> getPlanForUserCenter(Map<String, Object> map);

    int countPlanForUserCenter(Map<String, Object> map);

    Integer getTRAmount(Map<String, Object> map);

    Double getZJAmount(Map<String, Object> map);

    LotteryPlanOrder2 getByPlanNo(Integer planNo);

    Double getWinAmount(String account);

    int getTZCountByAccount(String account);

    int getZJCountByAccount(String account);

    List<EvenTheRedMemberDTO> getEvenTheRedList(Date time);

    List<Map> getBetList(Date time);

    List<Map> getAShortRed(Date time);

    List<String> getGroupByAccount(Date time);

    Double getTotalAddPrizeByDay(String account);
}