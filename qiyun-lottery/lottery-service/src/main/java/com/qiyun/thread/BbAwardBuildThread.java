package com.qiyun.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.grabber.model.AwardListEnum;
import com.qiyun.grabber.model.PlatformEnum;
import com.qiyun.model.LotteryTypeProps;
import com.qiyun.model.MatchStatus;
import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.*;
import com.qiyun.service.*;
import com.qiyun.tools.DateTools;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.TimeTools;
import com.qiyun.utils.basketball.SportteryGrabberUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BbAwardBuildThread extends Thread {
	private static transient Log log = LogFactory.getLog(BbAwardBuildThread.class);
	@Autowired
	private BasketBallService basketBallService;
	@Autowired
	private LotteryTypePropsService lotteryTypePropsService;
	@Autowired
	private BasketballDataService basketballDataService;
	@Autowired
	private BasketTeamService basketTeamService;

	private long sleepTime = 120000;
	private boolean isRun = true;

	@Override
	public void run() {
		try {
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			LogUtil.error(e);
		}
		while (true) {
			try {
				if (isRun) {
					snatchNewMatch();
					// 拿到对阵先,组装一下MATCH，拿到所有对阵的intTime_lineId值
					//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
					List<BasketBallMatch> matchs = basketBallService.findMatchByStatus(MatchStatus.ONSALE.ordinal());
					Map<Integer, List<BasketBallMatch>> matchMap = new HashMap<Integer, List<BasketBallMatch>>();
					Map<String, Integer> matchIdMap = new HashMap<String, Integer>();
					if (!matchs.isEmpty()) {
						for (BasketBallMatch match : matchs) {
							Integer intTime = match.getIntTime();
							List<BasketBallMatch> matchList = matchMap.get(intTime);
							if (matchList == null)
								matchList = new ArrayList<BasketBallMatch>();
							matchList.add(match);
							matchMap.put(intTime, matchList);
							Integer lineId = match.getLineId();
							matchIdMap.put(intTime + "_" + lineId, match.getId());
						}
						buildAwardInfo(matchIdMap, LotteryType.JC_LQ_DXF);
						buildAwardInfo(matchIdMap, LotteryType.JC_LQ_SF);
						buildAwardInfo(matchIdMap, LotteryType.JC_LQ_RFSF);
						buildFcawardInfo(matchMap, matchIdMap, LotteryType.JC_LQ_SFC);
						//盘口信息已经与SP同时获取.不需要另外方法
//						savaDataInFile(matchMap, matchs);
					} else {
						log.info("抓取对阵为空，返回");
					}
				}
			} catch (Exception e) {
				LogUtil.error(e);
			}
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				LogUtil.error(e);
			}
		}
	}
	
	/**
	 * 抓取新的对阵,更新对阵缩写
	 * 如果缩写表存在: 更新对阵表缩写.
	 * 如果缩写表不存在: 则用全称代替缩写,更新缩写表和对阵表
	 */
	public void snatchNewMatch() {
		LogUtil.info("----------竞彩篮球自动维护线程抓取新赛事开始-----------");
		try {
			Set<Integer> intTimeSet =new HashSet<Integer>();
			//得到抓取的数据
			List<BasketBallMatch> bballList = SportteryGrabberUtil.getMatchList(PlatformEnum.BASKETBALL.name());
			for (BasketBallMatch ms : bballList) {
				intTimeSet.add(ms.getIntTime());
			}
			//根据抓取到的intTimeSet查数据库中的数据
			//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
			List<BasketBallMatch> dbMatchs = this.basketBallService.getMatchListByIntTime(intTimeSet);
			
			Map<String, BasketBallMatch> dbMap = new HashMap<String, BasketBallMatch>();
			dbMap = arrangeListToMap(dbMatchs);
			
			//数据库不存在.把抓取到的放入数据库map
			for (BasketBallMatch ms : bballList) {
				String msKey=ms.getMapKey();
				if (dbMap.containsKey(msKey)) {
					 if(dbMap.get(msKey).getStatus() == 0) {//对阵为正常销售情况下，才更新状态
						 dbMap.get(msKey).setShowNum(ms.getShowNum());
					 }
				}else{
					LogUtil.info("---竞彩篮球抓取赛程:"+msKey+"--主队VS客队:"+ms.getHomeTeam()+"vs"+ms.getGuestTeam()
							+";比赛时间:"+ DateTools.dateToString(ms.getMatchTime())+";让分:"+ms.getHandicap()
							+";大小分:"+ms.getBaseBigOrSmall()+"---");
					dbMap.put(msKey, ms);
				}
			}
			/** 新的容器* */
			LotteryTypeProps props = lotteryTypePropsService.findById(LotteryType.JC_LQ_SF.getValue());
			List<BasketBallMatch> arrangeList = new ArrayList<BasketBallMatch>();
			for (Entry<String, BasketBallMatch> entry : dbMap.entrySet()) {
				BasketBallMatch match =entry.getValue();
				//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
				BasketBallTeam guestTeam = basketTeamService.getTeamInfoByFullName(match.getGuestTeam().trim());
				//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
				BasketBallTeam homeTeam = basketTeamService.getTeamInfoByFullName(match.getHomeTeam().trim());
				// 客队
				if (guestTeam != null) {
					match.setShortGuestTeam(guestTeam.getShortTeamName());
				}
				// 主队
				if (homeTeam != null) {
					match.setShortHomeTeam( homeTeam.getShortTeamName());
				}
				
				if(TimeTools.getBbEndSaleTime(match.getMatchTime(), props.getDsAheadTime()).getTime() <= System.currentTimeMillis()) {
					match.setStatus(MatchStatus.SALEEND.ordinal());
				}
				arrangeList.add(match);
			}
			basketBallService.attachDirty(arrangeList);
		} catch (Exception e) {
			LogUtil.error(e);
		}
		LogUtil.info("----------竞彩篮球自动维护线程抓取新赛事结束-----------");
	}
	public Map<String, BasketBallMatch> arrangeListToMap(List<BasketBallMatch> arrangeList) {
		Map<String, BasketBallMatch> arrangeMap = new LinkedHashMap<String, BasketBallMatch>();
		for (BasketBallMatch b : arrangeList) {
			arrangeMap.put(b.getMapKey(), b);
		}
		return arrangeMap;
	}

	public void buildAwardInfo(Map<String, Integer> matchIdMap, LotteryType lType) {
		log.info("开始执行" + lType.getName() + "玩法保存奖金值任务");
		AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
		List<PassMode> pmList = new ArrayList<PassMode>();
		pmList.add(PassMode.SINGLE);
		pmList.add(PassMode.PASS);
		for (PassMode pm : pmList) {
			// 拿到抓取过来的奖金值
			List<SFAward> tempAwardList = SportteryGrabberUtil.getAwardList(lType, (byte) pm.ordinal());
			if (!tempAwardList.isEmpty()) {
				for (SFAward tempAward : tempAwardList) {
					Integer intTime = tempAward.getIntTime();
					Integer lineId = tempAward.getLineId();
					if (matchIdMap.get(intTime + "_" + lineId) != null) {
						//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
						SFAward award = basketBallService.getAwardSpecial(intTime, lineId, pm, en);
						if (award == null) {
							tempAward.setWinOrBigChange(0);
							tempAward.setLoseOrSmallChange(0);
							tempAward.setBsChange(0);
							tempAward.setBsUpdateTime(new Date());
							tempAward.setHandicapChange(0);
							tempAward.setHandUpdateTime(new Date());
						} else {
							Double winOrBigAward = award.getWinOrBigAward();
							Double tempWinOrBigAward = tempAward.getWinOrBigAward();
							Double loseOrSmall=award.getLoseOrSmallAward();
							Double tempLoseOrSmall=tempAward.getLoseOrSmallAward();
							if (loseOrSmall.equals(tempLoseOrSmall)&&tempWinOrBigAward.equals(winOrBigAward) && tempAward.getHandicap().equals(award.getHandicap()) && tempAward.getBaseBigOrSmall().equals(award.getBaseBigOrSmall())) {
								continue;
							}
							int winOrBigChange = getSWchange(tempWinOrBigAward, winOrBigAward);
							int loseOrSmallChange = getSWchange(tempAward.getLoseOrSmallAward(), award.getLoseOrSmallAward());
							tempAward.setWinOrBigChange(winOrBigChange);
							tempAward.setLoseOrSmallChange(loseOrSmallChange);
							int bsChange=getSWchange(tempAward.getBaseBigOrSmall(), award.getBaseBigOrSmall());
							int handicapChange=getSWchange(tempAward.getHandicap(),award.getHandicap());
							tempAward.setBsChange(bsChange);
							tempAward.setHandicapChange(handicapChange);
							tempAward.setBsUpdateTime(new Date());
							tempAward.setHandUpdateTime(new Date());
						}
						tempAward.setMatchId(matchIdMap.get(intTime + "_" + lineId));
						tempAward.setLastUpdateTime(new Date());
						basketBallService.saveAward(tempAward, en);
					}

				}
			}
		}
		log.info("执行" + lType.getName() + "玩法保存奖金值任务完成");
	}

	public void buildFcawardInfo(Map<Integer, List<BasketBallMatch>> matchMap, Map<String, Integer> matchIdMap, LotteryType lType) {
		log.info("开始执行" + lType.getName() + "玩法保存奖金值任务");
		AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
		if (!matchMap.keySet().isEmpty()) {
			// 数据库中的奖金值
			//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
			List<AbstractAward> awardList = basketBallService.getAwardListByIntTimeListAndPlayType(matchMap.keySet(), lType);
			Map<String, AbstractAward> awardMap = new HashMap<String, AbstractAward>();
			for (AbstractAward award : awardList) {
				String key = award.getIntTime() + "_" + award.getLineId() + "_" + award.getPassMode();
				awardMap.put(key, award);
			}
			// 拿到抓取过来的奖金值
			List<AbstractAward> tempAwardList = new ArrayList<AbstractAward>();
			for (byte i = 0; i <= 1; i++) {
				List<AbstractAward> temp = SportteryGrabberUtil.getAwardList(lType, i);
				tempAwardList.addAll(temp);
			}
			// 遍历容器，与数据中的对象进行比较，如果有，则更新，无则插入
			for (AbstractAward s : tempAwardList) {
				String key = s.getIntTime() + "_" + s.getLineId() + "_" + s.getPassMode();
				AbstractAward tempAward = awardMap.get(key);
				Integer matchId = matchIdMap.get(s.getIntTime() + "_" + s.getLineId());
				if (tempAward == null) {
					if (matchId != null) {
						s.setMatchId(matchId);
						s.setLastUpdateTime(new Date());
						this.basketBallService.saveAward(s, en);
					}
				} else {
					tempAward.setAwardArr(s.getAwardArr());
					tempAward.setLastUpdateTime(new Date());
					this.basketBallService.saveAward(tempAward, en);
				}
			}
		}
		log.info("执行" + lType.getName() + "玩法保存奖金值任务完成");
	}

	public void buildRfBaseInfo(Map<String, Integer> matchIdMap, LotteryType lType) {
		log.info("开始执行" + lType.getName() + "玩法保存过关让分胜负基数任务");
		AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
		// 拿到抓取过来的让分胜负基数
		List<BasketBallMatch> tempRfBaseList = SportteryGrabberUtil.getRFList("BASKETBALL", (byte) PassMode.PASS.ordinal());
		if (!tempRfBaseList.isEmpty()) {
			for (BasketBallMatch tempMatch : tempRfBaseList) {
				Integer intTime = tempMatch.getIntTime();
				Integer lineId = tempMatch.getLineId();
				if (matchIdMap.get(intTime + "_" + lineId) != null) {
					//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
					SFAward award = basketBallService.getAwardSpecial(intTime, lineId, PassMode.PASS, en);
					SFAward tempAward = new SFAward();
					if (award == null) {
						continue;
					} else {
						if (award.getHandicap() == null) {
							award.setHandicap(tempMatch.getHandicap());
							award.setHandicapChange(0);
							award.setHandUpdateTime(new Date());
							basketBallService.saveAward(award, en);
						} else {
							if (Math.abs(tempMatch.getHandicap() - award.getHandicap()) < 0.00001) {
								continue;
							}
							int handicapChange = getSWchange(tempMatch.getHandicap(), award.getHandicap());
							tempAward.setHandicap(tempMatch.getHandicap());
							tempAward.setHandicapChange(handicapChange);
							tempAward.setHandUpdateTime(new Date());
							tempAward.setIntTime(intTime);
							tempAward.setLineId(lineId);
							tempAward.setWinOrBigAward(award.getWinOrBigAward());
							tempAward.setWinOrBigChange(0);
							tempAward.setLoseOrSmallAward(award.getLoseOrSmallAward());
							tempAward.setLoseOrSmallChange(0);
							tempAward.setLastUpdateTime(award.getLastUpdateTime());
							tempAward.setMatchId(award.getMatchId());
							tempAward.setPassMode(PassMode.PASS.ordinal());
							tempAward.setPlayType(AwardListEnum.SFRFAWARD.ordinal());
							basketBallService.saveAward(tempAward, en);
						}
					}
				}

			}
		}
		log.info("执行" + lType.getName() + "玩法保存过关让分胜负基数任务完成");
	}

	public void buildDxfBaseInfo(Map<String, Integer> matchIdMap, LotteryType lType) {
		log.info("开始执行" + lType.getName() + "玩法保存过关大小分基数任务");
		AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
		// 拿到抓取过来的过关大小分基数
		List<BasketBallMatch> tempDxBaseList = SportteryGrabberUtil.getDXbaseList("BASKETBALL", (byte) PassMode.PASS.ordinal());
		if (!tempDxBaseList.isEmpty()) {
			for (BasketBallMatch tempMatch : tempDxBaseList) {
				Integer intTime = tempMatch.getIntTime();
				Integer lineId = tempMatch.getLineId();
				if (matchIdMap.get(intTime + "_" + lineId) != null) {
					SFAward award = basketBallService.getAwardSpecial(intTime, lineId, PassMode.PASS, en);
					SFAward tempAward = new SFAward();
					if (award == null) {
						continue;
					} else {
						if (award.getBaseBigOrSmall() == null) {
							award.setBaseBigOrSmall(tempMatch.getBaseBigOrSmall());
							award.setBsChange(0);
							award.setBsUpdateTime(new Date());
							basketBallService.saveAward(award, en);
						} else {
							if (Math.abs(tempMatch.getBaseBigOrSmall() - award.getBaseBigOrSmall()) < 0.00001) {
								continue;
							}
							int bsChange = getSWchange(tempMatch.getBaseBigOrSmall(), award.getBaseBigOrSmall());
							tempAward.setBaseBigOrSmall(tempMatch.getBaseBigOrSmall());
							tempAward.setBsChange(bsChange);
							tempAward.setBsUpdateTime(new Date());
							tempAward.setIntTime(intTime);
							tempAward.setLineId(lineId);
							tempAward.setWinOrBigAward(award.getWinOrBigAward());
							tempAward.setWinOrBigChange(0);
							tempAward.setLoseOrSmallAward(award.getLoseOrSmallAward());
							tempAward.setLoseOrSmallChange(0);
							tempAward.setLastUpdateTime(award.getLastUpdateTime());
							tempAward.setMatchId(award.getMatchId());
							tempAward.setPassMode(PassMode.PASS.ordinal());
							tempAward.setPlayType(AwardListEnum.DXF.ordinal());
							basketBallService.saveAward(tempAward, en);
						}
					}
				}

			}
		}
		log.info("执行" + lType.getName() + "玩法保存过关大小分基数任务完成");
	}

