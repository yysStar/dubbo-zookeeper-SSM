package com.qiyun.thread.base;

public abstract class DaemonTaskRunnable implements Runnable {
	private DaemonTaskLocker locker;	
	public void setLocker(DaemonTaskLocker v){
		locker=v;
		locker.lock();
	}

	public final void run() {
		process();
		locker.release();
	}
	
	protected abstract void process();
}
