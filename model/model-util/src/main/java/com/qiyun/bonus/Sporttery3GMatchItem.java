package com.qiyun.bonus;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.item.MatchItem;
import com.qiyun.tools.DateTools;

import java.util.*;


public class Sporttery3GMatchItem extends MatchItem {
	/** 主队 */
	private String home;
	
	/** 客队 */
	private String guest;
	
	private Integer rqs;
	
	private Double rf;
	private Double dxf;
	/** 选择的内容 */
	private List<SportteryOption3G> options3G = new ArrayList<SportteryOption3G>();
	
	private Map<LotteryType,List<SportteryOption3G>> playTypes;
	
	
	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getIntTimeStr() {
		Date time = DateTools.StringToDate(getIntTime() + "", "yyyyMMdd");
		return DateTools.dateToString(time,"yyyy-MM-dd");
	}
	
	public String getWeekStr() {
		Date time = DateTools.StringToDate(getIntTime() + "", "yyyyMMdd");
		return DateTools.getWeekStr(time);
	}

	public String getLineIDText() {
		String lineId = getLineId().toString();
		for (int i = lineId.length(); i < 3; i++) {
			lineId = "0" + lineId;
		}
		return lineId;
	}

	public Map<LotteryType, List<SportteryOption3G>> getPlayTypes() {
		Map<LotteryType, List<SportteryOption3G>> map=new HashMap<LotteryType, List<SportteryOption3G>>();
		for (SportteryOption3G option : getOptions3G()) {
			LotteryType type= LotteryType.getItem(Integer.parseInt( option.getType()));
			List<SportteryOption3G> list=null;
			if(map.containsKey(type)){
				list=map.get(type);
			}else{
				list=new ArrayList<SportteryOption3G>();
			}
			list.add(option);
			map.put(type, list);
		}
		return map;
	}
	public boolean isHt(){
		return getPlayTypes().size()>1;
	}
	

	public Integer getRqs() {
		return rqs;
	}

	public void setRqs(Integer rqs) {
		this.rqs = rqs;
	}

	public Double getRf() {
		return rf;
	}

	public void setRf(Double rf) {
		this.rf = rf;
	}
	public void setRF(Double rf) {
		this.rf = rf;
	}

	public Double getDxf() {
		return dxf;
	}

	public void setDxf(Double dxf) {
		this.dxf = dxf;
	}
	
	public void setDXF(Double dxf) {
		this.dxf = dxf;
	}

	public List<SportteryOption3G> getOptions3G() {
		return options3G;
	}

	public void setOptions3G(List<SportteryOption3G> options3G) {
		this.options3G = options3G;
	}




	
}
