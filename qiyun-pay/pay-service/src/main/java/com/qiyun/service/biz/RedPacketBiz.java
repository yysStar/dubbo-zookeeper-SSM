package com.qiyun.service.biz;

import com.github.pagehelper.PageInfo;
import com.qiyun.api.RedPacketApi;
import com.qiyun.dto.*;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.model.Member;
import com.qiyun.model2.*;
import com.qiyun.service.*;
import com.qiyun.util.Constants;
import com.qiyun.util.DateUtil;
import com.qiyun.utils.DbDataVerify;
import com.qiyun.utils.NumberTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("redPacketApi")
public class RedPacketBiz implements RedPacketApi {
    @Autowired
    private RedPacketService redPacketService;
    @Autowired
    private MemberWalletService memberWalletService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private RedPacketLogService redPacketLogService;
    @Autowired
    private MemberFollowMappingService memberFollowMappingService;
    @Autowired
    private MemberWalletLineService memberWalletLineService;


    public Map<String, Object> lyRedPackage(String id, String account,String content) {
        return redPacketLogService.lyRedPackage(id,account,content);
    }

    /**
     * 判断是否有新的红包
     *
     * @param account
     * @return
     */
    public Map<String, Object> isRedPacket(String account) {
        return redPacketService.isRedPacket(account);
    }

    /**
     * 发红包时查询是否有进行中的单或红单
     *
     * @param account
     * @return
     */
    public Map<String, Object> search(String account) {
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String, Object> search = redPacketService.search(account);
        return search;
    }

