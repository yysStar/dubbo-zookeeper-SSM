package com.qiyun.grabber.football;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qiyun.model.PassMode;
import com.qiyun.model.football.MatchAwardOfBF;
import com.qiyun.model.inter.AwardInterface;
import com.qiyun.tools.DateTools;
import net.sf.json.JSONObject;

public class BFAwardList implements AwardInterface<MatchAwardOfBF> {
	
	public List<MatchAwardOfBF> getPassAwardList(String html) {
		return getAwardList(html, PassMode.PASS.ordinal());
	}
	
	public List<MatchAwardOfBF> getSingleAwardList(String html) {
		return getAwardList(html, PassMode.SINGLE.ordinal());
	}

	private List<MatchAwardOfBF> getAwardList(String html, int passMode) {
		List<MatchAwardOfBF> awardList = new ArrayList<MatchAwardOfBF>();
		try {
			html = html.substring(8, html.length()-2);
			JSONObject  o = JSONObject.fromObject(html);
			JSONObject list = o.getJSONObject("data");
			Iterator it = list.keys();
			while(it.hasNext()){
				String key = it.next().toString();
				JSONObject item = list.getJSONObject(key);
				String matchId = item.getString("id").toString().trim();
				String numberStr = item.get("num").toString().trim();
				String lineId = numberStr.substring(2, numberStr.length());
				String date = item.get("date").toString().trim();
				String time = item.get("time").toString().trim();
				String intTime = item.get("b_date").toString().trim().replaceAll("-", "");
				
				//比分
				if(item.containsKey("crs")){
					String jsonHad =  item.get("crs").toString().trim();
					JSONObject jsonObj = JSONObject.fromObject(jsonHad);
					String pStatus = jsonObj.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						Date matchTime = DateTools.StringToDate_YYYY_MM_DD_HH_MM_SS(date+" "+time);
						MatchAwardOfBF award = new MatchAwardOfBF();
						award.setMatchId(Integer.parseInt(matchId));
						award.setIntTime(Integer.parseInt(intTime));
						award.setLineId(Integer.parseInt(lineId));
						award.setMatchTime(matchTime);
						//胜
						award.setS10award(jsonObj.getDouble("0100"));
						award.setS20award(jsonObj.getDouble("0200"));
						award.setS21award(jsonObj.getDouble("0201"));
						award.setS30award(jsonObj.getDouble("0300"));
						award.setS31award(jsonObj.getDouble("0301"));
						award.setS32award(jsonObj.getDouble("0302"));
						award.setS40award(jsonObj.getDouble("0400"));
						award.setS41award(jsonObj.getDouble("0401"));
						award.setS42award(jsonObj.getDouble("0402"));
						award.setS50award(jsonObj.getDouble("0500"));
						award.setS51award(jsonObj.getDouble("0501"));
						award.setS52award(jsonObj.getDouble("0502"));
						award.setS_win_award(jsonObj.getDouble("-1-h"));
						//平
						award.setS00award(jsonObj.getDouble("0000"));
						award.setS11award(jsonObj.getDouble("0101"));
						award.setS22award(jsonObj.getDouble("0202"));
						award.setS33award(jsonObj.getDouble("0303"));
						award.setS_draw_award(jsonObj.getDouble("-1-d"));
						//负
						award.setS01award(jsonObj.getDouble("0001"));
						award.setS02award(jsonObj.getDouble("0002"));
						award.setS12award(jsonObj.getDouble("0102"));
						award.setS03award(jsonObj.getDouble("0003"));
						award.setS13award(jsonObj.getDouble("0103"));
						award.setS23award(jsonObj.getDouble("0203"));
						award.setS04award(jsonObj.getDouble("0004"));
						award.setS14award(jsonObj.getDouble("0104"));
						award.setS24award(jsonObj.getDouble("0204"));
						award.setS05award(jsonObj.getDouble("0005"));
						award.setS15award(jsonObj.getDouble("0105"));
						award.setS25award(jsonObj.getDouble("0205"));
						award.setS_lose_award(jsonObj.getDouble("-1-a"));
						award.setPassMode(passMode);
						award.setLastUpdateTime(new Date());
						awardList.add(award);
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return awardList;
	}
	
//	public static void main(String args[]) {
//		List<AbstractAward> awardList = SportteryGrabberUtil.getAwardList(LotteryType.JC_ZQ_BF, (byte) 0);
//	}

}
