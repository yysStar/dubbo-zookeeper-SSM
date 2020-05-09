package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.MasterInfoDTO;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.MemberCloudsLineMapper;
import com.qiyun.model2.Member2;
import com.qiyun.model2.MemberCloudsLine;
import com.qiyun.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Resource
    private Member2Mapper member2Mapper;

    @Resource
    private MemberCloudsLineMapper memberCloudsLineMapper;

    public Member2 getByAccount(String account) {
        return member2Mapper.selectByAccount(account);
    }

    public MasterInfoDTO getMasterInfo(String account) {
        return member2Mapper.selectMasterInfo(account);
    }

    public List<MemberCloudsLine> getCloudList(String account, int num,int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        switch (num){
            case 0: //读取全部云朵明细
                return memberCloudsLineMapper.selectCloudList(account);
            case 1: //读取收入云朵明细
                return memberCloudsLineMapper.selectShouCloudList(account);
            case 2: //读取支出云朵明细
                return memberCloudsLineMapper.selectZhiCloudList(account);
            case 3: //获取云朵提现明细列表
                return memberCloudsLineMapper.getWithdrawList(account,404);
        }
        return null;
    }
}
