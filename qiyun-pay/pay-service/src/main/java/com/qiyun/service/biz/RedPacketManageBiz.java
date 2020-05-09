package com.qiyun.service.biz;

import com.github.pagehelper.PageInfo;
import com.qiyun.api.RedPacketManageApi;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.dto.RedPacketListDTO;
import com.qiyun.model2.RedPacket;
import com.qiyun.model2.RedPacketLog;
import com.qiyun.service.MemberService;
import com.qiyun.service.MemberWalletService;
import com.qiyun.service.RedPacketLogService;
import com.qiyun.service.RedPacketService;
import com.qiyun.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service("redPacketManageApi")
public class RedPacketManageBiz implements RedPacketManageApi {
    private static Logger logger = LoggerFactory.getLogger(RedPacketManageBiz.class);

    @Autowired
    private RedPacketService redPacketService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private RedPacketLogService redPacketLogService;
    @Autowired
    private MemberWalletService memberWalletService;

    /**
     * 发布平台红包
     * @param money
     * @param name
     * @param type
     * @param number
     * @return
     */
    public Map<String, Object> addRedRacketForPlatform(List<Integer> robotIdList, Date date,
                               BigDecimal money, String name, int type, int number, BigDecimal robotMoney) {
        Map<String,Object> map = new HashMap<String, Object>();
        if(type == 2){
            money = money.multiply(new BigDecimal(number));
        }
        //单个金额小于0.01
        if(type == 1 && money.divide(new BigDecimal(number),2,BigDecimal.ROUND_HALF_UP).compareTo(new BigDecimal(0.01)) < 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_2);
            return map;
        }
        //确认发红包账号为sj066209047
        RedPacket redPacket = RedPacket.builder().account("sj066209047").apply(2)
                .createDatetime(new Date()).money(money).name(name).type(type).number(number)
                .surplusMoney(money).surplusNumber(number).build();
//        int i = redPacketService.insertSelective(redPacket);
        if(robotIdList.size() > 0){
            redPacket.setStatus(2);
        }
        Timer timer = new Timer(true);
        timer.schedule(new RedPacketTask(redPacket, robotIdList, robotMoney, type),
                date.getTime() - System.currentTimeMillis());
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 抢红包记录列表
     *
     * @param offset
     * @param pageSize
     * @param account
     * @param startTime
     * @param endTime
     * @return
     */
    public Map<String, Object> grabRedRacketList(int offset, int pageSize, String account, String startTime, String endTime) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<RedPacketListDTO> redPacketListDTOS = memberWalletService.grabRedRacketList(offset, pageSize, account, startTime, endTime);
        PageInfo<RedPacketListDTO> redPacketListDTOPageInfo = new PageInfo<RedPacketListDTO>(redPacketListDTOS);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA,redPacketListDTOPageInfo);
        return map;
    }

    /**
     * 发红包记录列表
     *
     * @param offset
     * @param pageSize
     * @param account
     * @param startTime
     * @param endTime
     * @return
     */
    public Map<String, Object> putRedRacketList(int offset, int pageSize, String account, String startTime, String endTime) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<RedPacketListDTO> redPacketListDTOS = memberWalletService.putRedRacketList(offset, pageSize, account, startTime, endTime);
        PageInfo<RedPacketListDTO> redPacketListDTOPageInfo = new PageInfo<RedPacketListDTO>(redPacketListDTOS);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA,redPacketListDTOPageInfo);
        return map;
    }

    class RedPacketTask extends TimerTask {
        private RedPacket redPacket;

        private List<Integer> robotList;

        private BigDecimal robotMoney;

        private int type;

        public RedPacketTask(RedPacket redPacket, List<Integer> robotList, BigDecimal robotMoney, int type) {
            this.robotList = robotList;
            this.redPacket = redPacket;
            this.robotMoney = robotMoney;
            this.type = type;
        }

        @Override
        public void run() {
            int i = redPacketService.insertSelective(redPacket);
            int n = 1;
            BigDecimal surplusMonry = robotMoney;
            BigDecimal grabMonry = new BigDecimal(0); // 抢到的金额
            int s = robotList.size();
            for(int id : robotList){
                switch (type){
                    case 1: //拼手气
                        if(n == s){
                            grabMonry = surplusMonry;
                        } else {
                            //剩余数量
                            int surplusNumber = s - n + 1;
                            //留下足够剩余的钱
                            BigDecimal plusMoney = surplusMonry.subtract(
                                    new BigDecimal(0.01 * (surplusNumber)));
                            //随机金额
                            BigDecimal randomMoney = plusMoney.multiply(new BigDecimal(Math.random()))
                                    .setScale(2, BigDecimal.ROUND_HALF_UP);
                            if (new BigDecimal(0.01).compareTo(randomMoney) > 0) {
                                grabMonry = new BigDecimal(0.01); //最低额度0.01
                            } else {
                                BigDecimal random = new BigDecimal(surplusNumber).divide(new BigDecimal(2));
                                //保留两位小数
                                grabMonry = randomMoney.divide(random, 2, BigDecimal.ROUND_HALF_UP);
                            }
                            surplusMonry = surplusMonry.subtract(grabMonry);
                        }
                        break;
                    case 2: //标准
                        grabMonry = redPacket.getMoney().divide(new BigDecimal(redPacket.getNumber()));
                        break;
                }
                Member2DTO member = memberService.getMemberById(id);
                RedPacketLog redPacketLog = RedPacketLog.builder().redpacketId(i).money(grabMonry)
                        .account(member.getAccount()).createDatetime(new Date()).build();
                redPacketLogService.insertSelective(redPacketLog);
                MemberWallet2DTO memberWallet2 =
                        memberWalletService.getMemberWalletByAccount(member.getAccount());
                // 统计红包总额
                memberWallet2.setRedPacketBalance(
                        new BigDecimal(memberWallet2.getRedPacketBalance()).add(grabMonry).doubleValue());
                memberWallet2.setAbleBalance(new BigDecimal(memberWallet2.getAbleBalance()).add(grabMonry).doubleValue());
                memberWalletService.updateMemberWallet(memberWallet2);//抢到的钱直接添加到余额
                n++;
            }
            RedPacket redPacket1 = redPacketService.getById(i);
            // 扣除机器人抢的金额和数量
            redPacket1.setSurplusMoney(redPacket1.getSurplusMoney().subtract(robotMoney));
            redPacket1.setSurplusNumber(redPacket1.getSurplusNumber() - s);
            redPacketService.updateByPrimaryKeySelective(redPacket1);
        }
    }
}
