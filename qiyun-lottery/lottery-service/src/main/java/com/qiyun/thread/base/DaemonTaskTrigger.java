package com.qiyun.thread.base;

public interface DaemonTaskTrigger {
	String getName();
	boolean isEnable();
	void onStart(MyDaemon daemon);
	void onTrigger();
	void onEnd();
}
