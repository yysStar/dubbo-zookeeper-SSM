package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.dto.MostPopularMemberDTO;
import com.qiyun.mapper2.MemberFollowMapping2Mapper;
import com.qiyun.model2.MemberFollowMapping2;
import com.qiyun.model2.MemberFollowMapping2Query;
import com.qiyun.service.MemberFollowMappingService;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberFollowMappingServiceImpl implements MemberFollowMappingService {

    @Resource
    private MemberFollowMapping2Mapper memberFollowMapping2Mapper;

    public Map<String, Object> getMostPopular(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<MostPopularMemberDTO> mostPopular = memberFollowMapping2Mapper.getMostPopular();
        PageInfo<MostPopularMemberDTO> pageInfo = new PageInfo<MostPopularMemberDTO>(mostPopular);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,pageInfo);
        return map;
    }

    public List<MemberFollowMapping2> getByaccountAndFansAccount(String account, String account1) {
        MemberFollowMapping2Query memberFollowMapping2Query = new MemberFollowMapping2Query();
        MemberFollowMapping2Query.Criteria criteria = memberFollowMapping2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andFansAccountEqualTo(account1);
        criteria.andIsCancelEqualTo(false);
        List<MemberFollowMapping2> memberFollowMapping2s = memberFollowMapping2Mapper.selectByExample(memberFollowMapping2Query);
        return memberFollowMapping2s;
    }
}
