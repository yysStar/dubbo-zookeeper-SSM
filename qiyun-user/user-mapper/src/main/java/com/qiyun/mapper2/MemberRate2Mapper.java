package com.qiyun.mapper2;

import com.qiyun.model2.MemberRate2;
import com.qiyun.model2.MemberRate2Query;
import com.qiyun.model2.MemberRate2WithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface MemberRate2Mapper {
    int countByExample(MemberRate2Query example);

    int deleteByExample(MemberRate2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberRate2WithBLOBs record);

    int insertSelective(MemberRate2WithBLOBs record);

    List<MemberRate2WithBLOBs> selectByExampleWithBLOBs(MemberRate2Query example);

    List<MemberRate2> selectByExample(MemberRate2Query example);

    MemberRate2WithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberRate2WithBLOBs record, @Param("example") MemberRate2Query example);

    int updateByExampleWithBLOBs(@Param("record") MemberRate2WithBLOBs record, @Param("example") MemberRate2Query example);

    int updateByExample(@Param("record") MemberRate2 record, @Param("example") MemberRate2Query example);

    int updateByPrimaryKeySelective(MemberRate2WithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MemberRate2WithBLOBs record);

    int updateByPrimaryKey(MemberRate2 record);

    List<Map> getMemberRate(String account);

    List<Map> findAllRate(@Param(value = "account") String account);

    int delRateByAccount(@Param(value="account") String account, @Param(value = "lottery_type") Integer lottery_type);

    int updateRateByAccount(Map memberRate2);

    int cancelFD(String account);

}