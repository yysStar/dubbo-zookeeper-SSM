package com.qiyun.serviceImpl;

import com.qiyun.mapper2.LotteryTypeProps2Mapper;
import com.qiyun.model.LotteryTypeProps;
import com.qiyun.model2.LotteryTypeProps2;
import com.qiyun.service.LotteryTypePropsService;
import com.qiyun.status.CommonStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("lotteryTypePropsService")
public class LotteryTypePropsServiceImpl implements LotteryTypePropsService {
    @Resource
    private LotteryTypeProps2Mapper lotteryTypeProps2Mapper;

    public LotteryTypeProps findById(int lotteryType) {
        LotteryTypeProps2 lotteryTypeProps2 = lotteryTypeProps2Mapper.selectByPrimaryKey(lotteryType);
        LotteryTypeProps lotteryTypeProps = changeLotteryTypeProps(lotteryTypeProps2);
        return lotteryTypeProps;
    }

    /**
     * lotteryTypeProps bean转换
     * @param lotteryTypeProps2
     * @return
     */
    private LotteryTypeProps changeLotteryTypeProps(LotteryTypeProps2 lotteryTypeProps2) {
        LotteryTypeProps lotteryTypeProps = new LotteryTypeProps();
        lotteryTypeProps.setBuyLink(lotteryTypeProps2.getBuyLink());
        lotteryTypeProps.setCmdLottery(lotteryTypeProps2.getCmdLottery());
        lotteryTypeProps.setCountInBatch(lotteryTypeProps2.getCountInBatch());
        lotteryTypeProps.setDefaultSort(lotteryTypeProps2.getDefaultSort());
        lotteryTypeProps.setDescribe(lotteryTypeProps2.getDescribe());
        lotteryTypeProps.setDiscount(lotteryTypeProps2.getDiscount());
        lotteryTypeProps.setDsAheadTime(lotteryTypeProps2.getDsAheadTime());
        lotteryTypeProps.setFsAheadTime(lotteryTypeProps2.getFsAheadTime());
        lotteryTypeProps.setIsHotSales(lotteryTypeProps2.getIsHotSales());
        lotteryTypeProps.setLotMgrIsAble(CommonStatus.getItem(lotteryTypeProps2.getLotMgrIsAble()));
        lotteryTypeProps.setLotteryGuideImg(lotteryTypeProps2.getLotteryGuideImg());
        lotteryTypeProps.setLotteryType(lotteryTypeProps2.getLotteryType());
        lotteryTypeProps.setMaxWaitTime(lotteryTypeProps2.getMaxWaitTime());
        lotteryTypeProps.setOnImp(lotteryTypeProps2.getOnImp());
        lotteryTypeProps.setPresentation(lotteryTypeProps2.getPresentation());
        lotteryTypeProps.setPrice(lotteryTypeProps2.getPrice());
        lotteryTypeProps.setPromotion(lotteryTypeProps2.getPromotion());
        lotteryTypeProps.setStopCause(lotteryTypeProps2.getStopCause());
        lotteryTypeProps.setStopImp(lotteryTypeProps2.getStopImp());
        lotteryTypeProps.setTotal(lotteryTypeProps2.getTotal());
        return lotteryTypeProps;
    }

    public LotteryTypeProps findAndCommendByLotType(int value) {
        return null;
    }
}
