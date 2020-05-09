package com.qiyun.mapper2;

import com.qiyun.model2.MemberFollowMapping2;
import com.qiyun.model2.MemberFollowMapping2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberFollowMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberFollowMapping2 record);

    int insertSelective(MemberFollowMapping2 record);

    List<MemberFollowMapping2> selectByExample(MemberFollowMapping2Example example);

    MemberFollowMapping2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberFollowMapping2 record);

    int updateByPrimaryKey(MemberFollowMapping2 record);

    MemberFollowMapping2 getByFansAccount(@Param("account") String account, @Param("fansAccount") String fansAccount);
}