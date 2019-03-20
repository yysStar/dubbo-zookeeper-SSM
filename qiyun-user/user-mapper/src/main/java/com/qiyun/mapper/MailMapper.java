package com.qiyun.mapper;

import com.qiyun.model.Mail;
import com.qiyun.model.MailQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailMapper {
    int countByExample(MailQuery example);

    int deleteByExample(MailQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mail record);

    int insertSelective(Mail record);

    List<Mail> selectByExampleWithBLOBs(MailQuery example);

    List<Mail> selectByExample(MailQuery example);

    Mail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mail record, @Param("example") MailQuery example);

    int updateByExampleWithBLOBs(@Param("record") Mail record, @Param("example") MailQuery example);

    int updateByExample(@Param("record") Mail record, @Param("example") MailQuery example);

    int updateByPrimaryKeySelective(Mail record);

    int updateByPrimaryKeyWithBLOBs(Mail record);

    int updateByPrimaryKey(Mail record);
}