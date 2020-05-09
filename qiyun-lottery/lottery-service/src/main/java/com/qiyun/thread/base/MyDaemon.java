package com.qiyun.thread.base;

import com.qiyun.util.LogUtil;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 后台守护线程(单例)
 * 用于触发后台任务
 * */
public final class MyDaemon extends Thread {	
	private DaemonTaskTrigger[] triggers;
	private int triggerLength;
	public void setTriggers(List<DaemonTaskTrigger> v){
		triggerLength=v.size();
		triggers=new DaemonTaskTrigger[triggerLength];
		for(int i=0;i<triggerLength;i++)triggers[i]=v.get(i);		
	}
	private int threadPoolSize=4;
	public void setThreadPoolSize(int v){threadPoolSize=v;}
	
	private boolean keepRunningFlag=true;	
	private static final  ExecutorService threadPool=Executors.newCachedThreadPool();
	/**
	 * 执行任务
	 * **/
	public static void execute(Runnable runable){
		threadPool.execute(runable);
	}
	
	@Override
	public void run() {
		onStart();
		while(keepRunningFlag){
			try {
				onProcess();
				Thread.sleep(60000);
			} catch (Exception e) {
				LogUtil.error(e);}
		}
		onEnd();
	}
	protected void execute(DaemonTaskRunnable runable){
		threadPool.execute(runable);
	}
	/**
	 *销毁 
	 * */
	public void destroy(){
		keepRunningFlag=false;
	}
	
	private void onStart(){
		this.setName("全境守护者");
		//threadPool= Executors.newFixedThreadPool(threadPoolSize);
		LogUtil.info("%s线程启动,线程池大小:%d,共计%d个任务触发器.",this.getName(),threadPoolSize,triggerLength);
		for(int i=0;i<triggerLength;i++){
			DaemonTaskTrigger trigger=triggers[i];
			//LogUtil.info("===>任务触发器初始化:%s",trigger.getName());
			trigger.onStart(this);
		} 
	}
	
	private void onProcess(){
		GB.setLength(0);
		GB.append(this.getName()).append("-------------线程执行新一趟任务.");
		boolean enable=false;
		DaemonTaskTrigger trigger;
		long g=0;
		for(int i=0;i<triggerLength;i++){
			trigger=triggers[i];
			enable=trigger.isEnable();
			if(!enable)continue;
			GSTART();
			trigger.onTrigger();
			g=GEND();
			if(g>100)GB.append('[').append(trigger.getName()).append("]触发器执行完毕，耗时").append(g).append("毫秒\n");
		}
		LogUtil.info(GB.toString());
	}
	
	
	private void onEnd(){
		triggers=null;
		for(int i=0;i<triggerLength;i++){
			DaemonTaskTrigger trigger=triggers[i];
			//LogUtil.info("===>任务触发器停止:%s",trigger.getName());
			trigger.onEnd();
		} 
		LogUtil.info("%s线程停止",this.getName());
	}
	
	private long startTime; 
	private void GSTART(){startTime=System.currentTimeMillis();}
	private long GEND(){return System.currentTimeMillis()-startTime;}
	private StringBuilder GB=new StringBuilder(512);
}
