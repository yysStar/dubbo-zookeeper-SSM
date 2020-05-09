package com.qiyun.controller;


import com.qiyun.api.TicketApi;
import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.Platform;
import com.qiyun.commonModel.TradeType;
import com.qiyun.model2.LotteryPlan;
import com.qiyun.util.LogUtil;
import org.apache.poi.hssf.record.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Controller
@RequestMapping("/ticket")
public class CheckTicket{

    private List<LotteryType> lotteryTypes = new  ArrayList<LotteryType>();
        private  static  final Logger logger =LoggerFactory.getLogger(CheckTicket.class);
    private static final ExecutorService threadPool=Executors.newCachedThreadPool();





    @Resource
    private TicketApi ticketApi;

/*    @Scheduled(cron="0/60 * *  * * ? ")   //每10秒执行一次*/
    @ResponseBody
    public void checkTicket() {
         List<String> lotteryTypeList = new ArrayList<String>();
        lotteryTypeList.add("304");
        lotteryTypeList.add("30");
        lotteryTypeList.add("31");
        lotteryTypeList.add("32");
        lotteryTypeList.add("33");
        lotteryTypeList.add("43");
        lotteryTypeList.add("303");
        lotteryTypeList.add("42");
        lotteryTypeList.add("41");
        lotteryTypeList.add("34");
        lotteryTypeList.add("35");
        lotteryTypeList.add("36");
        lotteryTypeList.add("37");
        lotteryTypeList.add("44");
        lotteryTypeList.add("1");
        try {
            for (String type : lotteryTypeList) {
                lotteryTypes.add(LotteryType.getItem(Integer.parseInt(type)));
            }
            LogUtil.info("执行检票");
            for (LotteryType lotType : lotteryTypes) {

                //按彩种找出当前期出票期
                LotteryTerm lotteryTerm = ticketApi.findPrintingTermByLotteryType(lotType.getValue());
                if(lotteryTerm==null)continue;
                // * 根据方案彩种、出票状态、期数找出方案 2出票中
                List<LotteryPlan> lotteryList =ticketApi.findByLotteryTypeAndTermsAndPlanTicketStatus(lotType, 2, lotteryTerm.getTerm());
                if (lotteryList == null||lotteryList.size()==0)continue;
                LogUtil.info("开始检票:"+lotType.getName()+" 出票中方案数:" + (lotteryList==null?0:lotteryList.size()) );

                //执行检票守护线程
                threadPool.execute(new JianPiaoRunnable(lotteryList));
                System.out.println(lotType.getValue());
                System.out.println(lotteryTerm.toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }
    private class JianPiaoRunnable implements Runnable {
        private List<LotteryPlan> lotteryList;

        public JianPiaoRunnable(List<LotteryPlan> lotteryList) {
            this.lotteryList = lotteryList;
        }

        public void run() {
            for (LotteryPlan lotteryPlan : lotteryList) {
                long time = System.currentTimeMillis() - lotteryPlan.getCreateDateTime().getTime();
                if ((LotteryType.GPList.contains(lotteryPlan.getLotteryType()) && time < 30000) ||            //高频延迟30秒出票
                        (LotteryType.CTSZCList.contains(lotteryPlan.getLotteryType()) && time < 300000) ||    //数字彩延迟5分钟出票
                        (LotteryType.JJC_LIST.contains(lotteryPlan.getLotteryType()) && time < 180000)) {        //竞彩延迟3分钟出票
                    continue;
                }
                if (lotteryPlan.getTradeType() != TradeType.TRADE_BALANCE.getValue()) {
                    lotteryPlan.updatePlanStatusForScore();
                    //修改方案状态
                    ticketApi.updateLotteryPlan(lotteryPlan);
                    continue;
                }
                try {
                    ticketApi.jianPiao(lotteryPlan, Platform.WWW);
                } catch (Exception e) {
                    LogUtil.error(e);
                    //检票票异常，发警告
                    logger.error("检票", lotteryPlan.getLotteryType(), lotteryPlan.getTerm(), "" + lotteryPlan.getPlanNo(), "" + lotteryPlan.getAccount(), lotteryPlan.getAmount().doubleValue()
                            , "第 " + lotteryPlan.getTerm() + " 期,方案号：" + lotteryPlan.getPlanNo() + " 金额：" + lotteryPlan.getAmount() + "，检票失败！" + e.getMessage()
                            , e);
                }
            }
        }

    }
}
