package com.qiyun.serviceImpl;

import com.qiyun.common.CommonStatus;
import com.qiyun.buildTerm.LotteryTermBuilderFactory;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.mapper2.LotteryTerm2Mapper;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.LotteryTermStatus;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.model2.LotteryTerm2Query;
import com.qiyun.service.LotteryTermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("lotteryTermService")
public class LotteryTermServiceImpl implements LotteryTermService {
    @Resource
    private LotteryTerm2Mapper lotteryTerm2Mapper;

    public LotteryTerm2 getByLotteryAndTerm(int lotteryType, String term) {
        LotteryTerm2Query lotteryTerm2Query = new LotteryTerm2Query();
        LotteryTerm2Query.Criteria criteria = lotteryTerm2Query.createCriteria();
        criteria.andLotteryTypeEqualTo(lotteryType);
        criteria.andTermEqualTo(term);
        List<LotteryTerm2> lotteryTerm2s = lotteryTerm2Mapper.selectByExample(lotteryTerm2Query);
        if (lotteryTerm2s==null || lotteryTerm2s.size()<=0){
            return null;
        }
        return lotteryTerm2s.get(0);
    }

    public LotteryTerm2 getNumberTerm(int i) {
        LotteryTerm2Query lotteryTerm2Query = new LotteryTerm2Query();
        LotteryTerm2Query.Criteria criteria = lotteryTerm2Query.createCriteria();
        criteria.andIsCurrentTermEqualTo(0);
        criteria.andStatusEqualTo(2);
        List<LotteryTerm2> lotteryTerm2s = lotteryTerm2Mapper.selectByExampleWithBLOBs(lotteryTerm2Query);
        if (lotteryTerm2s==null || lotteryTerm2s.size()<=0){
            return null;
        }
        return lotteryTerm2s.get(0);
    }
	
    public LotteryTerm findOpenResultByLotteryType(LotteryType lotType) {
        return null;
    }

    public List<LotteryTerm> findOpennendTermByLotteryType(LotteryType pl5, int i, int i1) {
        return null;
    }

    public LotteryTerm findCurrentTermByLotteryType(LotteryType type) {
        return null;
	}
	
    public LotteryTerm2 findCurrentTermByLotteryType(int type) {
        LotteryTerm2Query lotteryTerm2Query = new LotteryTerm2Query();
        LotteryTerm2Query.Criteria criteria = lotteryTerm2Query.createCriteria();
        criteria.andLotteryTypeEqualTo(type);
        criteria.andIsCurrentTermEqualTo(0);
        lotteryTerm2Query.setOrderByClause("term desc");
        List<LotteryTerm2> lotteryTerm2s = lotteryTerm2Mapper.selectByExample(lotteryTerm2Query);
        if (lotteryTerm2s==null || lotteryTerm2s.size()<=0){
            return null;
        }
        return lotteryTerm2s.get(0);
    }

    public List<LotteryTerm2> getFootBallTerm() {
        return lotteryTerm2Mapper.getFootBallTerm();
    }

    public List<LotteryTerm2> getBasketTerm() {
        return lotteryTerm2Mapper.getBasketTerm();
    }

    public LotteryTerm findOpenningTermByLotteryType(LotteryType lotteryType) {
        return null;
    }

    public LotteryTerm findByLotteryTypeAndTerm(LotteryType lotteryType, String term) {
        LotteryTerm2 lotteryTerm2 = lotteryTerm2Mapper.selectByLotteryTypeAndTerm(lotteryType.getValue(), term);
        return term2ToTerm(lotteryTerm2);
    }

    public void attachDirty(LotteryTerm lotteryTerm) {
        LotteryTerm2 term2 = termToTerm2(lotteryTerm);
        lotteryTerm2Mapper.updateByPrimaryKeySelective(term2);
    }

    public LotteryTerm findById(Integer id) {
        LotteryTerm2 term2 = lotteryTerm2Mapper.selectByPrimaryKey(id);
        return term2ToTerm(term2);
    }

