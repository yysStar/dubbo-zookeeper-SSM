package com.qiyun.service.biz;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.api.UserApi;
import com.qiyun.common.MyPageInfo;
import com.qiyun.common.Result;
import com.qiyun.dto.*;
import com.qiyun.exception.ServiceException;
import com.qiyun.model.Member;
import com.qiyun.model2.*;
import com.qiyun.service.*;
import com.qiyun.tools.CLSmsSend;
import com.qiyun.type.UcOperType;
import com.qiyun.util.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.BinaryClient;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("userApi")
public class UserBiz implements UserApi {

    private static Logger logger = LoggerFactory.getLogger(UserApi.class);
    @Resource
    private UserCountService userCountService;
    @Resource
    private WhiteForCertService whiteForCertService;

    @Resource
    private MemberNoteService memberNoteService;

    @Resource
    private MemberGradeService memberGradeService;

    @Resource
    private MemberRateService memberRateService;

    @Resource
    private SmsCodeService smsCodeService;

    @Resource
    private AdminUserService adminUserService;

    @Resource
    private CelebrityService celebrityService;

    @Resource
    private MailService mailService;

    @Autowired
    private MemberAgentService memberAgentService;

    @Autowired
    private MemberWalletService memberWalletService;

    @Autowired
    private MemberWalletLineService memberWalletLineService;

    @Autowired
    private MemberScoreService memberScoreService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberInfoService memberInfoService;

    @Autowired
    private UserService userService;

