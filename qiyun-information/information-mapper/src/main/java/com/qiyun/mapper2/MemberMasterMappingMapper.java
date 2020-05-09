package com.qiyun.mapper2;

import com.qiyun.dto.MemberDTO;
import com.qiyun.model2.MemberCloudsLine;
import com.qiyun.model2.MemberMasterMapping;
import com.qiyun.model2.MemberMasterMappingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMasterMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberMasterMapping record);

    int insertSelective(MemberMasterMapping record);

    List<MemberMasterMapping> selectByExample(MemberMasterMappingExample example);

    MemberMasterMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberMasterMapping record);

    int updateByPrimaryKey(MemberMasterMapping record);

    MemberMasterMapping getByAccount(String account);

    List<MemberDTO> selectSearchList(String keywords);

    List<MemberDTO> selectMasterList();

    List<MemberDTO> selectHighGradeList();

    String getAccountByusername(String username);

    List<MemberCloudsLine> getRechargeList(@Param("account")String account, @Param("list")List<Integer>list,@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<MemberCloudsLine> getWithdrawList(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<MemberCloudsLine> getBuyRecommendList(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<MemberCloudsLine> getRecommendRefundList(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<MemberCloudsLine> getRewardList(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<MemberCloudsLine> getRecommendIncomeList(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<MemberCloudsLine> getRewardIncomeList(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<MemberCloudsLine> getQuickReviwList(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    List<String>getIds();

    List<String>getIds2(String account);

    Integer getCloud(String account);

    Integer getRechargeClound(@Param("list")List<Integer>list,@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    Integer getWithdrawClound(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    Integer getBuyRecommendClound(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    Integer getRecommendRefundClound(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    Integer getRewardClound(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    Integer getRecommendIncomeClound(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    Integer getRewardIncomeClound(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);

    Integer getQuickReviwClound(@Param("account")String account,@Param("startTime")String startTime,@Param("endTime")String endTime);
}