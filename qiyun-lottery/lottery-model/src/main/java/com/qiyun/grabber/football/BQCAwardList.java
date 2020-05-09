package com.qiyun.grabber.football;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qiyun.model.PassMode;
import com.qiyun.model.football.MatchAwardOfBQC;
import com.qiyun.model.inter.AwardInterface;
import com.qiyun.tools.DateTools;
import net.sf.json.JSONObject;

public class BQCAwardList implements AwardInterface<MatchAwardOfBQC> {

	public List<MatchAwardOfBQC> getPassAwardList(String html) {
		return getAwardList(html, PassMode.PASS.ordinal());
	}

	public List<MatchAwardOfBQC> getSingleAwardList(String html) {
		return getAwardList(html, PassMode.SINGLE.ordinal());
	}
	
	private List<MatchAwardOfBQC> getAwardList(String html, int passMode) {
		List<MatchAwardOfBQC> awardList = new ArrayList<MatchAwardOfBQC>();
		try {
			html = html.substring(8, html.length()-2);
			JSONObject  o = JSONObject.fromObject(html);
			JSONObject list = o.getJSONObject("data");
			Iterator it = list.keys();
			while(it.hasNext()){
				String key = it.next().toString();
				JSONObject item = list.getJSONObject(key);
				String numberStr = item.get("num").toString().trim();
				String lineId = numberStr.substring(2, numberStr.length());
				String date = item.get("date").toString().trim();
				String time = item.get("time").toString().trim();
				String intTime = item.get("b_date").toString().trim().replaceAll("-", "");
				
				//半全场
				if(item.containsKey("hafu")){
					String jsonHad =  item.get("hafu").toString().trim();
					JSONObject jsonObj = JSONObject.fromObject(jsonHad);
					String pStatus = jsonObj.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						Date matchTime = DateTools.StringToDate_YYYY_MM_DD_HH_MM_SS(date+" "+time);
						Double[] awardArr = new Double[9];
						awardArr[0] = jsonObj.getDouble("hh");
						awardArr[1] = jsonObj.getDouble("hd");
						awardArr[2] = jsonObj.getDouble("ha");
						awardArr[3] = jsonObj.getDouble("dh");
						awardArr[4] = jsonObj.getDouble("dd");
						awardArr[5] = jsonObj.getDouble("da");
						awardArr[6] = jsonObj.getDouble("ah");
						awardArr[7] = jsonObj.getDouble("ad");
						awardArr[8] = jsonObj.getDouble("aa");
						
						MatchAwardOfBQC award = new MatchAwardOfBQC();
						award.setIntTime(Integer.parseInt(intTime));
						award.setLineId(Integer.parseInt(lineId));
						award.setMatchTime(matchTime);
						award.setAwardArr(awardArr);
						award.setPassMode(passMode);
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
//		List<AbstractAward> awardList = SportteryGrabberUtil.getAwardList(LotteryType.JC_ZQ_BQC, (byte) 0);
//	}
}
