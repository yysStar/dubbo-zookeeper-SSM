package com.qiyun.serviceImpl;

import com.qiyun.common.Result;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.mapper.MemberWalletMapper;
import com.qiyun.mapper2.MemberWallet2Mapper;
import com.qiyun.model.MemberWallet;
import com.qiyun.model2.MemberWallet2;
import com.qiyun.model2.MemberWallet2Query;
import com.qiyun.service.MemberWalletService;
import com.qiyun.utils.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class MemberWalletServiceImpl implements MemberWalletService {

    private static Logger logger = LoggerFactory.getLogger(MemberWalletServiceImpl.class);

    @Resource
    private MemberWallet2Mapper memberWallet2Mapper;

    @Resource
    private MemberWalletMapper memberWalletMapper;

    public MemberWallet2DTO getByMemberId(Integer id) {
        MemberWallet2 memberWallet2 = memberWallet2Mapper.selectByMemberId(id);
        if (memberWallet2==null){
            return null;
        }
        MemberWallet2DTO memberWallet2DTO = new MemberWallet2DTO();
        CopyUtils.Copy(memberWallet2DTO,memberWallet2,true);
        return memberWallet2DTO;
    }

    public Result update(MemberWallet2DTO memberWallet2DTO) {
        Result result = new Result();
        try {
            MemberWallet2 memberWallet2 = new MemberWallet2();
            CopyUtils.Copy(memberWallet2,memberWallet2DTO,true);
            memberWallet2Mapper.updateByPrimaryKeySelective(memberWallet2);

            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("更新会员钱包出错",e);
            result.setSuccess(false);
            result.setMsg("更新会员钱包出错");
            return result;
        }
    }

    public MemberWallet2 getByAccount(String account) {
        MemberWallet2Query memberWallet2Query = new MemberWallet2Query();
        MemberWallet2Query.Criteria criteria = memberWallet2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        List<MemberWallet2> memberWallet2s = memberWallet2Mapper.selectByExample(memberWallet2Query);
        if (memberWallet2s==null || memberWallet2s.size()<=0){
            return null;
        }
        return memberWallet2s.get(0);
    }

    public void update2(MemberWallet2 memberWallet2) {
        memberWallet2Mapper.updateByPrimaryKeySelective(memberWallet2);
    }

    private MemberWallet toMemberWallet(MemberWallet2 memberWallet2) {
        MemberWallet memberWallet = new MemberWallet();
        memberWallet.setMemberId(memberWallet2.getMemberId());
        memberWallet.setAccount(memberWallet2.getAccount());
        memberWallet.setUsableMoney(new BigDecimal(memberWallet2.getAbleBalance()));
        memberWallet.setFreezeMoney(new BigDecimal(memberWallet2.getFreezeBalance()));
        memberWallet.setCashQuota(new BigDecimal(memberWallet2.getTakeCashQuota()));
        memberWallet.setHistoryMoney(new BigDecimal(memberWallet2.getHeapBalance()));
        memberWallet.setHistoryPrize(new BigDecimal(memberWallet2.getHeapPrize()));
        memberWallet.setVerifyMd5(memberWallet2.getVerifyMd5());
        memberWallet.setWalletType(memberWallet2.getWalletType());
        memberWallet.setCreditLimit(memberWallet2.getCreditLimit());
        memberWallet.setAbleCreditBalance(memberWallet2.getAbleCreditBalance());
        memberWallet.setFreezeCreditBalance(memberWallet2.getFreezeCreditBalance());
        return memberWallet;
    }
}
