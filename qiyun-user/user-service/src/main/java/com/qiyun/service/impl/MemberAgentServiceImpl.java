package com.qiyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.common.Result;
import com.qiyun.dto.MemberAgent2DTO;
import com.qiyun.mapper.MemberAgentMapper;
import com.qiyun.mapper2.MemberAgent2Mapper;
import com.qiyun.model2.MemberAgent2;
import com.qiyun.model2.MemberAgent2Query;
import com.qiyun.service.MemberAgentService;
import com.qiyun.util.Constants;
import com.qiyun.util.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberAgentServiceImpl implements MemberAgentService {

    private static Logger logger = LoggerFactory.getLogger(MemberAgentServiceImpl.class);

    @Resource
    private MemberAgentMapper memberAgentMapper;

    @Resource
    private MemberAgent2Mapper memberAgent2Mapper;


    public Result getMemberAgent(Integer memberId) {
        Result result = new Result();
        try {
            MemberAgent2Query memberAgent2Query = new MemberAgent2Query();
            MemberAgent2Query.Criteria criteria = memberAgent2Query.createCriteria();
            criteria.andMemberIdEqualTo(memberId);
            List<MemberAgent2> memberAgent2s = memberAgent2Mapper.selectByExample(memberAgent2Query);
            if (memberAgent2s==null || memberAgent2s.size()<=0){
                result.setSuccess(false);
                result.setMsg("该会员不是代理或渠道");
                return result;
            }
            MemberAgent2DTO memberAgent2DTO = new MemberAgent2DTO();
            CopyUtils.Copy(memberAgent2DTO,memberAgent2s.get(0),true);
            result.setData(memberAgent2DTO);
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("查询代理出错",e);
            result.setSuccess(false);
            result.setMsg("查询代理出错");
            return result;
        }
    }

    public Map<String, Object> getAgentList(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Map> list = memberAgent2Mapper.getAgentList();
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,pageInfo);
        return map;
    }

    public List<MemberAgent2> getMemberAgentInfo(String account) {
        MemberAgent2Query memberAgent2Query = new MemberAgent2Query();
        MemberAgent2Query.Criteria criteria = memberAgent2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andStatusEqualTo(1);

        return memberAgent2Mapper.selectByExample(memberAgent2Query);
    }

    public void updateMemberAgent(MemberAgent2 memberAgent2) {
        memberAgent2Mapper.updateByPrimaryKey(memberAgent2);
    }
}
