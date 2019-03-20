package com.qiyun.mapper2;


import com.qiyun.model2.Ticket2;
import com.qiyun.model2.Ticket2Example;
import com.qiyun.model2.Ticket2WithBLOBs;
import org.apache.ibatis.annotations.Param;


import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.model2.*;

import java.util.Date;

import java.util.List;

public interface Ticket2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ticket2WithBLOBs record);

    int insertSelective(Ticket2WithBLOBs record);

    List<Ticket2WithBLOBs> selectByExampleWithBLOBs(Ticket2Example example);

    List<Ticket2> selectByExample(Ticket2Example example);

    Ticket2WithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ticket2WithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(Ticket2WithBLOBs record);

    int updateByPrimaryKey(Ticket2 record);

    List<Ticket2WithBLOBs> selectByPlanNo(Integer planNo);


    List<Ticket2WithBLOBs>searchTicket(@Param("type") Integer type,@Param("provider")Integer provider,@Param("term")String term,@Param("startTerm")String startTerm,@Param("endTerm")String endTerm,@Param("id")Integer id,@Param("planNo")Integer planNo,@Param("playType")Integer playType,@Param("isBingo")Integer isBingo,@Param("status")Integer status,@Param("createDateTimeStart")String createDateTimeStart,@Param("createDateTimeEnd")String createDateTimeEnd,@Param("printDateTimeStart")String printDateTimeStart,@Param("printDateTimeEnd")String printDateTimeEnd,@Param("sendTicketDateTimeStart")String sendTicketDateTimeStart,@Param("sendTicketDateTimeEnd")String sendTicketDateTimeEnd,@Param("offset")Integer offset,@Param("pagesize")Integer pagesize);

    Integer searchAmount(@Param("type") Integer type,@Param("provider")Integer provider,@Param("term")String term,@Param("startTerm")String startTerm,@Param("endTerm")String endTerm,@Param("id")Integer id,@Param("planNo")Integer planNo,@Param("playType")Integer playType,@Param("isBingo")Integer isBingo,@Param("status")Integer status,@Param("createDateTimeStart")String createDateTimeStart,@Param("createDateTimeEnd")String createDateTimeEnd,@Param("printDateTimeStart")String printDateTimeStart,@Param("printDateTimeEnd")String printDateTimeEnd,@Param("sendTicketDateTimeStart")String sendTicketDateTimeStart,@Param("sendTicketDateTimeEnd")String sendTicketDateTimeEnd);

    Integer searchBingoAmount(@Param("type") Integer type,@Param("provider")Integer provider,@Param("term")String term,@Param("startTerm")String startTerm,@Param("endTerm")String endTerm,@Param("id")Integer id,@Param("planNo")Integer planNo,@Param("playType")Integer playType,@Param("isBingo")Integer isBingo,@Param("status")Integer status,@Param("createDateTimeStart")String createDateTimeStart,@Param("createDateTimeEnd")String createDateTimeEnd,@Param("printDateTimeStart")String printDateTimeStart,@Param("printDateTimeEnd")String printDateTimeEnd,@Param("sendTicketDateTimeStart")String sendTicketDateTimeStart,@Param("sendTicketDateTimeEnd")String sendTicketDateTimeEnd);


    List<LotteryTerm> findPrintingTermByLotteryType(Integer lotType, Date date);


    TicketFindNew2 getByCopyPlanNo(Integer planNo);

    void updateTicketByPlanBack(Integer planNo);

    void updateForSongPiaoSuccess(Integer planNo);

    void updateForSongPiaoFail(Integer planNo);

    void updateTicketStatusForSongPiao(String ordersID,int status);
    Integer getCount();
}