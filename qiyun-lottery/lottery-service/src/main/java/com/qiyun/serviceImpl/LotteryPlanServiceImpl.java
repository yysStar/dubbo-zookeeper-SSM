package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import com.qiyun.common.Result;
import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.commonModel.PlayType;
import com.qiyun.dto.EvenTheRedMemberDTO;
import com.qiyun.dto.LotteryPlan2DTO;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.Member2ForSumprize;
import com.qiyun.mapper2.*;
import com.qiyun.model.PlanStatus;
import com.qiyun.model.PublicStatus;
import com.qiyun.model.WinStatus;
import com.qiyun.model2.*;
import com.qiyun.lottery.LotteryPlan;
import com.qiyun.service.LotteryPlanService;
import com.qiyun.util.BigDecimalUtil;
import com.qiyun.util.Constants;
import com.qiyun.util.LotteryUtils;
import com.qiyun.utils.NumberTools;
import com.qiyun.utils.StringUtils;
import com.qiyun.commonModel.LotteryType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.LinkedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LotteryPlanServiceImpl implements LotteryPlanService {
    private static Logger logger = LoggerFactory.getLogger(LotteryPlanServiceImpl.class);

    private List<Integer> footBallList;
    private List<Integer> basketBallList;
    private List<Integer> allList;

    public void setFootBallList(List<Integer> footBallList) {
        this.footBallList = footBallList;
    }

    public void setBasketBallList(List<Integer> basketBallList) {
        this.basketBallList = basketBallList;
    }

    public void setAllList(List<Integer> allList) {
        this.allList = allList;
    }

    @Resource
    private LotteryPlanAddPrize2Mapper lotteryPlanAddPrize2Mapper;

    @Resource
    private MemberFollowMapping2Mapper memberFollowMapping2Mapper;

    @Resource
    private LotteryPlanOrder2Mapper lotteryPlanOrder2Mapper;

    @Resource
    private LotteryPlan2Mapper lotteryPlan2Mapper;

    @Resource
    private Member2Mapper member2Mapper;
    @Resource
    private Ticket2Mapper ticket2Mapper;
    @Resource
    private TicketFindNew2Mapper ticketFindNew2Mapper;
    public static int[] JCLQ1 = {30, 31, 32, 33, 43, 39, 304};
    public static List<Integer> JCLQ = new ArrayList<Integer>();
    public static int[] JCZQ1 = {34, 35, 36, 37, 38, 41, 42, 44, 45, 46, 47, 48, 49, 303, 305, 306};
    public static List<Integer> JCZQ = new ArrayList<Integer>();

    static {
        for (int i : JCLQ1) {
            JCLQ.add(i);
        }
        for (int i : JCZQ1) {
            JCZQ.add(i);
        }
    }

    public LotteryPlan2WithBLOBs getByPlanNo(Integer planNo) {
        LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByPlanNo(planNo);
        return lotteryPlan2WithBLOBs;
    }

    public Result insert(LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs) {
        Result result = new Result();
        try {
            if (lotteryPlan2WithBLOBs == null) {
                result.setSuccess(false);
                return result;
            }

            lotteryPlan2Mapper.insert(lotteryPlan2WithBLOBs);
            result.setSuccess(true);
            result.setData(lotteryPlan2WithBLOBs);
            return result;
        } catch (Exception e) {
            logger.error("复制跟单添加方案表出错", e);
            result.setSuccess(false);
            result.setMsg("复制跟单添加方案表出错");
            return result;
        }
    }

    public  List<Map> querySuperLotteryPlan(int page,int pageSize,String type, String username,int sortType,Integer
            isFocus,String account) {
        Map<String,Object> map = new HashMap<String,Object>();
        if (!StringUtils.isNullOrBlank(username)){
            map.put("username",username);
        }
        if ("竞彩足球".equals(type)) {
            map.put("lotteryTypes",footBallList);
        } else if ("竞彩篮球".equals(type)) {
            map.put("lotteryTypes",basketBallList);
        } else if (StringUtils.isNullOrBlank(type)) {
            map.put("lotteryTypes",allList);
        }
        map.put("sortType",sortType);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(Calendar.MONTH, -1);
        Date time = instance.getTime();
        map.put("createDateTime",sdf.format(time));
        //
        if (isFocus==1){
            List<String> superManAccount = lotteryPlan2Mapper.getSuperManAccount(account);
            map.put("superManAccountList",superManAccount);
        }
        PageHelper.startPage(page,pageSize);
        List<Map> list = lotteryPlan2Mapper.querySuperLotteryPlan(map);

        return list;
    }

    public Result getPlanDetail(Integer planNo, Member2DTO member2DTO) {
        Result result = new Result();
        try {
            LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByPrimaryKey(planNo);
            if (lotteryPlan2WithBLOBs == null) {
                result.setSuccess(false);
                result.setMsg("找不到方案");
                return result;
            }
            String account = lotteryPlan2WithBLOBs.getAccount();
            Member2 member2 = member2Mapper.selectByAccount(account);
            if (member2 == null) {
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }
            Map<String, Object> reqMap = new HashMap<String, Object>();
            reqMap.put("account", account);
            Double jZAmount = lotteryPlanOrder2Mapper.getZJAmount(reqMap);

            Map<String, Object> map = new HashMap<String, Object>();

            if (member2.getType() == 1) {
                map.put("posttax_prize", NumberTools.round(lotteryPlan2WithBLOBs.getPosttaxPrize() * member2.getMultiple
                        (),2)); //税后奖金
                map.put("pretax_prize", lotteryPlan2WithBLOBs.getPretaxPrize() == null ? 0 : NumberTools.round
                        (lotteryPlan2WithBLOBs.getPretaxPrize() * member2.getMultiple(),2)); //税前奖金
                map.put("amount", lotteryPlan2WithBLOBs.getAmount() * member2.getMultiple()); //方案金额
//                map.put("ZJAmount",jZAmount*member2.getMultiple()); //中奖金额
                map.put("multiple",lotteryPlan2WithBLOBs.getMultiple()*member2.getMultiple());  //倍数
//                map.put("sumAmount",lotteryPlan2WithBLOBs.getSumamount()-lotteryPlan2WithBLOBs.getAmount()+lotteryPlan2WithBLOBs.getAmount()*member2.getMultiple());
                map.put("addPrize", lotteryPlan2WithBLOBs.getAddPrize() != null ? NumberTools.round
                        (lotteryPlan2WithBLOBs.getAddPrize() * member2.getMultiple(),2) : 0); //加奖
            } else {
                map.put("posttax_prize", NumberTools.round(lotteryPlan2WithBLOBs.getPosttaxPrize(),2)); //税后奖金
                map.put("pretax_prize", NumberTools.round(lotteryPlan2WithBLOBs.getPretaxPrize(),2)); //税前奖金
                map.put("amount", lotteryPlan2WithBLOBs.getAmount());  //方案金额
//                map.put("ZJAmount",jZAmount); //中奖金额
                map.put("multiple",lotteryPlan2WithBLOBs.getMultiple());  //倍数
//                map.put("sumAmount",lotteryPlan2WithBLOBs.getSumamount()); //方案总金额
                map.put("addPrize", lotteryPlan2WithBLOBs.getAddPrize() != null ? NumberTools.round
                        (lotteryPlan2WithBLOBs.getAddPrize(),2) : 0); //加奖
            }
            map.put("returnRate", NumberTools.bigDecimal(lotteryPlan2WithBLOBs.getPosttaxPrize() /
                    lotteryPlan2WithBLOBs.getAmount() * 100) + "%");
//            map.put("perAmount",lotteryPlan2WithBLOBs.getAmount()/lotteryPlan2WithBLOBs.getMultiple()); //单倍金额
//            map.put("note",lotteryPlan2WithBLOBs.getAmount()/lotteryPlan2WithBLOBs.getMultiple()/2);  //注数
            map.put("username", member2.getUsername());
            map.put("account", member2.getAccount());  //用户名
            map.put("pictureUrl", member2.getPictureUrl());  //头像路径
            SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            map.put("createDateTime", dateFormater.format(lotteryPlan2WithBLOBs.getCreateDateTime())); //方案发起时间
            map.put("dealDateTime", dateFormater.format(lotteryPlan2WithBLOBs.getDealDateTime()));  //方案截止时间
            map.put("planNo", planNo);  //方案编号
            map.put("winStatus", lotteryPlan2WithBLOBs.getWinStatus());  //中奖状态
            map.put("planStatus", lotteryPlan2WithBLOBs.getPlanStatus());  //方案状态
            map.put("publicStatus", PublicStatus.getItem(lotteryPlan2WithBLOBs.getPublicStatus()).getName());  //公开状态
            map.put("bookCount", lotteryPlan2WithBLOBs.getBookCount() == null ? 0 : lotteryPlan2WithBLOBs.getBookCount
                    ());
            map.put("sumCopyAmount", lotteryPlan2WithBLOBs.getIsSuperMan() == 1 ? lotteryPlan2WithBLOBs.getSumamount() -
                    lotteryPlan2WithBLOBs.getAmount() : 0);

            if (lotteryPlan2WithBLOBs.getPlayType() == 116){
                JSONObject content = JSONObject.fromObject(lotteryPlan2WithBLOBs.getContent());
                JSONArray passTypes = content.optJSONArray("passTypes");
                List<String> passTypeArr = new ArrayList<String>();
                for (Object passType : passTypes) {
                    passTypeArr.add(LotteryUtils.getPassType(passType.toString()));
                }
                String join = Joiner.on(",").join(passTypeArr);
                map.put("playType", PlayType.getItem(lotteryPlan2WithBLOBs.getPlayType()).getName()+"["+join+"]");
            }else {
                map.put("playType", PlayType.getItem(lotteryPlan2WithBLOBs.getPlayType()).getName());
            }


            LotteryPlanOrder2 lotteryPlanOrder2 = lotteryPlanOrder2Mapper.getByPlanNo(planNo);
            if (lotteryPlanOrder2 == null) {
                result.setSuccess(false);
                result.setMsg("找不到订单");
                return result;
            }
            map.put("sumGold", lotteryPlanOrder2.getSumGold());
            if (lotteryPlan2WithBLOBs.getIsSuperMan() == 0) {
                String accountDocumentary = lotteryPlan2WithBLOBs.getAccountDocumentary();
                Integer plannoCopydocumentary = lotteryPlan2WithBLOBs.getPlannoCopydocumentary();
                Member2 byAccountOrUsername = member2Mapper.selectByAccount(accountDocumentary);
                map.put("superUsername", byAccountOrUsername.getUsername() == null ? byAccountOrUsername.getAccount() :
                        byAccountOrUsername.getUsername());
                map.put("superPlanNo", plannoCopydocumentary);
            }

            MemberFollowMapping2Query memberFollowMapping2Query = new MemberFollowMapping2Query();
            MemberFollowMapping2Query.Criteria criteria = memberFollowMapping2Query.createCriteria();
            criteria.andAccountEqualTo(account);
            criteria.andFansAccountEqualTo(member2DTO.getAccount());
            criteria.andIsCancelEqualTo(false);
            List<MemberFollowMapping2> memberFollowMapping2s = memberFollowMapping2Mapper.selectByExample
                    (memberFollowMapping2Query);
            if (memberFollowMapping2s == null || memberFollowMapping2s.size() <= 0) {
                map.put("isFollow", false);
            } else {
                map.put("isFollow", true);
            }
            int zj = lotteryPlanOrder2Mapper.getZJCountByAccount(account);
            int total = lotteryPlanOrder2Mapper.getTZCountByAccount(account);
            map.put("win", total + "中" + zj); //中奖率

            result.setSuccess(true);
            result.setData(map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg("查询方案详情失败");
            return result;
        }
    }

    public Result getCopyPlanList(Integer planNo) {
        Result result = new Result();
        LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByPlanNo(planNo);
        if (lotteryPlan2WithBLOBs == null) {
            result.setSuccess(false);
            result.setMsg("找不到方案");
            return result;
        }
        if (lotteryPlan2WithBLOBs.getIsSuperMan() != 1) {
            result.setSuccess(false);
            result.setMsg("不是发单方案");
            return result;
        }
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andPlannoCopydocumentaryEqualTo(planNo);
        List<LotteryPlan2> lotteryPlan2s = lotteryPlan2Mapper.selectByExample(lotteryPlan2Query);
        if (lotteryPlan2s == null) {
            result.setSuccess(true);
            return result;
        }
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (LotteryPlan2 lotteryPlan2 : lotteryPlan2s) {
            Map<String, Object> map = new HashMap<String, Object>();
            LotteryPlanOrder2 byPlanNo = lotteryPlanOrder2Mapper.getByPlanNo(lotteryPlan2.getPlanNo());
            if (byPlanNo == null) {
                result.setSuccess(false);
                result.setMsg("找不到订单");
                return result;
            }
            Member2 member2 = member2Mapper.selectByAccount(lotteryPlan2.getAccount());
            if (member2 == null) {
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }
            map.put("account", lotteryPlan2.getAccount());
            map.put("username", member2.getUsername());
            map.put("amount", lotteryPlan2.getAmount());
            map.put("gold", byPlanNo.getGold() == null ? 0 : NumberTools.round(byPlanNo.getGold() * 0.8,2));
            map.put("posttax_prize", byPlanNo.getPosttaxPrize());
            list.add(map);
        }
        result.setSuccess(true);
        result.setData(list);
        return result;
    }

    public void update(LotteryPlan2WithBLOBs byPlanNo) {
        lotteryPlan2Mapper.updateByPrimaryKeySelective(byPlanNo);
    }

    public List<Member2ForSumprize> xyHall(int page, int pageSize, int day) {
        Map<String, Object> map = new HashMap<String, Object>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calSmall = Calendar.getInstance();
        calSmall.setTime(cal.getTime());
        calSmall.set(Calendar.DATE, calSmall.get(Calendar.DATE) - day);
        Date time = calSmall.getTime();
        List<Member2ForSumprize> list = lotteryPlan2Mapper.xyHall(time);
        if (list != null && list.size() > 0) {
            for (Member2ForSumprize member2ForSumprize : list) {
                Member2 member2 = member2Mapper.selectByAccount(member2ForSumprize.getAccount());
                if (member2.getType() == 1) {
                    member2ForSumprize.setSumPrize(member2ForSumprize.getSumPrize() * member2.getMultiple());
                }
                member2ForSumprize.setPicture(member2.getPicture());
                member2ForSumprize.setUsername(member2.getUsername());
            }
        }
        Collections.sort(list);

        List<Member2ForSumprize> list2 = new ArrayList<Member2ForSumprize>();
        for (int i = (page - 1) * pageSize; i < page * pageSize; i++) {
            if (i < list.size()) {
                list2.add(list.get(i));
            }
        }

        return list2;
    }

    public Map<String, Object> getIsFocusPlan(Integer planNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        LotteryPlanAddPrize2 lotteryPlanAddPrize2 = lotteryPlanAddPrize2Mapper.selectByPrimaryKey(planNo);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, lotteryPlanAddPrize2 == null ? false : true);
        return map;
    }

    public Map<String, Object> getPlanByNoPay(String account, int page, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();

        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andPlanStatusEqualTo(1); //未支付
        PageHelper.startPage(page, pageSize);
        lotteryPlan2Query.setOrderByClause("plan_no desc");
        List<LotteryPlan2WithBLOBs> lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByExampleWithBLOBs
                (lotteryPlan2Query);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, new PageInfo<LotteryPlan2WithBLOBs>(lotteryPlan2WithBLOBs));
        return map;
    }

    public List<LotteryPlan> findMuchTicketList(Date date, List<Integer> ltypeList) {
        return null;
    }

    public Map<String, Object> selectLotteryPlanByMap(Map<String, Object> map) {
        String account = map.get("account") == null ? null : map.get("account").toString();
        String startTime = map.get("startTime") == null ? null : map.get("startTime").toString();
        String endTime = map.get("endTime") == null ? null : map.get("endTime").toString();
        String dlAccount = map.get("dlAccount") == null ? null : map.get("dlAccount").toString();
        String qdAccount = map.get("qdAccount") == null ? null : map.get("qdAccount").toString();
        Integer planNo = (Integer) map.get("planNo");
        Integer planStatus = (Integer) map.get("planStatus");
        Integer winStatus = (Integer) map.get("winStatus");
        Integer startAmount = (Integer) map.get("startAmount");
        Integer endAmount = (Integer) map.get("endAmount");
        Integer playType = (Integer) map.get("playType");
        Integer page = (Integer) map.get("page");
        Integer pageSize = (Integer) map.get("pageSize");
        Double startReturnAmount = (Double) map.get("startReturnAmount");
        Double endReturnAmount = (Double) map.get("endReturnAmount");
        Double minBonus = (Double) map.get("minBonus");
        Double maxBonus = (Double) map.get("maxBonus");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        if (!StringUtils.isNullOrBlank(account)) {
            criteria.andAccountEqualTo(account);
        }
        if (!StringUtils.isNullOrBlank(startTime)) {
            try {
                Date parse = sdf.parse(startTime);
                criteria.andCreateDateTimeGreaterThanOrEqualTo(parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!StringUtils.isNullOrBlank(endTime)) {
            try {
                Date parse = sdf.parse(endTime);
                criteria.andCreateDateTimeLessThanOrEqualTo(parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (planNo != null) {
            criteria.andPlanNoEqualTo(planNo);
        }
        if (planStatus != null) {
            criteria.andPlanStatusEqualTo(planStatus);
        }
        if (winStatus != null) {
            criteria.andWinStatusEqualTo(winStatus);
        }
        if (startAmount != null) {
            criteria.andAmountGreaterThanOrEqualTo(startAmount);
        }
        if (endAmount != null) {
            criteria.andAmountLessThanOrEqualTo(endAmount);
        }
        if (playType != null) {
            criteria.andPlayTypeEqualTo(playType);
        }
        if (startReturnAmount != null) {
            criteria.andPosttaxPrizeGreaterThanOrEqualTo(startReturnAmount);
        }
        if (endReturnAmount != null) {
            criteria.andPosttaxPrizeLessThanOrEqualTo(endReturnAmount);
        }
        if (minBonus!=null){
            criteria.andMinBonusGreaterThanOrEqualTo(BigDecimalUtil.round(minBonus));
        }
        if (maxBonus!=null){
            criteria.andMaxBonusLessThanOrEqualTo(BigDecimalUtil.round(maxBonus));
        }
        if (!StringUtils.isNullOrBlank(dlAccount)){
            criteria.andDlAccountEqualTo(dlAccount);
        }
        if (!StringUtils.isNullOrBlank(qdAccount)){
            criteria.andDlAccountEqualTo(qdAccount);
        }
        PageHelper.startPage(page, pageSize);
        lotteryPlan2Query.setOrderByClause("plan_no desc");
        List<LotteryPlan2WithBLOBs> lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByExampleWithBLOBs
                (lotteryPlan2Query);
        int totalCount = lotteryPlan2Mapper.countByExample(lotteryPlan2Query);

        List<Map<String, Object>> maps = new ArrayList<Map<String, Object>>();
        Map<String, Object> respMap = new HashMap<String, Object>();
        if (lotteryPlan2WithBLOBs != null && lotteryPlan2WithBLOBs.size() > 0) {
            for (LotteryPlan2WithBLOBs plan : lotteryPlan2WithBLOBs) {
                Member2 member2 = member2Mapper.selectByAccount(plan.getAccount());
                LotteryPlanAddPrize2 lotteryPlanAddPrize2 = lotteryPlanAddPrize2Mapper.selectByPrimaryKey(plan.getPlanNo());
                Map<String, Object> resp = new HashMap<String, Object>();
                resp.put("planNo", plan.getPlanNo());
                resp.put("account", plan.getAccount());
                resp.put("createTime", plan.getCreateDateTime());
                resp.put("amount", plan.getAmount());
                resp.put("planStatus", PlanStatus.getItem(plan.getPlanStatus()).getName());
                resp.put("lotteryType", LotteryType.getItem(plan.getLotteryType()).getName());
                resp.put("term", plan.getTerm());
                resp.put("playType", PlayType.getItem(plan.getPlayType()).getName());
                resp.put("winStatus", WinStatus.getItem(plan.getWinStatus()).getName());
                resp.put("posttaxPrize", plan.getPosttaxPrize());
                resp.put("planDesc", plan.getPlanDesc());
                resp.put("dlAccount", plan.getDlAccount());
                resp.put("qdAccount", plan.getQdAccount());
                resp.put("minBonus", plan.getMinBonus());
                resp.put("maxBonus", plan.getMaxBonus());
                if (member2!=null){
                    resp.put("username", member2.getUsername());
                }
                if (lotteryPlanAddPrize2!=null){
                    resp.put("isFocus", true);
                }else{
                    resp.put("isFocus", false);
                }
                maps.add(resp);
            }
        }
        respMap.put(Constants.CODE, Constants.SUCCESS_CODE);
        respMap.put(Constants.MSG, Constants.SUCCESS_MSG);
        respMap.put(Constants.DATA, maps);
        respMap.put(Constants.TOTAL_COUNT, totalCount);
        return respMap;
    }

    public List<LotteryPlan2WithBLOBs> getByTypeAndTermAndTimeForReturnPrize(int lotteryType, String term, Date time) {
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andLotteryTypeEqualTo(lotteryType);
        criteria.andTermEqualTo(term);
        criteria.andOpenResultTimeLessThanOrEqualTo(time);
        criteria.andWinStatusEqualTo(WinStatus.AWARD.getValue());
        criteria.andPlanStatusEqualTo(PlanStatus.TICKET_OUT.getValue());
        criteria.andPretaxPrizeGreaterThan(0d);
        List<LotteryPlan2WithBLOBs> lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByExampleWithBLOBs
                (lotteryPlan2Query);
        return lotteryPlan2WithBLOBs;
    }

    public List<LotteryPlan2WithBLOBs> getWinPlanByType(int lotteryType) {
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andPlanStatusEqualTo(PlanStatus.TICKET_OUT.getValue());
        criteria.andWinStatusEqualTo(WinStatus.AWARD.getValue());
        criteria.andPlanStatusEqualTo(PlanStatus.TICKET_OUT.getValue());
        criteria.andLotteryTypeEqualTo(lotteryType);
        List<LotteryPlan2WithBLOBs> lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByExampleWithBLOBs
                (lotteryPlan2Query);
        return lotteryPlan2WithBLOBs;
    }

    public LotteryTerm findPrintingTermByLotteryType(Integer lotType) {
        Calendar calendar = Calendar.getInstance();
        /* calendar.add(Calendar.SECOND, -20);//延迟20秒*/
        Date nowDate = calendar.getTime();
        List<LotteryTerm> printingTermByLotteryType = ticket2Mapper.findPrintingTermByLotteryType(lotType, nowDate);
        if (printingTermByLotteryType.size()>0){
            return printingTermByLotteryType.get(0);
        }
        return null ;
    }

    public List<LotteryPlan2WithBLOBs> findByLotteryTypeAndTermsAndPlanTicketStatus(com.qiyun.commonModel.LotteryType
                                                                                            lotType, int i, String term) {
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andLotteryTypeEqualTo(lotType.getValue());
        criteria.andPlanTicketStatusEqualTo(i);
        criteria.andTermEqualTo(term);
        return lotteryPlan2Mapper.selectByExampleWithBLOBs(lotteryPlan2Query);

    }

    public void updateLotteryPlan(LotteryPlan2 lotteryPlan) {
        lotteryPlan2Mapper.updateByPrimaryKey(lotteryPlan);
    }

    public int getTicketCount(LotteryPlan2 lotteryPlan) {

        Ticket2Query ticket2Example = new Ticket2Query();
        Ticket2Query.Criteria criteria = ticket2Example.createCriteria();
        criteria.andPlanNoEqualTo(lotteryPlan.getPlanNo());
        List<Ticket2> ticket2s = ticket2Mapper.selectByExample(ticket2Example);
        return ticket2s.size();
    }

    public List<Ticket2> findTicketByPlanNo(Integer planNo) {
        Ticket2Query ticket2Example = new Ticket2Query();
        Ticket2Query.Criteria criteria = ticket2Example.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        criteria.andStatusEqualTo(3);//"未确认"
        return ticket2Mapper.selectByExample(ticket2Example);
    }

    public int countTicketNotSuccess(Integer planNo) {
        Ticket2Query ticket2Example = new Ticket2Query();
        Ticket2Query.Criteria criteria = ticket2Example.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        criteria.andStatusNotEqualTo(4);
        return ticket2Mapper.selectByExample(ticket2Example)==null?0:ticket2Mapper.selectByExample(ticket2Example).size
                ();
    }

    public int getFailCount(LotteryPlan2 lotteryPlan) {
        Ticket2Query ticket2Example = new Ticket2Query();
        Ticket2Query.Criteria criteria = ticket2Example.createCriteria();
        criteria.andPlanNoEqualTo(lotteryPlan.getPlanNo());
        criteria.andStatusEqualTo(5);
        return ticket2Mapper.selectByExample(ticket2Example)==null?0:ticket2Mapper.selectByExample(ticket2Example).size
                ();
    }

    public void updateSuccess(Ticket2 ticket2) {
        ticket2Mapper.updateByPrimaryKey(ticket2);
    }

    public List<Ticket2> findByOutId(String orderId) {
        Ticket2Query ticket2Example = new Ticket2Query();
        Ticket2Query.Criteria criteria = ticket2Example.createCriteria();
        criteria.andOutIdEqualTo(orderId);
        return ticket2Mapper.selectByExample(ticket2Example);
    }

    public TicketFindNew2 getByCopyPlanNo(Integer planNo) {

        return ticket2Mapper.getByCopyPlanNo(planNo);
    }

    public void updateTicketStatus(TicketFindNew2 findNew) {
        ticketFindNew2Mapper.updateByPrimaryKeySelective(findNew);
    }


    public List<String> getSuperManAccount(String account) {
        return lotteryPlan2Mapper.getSuperManAccount(account);
    }


    public void buildTodayPrizeInfo(LotteryType lotteryType, String s) {

    }

    public List<LotteryPlan2WithBLOBs> getByIsAbleTicketingAndPlanTicketStatus(Integer type, int isAbleTicketIng, int
            ticketStatus) {
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andLotteryTypeEqualTo(type);
        criteria.andIsAbleTicketingEqualTo(isAbleTicketIng);
        criteria.andPlanTicketStatusEqualTo(ticketStatus);
        List<LotteryPlan2WithBLOBs> lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByExampleWithBLOBs
                (lotteryPlan2Query);
        return lotteryPlan2WithBLOBs;
    }

    public List<LotteryPlan2WithBLOBs> getByTypeAndPlanTicketStatus(Integer type, int planTicketStatus) {
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andPlanTicketStatusEqualTo(planTicketStatus);
        criteria.andLotteryTypeEqualTo(type);
        List<LotteryPlan2WithBLOBs> lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByExampleWithBLOBs
                (lotteryPlan2Query);
        return lotteryPlan2WithBLOBs;
    }

    @Override
    public List<EvenTheRedMemberDTO> getEvenTheRedList(int page, int pageSize, int day) {
        Calendar cal = Calendar.getInstance();
        Calendar calSmall = Calendar.getInstance();
        calSmall.setTime(cal.getTime());
        calSmall.set(Calendar.DATE,calSmall.get(Calendar.DATE)-day);
        Date time = calSmall.getTime();
        List<String> accounts = lotteryPlan2Mapper.getGroupByAccount(time);

        List<EvenTheRedMemberDTO> list = new ArrayList<EvenTheRedMemberDTO>();
        for (String account : accounts) {
            LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
            LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
            criteria.andAccountEqualTo(account);
            criteria.andCreateDateTimeGreaterThan(time);
            criteria.andPlanStatusEqualTo(4);
            criteria.andWinStatusNotEqualTo(1);
            criteria.andPublicStatusNotEqualTo(1);
            List<LotteryPlan2WithBLOBs> lotteryPlan2s = lotteryPlan2Mapper.selectByExampleWithBLOBs(lotteryPlan2Query);
            Map<String,LotteryPlan2WithBLOBs> map = new LinkedHashMap<String,LotteryPlan2WithBLOBs>();

            for (int i = 0; i < lotteryPlan2s.size(); i++) {
                LotteryPlan2WithBLOBs lotteryPlan2 = lotteryPlan2s.get(i);
                StringBuffer sb = new StringBuffer();
                JSONObject content = JSONObject.fromObject(lotteryPlan2.getContent());
                String passTypes = content.optString("passTypes");
                sb.append(passTypes).append("-");
                JSONArray matchItems = content.optJSONArray("matchItems");
                for (Object object : matchItems) {
                    JSONObject matchItem = JSONObject.fromObject(object);
                    String intTime = matchItem.optString("intTime");
                    String lineId = matchItem.optString("lineId");
                    sb.append(intTime).append("-").append(lineId).append("-");
                    JSONArray options = matchItem.optJSONArray("options");
                    for (Object object2 : options) {
                        JSONObject option = JSONObject.fromObject(object2);
                        String type = option.optString("type");
                        String value = option.optString("value");
                        sb.append(type).append(":").append(value).append("|");
                    }
                    sb.append("^");
                }
                if (map.containsKey(sb.toString())){
                    lotteryPlan2s.remove(i);
                    i--;
                }
                map.put(sb.toString(),lotteryPlan2);
            }

            int count = 0;
            int maxCount = 0;
            for (LotteryPlan2WithBLOBs lotteryPlan2 : lotteryPlan2s) {
                if (lotteryPlan2.getPosttaxPrize()>0){
                    count+=1;
                }else{
                    count=0;
                }
                if (count>maxCount){
                    maxCount=count;
                }
            }
            EvenTheRedMemberDTO evenTheRedMemberDTO = new EvenTheRedMemberDTO();
            evenTheRedMemberDTO.setAccount(account);
            evenTheRedMemberDTO.setCount(maxCount);
            Member2 member2 = member2Mapper.selectByAccount(account);
            if (member2==null){
                continue;
            }
            evenTheRedMemberDTO.setPicture(member2.getPicture());
            evenTheRedMemberDTO.setUsername(member2.getUsername());
            list.add(evenTheRedMemberDTO);
        }
        Collections.sort(list);
        List<EvenTheRedMemberDTO> list2 = new ArrayList<EvenTheRedMemberDTO>();
        for (int i = (page-1)*pageSize; i < page*pageSize; i++) {
            if (i<=list.size()-1){
                list2.add(list.get(i));
            }
        }
        return list2;
    }

    public List<LotteryPlan2WithBLOBs> getByPlanStatus(int value) {
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andPlanStatusEqualTo(value);
        List<LotteryPlan2WithBLOBs> lotteryPlan2s = lotteryPlan2Mapper.selectByExampleWithBLOBs(lotteryPlan2Query);
        return lotteryPlan2s;
    }

    @Override
    public Integer getEvenRedByAccount(String account) {
        Calendar cal = Calendar.getInstance();
        Calendar calSmall = Calendar.getInstance();
        calSmall.setTime(cal.getTime());
        calSmall.set(Calendar.DATE,calSmall.get(Calendar.DATE)-7);
        Date time = calSmall.getTime();
        LotteryPlan2Query lotteryPlan2Query = new LotteryPlan2Query();
        LotteryPlan2Query.Criteria criteria = lotteryPlan2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andCreateDateTimeGreaterThan(time);
        criteria.andPlanStatusEqualTo(4);
        criteria.andWinStatusNotEqualTo(1);
        criteria.andPublicStatusNotEqualTo(1);
        List<LotteryPlan2WithBLOBs> lotteryPlan2s = lotteryPlan2Mapper.selectByExampleWithBLOBs(lotteryPlan2Query);

        int count = 0;
        int maxCount = 0;
        for (LotteryPlan2WithBLOBs lotteryPlan2 : lotteryPlan2s) {
            if (lotteryPlan2.getPosttaxPrize()>0){
                count+=1;
            }else{
                count=0;
            }
            if (count>maxCount){
                maxCount=count;
            }
        }
        return maxCount;
    }
}
