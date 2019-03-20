package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.DTO.TicketFindDTO;
import com.qiyun.mapper2.PlanTicketMappingMapper;
import com.qiyun.mapper.TicketFindMapper;
import com.qiyun.mapper2.LotteryPlanMapper;
import com.qiyun.mapper2.TicketFindNew2Mapper;
import com.qiyun.model.PlanTicketMapping;
import com.qiyun.model.TicketFind;
import com.qiyun.model2.LotteryPlanWithBLOBs;
import com.qiyun.model2.TicketFindNew2;
import com.qiyun.model2.TicketFindNew2Query;
import com.qiyun.service.TicketFindService;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ticketFindService")
public class TicketFindServiceImpl implements TicketFindService {

    @Resource
    private TicketFindNew2Mapper ticketFindNew2Mapper;
    @Resource
    private TicketFindMapper ticketFindMapper;
    @Resource
    private LotteryPlanMapper lotteryPlanMapper;
    @Resource
    private PlanTicketMappingMapper planTicketMappingMapper;

    public int insertSelective(TicketFind ticketFind) {
        return ticketFindMapper.insertSelective(ticketFind);
    }

    public TicketFind getByPlanNo(int planNo) {
        return ticketFindMapper.selectByPlanNo(planNo);
    }

    public PageInfo<TicketFindDTO> getAll(int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        List<TicketFindDTO> list = ticketFindMapper.selectAll();
        for(TicketFindDTO ticketFindDTO : list){
            LotteryPlanWithBLOBs lotteryPlanWithBLOBs =
                    lotteryPlanMapper.selectByPrimaryKey(ticketFindDTO.getPlanNo());
            ticketFindDTO.setCreateDateTime(lotteryPlanWithBLOBs.getCreateDateTime());
            ticketFindDTO.setAccount(lotteryPlanWithBLOBs.getAccount());
            ticketFindDTO.setPlanStatus(lotteryPlanWithBLOBs.getPlanStatus());
            List<PlanTicketMapping> ticketMappings =
                    planTicketMappingMapper.selectByPlanNo(ticketFindDTO.getPlanNo());
            if(ticketMappings.size() > 0) {
                ticketFindDTO.setIsDeliver(false);
            } else {
                ticketFindDTO.setIsDeliver(true);
            }
        }
        PageInfo page = new PageInfo(list);
        return page;
    }

    public int update(TicketFind ticket) {
        return ticketFindMapper.updateByPrimaryKeySelective(ticket);
    }

    public TicketFindNew2 getByPlanNoNew(int planNo) {
        TicketFindNew2Query ticketFindNew2Query = new TicketFindNew2Query();
        TicketFindNew2Query.Criteria criteria = ticketFindNew2Query.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        List<TicketFindNew2> ticketFindNew2s = ticketFindNew2Mapper.selectByExample(ticketFindNew2Query);
        if (ticketFindNew2s==null || ticketFindNew2s.size()<=0){
            return null;
        }
        return ticketFindNew2s.get(0);
    }

    public void insertSelectiveNew(TicketFindNew2 ticketFindNew2) {
        ticketFindNew2Mapper.insertSelective(ticketFindNew2);
    }

    public Map<String, Object> findTicketList2(int type, String account, int planNo, int page, int pageSize) {
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> reqMap = new HashMap<String,Object>();
        List<Map> list = null;
        PageHelper.startPage(page,pageSize);
        reqMap.put("account",account);
        reqMap.put("planNo",planNo);
        reqMap.put("type",type);
        list = ticketFindNew2Mapper.findTicketList(reqMap);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,new PageInfo<Map>(list));
        return map;
    }

    public TicketFindNew2 getByCopyPlanNo(int planNo) {
        TicketFindNew2Query ticketFindNew2Query = new TicketFindNew2Query();
        TicketFindNew2Query.Criteria criteria = ticketFindNew2Query.createCriteria();
        criteria.andCopyPlanNoEqualTo(planNo);
        List<TicketFindNew2> ticketFindNew2s = ticketFindNew2Mapper.selectByExample(ticketFindNew2Query);
        if (ticketFindNew2s==null || ticketFindNew2s.size()<=0){
            return null;
        }
        return ticketFindNew2s.get(0);
    }

    public void updateTicketStatus(TicketFindNew2 findNew) {
        ticketFindNew2Mapper.updateByPrimaryKeySelective(findNew);
    }

    public TicketFindNew2 getTicketFindNewByPlanNo(Integer planNo) {
        TicketFindNew2Query ticketFindNew2Query = new TicketFindNew2Query();
        TicketFindNew2Query.Criteria criteria = ticketFindNew2Query.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        List<TicketFindNew2> ticketFindNew2s = ticketFindNew2Mapper.selectByExample(ticketFindNew2Query);
        if (ticketFindNew2s==null || ticketFindNew2s.size()<=0){
            return null;
        }
        return ticketFindNew2s.get(0);
    }

    public void updateTicketFindNew(TicketFindNew2 ticketFindNew) {
        ticketFindNew2Mapper.updateByPrimaryKeySelective(ticketFindNew);
    }
}
