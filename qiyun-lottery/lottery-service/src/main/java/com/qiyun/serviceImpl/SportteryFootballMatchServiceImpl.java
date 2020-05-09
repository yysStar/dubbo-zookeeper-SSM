package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.mapper2.DgMapper;
import com.qiyun.mapper2.SportteryFootballBfaward2Mapper;
import com.qiyun.mapper2.SportteryFootballJqsaward2Mapper;
import com.qiyun.mapper2.SportteryFootballMatch2Mapper;
import com.qiyun.model.FootBallIsShow;
import com.qiyun.model.football.MatchAwardOfHT;
import com.qiyun.model.PassMode;
import com.qiyun.model2.SportteryFootballBfaward2;
import com.qiyun.model2.SportteryFootballMatch2;
import com.qiyun.model2.SportteryFootballMatch2Query;
import com.qiyun.service.SportteryFootballMatchService;
import com.qiyun.util.DateUtil;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.DateUtils;
import com.qiyun.utils.TimeTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SportteryFootballMatchServiceImpl implements SportteryFootballMatchService {

    @Resource
    private DgMapper dgMapper;

    @Resource
    private SportteryFootballMatch2Mapper sportteryFootballMatch2Mapper;
    @Resource
    private SportteryFootballBfaward2Mapper sportteryFootballBfaward2Mapper;

    public SportteryFootballMatch2 getByIntTimeAndLineId(Integer intTime, Integer lineId) {
        SportteryFootballMatch2Query sportteryFootballMatch2Query = new SportteryFootballMatch2Query();
        SportteryFootballMatch2Query.Criteria criteria = sportteryFootballMatch2Query.createCriteria();
        criteria.andInttimeEqualTo(intTime);
        criteria.andLineidEqualTo(lineId);
        List<SportteryFootballMatch2> sportteryFootballMatch2s = sportteryFootballMatch2Mapper.selectByExample(sportteryFootballMatch2Query);
        if (sportteryFootballMatch2s==null || sportteryFootballMatch2s.size()<=0){
            return null;
        }
        return sportteryFootballMatch2s.get(0);
    }

    public List<Map<String,Object>> findFootballMixureInfo(int isFocus) {
        int dealTime = dgMapper.getDealTime();
        //判断当前时间是否小于十点
        SimpleDateFormat time=new SimpleDateFormat("yyyyMMdd");
        int timeOffset=10;
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
        //查询出当日所有比赛的信息
        List<Map<String, Object>> maps = null;
        List<Map> respMap = new ArrayList<Map>();
        if (isFocus==0) {
            maps = sportteryFootballMatch2Mapper.findFootballMixureInfo(intTime);
        }else if (isFocus==1){
            maps = sportteryFootballMatch2Mapper.findFootballMixureInfoByFocus(intTime);
        }
            //获取到比赛场次的id
        Date parse = null;
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
        String lineIdStr =null;
        if (maps==null || maps.size()<=0){
            return maps;
        }
        for (int i = 0; i < maps.size(); i++) {
            Map<String, Object> map = maps.get(i);
            int lineid = Integer.parseInt(map.get("lineid").toString());
            try {
                parse = dateFormater.parse(map.get("intTime") + "");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String weekOfDate = DateUtil.getWeekForDate(parse);
            if (lineid<10){
                lineIdStr = "00"+lineid;
            }else if (lineid<100){
                lineIdStr = "0"+lineid;
            }else{
                lineIdStr = ""+lineid;
            }
               map.put("matchIds",weekOfDate+" "+lineIdStr);
//            map.put("MatchDealTime",TimeTools.getFbEndSaleTime((Date)map.get("matchTime"),60000*dealTime));
//            Date matchDealTime = TimeTools.getEndSaleTimeByWorldCup((Date) map.get("matchTime"), 60000 * dealTime, map.get("GAME_SHORT_NAME").toString());
            Date matchDealTime = TimeTools.getFootBallDealTime((Date) map.get("matchTime"), 60000 * dealTime);
            map.put("MatchDealTime",matchDealTime);
            if (matchDealTime.before(new Date())){
                maps.remove(i);
                i--;
                continue;
            }
            //查询让球胜平负的数据
            //判断是否开售
            boolean[] showNums = FootBallIsShow.getSelectStatus(Integer.parseInt(map.get("showNum").toString()));
            List list = new ArrayList();
            for (Boolean b:showNums
                 ) {
                list.add(b);
            }
            List<Map> rqMap = sportteryFootballMatch2Mapper.findRqspfSp(map);
            List<Map> nrpMap = sportteryFootballMatch2Mapper.findSpfSp(map);

            if (rqMap!=null && rqMap.size()>0) {
                map.putAll(rqMap.get(0));
            }
            if (nrpMap!=null && nrpMap.size()>0) {
                map.putAll(nrpMap.get(0));
            }
            map.put("showNum", list);
            Map<String, Object> mapInfo = new HashMap<String, Object>(map);

            respMap.add(mapInfo);
        }
        LogUtil.info("---------------------------nirema ------足球赛程返回："+maps.size()+"场");
        return maps;
    }

    public Map<String, Object> findFootballMixureMoreInfo(String matchId) {

        //获取比分数据
        List<Map> map = sportteryFootballBfaward2Mapper.findbfInfo(matchId);
        //获取总进球sp
        List<Map> jqMap = sportteryFootballMatch2Mapper.findjqInfo(matchId);
        //获取半场sp
        List<Map> bcMap = sportteryFootballMatch2Mapper.findbcInfo(matchId);

        Map<String,Object> maps = new HashMap<String, Object>();
        if (map!=null && map.size()>0) {
            maps.put("bfsp", map.get(0));
        }
        if (jqMap!=null && jqMap.size()>0) {
            maps.put("jqsp", jqMap.get(0));
        }
        if (bcMap!=null && bcMap.size()>0) {
            maps.put("bcsp", bcMap.get(0));
        }
        return maps;
    }

    public Map<String, MatchAwardOfHT> getAwardMapByIntTimeListAndPlayTypePassMode(Set<Integer> intTimeSet,
                                                                                   LotteryType jcZqHt, PassMode pass) {
        return null;
    }

    public List<Map> getSpfAward(Integer intTime, Integer lineId) {
        return sportteryFootballMatch2Mapper.getSpfAward(intTime,lineId);
    }

    public List<Map> getRqspfAward(Integer intTime, Integer lineId) {
        return sportteryFootballMatch2Mapper.getRqspfAward(intTime,lineId);
    }

    public List<Map> getBqcAward(Integer intTime, Integer lineId) {
        return sportteryFootballMatch2Mapper.getBqcAward(intTime,lineId);
    }

    public List<Map> getBfAward(Integer intTime, Integer lineId) {
        return sportteryFootballMatch2Mapper.getBfAward(intTime,lineId);
    }

    public List<Map> getJqsAward(Integer intTime, Integer lineId) {
        return sportteryFootballMatch2Mapper.getJqsAward(intTime,lineId);
    }

    public List<SportteryFootballMatch2> getWorldCupByIntTime(int i) {
        SportteryFootballMatch2Query sportteryFootballMatch2Query = new SportteryFootballMatch2Query();
        SportteryFootballMatch2Query.Criteria criteria = sportteryFootballMatch2Query.createCriteria();
        criteria.andInttimeEqualTo(i);
        criteria.andGamenameEqualTo("世界杯");
        sportteryFootballMatch2Query.setOrderByClause("matchTime desc");
        List<SportteryFootballMatch2> sportteryFootballMatch2s = sportteryFootballMatch2Mapper.selectByExample(sportteryFootballMatch2Query);
        return sportteryFootballMatch2s;
    }

    /**
     * 通过开售时间查询对应赛事
     * @param intTime
     * @return
     */
    public List<SportteryFootballMatch2> getMatchListByIntTime(Set<Integer> intTime) {
        if (intTime == null || intTime.isEmpty()) {
            throw new RuntimeException("intTime参数为空");
        }
        SportteryFootballMatch2Query sportteryFootballMatch2Query = new SportteryFootballMatch2Query();
        SportteryFootballMatch2Query.Criteria criteria = sportteryFootballMatch2Query.createCriteria();
        if (intTime.size() == 1) {
            criteria.andInttimeEqualTo(intTime.iterator().next());
        } else {
            List list = new ArrayList(intTime);
            criteria.andInttimeIn(list);
        }
        List<SportteryFootballMatch2> matchList = sportteryFootballMatch2Mapper
                .selectByExample(sportteryFootballMatch2Query);
        return matchList;
	}
	
    public List<SportteryFootballMatch2> getByIntTime(Integer intTime) {
        SportteryFootballMatch2Query sportteryFootballMatch2Query = new SportteryFootballMatch2Query();
        SportteryFootballMatch2Query.Criteria criteria = sportteryFootballMatch2Query.createCriteria();
        criteria.andInttimeEqualTo(intTime);
        List<SportteryFootballMatch2> sportteryFootballMatch2s = sportteryFootballMatch2Mapper.selectByExample(sportteryFootballMatch2Query);
        return sportteryFootballMatch2s;
    }

    public void update(SportteryFootballMatch2 footballMatch2) {
        sportteryFootballMatch2Mapper.updateByPrimaryKey(footballMatch2);
    }

    public SportteryFootballMatch2 getById(Integer id) {
        return sportteryFootballMatch2Mapper.selectByPrimaryKey(id);
    }
}
