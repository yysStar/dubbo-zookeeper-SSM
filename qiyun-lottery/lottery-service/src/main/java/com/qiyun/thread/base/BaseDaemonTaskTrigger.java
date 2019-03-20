package com.qiyun.thread.base;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseDaemonTaskTrigger implements DaemonTaskTrigger{

	private long nextRoundTime=0L;

	public final boolean isEnable() {
		return System.currentTimeMillis()>=nextRoundTime;
	}
	/**
	 * 延迟
	 * */
	protected final void delay(int sec){
		nextRoundTime=System.currentTimeMillis()+sec*1000;
	}
	protected final void delay(long millis){
		nextRoundTime=System.currentTimeMillis()+millis;
	}
	public final synchronized void  clearDelay(){
		nextRoundTime=0;
	}
	
	private Map<Integer,DaemonTaskLocker> lockers;
	private DaemonTaskLocker fetchLock(Integer subTaskId){
		if(lockers.containsKey(subTaskId))return lockers.get(subTaskId);
		DaemonTaskLocker locker=new DaemonTaskLocker();
		lockers.put(subTaskId, locker);
		return locker;
	}
	
	protected boolean subTaskEnable(Integer subTaskId){
		return fetchLock(subTaskId).enable();
	}
	
	private MyDaemon daemon;

	public void onStart(MyDaemon v){
		lockers=new HashMap<Integer,DaemonTaskLocker>();
		daemon=v;
		if(delay>0)delay(delay);
	}

	public void onEnd(){
		lockers=null;
	}
	
	protected final void execute(Integer subTaskId,DaemonTaskRunnable runable){
		runable.setLocker(fetchLock(subTaskId));
		daemon.execute(runable);
	}
	
	private int delay=0;
	public final void setDelay(int sec){delay=sec;}
	
	private int interval=0;
	public final void setInterval(int sec){interval=sec;}
	protected final int getInterval(){return interval;}
}
