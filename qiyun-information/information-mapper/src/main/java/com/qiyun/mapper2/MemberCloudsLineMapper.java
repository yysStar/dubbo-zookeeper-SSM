package com.qiyun.mapper2;

import com.qiyun.model2.MemberCloudsLine;
import com.qiyun.model2.MemberCloudsLineExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface MemberCloudsLineMapper {
    int deleteByPrimaryKey(Integer walletLineNo);

    int insert(MemberCloudsLine record);

    int insertSelective(MemberCloudsLine record);

    List<MemberCloudsLine> selectByExampleWithBLOBs(MemberCloudsLineExample example);

    List<MemberCloudsLine> selectByExample(MemberCloudsLineExample example);

    MemberCloudsLine selectByPrimaryKey(Integer walletLineNo);

    int updateByPrimaryKeySelective(MemberCloudsLine record);

    int updateByPrimaryKeyWithBLOBs(MemberCloudsLine record);

    int updateByPrimaryKey(MemberCloudsLine record);

    List<MemberCloudsLine> selectCloudList(String account);

    List<MemberCloudsLine> getWithdrawList(@Param("account")String account,@Param("num") int num);

    List<MemberCloudsLine> selectShouCloudList(String account);

    List<MemberCloudsLine> selectZhiCloudList(String account);

    int getIdByAccount(String account);
}