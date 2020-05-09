package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.MemberFansDTO;
import com.qiyun.mapper.MemberFollowMappingMapper;
import com.qiyun.mapper2.MemberFollowMapping2Mapper;
import com.qiyun.model.MemberFollowMapping;
import com.qiyun.model2.MemberFollowMapping2;
import com.qiyun.service.MemberFollowMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("memberFollowMappingService")
public class MemberFollowMappingServiceImpl implements MemberFollowMappingService {
    @Resource
    private MemberFollowMappingMapper memberFollowMappingMapper;
    @Resource
    private MemberFollowMapping2Mapper memberFollowMapping2Mapper;

    public int insertSelective(MemberFollowMapping record){
        MemberFollowMapping2 memberFollowMapping2 = MemberFollowMapping2.builder()
                .createDatetime(record.getCreateDatetime()).account(record.getAccount())
                .fansAccount(record.getFansAccount()).build();
        memberFollowMapping2Mapper.insertSelective(memberFollowMapping2);
        return memberFollowMappingMapper.insertSelective(record);
    }

    public List<MemberFansDTO> getFollowList(String account, int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return memberFollowMapping2Mapper.getFollowList(account);
    }

    public List<MemberFansDTO> getFansList(String fansAccount, int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return memberFollowMapping2Mapper.getFansList(fansAccount);
    }

    public MemberFollowMapping2 getByFansAccount(String account, String fansAccount) {
        return memberFollowMapping2Mapper.getByFansAccount(account, fansAccount);
    }

    public int update(MemberFollowMapping2 mapping) {
        MemberFollowMapping memberFollowMapping = memberFollowMappingMapper.selectByPrimaryKey(mapping.getId());
        memberFollowMapping.setIsCancel(mapping.getIsCancel());
        memberFollowMappingMapper.updateByPrimaryKeySelective(memberFollowMapping);
        return memberFollowMapping2Mapper.updateByPrimaryKeySelective(mapping);
    }
}
