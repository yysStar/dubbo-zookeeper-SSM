package com.qiyun.serviceImpl;


import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.MemberCloudsLineMapper;
import com.qiyun.mapper2.MemberCloudsMapper;
import com.qiyun.mapper2.MemberRewardMappingMapper;
import com.qiyun.model2.*;
import com.qiyun.service.RewardService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.qiyun.type.TransType.REWARD;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.qiyun.type.TransType.BEREWARD;

//import static com.qiyun.util.TransType.BEREWARD;
//import static com.qiyun.util.TransType.REWARD;

@Service("RewardService")
public class RewardServiceImpl implements RewardService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(LotteryTermServiceImpl.class);

    @Resource
    private Member2Mapper member2Mapper;  //用户表mapper

    @Resource
    private MemberCloudsMapper memberCloudsMapper;  //云朵表mapper

    @Resource
    private MemberCloudsLineMapper memberCloudsLineMapper;  //云朵流水表mapper

    @Resource
    private MemberRewardMappingMapper memberRewardMappingMapper;    //打赏云朵中间表mapper

    /**
     * 获取打赏者的列表
     * @param beRewarderId 被打赏人的账户
     * @return 打赏列表
     */
    public List<MemberRewardMapping> getRewarder(String beRewarderId) {

        List<MemberRewardMapping> memberRewardMappings = memberRewardMappingMapper.selectByBeRewarderAccount(beRewarderId);
        return memberRewardMappings;
    }
    /**
     * 点击打赏时调用的方法
     * @param cloud 打赏云朵的数量
     * @param beRewarderId  被打赏人的账户
     * @param RewarderId    打赏人的账户
     * @return  打赏的结果
     */
    public Integer Reward(int cloud, String beRewarderId, String RewarderId) {
        try {
            //查询云朵表中被打赏人的信息
            MemberCloudsExample selectByExample = new MemberCloudsExample();
            selectByExample.createCriteria().andAccountEqualTo(beRewarderId);
            final List<MemberClouds> memberClouds1 = memberCloudsMapper.selectByExample(selectByExample);
            //查询云朵表中打赏人的信息
            MemberCloudsExample selectByExample2 = new MemberCloudsExample();
            selectByExample2.createCriteria().andAccountEqualTo(RewarderId);
            final List<MemberClouds> memberClouds2 = memberCloudsMapper.selectByExample(selectByExample2);
            if(memberClouds2==null||memberClouds2.size()==0){    //云朵表中没有打赏者记录
                return -1;
            }
            int RewarderClouds = memberClouds2.get(0).getCloudsAbleBalance();   //获取打赏者云朵的余额
            if(RewarderClouds<cloud){   //余额不足
                return -1;
            }
            if(memberClouds1==null||memberClouds1.size()==0){    //如果云朵表中没有被打赏人的数据
                Member2Example M2Q = new Member2Example();
                M2Q.createCriteria().andAccountEqualTo(beRewarderId);
                List<Member2> member2s = member2Mapper.selectByExample(M2Q);
                MemberClouds newBeRewarder = new MemberClouds();
//                newBeRewarder.setId(member2s.get(0).getId()); //被打赏者id
                newBeRewarder.setAccount(beRewarderId); //被打赏者账户
                newBeRewarder.setFreezeBalance(0); //被打赏者冻结云朵
                newBeRewarder.setTakeCashQuota(0.0); //被打赏者可提现云朵
                newBeRewarder.setHeapBalance(0); //被打赏者历史消费
                newBeRewarder.setCloudsAbleBalance(0);  //重新设置可用云朵余额
                memberCloudsMapper.insert(newBeRewarder);
            }

            //修改数据库的余额信息
            MemberClouds beRewarder = new MemberClouds();
            beRewarder.setId(memberClouds1.get(0).getId()); //被打赏者id
            beRewarder.setAccount(memberClouds1.get(0).getAccount()); //被打赏者账户
            beRewarder.setFreezeBalance(memberClouds1.get(0).getFreezeBalance()); //被打赏者冻结云朵
            beRewarder.setTakeCashQuota(memberClouds1.get(0).getTakeCashQuota()+cloud); //被打赏者可提现云朵
            beRewarder.setHeapBalance(memberClouds1.get(0).getHeapBalance()); //被打赏者历史消费
            beRewarder.setCloudsAbleBalance(memberClouds1.get(0).getCloudsAbleBalance()+cloud);  //设置可用云朵余额
            memberCloudsMapper.updateByPrimaryKey(beRewarder);
            MemberClouds Rewarder = new MemberClouds();
            Rewarder.setId(memberClouds2.get(0).getId()); //打赏者id
            Rewarder.setAccount(memberClouds2.get(0).getAccount()); //打赏者账户
            Rewarder.setFreezeBalance(memberClouds2.get(0).getFreezeBalance()); //打赏者冻结云朵
            //如果当打赏者的余额减去打赏的云朵后小于可提现的金额时,提现金额随之变化
            if(memberClouds2.get(0).getCloudsAbleBalance()-cloud<memberClouds2.get(0).getTakeCashQuota()){
                Rewarder.setTakeCashQuota(memberClouds2.get(0).getCloudsAbleBalance()-cloud*1.0); //打赏者可提现云朵
            }else{
                Rewarder.setTakeCashQuota(memberClouds2.get(0).getTakeCashQuota());
            }
            Rewarder.setHeapBalance(memberClouds2.get(0).getHeapBalance()+cloud); //打赏者历史消费
            Rewarder.setCloudsAbleBalance(memberClouds2.get(0).getCloudsAbleBalance()-cloud); //重新设置可用云朵余额
            memberCloudsMapper.updateByPrimaryKey(Rewarder);
            //生成被打赏者流水
            MemberCloudsLine memberCloudsLine1 = new MemberCloudsLine();
            int idByAccount = memberCloudsLineMapper.getIdByAccount(beRewarderId);
            memberCloudsLine1.setAccount(beRewarderId);
            memberCloudsLine1.setClouds(cloud);
            memberCloudsLine1.setTransType(BEREWARD);  //52:打赏收入
            memberCloudsLine1.setMemberId(idByAccount);//设置用户ID
            memberCloudsLine1.setCreateDateTime(new Date());
            memberCloudsLine1.setAbleBalance(memberClouds1.get(0).getCloudsAbleBalance()+cloud);
            memberCloudsLine1.setFreezeBalance(memberClouds1.get(0).getFreezeBalance());
            memberCloudsLine1.setHeapBalance(memberClouds1.get(0).getHeapBalance());
            memberCloudsLine1.setRemark("打赏收入");
            memberCloudsLineMapper.insert(memberCloudsLine1);
            //生成打赏者流水
            MemberCloudsLine memberCloudsLine2 = new MemberCloudsLine();
            int idByAccount2 = memberCloudsLineMapper.getIdByAccount(RewarderId);
            memberCloudsLine2.setAccount(RewarderId);
            memberCloudsLine2.setClouds(cloud);
            memberCloudsLine2.setTransType(REWARD);  //51:打赏支出
            memberCloudsLine2.setMemberId(idByAccount2);
            memberCloudsLine2.setCreateDateTime(new Date());
            memberCloudsLine2.setAbleBalance(memberClouds2.get(0).getCloudsAbleBalance()-cloud);
            memberCloudsLine2.setFreezeBalance(memberClouds2.get(0).getFreezeBalance());
            memberCloudsLine2.setHeapBalance(memberClouds2.get(0).getHeapBalance()+cloud);
            memberCloudsLine2.setRemark("打赏支出");
            memberCloudsLineMapper.insert(memberCloudsLine2);
            //在打赏中间表生成记录
            Member2Example selectByExample3 = new Member2Example();
            selectByExample3.createCriteria().andAccountEqualTo(RewarderId);
            final List<Member2> member2s = member2Mapper.selectByExample(selectByExample3);
            final String picture = member2s.get(0).getPicture();    //获取打赏人的头像地址

            MemberRewardMapping memberRewardMapping = new MemberRewardMapping(); //打赏参数封装
            memberRewardMapping.setRewarder(RewarderId);        //记录打赏人的账户
            memberRewardMapping.setBeRewarder(beRewarderId);    //记录被打赏人的账户
            memberRewardMapping.setPicture(picture);    //将打赏人的头像放入打赏中间表
            //memberRewardMapping.setCloudNum(cloud);     //记录打赏云朵数量
            memberRewardMapping.setRewardDatetime(new Date());  //记录打赏时间


            MemberRewardMappingExample CX = new MemberRewardMappingExample();
            CX.createCriteria().andRewarderEqualTo(RewarderId).andBeRewarderEqualTo(beRewarderId);
            List<MemberRewardMapping> CXJG= memberRewardMappingMapper.selectByExample(CX);
            //查询之前是否有相同的打赏被打赏人的记录
            if (CXJG==null||CXJG.size()==0){
                memberRewardMapping.setCloudNum(cloud);     //记录打赏云朵数量
                int i = memberRewardMappingMapper.insert(memberRewardMapping);  //插入打赏记录
                //if(i!=1) return -2;
            }else{
                memberRewardMapping.setId(CXJG.get(0).getId()); //设置ID为原先的ID
                memberRewardMapping.setCloudNum(cloud+CXJG.get(0).getCloudNum());     //记录打赏云朵数量
                int i = memberRewardMappingMapper.updateByPrimaryKey(memberRewardMapping);//修改之前的打赏记录
                //if(i!=1) return -2;
            }
            return  1;  //打赏成功
        }catch (Exception e){
            return -2;  //打赏未知错误
        }
    }
}
