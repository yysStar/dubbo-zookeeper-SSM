package com.qiyun.builder;

public interface Builder {
	
	/**
	 * 生成简单遗漏文件，主要在开奖事件中调用.
	 * @param term
	 */
	public void execute(String term);
	
	/**
	 * 刷新走势图，主要给走势图应用调用.
	 * @param lotteryType
	 * @param term
	 * @param isRebuild
	 */
	public void excuteZSTProcess(final Integer lotteryType, final String term);
	
	/**
	 * 生成复杂遗漏文件xml及刷新遗漏，主要给遗漏应用调用.
	 * @param lotteryType
	 * @param term
	 * @param isRebuild  是否重算
	 * @param isRestore  是否修复
	 * @param backupName 备份目录名
	 */
	public void excuteMissProcess(final Integer lotteryType, final String term, boolean isRebuild, boolean isRestore, String backupName);
}
