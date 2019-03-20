package com.qiyun.grabber.football;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.PassMode;
import com.qiyun.model.football.MatchAwardOfSPF;
import com.qiyun.model.inter.AwardInterface;
import com.qiyun.tools.DateTools;
import com.qiyun.utils.CommonUtils;
import com.qiyun.utils.basketball.SportteryGrabberUtil;
import net.sf.json.JSONObject;

public class SPFAwardList implements AwardInterface<MatchAwardOfSPF> {

	public List<MatchAwardOfSPF> getPassAwardList(String html) {
		return getAwardList(html, PassMode.PASS.ordinal());
	}

	public List<MatchAwardOfSPF> getSingleAwardList(String html) {
		return getAwardList(html, PassMode.SINGLE.ordinal());
	}

	private List<MatchAwardOfSPF> getAwardList(String html, int passMode) {
		List<MatchAwardOfSPF> awardList = new ArrayList<MatchAwardOfSPF>();
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
				
				//胜平负
				if(item.containsKey("had")){
					String jsonHad =  item.get("had").toString().trim();
					JSONObject jsonObj = JSONObject.fromObject(jsonHad);
					String pStatus = jsonObj.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String homeWinAward = jsonObj.getString("h");
						String guestWinAward = jsonObj.getString("a");
						String drawAward = jsonObj.getString("d");
						MatchAwardOfSPF award = new MatchAwardOfSPF();
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
