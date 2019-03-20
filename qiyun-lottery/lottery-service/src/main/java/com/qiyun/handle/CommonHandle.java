package com.qiyun.handle;


public class CommonHandle extends AbstractHandle {
	public void initWorkFlow(){
		// 设置事件处理流程
		hmStopEvent.setNextEvent(termStopEvent);
		termStopEvent.setNextEvent(terminalStopEvent);
		terminalStopEvent.setNextEvent(openPrizeEvent);
		openPrizeEvent.setNextEvent(hmStopEvent);
	}
}
