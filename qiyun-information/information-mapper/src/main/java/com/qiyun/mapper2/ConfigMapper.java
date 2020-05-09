package com.qiyun.mapper2;

import com.qiyun.model2.Config;
import com.qiyun.model2.ConfigExample;
import java.util.List;

public interface ConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Config record);

    int insertSelective(Config record);

    List<Config> selectByExample(ConfigExample example);

    Config selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);

    int reviseSpSourse(Integer sp_source);

    int getSpSourse();
}