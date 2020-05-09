package com.qiyun.checkBingo;

import com.qiyun.commonModel.PlayType;
import com.qiyun.model.*;
import com.qiyun.utils.ArithUtil;
import com.qiyun.utils.CommonUtils;
import com.qiyun.utils.NumberTools;
import com.qiyun.utils.StringTools;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class SportteryBingoCheck<T extends SportteryTicketModel<X>, X extends MatchItem> implements BingoCheck {

	protected Map<String, Double> prizeHashMap = new HashMap<String, Double>();
	protected HashMap<String, Long> bingoHashMap = new HashMap<String, Long>();

	public StringBuffer bingoContent = new StringBuffer();// 中奖后的内容
	protected double bingoPretaxTotal;// 税前奖金
	protected double bingoPosttaxTotal;// 税后奖金
	protected static DecimalFormat DF = new DecimalFormat("#.00");
	protected boolean isBingo = false;
	protected boolean isOpenAble = true;

	@SuppressWarnings("unchecked")
	public void addCheck(BingoCheck otherCheck) {
		SportteryBingoCheck<T, X> check = (SportteryBingoCheck<T, X>) otherCheck;
		if (!check.isOpenAble) {
			this.isOpenAble = false;
			return;
		}
		if (!check.isBingo)
			return;
		isBingo = true;
		// 中奖情况加入
		for (String key : check.bingoHashMap.keySet()) {
			if (this.bingoHashMap.containsKey(key))
				this.bingoHashMap.put(key, this.bingoHashMap.get(key) + check.bingoHashMap.get(key));
			else
				this.bingoHashMap.put(key, check.bingoHashMap.get(key));
		}
		for (String key : check.prizeHashMap.keySet()) {
			if (this.prizeHashMap.containsKey(key))
				this.prizeHashMap.put(key, this.prizeHashMap.get(key) + check.prizeHashMap.get(key));
			else
				this.prizeHashMap.put(key, check.prizeHashMap.get(key));
		}
		this.bingoPosttaxTotal += Double.valueOf(DF.format(check.getBingoPosttaxTotal()));
		this.bingoPretaxTotal += Double.valueOf(DF.format(check.getBingoPretaxTotal()));
	}
	/**
	 * 竞彩篮球开奖算法
	 */
	public void execute(String content, PlayType playType, int multiple, HashMap<String, String> openResultMap) {
		T ticketModel = CommonUtils.Object4TikectJson(content, getTClass(), getXClass());
		List<X> matchItems = ticketModel.getMatchItems();
		String type = openResultMap.get("lotteryType");
		if (ticketModel.getPassType()== SportteryPassType.P1) {// 处理单关
															  //胜分差单关/过关 (比分单关/过关)一起投注.拆票会设置passMode为PASS
			// 根据玩法取得比赛的选项
			Double resultAward = 0d;
			for (X x : matchItems) {
				Double tempAward = 0d;
				try {//赛事取消的情况
					Map<String, String> matchResultMap = new HashMap<String, String>();
					String tempKey = x.getIntTime() + "_" + x.getLineId();
					String tempHomeScore = openResultMap.get(CommonUtils.homeScoreKey + tempKey);
					String tempGuestScore = openResultMap.get(CommonUtils.guestScoreKey + tempKey);
					matchResultMap.put(CommonUtils.homeScoreKey, tempHomeScore);
					matchResultMap.put(CommonUtils.guestScoreKey, tempGuestScore);

					if (tempHomeScore.equals("-1")) {// 赛事取消
						tempAward = ArithUtil.mul(2, x.getOptions().size());
					} else {
						String tmpType=x.getOptions().get(0).getType();
						if(StringTools.isNullOrBlank(tmpType)){ //子玩法类型不存在
							tmpType=type;
						}
						OptionItem option = getPassOptionItem(tmpType, x, matchResultMap); //跟过关一些需要拿回写的让分/大小分开奖
						SportteryOption winOption=x.won(option);
						boolean isWon =  winOption== null ? false : true;// 是否中奖
						if (!isWon)
							continue;
						//竞彩篮球单关改为固定奖
						tempAward = ArithUtil.mul(winOption.getAward(),2);
					}
					if (tempAward < 2)
						tempAward = 2d;// 不足两元补足两元
					resultAward =ArithUtil.add(resultAward, tempAward);
					isBingo = true;
					if (bingoHashMap.get("单关") != null)
						bingoHashMap.put("单关:", bingoHashMap.get("单关") + 1);
					else
						bingoHashMap.put("单关:", 1l);
				} catch (NullPointerException e) {
					isOpenAble = false;
					break;// 空指针异常，说明选择的赛事中有赛事还未结果
				}
			}
			resultAward=ArithUtil.sixRound(resultAward);
			resultAward=resultAward>100000?100000:resultAward;//单关固定奖 最高10w一张票
			// 计算奖金
			bingoPretaxTotal = NumberTools.round(ArithUtil.add(bingoPretaxTotal,ArithUtil.mul(resultAward , ticketModel.getMultiple())),2);
			if (resultAward > 10000) {// 税后
				resultAward = ArithUtil.mul(resultAward, 0.8);
				resultAward=ArithUtil.round2Scale(resultAward);
			}
			bingoPosttaxTotal =NumberTools.round(ArithUtil.add(bingoPosttaxTotal,ArithUtil.mul(resultAward , ticketModel.getMultiple())),2);
			prizeHashMap.put("单关:", bingoPosttaxTotal);// 单关的奖金加入
		} else {// 处理过关
			boolean hit = true;// 先定义好，假设全部命中
			double resultAward = 1d;
			int cancelSum = 0;
			for (X x : matchItems) {
				try {
					Map<String, String> matchResultMap = new HashMap<String, String>();
					String tempKey = x.getIntTime() + "_" + x.getLineId();
					String tempHomeScore = openResultMap.get(CommonUtils.homeScoreKey + tempKey);
					String tempGuestScore = openResultMap.get(CommonUtils.guestScoreKey + tempKey);
					// 赛事取消的情况
					if (tempHomeScore.equals("-1")) {
						resultAward = ArithUtil.mul(x.getOptions().size(),resultAward);
						cancelSum++;
					} else {
						matchResultMap.put(CommonUtils.homeScoreKey, tempHomeScore);
						matchResultMap.put(CommonUtils.guestScoreKey, tempGuestScore);
						OptionItem item = getPassOptionItem(type, x, matchResultMap);
						SportteryOption wonItem = x.won(item);
						hit = wonItem == null ? false : true;
						if (hit == false)
							break;
						Double tempAward = Double.valueOf(wonItem.getAward());
						resultAward =ArithUtil.mul(tempAward,resultAward);
					}
				} catch (NullPointerException e) {
					hit = false;
					isOpenAble = false;
					break;
				}
			}
			if (hit) {
				resultAward =ArithUtil.mul(resultAward, 2);// 乘以2
				resultAward=ArithUtil.sixRound(resultAward);
				Double tempAward = resultAward;
				int passCount = matchItems.size() - cancelSum;
				if (tempAward > 200000) {// 如果金额超过20万:一般都很难所以这里以金额做判断
					if (passCount <= 3) {
						tempAward = 200000d;
					} else if (4 <= passCount && passCount <= 5) {
						tempAward = tempAward > 500000 ? 500000d : tempAward;
					} else if (6 <= passCount) {
						tempAward = tempAward > 1000000 ? 1000000d : tempAward;
					}
				}
				// 税前奖金
				bingoPretaxTotal =NumberTools.round(ArithUtil.add(bingoPretaxTotal,ArithUtil.mul(tempAward , ticketModel.getMultiple())),2);
				if (tempAward > 10000) {// 税后
					tempAward =ArithUtil.mul(tempAward,0.8d);
					tempAward=ArithUtil.round2Scale(tempAward);
				}
				bingoPosttaxTotal =NumberTools.round(ArithUtil.add(bingoPosttaxTotal,ArithUtil.mul(tempAward , ticketModel.getMultiple())),2);
				bingoHashMap.put(matchItems.size() + "串1", 1l);
				isBingo = true;
				prizeHashMap.put(matchItems.size() + "串1", bingoPosttaxTotal);// 过关的奖金加入
			}
		}
	}

	public String getBingoContent() {
		bingoContent = new StringBuffer();
		for (String key : bingoHashMap.keySet()) {
			bingoContent.append(key).append("^" + bingoHashMap.get(key)).append("^").append(Double.valueOf(DF.format(prizeHashMap.get(key)))).append(
					"元#");
		}
		return bingoContent.toString();
	}

	public HashMap<String, Long> getBingoHashMap() {
		return this.bingoHashMap;
	}

	public double getBingoPosttaxTotal() {
		return bingoPosttaxTotal;
	}

	public double getBingoPretaxTotal() {
		return bingoPretaxTotal;
	}

	public boolean isBingo() {
		return isBingo;
	}

	/**
	 * @return the isOpenAble
	 */
	public boolean isOpenAble() {
		return isOpenAble;
	}

	/**
	 * @param isOpenAble
	 *            the isOpenAble to set
	 */
	public void setOpenAble(boolean isOpenAble) {
		this.isOpenAble = isOpenAble;
	}

	// 复制对象
	public BingoCheck clone() throws CloneNotSupportedException {
		return (BingoCheck) super.clone();
	}

	public abstract Class<T> getTClass();

	public abstract Class<X> getXClass();

	public abstract OptionItem getPassOptionItem(String lotteryType, X matchItem, Map<String, String> resultMap);
}
