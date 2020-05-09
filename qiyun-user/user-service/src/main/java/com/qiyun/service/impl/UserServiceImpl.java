package com.qiyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.common.DbDataVerify;
import com.qiyun.common.MyPageInfo;
import com.qiyun.common.Result;
import com.qiyun.dto.*;
import com.qiyun.exception.ServiceException;
import com.qiyun.mapper.*;
import com.qiyun.mapper2.*;
import com.qiyun.model.*;
import com.qiyun.model2.*;
import com.qiyun.service.UserService;
import com.qiyun.status.CommonStatus;
import com.qiyun.type.WalletTransType;
import com.qiyun.util.*;
import com.qiyun.type.WalletType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service("RegisterService")
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private MemberGrade2Mapper memberGrade2Mapper;

    @Resource
    private MemberGradeMapper memberGradeMapper;

    @Resource
    private MemberAgentMapper memberAgentMapper;

    @Resource
    private MemberAgent2Mapper memberAgent2Mapper;

    @Resource
    private MemberInfoMapper memberInfoMapper;

    @Resource
    private MemberInfo2Mapper memberInfo2Mapper;

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private Member2Mapper member2Mapper;

    @Resource
    private MemberWalletMapper memberWalletMapper;

    @Resource
    private MemberWallet2Mapper memberWallet2Mapper;

    @Resource
    private MemberScoreMapper memberScoreMapper;

    @Resource
    private MemberScoreMapper2 memberScoreMapper2;

    /**
     * 修改白名单时间
     */
    public int updateUserToWrite(String userName, Date tobeWriteTime) {
        int i = 0;
        try {
            Member2 member2 = member2Mapper.selectByAccount(userName);
            if (member2.getIsWhitelist() == 0) {
                i = member2Mapper.updateUserToWrite(userName, tobeWriteTime);
            }
        } catch (Exception ex) {
            logger.error("根据account获取member出错", ex);
            return 0;
        }
        return i;

    }

    public Member2 getMemberByAccount(String account) {
        try {
            Member2 member = member2Mapper.selectByAccount(account);
            return member;
        } catch (Exception e) {
            logger.error("根据account获取member出错", e);
            return null;
        }
    }

    public Member getMemberByAccount2(String account) {
        try {
            Member member = memberMapper.selectByAccount(account);
            return member;
        } catch (Exception e) {
            logger.error("根据account获取member出错", e);
            return null;
        }
    }

    public Member2 getMemberByMobile(String mobile) {
        try {
            Member2 member2 = member2Mapper.selectByMobile(mobile);
            return member2;
        } catch (Exception e) {
            logger.error("根据mobile获取member出错", e);
            return null;
        }
    }

