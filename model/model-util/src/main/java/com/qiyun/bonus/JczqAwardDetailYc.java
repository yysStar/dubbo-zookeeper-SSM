package com.qiyun.bonus;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.util.ArithUtil;

import java.util.*;

public class JczqAwardDetailYc extends AwardDetailYc {

	public static List<Integer[]> bfOptions;
	public static List<String> spcScores;
	static {
		bfOptions = new ArrayList<Integer[]>();
		bfOptions.add(new Integer[] { 1, 0 });
		bfOptions.add(new Integer[] { 2, 0 });
		bfOptions.add(new Integer[] { 2, 1 });
		bfOptions.add(new Integer[] { 3, 0 });
		bfOptions.add(new Integer[] { 3, 1 });
		bfOptions.add(new Integer[] { 3, 2 });
		bfOptions.add(new Integer[] { 4, 0 });
		bfOptions.add(new Integer[] { 4, 1 });
		bfOptions.add(new Integer[] { 4, 2 });
		bfOptions.add(new Integer[] { 5, 0 });
		bfOptions.add(new Integer[] { 5, 1 });
		bfOptions.add(new Integer[] { 5, 2 });
		bfOptions.add(new Integer[] { 0, 0 });
		bfOptions.add(new Integer[] { 1, 1 });
		bfOptions.add(new Integer[] { 2, 2 });
		bfOptions.add(new Integer[] { 3, 3 });
		bfOptions.add(new Integer[] { 0, 1 });
		bfOptions.add(new Integer[] { 0, 2 });
		bfOptions.add(new Integer[] { 1, 2 });
		bfOptions.add(new Integer[] { 0, 3 });
		bfOptions.add(new Integer[] { 1, 3 });
		bfOptions.add(new Integer[] { 2, 3 });
		bfOptions.add(new Integer[] { 0, 4 });
		bfOptions.add(new Integer[] { 1, 4 });
		bfOptions.add(new Integer[] { 2, 4 });
		bfOptions.add(new Integer[] { 0, 5 });
		bfOptions.add(new Integer[] { 1, 5 });
		bfOptions.add(new Integer[] { 2, 5 });

		spcScores = new ArrayList<String>();
		spcScores.add("WW"); // 胜其他
		spcScores.add("DD"); // 平其他
		spcScores.add("LL"); // 负其他
	}

	/**
	 * 通过这个计算偏移量
	 * 
	 * @return
	 */
	protected int getPtOffset() {
		return 116;
	}

