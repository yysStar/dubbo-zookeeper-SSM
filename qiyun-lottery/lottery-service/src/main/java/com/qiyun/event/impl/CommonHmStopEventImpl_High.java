package com.qiyun.event.impl;

import java.util.Map;


/**
 * 合买截止高频实现类
 * @author zhaofeng
 *
 */
public class CommonHmStopEventImpl_High extends AbstractHmStopEvent {

	public Map execute(Map request) {
		//不执行任何操作
		return request;
	}

}