    /**
     * 新建红包
     * @param account
     * @return
     */
    public Map<String, Object> addRedRacket(String account,
            BigDecimal money, String name, int type, int number, int apply,int mark) {
        Map<String,Object> map = new HashMap<String, Object>();
        MemberWallet2DTO memberWallet2 = memberWalletService.getMemberWalletByAccount(account);
        BigDecimal ableBalance = new BigDecimal(memberWallet2.getAbleBalance());
        if(type == 2){
            money = money.multiply(new BigDecimal(number));
        }
        if(memberWallet2 == null || money.compareTo(ableBalance) > 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_1);
            return map;
        }
        //单个金额小于0.01
        if(type == 1 && money.divide(new BigDecimal(number)).compareTo(new BigDecimal(0.01)) < 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_2);
            return map;
        }
        BigDecimal ableBalanceNew = ableBalance.subtract(money);
        memberWallet2.setAbleBalance(ableBalanceNew.doubleValue());
        memberWalletService.updateByPrimaryKeySelective(memberWallet2);
        RedPacket redPacket = RedPacket.builder().account(account).apply(apply)
                .createDatetime(new Date()).money(money).name(name).type(type).number(number)
                .surplusMoney(money).surplusNumber(number).mark(mark).build();
        int i = redPacketService.insertSelective(redPacket);
        //添加钱包流水 41发红包
        saveLine(memberWallet2, 41, money,i);
        Jedis jedis = RedisUtil.getJedis();
        jedis.del("newhongbao");
        jedis.close();
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put("i", i);
        return map;
    }

    /**
     * 红包列表
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> redRacketList(int offset,int pageSize,String account){
        Map<String,Object> map = new HashMap<String, Object>();
        List<RedPacketDTO> list = redPacketService.getAllList(offset, pageSize);
        boolean isGrab = false;
        for(RedPacketDTO redPacket : list){
            if((redPacket.getStatus() == 1 || redPacket.getStatus() == 2)) {
                if (DateUtil.isOverdue(redPacket.getCreateDatetime())){
                    redPacket.setStatus(4);// 已过期
                    if(redPacket.getSurplusNumber() > 0){// 余额退还
                        MemberWallet2DTO memberWallet2 =
                                memberWalletService.getMemberWalletByAccount(redPacket.getAccount());
                        BigDecimal ableBalance = new BigDecimal(memberWallet2.getAbleBalance());
                        BigDecimal ableBalanceNew = ableBalance.add(redPacket.getSurplusMoney());
                        memberWallet2.setAbleBalance(ableBalanceNew.doubleValue());
                        memberWalletService.updateMemberWallet(memberWallet2);
                        //添加钱包流水 43退还红包
                        saveLine(memberWallet2, 43, redPacket.getSurplusMoney(),redPacket.getId());
                        redPacket.setSurplusMoney(new BigDecimal(0));
                        redPacket.setSurplusNumber(0);
                    }
                    redPacketService.updateByPrimaryKeySelective(redPacket);
                } else {
                    isGrab = true;
                }
            }
        }
        PageInfo<RedPacketDTO> page = new PageInfo(list);
        Jedis jedis = RedisUtil.getJedis();
        long sadd = jedis.sadd("newhongbao", account);
        jedis.close();
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, page);
        map.put("isGrab", isGrab);
        return map;
    }

    /**
     * 红包校验
     * @param id
     * @param account
     * @return
     */
    public Map<String, Object> checkRedRacket(int id, String account){
        Map<String,Object> map = new HashMap<String, Object>();
        boolean isGrabed = false;//是否已抢
        RedPacketLog redPacketLog = redPacketLogService.getByPacketId(id, account);
        RedPacket redPacket = redPacketService.getById(id);
        String  account2 = redPacket.getAccount();
        String username = redPacketService.getUsername(account2);
        String picture = redPacketService.getPICTURE(account2);
        map = checkGrab(redPacket, account);
        if(Integer.parseInt(map.get(Constants.CODE).toString()) != Constants.SUCCESS_CODE){
            return map;
        }
        if (DateUtil.isOverdue(redPacket.getCreateDatetime())){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_4);
            return map;
        }
        if(redPacketLog != null){
            isGrabed = true;
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put("isGrabed", isGrabed);
        map.put("username", username);
        map.put("picture", "https://qyun88.oss-cn-hangzhou.aliyuncs.com/member/"+picture);
        map.put(Constants.DATA, redPacket);
        return map;
    }

    /**
     * 获取抢红包跳转的页面
     * @param id
     * @return
     */
    public Map<String, Object> getJump(int id){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            int jump = redPacketService.getJump(id);
            String account = redPacketService.getAccount(id);
            switch (jump){
                case 1:
                    map.put("haploidAmount",null);
                    map.put("planNo",null);
                    break;
                case 2: //跟单详情
                    Integer planNo = redPacketService.getFollow(account);
                    if (planNo==null){
                        map.put("planNo",null);
                        map.put("haploidAmount",null);
                    }else {
                        map.put("planNo",planNo);
                        int amount = redPacketService.getAmount(planNo);
                        int multiple = redPacketService.getMultiple(planNo);
                        int type = redPacketService.getType(account);
                        if (type==1) {
                            int CyMultiple = redPacketService.getCyMultiple(account);
                            map.put("haploidAmount", amount/multiple/CyMultiple);
                        }else{
                            map.put("haploidAmount", amount/multiple);
                        }
                    }
                    break;
                case 3: //红单详情
                    Integer planNo2 = redPacketService.getRed(account);
                    if(planNo2==null){
                        map.put("planNo",null);
                        map.put("haploidAmount",null);
                    }else {
                        map.put("planNo",planNo2);
                        map.put("haploidAmount",null);
                    }
                    break;
            }
            map.put("jump",jump);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取跳转页面失败");
            return map;
        }
    }

    /**
     * 抢红包接口
     * @return
     */
    public Map<String, Object> grabRedRacket(int id, String account){
        Map<String,Object> map = new HashMap<String, Object>();
        RedPacket redPacket = redPacketService.getById(id);
        map = checkGrab(redPacket, account);
        if(Integer.parseInt(map.get(Constants.CODE).toString()) != Constants.SUCCESS_CODE){
            return map;
        }
        RedPacketLog redPacketLog = redPacketLogService.getByPacketId(id, account);
        if(redPacketLog != null){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_8);
            return map;
        }
        MemberWallet2DTO memberWallet2 =
                memberWalletService.getMemberWalletByAccount(account);
        if(memberWallet2 == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
            return map;
        }
        if(redPacket.getSurplusNumber() == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_3);
            return map;
        }
        if (DateUtil.isOverdue(redPacket.getCreateDatetime())){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_4);
            return map;
        }
        //剩余可抢数
        int surplusNumber = redPacket.getSurplusNumber();
        BigDecimal grabMonry = new BigDecimal(0); // 抢到的金额
        switch (redPacket.getType()){
            case 1: //拼手气
                if (redPacket.getSurplusNumber() == 1) {
                    grabMonry = redPacket.getSurplusMoney();
                    //已抢完
                    redPacket.setStatus(3);
                } else {
                    //留下足够剩余的钱
                    BigDecimal plusMoney = redPacket.getSurplusMoney().subtract(
                            new BigDecimal(0.01 * surplusNumber));
                    //随机金额
                    BigDecimal randomMoney = plusMoney.multiply(new BigDecimal(Math.random()))
                            .setScale(2, BigDecimal.ROUND_HALF_UP);
                    if (new BigDecimal(0.01).compareTo(randomMoney) > 0) {
                        grabMonry = new BigDecimal(0.01); //最低额度0.01
                    } else {
                        BigDecimal random = new BigDecimal(surplusNumber).divide(new BigDecimal(2));
                        //保留两位小数
                        grabMonry = randomMoney.divide(random, 2, BigDecimal.ROUND_HALF_UP);
                        if (new BigDecimal(0.01).compareTo(grabMonry) > 0) {
                            grabMonry = new BigDecimal(0.01); //最低额度0.01
                        }
                    }
                    redPacket.setStatus(2);
                }
                break;
            case 2: //标准
                if(redPacket.getSurplusNumber() == 1){
                    grabMonry = redPacket.getSurplusMoney();
                    //已抢完
                    redPacket.setStatus(3);
                } else {
                    grabMonry = redPacket.getSurplusMoney().divide(new BigDecimal(surplusNumber));
                    redPacket.setStatus(2);
                }
                break;
        }
        redPacketLog = RedPacketLog.builder().redpacketId(id).money(grabMonry)
                .account(account).createDatetime(new Date()).build();
        redPacketLogService.insertSelective(redPacketLog);
        redPacket.setSurplusNumber(surplusNumber - 1);
        redPacket.setSurplusMoney(redPacket.getSurplusMoney().subtract(grabMonry));
        redPacketService.updateByPrimaryKeySelective(redPacket);//扣除被抢的额度
        memberWallet2.setAbleBalance(NumberTools.round(new BigDecimal(memberWallet2.getAbleBalance()).add(grabMonry).doubleValue(),2));
        memberWallet2.setRedPacketBalance(NumberTools.round(new BigDecimal(memberWallet2.getRedPacketBalance()).add(grabMonry).doubleValue(),2));
        memberWalletService.updateMemberWallet(memberWallet2);//抢到的钱直接添加到余额
        //添加钱包流水 42抢红包
        saveLine(memberWallet2, 42, grabMonry,id);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put("grabMonry", grabMonry);
        return map;
    }

    /**
     * 抢红包记录列表
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> grabRedRacketList(int offset,int pageSize){
        Map<String,Object> map = new HashMap<String, Object>();
        List<GrabRedRacketDTO> list = redPacketLogService.getAllList(offset, pageSize);
        PageInfo<GrabRedRacketDTO> page = new PageInfo(list);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, page);
        return map;
    }

    /**
     * 红包详情
     * @param redPacketId
     * @return
     */
    public Map<String,Object> getRedPacketDetails(String account, int redPacketId) {
        Map<String, Object> map = new HashMap<String, Object>();
        RedPacketDetailsDTO redPacketDetailsDTO = redPacketService.getDetails(redPacketId);
        List<GrabRedRacketDTO> logList = redPacketDetailsDTO.getLogList();
        String fbAccount = logList.get(0).getAccount(); //发包人account
//        if(account.equals(fbAccount)){  //如果是发包人查看红包记录
            for (GrabRedRacketDTO grabRedRacketDTO:logList
                    ) {    //遍历所有抢包记录
                int id = grabRedRacketDTO.getId();
                String lyById = redPacketLogService.getLyById(id);
                grabRedRacketDTO.setLyContent(lyById);
                String grabAccount = grabRedRacketDTO.getGrabAccount();
                if(account.equals(grabAccount)){
                    grabRedRacketDTO.setIsSelf(1);
                }else {
                    grabRedRacketDTO.setIsSelf(0);
                }
                String picture = memberService.getPicture(grabAccount);
                grabRedRacketDTO.setPicture("https://qyun88.oss-cn-hangzhou.aliyuncs.com/member/"+picture);
            }
//        }else {
//            for (GrabRedRacketDTO grabRedRacketDTO:logList
//                    ) {    //遍历所有抢包记录
//                String grabAccount = grabRedRacketDTO.getGrabAccount(); //抢包人account
//                if(account.equals(grabAccount)){
//                    int id = grabRedRacketDTO.getId();
//                    String lyById = redPacketLogService.getLyById(id);
//                    grabRedRacketDTO.setLyContent(lyById);
//                }
//            }
//        }
        MemberFollowMapping2 memberFollowMapping = memberFollowMappingService.getByFansAccount(
                redPacketDetailsDTO.getAccount(), account);
        boolean isFollow = true;
        if(memberFollowMapping == null){
            isFollow =false;
        } else if(memberFollowMapping.getIsCancel()){
            isFollow =false;
        }
        redPacketDetailsDTO.setFollow(isFollow);
        int count = redPacketService.getCount(redPacketId);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put("count",count);
        map.put(Constants.DATA, redPacketDetailsDTO);
        return map;
    }

    /**
     * 我抢到的红包记录
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> MygrabRedRacketList(String account, int offset, int pageSize) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<GrabRedRacketDTO> list = redPacketLogService.getMyList(account, offset, pageSize);
        for (GrabRedRacketDTO grabRedRacketDTO:list
             ) {
            String picture = grabRedRacketDTO.getPicture();
            grabRedRacketDTO.setPicture("https://qyun88.oss-cn-hangzhou.aliyuncs.com/member/"+picture);
        }
        MyTotalRedRacketDTO totalRedRacketDTO = redPacketLogService.getTotalMoney(account);
        PageInfo<GrabRedRacketDTO> page = new PageInfo(list);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, page);
        map.put("total", totalRedRacketDTO);
        return map;
    }

    /**
     * 发出的红包列表
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> awardRedPacketList(String account, int offset, int pageSize) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<RedPacketDTO> list = redPacketService.getMyList(account, offset, pageSize);
        MyTotalRedRacketDTO totalRedRacketDTO = redPacketService.getTotalMoney(account);
        PageInfo<GrabRedRacketDTO> page = new PageInfo(list);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, page);
        map.put("total", totalRedRacketDTO);
        return map;
    }

    /**
     * 获取用户当前红包
     * @param account
     * @return
     */
    public Map<String, Object> getRedPacketNow(String account) {
        Map<String,Object> map = new HashMap<String, Object>();
        RedPacketDTO redPacketDTO = redPacketService.getNowByAccount(account);
        if(redPacketDTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_910);
            map.put(Constants.DATA, redPacketDTO);
            return map;
        }
        if (DateUtil.isOverdue(redPacketDTO.getCreateDatetime())){
            redPacketDTO.setStatus(4);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, redPacketDTO);
        return map;
    }

    /**
     * 添加钱包流水
     * @param memberWallet2
     * @param transType
     * @param money
     */
    private void saveLine(MemberWallet2DTO memberWallet2, int transType, BigDecimal money,int id) {
        Member2DTO member = memberService.getMemberById(memberWallet2.getMemberId());
        MemberWalletLine2 memberWalletLine2 = MemberWalletLine2.builder()
                .memberId(memberWallet2.getMemberId()).account(memberWallet2.getAccount())
                .amount(money.doubleValue()).freezeBalance(NumberTools.round(memberWallet2.getFreezeBalance(),2))
                .heapBalance(NumberTools.round(memberWallet2.getHeapBalance(),2))
                .ableBalance(NumberTools.round(memberWallet2.getAbleBalance(),2)).lotteryType(-1)
                .createDateTime(new Date()).planNo(id).status(0)
                .walletType(1).sourceId(member.getSourceId()).transType(transType).build();
        switch (transType){
            case 41:
                memberWalletLine2.setRemark("发红包");
                break;
            case 42:
                memberWalletLine2.setRemark("抢红包");
                break;
            case 43:
                memberWalletLine2.setRemark("红包退还");
                break;
        }
        memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
        memberWalletLineService.insertSelective(memberWalletLine2);
    }

    /**
     * 校验可抢性
     * @param redPacket
     * @param account
     * @return
     */
    private Map<String,Object> checkGrab(RedPacket redPacket, String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (redPacket == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_5);
            return map;
        }
        if (redPacket.getAccount().equals(account)) {
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_7);
            return map;
        }
        if (redPacket.getStatus() == 4){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_4);
            return map;
        }
        if(redPacket.getSurplusNumber() == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_3);
            return map;
        }
        if (redPacket.getApply() == 1) { // 适用为粉丝
            MemberFollowMapping2 memberFollowMapping = memberFollowMappingService
                    .getByFansAccount(redPacket.getAccount(), account);
            if (memberFollowMapping == null || memberFollowMapping.getIsCancel()) {
                map.put(Constants.CODE, Constants.ERROR_CODE_9);
                map.put(Constants.MSG, Constants.ERROR_MSG_9_6);
                return map;
            }
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        return map;
    }
}
