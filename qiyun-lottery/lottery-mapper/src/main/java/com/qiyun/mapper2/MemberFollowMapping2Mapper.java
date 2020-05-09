package com.qiyun.mapper2;

import com.qiyun.dto.MostPopularMemberDTO;
import com.qiyun.model2.MemberFollowMapping2;
import com.qiyun.model2.MemberFollowMapping2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberFollowMapping2Mapper {
    int countByExample(MemberFollowMapping2Query example);

    int deleteByExample(MemberFollowMapping2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberFollowMapping2 record);

    int insertSelective(MemberFollowMapping2 record);

    List<MemberFollowMapping2> selectByExample(MemberFollowMapping2Query example);

    MemberFollowMapping2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberFollowMapping2 record, @Param("example") MemberFollowMapping2Query example);

    int updateByExample(@Param("record") MemberFollowMapping2 record, @Param("example") MemberFollowMapping2Query example);

    int updateByPrimaryKeySelective(MemberFollowMapping2 record);

    int updateByPrimaryKey(MemberFollowMapping2 record);

    List<MostPopularMemberDTO> getMostPopular();
}