//	@SuppressWarnings("unchecked")
//	public void savaDataInFile(Map<Integer, List<BasketBallMatch>> matchMap, List<BasketBallMatch> matchList) {
//
//		log.info("执行奖金值写入文件任务开始");
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		Map<Integer, BasketballYp> ypDataMap = basketballDataService.getYpData(MatchStatus.ONSALE.ordinal());
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		Map<Integer, BasketballDxp> dxpDataMap = basketballDataService.getDxpData(MatchStatus.ONSALE.ordinal());
//		//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//		Map<Integer, BasketballOp> opDataMap = basketballDataService.getOpData(MatchStatus.ONSALE.ordinal());
//
//		Map<String, String> ypMap = new HashMap<String, String>();
//		Map<String, String> dxpMap = new HashMap<String, String>();
//		Map<String, String> opMap = new HashMap<String, String>();
//
//		for (BasketBallMatch match : matchList) {
//			BasketballYp yp = ypDataMap.get(match.getId());
//			if (yp != null) {
//				ypMap.putAll(yp.getJsonMap(match));
//			}
//
//			BasketballDxp dxp = dxpDataMap.get(match.getId());
//			if (dxp != null) {
//				dxpMap.putAll(dxp.getJsonMap(match));
//			}
//			BasketballOp op = opDataMap.get(match.getId());
//			if (op != null) {
//				opMap.putAll(op.getJsonMap(match));
//			}
//		}
//
//		List<PassMode> pmList = new ArrayList<PassMode>();
//		pmList.add(PassMode.SINGLE);
//		pmList.add(PassMode.PASS);
//		List<LotteryType> typeList = LotteryType.JCLQList;
//
//		for (LotteryType lotteryType : typeList) {
//			// 获得文件中的投注比 用于计算亚盘跟大小盘的盈利比
//			Map<String, String> tzbMap = new HashMap<String, String>();
//			Map<String, String> ypYlbMap = new HashMap<String, String>();
//			Map<String, String> dxpYlbMap = new HashMap<String, String>();
//			int typeValue = lotteryType.getValue();
//			if (typeValue == 32)
//				typeValue = 31;
//			String tzbKey = typeValue + "_" + DateTools.getNowDateYYYY_MM_DD();
//			try {
//				String tzbContent = FileTools.getFileContent(WebConstants.getWebPath()
//						+ "/static/basketball/tzb_" + tzbKey + ".json");
//				tzbMap = new com.cailele.ajax.json.JSONObject(tzbContent).getMap();
//			} catch (Exception e) {
//				LogUtil.error(e);
//			}
//
//			// 亚盘.大小盘的盈利比
//			for (BasketBallMatch bb : matchList) {
//				if (typeValue == 31) {
//					BasketballYp yp = ypDataMap.get(bb.getId());
//					String key = "tzb_" + bb.getIntTime() + "_" + bb.getLineId();
//					String[] tzbArr = { tzbMap.get(key + "_1"), tzbMap.get(key + "_0") };
//					if (yp != null) {
//						ypYlbMap.putAll(yp.getYlb(bb, tzbArr));// 亚盘盈利比
//					}
//				} else if (typeValue == 33) {
//					BasketballDxp dxp = dxpDataMap.get(bb.getId());
//					String key = "tzb_" + bb.getIntTime() + "_" + bb.getLineId();
//					String[] tzbArr = { tzbMap.get(key + "_1"), tzbMap.get(key + "_0") };
//					if (dxp != null) {
//						dxpYlbMap.putAll(dxp.getYlb(bb, tzbArr));// 大小球盈利比
//					}
//				}
//
//			}
//
//			for (PassMode pm : pmList) {
//				Map<String, String> awardMap = new HashMap<String, String>();
//				Integer lType = AwardListEnum.enumOfAwardByLotteryType(lotteryType).ordinal();
//				if (lType != 1) {
//					//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//					List<SFAward> awardList = basketBallService.findForBbAward(MatchStatus.ONSALE.ordinal(), lType, pm.ordinal());
//					for (SFAward award : awardList) {
//						if (award != null) {
//							awardMap.putAll(award.getJsonMap());// 奖金值
//						}
//					}
//
//					// 过关：计算投注比用单关的奖金值 欧赔
//					List<SFAward> tzbAwardList = awardList;
//					if (pm == PassMode.PASS) {
//						tzbAwardList.clear();
//						//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//						tzbAwardList = basketBallService.findForBbAward(MatchStatus.ONSALE.ordinal(), lType, PassMode.SINGLE.ordinal());
//					}
//					for (SFAward award : tzbAwardList) {
//						if (award != null) {
//							if (lType == 0) {
//								BasketballOp op = opDataMap.get(award.getMatchId());
//								if (op != null) {
//									awardMap.putAll(op.getYlb(award));// 欧盘盈利比
//								}
//							}
//						}
//					}
//
//					if (lType == 2) {
//						awardMap.putAll(ypMap);// 亚盘数据
//						awardMap.putAll(ypYlbMap);// 亚盘盈利比数据
//					} else if (lType == 0) {
//						awardMap.putAll(opMap);// 欧盘数据
//					} else {
//						awardMap.putAll(dxpMap);// 大小球数据
//						awardMap.putAll(dxpYlbMap);// 大小球盈利比数据
//					}
//				} else {
//					//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
//					List<SFCAward> awardList = basketBallService.getAwardListByIntTimeListAndPlayTypePassMode(matchMap.keySet(), lotteryType, pm);
//					for (SFCAward award : awardList) {
//						if (award != null) {
//							awardMap.putAll(award.getJsonMap());// 奖金值
//						}
//					}
//					awardMap.putAll(ypMap);// 亚盘数据
//					awardMap.putAll(ypYlbMap);// 亚盘盈利比数据
//				}
//				String temkey = "PASS";
//				if (pm == PassMode.SINGLE) {
//					temkey = "SINGLE";
//				}
//				String key = lotteryType.getValue() + "_" + temkey;
//				JSONObject infoJson = JSONObject.fromObject(awardMap);
//				try {
//					FileTools.setFileContent(infoJson.toString(), WebConstants.getWebPath() + "/static/basketball/" + key + ".json");
//				} catch (Exception e) {
//					LogUtil.error(e);
//				}
//			}
//		}
//		log.info("执行奖金值写入文件任务结束");
//
//	}

	public int getSWchange(Double d1, Double d2) {
		if (d1 > d2) {
			return 1;
		} else if (d1 < d2) {
			return -1;
		} else {
			return 0;
		}
	}

	public void buildRfBaseOldInfo(List<BasketBallMatch> matchList, LotteryType lType) {
		log.info("开始执行" + lType.getName() + "玩法保存历史过关让分胜负基数任务");

		AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
		for (BasketBallMatch tempMatch : matchList) {
			Integer intTime = tempMatch.getIntTime();
			Integer lineId = tempMatch.getLineId();
			//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
			SFAward award = basketBallService.getAwardSpecial(intTime, lineId, PassMode.PASS, en);
			if (award == null) {
				continue;
			} else {
				if (award.getHandicap() == null && tempMatch.getHandicap() != null) {
					award.setHandicap(tempMatch.getHandicap());
					award.setHandicapChange(0);
					award.setHandUpdateTime(new Date());
					basketBallService.saveAward(award, en);
				}
			}
		}
		log.info("执行" + lType.getName() + "玩法保存历史过关让分胜负基数任务完成");
	}

	public void buildDxfBaseOldInfo(List<BasketBallMatch> matchList, LotteryType lType) {
		log.info("开始执行" + lType.getName() + "玩法保存历史过关大小分基数任务");
		AwardListEnum en = AwardListEnum.enumOfAwardByLotteryType(lType);
		for (BasketBallMatch tempMatch : matchList) {
			Integer intTime = tempMatch.getIntTime();
			Integer lineId = tempMatch.getLineId();
			//CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
			SFAward award = basketBallService.getAwardSpecial(intTime, lineId, PassMode.PASS, en);
			if (award == null) {
				continue;
			} else {
				if (award.getBaseBigOrSmall() == null && tempMatch.getBaseBigOrSmall() != null) {
					award.setBaseBigOrSmall(tempMatch.getBaseBigOrSmall());
					award.setBsChange(0);
					award.setBsUpdateTime(new Date());
					basketBallService.saveAward(award, en);
				}
			}
		}
		log.info("执行" + lType.getName() + "玩法保存历史过关大小分基数任务完成");
	}
}
