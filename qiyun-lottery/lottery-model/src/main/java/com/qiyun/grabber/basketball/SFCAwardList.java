package com.qiyun.grabber.basketball;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.SFCAward;
import com.qiyun.model.inter.AwardInterface;
import com.qiyun.tools.DateTools;
import net.sf.json.JSONObject;

public class SFCAwardList implements AwardInterface<SFCAward> {

	public List<SFCAward> getPassAwardList(String html) {
		return getAwardList(html, PassMode.PASS.ordinal());
	}
	
	public List<SFCAward> getSingleAwardList(String html) {
		return getAwardList(html, PassMode.SINGLE.ordinal());
	}

	private List<SFCAward> getAwardList(String html, int passMode) {
		List<SFCAward> awardList = new ArrayList<SFCAward>();
		if(html == null) {
			return awardList;
		}
		
		try {
			html = html.substring(8, html.length()-2);
			JSONObject o = JSONObject.fromObject(html);
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
				
				//胜负
				if(item.containsKey("wnm")){
					String jsonHad =  item.get("wnm").toString().trim();
					JSONObject json = JSONObject.fromObject(jsonHad);
					String pStatus = json.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						SFCAward award = new SFCAward();
						award.setPassMode(passMode);
						award.setIntTime(Integer.parseInt(intTime));
						award.setLineId(Integer.parseInt(lineId));
						Date matchTime = DateTools.StringToDate_YYYY_MM_DD_HH_MM_SS(date+" "+time);
						award.setMatchTime(matchTime);
						award.setLastUpdateTime(new Date());
						award.setHWawardOf1TO5(json.getDouble("w1"));
						award.setHWawardOf6TO10(json.getDouble("w2"));
						award.setHWawardOf11TO15(json.getDouble("w3"));
						award.setHWawardOf16TO20(json.getDouble("w4"));
						award.setHWawardOf21TO25(json.getDouble("w5"));
						award.setHWawardOf26(json.getDouble("w6"));
						award.setGWawardOf1TO5(json.getDouble("l1"));
						award.setGWawardOf6TO10(json.getDouble("l2"));
						award.setGWawardOf11TO15(json.getDouble("l3"));
						award.setGWawardOf16TO20(json.getDouble("l4"));
						award.setGWawardOf21TO25(json.getDouble("l5"));
						award.setGWawardOf26(json.getDouble("l6"));
						awardList.add(award);
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return awardList;
	}
	
	public Double getAward(String award, boolean flag) {
		double wAward = 0.0;
		if (!"".equals(award)) {
			int indexA = award.indexOf(" ");
			if (!flag) {
				if (indexA == -1) {
					String tempStr = award.substring(award.length() - 4);
					if ("0000".equals(tempStr)) {
						award = award.substring(0, award.length() - 4);
					} else {
						award = award.substring(0, 4);
					}
				} else {
					award = award.substring(0, indexA);
				}
			} else {
				if (indexA == -1) {
					String tempStr = award.substring(award.length() - 4);
					if ("0000".equals(tempStr)) {
						award = "0000";
					} else {
						award = award.substring(4);
					}
				} else {
					award = award.substring(indexA + 1);
				}
			}
			wAward = Double.parseDouble(award);
		}
		return wAward;
	}
}