    /**
     * 发送短信验证码
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> getSmsNotify(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String mobile = (String) reqMap.get("mobile");
        //类型
        int type = Integer.parseInt(reqMap.get("type").toString());
//        if(type == UcOperType.FIND_PASSWORD_BY_SMS.getValue()){
//            return map;
//        }
        String sRand = getSendContent(type);
        String content = "您的验证码为" + sRand + "。请及时操作！";
        try {
            if ("0".equals(CLSmsSend.send(mobile, content))) {
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put("sRand", sRand);
                logger.info("-----------------验证码=" + sRand);
                return map;
            } else {
                map.put(Constants.CODE, Constants.SMS_ERROR_CODE);
                map.put(Constants.MSG, Constants.SMS_ERROR_CODE_2);
                return map;
            }
        } catch (Exception e) {
            logger.info("-----------------发送短信失败e=" + e);
            map.put(Constants.CODE, Constants.SMS_ERROR_CODE);
            map.put(Constants.MSG, Constants.SMS_ERROR_CODE_2);
            return map;
        }
    }

    public Member2DTO getMember2ByAccount(String account) {
        Member2 member2 = userService.getMember2ByAccount(account);
        Member2DTO member2DTO = new Member2DTO();
        CopyUtils.Copy(member2DTO, member2, true);
        return member2DTO;
    }

    public void updateMember2(Member2 member2) {
        userService.updateMember2(member2);
    }

    public void updateMember(Member member) {
        userService.updateMember(member);
    }

    public Member2DTO getMemberByAccount(String account) {
        Member2 member = userService.getMemberByAccount(account);
        Member2DTO member2DTO = new Member2DTO();
        CopyUtils.Copy(member2DTO, member, true);
        return member2DTO;
    }

    public Result login(String account, String password) {
        return userService.login(account, password);
    }

    public Result bindCertNoSave(String certNo, String realName, Member2DTO member2DTO) {
        return userService.bindCertNoSave(certNo, realName, member2DTO);
    }

    public MemberInfoDTO getMemberInfoByAccount(String account) {
        return memberInfoService.getMemberInfoByAccount(account);
    }

    public Result updateMemberInfo(MemberInfoDTO memberInfoDTO) {
        return memberInfoService.updateMemberInfo(memberInfoDTO);
    }

    public Result updateMemberUsername(Member2DTO member2DTO) {
        return memberService.updateMemberUsername(member2DTO);
    }

    public Result getMemberInfo(String account) {
        return userService.getMemberInfo(account);
    }

    public Result updateMember(Member2DTO member2DTO) {
        return memberService.updateMember(member2DTO);
    }

    public Result getMemberWallet(Integer id) {
        return memberWalletService.getMemberWallet(id);
    }

    public Result updatePwdByMobile(String mobile, String password) {
        return memberService.updatePwdByMobile(mobile, password);
    }

    public Result updateMobile(Member2DTO member2DTO, String oldMobile, String mobile) {
        return memberService.updateMobile(member2DTO, oldMobile, mobile);
    }

    public Result getWalletLine(Member2DTO member2DTO, int page, int pageSize, String type) {
        return memberWalletLineService.getWalletLine(member2DTO, page, pageSize, type);
    }

    public Result updateMemberPicture(Member2DTO memberDTO) {
        return memberService.updateMemberPicture(memberDTO);
    }

    public Result getMemberAgent(Integer memberId) {
        return memberAgentService.getMemberAgent(memberId);
    }

    public Result getMembersByAgent(int id, String username, int page, int pageSize) {
        return memberService.getMembersByAgent(id, username, page, pageSize);
    }

    public Result getCreditMember(String account, int page, int pageSize,String loginAccount) {
        if (loginAccount!=null&&!loginAccount.equals("")) {
            if (checkCmsLoginAccount(new HashMap<String, Object>(), loginAccount, "", "")) {
                Result re = new Result();
                re.setSuccess(false);
                re.setMsg("权限不足");
                return re;
            }
        }
        return memberWalletService.getCreditMember(account, page, pageSize,loginAccount);
    }

    public Result getMail(Member2DTO member2DTO, int page, int pageSize) {
        Result result = mailService.getMail(member2DTO, page, pageSize);
        return result;
    }

    public Result toCaiYan(String account, int multiple) {
        return memberService.toCaiYan(account, multiple);
    }

    public Result getMember(String account, String username, String mobile, String type, int page, int pageSize) {
        return memberService.getMember(account, username, mobile, type, page, pageSize);
    }

    public Result adminLogin(String username, String password) {
        return adminUserService.adminLogin(username, password);
    }

    public Result getSuperMan() {
        Result result = new Result();
        List<Celebrity2> list = celebrityService.getCeleBrity();
        if (list == null) {
            result.setSuccess(true);
            return result;
        }
        List<Member2DTO> arr = new ArrayList<Member2DTO>();
        for (Celebrity2 celebrity2 : list) {
            Member2DTO member2DTO = memberService.getByAccount(celebrity2.getCelebrityName());
            arr.add(member2DTO);
        }
        result.setSuccess(true);
        result.setData(arr);
        return result;
    }

    /**
     * 校验用户名手机号是否可用
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> checkNum(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String userName = (String) reqMap.get("userName");
        String mobile = (String) reqMap.get("mobile");
        Member2 member = null;
        if (!StringUtils.isNullOrBlank(userName)) {
            member = userService.getMemberByAccount(userName);
            if (member != null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_2);
                map.put(Constants.MSG, Constants.ERROR_MSG_2_1);
                return map;
            }
        }
        if (!StringUtils.isNullOrBlank(mobile)) {
            member = userService.getMemberByMobile(mobile);
            if (member != null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_2);
                map.put(Constants.MSG, Constants.ERROR_MSG_2_2);
                return map;
            }
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 修改用户信息
     *
     * @param reqMap
     */
    public Map<String, Object> updateUser(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String userName = (String) reqMap.get("userName");
        int isWhitelist = Integer.parseInt(reqMap.get("isWhitelist").toString());
        Member member = userService.getMemberByAccount2(userName);
        if (isWhitelist != 0) {
            member = updateWhite(member);
            userService.updateMember(member);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> updateUserToWrite(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String userName = (String) reqMap.get("userName");
            Date tobeWriteTime = (Date) reqMap.get("tobeWriteTime");
            if (tobeWriteTime != null) {
                int i = userService.updateUserToWrite(userName, tobeWriteTime);
                if (i > 0) {
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return map;
    }

    /**
     * 注册接口
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> register(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String mobile = (String) reqMap.get("mobile");
        String password = (String) reqMap.get("password");
        String sign = reqMap.get("sign").toString();
        String activeCode = (String) reqMap.get("activeCode");
        String certNo = (String) reqMap.get("certNo");
        String name = (String) reqMap.get("name");
        String account = (String) reqMap.get("account");

        Member2 checkMember;

        Member2DTO byAccount = memberService.getByAccount(account);
        if (byAccount!=null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_5);
            return map;
        }
        Member2 byUserName = memberService.getByUserName(account);
        if (byUserName!=null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_5);
            return map;
        }
        checkMember = userService.getMemberByMobile(mobile);
        if (checkMember != null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_2);
            return map;
        }

        //身份证白名单 （允许多个账号使用相同身份证）
        Member2 member2 = memberService.getByCertNo(certNo);
        if (member2 != null) {
            WhiteForCert2 whiteForCert2 = whiteForCertService.getByCert(certNo);
            if (whiteForCert2 == null || whiteForCert2.getStatus() == 0) {
                map.put(Constants.CODE, Constants.ERROR_CODE_441);
                map.put(Constants.MSG, Constants.ERROR_MSG_441);
                return map;
            }
        }

        Member2 member = new Member2();
        member.setSourceId(0);
        if (!StringUtils.isNullOrBlank(activeCode)) {
            MemberAgentDTO memberAgentDTO = userService.getMemberAgentByActiveCode(activeCode);
            if (memberAgentDTO != null && memberAgentDTO.getAgentType() == 1) {
                member.setProvider("DL");
                member.setSourceId(memberAgentDTO.getMemberId());
            } else if (memberAgentDTO != null && memberAgentDTO.getAgentType() == 0) {
                member.setProvider("QD");
                member.setSourceId(memberAgentDTO.getMemberId());
            } else {
                map.put(Constants.CODE, Constants.ERROR_CODE_7);
                map.put(Constants.MSG, Constants.ERROR_MSG_7_1);
                return map;
            }
        }

        Short s = 1;
        Random random = new Random();
        int num = random.nextInt(9);
        // 初始化用户头像
        member.setPicture("avatar" + num + ".png");
        member.setAccount(account);
        member.setCertNo(certNo);
        member.setExprerience(new Integer(0));
        member.setLastLoginDateTime(null);
        member.setPassword(MD5.encode(password));
        member.setRank(1);
        member.setRecommender(0);
        member.setRegisterDateTime(new Date());
        member.setStatus(0);
        member.setSign(sign);
        member.setMobile(mobile);
        member.setIsMobileAuthed(0);
        member.setIsEmailAuthed(1);
        member.setPlayStatus(0);
        member.setCertType(1);
        member.setName(name);
        member.setUsername(account);
        //有邀请码默认加白
        /*if (member.getSourceId()==0) {
            member.setIsWhitelist(1);
        }else{
            member.setIsWhitelist(0);
        }*/
        member.setIsWhitelist(1);
        member.setIsCharge(0);
        int i = -1;
        try {
            i = userService.register(member);
        } catch (ServiceException e1) {
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_1);
            return map;
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put("id", i);
        return map;
    }

    private String getSendContent(int type) {
        String sendText = "";
        Random random = new Random();
        int randomLength = 4;
        if (type == UcOperType.FIND_PASSWORD_BY_SMS.getValue()) {
            randomLength = 6;
        }
        if (type == UcOperType.UPDATE_MOBILE.getValue()) {
            randomLength = 6;
        }
        for (int i = 0; i < randomLength; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sendText += rand;
        }
        return sendText;
    }

    /**
     * 修改是否白名单值
     *
     * @param member
     * @return
     */
    private Member updateWhite(Member member) {
        if (member.getIsWhitelist()) {
            member.setIsWhitelist(false);
        } else {
            member.setIsWhitelist(true);
        }
        return member;
    }

    /**
     * 获取手机app首页显示的数量
     */
    public Map<String, Object> getIndexNumInfo(String account) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            Map map = userService.getIndexNumInfo(account);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, map);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }

        return resMap;
    }

