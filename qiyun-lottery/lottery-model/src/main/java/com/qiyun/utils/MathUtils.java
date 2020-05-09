package com.qiyun.utils;


import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstactMatch;

import com.qiyun.model.*;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.model2.SportteryTicketVO;
import com.qiyun.ticket.Ticket;
import com.qiyun.tools.DateTools;


import java.util.*;

/**
 * 高效组合算法
 * 
 * @author ZhouHaiBin
 * 
 */
public class MathUtils {

	/**
	 * 计算组合数
	 * 
	 * @param r
	 *            取出元素个数
	 * @param n
	 *            可选个数
	 * @return 组合数
	 */
	public static int comp(int r, int n) {
		long C = 1;
		for (int i = n - r + 1; i <= n; i++) {
			C = C * i;
		}
		for (int i = 2; i <= r; i++) {
			C = C / i;
		}
		return (int) C;
	}

	public static List<String> combinResult(final List<Integer> dataList, int selectCount) {
		return combinResult(dataList, selectCount, true);
	}

	public static List<String> combinResult(final List<Integer> dataList, int selectCount, boolean doubleFlag) {
		final List<int[]> list = new ArrayList<int[]>();

		efficientComb(dataList.size(), selectCount, new CombCallBack() {
			public void callback(boolean[] comb, int m) {
				int[] tempArr = new int[m];
				int pos = 0;
				for (int i = 0; i < comb.length; i++) {
					if (comb[i] == true) {
						tempArr[pos] = dataList.get(i);
						pos++;
						if (pos == m)
							break;
					}
				}
				list.add(tempArr);
			}
		});

		List<String> retList = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		for (int[] arr1 : list) {
			for (int b : arr1) {
				if (doubleFlag) {
					sb.append(String.format("%02d", b) + ",");
				} else {
					sb.append(b + ",");
				}
			}
			retList.add(sb.toString().substring(0, sb.toString().length() - 1));
			sb.setLength(0);
		}

		return retList;
	}

