package com.qiyun.mapper2;

import com.qiyun.dto.Member2DTO;

import java.util.Date;
import java.util.Map;

public interface MasterMapper {
    String findClouds(Member2DTO member2DTO);

    Map findIsCelebrity(Member2DTO member2DTO);

    void celebrityBeginTask(Map map);

    int getPeriodsNnum(Map map);

    Date getMaxTime(Member2DTO member2DTO);
}
