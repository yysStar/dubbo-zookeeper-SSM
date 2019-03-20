package com.qiyun.mapper2;

import java.util.Map;

public interface ConfigMapper {
    Integer getLess5Auto();

    Integer getMore5Auto();

    Integer getChaiPiaoCount();

    void updateChaiPiaoCount(int count);
}