	/**
	 * 高效的组合算法
	 *
	 * @param n
	 *            可选的数目
	 * @param m
	 *            取的数目
	 * @param callBack
	 *            每取出一个组合时的回调函数
	 */
	public static void efficientComb(int n, int m, CombCallBack callBack) {
		if (m > n) {
			return;
		}

		boolean[] bs = new boolean[n];
		for (int i = 0; i < m; i++) {
			bs[i] = true;
		}
		if (m == n) {
			callBack.callback(bs, m);
			return;
		}
		for (int i = m; i < n; i++) {
			bs[i] = false;
		}
		if (m == 0) {
			callBack.callback(bs, m);
			return;
		}

		boolean flag = true;
		boolean tempFlag = false;
		int pos = 0;
		int sum = 0;
		// 首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边
		do {
			sum = 0;
			pos = 0;
			tempFlag = true;
			callBack.callback(bs, m);

			// 找到第一个10组合，然后变成01
			for (int i = 0; i < n - 1; i++) {
				if (bs[i] == true && bs[i + 1] == false) {
					bs[i] = false;
					bs[i + 1] = true;
					pos = i;
					break;
				}
			}

			// 将左边的1全部移动到数组的最左边
			for (int i = 0; i < pos; i++) {
				if (bs[i] == true) {
					sum++;
				}
			}
			for (int i = 0; i < pos; i++) {
				if (i < sum) {
					bs[i] = true;
				} else {
					bs[i] = false;
				}
			}

			// 检查是否所有的1都移动到了最右边
			for (int i = n - m; i < n; i++) {
				if (bs[i] == false) {
					tempFlag = false;
					break;
				}
			}
			if (tempFlag == false) {
				flag = true;
			} else {
				flag = false;
			}

		} while (flag);
		callBack.callback(bs, m);
	}
	public static <T extends SportteryBetContentModel<X>, X extends MatchItem, M extends AbstactMatch> List<SportteryTicketVO> combinResultToVO(
			final com.qiyun.commonModel.LotteryType lotteryType, final boolean isOpenPrize, String content, final Map<String, M> matchMap, Class<T> modelClass,
			Class<X> matchitemClass, Ticket ticket) throws InstantiationException, IllegalAccessException {
		List<SportteryTicketVO> voList = new ArrayList<SportteryTicketVO>();
		T planVO = CommonUtils.Object4Json(content, modelClass, matchitemClass);//根据content 转换成对象
		List<X> matchItems = planVO.getMatchItems();//对阵集合
		List<SportteryPassType> passTypes = planVO.getPassTypes();//过关方式
		int sheDanSize = 0;//未拆分投注选项前，胆的对阵个数
		final List<X> unDanList = new ArrayList<X>();//拖集合
		final List<X> sheDanList = new ArrayList<X>();//胆集合
		int sheDanTotal = 0;//拆分投注选项后，胆的对阵个数
		for (X x : matchItems) {
			//拆分对阵的投注选项，构建多个对阵
			for (SportteryOption sportteryOption :  x.getOptions()) {
				List<SportteryOption> list = new ArrayList<SportteryOption>();
				list.add(sportteryOption);
				X fb = (X) x.cloneItem();
				fb.setOptions(list);
				if (x.isShedan()) {
					sheDanList.add(fb);
				} else {
					unDanList.add(fb);
				}
			}
			if (x.isShedan()) {
				sheDanSize++;
				sheDanTotal +=  x.getOptions().size();
			}
		}
		if (sheDanSize> 0) {
			//胆拖拆分单式
			voList = getSheDanVOList(passTypes, sheDanSize, unDanList.size(), sheDanList, unDanList, planVO, sheDanTotal, lotteryType,
					isOpenPrize, matchMap,ticket);
		} else {
			//全拖拆分单式
			voList = getUnSheDanVOList(passTypes, sheDanSize, unDanList.size(), sheDanList, unDanList, planVO, sheDanTotal, lotteryType,
					isOpenPrize, matchMap,ticket);
		}
		return voList;
	}
	private static <T extends SportteryBetContentModel<X>, X extends MatchItem, M extends AbstactMatch> List<SportteryTicketVO> getSheDanVOList(
			List<SportteryPassType> passTypes, final int sheDanSize, final int unDanSize, final List<X> sheDanList, final List<X> unDanList,
			final T planVO, final int sheDanTotal, final com.qiyun.commonModel.LotteryType lotteryType, final boolean isOpenPrize, final Map<String, M> matchMap, final Ticket ticket) {
		boolean isOnlyPlay = planVO.getIsOnlyPlay();// 去除单一
		int multiple = planVO.getMultiple();// 倍数
		final List<SportteryTicketVO> voList = new ArrayList<SportteryTicketVO>();
		// 遍历过关方式
		for (final SportteryPassType type : passTypes) {
			final int needMatchCount = type.getMatchCount();// 拿到过关的场次数目
			final Map<Integer, List<X>> danMatchs = new HashMap<Integer, List<X>>();
			ExtensionMathUtils.efficientCombExtension(sheDanSize, 0, sheDanTotal, new ExtensionCombCallBack() {
				public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
					List<String> list = new ArrayList<String>();
					List<X> danList = new ArrayList<X>();
					for (int i = 0; i < comb2.length; i++) {
						String intTime = String.valueOf(sheDanList.get(i).getIntTime());
						String lineId = String.valueOf(sheDanList.get(i).getLineId());
						String key = intTime + "" + lineId;
						if (comb2[i] && !list.contains(key)) {
							list.add(key);
							danList.add(sheDanList.get(i));
						}
					}
					if (danList.size() == sheDanSize) {
						danMatchs.put(danMatchs.size() + 1, danList);
					}
				}
			});
			ExtensionMathUtils.efficientCombExtension(needMatchCount, sheDanSize, unDanSize, new ExtensionCombCallBack() {
				public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
					List<String> unList = new ArrayList<String>();

					for (Integer danKey : danMatchs.keySet()) {
						List<String> list = new ArrayList<String>();

						List<X> tempMatchs = new ArrayList<X>();

						tempMatchs.addAll(danMatchs.get(danKey));

						for (int i = 0; i < comb2.length; i++) {
							// 因为会存在一场比赛选择了多种玩法的情况，所以这边要添加场次判断
							String intTime = String.valueOf(unDanList.get(i).getIntTime());
							String lineId = String.valueOf(unDanList.get(i).getLineId());
							String key = intTime + "" + lineId;
							if (comb2[i] && !list.contains(key)) {
								list.add(key);
								tempMatchs.add(unDanList.get(i));
							}
						}

						List<SportteryTicketVO> tmpList = buildVo(tempMatchs, type, lotteryType, planVO, isOpenPrize, matchMap,ticket);
						voList.addAll(tmpList);
					}
				}
			});
		}
		return voList;
	}

	private static <T extends SportteryBetContentModel<X>, X extends MatchItem, M extends AbstactMatch> List<SportteryTicketVO> buildVo(
			List<X> tempMatchs, SportteryPassType type, com.qiyun.commonModel.LotteryType lotteryType, T planVO, Boolean isOpenPrize, Map<String, M> matchMap, Ticket ticket) {
		boolean isOnlyPlay = planVO.getIsOnlyPlay();// 去除单一
		int multiple = planVO.getMultiple();// 倍数
		if(ticket!=null){
			multiple = ticket.getMultiple();// 倍数
		}
		List<SportteryTicketVO> voList = new ArrayList<SportteryTicketVO>();
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();//按规则构建optionMap
		StringBuilder vokey = new StringBuilder();//vokey VO对象的主键
		StringBuilder optionStr = new StringBuilder();//VO 对象的option.投注明细页面显示的内容
		Double singlePrice = -1.0;//单倍金额
		List<String> dyList = new ArrayList<String>();// 如果size==1代表相同玩法
		boolean isBingo = false;
		int cnt = 0;
		List<M> matchList=new ArrayList<M>();
		for (int j = 0; j < tempMatchs.size(); j++) {
			// 去除单一
			X x = tempMatchs.get(j);
			if (isOnlyPlay) {
				String opType = x.getOptions().get(0).getType();
				if (!dyList.contains(opType)) {
					dyList.add(opType);
				}
			}
			String intTime = x.getIntTime() + "";
			String lineId = x.getLineId() + "";
			String key = intTime + "" + lineId;
			List<String> tmp = new ArrayList<String>();
			SportteryOption op = x.getOptions().get(0);
			if (null==op.getType()||"".equals(op.getType())) {//单式上传没有type值
				op.setType(lotteryType.getValue() + "");
			}
			Date intDate = DateTools.StringToDate(intTime + "", "yyyyMMdd");
			while (lineId.length() < 3) {
				lineId = "0" + lineId;
			}
			String weekStr = DateTools.getWeekStr(intDate) + lineId;
			OptionItem opItem = CommonUtils.getByPlayType(lotteryType, op);

			tmp.add(com.qiyun.commonModel.LotteryType.getItem(Integer.valueOf(op.getType())).getName());
			if(SubTypeEnum.YP.name().equals(op.getSubType())){ //亚盘投注, 主要用于区别单固.单固包含亚盘
				opItem= CommonUtils.getByPlayType(com.qiyun.commonModel.LotteryType.JC_ZQ_ALTERNATIVE, op);
			}
			tmp.add(opItem.getText());
			tmp.add(op.getAward() + "");
			tmp.add(weekStr);
			map.put(key, tmp);
			vokey.append(key + "\1\1" + op.getType() + "\1\1" + op.getValue());
			if (j + 1 < tempMatchs.size()) {
				vokey.append("\2\2");
			}
			// 判断票是否中奖
			if (matchMap != null && !matchMap.isEmpty()) {
				String matchKey = intTime + "_" + x.getLineId();
				M m = matchMap.get(matchKey);
				if(m.getStatus()==MatchStatus.CANCLE.ordinal()){
					singlePrice = singlePrice == -1.0 ? 1 : singlePrice * 1;
				}else{
					singlePrice = singlePrice == -1.0 ? op.getAward() : ArithUtil.mul(singlePrice , op.getAward());
				}
				matchList.add(m);
//				OptionItem resultItem = m.getResult(LotteryType.getItem(Integer.parseInt(op.getType())));
				OptionItem resultItem =ticketResult(com.qiyun.commonModel.LotteryType.getItem(Integer.parseInt(op.getType())), x, m);
				if(resultItem==null){
					cnt++;
				}else {
					if (!resultItem.getValue().equals(opItem.getValue())) {
						cnt++;// 记录不同的次数
					}
				}
				if(cnt==0){
					isBingo=true;
				}
			}else{
				singlePrice = singlePrice == -1.0 ? op.getAward() : ArithUtil.mul(singlePrice , op.getAward());
			}
			optionStr.append(weekStr + "[" + opItem.getText() + "(" + op.getAward() + ")]/");
		}
		if (cnt > 0) {
			isBingo = false;
		}
		boolean flag = true;
		if (isOnlyPlay && dyList.size() <= 1) {
			flag = false;
		}
		if (flag && tempMatchs.size() > type.getMatchCount() - 1) {
			SportteryTicketVO vo = new SportteryTicketVO();
			singlePrice =ArithUtil.mul(singlePrice, vo.getAmount());//单倍
			singlePrice=ArithUtil.sixRound(singlePrice);
			if(singlePrice>10000){//大于1w交税
				singlePrice = ArithUtil.mul(singlePrice, 0.8);
				singlePrice=ArithUtil.round2Scale(singlePrice);
			}
			vo.setAmount(ArithUtil.mul(vo.getAmount(),multiple));
			Double totalPrice = ArithUtil.mul(singlePrice, multiple);
			vo.setPassType(type); //过关方式
			vo.setMultiple(multiple);//倍数
			vo.setMatchItemList(tempMatchs);//对阵集合
			vo.setMatchList(matchList);
			vo.setSinglePrice(singlePrice);//单倍金额
			vo.setTotalPrice(totalPrice);//总金额
			vo.setOptionMap(map);//optionMap
			vo.setVoKeys(vokey.toString());//主键
			vo.setOption(optionStr.delete(optionStr.length() - 1, optionStr.length()).toString());//option
			vo.setTicket(ticket);
			if(ticket ==null || ticket.getWinStatus() == WinStatus.NOT_RESULT){
				isOpenPrize=false;
			}else {
				isOpenPrize=true;
			}
			vo.setIsBingo(isBingo);
			vo.setIsOpenPrize(isOpenPrize);
			voList.add(vo);
		}
		return voList;

	}
	public static  OptionItem ticketResult(com.qiyun.commonModel.LotteryType lotType, MatchItem item , AbstactMatch match){
		if(match==null ){
			throw new RuntimeException("赛事错误");
		}
		Integer homeScore=match.getHomeScore();
		if(homeScore==null){
			return null;
		}
		Integer guestScore=match.getGuestScore();
		Integer concede=null;
		Double rf=null;
		Double dxf=null;
		if(item instanceof FootBallMatchItem){//竞彩足球让球数 出票不回写.取对阵让球数
			concede =((FootBallMatch)match).getConcede();
		}else{//竞彩篮球大小分,让分 出票回写.根据出票数据计算结果
			rf =((BasketBallMatchItem)item).getRF();
			dxf =((BasketBallMatchItem)item).getDXF();
		}
		switch (lotType.getValue()) {
			case 34: {
				if (homeScore + concede > guestScore)
					return OptionItemSPF.WIN;// 主胜
				else if (homeScore + concede < guestScore)
					return OptionItemSPF.LOSE;// 主负
				else
					return OptionItemSPF.DRAW;// 主平
			}
			case 35: {
				if (homeScore == 1 & guestScore == 0) {
					return OptionItemBF.WIN10;// 1:0
				} else if (homeScore == 2 & guestScore == 0) {
					return OptionItemBF.WIN20;// 2:0
				} else if (homeScore == 2 & guestScore == 1) {
					return OptionItemBF.WIN21;// 2:1
				} else if (homeScore == 3 & guestScore == 0) {
					return OptionItemBF.WIN30;// 3:0
				} else if (homeScore == 3 & guestScore == 1) {
					return OptionItemBF.WIN31;// 1:3
				} else if (homeScore == 3 & guestScore == 2) {
					return OptionItemBF.WIN32;// 2:3
				} else if (homeScore == 4 & guestScore == 0) {
					return OptionItemBF.WIN40;// 0:4
				} else if (homeScore == 4 & guestScore == 1) {
					return OptionItemBF.WIN41;// 1:4
				} else if (homeScore == 4 & guestScore == 2) {
					return OptionItemBF.WIN42;// 2:4
				} else if (homeScore == 5 & guestScore == 0) {
					return OptionItemBF.WIN50;// 0:5
				} else if (homeScore == 5 & guestScore == 1) {
					return OptionItemBF.WIN51;// 1:5
				} else if (homeScore == 5 & guestScore == 2) {
					return OptionItemBF.WIN52;// 2:5
				}

				else if (homeScore == 0 & guestScore == 0) {
					return OptionItemBF.DRAW00;// 0:0
				} else if (homeScore == 1 & guestScore == 1) {
					return OptionItemBF.DRAW11;// 1:1
				} else if (homeScore == 2 & guestScore == 2) {
					return OptionItemBF.DRAW22;// 2:2
				} else if (homeScore == 3 & guestScore == 3) {
					return OptionItemBF.DRAW33;// 3:3
				}

				else if (homeScore == 0 & guestScore == 1) {
					return OptionItemBF.LOSE01;// 0:1
				} else if (homeScore == 0 & guestScore == 2) {
					return OptionItemBF.LOSE02;// 0:2
				} else if (homeScore == 1 & guestScore == 2) {
					return OptionItemBF.LOSE12;// 1:2
				} else if (homeScore == 0 & guestScore == 3) {
					return OptionItemBF.LOSE03;// 0:3
				} else if (homeScore == 1 & guestScore == 3) {
					return OptionItemBF.LOSE13;// 1:3
				} else if (homeScore == 2 & guestScore == 3) {
					return OptionItemBF.LOSE23;// 2:3
				} else if (homeScore == 0 & guestScore == 4) {
					return OptionItemBF.LOSE04;// 0:4
				} else if (homeScore == 1 & guestScore == 4) {
					return OptionItemBF.LOSE14;// 1:4
				} else if (homeScore == 2 & guestScore == 4) {
					return OptionItemBF.LOSE24;// 2:4
				} else if (homeScore == 0 & guestScore == 5) {
					return OptionItemBF.LOSE05;// 0:5
				} else if (homeScore == 1 & guestScore == 5) {
					return OptionItemBF.LOSE15;// 1:5
				} else if (homeScore == 2 & guestScore == 5) {
					return OptionItemBF.LOSE25;// 2:5
				} else if (homeScore > guestScore) {
					return OptionItemBF.WIN_OTHER;//
				} else if (homeScore == guestScore) {
					return OptionItemBF.DRAW_OTHER;//
				} else if (homeScore < guestScore) {
					return OptionItemBF.LOSE_OTHER;//
				}

			}
			case 36: {
				if ((homeScore + guestScore) == 0)
					return OptionItemJQS.S0;
				else if ((homeScore + guestScore) == 1)
					return OptionItemJQS.S1;
				else if ((homeScore + guestScore) == 2)
					return OptionItemJQS.S2;
				else if ((homeScore + guestScore) == 3)
					return OptionItemJQS.S3;
				else if ((homeScore + guestScore) == 4)
					return OptionItemJQS.S4;
				else if ((homeScore + guestScore) == 5)
					return OptionItemJQS.S5;
				else if ((homeScore + guestScore) == 6)
					return OptionItemJQS.S6;
				else
					return OptionItemJQS.S7;
			}
			case 37: {
				FootBallMatch fbMatch=(FootBallMatch)match;
				Integer halfHomeScore=fbMatch.getHalfHomeScore();
				Integer halfGuestScore=fbMatch.getHalfGuestScore();
				if (halfHomeScore > halfGuestScore && homeScore > guestScore)
					return OptionItemBQC.WIN_WIN;// 胜胜
				else if (halfHomeScore > halfGuestScore && homeScore.equals(guestScore))
					return OptionItemBQC.WIN_DRAW;// 胜平
				else if (halfHomeScore > halfGuestScore && homeScore < guestScore)
					return OptionItemBQC.WIN_LOSE;// 胜负
				else if (halfHomeScore.equals(halfGuestScore) && homeScore > guestScore)
					return OptionItemBQC.DRAW_WIN;// 平胜
				else if (halfHomeScore.equals(halfGuestScore) && homeScore.equals(guestScore))
					return OptionItemBQC.DRAW_DRAW;// 平平
				else if (halfHomeScore.equals(halfGuestScore) && homeScore < guestScore)
					return OptionItemBQC.DRAW_LOSE;// 平负
				else if (halfHomeScore < halfGuestScore && homeScore > guestScore)
					return OptionItemBQC.LOSE_WIN;// 负胜
				else if (halfHomeScore < halfGuestScore && homeScore.equals(guestScore))
					return OptionItemBQC.LOSE_DRAW;// 负平
				else if (halfHomeScore < halfGuestScore && homeScore < guestScore)
					return OptionItemBQC.LOSE_LOSE;// 负负
			}
			case 41: {
				if (homeScore > guestScore)
					return OptionItemSPF.WIN;// 主胜
				else if (homeScore < guestScore)
					return OptionItemSPF.LOSE;// 主负
				else
					return OptionItemSPF.DRAW;// 主平
			}case 44: {
				if(concede==-1){ //主胜WIN-客不败LOSE_RQ
					if (homeScore + concede>= guestScore){
						return OptionItemHT2C1.WIN;
					}else if(homeScore + concede < guestScore){
						return OptionItemHT2C1.LOSE_RQ;
					}
				}else if(concede==1){//客胜LOSE-主不败WIN_RQ
					if (homeScore + concede> guestScore){
						return OptionItemHT2C1.WIN_RQ;
					}else if(homeScore + concede <= guestScore){
						return OptionItemHT2C1.LOSE;
					}
				}else{
					throw new RuntimeException("玩法传递错误");
				}
			}

			case 30: {
				if (homeScore > guestScore)
					return OptionItemSF.WIN;// 主胜
				else
					return OptionItemSF.LOSE;// 主负
			}
			case 31: {
				if (homeScore + rf > guestScore)
					return OptionItemRFSF.WIN;// 主胜
				else
					return OptionItemRFSF.LOSE;// 主负
			}
			case 32: {
				if (1 <= (homeScore - guestScore) && (homeScore - guestScore) <= 5)
					return OptionItemSFC.HW1TO5;
				else if (6 <= (homeScore - guestScore) && (homeScore - guestScore) <= 10)
					return OptionItemSFC.HW6TO10;
				else if (11 <= (homeScore - guestScore) && (homeScore - guestScore) <= 15)
					return OptionItemSFC.HW11TO15;
				else if (16 <= (homeScore - guestScore) && (homeScore - guestScore) <= 20)
					return OptionItemSFC.HW16TO20;
				else if (21 <= (homeScore - guestScore) && (homeScore - guestScore) <= 25)
					return OptionItemSFC.HW21TO25;
				else if (26 <= (homeScore - guestScore))
					return OptionItemSFC.HW26;
				else if (1 <= (guestScore - homeScore) && (guestScore - homeScore) <= 5)
					return OptionItemSFC.GW1TO5;
				else if (6 <= (guestScore - homeScore) && (guestScore - homeScore) <= 10)
					return OptionItemSFC.GW6TO10;
				else if (11 <= (guestScore - homeScore) && (guestScore - homeScore) <= 15)
					return OptionItemSFC.GW11TO15;
				else if (16 <= (guestScore - homeScore) && (guestScore - homeScore) <= 20)
					return OptionItemSFC.GW16TO20;
				else if (21 <= (guestScore - homeScore) && (guestScore - homeScore) <= 25)
					return OptionItemSFC.GW21TO25;
				else if (26 <= (guestScore - homeScore))
					return OptionItemSFC.GW26;
			}
			case 33: {
				if (homeScore + guestScore > dxf)
					return OptionItemDXF.BIG;// 主胜
				else
					return OptionItemDXF.SMALL;// 主负
			}case 43:{
				return null;
			}
			default:
				throw new RuntimeException("玩法传递错误");
		}


	}
	private static <T extends SportteryBetContentModel<X>, X extends MatchItem, M extends AbstactMatch> List<SportteryTicketVO> getUnSheDanVOList(
			List<SportteryPassType> passTypes, final int sheDanSize, final int unDanSize, final List<X> sheDanList, final List<X> unDanList,
			final T planVO, final int sheDanTotal, final LotteryType lotteryType, final boolean isOpenPrize, final Map<String, M> matchMap, final Ticket ticket) {
		final List<SportteryTicketVO> voList = new ArrayList<SportteryTicketVO>();
		// 遍历过关方式
		for (final SportteryPassType type : passTypes) {
			int needMatchCount = type.getMatchCount();// 拿到过关的场次数目
			ExtensionMathUtils.efficientCombExtension(needMatchCount, sheDanSize, unDanSize, new ExtensionCombCallBack() {
				public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
					List<X> tempMatchs = new ArrayList<X>();
					List<String> list = new ArrayList<String>();
					for (int i = 0; i < comb2.length; i++) {
						String intTime = String.valueOf(unDanList.get(i).getIntTime());
						String lineId = String.valueOf(unDanList.get(i).getLineId());
						String key = intTime + "" + lineId;
						if (comb2[i] && !list.contains(key)) {
							list.add(key);
							tempMatchs.add(unDanList.get(i));
						}
					}
					List<SportteryTicketVO> tmpList = buildVo(tempMatchs, type, lotteryType, planVO, isOpenPrize, matchMap,ticket);
					voList.addAll(tmpList);
				}
			});
		}
		return voList;
	}
}
