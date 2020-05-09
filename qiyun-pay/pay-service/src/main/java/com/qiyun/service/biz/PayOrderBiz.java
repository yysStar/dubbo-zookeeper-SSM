package com.qiyun.service.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.api.PayApi;
import com.qiyun.common.GoldCard2;
import com.qiyun.common.Result;
import com.qiyun.dto.*;
import com.qiyun.model.Member;
import com.qiyun.model.WalletTransType;
import com.qiyun.model2.Member2;

import com.qiyun.model2.MemberClouds2;
import com.qiyun.model2.MemberWalletLine2;
import com.qiyun.model2.PayOrder2;
import com.qiyun.service.*;
import com.qiyun.status.DrawingStatus;
import com.qiyun.util.*;

import com.qiyun.utils.DbDataVerify;
import com.qiyun.utils.DbDataVerify2;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;

@Service("payApi")
public class PayOrderBiz implements PayApi {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PayOrderBiz.class);

    @Resource
    private MemberCloudsService memberCloudsService;

    @Resource
    private MemberCloudsLineService memberCloudsLineService;

    @Resource
    private CreditRefundService creditRefundService;

    @Resource
    private AgentChargeLineService agentChargeLineService;

    @Resource
    private MemberAgentService memberAgentService;

    @Resource
    private CreditLimitLineService creditLimitLineService;

    @Resource
    private XxPayApplyService xxPayApplyService;

    @Resource
    private MemberService memberService;

    @Resource
    private PayChannelService payChannelService;

    @Resource
    private PayOrderService payOrderService;

    @Resource
    private MemberWalletService memberWalletService;

    @Resource
    private MemberWalletLineService memberWalletLineService;

    public boolean callBackForPay(String orderId, String outOrderId, int amount, int transType, String remark) {
        synchronized (this) {
            log.info("支付回调:"+orderId+",金额:"+amount+"分");
            PayOrder2DTO payOrder2DTO = payOrderService.getPayOrderById(orderId);
            //判断回调跟订单金额是否一致
            if (payOrder2DTO == null) {
                return false;
            }
            if (amount != payOrder2DTO.getAmount()) {
                log.info("回调跟订单金额不一致:"+orderId);
                return false;
            }
            if ("01".equals(payOrder2DTO.getStatus())) {
                log.info("该订单已成功:"+orderId);
                return true;
            }

            if (payOrder2DTO.getType() == 1) {
                //冲入余额
                log.info("冲入余额");
                memberWalletService.update(orderId, amount + "");
                memberWalletLineService.update2(orderId, amount + "", remark, transType);
            } else {
                //冲入云朵
                log.info("冲入云朵");
                Member2DTO memberById = memberService.getMemberById(payOrder2DTO.getMemberId());
                Double clouds = NumberTools.round((double) (amount * payOrder2DTO.getRate() / 100), 2);
                Result result = memberCloudsService.addClouds(memberById.getAccount(), clouds);
                MemberClouds2 memberClouds2 = (MemberClouds2) result.getData();
                memberCloudsLineService.insert(memberClouds2, clouds, remark, transType);
            }
            PayOrderDTO payOrderDTO = new PayOrderDTO();
            payOrderDTO.setId(orderId);
            payOrderDTO.setStatus("01");
            payOrderDTO.setPayId(outOrderId);
            payOrderService.update(payOrderDTO);

            return true;
        }
    }

    public Result insert(PayOrderDTO payOrderDTO) {
        return payOrderService.insert(payOrderDTO);
    }

    public Result callBack(Map<String, String> map) {
        Result result = new Result();
        PayOrderDTO payOrderDTO = new PayOrderDTO();
        payOrderDTO.setId(map.get("prdOrdNo"));
        payOrderDTO.setPayId(map.get("payId"));
        payOrderDTO.setStatus(map.get("orderStatus"));

        String orderStatus = map.get("orderStatus");
        synchronized (this) {
            PayOrder2DTO payOrder2DTO = payOrderService.getPayOrderById(map.get("prdOrdNo"));
            if (payOrder2DTO == null) {
                result.setSuccess(false);
                result.setMsg("找不到订单");
                return result;
            }

            if ("01".equals(payOrder2DTO.getStatus()) && "01".equals(orderStatus)) {
                result.setSuccess(true);
                return result;
            }

            if ("01".equals(orderStatus)) {
                //支付成功
                Result result1 = memberWalletService.update(map.get("prdOrdNo"), Double.parseDouble(map.get("orderAmount")) + "");
                Result result2 = memberWalletLineService.update2(map.get("prdOrdNo"), Double.parseDouble(map.get("orderAmount")) + "", "QQH5充值", 2064);
                if (result1.isSuccess() && result2.isSuccess()) {
                    result.setSuccess(true);
                    result.setMsg("修改会员钱包，钱包流水成功");
                }

            }
            if (!payOrder2DTO.getStatus().equals(orderStatus)) {
                payOrderService.update(payOrderDTO);
            }

            return result;
        }
    }

    public Result callBack5(Map<String, String> map) {
        Result result = new Result();
        PayOrderDTO payOrderDTO = new PayOrderDTO();
        payOrderDTO.setId(map.get("prdOrdNo"));
        payOrderDTO.setPayId(map.get("payId"));
        payOrderDTO.setStatus(map.get("orderStatus"));

        String orderStatus = map.get("orderStatus");
        synchronized (this) {
            PayOrder2DTO payOrder2DTO = payOrderService.getPayOrderById(map.get("prdOrdNo"));
            if (payOrder2DTO == null) {
                result.setSuccess(false);
                result.setMsg("找不到订单");
                return result;
            }

            if ("01".equals(payOrder2DTO.getStatus()) && "01".equals(orderStatus)) {
                result.setSuccess(true);
                return result;
            }

            if ("01".equals(orderStatus)) {
                //支付成功
                Result result1 = memberWalletService.update(map.get("prdOrdNo"), Double.parseDouble(map.get("orderAmount")) + "");
                Result result2 = memberWalletLineService.update2(map.get("prdOrdNo"), Double.parseDouble(map.get("orderAmount")) + "", "快捷支付充值", 2065);
                if (result1.isSuccess() && result2.isSuccess()) {
                    result.setSuccess(true);
                    result.setMsg("修改会员钱包，钱包流水成功");
                }

            }
            if (!payOrder2DTO.getStatus().equals(orderStatus)) {
                payOrderService.update(payOrderDTO);
            }

            return result;
        }
    }

    public Result callBack6(Map<String, String> map) {
        Result result = new Result();
        PayOrderDTO payOrderDTO = new PayOrderDTO();
        payOrderDTO.setId(map.get("prdOrdNo"));
        payOrderDTO.setPayId(map.get("payId"));
        payOrderDTO.setStatus(map.get("orderStatus"));

        String orderStatus = map.get("orderStatus");
        synchronized (this) {
            PayOrder2DTO payOrder2DTO = payOrderService.getPayOrderById(map.get("prdOrdNo"));
            if (payOrder2DTO == null) {
                result.setSuccess(false);
                result.setMsg("找不到订单");
                return result;
            }

            if ("01".equals(payOrder2DTO.getStatus()) && "01".equals(orderStatus)) {
                result.setSuccess(true);
                return result;
            }

            if ("01".equals(orderStatus)) {
                //支付成功
                Result result1 = memberWalletService.update(map.get("prdOrdNo"), Double.parseDouble(map.get("orderAmount")) + "");
                Result result2 = memberWalletLineService.update2(map.get("prdOrdNo"), Double.parseDouble(map.get("orderAmount")) + "", "QQ扫码充值", 2063);
                if (result1.isSuccess() && result2.isSuccess()) {
                    result.setSuccess(true);
                    result.setMsg("修改会员钱包，钱包流水成功");
                }

            }
            if (!payOrder2DTO.getStatus().equals(orderStatus)) {
                payOrderService.update(payOrderDTO);
            }

            return result;
        }
    }

    public Result callBack2(Map<String, String> map) {
        Result result = new Result();
        String pay_result = map.get("pay_result");
        log.info("pay_result:" + pay_result);
        if (!StringUtils.isNullOrBlank(pay_result) && "0".equals(pay_result)) {
            synchronized (this) {
                String out_trade_no = map.get("out_trade_no");
                PayOrder2DTO payOrder2DTO = payOrderService.getPayOrderById(out_trade_no);
                log.info("订单:" + out_trade_no + ",pay_result:" + pay_result);
                if (payOrder2DTO == null) {
                    log.info("找不到订单:" + out_trade_no);
                    result.setSuccess(false);
                    result.setMsg("找不到订单");
                    return result;
                }

                if ("01".equals(payOrder2DTO.getStatus())) {
                    result.setSuccess(true);
                    return result;
                }

                if (payOrder2DTO.getAmount() != Integer.parseInt(map.get("total_fee"))) {
                    result.setSuccess(false);
                    result.setMsg("数据错误");
                    return result;
                }
                if (payOrder2DTO.getType() == 1) {
                    //冲入余额
                    Result result1 = memberWalletService.update(map.get("out_trade_no"), Double.parseDouble(map.get("total_fee")) + "");
                    Result result2 = memberWalletLineService.update2(map.get("out_trade_no"), Double.parseDouble(map.get("total_fee")) + "", "微信充值", 2071);
                    if (result1.isSuccess() && result2.isSuccess()) {
                        result.setSuccess(true);
                        result.setMsg("修改会员钱包，钱包流水成功");
                    }
                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(out_trade_no);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("out_transaction_id"));

                    payOrderService.update(payOrderDTO);

                    return result;
                } else {
                    //冲入云朵
                    Member2DTO memberById = memberService.getMemberById(payOrder2DTO.getMemberId());
                    Double clouds = NumberTools.round((double) (payOrder2DTO.getAmount() * payOrder2DTO.getRate() / 100), 2);
                    result = memberCloudsService.addClouds(memberById.getAccount(), clouds);
                    if (!result.isSuccess()) {
                        return result;
                    }
                    MemberClouds2 memberClouds2 = (MemberClouds2) result.getData();
                    result = memberCloudsLineService.insert(memberClouds2, clouds, "微信充值", 2071);

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(out_trade_no);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("out_transaction_id"));

                    payOrderService.update(payOrderDTO);

                    return result;
                }
            }
        } else {
            result.setSuccess(false);
        }
        result.setSuccess(false);
        return result;
    }

    public Result callBack3(Map<String, String> map) {
        Result result = new Result();
        String state = map.get("state");
        log.info("unPay回调状态：" + state);
        if (!StringUtils.isNullOrBlank(state) && "1".equals(state)) {
            synchronized (this) {
                String sdcustomno = map.get("sdcustomno");
                log.info("unPay回调支付成功，订单号：" + sdcustomno);
                PayOrder2DTO payOrder2DTO = payOrderService.getPayOrderById(sdcustomno);

                if (payOrder2DTO == null) {
                    result.setSuccess(false);
                    result.setMsg("找不到订单");
                    return result;
                }

                if ("01".equals(payOrder2DTO.getStatus())) {
                    result.setSuccess(true);
                    return result;
                }

                if (payOrder2DTO.getAmount() != Double.parseDouble(map.get("ordermoney")) * 100) {
                    result.setSuccess(false);
                    result.setMsg("数据错误");
                    return result;
                }

                if (payOrder2DTO.getType() == 1) {
                    //冲入余额
                    Result result1 = memberWalletService.update(map.get("sdcustomno"), Double.parseDouble(map.get("ordermoney")) * 100 + "");
                    Result result2 = memberWalletLineService.update2(map.get("sdcustomno"), Double.parseDouble(map.get("ordermoney")) * 100 + "", "支付宝充值", 2070);
                    if (result1.isSuccess() && result2.isSuccess()) {
                        result.setSuccess(true);
                        result.setMsg("修改会员钱包，钱包流水成功");
                    }

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(sdcustomno);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("sd51no"));

                    payOrderService.update(payOrderDTO);

                    return result;
                } else {
                    //冲入云朵
                    Member2DTO memberById = memberService.getMemberById(payOrder2DTO.getMemberId());
                    Double clouds = NumberTools.round((double) (payOrder2DTO.getAmount() * payOrder2DTO.getRate() / 100), 2);
                    result = memberCloudsService.addClouds(memberById.getAccount(), clouds);
                    if (!result.isSuccess()) {
                        return result;
                    }
                    MemberClouds2 memberClouds2 = (MemberClouds2) result.getData();
                    result = memberCloudsLineService.insert(memberClouds2, clouds, "支付宝充值", 2070);

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(sdcustomno);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("sd51no"));

                    payOrderService.update(payOrderDTO);

                    return result;
                }
            }
        } else {
            result.setSuccess(false);
        }
        result.setSuccess(false);
        return result;
    }

    public Result getAgentChargeLine(String account, int page, int pageSize, String loginAccount, String memberAccount, String start_time, String end_time) {
        return agentChargeLineService.getAgentChargeLine(account, page, pageSize, loginAccount,memberAccount,start_time,end_time);
    }

    public Result getPayOrder(String id) {
        return payOrderService.getPayOrder(id);
    }

    public Result addPayChannel(PayChannelDTO payChannelDTO) {
        return payChannelService.addPayChannel(payChannelDTO);
    }

    public Result getPayChannelList(int page, int pageSize) {
        return payChannelService.getPayChannelList(page, pageSize);
    }

    public Result updateStatus(int id, int status) {
        return payChannelService.updateStatus(id, status);
    }

    public Result updatePayChannel(XxPay2DTO xxPay2DTO) {
        return payChannelService.updatePayChannel(xxPay2DTO);
    }

    public XxPay2DTO getPayChannelById(int id) {
        return payChannelService.getPayChannelById(id);
    }

    public Result deletePayChannel(int id) {
        return payChannelService.deletePayChannel(id);
    }

    public Member2DTO getMemberById(int id) {
        return memberService.getMemberById(id);
    }

    public XxPay2DTO getPayChannelByIdAndIsOnLineAndType(int id, int isOnLine, String type) {
        return payChannelService.getPayChannelByIdAndIsOnLineAndType(id, isOnLine, type);
    }

    public Result getPayMember(int page, int pageSize) {
        return memberService.getPayMember(page, pageSize);
    }

    public Result getPayMember(String account) {
        return memberService.getPayMember(account);
    }

    public Result updateMemberPayWays(int id, String payWays) {
        return memberService.updateMemberPayWays(id, payWays);
    }

    public Result addXxPayApply(XxPayApplyDTO xxPayApply) {
        Result result = xxPayApplyService.addXxPayApply(xxPayApply);
        Member member = memberService.getMemberByAccount(xxPayApply.getAccount());
        Member2 member2 = memberService.getMember2ByAccount(xxPayApply.getAccount());
        if (member != null && member2 != null) {
            if ("wx".equals(xxPayApply.getType())) {
                member.setWxAccount(xxPayApply.getPayAccount());
                member2.setWxAccount(xxPayApply.getPayAccount());
            } else if ("zfb".equals(xxPayApply.getType())) {
                member.setZfbAccount(xxPayApply.getPayAccount());
                member2.setZfbAccount(xxPayApply.getPayAccount());
            }
            memberService.updateMember(member);
            memberService.updateMember2(member2);
        }
        return result;
    }

    public Result getPayApplyList(int page, int pageSize) {
        return xxPayApplyService.getPayApplyList(page, pageSize);
    }

    public Result passPayApply(int id) {
        Result result = new Result();
        XxPayApply2DTO xxPayApply2DTO = xxPayApplyService.getById(id);
        if (xxPayApply2DTO == null) {
            result.setSuccess(false);
            result.setMsg("找不到对应申请");
            return result;
        }
        if (xxPayApply2DTO.getStatus() != 0) {
            result.setSuccess(false);
            result.setMsg("审核出错");
            return result;
        }
        result = xxPayApplyService.passPayApply(id);
        if (!result.isSuccess()) {
            return result;
        }
        result = memberWalletService.addMoney(xxPayApply2DTO.getAccount(), xxPayApply2DTO.getAmount());
        if (!result.isSuccess()) {
            return result;
        }
        result = memberWalletLineService.passPayApply(xxPayApply2DTO.getAccount(), xxPayApply2DTO.getAmount());
        if (!result.isSuccess()) {
            return result;
        }

        return result;
    }

    public Result refuseApply(int id) {
        return xxPayApplyService.refuseApply(id);
    }

    public MemberWallet2DTO getMemberWalletByAccount(String account) {
        return memberWalletService.getMemberWalletByAccount(account);
    }

    public Result xxCharge(String account, double amount) {
        Result result = new Result();
        result = memberWalletService.addMoney(account, amount);
        if (!result.isSuccess()) {
            return result;
        }
        result = memberWalletLineService.passPayApply(account, amount);
        //给客户增加彩金卡
        try {
            List<GoldCard2> goldCard2s = SendGoldCardUtils.sendGoldCard(amount, account);
            for (GoldCard2 g : goldCard2s) {
                int num = memberService.addGoldCard(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Result getMemberWalletLineByXx(String account, int page, int pageSize) {
        return memberWalletLineService.getMemberWalletLineByXx(account, page, pageSize);
    }

    public Result credit(double creditLimit, String account, String operatoer) {
        Result result = new Result();
        MemberWallet2DTO memberWalletByAccount = memberWalletService.getMemberWalletByAccount(account);
        MemberAgent2DTO memberAgent2DTO = memberAgentService.getByAccount(account);
        if (memberAgent2DTO == null) {
            result.setSuccess(false);
            result.setMsg("该用户还不是代理/渠道");
            return result;
        }
        if (memberWalletByAccount == null) {
            result.setSuccess(false);
            result.setMsg("找不到会员钱包");
            return result;
        }
        if (!(memberWalletByAccount.getFreezeCreditBalance() == null || memberWalletByAccount.getFreezeCreditBalance() == 0)) {
            result.setSuccess(false);
            result.setMsg("还有金额未还款不能更改授信金额");
            return result;
        }
        memberWalletByAccount.setCreditLimit(creditLimit);
        memberWalletByAccount.setAbleCreditBalance(creditLimit);
        result = memberWalletService.updateMemberWallet(memberWalletByAccount);
        if (!result.isSuccess()) {
            return result;
        }
        Member2 member2ByAccount = memberService.getMember2ByAccount(account);
        Member2 member2 = member2ByAccount;
        System.out.println(member2);
        CreditLimitLine2DTO creditLimitLine2DTO = new CreditLimitLine2DTO();
        creditLimitLine2DTO.setAccount(account);
        creditLimitLine2DTO.setCreditLimit(creditLimit);
        creditLimitLine2DTO.setMemberId(memberAgent2DTO.getMemberId());
        creditLimitLine2DTO.setOperator(operatoer);
        creditLimitLine2DTO.setUpdateTime(new Date());
        creditLimitLine2DTO.setType(memberAgent2DTO.getAgentType());
        result = creditLimitLineService.insert(creditLimitLine2DTO);

        return result;
    }


    public Result creditRefundApply(String account, double amount) {
        return creditRefundService.creditRefundApply(account, amount);
    }

    public Result passCreditRefundApply(String account, int id) {
        Result result = new Result();
        CreditRefund2DTO byId = creditRefundService.getById(id);
        MemberWallet2DTO memberWalletByAccount = memberWalletService.getMemberWalletByAccount(byId.getAccount());
        if (memberWalletByAccount.getFreezeCreditBalance()-byId.getAmount()<0){
            result.setSuccess(false);
            result.setMsg("冻结金额不足!");
            return result;
        }

        result = creditRefundService.passCreditRefundApply(account, id);
        if (!result.isSuccess()) {
            return result;
        }

        CreditRefund2DTO creditRefund2DTO = creditRefundService.getById(id);
        if (creditRefund2DTO == null) {
            result.setSuccess(false);
            result.setMsg("找不到申请");
            return result;
        }
        result = memberWalletService.updateCreditBalance(creditRefund2DTO.getAccount(), -creditRefund2DTO.getAmount());

        return result;
    }

    public Result refuseCreditRefundApply(String account, int id) {
        return creditRefundService.refuseCreditRefundApply(account, id);
    }

    public Result getCreditLimitLine(int page, int pageSize, String account, String loginAccount) {
        return creditLimitLineService.getCreditLimitLine(page, pageSize, account,loginAccount);
    }

    public Result getCreditRefund(int page, int pageSize, String account, int status, String loginAccount, String operator, String startTime, String endTime) {
        return creditRefundService.getCreditRefund(page, pageSize, account, status, loginAccount,operator,startTime,endTime);
    }


    public Result agentCharge(String account, double amount, String DLAccount, String DLUsername,String pay_pass) {
        Result result = new Result();
        if (!account.substring(0, 2).equals("sj")) {
            Member2 member2 = memberService.getMember2ByUsername(account);
            account = member2.getAccount();
        }

        Member2 member2ByAccount = memberService.getMember2ByAccount(account);
        Member2 member2ByAccount2 = memberService.getMember2ByAccount(DLAccount);
        if (member2ByAccount.getSourceId() != member2ByAccount2.getId()) {
            result.setSuccess(false);
            result.setMsg("只能给自己名下代理充值");
        }
//查询代理的支付密码
        MemberAgent2DTO byAccount = memberAgentService.getByAccount(DLAccount);
        if (byAccount.getPayPass()==null){
            result.setSuccess(false);
            result.setMsg("请先去个人中心设置支付密码");
            return  result;
        }


        if (!byAccount.getPayPass().equals(MD5.encode(pay_pass))){
            result.setSuccess(false);
            result.setMsg("支付密码错误");
            return  result;
        }
        //修改客户钱包
        result = memberWalletService.addMoney(account, amount);
        if (!result.isSuccess()) {
            return result;
        }
        //添加客户钱包流水
        result = memberWalletLineService.passPayApply2(account, amount);
        if (!result.isSuccess()) {
            return result;
        }
        //修改代理授余额，冻结金额
        result = memberWalletService.updateCreditBalance(DLAccount, amount);
        if (!result.isSuccess()) {
            return result;
        }

        if (member2ByAccount == null) {
            result.setSuccess(false);
            result.setMsg("找不到会员");
            return result;
        }
        MemberWallet2DTO memberWalletByAccount = memberWalletService.getMemberWalletByAccount(account);
        if (memberWalletByAccount == null) {
            result.setSuccess(false);
            result.setMsg("找不到会员钱包");
            return result;
        }
        MemberWallet2DTO memberWalletByAccount1 = memberWalletService.getMemberWalletByAccount(DLAccount);
        if (memberWalletByAccount1 == null) {
            result.setSuccess(false);
            result.setMsg("找不到会员钱包");
            return result;
        }
        //给客户增加彩金卡
        try {
            List<GoldCard2> goldCard2s = SendGoldCardUtils.sendGoldCard(amount, account);
            for (GoldCard2 g : goldCard2s) {
                int num = memberService.addGoldCard(g);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //添加代理充值流水
        AgentChargeLine2DTO agentChargeLine2DTO = new AgentChargeLine2DTO();
        agentChargeLine2DTO.setAgentAccount(DLAccount);
        agentChargeLine2DTO.setAccount(account);
        agentChargeLine2DTO.setUsername(member2ByAccount.getUsername());
        agentChargeLine2DTO.setAmount(amount);
        agentChargeLine2DTO.setCreateTime(new Date());
        agentChargeLine2DTO.setCreditLimit(memberWalletByAccount1.getCreditLimit());
        agentChargeLine2DTO.setAbleCreditBalance(memberWalletByAccount1.getAbleCreditBalance());
        agentChargeLine2DTO.setFreezeCreditBalance(memberWalletByAccount1.getFreezeCreditBalance());
        result = agentChargeLineService.insert(agentChargeLine2DTO);
        return result;
    }

    public List<MemberDrawing> findMemberDrawingByAccount(String account) {

        return payOrderService.findMemberDrawingByAccount(account);
    }

    public int addMemberOperTrack(MemberOperTrack requestInfo) {

        return payOrderService.addMemberOperTrack(requestInfo);
    }

    public Map addWithdrawalOrder(MemberDrawing drawing, MemberWallet2DTO memberWallet, Member2DTO member, MemberOperTrack requestInfo) {
        Map mapInfo = new HashMap();
        try {


            int i = payOrderService.addWithdrawalOrder(drawing);
            //成功
            if (i > 0) {
                if (DbDataVerify2.checkMemberWalletVerify(memberWallet, memberWallet.getVerifyMd5())) {
                    //进行钱包余额操作
                    if (drawing.getAmount() < 0) {
                        throw new Exception("冻结金额不能小于0");
                    }
                    //设置可用余额
                    memberWallet.setAbleBalance(NumberTools.round(memberWallet.getAbleBalance() - drawing.getAmount(),2));
                    //设置冻结金额
                    memberWallet.setFreezeBalance(NumberTools.round(Double.valueOf(memberWallet.getFreezeBalance() + drawing.getAmount()),2));
                    //修改可提现金额
                    memberWallet.setTakeCashQuota(NumberTools.round(Double.valueOf(memberWallet.getTakeCashQuota() - drawing.getAmount()),2));
                    memberWallet.setVerifyMd5(DbDataVerify2.getMemberWalletVerify(memberWallet));
                    //进行钱包修改操作
                    payOrderService.updateWalltInfo(memberWallet);
                    //生成钱包流水
                    MemberWalletLine2 walletLine = new MemberWalletLine2();
                    walletLine.setAccount(member.getAccount());
                    walletLine.setSourceId(member.getSourceId());
                    walletLine.setAmount(NumberTools.round(Double.valueOf(drawing.getAmount()),2));
                    walletLine.setCreateDateTime(new Date());
                    walletLine.setLotteryType(-1);
                    walletLine.setMemberId(member.getId());
                    walletLine.setOperLineNo(requestInfo.getOPER_LINE_NO());
                    walletLine.setOrderNo(0);
                    walletLine.setPlanNo(0);
                    walletLine.setStatus(new Integer(0));
                    walletLine.setTransType(31);
                    walletLine.setWalletType(1);
                    walletLine.setSourceId(member.getSourceId());
                    walletLine.setAbleBalance(NumberTools.round(memberWallet.getAbleBalance(),2));
                    walletLine.setPrizeBalance(memberWallet.getPrizeBalance());
                    walletLine.setFreezeBalance(NumberTools.round(memberWallet.getFreezeBalance(),2));
                    walletLine.setHeapBalance(NumberTools.round(memberWallet.getHeapBalance(),2));
                    walletLine.setRemark("申请提款");
                    walletLine.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(walletLine));
                    walletLine.setPlatform(drawing.getPlatform());
                    //保存钱包流水
                    payOrderService.addwalltLineInfo(walletLine);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            mapInfo.put(Constants.CODE, Constants.ERROR_CODE_400);
            mapInfo.put(Constants.MSG, "提款失败,请联系管理员");
            return mapInfo;
        }
        mapInfo.put(Constants.CODE, Constants.SUCCESS_CODE);
        mapInfo.put(Constants.MSG, "提款申请发起成功");
        return mapInfo;
    }

    public Result callBack7(Map<String, String> map) {
        Result result = new Result();
        String result_pay = map.get("result_pay");
        log.info("lianlian连连回调状态：" + result_pay);
        if (!StringUtils.isNullOrBlank(result_pay) && "SUCCESS".equals(result_pay)) {
            synchronized (this) {
                String no_order = map.get("no_order");
                log.info("lianlian连连回调支付成功，订单号：" + no_order);
                PayOrder2DTO payOrder2DTO = payOrderService.getPayOrderById(no_order);

                if (payOrder2DTO == null) {
                    result.setSuccess(false);
                    result.setMsg("找不到订单");
                    return result;
                }

                if ("01".equals(payOrder2DTO.getStatus())) {
                    result.setSuccess(true);
                    return result;
                }

                if (payOrder2DTO.getAmount() != Double.parseDouble(map.get("money_order")) * 100) {
                    result.setSuccess(false);
                    result.setMsg("数据错误");
                    return result;
                }

                if (payOrder2DTO.getType() == 1) {
                    //冲入余额
                    Result result1 = memberWalletService.update(map.get("no_order"), Double.parseDouble(map.get("money_order")) * 100 + "");
                    Result result2 = memberWalletLineService.update2(map.get("no_order"), Double.parseDouble(map.get("money_order")) * 100 + "", "快捷支付充值", 2072);
                    if (result1.isSuccess() && result2.isSuccess()) {
                        result.setSuccess(true);
                        result.setMsg("修改会员钱包，钱包流水成功");
                    }

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(no_order);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("oid_paybill"));

                    payOrderService.update(payOrderDTO);

                    return result;
                } else {
                    //冲入云朵
                    Member2DTO memberById = memberService.getMemberById(payOrder2DTO.getMemberId());
                    Double clouds = NumberTools.round((double) (payOrder2DTO.getAmount() * payOrder2DTO.getRate() / 100), 2);
                    result = memberCloudsService.addClouds(memberById.getAccount(), clouds);
                    if (!result.isSuccess()) {
                        return result;
                    }
                    MemberClouds2 memberClouds2 = (MemberClouds2) result.getData();
                    result = memberCloudsLineService.insert(memberClouds2, clouds, "快捷支付充值", 2072);

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(no_order);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("oid_paybill"));

                    payOrderService.update(payOrderDTO);

                    return result;
                }
            }
        } else {
            result.setSuccess(false);
        }
        result.setSuccess(false);
        return result;
    }

    public Map<String, Object> chargeFix(Map paramsMap) {
        Map resMap = new HashMap();
        try {
            //查询客户

            Member2DTO member = memberService.getMemberById(Integer.parseInt(paramsMap.get("memberId").toString()));
            if (member == null) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "该账户不存在");
                return resMap;
            }
            PayOrder2 line = payOrderService.findById(paramsMap);
            if (!(line.getMemberId()+"").equals(paramsMap.get("memberId"))) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "账号信息不匹配");
                return resMap;
            }

            if (line.getAmount().doubleValue() != Double.valueOf(paramsMap.get("amount") + "")) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "请输入正确金额");
                return resMap;
            }

            if (Integer.parseInt(line.getStatus()) == Integer.valueOf(01)) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "已经成功的订单不允许重复补单!");
                return resMap;
            }

            //查询客户钱包
            MemberWallet2DTO memberWalletByAccount = memberWalletService.getMemberWalletByAccount(member.getAccount());
            if (memberWalletByAccount == null) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "未找到该客户钱包");
                return resMap;
            }
            //修改客户钱包
            memberWalletByAccount.setAbleBalance(memberWalletByAccount.getAbleBalance() + Double.valueOf(paramsMap.get("amount") + ""));
            memberWalletByAccount.setTakeCashQuota(memberWalletByAccount.getTakeCashQuota() + Double.valueOf(paramsMap.get("amount") + ""));
            memberWalletService.updateMemberWallet(memberWalletByAccount);
            //生成钱包流水

            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setAbleBalance(memberWalletByAccount.getAbleBalance() + Double.valueOf(paramsMap.get("amount") + ""));
            memberWalletLine2.setAccount(memberWalletByAccount.getAccount());
            memberWalletLine2.setAmount(Double.valueOf(paramsMap.get("amount") + ""));
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setFreezeBalance(memberWalletByAccount.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWalletByAccount.getHeapBalance());
            memberWalletLine2.setLotteryType(0);
            memberWalletLine2.setMemberId(memberWalletByAccount.getMemberId());
            memberWalletLine2.setOperLineNo(0);
            memberWalletLine2.setOrderNo(0);
            memberWalletLine2.setPlanNo(0);
            memberWalletLine2.setPlatform(1);
            memberWalletLine2.setPrizeBalance(memberWalletByAccount.getPrizeBalance());
            memberWalletLine2.setRemark("充值补单");
            memberWalletLine2.setSourceId(member.getSourceId());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setTransType(com.qiyun.type.WalletTransType.RECHARGE_FIX.getValue());
            memberWalletLine2.setWalletType(1);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            //保存钱包流水
            memberWalletLineService.insertSelective(memberWalletLine2);
            //修改订单状态
            PayOrderDTO payOrder2DTO = new PayOrderDTO();
            payOrder2DTO.setStatus("01");
            payOrder2DTO.setId(line.getId());
            int   i   = payOrderService.update(payOrder2DTO);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, "补单成功!");
        } catch (Exception ex) {
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "服务器内部错误!");
        }
        return resMap;
    }

    public Map<String, Object> getAllFailPayOrder(Map paramsMap, Integer page, Integer pageSize) {
        Map resMap = new HashMap();
        try {
            PageHelper.startPage(page,pageSize);
            List<Map> list = payOrderService.getAllFailPayOrder(paramsMap);
            PageInfo pageInfo = new PageInfo(list);
            if (list.size() > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "查询成功");
                resMap.put(Constants.DATA, pageInfo);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "查询失败");
            }
        } catch (Exception ex) {
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "服务器内部错误!");
        }
        return resMap;

    }

    public Result callBack8(SortedMap<String, String> map) {
        Result result = new Result();
        String state = map.get("state");
        log.info("引付回调状态：" + state);
        if (!StringUtils.isNullOrBlank(state) && "0".equals(state)) {
            synchronized (this) {
                String order_id = map.get("order_id");
                log.info("引付回调支付成功，订单号：" + order_id);
                PayOrder2DTO payOrder2DTO = payOrderService.getPayOrderById(order_id);

                if (payOrder2DTO == null) {
                    result.setSuccess(false);
                    result.setMsg("找不到订单");
                    return result;
                }

                if ("01".equals(payOrder2DTO.getStatus())) {
                    result.setSuccess(true);
                    return result;
                }

                if (payOrder2DTO.getAmount() != Integer.parseInt(map.get("order_amt"))) {
                    result.setSuccess(false);
                    result.setMsg("数据错误");
                    return result;
                }

                if (payOrder2DTO.getType() == 1) {
                    //冲入余额
                    Result result1 = memberWalletService.update(order_id, Integer.parseInt(map.get("order_amt")) + "");
                    Result result2 = memberWalletLineService.update2(order_id, Integer.parseInt(map.get("order_amt")) + "", "微信扫码充值", 2073);
                    if (result1.isSuccess() && result2.isSuccess()) {
                        result.setSuccess(true);
                        result.setMsg("修改会员钱包，钱包流水成功");
                    }

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(order_id);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("up_order_id"));

                    payOrderService.update(payOrderDTO);

                    return result;
                } else {
                    //冲入云朵
                    Member2DTO memberById = memberService.getMemberById(payOrder2DTO.getMemberId());
                    Double clouds = NumberTools.round((double) (payOrder2DTO.getAmount() * payOrder2DTO.getRate() / 100), 2);
                    result = memberCloudsService.addClouds(memberById.getAccount(), clouds);
                    if (!result.isSuccess()) {
                        return result;
                    }
                    MemberClouds2 memberClouds2 = (MemberClouds2) result.getData();
                    result = memberCloudsLineService.insert(memberClouds2, clouds, "微信扫码充值", 2073);

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(order_id);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("up_order_id"));

                    payOrderService.update(payOrderDTO);

                    return result;
                }
            }
        } else {
            result.setSuccess(false);
        }
        result.setSuccess(false);
        return result;
    }

    public Result callBack9(SortedMap<String, String> map) {
        Result result = new Result();
        String state = map.get("state");
        log.info("引付回调状态：" + state);
        if (!StringUtils.isNullOrBlank(state) && "0".equals(state)) {
            synchronized (this) {
                String order_id = map.get("order_id");
                log.info("引付回调支付成功，订单号：" + order_id);
                PayOrder2DTO payOrder2DTO = payOrderService.getPayOrderById(order_id);

                if (payOrder2DTO == null) {
                    result.setSuccess(false);
                    result.setMsg("找不到订单");
                    return result;
                }

                if ("01".equals(payOrder2DTO.getStatus())) {
                    result.setSuccess(true);
                    return result;
                }

                if (payOrder2DTO.getAmount() != Integer.parseInt(map.get("order_amt"))) {
                    result.setSuccess(false);
                    result.setMsg("数据错误");
                    return result;
                }

                if (payOrder2DTO.getType() == 1) {
                    //冲入余额
                    Result result1 = memberWalletService.update(order_id, Integer.parseInt(map.get("order_amt")) + "");
                    Result result2 = memberWalletLineService.update2(order_id, Integer.parseInt(map.get("order_amt")) + "", "QQ扫码充值", 2074);
                    if (result1.isSuccess() && result2.isSuccess()) {
                        result.setSuccess(true);
                        result.setMsg("修改会员钱包，钱包流水成功");
                    }

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(order_id);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("up_order_id"));

                    payOrderService.update(payOrderDTO);

                    return result;
                } else {
                    //冲入云朵
                    Member2DTO memberById = memberService.getMemberById(payOrder2DTO.getMemberId());
                    Double clouds = NumberTools.round((double) (payOrder2DTO.getAmount() * payOrder2DTO.getRate() / 100), 2);
                    result = memberCloudsService.addClouds(memberById.getAccount(), clouds);
                    if (!result.isSuccess()) {
                        return result;
                    }
                    MemberClouds2 memberClouds2 = (MemberClouds2) result.getData();
                    result = memberCloudsLineService.insert(memberClouds2, clouds, "QQ扫码充值", 2074);

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(order_id);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("up_order_id"));

                    payOrderService.update(payOrderDTO);

                    return result;
                }
            }
        } else {
            result.setSuccess(false);
        }
        result.setSuccess(false);
        return result;
    }


    public Map<String, Object> chargeRight(Map paramsMap) {
        Map resMap = new HashMap();
        try {
            Member2 member = memberService.getMember2ByAccount(paramsMap.get("account").toString());
            if (member == null) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "该账户不存在");
                return resMap;
            }
            //查找用户钱包
            MemberWallet2DTO memberWalletByAccount = memberWalletService.getMemberWalletByAccount(member.getAccount());
            if (memberWalletByAccount == null) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "未找到该客户钱包");
                return resMap;
            }
            //判断冲正金额是否大于余额
            if (memberWalletByAccount.getAbleBalance() < Double.valueOf(paramsMap.get("amount") + "")) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "冲正金额不能大于余额");
                return resMap;
            }
            if (memberWalletByAccount.getTakeCashQuota() < Double.valueOf(paramsMap.get("amount") + "")) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "可提现金额不能小于冲正金额");
                return resMap;
            }
            //修改客户钱包
            memberWalletByAccount.setAbleBalance(NumberTools.round(memberWalletByAccount.getAbleBalance() - Double.valueOf(paramsMap.get("amount") + ""),2));
            memberWalletByAccount.setTakeCashQuota(NumberTools.round(memberWalletByAccount.getTakeCashQuota() - Double.valueOf(paramsMap.get("amount") + ""),2));
            memberWalletService.updateMemberWallet(memberWalletByAccount);
            //生成钱包流水

            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setAbleBalance(memberWalletByAccount.getAbleBalance() + Double.valueOf(paramsMap.get("amount") + ""));
            memberWalletLine2.setAccount(memberWalletByAccount.getAccount());
            memberWalletLine2.setAmount(Double.valueOf(paramsMap.get("amount") + ""));
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setFreezeBalance(memberWalletByAccount.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWalletByAccount.getHeapBalance());
            memberWalletLine2.setLotteryType(0);
            memberWalletLine2.setMemberId(memberWalletByAccount.getMemberId());
            memberWalletLine2.setOperLineNo(0);
            memberWalletLine2.setOrderNo(0);
            memberWalletLine2.setPlanNo(0);
            memberWalletLine2.setPlatform(1);
            memberWalletLine2.setPrizeBalance(memberWalletByAccount.getPrizeBalance());
            memberWalletLine2.setRemark(paramsMap.get("desc") + "");
            memberWalletLine2.setSourceId(member.getSourceId());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setTransType(0);
            memberWalletLine2.setWalletType(-1000);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            //保存钱包流水
            memberWalletLineService.insertSelective(memberWalletLine2);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, "操作成功");
        } catch (Exception ex) {
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "服务器内部错误!");
        }
        return resMap;
    }


    public Result callBack10(SortedMap<String, String> map) {
        Result result = new Result();
        String state = map.get("state");
        log.info("引付回调状态：" + state);
        if (!StringUtils.isNullOrBlank(state) && "0".equals(state)) {
            synchronized (this) {
                String order_id = map.get("order_id");
                log.info("引付回调支付成功，订单号：" + order_id);
                PayOrder2DTO payOrder2DTO = payOrderService.getPayOrderById(order_id);

                if (payOrder2DTO == null) {
                    result.setSuccess(false);
                    result.setMsg("找不到订单");
                    return result;
                }

                if ("01".equals(payOrder2DTO.getStatus())) {
                    result.setSuccess(true);
                    return result;
                }

                if (payOrder2DTO.getAmount() != Integer.parseInt(map.get("order_amt"))) {
                    result.setSuccess(false);
                    result.setMsg("数据错误");
                    return result;
                }

                if (payOrder2DTO.getType() == 1) {
                    //冲入余额
                    Result result1 = memberWalletService.update(order_id, Integer.parseInt(map.get("order_amt")) + "");
                    Result result2 = memberWalletLineService.update2(order_id, Integer.parseInt(map.get("order_amt")) + "", "网银充值", 2075);
                    if (result1.isSuccess() && result2.isSuccess()) {
                        result.setSuccess(true);
                        result.setMsg("修改会员钱包，钱包流水成功");
                    }

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(order_id);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("up_order_id"));

                    payOrderService.update(payOrderDTO);

                    return result;
                } else {
                    //冲入云朵
                    Member2DTO memberById = memberService.getMemberById(payOrder2DTO.getMemberId());
                    Double clouds = NumberTools.round((double) (payOrder2DTO.getAmount() * payOrder2DTO.getRate() / 100), 2);
                    result = memberCloudsService.addClouds(memberById.getAccount(), clouds);
                    if (!result.isSuccess()) {
                        return result;
                    }
                    MemberClouds2 memberClouds2 = (MemberClouds2) result.getData();
                    result = memberCloudsLineService.insert(memberClouds2, clouds, "网银充值", 2075);

                    PayOrderDTO payOrderDTO = new PayOrderDTO();
                    payOrderDTO.setId(order_id);
                    payOrderDTO.setStatus("01");
                    payOrderDTO.setPayId(map.get("up_order_id"));

                    payOrderService.update(payOrderDTO);

                    return result;
                }
            }
        } else {
            result.setSuccess(false);
        }
        result.setSuccess(false);
        return result;
    }

    public Result findMemberDrawingList(String loginAccount, String account, String start_time, String end_time, String flow_num, String is_drawing_time,Integer page,Integer pageSize,Integer status) {


        return payOrderService.findMemberDrawingList(loginAccount,account,start_time,end_time,flow_num,is_drawing_time,page,pageSize,status);
    }

    public Map memberDrawingReview(Map paramsMap) {
        Map resMap = new HashMap();
        //查询那条流水
        try {
        MemberDrawing memberDrawing = payOrderService.findDrawingById(paramsMap.get("drawingId") + "");
        //判断这个订单的状态
        if (memberDrawing.getStatus()==DrawingStatus.SUCCESS_OVER.getValue()){
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "该订单已经汇款");
            return resMap;
        }

        Member2 member = memberService.getMember2ByAccount(paramsMap.get("account").toString());
        if (member == null) {
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "该账户不存在");
            return resMap;
        }
        //查找用户钱包
        MemberWallet2DTO memberWallet = memberWalletService.getMemberWalletByAccount(member.getAccount());
        if (memberWallet == null) {
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "未找到该客户钱包");
            return resMap;
        }
        //审核通过
        if (Integer.parseInt(paramsMap.get("status")+"")==1){

            //设置冻结金额
            memberWallet.setFreezeBalance(NumberTools.round(Double.valueOf(memberWallet.getFreezeBalance() - memberDrawing.getAmount()),2));
            memberWallet.setVerifyMd5(DbDataVerify2.getMemberWalletVerify(memberWallet));
            //进行钱包修改操作
            payOrderService.updateWalltInfo(memberWallet);
            //生成钱包流水

            MemberWalletLine2 walletLine = new MemberWalletLine2();
            walletLine.setAccount(member.getAccount());
            walletLine.setSourceId(member.getSourceId());
            walletLine.setAmount(NumberTools.round(Double.valueOf(memberDrawing.getAmount()),2));
            walletLine.setCreateDateTime(new Date());
            walletLine.setLotteryType(-1);
            walletLine.setMemberId(member.getId());
            walletLine.setOperLineNo(0);
            walletLine.setOrderNo(0);
            walletLine.setPlanNo(0);
            walletLine.setStatus(new Integer(0));
            walletLine.setTransType(WalletTransType.SUBSTRACT.getValue());
            walletLine.setWalletType(1);
            walletLine.setSourceId(member.getSourceId());
            walletLine.setAbleBalance(NumberTools.round(memberWallet.getAbleBalance(),2));
            walletLine.setPrizeBalance(NumberTools.round(memberWallet.getPrizeBalance(),2));
            walletLine.setFreezeBalance(NumberTools.round(memberWallet.getFreezeBalance(),2));
            walletLine.setHeapBalance(NumberTools.round(memberWallet.getHeapBalance(),2));
            walletLine.setRemark("提款审核通过");
            walletLine.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(walletLine));
            walletLine.setPlatform(memberDrawing.getPlatform());
            //保存钱包流水
            payOrderService.addwalltLineInfo(walletLine);
            //修改drawing状态
            memberDrawing.setStatus(DrawingStatus.SUCCESS_OVER.getValue());
            memberDrawing.setFinanceDealDateTime(new Date());
            memberDrawing.setConfirmDateTime(new Date());
            memberDrawing.setSendDateTime(new Date());
            payOrderService.updateDrawing(memberDrawing);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, "操作成功");
        }else if(Integer.parseInt(paramsMap.get("status")+"")==0) {
            //修改drawing状态
            memberDrawing.setStatus(DrawingStatus.CHECKED_FAILURE.getValue());
            memberDrawing.setReturnRemark(Integer.parseInt(paramsMap.get("returnRemark")+""));
            memberDrawing.setRemark(paramsMap.get("remark")+"");
            payOrderService.updateDrawing(memberDrawing);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, "操作成功");
        }
        }catch (Exception ex){
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "服务器内部错误!");
        }
        return resMap;
    }


}
