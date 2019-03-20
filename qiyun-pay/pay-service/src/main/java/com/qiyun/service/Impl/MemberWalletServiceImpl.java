package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.common.DbDataVerify;
import com.qiyun.common.Result;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.dto.RedPacketDTO;
import com.qiyun.dto.RedPacketListDTO;
import com.qiyun.mapper.MemberWalletMapper;
import com.qiyun.mapper.PayOrderMapper;
import com.qiyun.mapper2.MemberWallet2Mapper;
import com.qiyun.mapper2.PayOrder2Mapper;
import com.qiyun.model.MemberWallet;
import com.qiyun.model.MemberWalletQuery;
import com.qiyun.model2.MemberWallet2;
import com.qiyun.model2.MemberWallet2Query;
import com.qiyun.model2.PayOrder2;
import com.qiyun.service.MemberWalletService;
import com.qiyun.utils.CopyUtils;
import com.qiyun.utils.NumberTools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class MemberWalletServiceImpl implements MemberWalletService {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MemberWalletServiceImpl.class);

    @Resource
    private PayOrder2Mapper payOrder2Mapper;
    @Resource
    private PayOrderMapper payOrderMapper;
    @Resource
    private MemberWalletMapper memberWalletMapper;
    @Resource
    private MemberWallet2Mapper memberWallet2Mapper;

    public int updateByPrimaryKeySelective(MemberWallet2DTO memberWallet2DTO){
        MemberWallet2 memberWallet2 = new MemberWallet2();
        CopyUtils.Copy(memberWallet2, memberWallet2DTO,true);
        return memberWallet2Mapper.updateByPrimaryKeySelective(memberWallet2);
    }

    public List<RedPacketListDTO> grabRedRacketList(int offset, int pageSize, String account, String startTime, String endTime) {
        PageHelper.startPage(offset,pageSize);
        List<RedPacketListDTO> redPacketListDTOS = memberWallet2Mapper.grabRedRacketList(account, startTime, endTime);
        return redPacketListDTOS;
    }

    public List<RedPacketListDTO> putRedRacketList(int offset, int pageSize, String account, String startTime, String endTime) {
        PageHelper.startPage(offset,pageSize);
        List<RedPacketListDTO> redPacketListDTOS = memberWallet2Mapper.putRedRacketList(account, startTime, endTime);
        return redPacketListDTOS;
    }

    /**
     * 修改会员钱包
     * @param prdOrdNo
     * @param orderAmount
     */
    public Result update(String prdOrdNo, String orderAmount) {
        try {
            Result result = new Result();
            log.info("订单:"+prdOrdNo+",金额:"+orderAmount);
            PayOrder2 payOrder2 = payOrder2Mapper.selectByPrimaryKey(prdOrdNo);
            if (payOrder2==null){
                result.setSuccess(false);
                result.setMsg("找不到订单");
                return result;
            }
            Integer memberId = payOrder2.getMemberId();

            //old
            MemberWallet2Query memberWallet2Query = new MemberWallet2Query();
            MemberWallet2Query.Criteria criteria = memberWallet2Query.createCriteria();
            criteria.andMemberIdEqualTo(memberId);
            List<MemberWallet2> memberWallet2s = memberWallet2Mapper.selectByExample(memberWallet2Query);
            if (memberWallet2s==null || memberWallet2s.size()<=0){
                result.setSuccess(false);
                result.setMsg("找不到会员钱包");
                return result;
            }
            MemberWallet2 memberWallet2 = memberWallet2s.get(0);
            memberWallet2.setAbleBalance(NumberTools.round(memberWallet2.getAbleBalance()+Double.parseDouble(orderAmount)/100,2));
            memberWallet2.setVerifyMd5(DbDataVerify.getMemberWalletVerify2(memberWallet2));
            memberWallet2Mapper.updateByPrimaryKeySelective(memberWallet2);

            log.info("修改会员"+memberId+"钱包成功");
            result.setSuccess(true);
            result.setMsg("修改会员钱包成功");
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("修改会员钱包出错");
            log.info("修改会员钱包出错");
            return result;
        }
    }

    public Result addMoney(String account, Double amount) {
        try {

            Result result = new Result();
            result.setSuccess(false);

            MemberWallet2Query memberWallet2Query = new MemberWallet2Query();
            MemberWallet2Query.Criteria criteria1 = memberWallet2Query.createCriteria();
            criteria1.andAccountEqualTo(account);
            List<MemberWallet2> memberWallet2s = memberWallet2Mapper.selectByExample(memberWallet2Query);
            if (memberWallet2s==null || memberWallet2s.size()<=0){
                result.setSuccess(false);
                result.setMsg("找不到会员钱包");
                return result;
            }
            MemberWallet2 memberWallet2 = new MemberWallet2();
            memberWallet2 = memberWallet2s.get(0);
            memberWallet2.setAbleBalance(memberWallet2.getAbleBalance()+amount);
            memberWallet2.setVerifyMd5(DbDataVerify.getMemberWalletVerify2(memberWallet2));
            memberWallet2Mapper.updateByPrimaryKey(memberWallet2);

            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("修改会员钱包出错");
            log.info("修改会员钱包出错");
            return result;
        }
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

    public Result updateMemberWallet(MemberWallet2DTO memberWalletDTO) {
        Result result = new Result();
        try {
            MemberWallet2 memberWallet2 = new MemberWallet2();
            CopyUtils.Copy(memberWallet2,memberWalletDTO,true);
            memberWallet2Mapper.updateByPrimaryKey(memberWallet2);

            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setSuccess(false);
            result.setMsg("更新会员钱包出错");
            log.info("更新会员钱包出错");
            return result;
        }
    }

    public Result updateCreditBalance(String dlAccount, double amount) {
        Result result = new Result();
        try {
            MemberWallet2 memberWallet2 = memberWallet2Mapper.selectByAccount(dlAccount);
            if (memberWallet2==null){
                result.setSuccess(true);
                result.setMsg("找不到会员钱包");
                return result;
            }
            memberWallet2.setAbleCreditBalance(memberWallet2.getAbleCreditBalance()-amount);
            memberWallet2.setFreezeCreditBalance(memberWallet2.getFreezeCreditBalance()+amount);
            memberWallet2Mapper.updateByPrimaryKeySelective(memberWallet2);

            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setSuccess(false);
            result.setMsg("修改代理授信可用金额，冻结金额出错");
            return result;
        }
    }

    public MemberWallet toMemberWallet(MemberWallet2 memberWallet2){
        MemberWallet memberWallet = new MemberWallet();
        memberWallet.setMemberId(memberWallet2.getMemberId());
        memberWallet.setAccount(memberWallet2.getAccount());
        memberWallet.setUsableMoney(new BigDecimal(memberWallet2.getAbleBalance()));
        memberWallet.setFreezeMoney(new BigDecimal(memberWallet2.getFreezeBalance()));
        memberWallet.setCashQuota(new BigDecimal(memberWallet2.getTakeCashQuota()));
        memberWallet.setHistoryMoney(new BigDecimal(memberWallet2.getHeapBalance()));
        memberWallet.setHistoryPrize(new BigDecimal(memberWallet2.getHeapPrize()));
        memberWallet.setWalletType(memberWallet2.getWalletType());
        memberWallet.setCreditLimit(memberWallet2.getCreditLimit());
        memberWallet.setAbleCreditBalance(memberWallet2.getAbleCreditBalance());
        memberWallet.setFreezeCreditBalance(memberWallet2.getFreezeCreditBalance());
        memberWallet.setVerifyMd5(DbDataVerify.getMemberWalletVerify(memberWallet));
        return memberWallet;
    }
}