    public void initCurrentFlag(LotteryType lotteryType) {

    }

    public LotteryTerm findCurrentTermByDate(LotteryType lotteryType, Date time) {
        List<LotteryTerm2> term2 = lotteryTerm2Mapper.selectByLotteryTypeAndDate(lotteryType.getValue(), time);
        if(term2.size() > 0) {
            return term2ToTerm(term2.get(0));
        } else {
            return null;
        }
    }

    public List<LotteryTerm> findOverdueByDateAndUnReturnPrizeTerm(LotteryType lotteryType) {
        List<LotteryTerm> terms = new ArrayList<LotteryTerm>();
        int t = 30 ; //默认的补漏的时间跨度
        if(LotteryType.GPList.contains(lotteryType)) {
            t = 1;//抓取的彩种修复历史开奖号码再调整此参数
        }
        //计算开始结束时间 , 优化查询范围，只查找最近t天的已开奖彩期
        Calendar ca = Calendar.getInstance();
        Date endTime = ca.getTime();
        ca.set(Calendar.HOUR, 0);
        ca.add(Calendar.DAY_OF_MONTH, -t);
        Date startTime = ca.getTime();
        List<LotteryTerm2> term2s = lotteryTerm2Mapper.selectOverdueByDate(startTime, endTime, lotteryType.getValue());
        if(term2s.size() >0 ){
            for(LotteryTerm2 term2 : term2s){
                terms.add(term2ToTerm(term2));
            }
        }
        return terms;
    }

    public List findAfterByLotteryTypeAndTerm(LotteryType lotteryType, String term, int chaseCount) {
        List list = new ArrayList();
        if(chaseCount != -1){

        } else if(lotteryType.getValue() > 0){
        }
        return list;
    }

    public LotteryTerm findNextByLotteryTypeAndTerm(LotteryType lotteryType, String term) {
        LotteryTerm2 term2 = lotteryTerm2Mapper.selectByLotteryTypeAndTerm(lotteryType.getValue(), term);
        return term2ToTerm(term2);
	}
	
    public LotteryTerm2 findByLotteryTypeAndTerm(LotteryType lotteryTypeIn, Integer buildCount) {
        LotteryTerm2Query lotteryTerm2Query = new LotteryTerm2Query();
        lotteryTerm2Query.setOrderByClause("term desc");
        LotteryTerm2Query.Criteria criteria = lotteryTerm2Query.createCriteria();

        if (lotteryTypeIn.getValue() >= 0) {
            criteria.andLotteryTypeEqualTo(lotteryTypeIn.getValue());
        }
        criteria.andTermEqualTo(buildCount+"");

        List<LotteryTerm2> lotteryTerm2s = lotteryTerm2Mapper.selectByExample(lotteryTerm2Query);
        if (lotteryTerm2s != null && lotteryTerm2s.size()>0){
            return lotteryTerm2s.get(0);
        }
        return null;
    }

    public void buildTerm(Integer lotteryType, int buildCount) {
        LotteryTerm2Query lotteryTerm2Query = new LotteryTerm2Query();
        lotteryTerm2Query.setOrderByClause("term desc");
        LotteryTerm2Query.Criteria criteria = lotteryTerm2Query.createCriteria();
        criteria.andLotteryTypeEqualTo(lotteryType);
        List<LotteryTerm2> lotteryTerm2s = lotteryTerm2Mapper.selectByExample(lotteryTerm2Query);
        LotteryTerm2 term = lotteryTerm2s.get(0);
        if (term == null) {
            return;
        }
        List<LotteryTerm2> retList = LotteryTermBuilderFactory.getNextTermList(lotteryType, term.getTerm(), term.getOpenDateTime(), buildCount);

        for (int i = 0; i < retList.size(); i++) {
            LotteryTerm2 lotteryTerm = retList.get(i);
            //判断该彩种网站停开售状态
            lotteryTerm.setIsAble(term.getIsAble());
            //判断该彩种彩票大管家停开售状态
            lotteryTerm.setLotMgrIsAble(term.getLotMgrIsAble());
            this.lotteryTerm2Mapper.insertSelective(lotteryTerm);
        }
    }

