package com.qiyun.service.biz;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.api.UserManageApi;
import com.qiyun.common.GoldCard2;
import com.qiyun.model2.*;
import com.qiyun.service.MemberAgentService;
import com.qiyun.service.MemberRateService;
import com.qiyun.service.MemberService;
import com.qiyun.service.UserService;
import com.qiyun.util.Constants;
import com.qiyun.util.ListCompireUtil;
import com.qiyun.util.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("userManageApi")
public class UserManageBiz implements UserManageApi {
    private static Logger logger = LoggerFactory.getLogger(UserManageBiz.class);

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRateService memberRateService;
    @Autowired
    private MemberAgentService memberAgentService;
    @Autowired
    private UserService userService;

    /**
     * 获取一个月未登录客户列表
     *
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getHistoryClient(int offset, int pageSize) {
        return memberService.getHistoryClient(offset,pageSize);
    }

    /**
     * 添加机器人
     *
     * @return
     */
    public Map<String, Object> addRobot(String userName, String mobile, String certNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2 member2 = memberService.getByMobile(mobile);
        if (member2 != null) { //手机号判断
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_2);
            return map;
        }
        member2 = memberService.getByUserName(userName);
        if (member2 != null) { //昵称判断
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_5);
            return map;
        }
        Member2 member = new Member2();
        // 初始化用户头像
        Random random = new Random();
        int num = random.nextInt(9);
        member.setPicture("avatar" + num + ".png");
        String account = memberService.genRandomAccount("sj");
        member.setAccount(account);
        member.setUsername(userName);
