package com.qiyun.mapper2;

import com.qiyun.model2.TicketPrint;
import com.qiyun.model2.TicketPrintQuery;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TicketPrintMapper {
    int countByExample(TicketPrintQuery example);

    int deleteByExample(TicketPrintQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketPrint record);

    int insertSelective(TicketPrint record);

    List<TicketPrint> selectByExampleWithBLOBs(TicketPrintQuery example);

    List<TicketPrint> selectByExample(TicketPrintQuery example);

    TicketPrint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketPrint record, @Param("example") TicketPrintQuery example);

    int updateByExampleWithBLOBs(@Param("record") TicketPrint record, @Param("example") TicketPrintQuery example);

    int updateByExample(@Param("record") TicketPrint record, @Param("example") TicketPrintQuery example);

    int updateByPrimaryKeySelective(TicketPrint record);

    int updateByPrimaryKeyWithBLOBs(TicketPrint record);

    int updateByPrimaryKey(TicketPrint record);

    List<Map> getTotalCountGroupByDealTime();

    List<Map> getCountByStatusGroupByDealTime(int i);
}