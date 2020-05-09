package com.qiyun.openResult;

import com.qiyun.model.LotteryTerm;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/* 获取开奖号码服务类
 * zf   2012-7-15
 */
public class OpenResultService {
	
	private HashMap<String, Snatcher> snatcherMap;

	public void setSnatcherMap(HashMap<String, Snatcher> snatcherMap) {
		this.snatcherMap = snatcherMap;
	}

	//取得开奖号码
	public LotteryTerm getOpenResult(LotteryTerm term) throws Exception{
		//取得抓取器
		Snatcher snatcher = snatcherMap.get(term.getLotteryType().getValue()+"");		
		return snatcher.getOpenResult(term);
	}
}