    /**
     * 获取代理的code
     */
    public Map<String, Object> getAgentCode(String account) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

            String code = userService.getAgentCode(account);
            if (!StringUtils.isNullOrBlank(code)) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA, code);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);
        }
        return resMap;
    }

    /**
     * 修改会员备注信息 修改页面只能修改备注信息
     *
     * @param memInfo {member_id:value,memeber_tel:value,member_zxb:value,member_wx:value,note:value}
     * @return
     */
    public Map<String, Object> updateMemberNote(Map memInfo) {
        Map<String, Object> resMap = new HashMap<String, Object>();

        int i = userService.updateMemberNote(memInfo);
        try {

            if (i > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "修改失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);
        }
        return resMap;
    }

    /**
     * 三天内代理查看销售总量
     */
    public Map findSalesMoneyInfo(String account, Integer isMonth) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            Map<String, Object> parMap = new HashMap<String, Object>();
            parMap.put("account", account);
            parMap.put("isMonth", isMonth);

            List<Map> maps = userService.findSalesMoneyInfo(parMap);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findAccountWall(Integer page, Integer pageSize, String minCount) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageHelper.startPage(page, pageSize);
            List<Map> maps = userService.findAccountWall(minCount);
            PageInfo<Map> pageInfo = new PageInfo<Map>(maps);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, pageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;

    }

    public Map findRechargeWall(String account, Integer page, Integer pageSize, String minCount, String username, Integer isConsumer) {

        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageHelper.startPage(page, pageSize);
            List<Map> maps = userService.findRechargeWall(account, minCount, username, isConsumer);
            PageInfo<Map> pageInfo = new PageInfo<Map>(maps);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, pageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public int checkCertNo(String certNo) {
        return userService.checkCertNo(certNo);
    }

    public int checkMobile(String mobile) {
        return userService.checkMobile(mobile);
    }

    public Map memberToAgent(String memberAccount, String agentAccount, String note, String newAgent) {

        Map<String, Object> resMap = userService.memberToAgent(memberAccount, agentAccount, note, newAgent);

        return resMap;
    }

    public Map memberMoveLogs(Integer page, Integer pageSize) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageHelper.startPage(page, pageSize);
            List<Map> maps = userService.memberMoveLogs();
            for (Map map:maps) {
                Date create_time = (Date) map.get("create_time");
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timestamp = format2.format(create_time);
                map.put("create_time",timestamp);
            }
            PageInfo<Map> pageInfo = new PageInfo<Map>(maps);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, pageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;

    }

    public Map findMemberPlan(Integer page, Integer pageSize, String member, String agentAccount) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            boolean b =true;
            List<Map>  lists;
            if (!"".equals(member)) {
                //判断搜索的账号是不是属于这个代理
                b = userService.findMemberInfo(agentAccount,member);
                if (b) {

                    PageInfo<Map> pageInfo = userService.findMemberPlan(member,page,pageSize);

                    resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                    resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                    resMap.put(Constants.DATA, pageInfo);
                } else {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "没有权限查询这个账户");
                }
                return resMap;
            }
                List<String> list = userService.findMemberByAccount(agentAccount);
                PageHelper.startPage(page, pageSize);
                //查询这个代理名下所有会员
                     lists = userService.findMemberPlanByMember(list);
                PageInfo<Map> pageInfo = new PageInfo<Map>(lists);
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA, pageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> updatePwd(String account, String password) {
        return memberService.updatePwd(account, password);
    }


    public Map<String, Object> saveSmsCode(String mobile, String sRand) {
        return smsCodeService.saveSmsCode(mobile, sRand);
    }

    public Map<String, Object> getSmsCode(String mobile) {
        return smsCodeService.getSmsCode(mobile);
    }

    public Map findAgentInfoByAccount(String account, Integer isMonth) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
                List<String> list= new ArrayList<String>();
                list.add(account);
            List<Map> maps = userService.findAgentInfoByAccount(list, isMonth);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }
