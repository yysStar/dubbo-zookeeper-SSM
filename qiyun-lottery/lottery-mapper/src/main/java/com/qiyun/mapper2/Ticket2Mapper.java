package com.qiyun.mapper2;

import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.model2.Ticket2;
import com.qiyun.model2.Ticket2Query;
import com.qiyun.model2.Ticket2WithBLOBs;

import java.util.Date;
import java.util.List;

import com.qiyun.model2.TicketFindNew2;
import org.apache.ibatis.annotations.Param;

public interface Ticket2Mapper {
    int countByExample(Ticket2Query example);

    int deleteByExample(Ticket2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ticket2WithBLOBs record);

    int insertSelective(Ticket2WithBLOBs record);

    List<Ticket2WithBLOBs> selectByExampleWithBLOBs(Ticket2Query example);

    List<Ticket2> selectByExample(Ticket2Query example);

    Ticket2WithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ticket2WithBLOBs record, @Param("example") Ticket2Query example);

    int updateByExampleWithBLOBs(@Param("record") Ticket2WithBLOBs record, @Param("example") Ticket2Query example);

    int updateByExample(@Param("record") Ticket2 record, @Param("example") Ticket2Query example);

    int updateByPrimaryKeySelective(Ticket2WithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(Ticket2WithBLOBs record);

    int updateByPrimaryKey(Ticket2 record);

    void updateTicketByPlanBack(Integer planNo);

    void updateStatusByPlanNo(Integer planNo, int status);

    void updateReturnPrize(Integer planNo);

    List<LotteryTerm> findPrintingTermByLotteryType(Integer lotType, Date nowDate);

    TicketFindNew2 getByCopyPlanNo(Integer planNo);

    void updateForSongPiaoSuccess(Integer planNo);

    void updateForSongPiaoFail(Integer planNo);
}