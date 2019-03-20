package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.BasketBallMatchDTO;
import com.qiyun.mapper2.DgMapper;
import com.qiyun.mapper2.SportteryBasketMatch2Mapper;
import com.qiyun.model.HTAward;
import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model2.SportteryBasketMatch2;
import com.qiyun.model2.SportteryBasketMatch2Query;
import com.qiyun.service.SportteryBasketBallMatchService;
import com.qiyun.tools.DateTools;
import com.qiyun.util.Constants;
import com.qiyun.util.DateUtil;
import com.qiyun.utils.CommonUtils;
import com.qiyun.utils.DateUtils;
import com.qiyun.utils.TimeTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SportteryBasketBallMatchServiceImpl implements SportteryBasketBallMatchService {

    @Resource
    private DgMapper dgMapper;

    @Resource
    private SportteryBasketMatch2Mapper sportteryBasketMatch2Mapper;

    public SportteryBasketMatch2 getByIntTimeAndLineId(Integer intTime, Integer lineId) {
        SportteryBasketMatch2Query sportteryBasketMatch2Query = new SportteryBasketMatch2Query();
        SportteryBasketMatch2Query.Criteria criteria = sportteryBasketMatch2Query.createCriteria();
        criteria.andInttimeEqualTo(intTime);
        criteria.andLineidEqualTo(lineId);
        List<SportteryBasketMatch2> sportteryBasketMatch2s = sportteryBasketMatch2Mapper
                .selectByExample(sportteryBasketMatch2Query);
        if (sportteryBasketMatch2s==null || sportteryBasketMatch2s.size()<=0){
            return null;
        }
        return sportteryBasketMatch2s.get(0);
    }

    public List<BasketBallMatchDTO> getBasketBallMatch(int isFocus) {
        Map<String,Object> map = new HashMap<String,Object>();

        int dealTime = dgMapper.getDealTime();

        SimpleDateFormat time=new SimpleDateFormat("yyyyMMdd");
        int timeOffset=11;
        Calendar c = Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        if(hour<timeOffset){
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_MONTH,-1);
        }
        c.set(Calendar.HOUR_OF_DAY, timeOffset);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date date=c.getTime();
        Integer intTime = Integer.parseInt(time.format(date));
        List<Map> lineIds = null;
        if (isFocus==0) {
            lineIds = sportteryBasketMatch2Mapper.getByGroupLineId(intTime);
        }else if (isFocus==1){
            //焦点赛事
            lineIds = sportteryBasketMatch2Mapper.getByGroupLineIdAndFocus(intTime);
        }
        List<BasketBallMatchDTO> list = new ArrayList<BasketBallMatchDTO>();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
        for (Map lineId : lineIds) {
            String lineIdStr = "";
            Integer lineid = (Integer) lineId.get("lineId");
            Integer inttime = (Integer) lineId.get("intTime");
            BasketBallMatchDTO basketBallMatchDTO = new BasketBallMatchDTO();
            basketBallMatchDTO.setId((Integer) lineId.get("id"));
            basketBallMatchDTO.setIntTime(inttime);
            basketBallMatchDTO.setLineId(lineid);
            basketBallMatchDTO.setMatchTime((Date) lineId.get("matchTime"));
            basketBallMatchDTO.setHomeTeam(lineId.get("homeName").toString());
            basketBallMatchDTO.setGuestTeam(lineId.get("guestName").toString());
            basketBallMatchDTO.setMatchName(lineId.get("gameName").toString());
            basketBallMatchDTO.setShowNum((Integer) lineId.get("showNum"));
//            basketBallMatchDTO.setMatchDealTime(TimeTools.getBbEndSaleTime(basketBallMatchDTO.getMatchTime(),60000*dealTime));
//            Date matchDealTime = TimeTools.getEndSaleTimeByWorldCup(basketBallMatchDTO.getMatchTime(), 60000 * dealTime, lineId.get("gameName").toString());
            Date matchDealTime = TimeTools.getBasketBallDealTime(basketBallMatchDTO.getMatchTime(), 60000 * dealTime);
            basketBallMatchDTO.setMatchDealTime(matchDealTime);
            if (matchDealTime.before(new Date())){
                continue;
            }
            Date parse = null;
            try {
                parse = dateFormater.parse(inttime + "");
                String weekOfDate = DateUtil.getWeekForDate(parse);
                if (lineid<10){
                    lineIdStr = "00"+lineid;
                }else if (lineid<100){
                    lineIdStr = "0"+lineid;
                }else{
                    lineIdStr = ""+lineid;
                }
                basketBallMatchDTO.setMatchId(weekOfDate+" "+lineIdStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            list.add(basketBallMatchDTO);
        }
        Collections.sort(list);
        for (BasketBallMatchDTO basketBallMatchDTO : list) {
            //胜分差
            List<Map> sfcs = sportteryBasketMatch2Mapper.getSfcAwardByPassModelAndIntTimeAndLineId(1,basketBallMatchDTO.getIntTime(),basketBallMatchDTO.getLineId());
            if (sfcs!=null && sfcs.size()>0) {

                basketBallMatchDTO.setAwardOfSfcForHome5(Double.parseDouble(sfcs.get(0).get("HWawardOf1to5").toString()));
                basketBallMatchDTO.setAwardOfSfcForHome10(Double.parseDouble(sfcs.get(0).get("HWawardOf6TO10").toString()));
                basketBallMatchDTO.setAwardOfSfcForHome15(Double.parseDouble(sfcs.get(0).get("HWawardOf11TO15").toString()));
                basketBallMatchDTO.setAwardOfSfcForHome20(Double.parseDouble(sfcs.get(0).get("HWawardOf16TO20").toString()));
                basketBallMatchDTO.setAwardOfSfcForHome25(Double.parseDouble(sfcs.get(0).get("HWawardOf21TO25").toString()));
                basketBallMatchDTO.setAwardOfSfcForHome26(Double.parseDouble(sfcs.get(0).get("HWawardOf26").toString()));
                basketBallMatchDTO.setAwardOfSfcForGuest5(Double.parseDouble(sfcs.get(0).get("GWawardOf1TO5").toString()));
                basketBallMatchDTO.setAwardOfSfcForGuest10(Double.parseDouble(sfcs.get(0).get("GWawardOf6TO10").toString()));
                basketBallMatchDTO.setAwardOfSfcForGuest15(Double.parseDouble(sfcs.get(0).get("GWawardOf11TO15").toString()));
                basketBallMatchDTO.setAwardOfSfcForGuest20(Double.parseDouble(sfcs.get(0).get("GWawardOf16TO20").toString()));
                basketBallMatchDTO.setAwardOfSfcForGuest25(Double.parseDouble(sfcs.get(0).get("GWawardOf21TO25").toString()));
                basketBallMatchDTO.setAwardOfSfcForGuest26(Double.parseDouble(sfcs.get(0).get("GWawardOf26").toString()));
            }
            //大小分
            List<Map> dxfAward = sportteryBasketMatch2Mapper.getBasketBallAwardByPassModelAndIntTimeAndLineIdAndPlayType(1,basketBallMatchDTO.getIntTime(),basketBallMatchDTO.getLineId(),3);
            if (dxfAward!=null && dxfAward.size()>0){
                if (dxfAward.get(0).get("baseBigOrSmall")!=null){
                    basketBallMatchDTO.setDxf(Double.parseDouble(dxfAward.get(0).get("baseBigOrSmall").toString()));
                }
                basketBallMatchDTO.setAwardOfDxfForBig(Double.parseDouble(dxfAward.get(0).get("awardOfWinOrBig").toString()));
                basketBallMatchDTO.setAwardOfDxfForSmall(Double.parseDouble(dxfAward.get(0).get("awardOfLoseOrSmall").toString()));
            }
            //让分
            List<Map> rfAward = sportteryBasketMatch2Mapper.getBasketBallAwardByPassModelAndIntTimeAndLineIdAndPlayType(1,basketBallMatchDTO.getIntTime(),basketBallMatchDTO.getLineId(),2);
            if (rfAward!=null && rfAward.size()>0){
                if (rfAward.get(0).get("handicap")!=null){
                    basketBallMatchDTO.setRf(Double.parseDouble(rfAward.get(0).get("handicap").toString()));
                }
                basketBallMatchDTO.setAwardOfRfHomeWin(Double.parseDouble(rfAward.get(0).get("awardOfWinOrBig").toString()));
                basketBallMatchDTO.setAwardOfRfGuestWin(Double.parseDouble(rfAward.get(0).get("awardOfLoseOrSmall").toString()));
            }
            //胜负
            List<Map> sfAward = sportteryBasketMatch2Mapper
                    .getBasketBallAwardByPassModelAndIntTimeAndLineIdAndPlayType(1,
                            basketBallMatchDTO.getIntTime(),basketBallMatchDTO.getLineId(),0);
            if (sfAward!=null && sfAward.size()>0){
                basketBallMatchDTO.setAwardOfHomeWin(Double.parseDouble(sfAward.get(0).get("awardOfWinOrBig").toString()));
                basketBallMatchDTO.setAwardOfGuestWin(Double.parseDouble(sfAward.get(0).get("awardOfLoseOrSmall").toString()));
            }
        }
        return list;
    }

    public List<BasketBallMatch> getNBAbyDate(int i) {
        return sportteryBasketMatch2Mapper.getNBAbyDate(i);
    }

    public Map<String, HTAward> findForBbHTAwardMapByIntTime(Set<String> intTimeSet, PassMode passMode) {
        Map<String, HTAward> awardMap = new HashMap<String, HTAward>();
        List<String> intTimeList = new ArrayList<String>(intTimeSet);

        List<HTAward> awardList = findForBbHTAwardByIntTime(intTimeList, passMode.ordinal());

        for (HTAward award : awardList) {
            String matchKey = CommonUtils.genMatchKey(award.getIntTime(), award.getLineId());
            awardMap.put(matchKey, award);
        }

        return awardMap;
    }

    public Map getSfcAward(int i, Integer intTime, Integer lineId) {
        List<Map> list = sportteryBasketMatch2Mapper.getSfcAwardByPassModelAndIntTimeAndLineId(1, intTime, lineId);
        if (list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public List<Map> getbasketAward(int i, Integer intTime, Integer lineId, int i1) {
        return sportteryBasketMatch2Mapper.getBasketBallAwardByPassModelAndIntTimeAndLineIdAndPlayType(1,intTime,lineId,i1);
    }

    public List<SportteryBasketMatch2> getByIntTime(Integer intTime) {
        SportteryBasketMatch2Query sportteryBasketMatch2Query = new SportteryBasketMatch2Query();
        SportteryBasketMatch2Query.Criteria criteria = sportteryBasketMatch2Query.createCriteria();
        criteria.andInttimeEqualTo(intTime);
        List<SportteryBasketMatch2> sportteryBasketMatch2s = sportteryBasketMatch2Mapper.selectByExample(sportteryBasketMatch2Query);
        return sportteryBasketMatch2s;
    }

    public void update(SportteryBasketMatch2 basketMatch2) {
        sportteryBasketMatch2Mapper.updateByPrimaryKey(basketMatch2);
    }

    public SportteryBasketMatch2 getById(Integer id) {
        return sportteryBasketMatch2Mapper.selectByPrimaryKey(id);
    }

    public List findForBbHTAwardByIntTime(final List<String> intTimes, final Integer passMode) {
        List tempAwardList = new ArrayList();
        List forBbHTAwardByIntTime = sportteryBasketMatch2Mapper.findForBbHTAwardByIntTime(intTimes, passMode);
        List awardList = getHTAwardList(forBbHTAwardByIntTime);
        if (awardList.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < awardList.size(); i++) {
                if (awardList.get(i) != null) {
                    tempAwardList.add(awardList.get(i));
                }
            }
        }
        return tempAwardList;
    }

    private List<HTAward> getHTAwardList(List<Object[]> list) {
        List<HTAward> htAwardList = new ArrayList<HTAward>();
        Map<String, HTAward> map = new HashMap<String, HTAward>();
        for (int i = 0; i < list.size(); i++) {
            Object[] obj = list.get(i);
            HTAward award = map.get(obj[2] + "");
            award = award == null ? new HTAward() : award;
            int playType = Str2Int(obj[0]);
            switch (playType) {
                case 0:// 胜负
                    award.setSf_winOrBigAward(Str2Dou(obj[6]));
                    award.setSf_winOrBigChange(Str2Int(obj[7]));
                    award.setSf_loseOrSmallAward(Str2Dou(obj[8]));
                    award.setSf_loseOrSmallChange(Str2Int(obj[9]));
                    break;
                case 1:// 胜分差
                    break;
                case 2:// 让分胜负
                    award.setRfsf_winOrBigAward(Str2Dou(obj[6]));
                    award.setRfsf_winOrBigChange(Str2Int(obj[7]));
                    award.setRfsf_loseOrSmallAward(Str2Dou(obj[8]));
                    award.setRfsf_loseOrSmallChange(Str2Int(obj[9]));
                    award.setHandicap(Str2Dou(obj[10]));
                    award.setHandicapChange(Str2Int(obj[11]));
                    break;
                case 3:// 大小分
                    award.setDxf_winOrBigAward(Str2Dou(obj[6]));
                    award.setDxf_winOrBigChange(Str2Int(obj[7]));
                    award.setDxf_loseOrSmallAward(Str2Dou(obj[8]));
                    award.setDxf_loseOrSmallChange(Str2Int(obj[9]));
                    award.setBaseBigOrSmall(Str2Dou(obj[12]));
                    award.setBsChange(Str2Int(obj[13]));
                    break;
            }
            award.setId(Str2Int(obj[1]));
            award.setMatchId(Str2Int(obj[2]));
            award.setIntTime(Str2Int(obj[3]));
            award.setLineId(Str2Int(obj[4]));
            award.setPassMode(Str2Int(obj[5]));
            award.setHandUpdateTime(Str2Date(obj[14]));
            award.setBsUpdateTime(Str2Date(obj[15]));
            award.setLastUpdateTime(Str2Date(obj[16]));
            award.setHWawardOf1TO5(Str2Dou(obj[17]));
            award.setHWawardOf6TO10(Str2Dou(obj[18]));
            award.setHWawardOf11TO15(Str2Dou(obj[19]));
            award.setHWawardOf16TO20(Str2Dou(obj[20]));
            award.setHWawardOf21TO25(Str2Dou(obj[21]));
            award.setHWawardOf26(Str2Dou(obj[22]));
            award.setGWawardOf1TO5(Str2Dou(obj[23]));
            award.setGWawardOf6TO10(Str2Dou(obj[24]));
            award.setGWawardOf11TO15(Str2Dou(obj[25]));
            award.setGWawardOf16TO20(Str2Dou(obj[26]));
            award.setGWawardOf21TO25(Str2Dou(obj[27]));
            award.setGWawardOf26(Str2Dou(obj[28]));
            map.put(obj[2] + "", award);
            if (!htAwardList.contains(award)) {
                htAwardList.add(award);
            }
        }
        return htAwardList;
    }

    public Double Str2Dou(Object str){
        Double value=0.0;
        if(str!=null&&!("").equals(str)){
            value=Double.parseDouble(str+"");
        }
        return value;
    }
    public int Str2Int(Object str){
        int value=0;
        if(str!=null&&!("").equals(str)){
            value=Integer.parseInt(str+"");
        }
        return value;
    }
    public Date Str2Date(Object str){
        Date date=null;
        if(str!=null&&!("").equals(str)){
            date= DateTools.StringToDate(str+"");
        }
        return date;
    }
}
