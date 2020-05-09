package com.qiyun.service;

import java.util.Map;

public interface ConfigService {
    Integer getLess5Auto();

    Integer getMore5Auto();

    Integer getChaiPiaoCount();

    void updateChaiPiaoCount(int count);
}
