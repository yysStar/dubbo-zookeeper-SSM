package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.mapper2.TicketUserMapper;
import com.qiyun.model2.TicketUser;
import com.qiyun.model2.TicketUserQuery;
import com.qiyun.service.TicketUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketUserServiceImpl implements TicketUserService {

    @Autowired
    private TicketUserMapper ticketUserMapper;

    public TicketUser getByAccount(String account) {
        TicketUserQuery ticketUserQuery = new TicketUserQuery();
        TicketUserQuery.Criteria criteria = ticketUserQuery.createCriteria();
        criteria.andAccountEqualTo(account);
        List<TicketUser> ticketUsers = ticketUserMapper.selectByExample(ticketUserQuery);
        if (ticketUsers==null || ticketUsers.size()<=0){
            return null;
        }
        return ticketUsers.get(0);
    }

    public void add(TicketUser user) {
        ticketUserMapper.insertSelective(user);
    }

    public void updateByPrimaryKeySelective(TicketUser ticketUser) {
        ticketUserMapper.updateByPrimaryKeySelective(ticketUser);
    }

    public List<TicketUser> getByStatus(int i) {
        TicketUserQuery ticketUserQuery = new TicketUserQuery();
        TicketUserQuery.Criteria criteria = ticketUserQuery.createCriteria();
        criteria.andStatusEqualTo(i);
        List<TicketUser> ticketUsers = ticketUserMapper.selectByExample(ticketUserQuery);
        return ticketUsers;
    }

    public List<TicketUser> getByStatusAndPage(int i, int page, int pageSize) {
        TicketUserQuery ticketUserQuery = new TicketUserQuery();
        TicketUserQuery.Criteria criteria = ticketUserQuery.createCriteria();
        criteria.andStatusEqualTo(i);
        PageHelper.startPage(page,pageSize);
        List<TicketUser> ticketUsers = ticketUserMapper.selectByExample(ticketUserQuery);
        return ticketUsers;
    }

    public Integer getCountByStatus(int i) {
        TicketUserQuery ticketUserQuery = new TicketUserQuery();
        TicketUserQuery.Criteria criteria = ticketUserQuery.createCriteria();
        criteria.andStatusEqualTo(i);
        int count = ticketUserMapper.countByExample(ticketUserQuery);
        return count;
    }

}
