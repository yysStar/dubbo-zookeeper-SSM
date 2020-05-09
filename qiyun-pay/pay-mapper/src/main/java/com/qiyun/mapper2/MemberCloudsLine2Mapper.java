package com.qiyun.mapper2;

import com.qiyun.model2.MemberCloudsLine2;
import com.qiyun.model2.MemberCloudsLine2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberCloudsLine2Mapper {
    int countByExample(MemberCloudsLine2Query example);

    int deleteByExample(MemberCloudsLine2Query example);

    int deleteByPrimaryKey(Integer walletLineNo);

    int insert(MemberCloudsLine2 record);

    int insertSelective(MemberCloudsLine2 record);

    List<MemberCloudsLine2> selectByExampleWithBLOBs(MemberCloudsLine2Query example);

    List<MemberCloudsLine2> selectByExample(MemberCloudsLine2Query example);

    MemberCloudsLine2 selectByPrimaryKey(Integer walletLineNo);

    int updateByExampleSelective(@Param("record") MemberCloudsLine2 record, @Param("example") MemberCloudsLine2Query example);

    int updateByExampleWithBLOBs(@Param("record") MemberCloudsLine2 record, @Param("example") MemberCloudsLine2Query example);

    int updateByExample(@Param("record") MemberCloudsLine2 record, @Param("example") MemberCloudsLine2Query example);

    int updateByPrimaryKeySelective(MemberCloudsLine2 record);

    int updateByPrimaryKeyWithBLOBs(MemberCloudsLine2 record);

    int updateByPrimaryKey(MemberCloudsLine2 record);
}