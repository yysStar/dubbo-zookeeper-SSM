package com.qiyun.level;

import java.util.HashMap;

public class LevelFactory {

	private HashMap<String, HmLevel> levelMap;

	public boolean level(int lotteryType, String term) {
		HmLevel hm = levelMap.get(lotteryType+"");
		if (hm == null) {
			return false;
		}

		return hm.level(lotteryType,term);
	}

	public void setLevelMap(HashMap<String, HmLevel> levelMap) {
		this.levelMap = levelMap;
	}

}
