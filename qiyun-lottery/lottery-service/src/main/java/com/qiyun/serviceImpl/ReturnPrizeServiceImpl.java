package com.qiyun.serviceImpl;

import com.qiyun.mapper2.*;
import com.qiyun.model.WalletType;
import com.qiyun.model.WinStatus;
import com.qiyun.model2.*;
import com.qiyun.service.ReturnPrizeService;

import com.qiyun.type.WalletTransType;
import com.qiyun.utils.DbDataVerify;
import com.qiyun.utils.NumberTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("returnPrizeService")
public class ReturnPrizeServiceImpl implements ReturnPrizeService {

    @Resource
    private Ticket2Mapper ticket2Mapper;
    @Resource
    private LotteryPlanOrder2Mapper lotteryPlanOrder2Mapper;
    @Resource
    private LotteryPlan2Mapper lotteryPlan2Mapper;
    @Resource
    private MemberWallet2Mapper memberWallet2Mapper;
    @Resource
    private MemberWalletLine2Mapper memberWalletLine2Mapper;
    @Resource
    private Member2Mapper member2Mapper;
    @Resource
    private DgMapper dgMapper;
    @Resource
    private LotteryPlanAddPrize2Mapper lotteryPlanAddPrize2Mapper;

    /**
     * 派奖
     * @param planNo
     */
    public void returnPrize(Integer planNo) {
        LotteryPlan2WithBLOBs plan = lotteryPlan2Mapper.selectByPrimaryKey(planNo);
        if (plan.getWinStatus() != WinStatus.AWARD.getValue()) {
            return;// 如果方案不是已中奖状态，跳过
        }

        LotteryPlanOrder2Query lotteryPlanOrder2Query = new LotteryPlanOrder2Query();
        LotteryPlanOrder2Query.Criteria criteria = lotteryPlanOrder2Query.createCriteria();
        criteria.andPlanNoEqualTo(plan.getPlanNo());
        List<LotteryPlanOrder2> orderList = lotteryPlanOrder2Mapper.selectByExample(lotteryPlanOrder2Query);

        LotteryPlanOrder2 order = orderList.get(0);
        //修改订单状态
        order.setPosttaxPrize(NumberTools.round(plan.getPosttaxPrize(), 2));
        order.setPrizeSettleStatus(0);
        order.setPrizeSettleDateTime(new Date());

        double prize = plan.getPosttaxPrize();
        if (plan.getIsSuperMan()==0 && NumberTools.div(plan.getPosttaxPrize(),(double)plan.getAmount(),2)>1.6){
            //发单佣金
            LotteryPlan2WithBLOBs superPlan = lotteryPlan2Mapper.selectByPrimaryKey(plan.getPlannoCopydocumentary());
            LotteryPlanOrder2 superOrder = lotteryPlanOrder2Mapper.getByPlanNo(plan.getPlannoCopydocumentary());
            Double gold = NumberTools.round(plan.getPosttaxPrize() * 0.1, 2); //跟单人所交佣金
            Double webGold = NumberTools.round(gold*0.2, 2); //平台收佣
            Double superGold = NumberTools.round(gold*0.8, 2); //发单人收佣
            prize = NumberTools.round(prize*0.9,2);
            //设置跟单人所交佣金、平台收佣
            order.setGold(gold);
            order.setWebSiteGold(webGold);
            //设置发单人收佣
            superOrder.setSumGold(NumberTools.round(superOrder.getSumGold()+superGold,2));
            lotteryPlanOrder2Mapper.updateByPrimaryKeySelective(superOrder);

            //修改发单人钱包
            MemberWallet2 superWallet = memberWallet2Mapper.getByAccount(superPlan.getAccount());
            superWallet.setAbleBalance(NumberTools.round(superWallet.getAbleBalance()+superGold,2));
            superWallet.setTakeCashQuota(NumberTools.round(superWallet.getTakeCashQuota()+superGold,2));
            memberWallet2Mapper.updateByPrimaryKeySelective(superWallet);

            //添加发单人收佣流水
            Member2 superMember = member2Mapper.selectByAccount(superPlan.getAccount());
            MemberWalletLine2 superWalletLine2 = new MemberWalletLine2();
            superWalletLine2.setPlanNo(superPlan.getPlanNo());
            superWalletLine2.setOrderNo(superOrder.getOrderNo());
            superWalletLine2.setAccount(superMember.getAccount());
            superWalletLine2.setMemberId(superMember.getId());
            superWalletLine2.setTransType(WalletTransType.Gold.getValue());
            superWalletLine2.setWalletType(WalletType.DUOBAO.getValue());
            superWalletLine2.setAmount(superGold);
            superWalletLine2.setLotteryType(superPlan.getLotteryType());
            superWalletLine2.setCreateDateTime(new Date());
            superWalletLine2.setStatus(0);
            superWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(superWalletLine2));
            superWalletLine2.setSourceId(superMember.getSourceId());
            superWalletLine2.setAbleBalance(superWallet.getAbleBalance());
            superWalletLine2.setFreezeBalance(superWallet.getFreezeBalance());
            superWalletLine2.setHeapBalance(superWallet.getHeapBalance());
            superWalletLine2.setRemark("收佣:"+plan.getPlanNo());
            memberWalletLine2Mapper.insertSelective(superWalletLine2);

            //平台收佣
            MemberWallet2 ptWallet = memberWallet2Mapper.getByAccount("sj878466008");
            ptWallet.setAbleBalance(NumberTools.round(ptWallet.getAbleBalance()+webGold,2));
            ptWallet.setTakeCashQuota(NumberTools.round(ptWallet.getTakeCashQuota()+webGold,2));
            memberWallet2Mapper.updateByPrimaryKeySelective(ptWallet);

            //平台收佣流水
            Member2 ptMember = member2Mapper.selectByAccount("sj878466008");
            MemberWalletLine2 ptWalletLine = new MemberWalletLine2();
            ptWalletLine.setAccount(ptMember.getAccount());
            ptWalletLine.setMemberId(ptMember.getId());
            ptWalletLine.setTransType(WalletTransType.Gold.getValue());
            ptWalletLine.setWalletType(WalletType.DUOBAO.getValue());
            ptWalletLine.setAmount(webGold);
            ptWalletLine.setLotteryType(superPlan.getLotteryType());
            ptWalletLine.setCreateDateTime(new Date());
            ptWalletLine.setStatus(0);
            ptWalletLine.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(ptWalletLine));
            ptWalletLine.setSourceId(ptMember.getSourceId());
            ptWalletLine.setAbleBalance(ptWallet.getAbleBalance());
            ptWalletLine.setFreezeBalance(ptWallet.getFreezeBalance());
            ptWalletLine.setHeapBalance(ptWallet.getHeapBalance());
            ptWalletLine.setRemark("平台收佣:"+plan.getPlanNo());
            memberWalletLine2Mapper.insertSelective(ptWalletLine);

        }
        lotteryPlanOrder2Mapper.updateByPrimaryKeySelective(order);

        //会员钱包派奖
        Member2 member2 = member2Mapper.selectByAccount(plan.getAccount());
        MemberWallet2 memberWallet2 = memberWallet2Mapper.getByAccount(member2.getAccount());
        memberWallet2.setAbleBalance(NumberTools.round(memberWallet2.getAbleBalance()+prize,2));
        memberWallet2.setTakeCashQuota(NumberTools.round(memberWallet2.getTakeCashQuota()+prize,2));
        memberWallet2.setHeapPrize(NumberTools.round(memberWallet2.getHeapPrize()+prize,2));
        memberWallet2Mapper.updateByPrimaryKeySelective(memberWallet2);

        //派奖流水
        MemberWalletLine2 memberWalletLine = new MemberWalletLine2();
        memberWalletLine.setAccount(member2.getAccount());
        memberWalletLine.setMemberId(member2.getId());
        memberWalletLine.setTransType(WalletTransType.RETURN_PRIZE.getValue());
        memberWalletLine.setWalletType(WalletType.DUOBAO.getValue());
        memberWalletLine.setAmount(prize);
        memberWalletLine.setLotteryType(plan.getLotteryType());
        memberWalletLine.setCreateDateTime(new Date());
        memberWalletLine.setStatus(0);
        memberWalletLine.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine));
        memberWalletLine.setSourceId(member2.getSourceId());
        memberWalletLine.setAbleBalance(memberWallet2.getAbleBalance());
        memberWalletLine.setFreezeBalance(memberWallet2.getFreezeBalance());
        memberWalletLine.setHeapBalance(memberWallet2.getHeapBalance());
        memberWalletLine.setRemark("派奖:"+plan.getPlanNo());
        memberWalletLine2Mapper.insertSelective(memberWalletLine);

        // 更改方案的中奖状态为已派奖，防止二次派奖。
        plan.setWinStatus(WinStatus.SEND_AWARD.getValue());
        // 更新方案中奖金额、嘉奖
        double addPrize = handle(plan);
        plan.setPosttaxPrize(NumberTools.round(plan.getPosttaxPrize(),2));
        plan.setReturnPrizeTime(new Date());
        plan.setArrivalTime(new Date());//增加到帐时间
        plan.setAddPrize(addPrize);
        lotteryPlan2Mapper.updateByPrimaryKeySelective(plan);

        if (addPrize>0) {
            //嘉奖  钱包修改
            memberWallet2.setAbleBalance(NumberTools.round(memberWallet2.getAbleBalance() + addPrize,2));
//            memberWallet2.setTakeCashQuota(NumberTools.round(memberWallet2.getTakeCashQuota() + addPrize,2));
            memberWallet2Mapper.updateByPrimaryKeySelective(memberWallet2);

            //嘉奖 钱包流水
            MemberWalletLine2 memberWalletLineForJJ = new MemberWalletLine2();
            memberWalletLineForJJ.setAccount(member2.getAccount());
            memberWalletLineForJJ.setMemberId(member2.getId());
            memberWalletLineForJJ.setTransType(WalletTransType.AWARD_PRESENT.getValue());
            memberWalletLineForJJ.setWalletType(WalletType.DUOBAO.getValue());
            memberWalletLineForJJ.setAmount(addPrize);
            memberWalletLineForJJ.setLotteryType(plan.getLotteryType());
            memberWalletLineForJJ.setCreateDateTime(new Date());
            memberWalletLineForJJ.setStatus(0);
            memberWalletLineForJJ.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLineForJJ));
            memberWalletLineForJJ.setSourceId(member2.getSourceId());
            memberWalletLineForJJ.setAbleBalance(memberWallet2.getAbleBalance());
            memberWalletLineForJJ.setFreezeBalance(memberWallet2.getFreezeBalance());
            memberWalletLineForJJ.setHeapBalance(memberWallet2.getHeapBalance());
            memberWalletLineForJJ.setRemark("嘉奖:" + plan.getPlanNo());
            memberWalletLine2Mapper.insertSelective(memberWalletLineForJJ);
        }
        //更新所有票的状态
        ticket2Mapper.updateReturnPrize(plan.getPlanNo());
    }



    public double handle(LotteryPlan2WithBLOBs plan){
        double maxAddPrize = dgMapper.getMaxAddPrize();
        Double totalAddPrize = lotteryPlanOrder2Mapper.getTotalAddPrizeByDay(plan.getAccount());
        if (totalAddPrize==null) {
            totalAddPrize = 0d;
        }
        LotteryPlanAddPrize2 addPrize = lotteryPlanAddPrize2Mapper.selectByPrimaryKey(plan.getPlanNo());
        if (addPrize==null || addPrize.getRate()==null || addPrize.getRate()==0) {
            return 0;
        }
        if (totalAddPrize+(plan.getPosttaxPrize()==null?0:plan.getPosttaxPrize())*addPrize.getRate()>maxAddPrize) {
            addPrize.setAddPrizeTime(new Date());
            lotteryPlanAddPrize2Mapper.updateByPrimaryKeySelective(addPrize);
            return NumberTools.round(maxAddPrize-totalAddPrize, 2);
        }
        addPrize.setAddPrizeTime(new Date());
        lotteryPlanAddPrize2Mapper.updateByPrimaryKeySelective(addPrize);
        return NumberTools.round((plan.getPosttaxPrize()==null?0:plan.getPosttaxPrize())*addPrize.getRate(), 2);
    }
}
