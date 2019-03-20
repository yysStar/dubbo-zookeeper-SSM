package com.qiyun.model.football;


import com.qiyun.util.NumberTools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SportteryFootballBetPercent {
	public static Map<String, String> getBetPrecent(MatchAwardOfSPF spfAward) {
		Map<String, String> returnPercentMap=new HashMap<String, String>();
		if(spfAward==null){
			return returnPercentMap;
		}
		Double tempHomeWin=spfAward.getDrawAward()*spfAward.getGuestWinAward();
		Double tempDrawWin=spfAward.getHomeWinAward()*spfAward.getGuestWinAward();
		Double tempGuestWin=spfAward.getHomeWinAward()*spfAward.getDrawAward();
		Double sum=tempDrawWin+tempGuestWin+tempHomeWin;
		returnPercentMap.put(spfAward.getMatchId() + "_hp", NumberTools.formatDouble(tempHomeWin/sum*100, 2) + "%");
		returnPercentMap.put(spfAward.getMatchId() + "_dp", NumberTools.formatDouble(tempDrawWin/sum*100, 2)  + "%");
		returnPercentMap.put(spfAward.getMatchId() + "_gp", NumberTools.formatDouble(tempGuestWin/sum*100, 2)  + "%");
		return returnPercentMap;
		
	}
	public static Double[] handelAwardArr(Double[] awardValueArr){
		Arrays.sort(awardValueArr);
		return awardValueArr;
	}
}
