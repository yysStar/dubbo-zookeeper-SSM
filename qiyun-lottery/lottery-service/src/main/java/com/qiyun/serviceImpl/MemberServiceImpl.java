package com.qiyun.serviceImpl;

import com.qiyun.dto.Member2DTO;
import com.qiyun.mapper.CopyLotteryPlanMapper;
import com.qiyun.mapper.MemberMapper;
import com.qiyun.mapper2.CopyLotteryPlan2Mapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Member2;
import com.qiyun.model2.Member2Query;
import com.qiyun.service.MemberService;
import com.qiyun.utils.CopyUtils;
import com.qiyun.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MemberServiceImpl implements MemberService {

    private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private Member2Mapper member2Mapper;

    public List<Member2DTO> getByAccounts(String account,int page, int pageSize) {

        if (StringUtils.isNullOrBlank(account)){
            return null;
        }
        List<Member2> member2s = member2Mapper.selectByAccounts(account);
        if (member2s==null){
            return null;
        }
        ArrayList<Member2DTO> member2DTO = new ArrayList<Member2DTO> ();
        for(int i=0;i<member2s.size();i++){
            CopyUtils.Copy(member2DTO.get(i),member2s.get(i),true);
        }
        return member2DTO;
    }

    public Member2DTO getByAccount(String account) {
        if (StringUtils.isNullOrBlank(account)){
            return null;
        }
        Member2 member2 = member2Mapper.selectByAccount(account);
        if (member2==null){
            return null;
        }
        Member2DTO member2DTO = new Member2DTO();
        CopyUtils.Copy(member2DTO,member2,true);
        return member2DTO;
    }

    public Member2 getByUsername(String username) {
        Member2Query member2Query = new Member2Query();
        Member2Query.Criteria criteria = member2Query.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Member2> member2s = member2Mapper.selectByExample(member2Query);
        if (member2s==null || member2s.size()<=0){
            return null;
        }

        return member2s.get(0);
    }

    public List<Member2> getVirtualMember() {
        Member2Query member2Query = new Member2Query();
        Member2Query.Criteria criteria = member2Query.createCriteria();
        criteria.andTypeEqualTo(2);
        List<Member2> member2s = member2Mapper.selectByExample(member2Query);
        return member2s;
    }

    public Member2 getById(Integer id) {
        return member2Mapper.selectByPrimaryKey(id);
    }

    @Override
    public void addSalesCount(LotteryPlan2WithBLOBs lotteryPlan) {
        //从数据库拿出今天的这个账号的销量统计
        Map paramMap = new HashMap();
       paramMap.put("account",lotteryPlan.getAccount());
        if (lotteryPlan.getDlAccount()!=null && !"".equals(lotteryPlan.getDlAccount())) {
            paramMap.put("up_account", lotteryPlan.getDlAccount());
        }else {
            paramMap.put("up_account", lotteryPlan.getQdAccount());
        }
        paramMap.put("amount",lotteryPlan.getAmount());
        paramMap.put("isSuperMan",lotteryPlan.getIsSuperMan());

        //查找这个客户数据最后更新时间
        try {
            Map time  =  member2Mapper.selectMaxDate(lotteryPlan.getAccount());
            paramMap.put("self_buy",time.get("self_buy"));
            paramMap.put("follow_buy",time.get("follow_buy"));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //如果等于今天
            if (simpleDateFormat.format(time.get("create_time")).equals(simpleDateFormat.format(new Date()))){
                member2Mapper.updateSalesCount(paramMap);
              //判断当前客户上级是否发生改变
              if (!paramMap.get("up_account").equals(time.get("up_account"))){
                  member2Mapper.addSalesCount(paramMap);
              }
            }else {
                //若果不等于今天
                member2Mapper.addSalesCount(paramMap);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        }

}
