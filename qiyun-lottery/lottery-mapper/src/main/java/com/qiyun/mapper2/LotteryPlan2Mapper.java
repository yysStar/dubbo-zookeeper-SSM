package com.qiyun.mapper2;

import com.qiyun.common.Result;
import com.qiyun.dto.EvenTheRedMemberDTO;
import com.qiyun.dto.LotteryPlan2DTO;
import com.qiyun.dto.Member2ForSumprize;
import com.qiyun.model2.LotteryPlan2;
import com.qiyun.model2.LotteryPlan2Query;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface LotteryPlan2Mapper {
    int countByExample(LotteryPlan2Query example);

    int deleteByExample(LotteryPlan2Query example);

    int deleteByPrimaryKey(Integer planNo);

    int insert(LotteryPlan2WithBLOBs record);

    int insertSelective(LotteryPlan2WithBLOBs record);

    List<LotteryPlan2WithBLOBs> selectByExampleWithBLOBs(LotteryPlan2Query example);

    List<LotteryPlan2> selectByExample(LotteryPlan2Query example);

    LotteryPlan2WithBLOBs selectByPrimaryKey(Integer planNo);

    int updateByExampleSelective(@Param("record") LotteryPlan2WithBLOBs record, @Param("example") LotteryPlan2Query example);

    int updateByExampleWithBLOBs(@Param("record") LotteryPlan2WithBLOBs record, @Param("example") LotteryPlan2Query example);

    int updateByExample(@Param("record") LotteryPlan2 record, @Param("example") LotteryPlan2Query example);

    int updateByPrimaryKeySelective(LotteryPlan2WithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LotteryPlan2WithBLOBs record);

    int updateByPrimaryKey(LotteryPlan2 record);

    LotteryPlan2WithBLOBs selectByPlanNo(int planNo);

    List<Member2ForSumprize> xyHall(Date time);

    List<LotteryPlan2WithBLOBs>  selectFootball(@Param("username")String username);

    List<LotteryPlan2WithBLOBs>  selectBasketball(@Param("username") String username);

    List<LotteryPlan2WithBLOBs>  selectAll(@Param("username") String username);

    List<Map> querySuperLotteryPlan(Map<String, Object> map);

    List<String> getSuperManAccount(String account);

    List<LotteryPlan2DTO> getSuperManPlan(List<String> superManAccounts);

    List<String> getGroupByAccount(Date time);
}