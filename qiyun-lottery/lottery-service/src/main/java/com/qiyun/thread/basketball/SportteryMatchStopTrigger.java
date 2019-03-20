package com.qiyun.thread.basketball;

import com.qiyun.grabber.model.AbstactMatch;
import com.qiyun.model.MatchStatus;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.service.BasketBallService;
import com.qiyun.service.DGService;
import com.qiyun.service.FootBallService;
import com.qiyun.thread.base.BaseDaemonTaskTrigger;
import com.qiyun.thread.base.DaemonTaskRunnable;
import com.qiyun.thread.base.MyDaemon;
import com.qiyun.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public abstract class SportteryMatchStopTrigger<X extends AbstactMatch> extends BaseDaemonTaskTrigger {
	private final static Integer SUB_TASK_ID=0;
	@Autowired
	private BasketBallService basketBallService;
	@Autowired
	private FootBallService footBallService;
	@Autowired
	private DGService dgService;

	private static final long maxSleepTime= 1*60*60*1000;//！！！休眠时间最多不超过1小时，防止后抓取到的对阵先截止

	private DaemonTaskRunnable runable;
	@Override
	public void onStart(MyDaemon v){
		super.onStart(v);
		runable= new SportteryMatchStopRunnable();
	}

	public void onTrigger() {
		if(!this.subTaskEnable(SUB_TASK_ID))return;
		this.execute(SUB_TASK_ID,runable);
	}
	
	private class SportteryMatchStopRunnable extends DaemonTaskRunnable{
		@Override
		protected void process() {
			try {
				// 处理过期对阵并计算睡觉时间
				long sleepTime = processTask();
				if(sleepTime > maxSleepTime )sleepTime = maxSleepTime;
				LogUtil.info("--"+ getLotteryName() +" 停售事件处理成功，实际将休眠:" + sleepTime / 1000 /60 + "分钟");
				delay(sleepTime);
			} catch (Exception e) {
				LogUtil.error("--"+ getLotteryName() +" 停售事件处理异常，10分钟后重试",e);
				delay(10*60);
			}
		}		
	}

	private long processTask() throws Exception {
		long sleepMilli = -1;
		int i = getForClass(getXClass());
		if(i == 0){
			throw new RuntimeException("类型错误");
		}
		switch (i) {
			case 1:
				//获取开售的比赛列表
				List<BasketBallMatch> matchs = basketBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());
				if (matchs != null && matchs.size() > 0) {
					for (BasketBallMatch race : matchs) {
						int dealTime = dgService.getDealTime();
						int fsaheadTime = dealTime * 60 * 1000;//分转毫秒
						Date endTime = getEndSaleTime(race.getMatchTime(), fsaheadTime);
						LogUtil.info("时间判断>>>>>>>" + race.getGuestTeam() + " 比赛时间:" + race.getMatchTime().toString()
								+ " 截止时间：" + endTime.toString());
						// 计算截止时间差
						long interval = endTime.getTime() - new Date().getTime();
						if (interval <= 0) {// 如果赛事截止
							race.setStatus(MatchStatus.SALEEND.ordinal());
							basketBallService.save(race);
						} else {
							sleepMilli = interval;
							// 比赛已按时间排序，这里找到第一个未截止的时间就行了
							break;
						}
					}
				}
				break;
			case 2:
				List<FootBallMatch> footBallMatches = footBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());
				if (footBallMatches != null && footBallMatches.size() > 0) {
					for (FootBallMatch race : footBallMatches) {
						int dealTime = dgService.getDealTime();
						int fsaheadTime = dealTime * 60 * 1000;//分转毫秒
						Date endTime = getEndSaleTime(race.getMatchTime(), fsaheadTime);
						LogUtil.info("时间判断>>>>>>>" + race.getGuestTeam() + " 比赛时间:" + race.getMatchTime().toString()
								+ " 截止时间：" + endTime.toString());
						// 计算截止时间差
						long interval = endTime.getTime() - new Date().getTime();
						if (interval <= 0) {// 如果赛事截止
							race.setStatus(MatchStatus.SALEEND.ordinal());
							footBallService.attachDirty(race);
						} else {
							sleepMilli = interval;
							// 比赛已按时间排序，这里找到第一个未截止的时间就行了
							break;
						}
					}
				}
				break;
		}
		return sleepMilli;
	}

	private int getForClass(Class<X> xClass){
		if(xClass == BasketBallMatch.class){
			return 1;
		} else if(xClass == FootBallMatch.class){
			return 2;
		}
		return 0;
	}

	protected abstract Date getEndSaleTime(Date matchTime, int aheadMilli) ;// 计算实际的截止时间
	// 取得彩种名称
	protected abstract String getLotteryName();
	protected abstract Class<X> getXClass();
}
