package com.qiyun.task;


import com.qiyun.api.LotteryApi;

import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.Platform;
import com.qiyun.commonModel.TradeType;

import com.qiyun.httpUtil.ZipHttpUtil;

import com.qiyun.model2.*;
import com.qiyun.service.LotteryPlanService;

import com.qiyun.status.PlanStatus;
import com.qiyun.status.PlanTicketStatus;
import com.qiyun.util.LogUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Component
@Lazy(value = false)
public class CheckTicket {
//    private static String url = "https://ticket.api.qyun88.com/";
    private static String url = "https://ticket.api.qiyun88.cn/";

    private static final Logger logger = LoggerFactory.getLogger(CheckTicket.class);
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();

    private List<String> lotteryTypeList;

    public void setLotteryTypeList(List<String> lotteryTypes) {
        this.lotteryTypeList = lotteryTypes;
    }

    @Resource
    private LotteryPlanService lotteryPlanService;
    @Resource
    private LotteryApi lotteryApi;

    @Scheduled(cron = "0/10 * * * * ? ") //10秒执行一次
    public void checkTicket() {
        try {
            List<LotteryType> lotteryTypes = new ArrayList<LotteryType>();
            for (String type : lotteryTypeList) {
                lotteryTypes.add(LotteryType.getItem(Integer.parseInt(type)));
            }
            LogUtil.info("执行检票");
            for (LotteryType lotType : lotteryTypes) {

                //按彩种找出当前期出票期
                LotteryTerm lotteryTerm = lotteryPlanService.findPrintingTermByLotteryType(lotType.getValue());
                if (lotteryTerm == null) continue;
                // * 根据方案彩种、出票状态、期数找出方案 2出票中
                List<LotteryPlan2WithBLOBs> lotteryList = lotteryPlanService.findByLotteryTypeAndTermsAndPlanTicketStatus(lotType, 2, lotteryTerm.getTerm());
                if (lotteryList == null || lotteryList.size() == 0) continue;
                LogUtil.info("开始检票:" + lotType.getName() + " 出票中方案数:" + (lotteryList == null ? 0 : lotteryList.size()));

                run(lotteryList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }

     /*   private List<LotteryPlan2WithBLOBs> lotteryList;

        public JianPiaoRunnable(List<LotteryPlan2WithBLOBs> lotteryList) {
            this.lotteryList = lotteryList;
        }*/

    public void run(List<LotteryPlan2WithBLOBs> lotteryList) {
        for (LotteryPlan2WithBLOBs lotteryPlan : lotteryList) {
            long time = System.currentTimeMillis() - lotteryPlan.getCreateDateTime().getTime();
            if ((LotteryType.GPList.contains(LotteryType.getItem(lotteryPlan.getLotteryType())) && time < 30000) ||            //高频延迟30秒出票
                    (LotteryType.CTSZCList.contains(LotteryType.getItem(lotteryPlan.getLotteryType())) && time < 300000) ||    //数字彩延迟5分钟出票
                    (LotteryType.JJC_LIST.contains(LotteryType.getItem(lotteryPlan.getLotteryType())) && time < 180000)) {        //竞彩延迟3分钟出票
                continue;
            }
            if (lotteryPlan.getTradeType() != TradeType.TRADE_BALANCE.getValue()) {
//                    lotteryPlanService.updatePlanStatusForScore();
                //修改方案状态
                lotteryPlanService.updateLotteryPlan(lotteryPlan);
                continue;
            }
            try {
                jianPiao(lotteryPlan, Platform.WWW);
            } catch (Exception e) {
                LogUtil.error(e);
                //检票票异常，发警告
                logger.error("检票", lotteryPlan.getLotteryType(), lotteryPlan.getTerm(), "" + lotteryPlan.getPlanNo(), "" + lotteryPlan.getAccount(), lotteryPlan.getAmount().doubleValue()
                        , "第 " + lotteryPlan.getTerm() + " 期,方案号：" + lotteryPlan.getPlanNo() + " 金额：" + lotteryPlan.getAmount() + "，检票失败！" + e.getMessage()
                        , e);

            }
        }

    }

    public void jianPiao(LotteryPlan2WithBLOBs lotteryPlan, com.qiyun.commonModel.Platform platform) {
        LogUtil.info("方案：" + lotteryPlan.getPlanNo() + "  检票开始...");
        // 检票用，统计方案总票数
        int allTicketNum = lotteryPlanService.getTicketCount(lotteryPlan);
        if (0 == allTicketNum) {
            return;
        }
        //查找未确认的方案列表
        List<Ticket2> list = lotteryPlanService.findTicketByPlanNo(lotteryPlan.getPlanNo());
        //统计非成功状态的票数
        int noSuccessTicketNum = lotteryPlanService.countTicketNotSuccess(lotteryPlan.getPlanNo());
        //如果失败的票数为0
        if (noSuccessTicketNum == 0) {
            lotteryPlan = lotteryPlanService.getByPlanNo(lotteryPlan.getPlanNo());
            //!!!防止重复检票，如果已经是出票状态，则退出
            if (lotteryPlan.getPlanTicketStatus() == 4) {
                return;
            }
            // 如果方案已经满员就将方案状态设置为已出票状态
            if (lotteryPlan.getPlanStatus() == 3) {
                lotteryPlan.setPlanStatus(4);
               lotteryPlan.setPlanTicketStatus(4);
                lotteryPlan.setPrintTicketDateTime(new Date());
                lotteryPlanService.updateLotteryPlan(lotteryPlan);
                //增加到销量统计
                lotteryApi.addSalesCount(lotteryPlan);
                LogUtil.info("方案：" + lotteryPlan.getPlanNo() + "  检票处理为成功。");
                /*********寻票状态更新**********/
                updateTicketFindticketStatus(lotteryPlan);
                //查询返点 返回佣金
                lotteryApi.setCommision(lotteryPlan);
                LogUtil.info(lotteryPlan.getAccount() + "购彩方案编号:" + lotteryPlan.getPlanNo() + "赠送返点: ");
            }
        } else if (noSuccessTicketNum > 0 && noSuccessTicketNum < allTicketNum) {// 如果成功的票加上失败的票等于方案的票则设置该方案为部分出票
            // TODO:部份出票暂不处理
           /* if (list.size() > 0) {
                // 查询是否送票是否成功
                chaPiao(list, lotteryPlan, platform);
            }*/
        } else {
            if (list.size() > 0) {
                chaPiao(list, lotteryPlan, platform);
            }
            //整个方案都是失败的票则进行以下逻辑处理
            int failTicketNum = lotteryPlanService.getFailCount(lotteryPlan);
            if (allTicketNum == failTicketNum) {
                LogUtil.info("方案：" + lotteryPlan.getPlanNo() + "  检票：出票失败！");
                //退票处理
                lotteryApi.planBack(lotteryPlan.getPlanNo());
            }
        }
    }

    //查询票务商是否出票
    private void chaPiao(List<Ticket2> list, LotteryPlan2WithBLOBs lotteryPlan, com.qiyun.commonModel.Platform platform) {
        int i = 1;
        StringBuffer sb = new StringBuffer();
        for (Ticket2 ticket : list) {
            if (i == list.size()) {
                sb.append(ticket.getId());
            } else {
                sb.append(ticket.getId() + ",");
                i++;
            }
        }
        JSONObject jo = new JSONObject();
        jo.put("ticketIdList", sb.toString());
        ZipHttpUtil.sendGetHttp(url + "ticket/getTicketResult", jo);
    }


    public void updateTicketFindticketStatus(LotteryPlan2 lotteryPlan) {

        TicketFindNew2 findNew = lotteryPlanService.getByCopyPlanNo(lotteryPlan.getPlanNo());
        if (findNew != null) {
            findNew.setTicketStatus(lotteryPlan.getPlanStatus());
            lotteryPlanService.updateTicketStatus(findNew);
        }
    }

}
