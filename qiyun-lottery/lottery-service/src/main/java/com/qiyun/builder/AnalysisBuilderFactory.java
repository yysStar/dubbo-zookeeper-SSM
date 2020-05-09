package com.qiyun.builder;

import java.util.HashMap;

public class AnalysisBuilderFactory {

	private HashMap<String, Builder> BuilderMap;
	
	/**
	 * 在开奖事件中调用(builder购彩页面的号码遗漏和开奖号码).
	 * @param lotteryType
	 * @param term
	 */
	public void builder(int lotteryType,String term) {
		Builder b = BuilderMap.get(lotteryType+"");
		if (b != null)
			b.execute(term);
	}
	
	/**
	 * 在走势图应用调用(刷新走势图).
	 * @param lotteryType
	 * @param term
	 */
	public void builderZST(Integer lotteryType, String term) {
		final Builder b = BuilderMap.get(lotteryType);
		if (b != null)
			b.excuteZSTProcess(lotteryType,term);
	}
	
	/**
	 * 在遗漏应用调用(builder负责遗漏xml文件及刷新遗漏).
	 * @param lotteryType
	 * @param term
	 * @param isRebuild  是否重算
	 * @param isRestore  是否修复
	 * @param backupName 备份目录名
	 */
	public void builderMiss(Integer lotteryType, String term,boolean isRebuild,boolean isRestore,String backupName) {
		final Builder b = BuilderMap.get(lotteryType);
		if (b != null)
			b.excuteMissProcess(lotteryType,term,isRebuild,isRestore,backupName);
	}
	
	public void setBuilderMap(HashMap<String, Builder> builderMap) {
		BuilderMap = builderMap;
	}

	public HashMap<String, Builder> getBuilderMap() {
		return BuilderMap;
	}
}
