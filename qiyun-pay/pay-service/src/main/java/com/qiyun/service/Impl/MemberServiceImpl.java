package com.qiyun.service.Impl;

import com.qiyun.common.GoldCard2;
import com.qiyun.common.Result;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.PayMemberDTO;
import com.qiyun.mapper.MemberAgentMapper;
import com.qiyun.mapper.MemberMapper;
import com.qiyun.mapper2.*;
import com.qiyun.model.*;
import com.qiyun.model2.*;
import com.qiyun.service.MemberService;
import com.qiyun.utils.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource
    private Member2Mapper member2Mapper;

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private MemberAgentMapper memberAgentMapper;

    @Resource
    private MemberAgent2Mapper memberAgent2Mapper;

    public Member2DTO getMemberById(int id) {
        try {
            Member2 member2 = member2Mapper.selectByPrimaryKey(id);
            if (member2==null){
                return null;
            }
            Member2DTO member2DTO = new Member2DTO();
            CopyUtils.Copy(member2DTO,member2,true);
            return member2DTO;
        }catch (Exception e){
            logger.error("根据id获取Member出错",e);
            return null;
        }
    }

    public Result getPayMember(int page, int pageSize) {
        try {
            Result result = new Result();
            List<PayMember> payMembers = member2Mapper.getPayMember();
            if (payMembers==null || payMembers.size()<=0){
                return result;
            }
            List<PayMemberDTO> list = new ArrayList<PayMemberDTO>();
            for (PayMember payMember : payMembers) {
                PayMemberDTO payMemberDTO = new PayMemberDTO();
                CopyUtils.Copy(payMemberDTO,payMember,true);
                if (payMember.getSourceId()!=0){
                    MemberAgent2Query memberAgent2Query = new MemberAgent2Query();
                    MemberAgent2Query.Criteria criteria = memberAgent2Query.createCriteria();
                    criteria.andMemberIdEqualTo(payMember.getSourceId());
                    List<MemberAgent2> memberAgents = memberAgent2Mapper.selectByExample(memberAgent2Query);

                    if (memberAgents!=null && memberAgents.size()==1){
                        payMemberDTO.setSourceAccount(memberAgents.get(0).getAccount());
                        payMemberDTO.setSourceType(memberAgents.get(0).getAgentType());
                    }
                }
                list.add(payMemberDTO);
            }
            List<PayMemberDTO> list2 = new ArrayList<PayMemberDTO>();
            for (int i = (page-1)*pageSize; i < page*pageSize; i++) {
                 if (i<=list.size()-1){
                     list2.add(list.get(i));
                 }
            }
            result.setData(list2);
            result.setTotalCount(payMembers.size());
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("线下充值获取会员列表出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取出错");
            return result;
        }
    }

    public Result getPayMember(String account) {
        try {
            Result result = new Result();
            Member2Query member2Query = new Member2Query();
            Member2Query.Criteria criteria = member2Query.createCriteria();
            criteria.andAccountEqualTo(account);
            List<Member2> member2s = member2Mapper.selectByExample(member2Query);
            if (member2s==null || member2s.size()<=0){
                return null;
            }
            Member2 member2 = member2s.get(0);
            PayMemberDTO payMemberDTO = new PayMemberDTO();
            payMemberDTO.setId(member2.getId());
            payMemberDTO.setAccount(member2.getAccount());
            payMemberDTO.setName(member2.getName());
            payMemberDTO.setPayWays(member2.getPayWays());
            payMemberDTO.setSourceId(member2.getSourceId());

            MemberAgent2Query memberAgent2Query = new MemberAgent2Query();
            MemberAgent2Query.Criteria criteria2 = memberAgent2Query.createCriteria();
            criteria2.andMemberIdEqualTo(member2.getId());
            List<MemberAgent2> memberAgent2s = memberAgent2Mapper.selectByExample(memberAgent2Query);
            if (memberAgent2s==null && memberAgent2s.size()<=0){
                payMemberDTO.setType(2);
            }else{
                payMemberDTO.setType(memberAgent2s.get(0).getAgentType());
            }

            if (member2.getSourceId()!=0){
                MemberAgent2Query memberAgent2Query2 = new MemberAgent2Query();
                MemberAgent2Query.Criteria criteria3 = memberAgent2Query.createCriteria();
                criteria3.andMemberIdEqualTo(member2.getSourceId());
                List<MemberAgent2> memberAgent22s = memberAgent2Mapper.selectByExample(memberAgent2Query2);

                if (memberAgent22s!=null && memberAgent22s.size()==1){
                    payMemberDTO.setSourceAccount(memberAgent22s.get(0).getAccount());
                    payMemberDTO.setSourceType(memberAgent22s.get(0).getAgentType());
                }
            }
            result.setData(payMemberDTO);
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("线下充值根据用户名获取会员出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取失败");
            return result;
        }
    }

    public Result updateMemberPayWays(int id, String payWays) {
        try {
            Result result = new Result();

            Member2 member2 = member2Mapper.selectByPrimaryKey(id);
            if (member2==null){
                result.setSuccess(false);
                result.setMsg("没有该用户");
            }
            member2.setPayWays(payWays);
            member2Mapper.updateByPrimaryKeySelective(member2);

            result.setMsg("设置成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新会员支付渠道出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("更新支付渠道失败");
            return result;
        }
    }

    public Member getMemberByAccount(String account) {
        try {
            MemberQuery memberQuery = new MemberQuery();
            MemberQuery.Criteria criteria = memberQuery.createCriteria();
            criteria.andAccountEqualTo(account);
            List<Member> members = memberMapper.selectByExample(memberQuery);
            if (members==null || members.size()<=0){
                return null;
            }
            return members.get(0);
        }catch (Exception e){
            logger.error("根据account获取member出错",e);
            return null;
        }
    }

    public void updateMember(Member member) {
        try {
            memberMapper.updateByPrimaryKey(member);
        }catch (Exception e){
            logger.error("更新会员出错",e);
        }
    }

    public Member2 getMember2ByAccount(String account) {
        try {
            Member2Query member2Query = new Member2Query();
            Member2Query.Criteria criteria2 = member2Query.createCriteria();
            criteria2.andAccountEqualTo(account);
            List<Member2> member2s = member2Mapper.selectByExample(member2Query);
            if (member2s==null || member2s.size()<=0){
                return null;
            }
            return member2s.get(0);
        }catch (Exception e){
            logger.error("根据account获取member2出错",e);
            return null;
        }
    }

    public void updateMember2(Member2 member2) {
        try {
            member2Mapper.updateByPrimaryKey(member2);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新member2出错",e);
        }
    }

    public Member2 getMember2ByUsername(String account) {
        Member2Query member2Query = new Member2Query();
        Member2Query.Criteria criteria = member2Query.createCriteria();
        criteria.andUsernameEqualTo(account);
        List<Member2> member2s = member2Mapper.selectByExample(member2Query);
        if (member2s==null){
            return null;
        }
        return member2s.get(0);
    }

    public int addGoldCard(GoldCard2 g) {
        return member2Mapper.addGoldCard(g);
    }

    public String getPicture(String account){
        return member2Mapper.getPicture(account);
    }
}
