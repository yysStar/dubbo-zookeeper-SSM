package com.qiyun.chaiPiao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.PassMode;
import com.qiyun.model.football.MatchAwardOfRQSPF;
import com.qiyun.tools.DateTools;
import com.qiyun.utils.CommonUtils;
import net.sf.json.JSONObject;


public class RQSPFAwardList implements AwardInterface<MatchAwardOfRQSPF> {

	public List<MatchAwardOfRQSPF> getPassAwardList(String html) {
		return getAwardList(html, PassMode.PASS.ordinal());
	}

	public List<MatchAwardOfRQSPF> getSingleAwardList(String html) {
		return getAwardList(html, PassMode.SINGLE.ordinal());
	}

	private List<MatchAwardOfRQSPF> getAwardList(String html, int passMode) {
		List<MatchAwardOfRQSPF> awardList = new ArrayList<MatchAwardOfRQSPF>();
		try {
			html = html.substring(8, html.length()-2);
			JSONObject  o = JSONObject.fromObject(html);
			JSONObject list = o.getJSONObject("data");
			Iterator it = list.keys();
			while(it.hasNext()){
				String key = it.next().toString();
				JSONObject item = list.getJSONObject(key);
				String matchId = item.get("id").toString().trim();
				String numberStr = item.get("num").toString().trim();
				String lineId = numberStr.substring(2, numberStr.length());
				String date = item.get("date").toString().trim();
				String time = item.get("time").toString().trim();
				String intTime = item.get("b_date").toString().trim().replaceAll("-", "");
				
				//让球胜平负
				if(item.containsKey("hhad")){
					String jsonHad =  item.get("hhad").toString().trim();
					JSONObject jsonObj = JSONObject.fromObject(jsonHad);
					String pStatus = jsonObj.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String homeWinAward = jsonObj.getString("h");
						String guestWinAward = jsonObj.getString("a");
						String drawAward = jsonObj.getString("d");
						
						MatchAwardOfRQSPF award = new MatchAwardOfRQSPF();
						award.setLineId(Integer.parseInt(lineId));
						Date matchTime = DateTools.StringToDate_YYYY_MM_DD_HH_MM_SS(date+" "+time);
						award.setMatchId(Integer.parseInt(matchId));
						award.setSportteryMatchId(matchId);
						award.setMatchTime(matchTime);
						award.setIntTime(Integer.parseInt(intTime));
						award.setHomeWinAward(CommonUtils.getAward(homeWinAward));
						award.setGuestWinAward(CommonUtils.getAward(guestWinAward));
						award.setDrawAward(CommonUtils.getAward(drawAward));
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
		List<AbstractAward> awardList = SportteryGrabberUtil.getAwardList(LotteryType.JC_ZQ_RQSPF, (byte) 1);
	}
}
