package com.qiyun.mapper2;

import com.qiyun.model2.TicketOperationLine;
import com.qiyun.model2.TicketOperationLineQuery;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TicketOperationLineMapper {
    int countByExample(TicketOperationLineQuery example);

    int deleteByExample(TicketOperationLineQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketOperationLine record);

    int insertSelective(TicketOperationLine record);

    List<TicketOperationLine> selectByExample(TicketOperationLineQuery example);

    TicketOperationLine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketOperationLine record, @Param("example") TicketOperationLineQuery example);

    int updateByExample(@Param("record") TicketOperationLine record, @Param("example") TicketOperationLineQuery example);

    int updateByPrimaryKeySelective(TicketOperationLine record);

    int updateByPrimaryKey(TicketOperationLine record);

    List<Map> getSumTicketCountByTypeAndDateGroupByDate(String startTimeStr, String endTimeStr, int type);

    List<Map> getSumAmountByTypeAndDateGroupByDate(String startTimeStr, String endTimeStr,  int type);

    List<Map> getSumAmountByTypeAndDateAndAccountGroupByDate(String startTimeStr, String endTimeStr, String account, int type);

    List<Map> getSumTicketCountByTypeAndDateAndAccountGroupByDate(String startTimeStr, String endTimeStr, String account, int type);

    BigDecimal getSumAmountByTypeAndDate(String startTimeStr, String endTimeStr, int value, String account);

    Integer getSumTicketCountByTypeAndDate(String startTimeStr, String endTimeStr, int value, String account);
}