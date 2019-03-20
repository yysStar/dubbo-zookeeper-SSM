package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.WithdrawCashDTO;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.MemberCloudsLineMapper;
import com.qiyun.mapper2.MemberCloudsMapper;
import com.qiyun.model2.*;
import com.qiyun.service.MemberCloudsService;
//import com.qiyun.util.TransType;

import com.qiyun.type.TransType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@Service("memberCloudsService")
public class MemberCloudsServiceImpl implements MemberCloudsService {
    @Resource
    private MemberCloudsMapper memberCloudsMapper;

    @Resource
    private MemberCloudsLineMapper memberCloudsLineMapper;

    @Resource
    private Member2Mapper member2Mapper;  //用户表mapper

    public MemberClouds getByAccount(String account) {
        return memberCloudsMapper.selectByAccount(account);
    }

    public int update(MemberClouds memberClouds) {
        return memberCloudsMapper.updateByPrimaryKeySelective(memberClouds);
    }

    public int insertSelective(MemberClouds memberClouds) {
        return memberCloudsMapper.insertSelective(memberClouds);
    }

    public List<WithdrawCashDTO> getCashList(int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return memberCloudsMapper.selectCashList();
    }

    /**
     * 获取是否具有快速审核功能的权限（暂时关闭）
     * @param account
     * @return
     */
    public int isFast(String account) {
        String result = memberCloudsMapper.selectFAST(account);
        if(result == null ||result.length()<=0){
            return 0;   //账户没有快速审核功能的权限
        }else{
            return 1;   //账户具有快速审核功能的权限
        }
    }

    /**
     * 获取云朵数量
     * @param account
     * @return
     */
    public Integer getClounds(String account) {
        return memberCloudsMapper.getClounds(account);
    }

    public int QuickReview(String account) {
        MemberCloudsExample memberCloudsExample = new MemberCloudsExample();
        memberCloudsExample.createCriteria().andAccountEqualTo(account);
        List<MemberClouds> memberClouds = memberCloudsMapper.selectByExample(memberCloudsExample);
        MemberClouds memberCloud = memberClouds.get(0);

        Member2Example M2Q = new Member2Example();
        M2Q.createCriteria().andAccountEqualTo(account);

        List<Member2> member2s = member2Mapper.selectByExample(M2Q);
        //云朵流水表快速审核生成
        MemberCloudsLine memberCloudsLine = MemberCloudsLine.builder().account(account).ableBalance(memberCloud.getCloudsAbleBalance() - 1)
                .transType(TransType.QUICKREVIW).memberId(member2s.get(0).getId()).clouds(1).createDateTime(new Date())
                .freezeBalance(memberCloud.getFreezeBalance()).heapBalance(memberCloud.getHeapBalance() + 1)
                .remark("快速审核扣款").build();
        memberCloudsLineMapper.insert(memberCloudsLine);
        //云朵表修改
        MemberClouds memberClouds1 = MemberClouds.builder().id(memberCloud.getId()).account(account)
                .cloudsAbleBalance(memberCloud.getCloudsAbleBalance() - 1)
                .takeCashQuota(memberCloud.getTakeCashQuota()-1).freezeBalance(memberCloud.getFreezeBalance())
                .heapBalance(memberCloud.getHeapBalance()+1).build();
        memberCloudsMapper.updateByPrimaryKey(memberClouds1);
        return 1;
    }


}
