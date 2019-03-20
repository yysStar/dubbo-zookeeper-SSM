package com.qiyun.chaiPiao;


import com.qiyun.grabber.model.AbstactMatch;

import java.util.List;

public interface MatchInterface<X extends AbstactMatch> {
	List<X> getMatchList(String html, String statusHtml);

	List<X> getMatchResultList(String html);

	Integer getResultPage(String html);

	/**
	 * 获取赛果时 抓取单关的信息 包括单关sp/单关大小分/让分盘口
	 * @param html
	 * @return
	 */
	List<X> getSingleResultAward(String html);
	
	List<X> getRFofSingle(String html);

	List<X> getRFofPass(String html);

	List<X> getDXbaseofSingle(String html);

	List<X> getDXbaseofPass(String html);
	
	/**
	 * 获取赛果时,抓取过关的让分/大小分盘口
	 * @param html
	 * @return
	 */
	List<X> getPassResultPankou(String html);
}
