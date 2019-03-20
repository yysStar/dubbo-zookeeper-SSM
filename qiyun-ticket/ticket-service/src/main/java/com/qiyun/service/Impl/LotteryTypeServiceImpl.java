package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.DTO.LotteryBusinessDTO;
import com.qiyun.mapper.LotteryTypeMapper;
import com.qiyun.mapper2.LotteryType2Mapper;
import com.qiyun.model2.LotteryType2;
import com.qiyun.model.LotteryType;
import com.qiyun.service.LotteryTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("lotteryTypeService")
public class LotteryTypeServiceImpl implements LotteryTypeService {
    @Resource
    private LotteryTypeMapper lotteryTypeMapper;

    @Resource
    private LotteryType2Mapper lotteryType2Mapper;

//    public List<LotteryBusinessDTO> getLotteryBusinessList(int offset, int pageSize) {
//        List<LotteryBusinessDTO> list = lotteryTypeMapper.getLotteryBusinessList(offset, pageSize);
//        return list;
//    }

    public PageInfo<LotteryBusinessDTO> getPageLotteryBusinessList(int offset, int pageSize) {
        PageHelper.startPage(offset + 1, pageSize);
        List<LotteryBusinessDTO> list = lotteryTypeMapper.getLotteryBusinessList();
        PageInfo page = new PageInfo(list);
        return page;
    }

    public LotteryType getById(int typeId) {
        return lotteryTypeMapper.selectByPrimaryKey(typeId);
    }

    public void updateByPrimaryKeySelective(LotteryType lotteryType) {
        lotteryTypeMapper.updateByPrimaryKeySelective(lotteryType);
        //同步老库
        LotteryType2 lotteryType2 = lotteryType2Mapper.selectByPrimaryKey(lotteryType.getId());
        lotteryType2.setTicketId(lotteryType.getTicketId());
        lotteryType2Mapper.updateByPrimaryKeySelective(lotteryType2);
    }

}
