package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.ChampionPlanDTO;
import com.qiyun.dto.ChampionPlanDetailsDTO;
import com.qiyun.dto.ChampionPlanMatchDTO;
import com.qiyun.mapper2.*;
import com.qiyun.model2.*;
import com.qiyun.service.ChampionPlanService;
import com.qiyun.utils.DbDataVerify;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("championPlanService")
public class ChampionPlanServiceImpl implements ChampionPlanService {
    @Resource
    private ChampionPlanMapper championPlanMapper;
    @Resource
    private ChampionPlanMatchMapper championPlanMatchMapper;
    @Resource
    private MemberWallet2Mapper memberWallet2Mapper;
    @Resource
    private Member2Mapper member2Mapper;
    @Resource
    private MemberWalletLine2Mapper memberWalletLine2Mapper;

    public int insertSelective(ChampionPlan championPlan){
        championPlanMapper.insertSelective(championPlan);
        return championPlan.getId();
    }

    public int update(ChampionPlan plan) {
        return championPlanMapper.updateByPrimaryKeySelective(plan);
    }

    /**
     * 获取所有出票中的订单
     * @return
     */
    public List<ChampionPlan> getTicketIngList() {
        return championPlanMapper.selectTicketIngList();
    }

    public ChampionPlan getByOrderNo(String orderNo) {
        return championPlanMapper.selectByOrderNo(orderNo);
    }

    public List<ChampionPlanDTO> getListByAccount(String account, int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        List<ChampionPlanDTO> list = championPlanMapper.selectByAccount(account);
        for(ChampionPlanDTO plan : list){
            if(plan.getType().intValue() == 1){
                plan.setPlanMatchList(championPlanMatchMapper.selectMatchByPlanId(plan.getId()));
            }else{
                plan.setPlanMatchList(championPlanMatchMapper.selectMatchUpByPlanId(plan.getId()));
            }
        }
        return list;
    }

    public ChampionPlanDetailsDTO getDetailsById(int id) {
        ChampionPlanDetailsDTO detailsDTO = championPlanMapper.selectDetailsById(id);
        if(detailsDTO.getType().intValue() == 1){
            detailsDTO.setPlanMatchList(championPlanMatchMapper.selectMatchByPlanId(detailsDTO.getId()));
        }else{
            detailsDTO.setPlanMatchList(championPlanMatchMapper.selectMatchUpByPlanId(detailsDTO.getId()));
        }
        return detailsDTO;
    }

    public List<ChampionPlanDTO> getBingoListByAccount(String account, int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        List<ChampionPlanDTO> list = championPlanMapper.selectBingoByAccount(account);
        for(ChampionPlanDTO plan : list){
            if(plan.getType().intValue() == 1){
                plan.setPlanMatchList(championPlanMatchMapper.selectMatchByPlanId(plan.getId()));
            }else{
                plan.setPlanMatchList(championPlanMatchMapper.selectMatchUpByPlanId(plan.getId()));
            }
        }
        return list;
    }

    /**
     * 修改开奖状态
     * @param planId
     * @return
     */
    public int updateFailByTeamId(Integer planId) {
        ChampionPlan championPlan = championPlanMapper.selectByPrimaryKey(planId);
        List<ChampionPlanMatchDTO> list = new ArrayList<ChampionPlanMatchDTO>();
        if(championPlan.getType().intValue() == 1){
            list = championPlanMatchMapper.selectMatchByPlanId(championPlan.getId());
        }else{
            list = championPlanMatchMapper.selectMatchUpByPlanId(championPlan.getId());
        }
        if(list.size() == 1){ // 如果所选赛事只有1场直接置为失败
            championPlan.setBingoStatus(2);
            championPlan.setBingoMoney(new BigDecimal(0));
            championPlanMapper.updateByPrimaryKeySelective(championPlan);
            return 1;
        }
        int i = 0;
        for(ChampionPlanMatchDTO planMatchDTO : list){
            if(planMatchDTO.getStatus() != 2){
                i = 1;
            }
        }
        if(i == 0){ //所选的所有赛事都为失败
            championPlan.setBingoStatus(2);
            championPlan.setBingoMoney(new BigDecimal(0));
            championPlanMapper.updateByPrimaryKeySelective(championPlan);
            return 1;
        }
        return 0;
    }

    /**
     * 修改开奖状态
     * @param planMatch
     * @return
     */
    public int updateSuccessByTeamId(ChampionPlanMatch planMatch) {
        ChampionPlan championPlan = championPlanMapper.selectByPrimaryKey(planMatch.getPlanId());
        if(championPlan.getBingoStatus() == 0) { //只要有一场比赛中奖，订单就为中奖状态
            championPlan.setBingoStatus(1);
            championPlan.setBingoMoney(new BigDecimal(2).multiply(planMatch.getSp())
                    .multiply(new BigDecimal(championPlan.getMultiple())));
            championPlanMapper.updateByPrimaryKeySelective(championPlan);
            Member2 member = member2Mapper.selectByAccount(championPlan.getAccount());
            MemberWallet2 memberWallet2 = memberWallet2Mapper.selectByMemberId(member.getId());
            //增加可用余额
            memberWallet2.setAbleBalance(new BigDecimal(memberWallet2.getAbleBalance())
                    .add(championPlan.getBingoMoney()).doubleValue());
            //增加可提现金额
            memberWallet2.setTakeCashQuota(new BigDecimal(memberWallet2.getTakeCashQuota())
                    .add(championPlan.getBingoMoney()).doubleValue());
            memberWallet2Mapper.updateByPrimaryKeySelective(memberWallet2);
            //添加钱包流水
            MemberWalletLine2 line = MemberWalletLine2.builder().planNo(championPlan.getId())
                    .account(championPlan.getAccount()).memberId(memberWallet2.getMemberId()).transType(35)
                    .walletType(1).amount(championPlan.getBingoMoney().doubleValue()).heapBalance(memberWallet2.getHeapBalance())
                    .freezeBalance(memberWallet2.getFreezeBalance()).sourceId(member.getSourceId())
                    .ableBalance(memberWallet2.getAbleBalance()).prizeBalance(memberWallet2.getPrizeBalance())
                    .status(0).remark("冠亚军返奖").createDateTime(new Date())
                    .build();
            if(championPlan.getType() == 1){
                line.setLotteryType(46);
            } else {
                line.setLotteryType(47);
            }
            line.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(line));
            memberWalletLine2Mapper.insertSelective(line);
            //添加
            return 1;
        }
        return 0;
    }

    public List<ChampionPlanDetailsDTO> getAllList(int offset, int pageSize, String account,
                                                   Integer planId, Date startTime, Date endTime) {
        PageHelper.startPage(offset, pageSize);
        List<ChampionPlanDetailsDTO> list = championPlanMapper.selectAllList(account, planId, startTime , endTime);
        for(ChampionPlanDTO plan : list){
            if(plan.getType().intValue() == 1){
                plan.setPlanMatchList(championPlanMatchMapper.selectMatchByPlanId(plan.getId()));
            }else{
                plan.setPlanMatchList(championPlanMatchMapper.selectMatchUpByPlanId(plan.getId()));
            }
        }
        return list;
    }
}
