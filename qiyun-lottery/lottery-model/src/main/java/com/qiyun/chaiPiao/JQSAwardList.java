package com.qiyun.chaiPiao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.PassMode;
import com.qiyun.tools.DateTools;
import net.sf.json.JSONObject;

public class JQSAwardList implements AwardInterface<MatchAwardOfJQS> {
	
	public List<MatchAwardOfJQS> getPassAwardList(String html) {
		return getAwardList(html, PassMode.PASS.ordinal());
	}

	public List<MatchAwardOfJQS> getSingleAwardList(String html) {
		return getAwardList(html, PassMode.SINGLE.ordinal());
	}
	
	private List<MatchAwardOfJQS> getAwardList(String html, int passMode) {
		List<MatchAwardOfJQS> awardList = new ArrayList<MatchAwardOfJQS>();
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
				
				//进球数
				if(item.containsKey("ttg")){
					String jsonHad =  item.get("ttg").toString().trim();
					JSONObject jsonObj = JSONObject.fromObject(jsonHad);
					String pStatus = jsonObj.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						Date matchTime = DateTools.StringToDate_YYYY_MM_DD_HH_MM_SS(date+" "+time);
						MatchAwardOfJQS award = new MatchAwardOfJQS();
						award.setIntTime(Integer.parseInt(intTime));
						award.setLineId(Integer.parseInt(lineId));
						award.setMatchTime(matchTime);
						award.setS0_award(jsonObj.getDouble("s0"));
						award.setS1_award(jsonObj.getDouble("s1"));
						award.setS2_award(jsonObj.getDouble("s2"));
						award.setS3_award(jsonObj.getDouble("s3"));
						award.setS4_award(jsonObj.getDouble("s4"));
						award.setS5_award(jsonObj.getDouble("s5"));
						award.setS6_award(jsonObj.getDouble("s6"));
						award.setS7_award(jsonObj.getDouble("s7"));
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

	public static void main(String args[]) {
		List<AbstractAward> awardList = SportteryGrabberUtil.getAwardList(LotteryType.JC_ZQ_JQS, (byte) 0);
	}
}
