package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.DTO.TicketPrintSearch;
import com.qiyun.mapper2.TicketPrintMapper;
import com.qiyun.model2.TicketPrint;
import com.qiyun.model2.TicketPrintQuery;
import com.qiyun.service.TicketPrintService;
import com.qiyun.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TicketPrintServiceImpl implements TicketPrintService {

    @Autowired
    private TicketPrintMapper ticketPrintMapper;

    public TicketPrint orderReceiving() {
        TicketPrintQuery ticketPrintQuery = new TicketPrintQuery();
        TicketPrintQuery.Criteria criteria = ticketPrintQuery.createCriteria();
        criteria.andStatusEqualTo(0);
        criteria.andResidueCountGreaterThan(0);
        criteria.andDealTimeGreaterThan(new Date());
        ticketPrintQuery.setOrderByClause("weight DESC, deal_time DESC, amount DESC, bonus DESC, residue_count DESC, create_time ASC");
        List<TicketPrint> ticketPrints = ticketPrintMapper.selectByExample(ticketPrintQuery);
        if (ticketPrints==null || ticketPrints.size()<=0){
            return null;
        }
        return ticketPrints.get(0);
    }

    public void updateByPrimaryKeySelective(TicketPrint ticket) {
        ticketPrintMapper.updateByPrimaryKeySelective(ticket);
    }

    public TicketPrint getById(Integer ticketId) {
        return ticketPrintMapper.selectByPrimaryKey(ticketId);
    }

    public void insert(TicketPrint ticket) {
        ticketPrintMapper.insertSelective(ticket);
    }

    public List<TicketPrint> ticketPrintSearch(TicketPrintSearch search) {
        TicketPrintQuery ticketPrintQuery = new TicketPrintQuery();
        TicketPrintQuery.Criteria criteria = ticketPrintQuery.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (search.getId()!=null){
            criteria.andIdEqualTo(search.getId());
        }
        if (search.getPlanNo()!=null){
            criteria.andPlanNoEqualTo(search.getPlanNo());
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
        if (!StringUtils.isNullOrBlank(search.getStartDealTime())){
            try {
                criteria.andDealTimeGreaterThanOrEqualTo(sdf.parse(search.getStartDealTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!StringUtils.isNullOrBlank(search.getEndDealTime())){
            try {
                criteria.andDealTimeLessThanOrEqualTo(sdf.parse(search.getEndDealTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (search.getLotteryType()!=null){
            criteria.andLotteryTypeEqualTo(search.getLotteryType());
        }
        if (!StringUtils.isNullOrBlank(search.getPassType())){
            criteria.andPasstypeEqualTo(search.getPassType());
        }
        if (search.getStartAmount()!=null){
            criteria.andAmountGreaterThanOrEqualTo(search.getStartAmount());
        }
        if (search.getEndAmount()!=null){
            criteria.andAmountLessThanOrEqualTo(search.getEndAmount());
        }
        if (search.getStartMultiple()!=null){
            criteria.andMultipleGreaterThanOrEqualTo(search.getStartMultiple());
        }
        if (search.getEndMultiple()!=null){
            criteria.andMultipleLessThanOrEqualTo(search.getEndMultiple());
        }
        if (search.getStartBonus()!=null){
            criteria.andBonusGreaterThanOrEqualTo(search.getStartBonus());
        }
        if (search.getEndBonus()!=null){
            criteria.andBonusLessThanOrEqualTo(search.getEndBonus());
        }
        if (search.getStatus()!=null){
            criteria.andStatusEqualTo(search.getStatus());
        }
        if (search.getStartResidueCount()!=null){
            criteria.andResidueCountGreaterThanOrEqualTo(search.getStartResidueCount());
        }
        if (search.getEndResidueCount()!=null){
            criteria.andResidueCountLessThanOrEqualTo(search.getEndResidueCount());
        }
        if (search.getStartCount()!=null){
            criteria.andCountGreaterThanOrEqualTo(search.getStartCount());
        }
        if (search.getEndCount()!=null){
            criteria.andCountLessThanOrEqualTo(search.getEndCount());
        }
        if (!StringUtils.isNullOrBlank(search.getDlAccount())){
            criteria.andDlAccountEqualTo(search.getDlAccount());
        }
        if (!StringUtils.isNullOrBlank(search.getQdAccount())){
            criteria.andQdAccountEqualTo(search.getQdAccount());
        }
        PageHelper.startPage(search.getPage(),search.getPageSize());
        List<TicketPrint> list = ticketPrintMapper.selectByExample(ticketPrintQuery);
        return list;
    }

    public int countTicketPrintSearch(TicketPrintSearch search) {
        TicketPrintQuery ticketPrintQuery = new TicketPrintQuery();
        TicketPrintQuery.Criteria criteria = ticketPrintQuery.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (search.getId()!=null){
            criteria.andIdEqualTo(search.getId());
        }
        if (search.getPlanNo()!=null){
            criteria.andPlanNoEqualTo(search.getPlanNo());
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
        if (!StringUtils.isNullOrBlank(search.getStartDealTime())){
            try {
                criteria.andDealTimeGreaterThanOrEqualTo(sdf.parse(search.getStartDealTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!StringUtils.isNullOrBlank(search.getEndDealTime())){
            try {
                criteria.andDealTimeLessThanOrEqualTo(sdf.parse(search.getEndDealTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (search.getLotteryType()!=null){
            criteria.andLotteryTypeEqualTo(search.getLotteryType());
        }
        if (!StringUtils.isNullOrBlank(search.getPassType())){
            criteria.andPasstypeEqualTo(search.getPassType());
        }
        if (search.getStartAmount()!=null){
            criteria.andAmountGreaterThanOrEqualTo(search.getStartAmount());
        }
        if (search.getEndAmount()!=null){
            criteria.andAmountLessThanOrEqualTo(search.getEndAmount());
        }
        if (search.getStartMultiple()!=null){
            criteria.andMultipleGreaterThanOrEqualTo(search.getStartMultiple());
        }
        if (search.getEndMultiple()!=null){
            criteria.andMultipleLessThanOrEqualTo(search.getEndMultiple());
        }
        if (search.getStartBonus()!=null){
            criteria.andBonusGreaterThanOrEqualTo(search.getStartBonus());
        }
        if (search.getEndBonus()!=null){
            criteria.andBonusLessThanOrEqualTo(search.getEndBonus());
        }
        if (search.getStatus()!=null){
            criteria.andStatusEqualTo(search.getStatus());
        }
        if (search.getStartResidueCount()!=null){
            criteria.andResidueCountGreaterThanOrEqualTo(search.getStartResidueCount());
        }
        if (search.getEndResidueCount()!=null){
            criteria.andResidueCountLessThanOrEqualTo(search.getEndResidueCount());
        }
        if (search.getStartCount()!=null){
            criteria.andCountGreaterThanOrEqualTo(search.getStartCount());
        }
        if (search.getEndCount()!=null){
            criteria.andCountLessThanOrEqualTo(search.getEndCount());
        }
        if (!StringUtils.isNullOrBlank(search.getDlAccount())){
            criteria.andDlAccountEqualTo(search.getDlAccount());
        }
        if (!StringUtils.isNullOrBlank(search.getQdAccount())){
            criteria.andQdAccountEqualTo(search.getQdAccount());
        }
        int i = ticketPrintMapper.countByExample(ticketPrintQuery);
        return i;
    }

    @Override
    public List<TicketPrint> getByPlanNo(Integer planNo) {
        TicketPrintQuery ticketPrintQuery = new TicketPrintQuery();
        TicketPrintQuery.Criteria criteria = ticketPrintQuery.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        List<TicketPrint> ticketPrintList = ticketPrintMapper.selectByExample(ticketPrintQuery);
        return ticketPrintList;
    }

    @Override
    public List<TicketPrint> getByPrintAccount(String account, int page, int pageSize) {
        TicketPrintQuery ticketPrintQuery = new TicketPrintQuery();
        TicketPrintQuery.Criteria criteria = ticketPrintQuery.createCriteria();
        criteria.andPrintAccountEqualTo(account);
        ticketPrintQuery.setOrderByClause("push_time desc");
        PageHelper.startPage(page,pageSize);
        List<TicketPrint> ticketPrintList = ticketPrintMapper.selectByExample(ticketPrintQuery);
        return ticketPrintList;
    }

    @Override
    public Integer countByPrintAccount(String account) {
        TicketPrintQuery ticketPrintQuery = new TicketPrintQuery();
        TicketPrintQuery.Criteria criteria = ticketPrintQuery.createCriteria();
        criteria.andPrintAccountEqualTo(account);
        return ticketPrintMapper.countByExample(ticketPrintQuery);
    }

    @Override
    public List<Map> getTotalCountGroupByDealTime() {
        return ticketPrintMapper.getTotalCountGroupByDealTime();
    }

    @Override
    public List<Map> getCountByStatusGroupByDealTime(int i) {
        return ticketPrintMapper.getCountByStatusGroupByDealTime(i);
    }


}
