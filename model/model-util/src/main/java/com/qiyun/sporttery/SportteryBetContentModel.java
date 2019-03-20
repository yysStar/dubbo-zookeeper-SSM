package com.qiyun.sporttery;

import com.qiyun.intface.ExtensionCombCallBack;


import com.qiyun.item.MatchItem;
import com.qiyun.type.SportteryPassType;
import com.qiyun.util.ExtensionMathUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SportteryBetContentModel<X extends MatchItem> implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<X> matchItems;
	private Integer passMode;
	private List<SportteryPassType> passTypes;
	private int multiple;
	private boolean isOnlyPlay;

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

	public List<SportteryPassType> getPassTypes() {
		return passTypes;
	}

	public void setPassTypes(List<SportteryPassType> passTypes) {
		this.passTypes = passTypes;
	}

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}
	
	public boolean getIsOnlyPlay() {
		return isOnlyPlay;
	}

	public void setIsOnlyPlay(boolean isOnlyPlay) {
		this.isOnlyPlay = isOnlyPlay;
	}
	
	public void setOnlyPlay(boolean isOnlyPlay) {
		this.isOnlyPlay = isOnlyPlay;
	}

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
		for (SportteryPassType passType : passTypes) {
			int passCount = passType.getPassMatchs()[0];
			if (passCount < sheDanMatch.size())
				throw new RuntimeException("设胆错误");
			ExtensionMathUtils.efficientCombExtension(passCount, sheDanMatch.size(), unDanMatch.size(), new ExtensionCombCallBack() {
				public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
					Integer tempCount = 1;
					for (int i = 0; i < comb1.length; i++) {
						if (comb1[i]){
							tempCount *= sheDanMatch.get(i);
						}
					}
					for (int i = 0; i < comb2.length; i++) {
						if (comb2[i]){
							tempCount *= unDanMatch.get(i);
						}
					}
					
					result.add(tempCount);
				}
			});
		}
		for (Integer r : result) {
			count += r;
		}
		return count;
	}
	
	// 计算混投注数
	public int countHtUnit() {
		int count = 0;
		final List<Integer> sheDanMatch = new ArrayList<Integer>();
		final List<Integer> unDanMatch = new ArrayList<Integer>();
		final List<X> shdDanList = new ArrayList<X>();
		final List<X> undDanList = new ArrayList<X>();
		int sheDanTotal = 0;
		for (X x : matchItems) {// 找出设胆和非设胆的
			List<SportteryOption> sportteryOptionList = new ArrayList<SportteryOption>();
			for(SportteryOption sportteryOption : x.getOptions()){
				sportteryOptionList.add(sportteryOption);
			}
			
			for(SportteryOption sportteryOption : sportteryOptionList){
				List<SportteryOption> list = new ArrayList<SportteryOption>();
				list.add(sportteryOption);
				X fb = (X) new MatchItem();
				
				fb.setIntTime(x.getIntTime());
				fb.setLineId(x.getLineId());
				fb.setOptions(list);
				fb.setShedan(x.isShedan());
				if(x.isShedan()){
					shdDanList.add(fb);
				}else{
					undDanList.add(fb);
					unDanMatch.add(1);
				}
			}
			
			if(x.isShedan()){
				sheDanMatch.add(sportteryOptionList.size());
				sheDanTotal += sportteryOptionList.size();
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		for (final SportteryPassType passType : passTypes) {
			int passCount = passType.getPassMatchs()[0];
			if (passCount < sheDanMatch.size())
				throw new RuntimeException("设胆错误");
			if(sheDanMatch.size()>0){
				result = this.getHtSheDanCount(passCount,sheDanMatch,unDanMatch,shdDanList,undDanList,passType,result,sheDanTotal);
			}else{
				result = this.getHtUnDanCount(passCount,sheDanMatch,unDanMatch,shdDanList,undDanList,passType,result);
			}
		}
		for (Integer r : result) {
			count += r;
		}
		return count;
	}
	
	@SuppressWarnings("unused")
	private List<Integer> getHtSheDanCount(int passCount,final List<Integer> sheDanMatch,final List<Integer> unDanMatch,
			final List<X> sheDanList,final List<X> undDanList,final SportteryPassType passType,final List<Integer> result,final int sheDanTotal){
		final Map<Integer,List<X>> danMatchs = new HashMap<Integer,List<X>>();
		
		ExtensionMathUtils.efficientCombExtension(sheDanMatch.size(), 0, sheDanTotal, new ExtensionCombCallBack() {
			public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
				List<String> list = new ArrayList<String>();
				List<X> danList = new ArrayList<X>();
				for (int i = 0; i < comb2.length; i++) {
					String intTime = String.valueOf(sheDanList.get(i).getIntTime());
					String lineId = String.valueOf(sheDanList.get(i).getLineId());
					String key = intTime+""+lineId;
					if (comb2[i] && !list.contains(key)){
						list.add(key);
						danList.add(sheDanList.get(i));
					}
				}
				if(danList.size() == sheDanMatch.size()){
					danMatchs.put(danMatchs.size()+1, danList);
				}
			}
		});
		
		ExtensionMathUtils.efficientCombExtension(passCount, sheDanMatch.size(), unDanMatch.size(), new ExtensionCombCallBack() {
			public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
				List<String> unDanList = new ArrayList<String>();
				
				for (Integer danKey : danMatchs.keySet()) {

					List<String> list = new ArrayList<String>();
					
					List<X> tempMatchs = new ArrayList<X>();
							
					tempMatchs.addAll(danMatchs.get(danKey));
					
					for (int i = 0; i < comb2.length; i++) {
						String intTime = String.valueOf(undDanList.get(i).getIntTime());
						String lineId = String.valueOf(undDanList.get(i).getLineId());
						String key = intTime + "" + lineId;
						if (comb2[i] && !list.contains(key)) {
							list.add(key);
							tempMatchs.add(undDanList.get(i));
						}
					}

					boolean isOnly = getOnlyPlay(tempMatchs, passType);

					if (isOnly && tempMatchs.size() > passType.getPassMatchs()[0] - 1) {
						result.add(1);
					}
				}
			}
		});
		return result;
	}
	
	@SuppressWarnings("unused")
	private List<Integer> getHtUnDanCount(int passCount,final List<Integer> sheDanMatch,final List<Integer> unDanMatch,
			final List<X> shdDanList,final List<X> undDanList,final SportteryPassType passType,final List<Integer> result){
		
		ExtensionMathUtils.efficientCombExtension(passCount, sheDanMatch.size(), unDanMatch.size(), new ExtensionCombCallBack() {
			public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
				List<X> tempMatchs = new ArrayList<X>();
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < comb2.length; i++) {
					String intTime = String.valueOf(undDanList.get(i).getIntTime());
					String lineId = String.valueOf(undDanList.get(i).getLineId());
					String key = intTime+""+lineId;
					if (comb2[i] && !list.contains(key)){
						list.add(key);
						tempMatchs.add(undDanList.get(i));
					}
				}
				
				boolean isOnly = getOnlyPlay(tempMatchs,passType);
			
				if(isOnly && tempMatchs.size()>passType.getPassMatchs()[0]-1){
					Integer tempCount = 1;
					for (int i = 0; i < comb2.length; i++) {
						if (comb2[i]){
							tempCount *= unDanMatch.get(i);
						}
					}
					result.add(tempCount);
				}
			}
		});
		return result;
	}
	
	
	//判断是否为单一玩法
	@SuppressWarnings("unused")
	private boolean getOnlyPlay(List<X> tempMatchs,SportteryPassType passType){
		Map<String, Integer> lotteryTypeMap = new HashMap<String, Integer>();
		boolean isOnly = true;
		
		if(isOnlyPlay){
			for(X x : tempMatchs){
				for (SportteryOption sportteryOption : x.getOptions()) {
					if (lotteryTypeMap.containsKey(sportteryOption.getType())) {
						Integer typeNum = lotteryTypeMap.get(sportteryOption.getType()) + 1;
						lotteryTypeMap.put(sportteryOption.getType(), typeNum);
					} else {
						lotteryTypeMap.put(sportteryOption.getType(), 1);
					}
				}
			}
			
			for (String key : lotteryTypeMap.keySet()) {
				if (passType.getPassMatchs()[0] <= lotteryTypeMap.get(key)) {
					isOnly = false;
				}
			}
		}
		return isOnly;
	}
	
	
}