//    public Member2 getMemberByMobile2(String mobile) {
//        Member2 member = memberMapper2.selectByMobile(mobile);
//        return  member;
//    }

    public int register(Member2 member2) throws ServiceException {
        Member2 checkMember = this.getMemberByAccount(member2.getAccount());
        if (checkMember != null) {
            logger.info("用户名:" + member2.getAccount() + " 已被使用!");
            throw new ServiceException("7878", "用户名:" + member2.getAccount() + " 已被使用!");
        }

        Member2Query member2Query = new Member2Query();
        member2Query.createCriteria();

        Member2 checkMember2 = member2Mapper.selectByAccount(member2.getAccount());
        int i = 0;
        if (checkMember2 == null) {
            member2Mapper.insertSelective(member2);

            i = member2.getId();

            MemberGrade2 memberGrade2 = new MemberGrade2();
            memberGrade2.setMemberId(member2.getId());
            memberGrade2.setIsReturnPoint(0);
            memberGrade2.setIsVip(0);
            memberGrade2.setMemberAccount(member2.getAccount());
            memberGrade2.setIsProviderTicket(0);
            memberGrade2Mapper.insertSelective(memberGrade2);

            // 初始化会员钱包(老库)
            MemberWallet2 wallet2 = new MemberWallet2();
            wallet2.setWalletType(WalletType.DUOBAO.getValue());
            wallet2.setMemberId(member2.getId());
            wallet2.setAccount(member2.getAccount());
            wallet2.setAbleBalance(BigDecimal.valueOf(new Double(0)).doubleValue());
            wallet2.setFreezeBalance(BigDecimal.valueOf(new Double(0)).doubleValue());
            wallet2.setTakeCashQuota(BigDecimal.valueOf(new Double(0)).doubleValue());
            wallet2.setHeapBalance(BigDecimal.valueOf(new Double(0)).doubleValue());
            wallet2.setHeapPrize(BigDecimal.valueOf(new Double(0)).doubleValue());
            wallet2.setVerifyMd5(DbDataVerify.getMemberWalletVerify2(wallet2));
            wallet2.setCreditLimit(0d);
            wallet2.setAbleCreditBalance(0d);
            wallet2.setFreezeCreditBalance(0d);
            memberWallet2Mapper.insertSelective(wallet2);
            logger.info("初始化会员钱包成功");

            // 初始化会员积分(老库)
            MemberScore2 score2 = new MemberScore2();
            score2.setMemberId(member2.getId());
            score2.setAbleScore(new Integer(0));
            score2.setAccount(member2.getAccount());
            score2.setHeapScore(new Integer(0));
            memberScoreMapper2.insert(score2);
            logger.info("初始化会员积分成功");

            MemberInfo2 info2 = new MemberInfo2();
            info2.setAccount(member2.getAccount());
            info2.setMemberId(member2.getId());
            memberInfo2Mapper.insert(info2);
        }

        return i;
    }

    public Member2 getMember2ByAccount(String account) {
        try {
            Member2 member2 = member2Mapper.selectByAccount(account);
            return member2;
        } catch (Exception e) {
            logger.error("根据account获取member2出错");
            return null;
        }
    }

    public void updateMember2(Member2 member2) {
        try {
            member2Mapper.updateByPrimaryKey(member2);
        } catch (Exception e) {
            logger.error("更新member2出错", e);
        }
    }

    public void updateMember(Member member) {
        try {
            memberMapper.updateByPrimaryKey(member);
        } catch (Exception e) {
            logger.error("更新member出错", e);
        }
    }

    public Result login(String account, String password) {
        try {
            Result result = new Result();

            Member2 member2 = member2Mapper.selectByMobileOrAccount(account);

            if (member2 == null) {
                result.setSuccess(false);
                result.setMsg("账号或密码错误");
                return result;
            }
            if (!MD5.encode(password).equals(member2.getPassword())) {
                result.setSuccess(false);
                result.setMsg("账号或密码错误");
                return result;
            }

            member2.setLastLoginDateTime(new Date());

            member2Mapper.updateByPrimaryKey(member2);

            Member2DTO member2DTO = new Member2DTO();
            CopyUtils.Copy(member2DTO, member2, true);
            if (member2DTO.getIsWhitelist() == 0) {
                member2DTO.setWhiteList2(true);
            } else {
                member2DTO.setWhiteList2(false);
            }
            result.setSuccess(true);
            result.setMsg("登录成功");
            result.setData(member2DTO);
            return result;
        } catch (Exception e) {
            logger.error("登录出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("登录出错");
            return result;
        }
    }

    public Result bindCertNoSave(String certNo, String realName, Member2DTO member2DTO) {
        try {
            Result result = new Result();

            Member2 member2 = member2Mapper.selectByAccount(member2DTO.getAccount());
            if (member2 != null && !StringUtils.isNullOrBlank(member2.getCertNo())) {
                result.setSuccess(false);
                result.setMsg("您已经绑定了身份证信息！如需修改，请联系客服。");
                return result;
            }

            Member2Query member2Query = new Member2Query();
            Member2Query.Criteria criteria2 = member2Query.createCriteria();
            criteria2.andCertNoEqualTo(certNo);
            criteria2.andStatusNotEqualTo(0);
            List<Member2> member2s = member2Mapper.selectByExample(member2Query);
            if (member2s != null && member2s.size() > 0) {
                result.setSuccess(false);
                result.setMsg("身份证信息异常，请联系客服。");
                return result;
            }

            member2.setName(realName);
            member2.setCertNo(certNo);
            member2.setCertType(1);
            member2Mapper.updateByPrimaryKeySelective(member2);

            result.setSuccess(true);
            result.setMsg("绑定成功");
            return result;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("绑定身份证真实姓名出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("绑定身份证真实姓名出错");
            return result;
        }
    }


    public MemberAgentDTO getMemberAgentByActiveCode(String activeCode) {
        try {
            MemberAgent2Query memberAgent2Query = new MemberAgent2Query();
            MemberAgent2Query.Criteria criteria = memberAgent2Query.createCriteria();
            criteria.andActiveCodeEqualTo(activeCode);
            criteria.andStatusEqualTo(1);
            List<MemberAgent2> memberAgent2s = memberAgent2Mapper.selectByExample(memberAgent2Query);
            MemberAgentDTO memberAgentDTO = new MemberAgentDTO();
            if (memberAgent2s != null && memberAgent2s.size() == 1) {
                CopyUtils.Copy(memberAgentDTO, memberAgent2s.get(0), true);
            } else {
                return null;
            }
            return memberAgentDTO;
        } catch (Exception e) {
            logger.error("根据activeCode获取memberAgent出错", e);
            return null;
        }
    }

    public Result getMemberInfo(String account) {
        try {
            Result result = new Result();
            MemberInfo2Query memberInfo2Query = new MemberInfo2Query();
            MemberInfo2Query.Criteria criteria2 = memberInfo2Query.createCriteria();
            criteria2.andAccountEqualTo(account);
            List<MemberInfo2> memberInfo2s = memberInfo2Mapper.selectByExample(memberInfo2Query);
            if (memberInfo2s == null || memberInfo2s.size() <= 0) {
                return result;
            }
            MemberInfo2DTO memberInfo2DTO = new MemberInfo2DTO();
            CopyUtils.Copy(memberInfo2DTO, memberInfo2s.get(0), true);
            result.setSuccess(true);
            result.setData(memberInfo2DTO);
            return result;
        } catch (Exception e) {
            logger.error("根据account获取memberInfo出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("根据account获取memberInfo出错");
            return result;
        }
    }

    private Member2 memberToMember2(Member member) {
        Member2 member2 = new Member2();
        member2.setAccount(member.getAccount());
        member2.setEmail(member.getEmail());
        member2.setCertType(new Integer(1));
        member2.setExprerience(new Integer(0));
        member2.setLastLoginDateTime(new Date());
        member2.setPassword(member.getPassword());
        member2.setRank(1);
        member2.setRecommender(0);
        member2.setRegisterDateTime(new Date());
        member2.setSourceId(member.getSourceId());
        member2.setStatus(0);
        member2.setSign(member.getSign());
        member2.setPlayStatus(0);
        member2.setProvider(member.getProvider());
        member2.setMobile(member.getMobile());
        member2.setPicture(member.getPicture());
        if (member.getIsEmailAuthed()) {
            member2.setIsEmailAuthed(CommonStatus.YES.getValue());
        } else {
            member2.setIsEmailAuthed(CommonStatus.NO.getValue());
        }
        member2.setIsMobileAuthed(CommonStatus.YES.getValue());
        member2.setIsCharge(0);//注册时注入初始值
        member2.setIsWhitelist(CommonStatus.NO.getValue());//2016-3-31调整默认为白名单用户
        return member2;
    }

    //h获取app首页num
    public Map getIndexNumInfo(String account) {
        //获取今日开户人数 SELECT count(*)
        //FROM member
        //WHERE TO_DAYS(REGISTER_DATE_TIME) = TO_DAYS(NOW());
        int accountNum = member2Mapper.findAccountNum(account);
        //获取今日激活人数
        int activeNum = member2Mapper.findActiveNum(account);
        //获取今日消费数和销量
        Map payNum = member2Mapper.findPayNum(account);

        payNum.put("accountNum", accountNum);
        payNum.put("activeNum", activeNum);

        return payNum;
    }

    //获取代理code
    public String getAgentCode(String account) {
        return member2Mapper.getAgentCode(account);
    }

    public int updateMemberNote(Map<String, java.lang.Object> map) {
        int resNum = 0;
        //判断是否是第一次修改
        int num = member2Mapper.findMemberNote(map);
        //是第一次修改
        if (num == 0) {
            resNum = member2Mapper.addMemberNote(map);
        } else if (num > 0) {
            resNum = member2Mapper.updateMemberNote(map);
        }
        return resNum;
    }


    public List<Map> findSalesMoneyInfo(Map account) {

        return member2Mapper.findSalesMoneyInfo(account);
    }

    /*
    开户墙
     */
    public List<Map> findAccountWall(String mincout) {
        Map map = new HashMap();
        map.put("mincout", mincout);
        List<Map> accountWall = member2Mapper.findAccountWall(map);
        return accountWall;
    }

    /*
    充值墙 和消费墙
     */
    public List<Map> findRechargeWall(String account, String minCount, String username, Integer isConsumer) {
        Map<String, java.lang.Object> map = new HashMap<String, java.lang.Object>();
        map.put("account", account);
        map.put("minCount", minCount);
        map.put("username", username);
        map.put("isConsumer", isConsumer);
        List<Map> resList = member2Mapper.findRechargeWall(map);
        return resList;
    }

    public int checkCertNo(String certNo) {
        return member2Mapper.checkCertNo(certNo);
    }

    public int checkMobile(String mobile) {
        return member2Mapper.checkMobile(mobile);
    }

    public Map memberToAgent(String memberName, String agentName, String note, String newAgent) {


        Map<String, Object> resMap = new HashMap<String, Object>();
        //通过newAgent是否为空判断是进行会员转移 还是会员添加 为空为添加
        if (StringUtils.isNullOrBlank(newAgent)) {
            Map paramMap = new HashMap();
            paramMap.put("memberName", memberName);
            paramMap.put("agentName", agentName);
            paramMap.put("note", note);
            paramMap.put("create_time", new Date());
            //0为添加 1为转移
            paramMap.put("is_move", 0);
            paramMap.put("move_agentName", newAgent);
            //判断 这个会员是否存在
            int m = member2Mapper.checkName(memberName);
            //判断这个代理昵称是否存在
            int a = member2Mapper.checkName(agentName);
            if (m > 0 && a > 0) {
                paramMap.put("is_success", 0);
                int resNum = member2Mapper.memberToAgent(paramMap);
                if (resNum > 0) {
                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                } else {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "操作失败");
                    return resMap;
                }
            } else {
                paramMap.put("is_success", 1);
                int resNum = member2Mapper.memberToAgent(paramMap);
                if (resNum > 0) {
                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                } else {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "操作失败");
                    return resMap;
                }
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "请输入正确的会员昵称或者代理昵称");
                return resMap;
            }
        }
        //不为空为会员转移
        else {
            Map paramMap = new HashMap();
            paramMap.put("memberName", memberName);
            paramMap.put("agentName", agentName);
            paramMap.put("note", note);
            paramMap.put("create_time", new Date());
            //0为添加 1为转移
            paramMap.put("is_move", 1);
            paramMap.put("move_agentName", newAgent);
            //判断 这个会员是否存在
            int m = member2Mapper.checkName(memberName);
            //判断这个代理昵称是否存在
            int a = member2Mapper.checkName(agentName);
            //判断 转移代理是否存在
            int n = member2Mapper.checkName(newAgent);
            if (m > 0 && a > 0 && n > 0) {
                paramMap.put("is_success", 0);
                int resNum = member2Mapper.memberToAgent(paramMap);
                if (resNum > 0) {
                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                } else {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "操作失败");
                    return resMap;
                }
            } else {
                paramMap.put("is_success", 1);
                int resNum = member2Mapper.memberToAgent(paramMap);
                if (resNum > 0) {
                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                } else {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "操作失败");
                    return resMap;
                }
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "请输入正确的会员昵称或者代理昵称");
                return resMap;
            }
        }
        return resMap;
    }

    public List<Map> memberMoveLogs() {
        return member2Mapper.memberMoveLogs();
    }

    public PageInfo<List> findMemberPlan(String member,Integer page,Integer pageSize) {
        Map map = new HashMap();
        map.put("member", member);
//        //判断传过来的是昵称 还是账号
//        if (member.startsWith("sj")) {
//            //是账号
//            map.put("is_username", 0);
//        } else {
//            //是昵称
//            map.put("is_username", 1);
//        }
        PageHelper.startPage(page, pageSize);
        List<Map> maps = member2Mapper.findMemberPlan(map);
        PageInfo pageInfo = new PageInfo(maps);
        return pageInfo;
    }

    public boolean findMemberInfo(String agentAccount,String member) {
        Member2 agentMember2 = member2Mapper.selectByAccount(agentAccount);
        if (member.startsWith("sj")) {
            //是账号

            Member2 member2 = member2Mapper.selectByAccount(member);
                if (member2==null){
                    return false;
                }
            return (member2.getSourceId()==agentMember2.getId());
        } else {
         /*   //是昵称
            Member2Query member2Query = new Member2Query();
            Member2Query.Criteria criteria = member2Query.createCriteria();

                criteria.andUsernameLike(member);*/

          List<Member2> list1 = member2Mapper.selectByUserName(member);
            Member2 member2 =null;
                if (list1.size()>0){
                    member2  = list1.get(0);
                }else {
                    return false;
                }
            return member2.getSourceId().intValue()==agentMember2.getId().intValue();
        }

    }

    public List<Map> findAgentInfoByAccount(List<String> account, Integer isMonth) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map> lists = new ArrayList<Map>();
        for (String acc : account
                ) {
            map.put("account", acc);
            map.put("isMonth", isMonth);
            List<Map> saleBuyNum = member2Mapper.findSaleDatas(map);
            for (Map maps1 : saleBuyNum
                    ) {
                maps1.put("offer", 0);
                maps1.put("beidan", 0);
                maps1.put("laozhucai", 0);
                maps1.put("shuzi", 0);

            }
            lists.addAll(saleBuyNum);
        }
        //查询激活
        return lists;
    }


    public List<Map> findMemberAssociation(String agentName, String startDate, String endDate, Integer page, Integer pageSize) {
        Map map = new HashMap();
        map.put("agentName", agentName);
        map.put("startDate", startDate);
        map.put("endDate", endDate);

        List<Map> memberAssociation = member2Mapper.findMemberAssociation(map);

        return memberAssociation;
    }

    public List<Map> findMemberMove(String agentName, String startDate, String endDate) {
        Map map = new HashMap();
        map.put("agentName", agentName);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        return member2Mapper.findMemberMove(map);
    }

    public List<Map> findMemberWalletLine(List<String> agentAccount, String startDate, String endDate) {
        Map map = new HashMap();
        List<Map> lists = new ArrayList<Map>();
        for (String agen : agentAccount
                ) {
            map.put("agentName", agen);
            map.put("startDate", startDate);
            map.put("endDate", endDate);
            List<Map> memberWalletLine = member2Mapper.findMemberWalletLine(map);
            if (memberWalletLine != null) {
                lists.addAll(memberWalletLine);
            }
        }

        return lists;
    }

    public List<Map> findRechargeLine(Map<String, String> mapParam) {
        List<Map> rechargeLine = member2Mapper.findRechargeLine(mapParam);
        for (Map mapInfo : rechargeLine
                ) {
            mapInfo.put("species", "线上加款");
            mapInfo.put("rechargeCompensation", "");
        }
        return rechargeLine;
    }

    public List<Map> findRechargeUnderLine(Map<String, String> mapParam) {
        return member2Mapper.findRechargeUnderLine(mapParam);
    }

    public List<Map> findFinancialCashInfo(Integer isMonth) {
        Map map = new HashMap();
        map.put("isMonth", isMonth);
        List<Map> financialCashInfo = member2Mapper.findFinancialCashInfo(map);
        for (Map maps : financialCashInfo
                ) {
            maps.put("operationsUnderLineAdd", 0);//线下运营加款
            maps.put("cusServiceUnderLineAdd", 0);//线下客服加款
            maps.put("financialUnderLineAdd", 0);//线下财务加款
            maps.put("yibao", 0);
            maps.put("liandong", 0);
            maps.put("zifubao", 0);
            maps.put("allMoney", maps.get("officeUnderLineAdd"));//合计
            maps.put("withdrawal", 0);//当日提款
            maps.put("sendMoney", 0);//当日赠送
        }
        return financialCashInfo;
    }

    public PageInfo findSaleInfo(String agentName, String start_time, String end_time, Integer page, Integer pageSize, String loginAccount) {
        long l = System.currentTimeMillis();
        //查找这个登录账号绑定的渠道account
        List<String> accounts = member2Mapper.findQDByLoginAccount(loginAccount);
        //查询登录账号的所有代理
        List<Map> list = member2Mapper.findDlInfoByQD(accounts,agentName);
        //循环遍历所有 代理去查询
        List<Map> lists = new ArrayList();
            Map mapParams = new HashMap();

            mapParams.put("agentName", list);
            mapParams.put("startTime", start_time);
            mapParams.put("endTime", end_time);
            //获取当日自购和跟单
        System.out.println(list.toString());
            PageHelper.startPage(page,pageSize);
            List<Map> selfBuy = member2Mapper.findselfBuy(mapParams);
            PageInfo pageInfo = new PageInfo(selfBuy);
            //查询当日注册
            int regist = member2Mapper.findAccountNumBy(mapParams);
            //查询当日激活
        /*    int active = member2Mapper.findActiveNumBy(mapParams);
            //查询消费数
            Map<String, Object> payNums = member2Mapper.findPayNumBy(mapParams);*/
            //获取当日佣金
           /* String sumCommision = member2Mapper.findCommision(mapParams);*/
           /* map.put("selfBuy", selfBuy.get("selfBuy"));
            map.put("followBuy", selfBuy.get("followBuy"));*/
            /*map.put("payNum", payNums.get("allPayNum"));
            map.put("active", active);*/
          /*  map.put("agentName", maps.get("agentName"));
            map.put("qdName", maps.get("qdName"));*/
        for ( Map map: selfBuy
             ) {
            map.put("offer", 0);
            map.put("beidan", 0);
            map.put("laozucai", 0);
            map.put("shuzi", 0);
            /* map.put("regist", regist);*/
            map.put("koujian", 0);
            lists.add(map);
        }
        pageInfo.setList(lists);
      /*  }*/
  /*      MyPageInfo myPageInfo =new MyPageInfo();
        List<Map> pageMaps = new ArrayList<Map>();
        myPageInfo.setTotal(list.size());
         int num  = page*pageSize;
        for (int i = num ;i<(page*pageSize+pageSize > list.size() ? list.size():(page*pageSize)+pageSize);i++){

                        pageMaps.add(lists.get(i));
        }
        myPageInfo.setList(pageMaps);
        myPageInfo.setPageNum(page);
        myPageInfo.setPageSize(pageSize);*/
        long l1 = System.currentTimeMillis();
        System.out.println("一共花费"+((l1-l)/1000)+"秒");
        return pageInfo;
    }

    public MyPageInfo findQDSaleInfo(String qdName, String start_time, String end_date, Integer page, Integer pageSize) {
        Map mapParams = new HashMap();
        //查询出所有渠道
        MemberAgent2Query memberAgent2Query = new MemberAgent2Query();
        MemberAgent2Query.Criteria criteria = memberAgent2Query.createCriteria();
        criteria.andAgentTypeEqualTo(0);
        if (qdName.startsWith("sj")){
            criteria.andAccountEqualTo(qdName);
        }else {
            //查询账号
            Member2 byUsername = member2Mapper.getByUsername(qdName);
            criteria.andAccountEqualTo(byUsername.getAccount());
        }
        List<MemberAgent2> memberAgent2s = memberAgent2Mapper.selectByExample(memberAgent2Query);
        List<Map> lists = new ArrayList();
        for (MemberAgent2 ma: memberAgent2s
             ) {
            mapParams.put("agentName", ma.getMemberId());
            mapParams.put("startTime", start_time);
            mapParams.put("endTime", end_date);
            Map<String, Object> map = new HashMap<String, Object>();
            //获取当日自购单数
          /*  Map selfBuy = member2Mapper.findselfBuy(mapParams);*/
            //查询当日跟单单数
            int followBuy = member2Mapper.findfollowBuy(mapParams);
            //查询当日注册
            int regist = member2Mapper.findAccountNumBy(mapParams);
            //查询当日激活
            int active = member2Mapper.findActiveNumBy(mapParams);
            //查询消费数
            Map<String, Object> payNums = member2Mapper.findPayNumBy(mapParams);
            //获取当日佣金
            String sumCommision = member2Mapper.findCommision(mapParams);
           /* map.put("selfBuy",selfBuy.get("selfBuy") );*/
            map.put("followBuy", followBuy);
            map.put("payNum", payNums.get("allPayNum"));
            map.put("active", active);
            map.put("offer", 0);
            map.put("beidan", 0);
            map.put("laozucai", 0);
            map.put("shuzi", 0);
            map.put("regist", regist);
            map.put("sumCommision",Double.valueOf(sumCommision) );
            map.put("koujian", 0);
            lists.add(map);
        }
        MyPageInfo myPageInfo =new MyPageInfo();
        List<Map> pageMaps = new ArrayList<Map>();
        myPageInfo.setTotal(memberAgent2s.size());
        int num  = page*pageSize;
        for (int i = num ;i<(page*pageSize+pageSize > memberAgent2s.size() ? memberAgent2s.size():(page*pageSize)+pageSize);i++){

            pageMaps.add(lists.get(i));
        }
        myPageInfo.setList(pageMaps);
        myPageInfo.setPageNum(page);
        myPageInfo.setPageSize(pageSize);

        return myPageInfo;
    }

    public List<Map> findFinancialMoneyInfo(Integer isMonth) {
        Map map = new HashMap();
        map.put("isMonth", isMonth);
        List<Map> maps = member2Mapper.findFinancialMoneyInfo(map);
        for (Map mapInfo : maps
                ) {
            mapInfo.put("todaySend", 0);
            mapInfo.put("lotteryCard", 0);
            mapInfo.put("lotteryCardUse", 0);
            mapInfo.put("commissionUse", 0);
        }

        return maps;
    }

    public List<Map> findRechargeAndWitdrawlInfo(String account) {
        return member2Mapper.findRechargeAndWitdrawlInfo(account);
    }

    public Map findRoleByAccount(String account) {
        return member2Mapper.findRoleByAccount(account);
    }

    public List<Map<String, Object>> findAllParentModel(Integer id) {
        return member2Mapper.findAllParentModel(id);
    }

    public List<Map<String, Object>> findChildModel(Map map) {

        return member2Mapper.findChildModel(map);
    }

    public int addUser(Map<String, Object> map) {
        return member2Mapper.addUser(map);
    }

    public List<Map> findAllRole(Map<String, Object> map) {
        return member2Mapper.findAllRole(map);
    }

    public List<Map> findAllUserAndRole(Integer id) {
        return member2Mapper.findAllUserAndRole(id);
    }


    public int addPermission(Map<String, Object> map) {
        return member2Mapper.addPermission(map);
    }

    public int addParentModel(Map<String, Object> map) {
        return member2Mapper.addParentModel(map);
    }

    public int addRole(Map<String, Object> map) {
        return member2Mapper.addRole(map);
    }

    public int updatePermission(Map<String, Object> map) {
        return member2Mapper.updatePermission(map);
    }

    public void updateChildPermission(Map map) {
        member2Mapper.updateChildPermission(map);
    }

    public String findModelName(String s) {
        return member2Mapper.findModelName(s);
    }

    public Map findChildModelName(Integer childs, Object id) {
        return member2Mapper.findChildModelName(childs, Integer.parseInt(id.toString()));
    }

    public int MemberAudit(Map map) {
        int i = 0;
        //判断是否通过
        if ("2".equals(map.get("is_erview"))) {
            i = member2Mapper.updateStatus(map);
            return i;
        } else {
            i = member2Mapper.updateStatus(map);
            //添加 关联
            i = member2Mapper.addMemberToAgent(map);
        }
        return i;
    }

    public int MemberMoveAudit(Map map) {
        int i = 0;
        if ("2".equals(map.get("is_erview"))) {
            i = member2Mapper.updateStatus(map);
            return i;
        } else {
            i = member2Mapper.updateStatus(map);
            //添加 关联
            i = member2Mapper.memberMoveAudit(map);
        }
        return i;
    }

    public int updateUserInfo(Map<String, Object> map) {
        return member2Mapper.updateUserInfo(map);
    }

    public int updateChildModelInfo(Map<String, Object> map) {

        //判断是否修改了这个权限的父模块id
        //查找这个父模块的id
        List<Map<String, Object>> childModel = member2Mapper.findChildModel(map);
        Object id = childModel.get(0).get("model_parent");
        //说明修改了父模块的id
        if (!id.equals(map.get("model_parent"))) {

            //获取所有的角色权限
            List<Map> allRole = member2Mapper.findAllRole(map);
            for (Map mapInfo : allRole
                    ) {
                //拿到每一个的权限
                String permission = mapInfo.get("PERMISSION").toString();
                System.out.println("修噶前permi   " + permission);

                if (permission != null) {
                    String[] pers = permission.split("@");
                    String str = "";
                    for (int j = 0; j < pers.length; j++) {
                        //将权限的里面的这个权限移除
                        String idstr = map.get("id").toString();
                        if (pers[j].startsWith(id.toString() + "#")) {
                            //去掉父模块id
                            String childPermission = pers[j].replaceFirst(id.toString() + "#", "");
                            //获取子模块数组
                            List list = Arrays.asList(childPermission.split("#"));
                            List s = new ArrayList(list);
                            s.remove(idstr);
                            pers[j] = id + "#" + org.apache.commons.lang.StringUtils.join(s.toArray(), "#");

                            String sss = pers[j];
                            System.out.println(sss);
                        }
                        if (pers[j].startsWith(map.get("model_parent").toString() + "#")) {
                            pers[j] += "#" + idstr;
                        }
                        if (j != pers.length - 1) {
                            str += pers[j] + "@";
                        } else {
                            str += pers[j];
                        }
                    }
                    mapInfo.put("permissions", str);
                    mapInfo.put("role_id", mapInfo.get("id"));
                    mapInfo.put("role_name", mapInfo.get("NAME"));
                    int il = member2Mapper.updatePermission(mapInfo);
                }
            }
        }
        //修改了模块信息
        int i = member2Mapper.updateChildModelInfo(map);
        return i;
    }

    public List<Map> findChildModelByParent(Integer parentModelId) {
        return member2Mapper.findChildModelByParent(parentModelId);
    }

    public int delUser(Integer user_id) {
        return member2Mapper.delUser(user_id);
    }

    public int updateMemberToQD(Integer member_id, String account, String provider, Integer transType, Integer sourceId, String active_code) {
        Date date = new Date();
        int i = 0;
        //修改member上级 null
        Member2Query member2Query = new Member2Query();
        Member2Query.Criteria criteria = member2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        List<Member2> member2s = member2Mapper.selectByExample(member2Query);
        Member2 member2 = member2s.get(0);
        member2.setProvider(provider);
        member2.setSourceId(sourceId);
        member2Mapper.updateByPrimaryKey(member2);
        //判断这是人以前是不是代理
        MemberAgent2Query memberAgent2Query = new MemberAgent2Query();
        MemberAgent2Query.Criteria criteria1 = memberAgent2Query.createCriteria();
        criteria1.andMemberIdEqualTo(member_id);
        List<MemberAgent2> list = memberAgent2Mapper.selectByExample(memberAgent2Query);
        //说明这个人以前是代理
        if (list.size()>0){
            //进行修改操作
            MemberAgent2 memberAgent2 = list.get(0);
            memberAgent2.setStatus(1);
            memberAgent2.setAgentType(transType);
              i =   memberAgent2Mapper.updateByPrimaryKey(memberAgent2);
        }else {
            //进行添加
            i = member2Mapper.updateMemberToQD(member_id, account, date, transType, active_code);
        }
        return i;
    }

    public List<Map> findAllMember(String start_time, String end_time, String username, String account, String mobile,String realName,String identifyId,String email) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startTime", start_time);
        map.put("endTime", end_time);
        map.put("username", username);
        map.put("account", account);
        map.put("mobile", mobile);
        map.put("realName", realName);
        map.put("identifyId", identifyId);
        map.put("email", email);
        return member2Mapper.findAllMemberBy(map);
    }

    public List<Map> findAllAgentAndQD(String account) {
        return member2Mapper.findAllAgentAndQD(account);
    }

    public void addAgentToQD(Map<String, Object> map) {

        for (Map.Entry<String, Object> en : map.entrySet()
                ) {
            String QD_id = en.getKey();
            String[] agent_id = en.getValue().toString().split(",");
            for (String in : agent_id
                    ) {
                member2Mapper.addAgentToQD(QD_id, Integer.parseInt(in));

            }
        }
    }

    public PageInfo findMemberWalletLineByAccount(Map<String, Object> map) {

        List<WalletTransType> list;
        List<Map> resList = null;

        List<Integer> lists = new ArrayList<Integer>();

        switch (Integer.parseInt(map.get("type") + "")) {
            case 0:
                list = WalletTransType.list;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询
                break;
            case 1:
                list = WalletTransType.outTypeList;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询
                break;
            case 2:
                list = WalletTransType.chargeTypeList;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询

                break;
            case 3:
                list = WalletTransType.consumeTypeList;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询

                break;
            case 4:
                list = WalletTransType.returnTypeList;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询

                break;
            case 5:
                list = WalletTransType.prizeTypeList;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询

                break;
            case 6:
                list = WalletTransType.presentTypeList;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询

                break;
            case 7:
                list = WalletTransType.TikuanTypeList;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询

                break;
            case 8:
                list = WalletTransType.TikuanReturnTypeList;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询

                break;
            case 9:
                list = WalletTransType.otherList;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询

                break;
            case 10:
                list = WalletTransType.takeCashList;

                for (WalletTransType walletTransType : list
                        ) {
                    lists.add(walletTransType.getValue());
                }
                //查询
                break;

        }
        if (map.get("child_type") != null && !"".equals(map.get("child_type"))) {
            lists = new ArrayList<Integer>();
            lists.add(Integer.parseInt(map.get("child_type") + ""));
        }
        PageHelper.startPage(Integer.parseInt(map.get("page") + ""), Integer.parseInt(map.get("pageSize") + ""));
        resList = member2Mapper.findMemberWalletLineByAccount(map, lists);
        PageInfo pageInfo = new PageInfo(resList);

        List<Map> listInfo = new ArrayList<Map>();
        for (Map mapInfo : resList
                ) {
            mapInfo.put("TRANS_TYPE_NAME", WalletTransType.getItem(Integer.parseInt(mapInfo.get("TRANS_TYPE") + "")).getName());
            mapInfo.put("LOTTERY_TYPE_NAME", LotteryType.getItem(Integer.parseInt(mapInfo.get("LOTTERY_TYPE") + "")).getName());
            listInfo.add(mapInfo);
        }
        pageInfo.setList(listInfo);
        return pageInfo;
    }

    public MemberAgent2 findAgetInfo(String account) {
        MemberAgent2 memberAgent = member2Mapper.findAgetInfo(account);
        return memberAgent;
    }

    public void upgradeAgentToQD(String account) {
        //修改代理表agentType = 0
        member2Mapper.upgradeAgentToQD(account);
        //将这个代理的会员上级设置为qd
        Member2Query member2Query = new Member2Query();
        Member2Query.Criteria criteria = member2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        //查找这个代理
        List<Member2> member2s = member2Mapper.selectByExample(member2Query);
        //将这个代理的上级设置为null
        Member2 member2 = member2s.get(0);
        member2.setProvider(null);
        member2Mapper.updateByPrimaryKey(member2);
        //1.查找这个代理手下的会员
        Member2Query member = new Member2Query();
        Member2Query.Criteria criteriaMember = member.createCriteria();
        criteriaMember.andSourceIdEqualTo(member2s.get(0).getId());
        List<Member2> members = member2Mapper.selectByExample(member2Query);
        for (Member2 m : members
                ) {
            m.setProvider("QD");
            member2Mapper.updateByPrimaryKey(m);
        }
    }

    public Map findchildRole(Map map1) {

        return member2Mapper.findchildRole(map1);
    }

    public List<MemberWalletLine2> findRobotConsume() {

        return member2Mapper.findRobotConsume();
    }

    public void updateChild(Map<String, Object> map) {
        member2Mapper.updateChild(map);
    }

    public Map findAdminUser(Map<String, Object> map) {
        return member2Mapper.findAdminUser(map);
    }

    public int updateParentModel(Map<String, Object> map) {
        return member2Mapper.updateParentModel(map);
    }

    public void setOrUpdateQDtoUser(Map map) {
        //增加
        String[] memberAccount = map.get("member_account").toString().split(",");
        List<String> user_account = member2Mapper.findQDByLoginAccount(map.get("user_account") + "");
        if (Integer.parseInt(map.get("is_del").toString()) == 1) {
            for (String s : memberAccount
                    ) {
                //判断登录账号是否绑定过这个渠道
                if (!user_account.contains(s)) {
                    member2Mapper.insetQDToUser(map.get("user_account") + "", s);
                }
            }

        } else {
            //删除
            for (String s : memberAccount
                    ) {
                member2Mapper.delQDToUser(map.get("user_account") + "", s);
            }
        }
    }

    public List<String> findMemberByAccount(String agentAccount) {
        return member2Mapper.findMemberByAccount(agentAccount);
    }

    public List<Map> findMemberPlanByMember(List account) {
        return member2Mapper.findMemberPlanByMember(account);
    }

    public void updateMemberInfoBack(Map<String, Object> paramMap) {
        member2Mapper.updateMemberInfoBack(paramMap);
    }
}