	public List<SportteryOption3G> sortByDesc(List<SportteryOption3G> list) {
		Collections.sort(list, new Comparator<SportteryOption3G>() {
			public int compare(SportteryOption3G o1, SportteryOption3G o2) {
				return o2.getAward().compareTo(o1.getAward());
			}
		});
		return list;
	}
	/**
	 * 通过允许的选项,构建最大/最小sp VO
	 * @param allowOptList
	 * @param maxPrizeVo
	 * @param minPrizeVo
	 */
	public void buildComineVo(List<SportteryOption3G> allowOptList,AwardOptionComineVo maxPrizeVo,AwardOptionComineVo minPrizeVo,int lotType){
		if(allowOptList.size()>0){
			sortByDesc(allowOptList);
			SportteryOption3G maxOpt=allowOptList.get(0);
			SportteryOption3G minOpt=allowOptList.get(allowOptList.size()-1);
			if(lotType==37){ //半全场玩法需要判断是否全选必中,是否有其他玩法
				maxPrizeVo.getOptionList().add(maxOpt);
				maxPrizeVo.setSumSp(ArithUtil.add(maxPrizeVo.getSumSp(), maxOpt.getAward()));
				if (minPrizeVo.getOptionList().size() == 0) {// 没有其他玩法
					minPrizeVo.getOptionList().add(minOpt);
					minPrizeVo.setSumSp(ArithUtil.add(minPrizeVo.getSumSp(), minOpt.getAward()));
					minPrizeVo.setOnlyBqc(true);
					minPrizeVo.setBqcLen(allowOptList.size());
				} else {
					if (allowOptList.size() == 3) { // 有其他玩法,并且半全场全包了必中选项
						minPrizeVo.getOptionList().add(minOpt);
						minPrizeVo.setSumSp(ArithUtil.add(minPrizeVo.getSumSp(), minOpt.getAward()));
						minPrizeVo.setBqcLen(allowOptList.size());
					}
				}
			}else{
				AwardOptionComineVo tmpMinVo=minPrizeVo;
				// 最小sp组合: 半全场和其他玩法不能同时命中,除非半全场全选必中
				if (minPrizeVo.getOnlyBqc() && minPrizeVo.getBqcLen() < 3) {
					tmpMinVo = new AwardOptionComineVo();
				}
				maxPrizeVo.getOptionList().add(maxOpt);
				maxPrizeVo.setSumSp(ArithUtil.add(maxPrizeVo.getSumSp(), maxOpt.getAward()));
				tmpMinVo.getOptionList().add(minOpt);
				tmpMinVo.setSumSp(ArithUtil.add(tmpMinVo.getSumSp(), minOpt.getAward()));
				minPrizeVo.setOptionList(tmpMinVo.getOptionList());
				minPrizeVo.setSumSp(tmpMinVo.getSumSp());
			}
		}
		
	}
	/**
	 * 过滤出每场次的 最大/最小值
	 * @param matchItem
	 * @return
	 */
	protected List<AwardOptionComineVo> getMinAndMaxVo(Sporttery3GMatchItem matchItem) {
		Map<LotteryType, List<SportteryOption3G>> map = matchItem.getPlayTypes();
		int rqs = matchItem.getRqs();
		AwardOptionComineVo maxVo = new AwardOptionComineVo();
		AwardOptionComineVo minVo = new AwardOptionComineVo();

		// 循环每种赛果(bfList+spcScores),根据玩法过滤符合赛果的选项组成组合.
		// 过滤出每个玩法允许出现的选项, 然后获取最大/最小sp
		// 最小sp组合: 组合内其他选项不能和半全场选项同时命中.(半全场全选必中一个除外 如同时选择胜-胜,平胜,负胜)
		for (Integer[] bfArray : bfOptions) {
			AwardOptionComineVo maxPrizeVo = new AwardOptionComineVo();
			AwardOptionComineVo minPrizeVo = new AwardOptionComineVo();
			for (Map.Entry<LotteryType, List<SportteryOption3G>> entry : map.entrySet()) {
				List<SportteryOption3G> allowOptList=new ArrayList<SportteryOption3G>(); //每个玩法中,可以同时存在的选项集合
				switch (entry.getKey().getValue()) {
				case 41: // 胜平负
					if (bfArray[0] - bfArray[1] > 0) { // 代表胜
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("3")) {
								allowOptList.add(opt);
								break;
							}
						}
					} else if (bfArray[0] - bfArray[1] == 0) { // 平
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("1")) {
								allowOptList.add(opt);
								break;
							}
						}
					} else if (bfArray[0] - bfArray[1] < 0) { // 负
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("0")) {
								allowOptList.add(opt);
								break;
							}
						}
					}
					buildComineVo(allowOptList, maxPrizeVo, minPrizeVo,entry.getKey().getValue());
					break;
				case 34: // 让球胜平负
					if (bfArray[0] - bfArray[1] + rqs > 0) { // 代表胜
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("3")) {
								allowOptList.add(opt);
								break;
							}
						}
					} else if (bfArray[0] - bfArray[1] + rqs == 0) { // 平
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("1")) {
								allowOptList.add(opt);
								break;
							}
						}
					} else if (bfArray[0] - bfArray[1] + rqs < 0) { // 负
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("0")) {
								allowOptList.add(opt);
								break;
							}
						}
					}
					buildComineVo(allowOptList, maxPrizeVo, minPrizeVo,entry.getKey().getValue());
					break;
				case 35: // 比分
					for (SportteryOption3G opt : entry.getValue()) {
						if (opt.getValue().equals(bfArray[0] + "" + bfArray[1])) {
							allowOptList.add(opt);
							break;
						}
					}
					buildComineVo(allowOptList, maxPrizeVo, minPrizeVo,entry.getKey().getValue());
					break;
				case 36:// 进球数
					for (SportteryOption3G opt : entry.getValue()) {
						if (opt.getValue().equals(bfArray[0] + bfArray[1] + "")) {
							allowOptList.add(opt);
							break;
						}
					}
					buildComineVo(allowOptList, maxPrizeVo, minPrizeVo,entry.getKey().getValue());
					break;
				case 37:// 半全场
					if (bfArray[0] - bfArray[1] > 0) {
						for (SportteryOption3G opt : entry.getValue()) {
							if(bfArray[1]==0){ //1:0 情况 只能出现胜-胜 平-胜
								if (opt.getValue().equals("33") ||opt.getValue().equals("13") ) {
									allowOptList.add(opt);
								}
							}else{
								if (opt.getValue().equals("33") || opt.getValue().equals("13") || opt.getValue().equals("03")) {
									allowOptList.add(opt);
								}
							}
						}
					} else if (bfArray[0] - bfArray[1] == 0) {
						for (SportteryOption3G opt : entry.getValue()) {
							if(bfArray[0]==bfArray[1] && bfArray[0]==0){ //0:0
								if(opt.getValue().equals("11")){
									allowOptList.add(opt);
									break;
								}
							}else {
								if (opt.getValue().equals("31") || opt.getValue().equals("11") || opt.getValue().equals("01")) {
									allowOptList.add(opt);
								}
							}
						}
					} else if (bfArray[0] - bfArray[1] < 0) {
						for (SportteryOption3G opt : entry.getValue()) {
							if(bfArray[0]==0){ //0:1情况 只能出现 平-负,负-负
								if (opt.getValue().equals("10") || opt.getValue().equals("00")) {
									allowOptList.add(opt);
								}
							}else{
								if (opt.getValue().equals("30") || opt.getValue().equals("10") || opt.getValue().equals("00")) {
									allowOptList.add(opt);
								}
							}
						}
					}
					buildComineVo(allowOptList, maxPrizeVo, minPrizeVo,entry.getKey().getValue());
					break;
				}
			}

			if (maxVo.getSumSp() < maxPrizeVo.getSumSp()) {
				maxVo = maxPrizeVo;
			}
			if (minVo.getSumSp() == 0 || (minVo.getSumSp() > minPrizeVo.getSumSp() && minPrizeVo.getSumSp() != 0)) {
				minVo = minPrizeVo;
			}
		}// end for
		for (String str : spcScores) {
			AwardOptionComineVo maxPrizeVo = new AwardOptionComineVo();
			AwardOptionComineVo minPrizeVo = new AwardOptionComineVo();
			for (Map.Entry<LotteryType, List<SportteryOption3G>> entry : map.entrySet()) {
				List<SportteryOption3G> allowOptList=new ArrayList<SportteryOption3G>(); //每个玩法中,可以同时存在的选项集合
				switch (entry.getKey().getValue()) {
				case 41:// 胜平负
					if (str.equals("WW")) {
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("3")) {
								allowOptList.add(opt);
								break;
							}
						}
					} else if (str.equals("DD")) {
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("1")) {
								allowOptList.add(opt);
								break;
							}
						}
					} else if (str.equals("LL")) {
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("0")) {
								allowOptList.add(opt);
								break;
							}
						}
					}
					buildComineVo(allowOptList, maxPrizeVo, minPrizeVo,entry.getKey().getValue());
					break;
				case 34: // 让球胜平负
					if (str.equals("WW")) {// 胜其他
						if (rqs >= 0) {
							for (SportteryOption3G opt : entry.getValue()) {
								if (opt.getValue().equals("3")) {
									allowOptList.add(opt);
									break;
								}
							}
							
						} else if (rqs == -1) {
							for (SportteryOption3G opt : entry.getValue()) {
								if (opt.getValue().equals("3") || opt.getValue().equals("1")) {
									allowOptList.add(opt);
								}
							}
						} else if (rqs < -1) {
							allowOptList = entry.getValue();
						}
					} else if (str.equals("DD")) {
						if (rqs > 0) {
							for (SportteryOption3G opt : entry.getValue()) {
								if (opt.getValue().equals("3")) {
									allowOptList.add(opt);
									break;
								}
							}
						}
						if (rqs == 0) {
							for (SportteryOption3G opt : entry.getValue()) {
								if (opt.getValue().equals("1")) {
									allowOptList.add(opt);
									break;
								}
							}
						}
						if (rqs < 0) {
							for (SportteryOption3G opt : entry.getValue()) {
								if (opt.getValue().equals("0")) {
									allowOptList.add(opt);
									break;
								}
							}
						}
					} else if (str.equals("LL")) {
						if (rqs > 1) {
							allowOptList=entry.getValue();
						} else if (rqs == 1) {
							for (SportteryOption3G opt : entry.getValue()) {
								if (opt.getValue().equals("0") || opt.getValue().equals("1")) {
									allowOptList.add(opt);
								}
							}
						}
						if (rqs < 1) {
							for (SportteryOption3G opt : entry.getValue()) {
								if (opt.getValue().equals("0")) {
									allowOptList.add(opt);
									break;
								}
							}
						}
					}
					buildComineVo(allowOptList, maxPrizeVo, minPrizeVo, entry.getKey().getValue());
					break;
				case 35: // 比分
					for (SportteryOption3G opt : entry.getValue()) {
						if (opt.getValue().equals(str)) {
							allowOptList.add(opt);
							break;
						}
					}
					buildComineVo(allowOptList, maxPrizeVo, minPrizeVo,entry.getKey().getValue());
					break;
				case 36:// 进球数
					for (SportteryOption3G opt : entry.getValue()) {
						if (opt.getValue().equals("7+")) {
							allowOptList.add(opt);
							break;
						}
					}
					buildComineVo(allowOptList, maxPrizeVo, minPrizeVo,entry.getKey().getValue());
					break;
				case 37:// 半全场
					if (str.equals("WW")) {
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("33") || opt.getValue().equals("13") || opt.getValue().equals("03")) {
								allowOptList.add(opt);
							}
						}
					} else if (str.equals("DD")) {
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("31") || opt.getValue().equals("11") || opt.getValue().equals("01")) {
								allowOptList.add(opt);
							}
						}
					} else if (str.equals("LL")) {
						for (SportteryOption3G opt : entry.getValue()) {
							if (opt.getValue().equals("30") || opt.getValue().equals("10") || opt.getValue().equals("00")) {
								allowOptList.add(opt);
							}
						}
					}
					buildComineVo(allowOptList, maxPrizeVo, minPrizeVo,entry.getKey().getValue());
					break;
				}
			}
			if (maxVo.getSumSp() < maxPrizeVo.getSumSp()) {
				maxVo = maxPrizeVo;
			}
			if (minVo.getSumSp() == 0 || (minVo.getSumSp() > minPrizeVo.getSumSp() && minPrizeVo.getSumSp() != 0)) {
				minVo = minPrizeVo;
			}
		}
		List<AwardOptionComineVo> list = new ArrayList<AwardOptionComineVo>();
		list.add(maxVo);
		list.add(minVo);
		return list;
	}

}
