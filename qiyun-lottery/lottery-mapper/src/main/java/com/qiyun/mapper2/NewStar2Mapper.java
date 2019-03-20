package com.qiyun.mapper2;

import com.qiyun.model2.NewStar2;
import com.qiyun.model2.NewStar2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewStar2Mapper {
    int countByExample(NewStar2Query example);

    int deleteByExample(NewStar2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(NewStar2 record);

    int insertSelective(NewStar2 record);

    List<NewStar2> selectByExample(NewStar2Query example);

    NewStar2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NewStar2 record, @Param("example") NewStar2Query example);

    int updateByExample(@Param("record") NewStar2 record, @Param("example") NewStar2Query example);

    int updateByPrimaryKeySelective(NewStar2 record);

    int updateByPrimaryKey(NewStar2 record);

    Integer getZJCount(int dan,String account);

    Integer getTZCount(int dan,String account);
}