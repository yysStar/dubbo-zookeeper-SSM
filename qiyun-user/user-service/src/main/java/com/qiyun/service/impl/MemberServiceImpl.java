package com.qiyun.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.qiyun.common.DbDataVerify;
import com.qiyun.common.GoldCard2;
import com.qiyun.common.Result;
import com.qiyun.commonModel.MemberChargeLine;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.SuperGodDTO;
import com.qiyun.mapper.MemberMapper;
import com.qiyun.mapper2.*;
import com.qiyun.model.Member;
import com.qiyun.model2.*;
import com.qiyun.service.MemberService;
import com.qiyun.type.WalletType;
import com.qiyun.util.*;
import com.qiyun.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class MemberServiceImpl implements MemberService {

    private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private Member2Mapper member2Mapper;

    @Resource
    private MemberGrade2Mapper memberGrade2Mapper;

    @Resource
    private MemberScoreMapper2 memberScore2Mapper;

    @Resource
    private MemberInfo2Mapper memberInfo2Mapper;

    @Resource
    private MemberWallet2Mapper memberWallet2Mapper;
    @Resource
    private MemberWalletLine2Mapper memberWalletLine2Mapper;

    public Map<String, Object> getHistoryClient(int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageHelper.startPage(offset, pageSize);
        Date beforeOneMonth = DateUtil.getBeforeOneMonth(new Date());
        List<Member2> beforeOneMonth1 = member2Mapper.getBeforeOneMonth(beforeOneMonth);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA,beforeOneMonth1);
        return map;
    }

    public Result updateMemberUsername(Member2DTO member2DTO) {
        try {
            Result result = new Result();

            Member2Query member2Query = new Member2Query();
            Member2Query.Criteria criteria = member2Query.createCriteria();
            criteria.andUsernameEqualTo(member2DTO.getUsername());
            List<Member2> member2s = member2Mapper.selectByExample(member2Query);
            if (member2s != null && member2s.size() > 0) {
                result.setSuccess(false);
                result.setMsg("该用户名已被占用");
                return result;
            }

            Member2 member2 = member2Mapper.selectByPrimaryKey(member2DTO.getId());
            if (member2 == null) {
                result.setSuccess(false);
                result.setMsg("修改用户名出错");
                return result;
            }

            if (!StringUtils.isNullOrBlank(member2.getUsername())) {
                result.setSuccess(false);
                result.setMsg("用户名只能修改一次");
                return result;
            }
            member2.setUsername(member2DTO.getUsername());
            member2Mapper.updateByPrimaryKey(member2);

            result.setSuccess(true);
            result.setMsg("修改成功");
            return result;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("获取用户名出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取用户名出错");
            return result;
        }
    }

    public Result updateMember(Member2DTO member2DTO) {
        try {
            Result result = new Result();
            Member2 member2 = new Member2();
            member2.setId(member2DTO.getId());
            member2.setPassword(member2DTO.getPassword());
            member2Mapper.updateByPrimaryKeySelective(member2);
            result.setSuccess(true);
            result.setMsg("修改成功");
            return result;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新member出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("更新member出错");
            return result;
        }
    }

    public Result updatePwdByMobile(String mobile, String password) {
        try {
            Result result = new Result();

            Member2Query member2Query = new Member2Query();
            Member2Query.Criteria criteria2 = member2Query.createCriteria();
            criteria2.andMobileEqualTo(mobile);
            List<Member2> member2s = member2Mapper.selectByExample(member2Query);

            if (member2s == null || member2s.size() <= 0) {
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }

            Member2 member2 = member2s.get(0);
            member2.setPassword(password);
            member2Mapper.updateByPrimaryKey(member2);

            result.setSuccess(true);
            result.setMsg("修改成功");
            return result;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("根据手机号修改密码出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("根据手机号修改密码出错");
            return result;
        }
    }

    public Result updateMobile(Member2DTO member2DTO, String oldMobile, String mobile) {
        try {
            Result result = new Result();

            Member2 member2 = member2Mapper.selectByMobile(oldMobile);
            Member2 member = member2Mapper.selectByMobile(mobile);
            if (member != null) {
                result.setSuccess(false);
                result.setMsg("该手机号已被使用!");
                return result;
            }
            if (!member2.getMobile().equals(oldMobile)) {
                result.setSuccess(false);
                result.setMsg("原手机号错误!|");
                return result;
            }
            member2.setMobile(mobile);
            member2Mapper.updateByPrimaryKeySelective(member2);
            result.setSuccess(true);
            result.setMsg("修改成功");
            return result;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("修改手机号出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("修改手机号出错");
            return result;
        }
    }

    public Result updateMemberPicture(Member2DTO memberDTO) {
        try {
            Result result = new Result();

            Member2 member2 = new Member2();
            member2.setId(memberDTO.getId());
            member2.setPicture(memberDTO.getPicture());
            member2Mapper.updateByPrimaryKeySelective(member2);
            result.setSuccess(true);
            result.setMsg("修改成功");
            result.setData(member2.getPictureUrl());
            return result;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("修改用户头像出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("修改用户头像出错");
            return result;
        }
    }

    public Result getMembersByAgent(int id, String username, int page, int pageSize) {
        Result result = new Result();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", id);
            if (!StringUtils.isNullOrBlank(username)) {
                map.put("username", username);
            }
            List<Map<String, Object>> resMap = member2Mapper.getMemberByAgent(map);
            result.setSuccess(true);
            result.setData(resMap);
            return result;
        } catch (Exception e) {
            logger.error("获取代理名下会员出错", e);
            result.setSuccess(false);
            result.setMsg("获取代理名下会员出错");
            return result;
        }
    }

    public Result toCaiYan(String account, int multiple) {
        Result result = new Result();
        try {
            Member2 member2 = member2Mapper.selectByAccount(account);
            if (member2 == null) {
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }
            if (member2.getType() != 0) {
                result.setSuccess(false);
                result.setMsg("只有普通会员才能设置为彩研人员");
                return result;
            }
            member2.setType(1);
            member2.setMultiple(multiple);
            member2Mapper.updateByPrimaryKeySelective(member2);
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            logger.error("设置彩研人员出错", e);
            result.setSuccess(false);
            result.setMsg("设置彩研人员出错");
            return result;
        }
    }

    public Result getMember(String account, String username, String mobile, String type, int page, int pageSize) {
        Result result = new Result();
        try {
            Member2Query member2Query = new Member2Query();
            Member2Query.Criteria criteria = member2Query.createCriteria();
            if (!StringUtils.isNullOrBlank(account)) {
                criteria.andAccountEqualTo(account);
            }
            if (!StringUtils.isNullOrBlank(username)) {
                criteria.andUsernameEqualTo(username);
            }
            if (!StringUtils.isNullOrBlank(mobile)) {
                criteria.andMobileEqualTo(mobile);
            }
            if (!StringUtils.isNullOrBlank(type)) {
                criteria.andTypeEqualTo(Integer.parseInt(type));
            }
            PageHelper.startPage(page, pageSize);
            List<Member2> member2s = member2Mapper.selectByExample(member2Query);
            int totalCount = member2Mapper.countByExample(member2Query);
            if (member2s == null) {
                result.setSuccess(true);
                result.setTotalCount(0);
                return result;
            }
            List<Member2DTO> list = new ArrayList<Member2DTO>();
            for (Member2 member2 : member2s) {
                Member2DTO member2DTO = new Member2DTO();
                CopyUtils.Copy(member2DTO, member2, true);
                list.add(member2DTO);
            }
            result.setSuccess(true);
            result.setData(list);
            result.setTotalCount(totalCount);
            return result;
        } catch (Exception e) {
            logger.error("条件查询会员出错", e);
            result.setSuccess(false);
            result.setMsg("条件查询会员出错");
            return result;
        }
    }

    /**
     * 获取超级大神个人中心
     *
     * @param account
     * @return
     */
    public SuperGodDTO getSuperGod(String account) {
        return member2Mapper.getSuperGod(account);
    }

    /**
     * 获取没有发过单子的人的粉丝数和关注数
     *
     * @param account
     * @return
     */
    public SuperGodDTO getSuperGodN(String account) {
        return member2Mapper.getSuperGodN(account);
    }

    public Member2DTO getByAccount(String account) {
        Member2 member2 = member2Mapper.selectByAccount(account);
        if (member2 == null) {
            return null;
        }
        Member2DTO member2DTO = new Member2DTO();
        CopyUtils.Copy(member2DTO, member2, true);
        return member2DTO;
    }

    public Map<String, Object> updatePwd(String account, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2 member2 = null;
        if (!"sj".equals(account.substring(0, 2))) {
            member2 = member2Mapper.getByUsername(account);
        } else {
            member2 = member2Mapper.selectByAccount(account);
        }
        if (member2 == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_400);
            map.put(Constants.MSG, Constants.ERROR_MSG_400);
            return map;
        }
        member2.setPassword(MD5.encode(password));
        member2Mapper.updateByPrimaryKeySelective(member2);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    public String genRandomAccount(String sj) {
        String account = "";

        while (true) {
            account = sj + com.qiyun.util.StringUtil.randomNumberString(9);
            Member2 member = member2Mapper.selectByAccount(account);

            if (member == null) {
                break;
            }
        }

        return account;
    }

    public int addRobot(Member2 member) {
        member2Mapper.insertSelective(member);
        int id = member.getId();

        MemberGrade2 memberGrade2 = new MemberGrade2();
        memberGrade2.setMemberId(id);
        memberGrade2.setIsReturnPoint(0);
        memberGrade2.setIsVip(0);
        memberGrade2.setMemberAccount(member.getAccount());
        memberGrade2Mapper.insertSelective(memberGrade2);

        // 初始化会员钱包(老库)
        MemberWallet2 wallet2 = new MemberWallet2();
        wallet2.setWalletType(WalletType.DUOBAO.getValue());
        wallet2.setMemberId(id);
        wallet2.setAccount(member.getAccount());
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
        score2.setMemberId(id);
        score2.setAbleScore(new Integer(0));
        score2.setAccount(member.getAccount());
        score2.setHeapScore(new Integer(0));
        memberScore2Mapper.insert(score2);
        logger.info("初始化会员积分成功");

        MemberInfo2 info2 = new MemberInfo2();
        info2.setAccount(member.getAccount());
        info2.setMemberId(id);
        memberInfo2Mapper.insert(info2);
        return id;
    }

    public List<Member2> getRobotList(int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        List<Member2> list = member2Mapper.getRobotList();
        return list;
    }

    public Member2 getByUserName(String userName) {
        return member2Mapper.getByUsername(userName);
    }

    public Member2 getByMobile(String mobile) {
        return member2Mapper.selectByMobile(mobile);
    }

    public Member2 getByPlanNo(int planNo) {
        return member2Mapper.selectByPlanNo(planNo);
    }

    public int findDrawsNums(String account) {
        return member2Mapper.findDrawsNums(account);
    }

    public int updateDrawsNum(String account) {
        int drawsNums = member2Mapper.findDrawsNums(account);
        if (drawsNums > 0) {
            int num = member2Mapper.updateDrawsNum(drawsNums - 1, account);
            return num;
        } else {
            return 0;
        }
    }

    public int addGoldCard(GoldCard2 goldCard2) {
        return member2Mapper.addGoldCard(goldCard2);
    }

    public List<GoldCard2> findGoldCard(String account, String startTime, String endTime) {
        return member2Mapper.findGoldCard(account, startTime, endTime);
    }

    public int addActivity(Map<String, Object> mapParams) {
        return member2Mapper.addActivity(mapParams);
    }

    public List<Map> findAllActivity() {
        return member2Mapper.findAllActivity();
    }

    public int updateActivity(Map<String, Object> mapParams) {
        return member2Mapper.updateActivity(mapParams);
    }

    public int resetDrawsNum() {

        return member2Mapper.resetDrawsNum();
    }

    public int updateGoldCard(GoldCard2 goldCard2) {
        return member2Mapper.updateGoldCard(goldCard2);
    }

    public int incrementDrawsNum(int i, String account) {
        return member2Mapper.incrementDrawsNum(i, account);
    }

    public List<Member2> countByExample(String account) {
        Member2Query member2Query = new Member2Query();
        Member2Query.Criteria criteria = member2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        return member2Mapper.selectByExample(member2Query);
    }

    public int presentes(String params, String username) {
        List list = JSONObject.parseObject(params, List.class);
        for (Object obj : list
                ) {
            Map<String, Object> map = (Map) obj;
            for (Map.Entry<String, Object> en : map.entrySet()
                    ) {
                MemberWallet2Query memberWallet2Query = new MemberWallet2Query();
                MemberWallet2Query.Criteria criteria = memberWallet2Query.createCriteria();
                criteria.andAccountEqualTo(en.getKey());
                List<MemberWallet2> memberWallet2s = memberWallet2Mapper.selectByExample(memberWallet2Query);
                if (memberWallet2s.size() < 0) {
                    return 0;
                }
                //查找member
                Member2 member2 = member2Mapper.selectByAccount(en.getKey());
                //获取钱包
                MemberWallet2 memberWallet2 = memberWallet2s.get(0);
                //修改钱包可用金额
                Double ableBalance = memberWallet2.getAbleBalance();
                memberWallet2.setAbleBalance(ableBalance + Double.valueOf(en.getValue() + ""));
                memberWallet2Mapper.updateByPrimaryKey(memberWallet2);
                //添加钱包流水
                MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
                memberWalletLine2.setAbleBalance(ableBalance + Double.valueOf(en.getValue() + ""));
                memberWalletLine2.setAccount(memberWallet2.getAccount());
                memberWalletLine2.setAmount(Double.valueOf(en.getValue() + ""));
                memberWalletLine2.setCreateDateTime(new Date());
                memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
                memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
                memberWalletLine2.setLotteryType(0);
                memberWalletLine2.setMemberId(memberWallet2.getMemberId());
                memberWalletLine2.setOperLineNo(0);
                memberWalletLine2.setOrderNo(0);
                memberWalletLine2.setPlanNo(0);
                memberWalletLine2.setPlatform(1);
                memberWalletLine2.setPrizeBalance(memberWallet2.getPrizeBalance());
                memberWalletLine2.setRemark("彩金赠送,操作人:" + username);
                memberWalletLine2.setSourceId(member2.getSourceId());
                memberWalletLine2.setStatus(0);
                memberWalletLine2.setTransType(1);
                memberWalletLine2.setWalletType(1);
                memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletVerify2(memberWallet2));
                //保存钱包流水
                memberWalletLine2Mapper.insertSelective(memberWalletLine2);
            }
        }
        return 1;
    }


    public List<Member2> getSubordinateMember(Integer memberId) {
        Member2Query member2Query = new Member2Query();
        Member2Query.Criteria criteria = member2Query.createCriteria();
        criteria.andSourceIdEqualTo(memberId);
        List<Member2> member2s = member2Mapper.selectByExample(member2Query);
        return member2s;
    }

    public Member2 getByCertNo(String certNo) {
        Member2Query member2Query = new Member2Query();
        Member2Query.Criteria criteria = member2Query.createCriteria();
        criteria.andCertNoEqualTo(certNo);
        List<Member2> member2s = member2Mapper.selectByExample(member2Query);
        if (member2s == null || member2s.size() <= 0) {
            return null;
        }
        return member2s.get(0);
    }

    public void updateMemberSourceId(String provider, int i, Integer memberId) {
        member2Mapper.updateMemberSourceId(provider, i, memberId);
    }

    public int memberToWrite(String account) {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        return member2Mapper.memberToWrite(account,time);
    }

    public int memberToNoWrite(String account) {
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        return member2Mapper.memberToNoWrite(account,time);
    }
}
