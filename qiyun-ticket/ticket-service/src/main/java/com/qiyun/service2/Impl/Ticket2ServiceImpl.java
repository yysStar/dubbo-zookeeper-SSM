package com.qiyun.service2.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.DTO.PlayType;
import com.qiyun.mapper2.Ticket2Mapper;
import com.qiyun.model2.Ticket2;
import com.qiyun.model2.Ticket2Example;
import com.qiyun.model2.Ticket2WithBLOBs;

import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.mapper2.Ticket2Mapper;
import com.qiyun.model2.*;

import com.qiyun.service2.Ticket2Service;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import java.util.Map;

@Service("ticket2Service")
public class Ticket2ServiceImpl implements Ticket2Service {

    @Resource
    private Ticket2Mapper ticket2Mapper;

    public Map<String, Object> searchTicket(Integer type,Integer provider,String term,String startTerm,String endTerm,Integer id,Integer planNo,Integer playType,Integer isBingo,Integer status,String createDateTimeStart,String createDateTimeEnd,String printDateTimeStart,String printDateTimeEnd,String sendTicketDateTimeStart,String sendTicketDateTimeEnd,Integer offset,Integer pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
//        PageHelper.startPage(offset, pageSize);
        if(type==-1||type==-100){
            type=null;
        }
        if(provider==-1||provider==-100){
            provider=null;
        }
        if(id==-1||id==-100){
            id=null;
        }
        if(planNo==-1||planNo==-100){
            planNo=null;
        }
        if(playType==-1||playType==-100){
            playType=null;
        }
        if(isBingo==-1||isBingo==-100){
            isBingo=null;
        }
        if(status==-1||status==-100){
            status=null;
        }
        try{
            offset = offset-1;
            offset = offset * pageSize;
            List<Ticket2WithBLOBs> ticket2WithBLOBs = ticket2Mapper.searchTicket(type, provider, term, startTerm, endTerm, id, planNo, playType, isBingo, status, createDateTimeStart, createDateTimeEnd, printDateTimeStart, printDateTimeEnd, sendTicketDateTimeStart, sendTicketDateTimeEnd,offset,pageSize);
        for (Ticket2WithBLOBs ticket2WithBLOB:ticket2WithBLOBs) {
            ticket2WithBLOB.setFhPlayType(PlayType.getItem(ticket2WithBLOB.getPlayType()).getName());
        }
            Integer integer = ticket2Mapper.searchAmount(type, provider, term, startTerm, endTerm, id, planNo, playType, isBingo, status, createDateTimeStart, createDateTimeEnd, printDateTimeStart, printDateTimeEnd, sendTicketDateTimeStart, sendTicketDateTimeEnd);
            Integer integer1 = ticket2Mapper.searchBingoAmount(type, provider, term, startTerm, endTerm, id, planNo, playType, isBingo, status, createDateTimeStart, createDateTimeEnd, printDateTimeStart, printDateTimeEnd, sendTicketDateTimeStart, sendTicketDateTimeEnd);
            Integer count = ticket2Mapper.getCount();
            double ceil = Math.ceil(count/pageSize);
//            PageInfo<Ticket2WithBLOBs> ticket2WithBLOBsPageInfo = new PageInfo<Ticket2WithBLOBs>();
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,ticket2WithBLOBs);
            map.put("amount", integer);
            map.put("bingoAmount", integer1);
            map.put("count",ceil);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_2);
            return map;
        }
    }

    public int insertSelective(Ticket2WithBLOBs record) {
        return ticket2Mapper.insertSelective(record);
    }

    public Ticket2WithBLOBs getById(int ticketId) {
        return ticket2Mapper.selectByPrimaryKey(ticketId);
    }

    public List<Ticket2WithBLOBs> getByPlanNo(Integer planNo) {
        return ticket2Mapper.selectByPlanNo(planNo);
    }

    public int update(Ticket2WithBLOBs ticket2) {
        return ticket2Mapper.updateByPrimaryKeySelective(ticket2);
    }

    public LotteryTerm findPrintingTermByLotteryType(Integer lotType) {
        Calendar calendar = Calendar.getInstance();

           /* calendar.add(Calendar.SECOND, -20);//延迟20秒*/

        Date nowDate = calendar.getTime();

        return ticket2Mapper.findPrintingTermByLotteryType(lotType,nowDate).get(0);
    }

    public List<Ticket2> findTicketByPlanNo(Integer planNo) {
        Ticket2Example ticket2Example = new Ticket2Example();
        Ticket2Example.Criteria criteria = ticket2Example.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        criteria.andStatusEqualTo(3);//"未确认"
        return ticket2Mapper.selectByExample(ticket2Example);
    }

    public int countTicketNotSuccess(Integer planNo) {
        Ticket2Example ticket2Example = new Ticket2Example();
        Ticket2Example.Criteria criteria = ticket2Example.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        criteria.andStatusNotEqualTo(4);
        return ticket2Mapper.selectByExample(ticket2Example).size();
    }

    public TicketFindNew2 getByCopyPlanNo(Integer planNo) {

        return  ticket2Mapper.getByCopyPlanNo(planNo);
    }

    public List<Ticket2> findByOutId(String orderId) {
        Ticket2Example ticket2Example = new Ticket2Example();
        Ticket2Example.Criteria criteria = ticket2Example.createCriteria();
        criteria.andOutIdEqualTo(orderId);
        return ticket2Mapper.selectByExample(ticket2Example);
    }

    public void updateSuccess(Ticket2 ticket2) {
        ticket2Mapper.updateByPrimaryKey(ticket2);
    }

    public int getFailCount(LotteryPlan lotteryPlan) {
        Ticket2Example ticket2Example = new Ticket2Example();
        Ticket2Example.Criteria criteria = ticket2Example.createCriteria();
        criteria.andPlanNoEqualTo(lotteryPlan.getPlanNo());
        criteria.andStatusEqualTo(5);
        return ticket2Mapper.selectByExample(ticket2Example).size();
    }
    public void updateTicketByPlanBack(Integer planNo) {

        ticket2Mapper.updateTicketByPlanBack(planNo);
    }

    public int getTicketCount(LotteryPlan lotteryPlan) {

            Ticket2Example ticket2Example  = new Ticket2Example();
            Ticket2Example.Criteria criteria = ticket2Example.createCriteria();
            criteria.andPlanNoEqualTo(lotteryPlan.getPlanNo());
        List<Ticket2> ticket2s = ticket2Mapper.selectByExample(ticket2Example);
        return ticket2s.size();

    }

    public void updateForSongPiaoSuccess(Integer planNo) {
        ticket2Mapper.updateForSongPiaoSuccess(planNo);
    }

    public void updateForSongPiaoFail(Integer planNo) {
        ticket2Mapper.updateForSongPiaoFail(planNo);
    }

    public void updateTicketStatusForSongPiao(String ordersID,int status) {
        ticket2Mapper.updateTicketStatusForSongPiao(ordersID,status);
    }
}
