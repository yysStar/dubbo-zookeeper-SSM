package com.qiyun.mapper2;

import com.qiyun.model2.AdminUser2;
import com.qiyun.model2.AdminUser2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminUser2Mapper {
    int countByExample(AdminUser2Query example);

    int deleteByExample(AdminUser2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminUser2 record);

    int insertSelective(AdminUser2 record);

    List<AdminUser2> selectByExample(AdminUser2Query example);

    AdminUser2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminUser2 record, @Param("example") AdminUser2Query example);

    int updateByExample(@Param("record") AdminUser2 record, @Param("example") AdminUser2Query example);

    int updateByPrimaryKeySelective(AdminUser2 record);

    int updateByPrimaryKey(AdminUser2 record);
}