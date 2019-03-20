package com.qiyun.model.basketball;

import com.qiyun.grabber.model.AbstractBasketballYp;
import com.qiyun.util.NumberTools;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class BasketballYp extends AbstractBasketballYp implements java.io.Serializable {
	public static final String AVG_COMPANY="平均值";
	public static final Map<String, String> COMAPNY=new HashMap<String, String>();
	static{
		COMAPNY.put("澳门", "aomen");
		COMAPNY.put( "立博","libo");
		COMAPNY.put("bet365","ribo");
		COMAPNY.put( "韦德","weide");
		COMAPNY.put("易胜博","yisheng");
		COMAPNY.put("皇冠","huangguan");
		COMAPNY.put(AVG_COMPANY,"avg");
	}
	// Constructors

	/** default constructor */
	public BasketballYp() {
	}

	/** minimal constructor */
	public BasketballYp(Integer matchId) {
		super(matchId);
	}

	/** full constructor */
	public BasketballYp(Integer matchId, Double home, Integer homeChange, Double pankou, Integer pankouChange, Double guest, Integer guestChange,
			Integer isFirst, Date time) {
		super(matchId, home, homeChange, pankou, pankouChange, guest, guestChange, isFirst, time);
	}

	public Map<String, String> getJsonMap(BasketBallMatch match) {
		Map<String, String> tempMap = new HashMap<String, String>();

		tempMap.put("az_" + match.getIntTime() + "_" + match.getLineId() + "_h", getHome() + "");
		tempMap.put("az_" + match.getIntTime() + "_" + match.getLineId() + "_r", getPankouReversal() + "");
		tempMap.put("az_" + match.getIntTime() + "_" + match.getLineId() + "_a", getGuest() + "");
		tempMap.put("az_" + match.getIntTime() + "_" + match.getLineId() + "_hC", getHomeChange() + "");
		tempMap.put("az_" + match.getIntTime() + "_" + match.getLineId() + "_rC", getPankouChange() + "");
		tempMap.put("az_" + match.getIntTime() + "_" + match.getLineId() + "_aC", getGuestChange() + "");

		return tempMap;
	}

	public Map<String, String> getYlb(BasketBallMatch bb, String[] tzbArr) {
		Map<String, String> ylbMap = new HashMap<String, String>();
		Double[] betArr = { getHome(), getGuest() };
		for (int i = 0; i < tzbArr.length; i++) {
			if (tzbArr[i] == null || "0.0%".equals(tzbArr[i]) || betArr == null) {
				continue;
			}
			Double tempYlb = null;
			tzbArr[i] = tzbArr[i].replace("%", "");
			Double tzb = Double.valueOf(tzbArr[i]) / 100;
			tempYlb = 1 - tzb * (betArr[i] + 1);
			String ylb = NumberTools.doubleToPercent(tempYlb, "0.0%");
			ylbMap.put("ylb_" + bb.getIntTime() + "_" + bb.getLineId() + "_az_" + i, ylb);
		}
		return ylbMap;
	}

	public static Map<String, String> getYlbJsonMap(Map<Integer, BasketballYp> ypMap, Map<Integer, BasketballTzb> awardTzbMap,
			List<BasketBallMatch> raceList) {
		if (ypMap == null || ypMap.isEmpty() || awardTzbMap == null || awardTzbMap.isEmpty())
			return null;
		Map<String, String> resultMap = new HashMap<String, String>();
		for (BasketBallMatch bb : raceList) {
			BasketballYp yp = ypMap.get(bb.getId());
			BasketballTzb tzb = awardTzbMap.get(bb.getId());
			if (tzb != null && yp != null) {
				String[] tzbArr = { tzb.getHome(), tzb.getGuest() };
				resultMap.putAll(yp.getYlb(bb, tzbArr));
			}
		}
		return resultMap;
	}
	
	public void checkChangeStatus(BasketballYp beforYp){
		this.setHomeChange(getSWchange(this.getHome(),beforYp.getHome()));
		this.setPankouChange(getSWchange(this.getPankou(),beforYp.getPankou()));
		this.setGuestChange(getSWchange(this.getGuest(),beforYp.getGuest()));
	}
	public int getSWchange(Double d1, Double d2) {
		if (d1 > d2) {
			return 1;
		} else if (d1 < d2) {
			return -1;
		} else {
			return 0;
		}
	}
}
