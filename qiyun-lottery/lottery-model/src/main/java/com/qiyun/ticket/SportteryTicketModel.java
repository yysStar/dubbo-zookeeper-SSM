package com.qiyun.ticket;

import java.util.ArrayList;
import java.util.List;

import com.qiyun.model.ExtensionCombCallBack;
import com.qiyun.model.MatchItem;
import com.qiyun.model.SportteryOption;
import com.qiyun.model.SportteryPassType;
import com.qiyun.utils.ExtensionMathUtils;

public class SportteryTicketModel<X extends MatchItem> {

	private List<X> matchItems;
	private Integer passMode;
	private int multiple;
	private SportteryPassType passType;
	private boolean isOnlyPlay;
	

	// 计算注数
	public int countUnit() {
		int count = 0;
		final List<Integer> sheDanMatch = new ArrayList<Integer>();
		final List<Integer> unDanMatch = new ArrayList<Integer>();
		for (X x : matchItems) {
			if (x.isShedan())
				sheDanMatch.add(x.selectedCount());
			else
				unDanMatch.add(x.selectedCount());
		}
		final List<Integer> result = new ArrayList<Integer>();
		int passCount = passType.getPassMatchs()[0];
		if (passCount < sheDanMatch.size())
			throw new RuntimeException("设胆错误");
		ExtensionMathUtils.efficientCombExtension(passCount, sheDanMatch.size(), unDanMatch.size(),
				new ExtensionCombCallBack() {
			public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
				Integer tempCount = 1;
				for (int i = 0; i < comb1.length; i++) {
					if (comb1[i])
						tempCount *= sheDanMatch.get(i);
				}
				for (int i = 0; i < comb2.length; i++) {
					if (comb2[i])
						tempCount *= unDanMatch.get(i);
				}
				result.add(tempCount);
			}
		});
		for (Integer r : result) {
			count += r;
		}
		return count;
	}
	
	// 计算混投注数
	public int countHtUnit() {
		int count = 0;
		final List<Integer> tiketMatch = new ArrayList<Integer>();
		final List<X> tiketList = new ArrayList<X>();
		for (X x : matchItems) {// 找出设胆和非设胆的
			List<SportteryOption> undanSportteryOptionList = new ArrayList<SportteryOption>();
			for(SportteryOption sportteryOption : x.getOptions()){
				undanSportteryOptionList.add(sportteryOption);
			}
			
			for(SportteryOption sportteryOption : undanSportteryOptionList){
				List<SportteryOption> list = new ArrayList<SportteryOption>();
				list.add(sportteryOption);
				X fb = (X) new MatchItem();
				
				fb.setIntTime(x.getIntTime());
				fb.setLineId(x.getLineId());
				fb.setOptions(list);
				fb.setShedan(x.isShedan());
				tiketList.add(fb);
				tiketMatch.add(1);
			}
		}
		
		final List<Integer> result = new ArrayList<Integer>();
		int passCount = passType.getPassMatchs()[0];
		if (passCount < 0)
			throw new RuntimeException("设胆错误");
		ExtensionMathUtils.efficientCombExtension(passCount, 0, tiketMatch.size(), new ExtensionCombCallBack() {
			public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
				List<X> tempMatchs = new ArrayList<X>();
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < comb2.length; i++) {
					String intTime = String.valueOf(tiketList.get(i).getIntTime());
					String lineId = String.valueOf(tiketList.get(i).getLineId());
					String key = intTime+""+lineId;
					if (comb2[i] && !list.contains(key)){
						list.add(key);
						tempMatchs.add(tiketList.get(i));
					}
				}
				
				if(tempMatchs.size()>passType.getPassMatchs()[0]-1){
					Integer tempCount = 1;
					for (int i = 0; i < comb2.length; i++) {
						if (comb2[i]){
							tempCount *= tiketMatch.get(i);
						}
					}
					result.add(tempCount);
				}
			}
		});
		for (Integer r : result) {
			count += r;
		}
		return count;
	}


	public List<X> getMatchItems() {
		return matchItems;
	}

	public void setMatchItems(List<X> matchItems) {
		this.matchItems = matchItems;
	}

	public Integer getPassMode() {
		return passMode;
	}

	public void setPassMode(Integer passMode) {
		this.passMode = passMode;
	}

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}

	public SportteryPassType getPassType() {
		return passType;
	}

	public void setPassType(SportteryPassType passType) {
		this.passType = passType;
	}

	public boolean isOnlyPlay() {
		return isOnlyPlay;
	}

	public void setOnlyPlay(boolean isOnlyPlay) {
		this.isOnlyPlay = isOnlyPlay;
	}
}
