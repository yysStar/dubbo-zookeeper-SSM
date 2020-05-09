package com.qiyun.grabber.basketball;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.qiyun.grabber.model.AwardListEnum;
import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.SFAward;
import com.qiyun.model.inter.AwardInterface;
import com.qiyun.tools.DateTools;
import com.qiyun.utils.CommonUtils;
import net.sf.json.JSONObject;

public class DXFAwardList implements AwardInterface<SFAward> {

	public List<SFAward> getPassAwardList(String html) {
		return getAwardList(html, PassMode.PASS.ordinal());
	}
	
	public List<SFAward> getSingleAwardList(String html) {
		return getAwardList(html, PassMode.SINGLE.ordinal());
	}

	private List<SFAward> getAwardList(String html, int passMode) {
		List<SFAward> awardList = new ArrayList<SFAward>();
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
				
				//大小分
				if(item.containsKey("hilo")){
					String jsonHad =  item.get("hilo").toString().trim();
					JSONObject json = JSONObject.fromObject(jsonHad);
					String pStatus = json.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String bigAward = json.getString("h");
						String smallAward = json.getString("l");
						String baseBigOrSmall = json.getString("fixedodds");
						
						SFAward award = new SFAward();
						award.setPlayType(AwardListEnum.DXF.ordinal());
						award.setPassMode(passMode);
						award.setIntTime(Integer.parseInt(intTime));
						award.setLineId(Integer.parseInt(lineId));
						Date matchTime = DateTools.StringToDate_YYYY_MM_DD_HH_MM_SS(date+" "+time);
						award.setMatchTime(matchTime);
						award.setHandicap(0d);
						award.setBaseBigOrSmall(Double.valueOf(baseBigOrSmall));
						award.setWinOrBigAward(CommonUtils.getAward(bigAward));
						award.setLoseOrSmallAward(CommonUtils.getAward(smallAward));
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
	
}
