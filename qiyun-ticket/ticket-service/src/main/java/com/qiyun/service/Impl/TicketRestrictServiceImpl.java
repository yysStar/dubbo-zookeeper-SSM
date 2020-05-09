package com.qiyun.service.Impl;

import com.qiyun.mapper.TicketRestrictMapper;
import com.qiyun.model.TicketRestrict;
import com.qiyun.service.TicketRestrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ticketRestrictService")
public class TicketRestrictServiceImpl implements TicketRestrictService {
    @Resource
    TicketRestrictMapper ticketRestrictMapper;

    /**
     * 获取有效的条件
     * @return
     */
    public TicketRestrict getByEffective() {
        return ticketRestrictMapper.selectByStatus();
    }

    public int updateByPrimaryKeySelective(TicketRestrict ticketRestrict) {
        return ticketRestrictMapper.updateByPrimaryKeySelective(ticketRestrict);
    }

    public int insertSelective(TicketRestrict restrict) {
        return ticketRestrictMapper.insertSelective(restrict);
    }

    public TicketRestrict getById(int id) {
        TicketRestrict ticketRestrict = ticketRestrictMapper.selectByPrimaryKey(id);
        if(ticketRestrict.getIsEffective()){
            return ticketRestrict;
        } else {
            return null;
        }
    }
}
