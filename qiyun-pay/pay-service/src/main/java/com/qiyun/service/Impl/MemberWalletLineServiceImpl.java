package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.common.Result;
import com.qiyun.dto.MemberWalletLine2DTO;
import com.qiyun.mapper.MemberMapper;
import com.qiyun.mapper.MemberWalletLineMapper;
import com.qiyun.mapper.MemberWalletMapper;
import com.qiyun.mapper.PayOrderMapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.MemberWallet2Mapper;
import com.qiyun.mapper2.MemberWalletLine2Mapper;
import com.qiyun.mapper2.PayOrder2Mapper;
import com.qiyun.model.*;
import com.qiyun.model2.*;
import com.qiyun.service.MemberWalletLineService;
import com.qiyun.utils.CopyUtils;
import com.qiyun.utils.DbDataVerify;
import com.qiyun.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberWalletLineServiceImpl implements MemberWalletLineService {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MemberWalletLineServiceImpl.class);


    @Resource
    private MemberWalletMapper memberWalletMapper;

    @Resource
    private MemberWallet2Mapper memberWallet2Mapper;

    @Resource
    private MemberWalletLineMapper memberWalletLineMapper;
    @Resource
    private MemberWalletLine2Mapper memberWalletLine2Mapper;
    @Resource
    private PayOrderMapper payOrderMapper;
    @Resource
    private PayOrder2Mapper payOrder2Mapper;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private Member2Mapper member2Mapper;

    public int insertSelective(MemberWalletLine2 record) {
        return memberWalletLine2Mapper.insertSelective(record);
    }

    /**
     * 添加钱包流水
     * @param prdOrdNo
     * @param orderAmount
     */
    public Result update(String prdOrdNo, String orderAmount) {
        try {
            Result result = new Result();
            //获取会员id
            PayOrder2 payOrder2 = payOrder2Mapper.selectByPrimaryKey(prdOrdNo);
            if (payOrder2==null){
                result.setSuccess(false);
                result.setMsg("找不到订单");
                return result;
            }
            Integer memberId = payOrder2.getMemberId();

            //查询会员
            Member member = memberMapper.selectByPrimaryKey(memberId);
            if (member==null){
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }

            MemberWallet2 memberWallet2 = memberWallet2Mapper.selectByMemberId(memberId);
            if (memberWallet2==null){
                result.setSuccess(false);
                result.setMsg("找不到钱包");
                return result;
            }

            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setAbleBalance(memberWallet2.getAbleBalance());
            memberWalletLine2.setAccount(memberWallet2.getAccount());
            memberWalletLine2.setAmount((double) (Integer.parseInt(orderAmount)));
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
            memberWalletLine2.setLotteryType(-1);
            memberWalletLine2.setMemberId(memberId);
            memberWalletLine2.setRemark("充值");
            memberWalletLine2.setWalletType(1);
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setSourceId(member.getSourceId());
            memberWalletLine2.setTransType(0);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            memberWalletLine2Mapper.insert(memberWalletLine2);

            result.setSuccess(true);
            result.setMsg("修改钱包流水成功");
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("更新钱包流水出错");
            log.info("更新钱包流水出错");
            return result;
        }
    }

    /**
     * 添加钱包流水
     * @param prdOrdNo
     * @param orderAmount
     */
    public Result update2(String prdOrdNo, String orderAmount,String remark,int transType) {
        try {
            Result result = new Result();
            //获取会员id
            PayOrder2 payOrder2 = payOrder2Mapper.selectByPrimaryKey(prdOrdNo);
            if (payOrder2==null){
                result.setSuccess(false);
                result.setMsg("找不到订单");
                return result;
            }
            Integer memberId = payOrder2.getMemberId();

            //查询会员
            Member2 member = member2Mapper.selectByPrimaryKey(memberId);
            if (member==null){
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }

            MemberWallet2 memberWallet2 = memberWallet2Mapper.selectByMemberId(memberId);
            if (memberWallet2==null){
                result.setSuccess(false);
                result.setMsg("找不到钱包");
                return result;
            }

            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setAbleBalance(memberWallet2.getAbleBalance());
            memberWalletLine2.setAccount(memberWallet2.getAccount());
            memberWalletLine2.setAmount((Double.parseDouble(orderAmount)/100));
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
            memberWalletLine2.setLotteryType(-1);
            memberWalletLine2.setMemberId(memberId);
            memberWalletLine2.setRemark(remark);
            memberWalletLine2.setWalletType(1);
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setSourceId(member.getSourceId());
            memberWalletLine2.setTransType(transType);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            memberWalletLine2Mapper.insert(memberWalletLine2);

            log.info("修改"+member.getAccount()+"钱包流水成功");
            result.setSuccess(true);
            result.setMsg("修改钱包流水成功");
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("更新钱包流水出错");
            log.info("更新钱包流水出错");
            return result;
        }
    }

    public Result passPayApply(String account, Double amount) {
        try {
            Result result = new Result();

            MemberWalletLine2Query memberWalletLine2Query = new MemberWalletLine2Query();
            MemberWalletLine2Query.Criteria criteria1 = memberWalletLine2Query.createCriteria();
            criteria1.andAccountEqualTo(account);
            memberWalletLine2Query.setOrderByClause("wallet_Line_No DESC");
            List<MemberWalletLine2> memberWalletLine2s = memberWalletLine2Mapper.selectByExample(memberWalletLine2Query);
            Member2 member2 = member2Mapper.selectByAccount(account);
            if (member2==null){
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }
            MemberWallet2 memberWallet2 = memberWallet2Mapper.selectByAccount(account);
            if (memberWallet2==null){
                result.setSuccess(false);
                result.setMsg("找不到会员钱包");
                return result;
            }
            //old
            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setAccount(account);
            memberWalletLine2.setMemberId(member2.getId());
            memberWalletLine2.setTransType(2058);
            memberWalletLine2.setWalletType(1);
            memberWalletLine2.setAmount(amount);
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setSourceId(member2.getSourceId());
            memberWalletLine2.setAbleBalance(memberWallet2.getAbleBalance());
            memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
            memberWalletLine2.setRemark("线下充值");
            memberWalletLine2.setPrizeBalance(memberWallet2.getHeapPrize());
            memberWalletLine2.setLotteryType(-1);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            memberWalletLine2Mapper.insertSelective(memberWalletLine2);

            result.setSuccess(true);

            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("更新钱包流水出错");
            log.info("更新钱包流水出错");
            return result;
        }


    }

    public Result passPayApply2(String account, Double amount) {
        try {
            Result result = new Result();

            MemberWalletLine2Query memberWalletLine2Query = new MemberWalletLine2Query();
            MemberWalletLine2Query.Criteria criteria1 = memberWalletLine2Query.createCriteria();
            criteria1.andAccountEqualTo(account);
            memberWalletLine2Query.setOrderByClause("wallet_Line_No DESC");
            List<MemberWalletLine2> memberWalletLine2s = memberWalletLine2Mapper.selectByExample(memberWalletLine2Query);
            Member2 member2 = member2Mapper.selectByAccount(account);
            if (member2==null){
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }
            MemberWallet2 memberWallet2 = memberWallet2Mapper.selectByAccount(account);
            if (memberWallet2==null){
                result.setSuccess(false);
                result.setMsg("找不到会员钱包");
                return result;
            }
            //old
            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setAccount(account);
            memberWalletLine2.setMemberId(member2.getId());
            memberWalletLine2.setTransType(2062);
            memberWalletLine2.setWalletType(1);
            memberWalletLine2.setAmount(amount);
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setSourceId(member2.getSourceId());
            memberWalletLine2.setAbleBalance(memberWallet2.getAbleBalance());
            memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
            memberWalletLine2.setRemark("授信充值");
            memberWalletLine2.setPrizeBalance(memberWallet2.getHeapPrize());
            memberWalletLine2.setLotteryType(-1);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            memberWalletLine2Mapper.insertSelective(memberWalletLine2);

            result.setSuccess(true);

            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("更新钱包流水出错");
            log.info("更新钱包流水出错");
            return result;
        }


    }

    public Result getMemberWalletLineByXx(String account,int page,int pageSize) {
        try {

            Result result = new Result();
            if (!StringUtils.isNullOrBlank(account)){
                //根据用户名查询
                MemberWalletLine2Query memberWalletLine2Query = new MemberWalletLine2Query();
                MemberWalletLine2Query.Criteria criteria = memberWalletLine2Query.createCriteria();
                criteria.andAccountEqualTo(account);
                criteria.andTransTypeEqualTo(2058);
                memberWalletLine2Query.setOrderByClause("wallet_Line_No DESC");
                PageHelper.startPage(page,pageSize);
                List<MemberWalletLine2> memberWalletLine2s = memberWalletLine2Mapper.selectByExample(memberWalletLine2Query);
                int totalCount = memberWalletLine2Mapper.countByExample(memberWalletLine2Query);
                List<MemberWalletLine2DTO> list = new ArrayList<MemberWalletLine2DTO>();
                if (memberWalletLine2s!=null && memberWalletLine2s.size()>0){
                    for (MemberWalletLine2 memberWalletLine2 : memberWalletLine2s) {
                        MemberWalletLine2DTO memberWalletLine2DTO = new MemberWalletLine2DTO();
                        CopyUtils.Copy(memberWalletLine2DTO,memberWalletLine2,true);
                        list.add(memberWalletLine2DTO);
                    }
                }
                result.setSuccess(true);
                result.setTotalCount(totalCount);
                result.setData(list);
                return result;
            }else{
                //查询所有
                MemberWalletLine2Query memberWalletLine2Query = new MemberWalletLine2Query();
                MemberWalletLine2Query.Criteria criteria = memberWalletLine2Query.createCriteria();
                criteria.andTransTypeEqualTo(2058);
                memberWalletLine2Query.setOrderByClause("wallet_Line_No DESC");
                PageHelper.startPage(page,pageSize);
                List<MemberWalletLine2> memberWalletLine2s = memberWalletLine2Mapper.selectByExample(memberWalletLine2Query);
                int totalCount = memberWalletLine2Mapper.countByExample(memberWalletLine2Query);
                List<MemberWalletLine2DTO> list = new ArrayList<MemberWalletLine2DTO>();
                if (memberWalletLine2s!=null && memberWalletLine2s.size()>0){
                    for (MemberWalletLine2 memberWalletLine2 : memberWalletLine2s) {
                        MemberWalletLine2DTO memberWalletLine2DTO = new MemberWalletLine2DTO();
                        CopyUtils.Copy(memberWalletLine2DTO,memberWalletLine2,true);
                        list.add(memberWalletLine2DTO);
                    }
                }
                result.setSuccess(true);
                result.setTotalCount(totalCount);
                result.setData(list);
                return result;
            }
        }catch (Exception e){
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取线下充值流水出错");
            log.info("获取线下充值流水出错");
            return result;
        }
    }
}
