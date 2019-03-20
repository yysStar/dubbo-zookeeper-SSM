package com.qiyun.checkBingo;

import com.qiyun.commonModel.PlayType;

import java.util.HashMap;


public interface BingoCheck extends Cloneable {

	/**
	 * 执行开奖处理
	 * 
	 */
	public void execute(String content, PlayType playType, int multiple, HashMap<String, String> openResultMap);

	/**
	 * 是否中奖
	 * 
	 * @return
	 */
	public boolean isBingo();

	/**
	 * 得到中奖结果内容 用于存进Ticket里面的bingoContent
	 * 
	 * @return
	 */
	public String getBingoContent();

	/**
	 * 得到中奖结果的HashMap 用于存进LotteryPlan里面prizeContent
	 * 
	 * @return
	 */
	public HashMap getBingoHashMap();

	/**
	 * 得到税前奖金
	 * 
	 * @return
	 */
	public double getBingoPretaxTotal();

	/**
	 * 得到税后奖金
	 * 
	 * @return
	 */
	public double getBingoPosttaxTotal();

	/**
	 * 合并结果,开奖的时候先开票，再把票的结果合并后传给LotteryPlan
	 * 
	 * @param otherCheck
	 */
	public void addCheck(BingoCheck otherCheck);

	public BingoCheck clone() throws CloneNotSupportedException;

}
