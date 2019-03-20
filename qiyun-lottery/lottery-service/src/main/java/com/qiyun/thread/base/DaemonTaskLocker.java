package com.qiyun.thread.base;

public final class DaemonTaskLocker {
	private boolean flag=true;
	public synchronized boolean enable(){
		return flag;
	}
	
	public synchronized void lock(){
		flag=false;
	}
	
	public synchronized void release(){
		flag=true;
	}
}