//        member.setName(Constants.ROBOT_NAME);
        member.setCertType(1);
        member.setExprerience(new Integer(0));
        member.setRegisterDateTime(new Date());
        member.setPassword(MD5.encode("123456"));
        member.setRank(1);
        member.setRecommender(0);
        member.setLastLoginDateTime(new Date());
        member.setStatus(0);
        member.setSign("0");
        member.setMobile(mobile);
        member.setIsMobileAuthed(0);
        member.setIsEmailAuthed(1);
        member.setIsWhitelist(0);
        member.setIsCharge(0);
        member.setCertNo(certNo);
        member.setCertType(1);
        member.setType(2);
        member.setSourceId(85);
        member.setProvider("DL");
        member.setPlayStatus(0);
        int id = memberService.addRobot(member);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put("id", id);
        return map;
    }

    /**
     * 机器人列表
     *
     * @return
     */
    public Map<String, Object> getRobotList(int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Member2> list = memberService.getRobotList(offset, pageSize);
        PageInfo<Member2> pageInfo = new PageInfo<Member2>(list);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, pageInfo);
        return map;
    }

    public Map<String, Object> findDrawsNums(String account) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int num = memberService.findDrawsNums(account);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, num);

        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map updateDrawsNum(String account) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int num = memberService.updateDrawsNum(account);
            if (num > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA, num);
            } else {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "今日次数已用完");
                resMap.put(Constants.DATA, num);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map addGoldCard(GoldCard2 goldCard2) {

        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //查看这个账号是否存在
            List<Member2> member2s = memberService.countByExample(goldCard2.getAccount());
            int i = member2s.size();
            if (i != 0) {
                int num = memberService.addGoldCard(goldCard2);
                if (num > 0) {
                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                } else {
                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, "数据添加失败");
                }
            } else {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "该账户不存在");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> findGoldCard(String account, String startTime, String endTime) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        if (startTime==null){
            startTime="";
        }
        if (endTime==null){
            endTime="";
        }
        try {
            List<GoldCard2> goldCard2 = memberService.findGoldCard(account, startTime, endTime);
            if (goldCard2.size() > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA, goldCard2);
            } else {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "您当前没有彩金卡");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;

    }

    public Map<String, Object> addActivity(Map<String, Object> mapParams) {
        Map<String, Object> resMap = new HashMap<String, Object>();

        try {
            int num = 0;
            if (0 == Integer.parseInt(mapParams.get("is_edit").toString())) {
                num = memberService.addActivity(mapParams);
            }

            if (1 == Integer.parseInt(mapParams.get("is_edit").toString())) {
                num = memberService.updateActivity(mapParams);
            }
            if (num > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "数据添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> findAllActivity() {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            List<Map> maps = memberService.findAllActivity();
            if (maps.size() > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA, maps);
            } else {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "您当前没有彩金卡");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public int resetDrawsNum() {
        return memberService.resetDrawsNum();
    }

    public int updateGoldCard(GoldCard2 goldCard2) {
        return memberService.updateGoldCard(goldCard2);
    }

    public Map<String, Object> incrementDrawsNum(String account, BigDecimal amount) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int num = memberService.findDrawsNums(account);
            if (amount.compareTo(new BigDecimal(500)) >= 0) {
                //增加一次抽奖机会
                int resNum = memberService.incrementDrawsNum(num + 1, account);
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "赠送一次抽奖机会");
            } else {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "金额小于500元不能赠送抽奖机会");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);
        }
        return resMap;
    }

    public Map<String, Object> presentes(String params, String username) {
        Map resMap = new HashMap();
        try {
            int nums = memberService.presentes(params, username);
            if (nums > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);

            } else {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "彩金添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> setRate(String account, String rateParams) {
        Map resMap = new HashMap();
        try {
            //1.判断这个账号是否存在
            List<Member2> member2s = memberService.countByExample(account);
            //查找这个人是不是有返点
            List<MemberRate2WithBLOBs> memberRate2lists = memberRateService.findMemberRateById(member2s.get(0).getId());
            if (member2s.size() == 0) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "该账户不存在");
                return resMap;
            }
            List list = JSONObject.parseObject(rateParams, List.class);

            //查找这个人上级点位

            //判断 传入点位是否小于上级点位

            for (Object o : list
                    ) {
                Map<String, Object> mapParams = (Map<String, Object>) o;

                if (member2s.get(0).getSourceId()!=null) {
                    List<MemberRate2> memberRate2s = memberRateService.findMemberRate(member2s.get(0));
                    //遍历上级点位

                    for (MemberRate2 m : memberRate2s) {

                        //判断足球dg点位
                        if (mapParams.get("lotteryType").equals(m.getLotteryType()) && mapParams.get("lotteryType").equals(38) && Double.valueOf(mapParams.get("dg_rate") + "") > m.getFdDgRate()) {
                            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                            resMap.put(Constants.MSG, "竞彩足球代购点位设置不能超过上级点位");
                            return resMap;
                        }
                        if (mapParams.get("lotteryType").equals(m.getLotteryType()) && mapParams.get("lotteryType").equals(39) && Double.valueOf(mapParams.get("dg_rate") + "") > m.getFdDgRate()) {
                            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                            resMap.put(Constants.MSG, "竞彩蓝球代购点位设置不能超过上级点位");
                            return resMap;
                        }
                        if (mapParams.get("lotteryType").equals(m.getLotteryType()) && mapParams.get("lotteryType").equals(39) && Double.valueOf(mapParams.get("hm_rate") + "") > m.getFdHmRate()) {
                            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                            resMap.put(Constants.MSG, "竞彩蓝球合买点位设置不能超过上级点位");
                            return resMap;
                        }
                        if (mapParams.get("lotteryType").equals(m.getLotteryType()) && mapParams.get("lotteryType").equals(38) && Double.valueOf(mapParams.get("hm_rate") + "") > m.getFdHmRate()) {
                            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                            resMap.put(Constants.MSG, "竞彩足球合买点位设置不能超过上级点位");
                            return resMap;
                        }
                    }
                }
             if (memberRate2lists.size()>0){
                 for (MemberRate2 m:memberRate2lists
                      ) {
                     if (mapParams.get("lotteryType").equals(m.getLotteryType()+"") && mapParams.get("lotteryType").equals(38+"")) {
                         resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                         resMap.put(Constants.MSG, "该账户存在竞彩足球点位");
                         return resMap;
                     }
                     else if (mapParams.get("lotteryType").equals(m.getLotteryType()+"") && mapParams.get("lotteryType").equals(39+"")){
                         resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                         resMap.put(Constants.MSG, "该账户存在竞彩篮球点位");
                         return resMap;
                     }
                 }
             }
             // //保存到数据库
                MemberRate2 memberRate2 = new MemberRate2WithBLOBs();
                memberRate2.setAccount(account);
                memberRate2.setCreateDate(new Date());
                memberRate2.setFdDgRate(Double.valueOf(mapParams.get("dg_rate")+""));
                memberRate2.setFdHmRate(Double.valueOf(mapParams.get("hm_rate")+""));
                memberRate2.setLotteryType(Integer.parseInt(mapParams.get("lotteryType")+""));
                memberRate2.setMemberId(member2s.get(0).getId());
                memberRate2.setReturnPointType(1);//返点
                memberRate2.setIsSetRate(1);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                memberRate2.setRateCreateDate(sdf.parse(mapParams.get("startDate")+""));
                memberRate2.setRateEndDate(sdf.parse(mapParams.get("endDate")+""));
                memberRate2.setApplyRemark(mapParams.get("remark")+"");
                memberRateService.insert((MemberRate2WithBLOBs) memberRate2);

            }
            //修改代理表是否设置点位//
            //查找是否是代理
            List<MemberAgent2> memberAgentInfo = memberAgentService.getMemberAgentInfo(account);
            if (memberAgentInfo.size()>0){
                MemberAgent2 memberAgent2 = memberAgentInfo.get(0);
                memberAgent2.setIsSetRate(1);
                memberAgentService.updateMemberAgent(memberAgent2);
            }
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, "返点设置成功");
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> findAllRate(String account, Integer page, Integer pageSize) {
        Map resMap = new HashMap();
        try {
            PageHelper.startPage(page,pageSize);
           List<Map> maps = memberRateService.findAllRate(account);
           PageInfo pageInfo = new PageInfo(maps);
            if (maps.size() > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA,pageInfo);

            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "数据获取失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> updateRateByAccount(Map mapParams) {
        Map resMap = new HashMap();
        try {
            List<Member2> member2s = memberService.countByExample((String) mapParams.get("account"));
            List<MemberRate2> memberRate2s = memberRateService.findMemberRate(member2s.get(0));
            for (MemberRate2 m : memberRate2s) {
                //判断足球dg点位

                if (mapParams.get("lotteryType").equals(m.getLotteryType()) && mapParams.get("lotteryType").equals(38) && Double.valueOf(mapParams.get("dg_rate") + "") > m.getFdDgRate()) {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "竞彩足球代购点位设置不能超过上级点位");
                    return resMap;
                }
                if (mapParams.get("lotteryType").equals(m.getLotteryType()) && mapParams.get("lotteryType").equals(39) && Double.valueOf(mapParams.get("dg_rate") + "") > m.getFdDgRate()) {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "竞彩蓝球代购点位设置不能超过上级点位");
                    return resMap;
                }
                if (mapParams.get("lotteryType").equals(m.getLotteryType()) && mapParams.get("lotteryType").equals(39) && Double.valueOf(mapParams.get("hm_rate") + "") > m.getFdHmRate()) {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "竞彩蓝球合买点位设置不能超过上级点位");
                    return resMap;
                }
                if (mapParams.get("lotteryType").equals(m.getLotteryType()) && mapParams.get("lotteryType").equals(38) && Double.valueOf(mapParams.get("hm_rate") + "") > m.getFdHmRate()) {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "竞彩足球合买点位设置不能超过上级点位");
                    return resMap;
                }
            }
            int num =  memberRateService.updateRateByAccount(mapParams);
            if ( num > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);

            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "数据获取失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> delRateByAccount(String account, Integer lottery_type) {
        Map resMap = new HashMap();
        try {
            int num =  memberRateService.delRateByAccount(account,lottery_type);
            if ( num > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);

            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "数据获取失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> getSubordinateMember(String account, Integer page, Integer pageSize) {
        Map resMap = new HashMap();
        try {
            List<MemberAgent2> memberAgent2 = memberAgentService.getMemberAgentInfo(account);
            if (memberAgent2.size()==0){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "这个账号不是代理或者渠道");
                return resMap;
            }
            PageHelper.startPage(page,pageSize);
            List<Member2> list =  memberService.getSubordinateMember(memberAgent2.get(0).getMemberId());
            PageInfo pageInfo = new PageInfo(list);
            if ( list.size() > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA,pageInfo);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "该账号下面没有会员");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }
    public Map<String, Object> moveMember(String oldAccount, String newAccount, String moveMemberId) {
    Map resMap = new HashMap();
        try {
        //判断传入oldaccount手下人员id是否是 moveMemberid
        List<MemberAgent2> memberAgent2 = memberAgentService.getMemberAgentInfo(oldAccount);
        if (memberAgent2.size()==0){
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "这个账号不是代理或者渠道");
            return resMap;
        }
        List<Member2> list =  memberService.getSubordinateMember(memberAgent2.get(0).getMemberId());
        List<String> str = new ArrayList();
        for (Member2 member2:list
                ) {
            str.add(member2.getId()+"");
        }
        List<String> ids = Arrays.asList(moveMemberId.split(","));

        //判断两个集合的交集
            str.retainAll(ids);
            if (!ListCompireUtil.isListEqual(str,ids)){
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "代理账号信息与转移会员信息不匹配");
            return  resMap;
        }
        System.out.println("并集"+ids.toString());
        //判断新的账号是代理还是渠道还是代理
        List<MemberAgent2> newMemberAgent = memberAgentService.getMemberAgentInfo(newAccount);
        if (newMemberAgent.size()==0){
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "这个账号不是代理或者渠道");
            return resMap;
        }
        if (newMemberAgent.get(0).getStatus()==0){
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "这个代理账号无效");
        }
        //判断返点
        //1.查询newAccount的返点
            List<MemberRate2WithBLOBs> memberRateById = memberRateService.findMemberRateById(newMemberAgent.get(0).getMemberId());
            for (String id:ids
                    ) {
                List<MemberRate2WithBLOBs> memberRateById1 = memberRateService.findMemberRateById(Integer.parseInt(id));
                if (memberRateById1.size()!=0){
                    for (MemberRate2 m :memberRateById
                            ) {
                        for (MemberRate2 m1:memberRateById1
                             ) {
                            if (m.getLotteryType()==m1.getLotteryType()&&(m.getFdDgRate()<m1.getFdDgRate()||m.getFdHmRate()<m1.getFdHmRate())){
                                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                                resMap.put(Constants.MSG, m1.getAccount()+"点位高于"+m.getAccount()+"点位");
                                return  resMap;
                            }
                        }
                    }
                }
            }
            //这个人是渠道
        String provider =null;
        if (Integer.valueOf(newMemberAgent.get(0).getAgentType())==0){
            provider="QD";
        }
        if (Integer.valueOf(newMemberAgent.get(0).getAgentType())==1){
            provider="DL";
        }
        for (String id:ids
                ) {
            memberService.updateMemberSourceId(provider,Integer.parseInt(id),newMemberAgent.get(0).getMemberId());
        }
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> setMemberToAgent(String account,String QDAccount) {
        Map resMap = new HashMap();
        try {
            List<Member2> member2s = memberService.countByExample(account);
            //查找渠道
            Integer qdId;
            String provider =null;
            if (QDAccount!=null && !QDAccount.equals("")) {
                List<Member2> qdmember2s = memberService.countByExample(QDAccount);
                qdId = qdmember2s.get(0).getId();
                provider= "QD";
            }else {
                qdId=0;
            }
            if (member2s.size()==0){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "该账户不存在");
                return resMap;
            }
            else {
                if (Integer.valueOf(member2s.get(0).getIsWhitelist())==1){
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "非加白用户不能成为代理");
                    return resMap;
                }
            }
            List<MemberAgent2> memberAgent2 = memberAgentService.getMemberAgentInfo(account);
            if (memberAgent2.size()>0){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "这个账号已经是渠道或者代理");
                return resMap;
            }
            //生成水机的代理激活码
            String str = "";
            for (int i = 0;i<2;i++){
                str = str+ (char)(Math.random()*26+'a');
            }
            int i = (int) ((Math.random() * 9 + 1) * 1000);
            String activeCode = str+i;

            int  num =  userService.updateMemberToQD(member2s.get(0).getId(),account,provider,1,qdId, activeCode);

            if ( num > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);

            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "数据获取失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> setAgentToMember(String account) {
        Map resMap = new HashMap();
        try {
        //判断这个账号存不存在
        List<Member2> member2s = memberService.countByExample(account);
        if (member2s.size()==0){
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "该账户不存在");
            return resMap;
        }
        //1判断这个人是不是代理或者渠道
            List<MemberAgent2> memberAgent2 = memberAgentService.getMemberAgentInfo(account);
            if (memberAgent2.size()==0){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "这个账号不是渠道或者代理");
                return resMap;
            }
            //判断 这个人是否存在下级
            List<Member2> list =  memberService.getSubordinateMember(memberAgent2.get(0).getMemberId());
            if (list.size()>0){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "账号存在下级,降级前请先转移下级");
                return resMap;
            }
            //将这个代理的返点设置为0
            List<MemberRate2WithBLOBs> memberRateById = memberRateService.findMemberRateById(member2s.get(0).getId());
            for (MemberRate2WithBLOBs memberRate2: memberRateById
                 ) {
                memberRate2.setFdHmRate(0.0);
                memberRate2.setFdDgRate(0.0);
                memberRate2.setCreateDate(new Date());
                memberRate2.setRateEndDate(new Date());
                memberRateService.update(memberRate2);
            }
            //修改这带带里的状态改为0
            MemberAgent2 memberAgent= memberAgent2.get(0);
            memberAgent.setStatus(0);
            memberAgentService.updateMemberAgent(memberAgent);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, "修改成功");
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> memberToWrite(String account,Integer type) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            if(type==null||account==null){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_624);
                resMap.put(Constants.MSG, Constants.ERROR_MSG_624);
                return resMap;
            }
            if(type==1){
                int m = 0;
                String[] split = account.split(",");
                for (String str:split) {
                    m =  m + memberService.memberToWrite(str);
                }
                if (m > 0) {
                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return resMap;
                } else {
                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, "找不到该用户");
                    return resMap;
                }
            }else if (type==2){
                int m = 0;
                int n = 0;
                String[] split = account.split(",");
                for (String str:split) {
                    m =  m + memberService.memberToNoWrite(str);
                    n = n + memberRateService.cancelFD(str);
                }
                if (m > 0|| n >0) {
                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return resMap;
                } else {
                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, "找不到该用户");
                    return resMap;
                }
            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_626);
                resMap.put(Constants.MSG, Constants.ERROR_MSG_626);
                return resMap;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_619);
            resMap.put(Constants.MSG, "设置加白或取消加白出错");
            return resMap;
        }
    }
}
