package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.MemberTaskBeginDTO;
import com.qiyun.mapper2.MemberTaskBeginMapper;
import com.qiyun.model2.MemberTaskBegin;
import com.qiyun.service.MemberTaskBeginService;
import com.qiyun.mapper2.FastMappingMapper;
import com.qiyun.model2.FastMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("memberTaskBeginService")
public class MemberTaskBeginServiceImpl implements MemberTaskBeginService {
    @Resource
    private MemberTaskBeginMapper memberTaskBeginMapper;

    @Autowired
    private FastMappingMapper fastMappingMapper;

    public MemberTaskBegin getNowTask(String account) {
        return memberTaskBeginMapper.selectNowTask(account);
    }

    public int update(MemberTaskBegin memberTaskBegin) {
        return memberTaskBeginMapper.updateByPrimaryKeySelective(memberTaskBegin);
    }

    public List<MemberTaskBeginDTO> getAll(String account, int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return memberTaskBeginMapper.selectAll(account);
    }

    public MemberTaskBegin getById(Integer taskId) {
        return memberTaskBeginMapper.selectByPrimaryKey(taskId);
    }

    public MemberTaskBeginDTO getNowTaskAndPlan(String account) {
        return memberTaskBeginMapper.selectNowTaskAndPlan(account);
    }

    public int  setFast(String phone,String account){
        FastMapping build = FastMapping.builder().account(account).phone(phone).changeDatetime(new Date()).build();
        int insert = fastMappingMapper.insert(build);
        return insert;
    }

    public String getPhone(){
        return fastMappingMapper.getPhone();
    }
}