    public List<LotteryTerm2> findTerm(Integer lotteryTypeValue, String term) {
        LotteryTerm2Query lotteryTerm2Query = new LotteryTerm2Query();
        LotteryTerm2Query.Criteria criteria = lotteryTerm2Query.createCriteria();
        criteria.andLotteryTypeEqualTo(lotteryTypeValue);
        if (term!=null&&!"".equals(term)){
            criteria.andTermEqualTo(term);
        }

        return lotteryTerm2Mapper.selectByExample(lotteryTerm2Query);
    }

    public int updateTerm(LotteryTerm2 lotteryTerm2) {
        return lotteryTerm2Mapper.updateByPrimaryKey(lotteryTerm2);
    }

    private LotteryTerm term2ToTerm(LotteryTerm2 lotteryTerm2) {
        LotteryTerm term = new LotteryTerm();
        term.setAwardPool(lotteryTerm2.getAwardPool());
        term.setEndDateTime(lotteryTerm2.getEndDateTime());
        term.setId(lotteryTerm2.getId());
        term.setIsAble(CommonStatus.getItem(lotteryTerm2.getIsAble()));
//        term.setIsBooking(CommonStatus.getItem(lotteryTerm2.getIsBooking()));
        term.setIsCurrentTerm(CommonStatus.getItem(lotteryTerm2.getIsCurrentTerm()));
        term.setLotMgrIsAble(CommonStatus.getItem(lotteryTerm2.getLotMgrIsAble()));
        term.setLotteryType(LotteryType.getItem(lotteryTerm2.getLotteryType()));
        term.setOpenDateTime(lotteryTerm2.getOpenDateTime());
        term.setOutTerm(lotteryTerm2.getOutTerm());
        term.setResult(lotteryTerm2.getResult());
        term.setResultDetail(lotteryTerm2.getResultDetail());
        term.setStartDateTime(lotteryTerm2.getStartDateTime());
        term.setStatus(LotteryTermStatus.getItem(lotteryTerm2.getStatus()));
        term.setTerm(lotteryTerm2.getTerm());
        term.setTerminalEndDateTime(lotteryTerm2.getTerminalEndDateTime());
        term.setTestMachineCode(lotteryTerm2.getTestMachineCode());
        term.setTotalAmount(lotteryTerm2.getTotalAmount());
        return term;
    }

    private LotteryTerm2 termToTerm2(LotteryTerm lotteryTerm) {
        LotteryTerm2 term2 = LotteryTerm2.builder().awardPool(lotteryTerm.getAwardPool())
                .endDateTime(lotteryTerm.getEndDateTime()).id(lotteryTerm.getId())
                .isAble(lotteryTerm.getIsAble().getValue()).isCurrentTerm(lotteryTerm.getIsCurrentTerm().getValue())
                .lotMgrIsAble(lotteryTerm.getLotMgrIsAble().getValue()).openDateTime(lotteryTerm.getOpenDateTime())
                .lotteryType(lotteryTerm.getLotteryType().getValue()).outTerm(lotteryTerm.getOutTerm())
                .result(lotteryTerm.getResult()).resultDetail(lotteryTerm.getResultDetail())
                .startDateTime(lotteryTerm.getStartDateTime()).status(lotteryTerm.getStatus().getValue())
                .term(lotteryTerm.getTerm()).terminalEndDateTime(lotteryTerm.getTerminalEndDateTime())
                .testMachineCode(lotteryTerm.getTestMachineCode()).totalAmount(lotteryTerm.getTotalAmount()).build();
        return term2;
    }

    public void updateTermIsAbleForFootBall(int status) {
        lotteryTerm2Mapper.updateTermIsAbleForFootBall(status);
    }

    public void updateTermIsAbleForBasketBall(Integer status) {
        lotteryTerm2Mapper.updateTermIsAbleForBasketBall(status);
    }
}