/* public Map findAgentInfoByAccountBac(String account, Integer isMonth) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            List<String> list = userCountService.findQDByLoginAccount(account);
            if (list.size()==0){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG,"该账号没有查询信息权限");
                return resMap;
            }
            //查询这个账号下所有渠道下面的代理
            List<String> dlList  = userCountService.findDLByQD(list);
            List<Map> maps = userService.findAgentInfoByAccount(dlList, isMonth);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }*/

    public Map findMemberAssociation(String agentName, String startDate, String endDate, Integer page, Integer pageSize) {

        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageHelper.startPage(page,pageSize);
            List<Map> maps = userService.findMemberAssociation(agentName, startDate, endDate,page,pageSize);
            for (Map map:maps) {
                Date create_time = (Date) map.get("create_time");
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timestamp = format2.format(create_time);
                map.put("create_time",timestamp);
            }
            PageInfo pageInfo = new PageInfo(maps);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, pageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findMemberMove(String agentName, String startDate, String endDate, Integer page, Integer pageSize) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageHelper.startPage(page,pageSize);
            List<Map> maps = userService.findMemberMove(agentName, startDate, endDate);
            for (Map map:maps) {
                Date create_time = (Date) map.get("create_time");
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timestamp = format2.format(create_time);
                map.put("create_time",timestamp);
            }
            PageInfo pageInfo = new PageInfo(maps);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, pageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findMemberWalletLine(String agentAccount, String startDate, String endDate,String loginAccount) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        List<String> dlList = new ArrayList<String>();
        try {
            if (loginAccount!=null&&!loginAccount.equals("")) {
                List<String> list = userCountService.findQDByLoginAccount(loginAccount);
                if (list.size() == 0) {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "该账号没有查询信息权限");
                    return resMap;
                }
                //查询这个账号下所有渠道下面的代理
                dlList = userCountService.findDLByQD(list);
            }
            if (agentAccount!=null&&!agentAccount.equals("")){
                //判断这个代理是否坐在这个渠道下面
                if (dlList.contains(agentAccount)){
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "没有权限查找该代理");
                    return resMap;
                }
                dlList =new ArrayList<String>();
                dlList.add(agentAccount);
            }
            List<Map> maps = userService.findMemberWalletLine(dlList, startDate, endDate);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findRechargeLine(Map<String, String> mapParam) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

            List<Map> maps = userService.findRechargeLine(mapParam);


            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findRechargeUnderLine(Map<String, String> mapParam) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

            List<Map> maps = userService.findRechargeUnderLine(mapParam);


            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findFinancialCashInfo(Integer isMonth) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

            List<Map> maps = userService.findFinancialCashInfo(isMonth);


            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findSaleInfo(String agentName, String start_time, String end_time, Integer page, Integer pageSzie, String loginAccount) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageInfo myPageInfo = userService.findSaleInfo(agentName, start_time, end_time, page, pageSzie, loginAccount);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, myPageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findQDSaleInfo(String qdName, String start_time, String end_date, Integer page, Integer pageSize) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

            MyPageInfo myPageInfo = userService.findQDSaleInfo(qdName, start_time, end_date, page, pageSize);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, myPageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> addCelebrity(String[] accounts) {
        Map<String,Object> map = new HashMap<String,Object>();
        for (String account : accounts) {
            Member2DTO byAccount = memberService.getByAccount(account);
            if (byAccount==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_425);
                map.put(Constants.MSG,"用户名:"+account+"不存在，请检查！");
                return map;
            }
        }
        celebrityService.delete();
        for (String account : accounts) {
            Celebrity2 celebrity2 = new Celebrity2();
            celebrity2.setCelebrityName(account);
            celebrityService.add(celebrity2);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map updateMemberInfoBack(Map<String, Object> paramMap) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

        userService.updateMemberInfoBack(paramMap);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);

        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> relieveBind(String account) {
        return memberInfoService.relieveBind(account);
    }

    public Map findFinancialMoneyInfo(Integer isMonth) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

            List<Map> maps = userService.findFinancialMoneyInfo(isMonth);


            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findRechargeAndWitdrawlInfo(String account) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

            List<Map> maps = userService.findRechargeAndWitdrawlInfo(account);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findRoleAndPermission(String account) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //根据账号查询这个人的角色信息 一个账号一个角色
            Map role = userService.findRoleByAccount(account);
            String permission = role.get("permission").toString();
            if (permission == "") {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "请给用户配置权限");
                return resMap;
            }
            //查询所有的父菜单的 id
            List list = new ArrayList();

            String[] ids = permission.split("@");
            System.out.println(ids.toString());
            for (int i = 0; i < ids.length; i++) {
                Map roleMap = new HashMap();
                String[] split = ids[i].split("#");
                //查询 父菜单的名字
                String modelName = userService.findModelName(split[0]);
                roleMap.put("modelNme", modelName);
                //获取所有子级菜单和子菜单权限
                System.out.println(ids[i].indexOf("#"));

               /* if (ids[i].indexOf("#")!=-1) {*/
                    //+1移除#号
                    String substring = ids[i].substring(ids[i].indexOf("#") + 1);
                     String[] childs =null;
                    if (!substring.equals("")) {
                       childs = substring.split("#");

                     List childPerList = new ArrayList();
                    for (String childId : childs
                            ) {
                        if (!childId.equals("")) {
                            Map List = userService.findChildModelName(Integer.parseInt(childId), role.get("id"));
                            childPerList.add(List);
                        }
                    }

                    roleMap.put("childList", childPerList);
                    list.add(roleMap);
                    }
               /* }*/
            }
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, list);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map addUser(Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //判断账号是否重复
            Map mapUser = userService.findAdminUser(map);
            if (mapUser != null) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "该账户已经存在");
                return resMap;
            }
            int i = userService.addUser(map);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);

        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findAllRole(Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

            List<Map> maps = userService.findAllRole(map);


            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findAllUserAndRole(Integer page, Integer pageSize, Integer id) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageHelper.startPage(page, pageSize);
            List<Map> maps = userService.findAllUserAndRole(id);
            PageInfo pageInfo = new PageInfo(maps);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, pageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findAllParentModel(Integer id) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            List<Map<String, Object>> maps = userService.findAllParentModel(id);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findAllChildModel(Map<String, Object> map, Integer page, Integer pageSize) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageHelper.startPage(page, pageSize);
            List<Map<String, Object>> maps = userService.findChildModel(map);
            PageInfo pageInfo = new PageInfo(maps);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, pageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);
        }
        return resMap;
    }

    public Map addPermission(Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int i = userService.addPermission(map);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map addParentModel(Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int i = userService.addParentModel(map);
            if (i > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map addRole(Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int i = userService.addRole(map);
            if (i > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    // {"role_id":value,"permissions":"父模块id#子模块id@parent_model_id#child_model_id","child_premission":[{"child_model_id":"子模块id","child_permission":value,value},{"child_model_id":子权限}]}
    public Map addRoleBondPermission(Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //保存 到admin_role 权限
            int num = userService.updatePermission(map);

            //1.获得子权限 第一个 为权限 第二个为 子权限
            String role_id = map.get("role_id") + "";
            List<Map> list = (List<Map>)map.get("child_premission");
            for (Map map1 : list
                    ) {
                map1.put("role_id", role_id);
                //判断是否存在这个权限
                Map childRole = userService.findchildRole(map1);
                if (childRole == null) {
                    //保存子权限
                    userService.updateChildPermission(map1);

                } else {
                    map1.put("id", childRole.get("id"));
                    userService.updateChild(map1);
                }

            }
            if (num > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map MemberAudit(Map map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int i = userService.MemberAudit(map);
            if (i > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map MemberMoveAudit(Map map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int i = userService.MemberMoveAudit(map);
            if (i > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> getAgentList(int page, int pageSize) {
        return memberAgentService.getAgentList(page, pageSize);
    }

    public Map updateUserInfo(Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int i = userService.updateUserInfo(map);
            if (i > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map updateChildModelInfo(Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int i = userService.updateChildModelInfo(map);
            if (i > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findChildModelByParent(Integer parentModelId) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            List map = userService.findChildModelByParent(parentModelId);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, map);

        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map delUser(Integer user_id) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            int i = userService.delUser(user_id);
            if (i > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> setMemberRate(Member2DTO member2DTO, String account, double rate, Integer lotteryType) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            Member2DTO byAccount = memberService.getByAccount(account);
            if (byAccount.getSourceId().intValue() != member2DTO.getId().intValue()) {
                map.put(Constants.CODE, Constants.ERROR_CODE_420);
                map.put(Constants.MSG, Constants.ERROR_MSG_420);
                return map;
            }
            MemberRate2WithBLOBs memberRate2 = memberRateService.getByAccountAndType(member2DTO.getAccount(), lotteryType);
            if (memberRate2 == null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_421);
                map.put(Constants.MSG, Constants.ERROR_MSG_421);
                return map;
            }
            if (memberRate2.getFdDgRate() < rate) {
                map.put(Constants.CODE, Constants.ERROR_CODE_422);
                map.put(Constants.MSG, Constants.ERROR_MSG_422);
                return map;
            }
            MemberRate2WithBLOBs memberRate21 = memberRateService.getByAccountAndType(account, lotteryType);
            if (memberRate21 == null) {
                //新增
                memberRate21 = new MemberRate2WithBLOBs();
                memberRate21.setAccount(account);
                memberRate21.setMemberId(byAccount.getId());
                memberRate21.setLotteryType(lotteryType);
                memberRate21.setCreateDate(new Date());
                memberRate21.setReturnPointType(1);
                memberRate21.setFdDgRate(rate);
                memberRate21.setFdHmRate(rate);
                memberRate21.setRateEndDate(memberRate2.getRateEndDate());
                memberRate21.setRateCreateDate(new Date());
                memberRate21.setIsSetRate(1);
                memberRateService.insert(memberRate21);
            } else {
                memberRate21.setFdDgRate(rate);
                memberRate21.setFdHmRate(rate);
                memberRate21.setRateEndDate(memberRate2.getRateEndDate());
                memberRate21.setRateCreateDate(new Date());
                memberRateService.update(memberRate21);
            }

            MemberGrade2 memberGrade2 = memberGradeService.getByAccount(account);
            if (memberGrade2 == null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_400);
                map.put(Constants.MSG, Constants.ERROR_MSG_400);
                return map;
            }
            if (memberGrade2.getIsReturnPoint() == 0) {
                memberGrade2.setIsReturnPoint(1);
                memberGradeService.update(memberGrade2);
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constants.CODE, Constants.ERROR_CODE_423);
            map.put(Constants.MSG, Constants.ERROR_MSG_423);
            return map;
        }
    }

    public Map<String, Object> getMemberRate(String account) {
        return memberRateService.getMemberRate(account);
    }

    public Map updateMemberToQD(Integer member_id, String account) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            String str = "";
            for (int i = 0;i<2;i++){
                str = str+ (char)(Math.random()*26+'a');
            }
            int num = (int) ((Math.random() * 9 + 1) * 1000);
            String active_code = str+num;
            //判断这个 账号是不是代理或者渠道
            MemberAgent2 agetInfo = userService.findAgetInfo(account);
            if (agetInfo!=null) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, "该账户已经是代理或者渠道");
                return resMap;
                //如果这个人事代理
            }
            String provider = null;
            Integer transType = 0;
            Integer sourceId = 0;

            int i = userService.updateMemberToQD(member_id, account, provider, transType, sourceId, active_code);

            if (i > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findAllMember(Integer page, Integer pageSize, String start_time, String end_time, String username, String account, String mobile,String realName,String identifyId,String email) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageHelper.startPage(page, pageSize);
            List<Map> maps = userService.findAllMember(start_time,end_time,username,account,mobile,realName,identifyId,email);
            for (Map map:maps) {

                Date create_time = (Date) map.get("LAST_LOGIN_DATE_TIME");
                Date registerDateTime = (Date) map.get("REGISTER_DATE_TIME");
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                if (create_time == null) {
                    map.put("lastLoginDateTime", "----");
                } else {
                    String timestamp = format2.format(create_time);
                    map.put("lastLoginDateTime", timestamp);
                }
                if (registerDateTime == null) {
                    map.put("registerDateTime", "----");
                } else {
                    String format = format2.format(registerDateTime);
                    map.put("registerDateTime", format);
                }
            }
            PageInfo pageInfo = new PageInfo(maps);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, pageInfo);

        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

        public Map findAllAgentAndQD(Integer page, Integer pageSize, String account) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageHelper.startPage(page,pageSize);
            List<Map> map = userService.findAllAgentAndQD(account);
            for (Map ne:map) {
                Date create_time = (Date)ne.get("CREATE_DATE_TIME");
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String create_time2= format2.format(create_time);
                ne.put("CREATE_DATE_TIME2",create_time2);
            }
            PageInfo pageInfo = new PageInfo(map);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, pageInfo);

        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map addAgentToQD(Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

            userService.addAgentToQD(map);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, map);

        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> updateMemberTicket(String account, int isProviderTicket) {
        Map<String, Object> map = new HashMap<String, Object>();
        MemberGrade2 byAccount = memberGradeService.getByAccount(account);
        if (byAccount == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_400);
            map.put(Constants.MSG, Constants.ERROR_MSG_400);
            return map;
        }
        if (byAccount.getIsProviderTicket() != isProviderTicket) {
            byAccount.setIsProviderTicket(isProviderTicket);
            memberGradeService.update(byAccount);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    public Map findMemberWalletLineByAccount(Map<String, Object> map) {

        Map<String, Object> resMap = new HashMap<String, Object>();
        List<String> list = null;
        try {
            String loginAccount = map.get("loginAccount")+"";
            String qdAccount = map.get("qdAccount")+"";
            String dlAccount = map.get("dlAccount")+"";

            String memberAccount = map.get("account")+"";
            //如果直接会员信息直接返回
            if (!memberAccount.equals("")&&memberAccount!=null){
                if (checkCmsLoginAccount(resMap, loginAccount, dlAccount, memberAccount)) return resMap;

                List<String> listAccount  = new ArrayList<String>();
                listAccount.add(map.get("account")+"");
                map.put("account",listAccount);

               PageInfo maps = userService.findMemberWalletLineByAccount(map);

                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA, maps);
                return resMap;
            }
            //
          list  = userCountService.findQDByLoginAccount(loginAccount);
            if (list.size()==0){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG,"该账号没有查询信息权限");
                return resMap;
            }
            //通过渠道条件查询
            if ((!qdAccount.equals(""))&&qdAccount!=null){
                list = new ArrayList<String>();
                list.add(qdAccount);
            }
            //查询这个账号下所有渠道下面的代理
            List<String> dlList  = userCountService.findDLByQD(list);
           //将代理和渠道的account放入同一个集合
            dlList.addAll(list);
            //代理条件查询
            if ((!dlAccount.equals(""))&&dlAccount!=null){
                //判断搜索的代理是否是登录账户渠道里面手下的代理
                if (!dlList.contains(dlAccount)){
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "没有权限查询这代理");
                    return resMap;
                }
                dlList = new ArrayList<String>();
                dlList.add(dlAccount);
            }
            //查询渠道和代理手下的会员
             List<String> memberAccounts = userCountService.findMemAccountByupAccount(dlList);

            //传入所有会员账号查询

                map.put("account",memberAccounts);

               PageInfo maps = userService.findMemberWalletLineByAccount(map);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, maps);

        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    private boolean checkCmsLoginAccount(Map<String, Object> resMap, String loginAccount, String dlAccount, String memberAccount) {
        List<String> list;
        list  = userCountService.findQDByLoginAccount(loginAccount);
        if (list.size()==0){
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG,"该账号没有查询信息权限");
            return true;
        }
        List<String> dlList  = userCountService.findDLByQD(list);
        dlList.addAll(list);
        if (!dlAccount.equals("null")&&!dlAccount.equals("")&&dlAccount!=null){
        if (!dlList.contains(dlAccount)){
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, "没有权限查询这代理");
            return true;
        }
        }
        List<String> memberAccounts = userCountService.findMemAccountByupAccount(dlList);
        if (!memberAccount.equals("null")&&!memberAccount.equals("")&&memberAccount!=null) {
            if (!memberAccounts.contains(memberAccount)) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "该账号没有查询该用户信息权限");
                return true;
            }
        }
        return false;
    }


    public Map upgradeAgentToQD(String account) {

        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //判断这个人是不是是不是代理
            MemberAgent2 memberAgent2 = userService.findAgetInfo(account);
            if (memberAgent2 == null) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "未查询到该代理");
                return resMap;
            }
            userService.upgradeAgentToQD(account);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> setKeyClient(Member2DTO member2DTO, String account, int status) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO byAccount = memberService.getByAccount(account);
        if (byAccount == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_400);
            map.put(Constants.MSG, Constants.ERROR_MSG_400);
            return map;
        }
        if (byAccount.getSourceId().intValue() != member2DTO.getId().intValue()) {
            map.put(Constants.CODE, Constants.ERROR_CODE_439);
            map.put(Constants.MSG, Constants.ERROR_MSG_439);
            return map;
        }
        MemberNote2 memberNote2 = memberNoteService.getByKhAccount(account);
        if (memberNote2 == null) {
            memberNote2 = new MemberNote2();
            memberNote2.setMemberId(account);
            memberNote2.setIsKey(status);
            memberNoteService.add(memberNote2);
        } else {
            memberNote2.setIsKey(status);
            memberNoteService.update(memberNote2);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> addWhiteCert(String certNo, int status) {
        WhiteForCert2 byCert = whiteForCertService.getByCert(certNo);
        if (byCert == null) {
            byCert = new WhiteForCert2();
            byCert.setCertNo(certNo);
            byCert.setStatus(status);
            whiteForCertService.add(byCert);
        } else {
            byCert.setStatus(status);
            whiteForCertService.update(byCert);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> getWhiteCert(int page, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<WhiteForCert2> list = whiteForCertService.getWhiteCertByStatus(page, pageSize, 1);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, new PageInfo<WhiteForCert2>(list));
        return map;

    }

    public Map findRobotConsume(Integer page, Integer pageSize) {

        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //判断这个人是不是是不是代理
            PageHelper.startPage(page, pageSize);
            List<MemberWalletLine2> member = userService.findRobotConsume();
            PageInfo pageInfo = new PageInfo(member);
            if (member == null) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "没有机器人数据");
                return resMap;
            }
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, pageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map setAgentPassword(Map params) {
        //判断账号是不是代理
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //判断这个人是不是是不是代理

            List<MemberAgent2> member = memberAgentService.getMemberAgentInfo(params.get("account") + "");
            if (member.size() == 0) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "这个人不是代理");
                return resMap;
            }
            MemberAgent2 memberAgent2 = member.get(0);
            if (memberAgent2.getPayPass() != null) {
                if (MD5.encode(params.get("password") + "").equals(memberAgent2.getPayPass())) {
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                    resMap.put(Constants.MSG, "与上次密码不能一样");
                    return resMap;
                }

            }
            memberAgent2.setPayPass(MD5.encode(params.get("password") + ""));
            memberAgentService.updateMemberAgent(memberAgent2);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);

        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map updateParentModel(Map<String, Object> map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

            int i = userService.updateParentModel(map);

            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);


        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map setOrUpdateQDtoUser(Map map) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //增加
             userService.setOrUpdateQDtoUser(map);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);


        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

}
