package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.DTO.TicketOperationLineSearch;
import com.qiyun.mapper2.TicketOperationLineMapper;
import com.qiyun.model2.TicketOperationLine;
import com.qiyun.model2.TicketOperationLineQuery;
import com.qiyun.service.TicketOperationLineService;
import com.qiyun.type.TicketUserTransType;
import com.qiyun.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TicketOperationLineServiceImpl implements TicketOperationLineService {

    @Autowired
    private TicketOperationLineMapper ticketOperationLineMapper;

    public void add(String account, TicketUserTransType transType, BigDecimal amount, int ticketId, String ticketApparatusId, BigDecimal ticketApparatusAbleBalance,String remark,int ticketCount) {
        TicketOperationLine ticketOperationLine = new TicketOperationLine();
        ticketOperationLine.setAccount(account);
        ticketOperationLine.setCreateTime(new Date());
        ticketOperationLine.setTransType(transType.getValue());
        ticketOperationLine.setAmount(amount);
        ticketOperationLine.setTicketId(ticketId);
        ticketOperationLine.setTicketApparatusId(ticketApparatusId);
        ticketOperationLine.setTicketApparatusAbleBalance(ticketApparatusAbleBalance);
        ticketOperationLine.setRemark(remark);
        ticketOperationLine.setTicketCount(ticketCount);
        ticketOperationLineMapper.insertSelective(ticketOperationLine);
    }

    public List<Map> getSumTicketCountByTypeAndDateGroupByDate(String startTimeStr, String endTimeStr,  int type) {
        return ticketOperationLineMapper.getSumTicketCountByTypeAndDateGroupByDate(startTimeStr,endTimeStr,type);
    }

    public List<Map> getSumAmountByTypeAndDateGroupByDate(String startTimeStr, String endTimeStr, int type) {
        return ticketOperationLineMapper.getSumAmountByTypeAndDateGroupByDate(startTimeStr,endTimeStr,type);
    }

    public List<Map> getSumAmountByTypeAndDateAndAccountGroupByDate(String startTimeStr, String endTimeStr, String account, int type) {
        return ticketOperationLineMapper.getSumAmountByTypeAndDateAndAccountGroupByDate(startTimeStr,endTimeStr,account,type);
    }

    public List<Map> getSumTicketCountByTypeAndDateAndAccountGroupByDate(String startTimeStr, String endTimeStr, String account, int type) {
        return ticketOperationLineMapper.getSumTicketCountByTypeAndDateAndAccountGroupByDate(startTimeStr,endTimeStr,account,type);
    }

    public BigDecimal getSumAmountByTypeAndDate(String startTimeStr, String endTimeStr, int value,String account) {
        return ticketOperationLineMapper.getSumAmountByTypeAndDate(startTimeStr,endTimeStr,value,account);
    }

    public Integer getSumTicketCountByTypeAndDate(String startTimeStr, String endTimeStr, int value,String account) {
        return ticketOperationLineMapper.getSumTicketCountByTypeAndDate(startTimeStr,endTimeStr,value,account);
    }

    @Override
    public List<TicketOperationLine> ticketOperationLineSearch(TicketOperationLineSearch search) {
        TicketOperationLineQuery ticketOperationLineQuery = new TicketOperationLineQuery();
        TicketOperationLineQuery.Criteria criteria = ticketOperationLineQuery.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!StringUtils.isNullOrBlank(search.getAccount())){
            criteria.andAccountEqualTo(search.getAccount());
        }
        if (!StringUtils.isNullOrBlank(search.getTicketApparatusId())){
            criteria.andTicketApparatusIdEqualTo(search.getTicketApparatusId());
        }
        if (search.getStartAmount()!=null){
            criteria.andAmountGreaterThanOrEqualTo(search.getStartAmount());
        }
        if (search.getEndAmount()!=null){
            criteria.andAmountGreaterThanOrEqualTo(search.getEndAmount());
        }
        if (search.getTransType()!=null){
            criteria.andTransTypeEqualTo(search.getTransType());
        }
        if (!StringUtils.isNullOrBlank(search.getStartCreateTime())){
            try {
                criteria.andCreateTimeGreaterThanOrEqualTo(sdf.parse(search.getStartCreateTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!StringUtils.isNullOrBlank(search.getEndCreateTime())){
            try {
                criteria.andCreateTimeLessThanOrEqualTo(sdf.parse(search.getEndCreateTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ticketOperationLineQuery.setOrderByClause("create_time desc");
        PageHelper.startPage(search.getPage(),search.getPageSize());
        List<TicketOperationLine> ticketOperationLines = ticketOperationLineMapper.selectByExample(ticketOperationLineQuery);
        return ticketOperationLines;
    }

    @Override
    public Integer ticketOperationLineSearchCount(TicketOperationLineSearch search) {
        TicketOperationLineQuery ticketOperationLineQuery = new TicketOperationLineQuery();
        TicketOperationLineQuery.Criteria criteria = ticketOperationLineQuery.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!StringUtils.isNullOrBlank(search.getAccount())){
            criteria.andAccountEqualTo(search.getAccount());
        }
        if (!StringUtils.isNullOrBlank(search.getTicketApparatusId())){
            criteria.andTicketApparatusIdEqualTo(search.getTicketApparatusId());
        }
        if (search.getStartAmount()!=null){
            criteria.andAmountGreaterThanOrEqualTo(search.getStartAmount());
        }
        if (search.getEndAmount()!=null){
            criteria.andAmountGreaterThanOrEqualTo(search.getEndAmount());
        }
        if (search.getTransType()!=null){
            criteria.andTransTypeEqualTo(search.getTransType());
        }
        if (!StringUtils.isNullOrBlank(search.getStartCreateTime())){
            try {
                criteria.andCreateTimeGreaterThanOrEqualTo(sdf.parse(search.getStartCreateTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!StringUtils.isNullOrBlank(search.getEndCreateTime())){
            try {
                criteria.andCreateTimeLessThanOrEqualTo(sdf.parse(search.getEndCreateTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return ticketOperationLineMapper.countByExample(ticketOperationLineQuery);
    }


}
