package com.qiyun.task;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.dto.EvenTheRedMemberDTO;
import com.qiyun.dto.Member2ForSumprize;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.service.*;
import com.qiyun.util.Constants;
import com.qiyun.util.LogUtil;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.*;

@Component
@Lazy(value=false)
public class CheckBingoTask {
    private static Logger logger = LoggerFactory.getLogger(CheckBingoTask.class);

    @Resource
    private LotteryTermService lotteryTermService;
    @Resource
    private CheckBingoService checkBingoService;
    @Resource
    private LotteryPlanService lotteryPlanService;
    @Resource
    private ReturnPrizeService returnPrizeService;
    @Autowired
    private DGService dgService;

    private List<Integer> lotteryTypes;

    public void setLotteryTypes(List<Integer> lotteryTypes) {
        this.lotteryTypes = lotteryTypes;
    }

    /**
     * 自动开奖
     */
//    @Scheduled(cron = "0 0/6 * * * ?")//每隔6分钟处理一次
    public void openResult(){
        dgService.updateLastCheckBingoTime(new Date());
        LogUtil.info("执行自动开奖");
        for (Integer type : lotteryTypes) {
            LotteryTerm2 term = lotteryTermService.findCurrentTermByLotteryType(type);
            //开奖
            checkBingo(term, LotteryType.getItem(type));
        }
    }

    /**
     * 自动派奖
     */
//    @Scheduled(cron = "0 0/6 * * * ?")//每隔6分钟处理一次
    public void checkBingo(){
        dgService.updateLastReturnPrizeTime(new Date());
        for (Integer type : lotteryTypes) {
            LotteryTerm2 term = lotteryTermService.findCurrentTermByLotteryType(type);
            //派奖
            returnPrize(term, LotteryType.getItem(type));
            //未支付方案开奖
//            checkBingoForNoPay(term, LotteryType.getItem(type));
        }
    }

    private void returnPrize(LotteryTerm2 term, LotteryType type) {
        // 自动派奖
        synchronized (this) {
            try {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.MINUTE, -20);
                // 查找20分前(已中奖)方案
                List<LotteryPlan2WithBLOBs> bingoPlanList = lotteryPlanService.getByTypeAndTermAndTimeForReturnPrize(type.getValue(),term.getTerm(),cal.getTime());
                if (bingoPlanList.isEmpty()) {
                    throw new Exception(type.getName() + ":" + term.getTerm() + "期当前无需派奖方案");
                }
                LogUtil.info("待派奖方案数："+bingoPlanList.size());
                for (LotteryPlan2WithBLOBs bingoPlan : bingoPlanList) {
                    if(bingoPlan.getTradeType()==0){
                        //余额购买
                        returnPrizeService.returnPrize(bingoPlan.getPlanNo());
                    }/* else if(TradeType.isScroeTrade(bingoPlan.getTradeType())){
                        planBusiness.returnScore(bingoPlan.getPlanNo().toString(), String.valueOf(bingoPlan.getPosttaxPrize()), Platform.WWW);
                    }*/
                }
                //更新连红榜
                LogUtil.info("更新连红榜");
                List<EvenTheRedMemberDTO> list = lotteryPlanService.getEvenTheRedList(1,20,7);
                if (list!=null && list.size()>0) {
                    Jedis jedis = RedisUtil.getJedis();
                    JSONArray jsonArray = JSONArray.fromObject(list);
                    jedis.set(Constants.EVEN_RED, jsonArray.toString());
                    jedis.close();
                }
                //更新祥云大厅
                LogUtil.info("更新祥云大厅");
                List<Member2ForSumprize> list2 = lotteryPlanService.xyHall(1, 20, 7);
                if (list2!=null && list2.size()>0) {
                    Jedis jedis = RedisUtil.getJedis();
                    JSONArray jsonArray = JSONArray.fromObject(list2);
                    jedis.set(Constants.XYHALL, jsonArray.toString());
                    jedis.close();
                }
            } catch (Exception e) {
                LogUtil.info(e.getMessage());
            }
        }
    }

    private List<LotteryPlan2WithBLOBs> checkBingo(LotteryTerm2 term, LotteryType type) {
        List<LotteryPlan2WithBLOBs> bingoPlanList = new ArrayList<LotteryPlan2WithBLOBs>();
        synchronized (this) {
            HashMap<String, String> openInfoMap = checkBingoService.getOpenInfoMapForCheckBingo(term, type);
            bingoPlanList = checkBingoService.checkBingo(openInfoMap);
        }
        return bingoPlanList;
    }

    private List<LotteryPlan2WithBLOBs> checkBingoForNoPay(LotteryTerm2 term, LotteryType type) {
        List<LotteryPlan2WithBLOBs> bingoPlanList = new ArrayList<LotteryPlan2WithBLOBs>();
        synchronized (this) {
            HashMap<String, String> openInfoMap = checkBingoService.getOpenInfoMapForCheckBingo(term, type);
            bingoPlanList = checkBingoService.checkBingoForNoPay(openInfoMap);
        }
        return bingoPlanList;
    }

}
