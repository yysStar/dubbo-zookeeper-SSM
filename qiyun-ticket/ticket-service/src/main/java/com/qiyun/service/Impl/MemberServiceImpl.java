package com.qiyun.service.Impl;

import com.qiyun.common.Result;
import com.qiyun.dto.MemberDTO;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.mapper.MemberMapper;
import com.qiyun.mapper2.*;
import com.qiyun.model.Member;
import com.qiyun.model.MemberAgentCommision;
import com.qiyun.model.MemberQuery;
import com.qiyun.model2.*;
import com.qiyun.service.MemberService;
import com.qiyun.util.CopyUtils;
import com.qiyun.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private Member2Mapper member2Mapper;

    @Autowired
    MemberRate2Mapper memberRate2Mapper;
    @Autowired
    private MemberAgent2Mapper memberAgent2Mapper;
    @Autowired
    private MemberWalletLine2Mapper memberWalletLine2Mapper;
    @Autowired
    private MemberWallet2Mapper memberWallet2Mapper;
    public Result updateMemberUsername(MemberDTO memberDTO) {
        Result result = new Result();
        Member member = memberMapper.selectByPrimaryKey(memberDTO.getId());
        if (member==null){
            result.setSuccess(false);
            result.setMsg("修改用户名出错");
            return result;
        }

        if (!StringUtils.isNullOrBlank(member.getUsername())){
            result.setSuccess(false);
            result.setMsg("用户名只能修改一次");
            return result;
        }
        member.setUsername(memberDTO.getUsername());
        memberMapper.updateByPrimaryKey(member);

        Member2 member2 = member2Mapper.selectByPrimaryKey(memberDTO.getId());
        if (member2==null){
            result.setSuccess(false);
            result.setMsg("修改用户名出错");
            return result;
        }

        if (!StringUtils.isNullOrBlank(member2.getUsername())){
            result.setSuccess(false);
            result.setMsg("用户名只能修改一次");
        }
        member2.setUsername(memberDTO.getUsername());
        member2Mapper.updateByPrimaryKey(member2);
        result.setSuccess(true);
        result.setMsg("修改成功");
        return result;
    }

    public Result updateMember(MemberDTO memberDTO) {
        Result result = new Result();
        Member member = new Member();
        Member2 member2 = new Member2();
        member.setId(memberDTO.getId());
        member.setPassword(memberDTO.getPassword());
        member2.setId(memberDTO.getId());
        member2.setPassword(memberDTO.getPassword());
        memberMapper.updateByPrimaryKeySelective(member);
        member2Mapper.updateByPrimaryKeySelective(member2);
        result.setSuccess(true);
        result.setMsg("修改成功");
        return result;
    }

    public Result updatePwdByMobile(String mobile, String password) {
        Result result = new Result();
        MemberQuery memberQuery = new MemberQuery();
        MemberQuery.Criteria criteria = memberQuery.createCriteria();
        criteria.andMobileEqualTo(mobile);
        List<Member> members = memberMapper.selectByExample(memberQuery);
        if (members!=null && members.size()==1){
            Member member = members.get(0);
            member.setPassword(password);
            memberMapper.updateByPrimaryKey(member);
        }

        Member2Query member2Query = new Member2Query();
        Member2Query.Criteria criteria2 = member2Query.createCriteria();
        criteria2.andMobileEqualTo(mobile);
        List<Member2> member2s = member2Mapper.selectByExample(member2Query);
        if (member2s!=null && member2s.size()==1){
            Member2 member2 = member2s.get(0);
            member2.setPassword(password);
            member2Mapper.updateByPrimaryKey(member2);
        }

        result.setSuccess(true);
        result.setMsg("修改成功");
        return result;
    }

    public Result updateMobile(MemberDTO memberDTO) {
        Result result = new Result();
        Member member = new Member();
        member.setId(memberDTO.getId());
        member.setMobile(memberDTO.getMobile());
        memberMapper.updateByPrimaryKeySelective(member);

        Member2 member2 = new Member2();
        member2.setId(memberDTO.getId());
        member2.setMobile(memberDTO.getMobile());
        member2Mapper.updateByPrimaryKeySelective(member2);
        result.setSuccess(true);
        result.setMsg("修改成功");
        return result;
    }

    public MemberDTO getByAccount(String account) {
        Member2 member2 = member2Mapper.selectByAccount(account);
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setAccount(account);
        memberDTO.setMobile(member2.getMobile());
        memberDTO.setCertNo(member2.getCertNo());
        memberDTO.setCertType(member2.getCertType().shortValue());
        memberDTO.setEmail(member2.getEmail());memberDTO.setName(member2.getName());
        memberDTO.setType(member2.getType());
        memberDTO.setId(member2.getId());
        memberDTO.setSourceId(member2.getSourceId());
        return memberDTO;
    }

    public Member2 getById(Integer memberId) {
        Member2Query member2Query = new Member2Query();
        member2Query.createCriteria().andIdEqualTo(memberId).andTypeEqualTo(0);
        return  member2Mapper.selectByExample(member2Query).get(0);
    }

    public MemberRate2 findMemberRate2ByAccount(Integer sourceId, Integer planType) {
        MemberRate2Query memberRate2Query = new MemberRate2Query();
        MemberRate2Query.Criteria criteria = memberRate2Query.createCriteria();
        criteria.andMemberIdEqualTo(sourceId);
        criteria.andLotteryTypeEqualTo(planType);
        List<MemberRate2> memberRate2s = memberRate2Mapper.selectByExample(memberRate2Query);
        if (memberRate2s.size()>0) {
            return memberRate2s.get(0);
        }
        return null;
    }

    public MemberAgent2 findIsAgentOrQd(Integer member) {
        MemberAgent2Query memberAgent2Query = new MemberAgent2Query();
        MemberAgent2Query.Criteria criteria = memberAgent2Query.createCriteria();
        criteria.andMemberIdEqualTo(member);
        criteria.andStatusEqualTo(1);
        return memberAgent2Mapper.selectByExample(memberAgent2Query).get(0);
    }

    public MemberWallet2DTO getMemberWalletByAccount(String account) {
        try {
            MemberWallet2Query memberWallet2Query = new MemberWallet2Query();
            MemberWallet2Query.Criteria criteria2 = memberWallet2Query.createCriteria();
            criteria2.andAccountEqualTo(account);
            List<MemberWallet2> memberWallet2s = memberWallet2Mapper.selectByExample(memberWallet2Query);
            if (memberWallet2s==null || memberWallet2s.size()<=0){
                return null;
            }
            MemberWallet2DTO memberWallet2DTO = new MemberWallet2DTO();
            CopyUtils.Copy(memberWallet2DTO,memberWallet2s.get(0),true);
            return memberWallet2DTO;
        }catch (Exception e){
            return null;
        }
    }

    public void updateMemberWallet(MemberWallet2DTO memberWalletByAccount) {
        MemberWallet2 memberWallet2 = new MemberWallet2();
        CopyUtils.Copy(memberWallet2,memberWalletByAccount,true);
        memberWallet2Mapper.updateByPrimaryKey(memberWallet2);
    }

    public void insertSelective(MemberWalletLine2 memberWalletLine2) {
        memberWalletLine2Mapper.insertSelective(memberWalletLine2);
    }

    public void insert(MemberAgentCommision memberAgentCommision) {
        member2Mapper.insertMemberAgentCommision(memberAgentCommision);
    }

    public MemberWalletLine2 getByPlanNoAndRemark(Integer planNo, String remark) {
        return memberWalletLine2Mapper.getByPlanNoAndRemark(planNo,remark);
    }


}
