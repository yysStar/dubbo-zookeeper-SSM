package com.qiyun.bonus;

import com.qiyun.commonModel.PlayType;
import com.qiyun.intface.CombCallBack;
import com.qiyun.intface.ExtensionCombCallBack;
import com.qiyun.util.ArithUtil;
import com.qiyun.util.ExtensionMathUtils;
import com.qiyun.util.MathUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AwardDetailYc {

	/**
	 * 过滤出每场次的 最大/最小值 (混投玩法)
	 * 
	 * @param matchItem
	 * @return
	 */
	protected abstract List<AwardOptionComineVo> getMinAndMaxVo(Sporttery3GMatchItem matchItem);

	/**
	 * 通过这个计算偏移量
	 * 
	 * @return
	 */
	protected abstract int getPtOffset();

	/**
	 * 过滤出每场次的 最大/最小值(单一玩法)
	 * 
	 * @param matchItem
	 * @return
	 */
	protected List<AwardOptionComineVo> getMinAndMaxVoSingle(Sporttery3GMatchItem matchItem) {
		AwardOptionComineVo maxVo = new AwardOptionComineVo();
		AwardOptionComineVo minVo = new AwardOptionComineVo();

		// 单一玩法,过滤出最大最小即可
		List<SportteryOption3G> optList = new ArrayList<SportteryOption3G>();
		optList.addAll(matchItem.getOptions3G());
		sortAwardASC(optList);

		// 最小
		SportteryOption3G minOpt = optList.get(0);
		List<SportteryOption3G> minList = new ArrayList<SportteryOption3G>();
		minList.add(minOpt);
		minVo.setSumSp(minOpt.getAward());
		minVo.setOptionList(minList);
		// 最大
		SportteryOption3G maxOpt = optList.get(optList.size() - 1);
		List<SportteryOption3G> maxList = new ArrayList<SportteryOption3G>();
		maxList.add(maxOpt);
		maxVo.setSumSp(maxOpt.getAward());
		maxVo.setOptionList(maxList);

		List<AwardOptionComineVo> voList = new ArrayList<AwardOptionComineVo>();
		voList.add(maxVo);
		voList.add(minVo);
		return voList;
	}

	/**
	 * 按award 升序排列
	 * 
	 * @param optionList
	 */
	public void sortAwardASC(List<SportteryOption3G> optionList) {
		if (optionList != null && !optionList.isEmpty()) {
			Collections.sort(optionList, new Comparator<SportteryOption3G>() {
				public int compare(SportteryOption3G o1, SportteryOption3G o2) {
					return o1.getAward().compareTo(o2.getAward());
				}
			});
		}
	}

	/**
	 * 预测奖金明细
	 * 
	 * @param matchItems
	 *            投注信息
	 * @param multiple
	 *            倍数
	 * @param playTypeList
	 *            过关方式
	 * @param isOnlyPlay
	 *            是否去除单一玩法
	 * @return
	 */
	public AwardResultVo ycAwardDetail(List<Sporttery3GMatchItem> matchItems, List<PlayType> playTypeList, int amount, int multiple,
									   Boolean isOnlyPlay) {
		// 1.对每场投注选项sp进行过滤,获得最小,最大组合
		// 2.进行明细分组
		List<AwardMatchInfoVo> matchVoList = buildMatchItem(matchItems);
		List<Integer> passTypes = buildPassType(playTypeList);
		// 4.进行明细分组
		AwardResultVo finalVo = combineDetail(passTypes, matchVoList, multiple, amount);
		return finalVo;
	}

	/**
	 * 只计算最小最大金额
	 * 
	 * @param matchItems
	 * @param playTypeList
	 * @return
	 */
	public AwardResultVo minAndMaxPrize(List<Sporttery3GMatchItem> matchItems, List<PlayType> playTypeList) {
		List<AwardMatchInfoVo> matchVoList = buildMatchItem(matchItems);
		List<Integer> passTypes = buildPassType(playTypeList);

		Double maxPrize = null;
		Double minPrize = null;

		Double allDanMinSp = null;// 所有设胆场次的最小金额乘积
		Double allDanMaxSp = null;// 所有设胆场次的最大金额乘积
		int danSize = 0;
		int tuoSize = 0;
		final List<Double> tuoMinSpList = new ArrayList<Double>();// 所有托的最小sp
		final List<Double> tuoMaxSpList = new ArrayList<Double>();// 所有托的最大sp
		final List<Double> quanBaoTuoSpList=new ArrayList<Double>();//全保托splist;
		// 1.先计算胆的最小最大奖金
		for (AwardMatchInfoVo vo : matchVoList) {
			Double minSp = vo.getMinZh().getSumSp();
			Double maxSp = vo.getMaxZh().getSumSp();
			if (vo.getMatchItem().isShedan()) {
				allDanMinSp = allDanMinSp == null ? minSp : ArithUtil.mul(allDanMinSp, minSp);
				allDanMaxSp = allDanMaxSp == null ? maxSp : ArithUtil.mul(allDanMaxSp, maxSp);
				danSize++;
			} else {
				if(vo.getHasBingo()){
					quanBaoTuoSpList.add(minSp);
				}else{
					tuoMinSpList.add(minSp);
				}
				tuoMaxSpList.add(maxSp);
				tuoSize++;
			}
		}
		// 2.再乘以托的最小奖金
		Collections.sort(tuoMinSpList);// 从小到大排序
		Collections.sort(quanBaoTuoSpList);// 从小到大排序
		quanBaoTuoSpList.addAll(tuoMinSpList);
		tuoMinSpList.clear();
		tuoMinSpList.addAll(quanBaoTuoSpList); //全包的sp在前面. 
		
		int bingoSize=0; //必中场数
		for (int i = 0; i < matchVoList.size(); i++) {
			if(matchVoList.get(i).getHasBingo() && !matchVoList.get(i).getMatchItem().isShedan() ){ //
				bingoSize++;
			}
		}
		//必中 <= 最小需要命中的场次数 则截取tuoMinSpList即可. tuoMinSpList按照 1.全包正序2.sp大小正序
		int minNeedCnt=passTypes.get(0)-danSize; //最小需要命中的场次数
		if(bingoSize <= minNeedCnt){ 
			Double totalSp = null;
			for (int j = 0; j < minNeedCnt; j++) {
				double sp = tuoMinSpList.get(j);
				totalSp = totalSp == null ? sp : ArithUtil.mul(totalSp, sp);
			}
			totalSp=totalSp==null?1d:totalSp;
			minPrize = allDanMinSp == null ? totalSp : ArithUtil.mul(allDanMinSp, totalSp);// 计算最小金额
		}else{
			//必中场次 大于需要的过关数 . 需要进行组合 
			
			//计算最小奖金
			for (int i = 0; i < passTypes.size(); i++) {
				int pt=passTypes.get(i);
				minNeedCnt=pt-danSize;
				if(bingoSize >= minNeedCnt ){ //必中场次小于需要的场次 则不进行处理 .如 必中2场,3串1则不符合要求 
					final List<Double> minSpCombList = new ArrayList<Double>();
					MathUtils.efficientComb(bingoSize, minNeedCnt, new CombCallBack() {
						public void callback(final boolean[] comb2, int m2) {
							Double totalSp = null;
							for (int j = 0; j < comb2.length; j++) {
								if (comb2[j]) {
									double sp = tuoMinSpList.get(j);
									totalSp = totalSp == null ? sp : ArithUtil.mul(totalSp, sp);
								}
							}
							if (totalSp != null) {
								minSpCombList.add(totalSp);
							}
						}
					});
					for (int j = 0; j < minSpCombList.size(); j++) {
						double minSp = minSpCombList.get(j);
						double totalSp = allDanMinSp == null ? minSp : ArithUtil.mul(minSp, allDanMinSp);// 胆码乘以托码sp
						minPrize = minPrize == null ? totalSp : ArithUtil.add(minPrize, totalSp);// 计算最大金额
					}
				}
				//出现胆数和过关数一致的情况
				minPrize=minPrize==null?allDanMinSp:minPrize;
			}
		}
		
		// 3.计算最大奖金
		for (int i = 0; i < passTypes.size(); i++) {
			int pt = passTypes.get(i);
			final List<Double> tuoSpCombList = new ArrayList<Double>();// 托码分组后的sp集合
			int needTuoCnt = pt - danSize;
			MathUtils.efficientComb(tuoSize, needTuoCnt, new CombCallBack() {
				public void callback(final boolean[] comb2, int m2) {
					Double totalSp = null;
					for (int j = 0; j < comb2.length; j++) {
						if (comb2[j]) {
							double sp = tuoMaxSpList.get(j);
							totalSp = totalSp == null ? sp : ArithUtil.mul(totalSp, sp);
						}
					}
					if (totalSp != null) {
						tuoSpCombList.add(totalSp);
					}
				}
			});
			if (tuoSpCombList.isEmpty()) {
				// 直接胆金额
				maxPrize = allDanMaxSp;
			} else {
				for (int j = 0; j < tuoSpCombList.size(); j++) {
					double tuoSp = tuoSpCombList.get(j);
					double totalSp = allDanMaxSp == null ? tuoSp : ArithUtil.mul(tuoSp, allDanMaxSp);// 胆码乘以托码sp
					maxPrize = maxPrize == null ? totalSp : ArithUtil.add(maxPrize, totalSp);// 计算最大金额
				}
			}
		}
		// 取2位小数
		minPrize = ArithUtil.sixRound(minPrize);
		maxPrize = ArithUtil.sixRound(maxPrize);
		Double[] scope = new Double[] { minPrize, maxPrize };
		AwardResultVo vo = new AwardResultVo();
		vo.setAwardScope(scope);
		return vo;
	}

	/**
	 * 构建过关数(从小到大排列)
	 * 
	 * @param playTypeList
	 * @return
	 */
	private List<Integer> buildPassType(List<PlayType> playTypeList) {
		List<Integer> passTypes = new ArrayList<Integer>();
		int offset = getPtOffset();// 通过减去这个,得到过关数
		for (PlayType pt : playTypeList) {
			passTypes.add(pt.getValue() - offset);
		}
		Collections.sort(passTypes);// 从小到大排序
		return passTypes;
	}

	/**
	 * 构建对阵VO信息
	 * 
	 * @param matchItems
	 * @return
	 */
	private List<AwardMatchInfoVo> buildMatchItem(List<Sporttery3GMatchItem> matchItems) {
		List<AwardMatchInfoVo> matchVoList = new ArrayList<AwardMatchInfoVo>();
		for (Sporttery3GMatchItem matchItem : matchItems) {
			AwardMatchInfoVo vo = new AwardMatchInfoVo();
			vo.setMatchItem(matchItem);
			List<AwardOptionComineVo> list = null;
			if(matchItem.isHt()){
				list=getMinAndMaxVo(matchItem);
			}else{
				list=getMinAndMaxVoSingle(matchItem);
			}
			vo.setMaxZh(list.get(0));
			vo.setMinZh(list.get(1));
			matchVoList.add(vo);
		}
		return matchVoList;
	}

	/**
	 * 具体明细分组
	 * 
	 * @param passTypes
	 * @param matchVoList
	 * @param multiple
	 * @param amount
	 * @return
	 */
	private AwardResultVo combineDetail(List<Integer> passTypes, List<AwardMatchInfoVo> matchVoList, int multiple, int amount) {
		// 1.按场次数进行分析数据,最小过关方式得到最小的命中场次
		// 2.按命中场次分别分析数据
		// 3.根据命中场次,筛选最大最小的赛事
		List<AwardMatchResultVo> resultVoList = new ArrayList<AwardMatchResultVo>();
		String[] typeKeys = new String[] { AwardResultVo.MAX_PRIZE, AwardResultVo.MIN_PRIZE };
		List<AwardMatchInfoVo> matchVoMaxList = new ArrayList<AwardMatchInfoVo>();// 按最大奖金总额排序
		matchVoMaxList.addAll(matchVoList);
		List<AwardMatchInfoVo> matchVoMinList = new ArrayList<AwardMatchInfoVo>();// 按最小奖金总额排序
		matchVoMinList.addAll(matchVoList);
		// 按最大奖金总额排序:胆在前，全包在前,倒序;
		Collections.sort(matchVoMaxList, new Comparator<AwardMatchInfoVo>() {
			public int compare(AwardMatchInfoVo o1, AwardMatchInfoVo o2) {
				Boolean d1 = o1.getMatchItem().isShedan();
				Boolean d2 = o2.getMatchItem().isShedan();
				Boolean qbao1=o1.getHasBingo();
				Boolean qbao2=o2.getHasBingo();
				int result = 0;
				if (d1 && d2 ||  (!d1 && !d2)) { // 2个胆拖一致　则比较 全包与否
					if((!qbao1 && !qbao2) || (qbao1 && qbao2)){ //2个全包与否一致则比较sp
						result = o2.getMaxZh().getSumSp().compareTo(o1.getMaxZh().getSumSp());
					}else{ //全包在前
						result=qbao2.compareTo(qbao1);
					}
				} else {// 胆排列在前
					result = d2.compareTo(d1);
				}
				return result;
			}
		});
		// 按最小奖金总额排序:胆在前，全包在前,升序
		Collections.sort(matchVoMinList, new Comparator<AwardMatchInfoVo>() {
			public int compare(AwardMatchInfoVo o1, AwardMatchInfoVo o2) {
				Boolean d1 = o1.getMatchItem().isShedan();
				Boolean d2 = o2.getMatchItem().isShedan();
				Boolean qbao1=o1.getHasBingo();
				Boolean qbao2=o2.getHasBingo();
				int result = 0;
				if ((d1 && d2) || (!d1 && !d2)) {// 则比较 全包与否
					if((!qbao1 && !qbao2) || (qbao1 && qbao2)){ //2个全包与否一致则比较sp
						result = o1.getMinZh().getSumSp().compareTo(o2.getMinZh().getSumSp());
					}else{ //全包在前
						result=qbao2.compareTo(qbao1);
					}
				} else {// 胆排列在前
					result = d2.compareTo(d1);
				}
				return result;
			}
		});
		int minBingoSize = passTypes.get(0); // 最小命中场次
		int quanBaoSize=0;
		for (int i = 0; i < matchVoMaxList.size(); i++) {
			if(matchVoMaxList.get(i).getHasBingo() || matchVoMaxList.get(i).getMatchItem().isShedan()){
				quanBaoSize++;
			}
		}
		minBingoSize=minBingoSize<quanBaoSize?quanBaoSize:minBingoSize;
		
		int maxBingoSize = matchVoList.size();// 最大命中场次
		// 按命中场次分析
		for (int i = maxBingoSize; i >= minBingoSize; i--) {
			AwardMatchResultVo matchResultVo = new AwardMatchResultVo();
			matchResultVo.setMatchCount(i);
			matchResultVo.setMultiple(multiple);
			matchResultVo.setAmount(amount);
			resultVoList.add(matchResultVo);

			// 3.按场次筛选数据
			for (String key : typeKeys) { // 循环计算最大最小奖金
				final List<AwardMatchInfoVo> combineList = new ArrayList<AwardMatchInfoVo>();
				if (key == AwardResultVo.MAX_PRIZE) {
					combineList.addAll(matchVoMaxList.subList(0, i));
				} else {
					combineList.addAll(matchVoMinList.subList(0, i));
				}
				// 4.对筛选的赛事进行分组
				final List<AwardMatchInfoVo> danList = new ArrayList<AwardMatchInfoVo>();
				final List<AwardMatchInfoVo> tuoList = new ArrayList<AwardMatchInfoVo>();
				for (AwardMatchInfoVo vo : combineList) {
					if (vo.getMatchItem().isShedan()) {
						danList.add(vo);
					} else {
						tuoList.add(vo);
					}
				}
				int sheDanSize = danList.size(); // 胆码个数
				int unSheDanSize = tuoList.size();// 托码个数

				for (Integer passType : passTypes) {
					AwardPrizeVo prizeVo = new AwardPrizeVo();
					prizeVo.setPassType(passType);
					List<AwardDetailVo> detailVoList = new ArrayList<AwardDetailVo>();
					prizeVo.setDetailList(detailVoList);

					List<AwardPrizeVo> prizeVoList = null;
					if (key == AwardResultVo.MAX_PRIZE) {
						prizeVoList = matchResultVo.getMaxList();
					} else {
						prizeVoList = matchResultVo.getMinList();
					}
					prizeVoList = prizeVoList == null ? new ArrayList<AwardPrizeVo>() : prizeVoList;
					prizeVoList.add(prizeVo);
					if (passType > i) { // 过关方式大于场次数,跳过
						continue;
					}
					final List<List<AwardMatchInfoVo>> matchCombineList = new ArrayList<List<AwardMatchInfoVo>>();
					// 先对场次进行组合
					ExtensionMathUtils.efficientCombExtension(passType, sheDanSize, unSheDanSize, new ExtensionCombCallBack() {
						public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
							List<AwardMatchInfoVo> list = new ArrayList<AwardMatchInfoVo>();
							list.addAll(danList);
							for (int i = 0; i < comb2.length; i++) {
								if (comb2[i]) {
									list.add(tuoList.get(i));
								}
							}
							matchCombineList.add(list);
						}
					});

					// 循环场次组合,对选项进行计算笛卡尔积
					for (List<AwardMatchInfoVo> list : matchCombineList) {
						List<List> dkeList = new ArrayList<List>();// 用来算笛卡尔积
						for (AwardMatchInfoVo vo : list) {
							// 为了获取matchItem信息,需要对optionList进行拆分
							List<SportteryOption3G> tmpList = new ArrayList<SportteryOption3G>();
							if (key == AwardResultVo.MAX_PRIZE) {
								tmpList = vo.getMaxZh().getOptionList();
							} else {
								tmpList = vo.getMinZh().getOptionList();
							}
							List itemList = new ArrayList();
							for (SportteryOption3G opt : tmpList) {
								Sporttery3GMatchItem matchItem = vo.getMatchItem();
								// 组装AwardDetailItemVo
								AwardDetailItemVo item = new AwardDetailItemVo();
								item.setLineIdText(matchItem.getLineIDText());
								item.setWeekStr(matchItem.getWeekStr());
								item.setOption(opt);
								itemList.add(item);
							}
							dkeList.add(itemList);
						}
						List<List> resultList = DescartesUtil.cross(dkeList);// 笛卡尔积之后的数据
						// 组装AwardDetailVo
						for (List tmpList : resultList) {
							AwardDetailVo vo = new AwardDetailVo();
							vo.setMultiple(multiple);
							vo.setItems(tmpList);
							detailVoList.add(vo);
						}
					}
					if (key == AwardResultVo.MAX_PRIZE) {
						matchResultVo.setMaxList(prizeVoList);
					} else {
						matchResultVo.setMinList(prizeVoList);
					}
				}// end of 过关数

			}// end of 最大最小
		}// end of 场次循环
		AwardResultVo vo = new AwardResultVo();
		vo.setMatchs(matchVoList);
		vo.setDetails(resultVoList);
		vo.setMultiple(multiple);
		vo.setPassType(passTypes);
		vo.setAmount(amount);
		return vo;
	}

}
