package com.qiyun.service.Impl;

import com.qiyun.dto.MemberAgent2DTO;
import com.qiyun.mapper.MemberAgentMapper;
import com.qiyun.mapper2.MemberAgent2Mapper;
import com.qiyun.model2.MemberAgent2;
import com.qiyun.model2.MemberAgent2Query;
import com.qiyun.service.MemberAgentService;
import com.qiyun.util.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberAgentServiceImpl implements MemberAgentService {

    private static Logger logger = LoggerFactory.getLogger(MemberAgentServiceImpl.class);

    @Resource
    private MemberAgentMapper memberAgentMapper;

    @Resource
    private MemberAgent2Mapper memberAgent2Mapper;

    public MemberAgent2DTO getByAccount(String account) {
        try {
            MemberAgent2Query memberAgent2Query = new MemberAgent2Query();
            MemberAgent2Query.Criteria criteria = memberAgent2Query.createCriteria();
            criteria.andAccountEqualTo(account);
            List<MemberAgent2> memberAgent2s = memberAgent2Mapper.selectByExample(memberAgent2Query);
            if (memberAgent2s==null || memberAgent2s.size()<=0){
                return null;
            }

            MemberAgent2DTO memberAgent2DTO = new MemberAgent2DTO();
            CopyUtils.Copy(memberAgent2DTO,memberAgent2s.get(0),true);
            return memberAgent2DTO;
        }catch (Exception e){
            logger.error("根据account查询memberAgent出错",e);
            return null;
        }
    }
}
