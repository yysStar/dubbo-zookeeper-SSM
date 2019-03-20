package com.qiyun.mapper2;

import com.qiyun.model2.LotteryChaseTerm2;
import com.qiyun.model2.LotteryChaseTerm2Example;
import java.util.List;

public interface LotteryChaseTerm2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LotteryChaseTerm2 record);

    int insertSelective(LotteryChaseTerm2 record);

    List<LotteryChaseTerm2> selectByExample(LotteryChaseTerm2Example example);

    LotteryChaseTerm2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LotteryChaseTerm2 record);

    int updateByPrimaryKey(LotteryChaseTerm2 record);
}