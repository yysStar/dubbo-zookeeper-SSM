package com.qiyun.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.common.Result;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.mapper.MemberWalletMapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.MemberWallet2Mapper;
import com.qiyun.mapper2.UserCountMapper;
import com.qiyun.model2.MemberWallet2;
import com.qiyun.service.MemberWalletService;
import com.qiyun.util.CopyUtils;
import com.qiyun.util.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("memberWalletService")
public class MemberWalletServiceImpl implements MemberWalletService {

    private static Logger logger = LoggerFactory.getLogger(MemberWalletServiceImpl.class);

    @Resource
    private MemberWalletMapper memberWalletMapper;

    @Resource
    private MemberWallet2Mapper memberWallet2Mapper;

    @Resource
    private Member2Mapper member2Mapper;
    @Resource
    private UserCountMapper userCountMapper;
    public Result getMemberWallet(Integer id) {
        try {
            MemberWallet2 memberWallet2 = memberWallet2Mapper.selectByMemberId(id);
            Result result = new Result();
            result.setSuccess(true);
            result.setData(memberWallet2);
            return result;
        }catch (Exception e){
            logger.error("获取会员钱包出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取会员钱包出错");
            return result;
        }
    }

    public Result getCreditMember(String account, int page, int pageSize, String loginAccount) {
        Result result = new Result();
        try {
           /* if (StringUtils.isNullOrBlank(account)) {
                //查询全部
                List<MemberWallet2> list = memberWallet2Mapper.getCreditMember((page - 1) * pageSize, pageSize);
                int totalCount = memberWallet2Mapper.getCreditMemberCount();
                if (list == null || list.size() <= 0) {
                    result.setSuccess(true);
                    return result;
                }
                List<MemberWallet2DTO> lists = new ArrayList<MemberWallet2DTO>();
                for (MemberWallet2 memberWallet2 : list) {
                    MemberWallet2DTO memberWallet2DTO = new MemberWallet2DTO();
                    CopyUtils.Copy(memberWallet2DTO, memberWallet2, true);
                    lists.add(memberWallet2DTO);
                }
                result.setSuccess(true);
                result.setData(lists);
                result.setTotalCount(totalCount);
                return result;
            }else{*/
                //根据用户名查询
                //查询登录账号名下所有渠道
            List<MemberWallet2> list;
            List<String> agentByQD = new ArrayList<String>();
            PageInfo pageInfo;
            if (loginAccount!=null&&!"".equals(loginAccount)) {
                List<String> qdByLoginAccount = member2Mapper.findQDByLoginAccount(loginAccount);
                //查询渠道下所有代理

                //根据会员名查询
                if (account!=null&&!account.equals("")){
                    agentByQD.add(account);
                }else {
                    agentByQD = userCountMapper.findAgentByQD(qdByLoginAccount);
                }
                     list= new ArrayList<MemberWallet2>();
                    PageHelper.startPage(page,pageSize);
                    list = memberWallet2Mapper.getCreditMemberByAccount(agentByQD);
                     pageInfo = new PageInfo(list);
            }else {
                agentByQD= new ArrayList<String>();
                agentByQD.add(account);
                PageHelper.startPage(page,pageSize);
                 list = memberWallet2Mapper.getCreditMemberByAccount(agentByQD);
                pageInfo = new PageInfo(list);
            }
                if (list == null || list.size() <= 0) {
                    result.setSuccess(true);
                    return result;
                }
            /*    List<MemberWallet2DTO> lists = new ArrayList<MemberWallet2DTO>();
                for (MemberWallet2 memberWallet2 : list) {
                    MemberWallet2DTO memberWallet2DTO = new MemberWallet2DTO();
                    CopyUtils.Copy(memberWallet2DTO, memberWallet2, true);
                    lists.add(memberWallet2DTO);
                }*/
                result.setSuccess(true);
                result.setData(pageInfo);
                return result;
          /*  }*/
        }catch (Exception e){
            logger.error("获取代理授信出错",e);
            result.setSuccess(false);
            result.setMsg("获取代理授信出错");
            return result;
        }
    }
}
