package com.qiyun.mapper2;

import com.qiyun.model2.WhiteForCert2;
import com.qiyun.model2.WhiteForCert2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WhiteForCert2Mapper {
    int countByExample(WhiteForCert2Query example);

    int deleteByExample(WhiteForCert2Query example);

    int deleteByPrimaryKey(String certNo);

    int insert(WhiteForCert2 record);

    int insertSelective(WhiteForCert2 record);

    List<WhiteForCert2> selectByExample(WhiteForCert2Query example);

    WhiteForCert2 selectByPrimaryKey(String certNo);

    int updateByExampleSelective(@Param("record") WhiteForCert2 record, @Param("example") WhiteForCert2Query example);

    int updateByExample(@Param("record") WhiteForCert2 record, @Param("example") WhiteForCert2Query example);

    int updateByPrimaryKeySelective(WhiteForCert2 record);

    int updateByPrimaryKey(WhiteForCert2 record);
}