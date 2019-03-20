package com.qiyun.check;

import com.qiyun.commonModel.PlayType;
import com.qiyun.ticket.Ticket;
import com.qiyun.util.LogUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DcSxdsBingoCheck implements DcBingoCheck {
	/*
	 * BAK //3.26^1.23^-^... -表示还没有出结果 //String spContent =
	 * openResultMap.get("spResult");
	 * 
	 * //上半场比分^下半场比分#上半场比分^下半场比分 //String resultContent =
	 * openResultMap.get("result");
	 */

	private static DecimalFormat DF = new DecimalFormat("#.00");

	public Ticket ticket;

	// 串数^场次,sp值+场次,sp值^金额#串数^场次,sp值+场次,sp值^金额

	public StringBuffer bingoContent = new StringBuffer();

	private HashMap<String, Long> bingoHashMap = new HashMap<String, Long>();

	// private List levelBeanList;

	private HashMap<String, Double> spResultHashMap = new HashMap<String, Double>();

	// 奖级对应奖金
	private HashMap<String, Double> prizeHashMap = new HashMap<String, Double>();

	// 赛事数量
	// private int matchEndCount;

	// 税后
	private double bingoPosttaxTotal;
	// 税前
	private double bingoPretaxTotal;

	private boolean isBingo;

	private boolean isOpenAble = true;
	private boolean isTempOpen=false;
	// private StringBuffer resultSb = new StringBuffer();
	// 选中了的赛事
	private HashMap<Integer, Integer> matchResultMap = new HashMap<Integer, Integer>();

	public void addCheck(BingoCheck otherCheck) {

		DcSxdsBingoCheck check = (DcSxdsBingoCheck) otherCheck;
		if (!check.isOpenAble) {
			this.isOpenAble = false;
			return;
		}

		if (!check.isBingo()) {
			return;
		}
		isBingo = true;

		HashMap<Integer, Integer> otherMatchResultMap = check.getMatchResultMap();
		Iterator<Integer> it = otherMatchResultMap.keySet().iterator();
		while (it.hasNext()) {
			int key = it.next();
			if (this.matchResultMap.containsKey(key)) {
				this.matchResultMap.put(key, otherMatchResultMap.get(key) + this.matchResultMap.get(key));
			} else {
				this.matchResultMap.put(key, otherMatchResultMap.get(key));
			}

		}

		bingoHashMap.put("prize1", bingoHashMap.get("prize1") + check.getBingoHashMap().get("prize1"));
		bingoHashMap.put("prize2", bingoHashMap.get("prize2") + check.getBingoHashMap().get("prize2"));
		bingoHashMap.put("prize3", bingoHashMap.get("prize3") + check.getBingoHashMap().get("prize3"));
		bingoHashMap.put("prize4", bingoHashMap.get("prize4") + check.getBingoHashMap().get("prize4"));
		bingoHashMap.put("prize5", bingoHashMap.get("prize5") + check.getBingoHashMap().get("prize5"));
		bingoHashMap.put("prize6", bingoHashMap.get("prize6") + check.getBingoHashMap().get("prize6"));
		bingoHashMap.put("prize7", bingoHashMap.get("prize7") + check.getBingoHashMap().get("prize7"));
		bingoHashMap.put("prize8", bingoHashMap.get("prize8") + check.getBingoHashMap().get("prize8"));
		bingoHashMap.put("prize9", bingoHashMap.get("prize9") + check.getBingoHashMap().get("prize9"));
		bingoHashMap.put("prize10", bingoHashMap.get("prize10") + check.getBingoHashMap().get("prize10"));
		bingoHashMap.put("prize11", bingoHashMap.get("prize11") + check.getBingoHashMap().get("prize11"));
		bingoHashMap.put("prize12", bingoHashMap.get("prize12") + check.getBingoHashMap().get("prize12"));
		bingoHashMap.put("prize13", bingoHashMap.get("prize13") + check.getBingoHashMap().get("prize13"));
		bingoHashMap.put("prize14", bingoHashMap.get("prize14") + check.getBingoHashMap().get("prize14"));
		bingoHashMap.put("prize15", bingoHashMap.get("prize15") + check.getBingoHashMap().get("prize15"));

		prizeHashMap.put("prize1", prizeHashMap.get("prize1") + check.getPrizeHashMap().get("prize1"));
		prizeHashMap.put("prize2", prizeHashMap.get("prize2") + check.getPrizeHashMap().get("prize2"));
		prizeHashMap.put("prize3", prizeHashMap.get("prize3") + check.getPrizeHashMap().get("prize3"));
		prizeHashMap.put("prize4", prizeHashMap.get("prize4") + check.getPrizeHashMap().get("prize4"));
		prizeHashMap.put("prize5", prizeHashMap.get("prize5") + check.getPrizeHashMap().get("prize5"));
		prizeHashMap.put("prize6", prizeHashMap.get("prize6") + check.getPrizeHashMap().get("prize6"));
		prizeHashMap.put("prize7", prizeHashMap.get("prize7") + check.getPrizeHashMap().get("prize7"));
		prizeHashMap.put("prize8", prizeHashMap.get("prize8") + check.getPrizeHashMap().get("prize8"));
		prizeHashMap.put("prize9", prizeHashMap.get("prize9") + check.getPrizeHashMap().get("prize9"));
		prizeHashMap.put("prize10", prizeHashMap.get("prize10") + check.getPrizeHashMap().get("prize10"));
		prizeHashMap.put("prize11", prizeHashMap.get("prize11") + check.getPrizeHashMap().get("prize11"));
		prizeHashMap.put("prize12", prizeHashMap.get("prize12") + check.getPrizeHashMap().get("prize12"));
		prizeHashMap.put("prize13", prizeHashMap.get("prize13") + check.getPrizeHashMap().get("prize13"));
		prizeHashMap.put("prize14", prizeHashMap.get("prize14") + check.getPrizeHashMap().get("prize14"));
		prizeHashMap.put("prize15", prizeHashMap.get("prize15") + check.getPrizeHashMap().get("prize15"));

		buildBingoContent();
		this.bingoPosttaxTotal += Double.valueOf(DF.format(otherCheck.getBingoPosttaxTotal()));
		this.bingoPretaxTotal += Double.valueOf(DF.format(otherCheck.getBingoPretaxTotal()));
		//判断加入进来的票是否是临时开奖。若是临时开奖，奖金设置为0
		for(String prizeKey:check.bingoHashMap.keySet()){
			Long bingoCount=check.bingoHashMap.get(prizeKey);
			Double prize=check.prizeHashMap.get(prizeKey);
			if(isTempOpen||(bingoCount!=null&&bingoCount>0&&prize==0)){
				bingoPretaxTotal = 0;
				bingoPosttaxTotal =0;
				isTempOpen=true;
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void execute(String content, PlayType playType, int multiple, HashMap<String, String> openResultMap) {
		Integer ticketAmount = Integer.valueOf(openResultMap.get("ticketAmount"));
		Ticket ticket = new Ticket();
		String temp = content.split(":")[1];
		ticket.setContent(temp);
		ticket.setPlayType(playType);
		ticket.setMultiple(multiple);
		ticket.setAmount(ticketAmount);
		execute(ticket, openResultMap);
	}

	/**
	 * 票的内容：41(0),42(1),44(1),44(1)
	 */
	public void execute(Ticket ticket, HashMap<String, String> openResultMap) {
		// levelBeanList = new ArrayList();
		// bingoHashMap = new HashMap<String,Long>();
		bingoHashMap.put("prize1", new Long(0));
		bingoHashMap.put("prize2", new Long(0));
		bingoHashMap.put("prize3", new Long(0));
		bingoHashMap.put("prize4", new Long(0));
		bingoHashMap.put("prize5", new Long(0));
		bingoHashMap.put("prize6", new Long(0));
		bingoHashMap.put("prize7", new Long(0));
		bingoHashMap.put("prize8", new Long(0));
		bingoHashMap.put("prize9", new Long(0));
		bingoHashMap.put("prize10", new Long(0));
		bingoHashMap.put("prize11", new Long(0));
		bingoHashMap.put("prize12", new Long(0));
		bingoHashMap.put("prize13", new Long(0));
		bingoHashMap.put("prize14", new Long(0));
		bingoHashMap.put("prize15", new Long(0));

		prizeHashMap.put("prize1", new Double(0));
		prizeHashMap.put("prize2", new Double(0));
		prizeHashMap.put("prize3", new Double(0));
		prizeHashMap.put("prize4", new Double(0));
		prizeHashMap.put("prize5", new Double(0));
		prizeHashMap.put("prize6", new Double(0));
		prizeHashMap.put("prize7", new Double(0));
		prizeHashMap.put("prize8", new Double(0));
		prizeHashMap.put("prize9", new Double(0));
		prizeHashMap.put("prize10", new Double(0));
		prizeHashMap.put("prize11", new Double(0));
		prizeHashMap.put("prize12", new Double(0));
		prizeHashMap.put("prize13", new Double(0));
		prizeHashMap.put("prize14", new Double(0));
		prizeHashMap.put("prize15", new Double(0));

		if(openResultMap!=null){
			for(Map.Entry<String, String> entry : openResultMap.entrySet()){
				if(entry.getKey().startsWith("spResult")){
					spResultHashMap.put(entry.getKey(),Double.valueOf(entry.getValue()));
				}
			}
		}

		bingoPosttaxTotal = 0;
		bingoPretaxTotal = 0;
		isBingo = false;
		this.ticket = ticket;

		if (ticket.getPlayType().getValue() == PlayType.DC_1.getValue()) {
			// 单关，不管多少赛事多少选项都是一张票，需要特殊处理
			String[] matchAreas = ticket.getContent().split("\\;");

			for (int i = 0; i < matchAreas.length; i++) {
				int matchNo = Integer.valueOf(getBeforeKuoHao(matchAreas[i]));
				// 如果还有比赛是没有结果的，不作开奖处理
				if (spResultHashMap.get("spResult" + matchNo)==null) {
					isOpenAble = false;
					return;
				}
				String optionString = getInKuoHao(matchAreas[i]);
				String[] options = optionString.split("\\,");
				for (int j = 0; j < options.length; j++) {
					int matchResult = getResultByBF(openResultMap.get("wholeScore" + matchNo));
					// 延期即9999，也算中
					if (Integer.valueOf(options[j]) == matchResult || matchResult == 9999) {
						isBingo = true;
						// [单关投注奖金]＝2元×单场开奖SP值（SP）×赔数×65％（如果最后的结果大于0而小于2的,要保底为2）
						// 中奖了
						double danguanbingo = Double.valueOf(2 * spResultHashMap.get("spResult" + matchNo) * 0.65);
						//加奖开始
						int term=Integer.parseInt(openResultMap.get("term"));
						if( term >= 140604 && term <=140606){
							//加奖4%,但不产生税金 公式=含税奖金 / 65% * 4%;
							double add= 2 * spResultHashMap.get("spResult" + matchNo) * 0.04;
							danguanbingo=danguanbingo+add;
						}
						//加奖结束
						if (danguanbingo >= 2.0) {
							bingoPretaxTotal += Double.valueOf(DF.format(danguanbingo * ticket.getMultiple().intValue()));
						}
						else if (danguanbingo > 0 && danguanbingo < 2.0) {
							bingoPretaxTotal += Double.valueOf(DF.format(2.0 * ticket.getMultiple().intValue()));
						}
						bingoPosttaxTotal = bingoPretaxTotal;

						if (matchResultMap.containsKey(matchNo)) {
							matchResultMap.put(matchNo, matchResultMap.get(matchNo) + 1);
						} else {
							matchResultMap.put(matchNo, 1);
						}
						bingoHashMap.put("prize1", 1l);
						prizeHashMap.put("prize1", bingoPosttaxTotal);
					}
				}
			}
		} else {
			// 过关的开奖算法
			// 这里的特殊处理是要考虑比赛取消的情况
			String[] matchAreas = ticket.getContent().split("\\;");
			int passCount = 0;
			int cancelSum = 1;
			int cancelCount = 0;
			double spSum = 1;
			for (int i = 0; i < matchAreas.length; i++) {
				int matchNo = Integer.valueOf(getBeforeKuoHao(matchAreas[i]));
				// 如果还有比赛是没有结果的，不作开奖处理
				if (spResultHashMap.get("spResult" + matchNo)==null) {
					isOpenAble = false;
					return;
				}
				String optionString = getInKuoHao(matchAreas[i]);
				String[] options = optionString.split("\\,");
				for (int j = 0; j < options.length; j++) {
					int matchResult = getResultByBF(openResultMap.get("wholeScore" + matchNo));
					if (matchResult == 9999) {
						cancelSum *= options.length;
						cancelCount++;
						passCount++;
						// resultSb.append(matchNo).append("(").append(options.length).append("),");

						matchResultMap.put(matchNo, options.length);
						spSum *= spResultHashMap.get("spResult" + matchNo);
						break;
					} else if (Integer.valueOf(options[j]) == matchResult) {
						spSum *= spResultHashMap.get("spResult" + matchNo);
						passCount++;
						// resultSb.append(matchNo).append("(").append(1).append("),");

						if (matchResultMap.containsKey(matchNo)) {
							matchResultMap.put(matchNo, matchResultMap.get(matchNo) + 1);
						} else {
							matchResultMap.put(matchNo, 1);
						}
					}
				}
			}
			// 过关成功
			if (passCount == matchAreas.length) {
				isBingo = true;
				bingoHashMap.put("prize" + passCount, 1l * cancelSum);
				double _pre = 2 * spSum * 0.65;
				double _post = _pre > 10000.0 ? _pre * 0.8 : _pre;
				//加奖开始
				int term=Integer.parseInt(openResultMap.get("term"));
				if( term >= 140604 && term <=140606){
					//加奖4%,但不产生税金 公式=含税奖金 / 65% * 4%;
					double add= 2 * spSum *0.04;
					_post=_post+add;
					_pre=_pre+add;
				}
				//加奖结束

				//表示购买的过关赛事都为取消
				if(cancelCount == matchAreas.length){
					//直接返回本金
					bingoPretaxTotal +=ticket.getAmount().doubleValue();
					bingoPosttaxTotal +=ticket.getAmount().doubleValue();
				}else{
					bingoPretaxTotal += Double.valueOf(DF.format(_pre * cancelSum * ticket.getMultiple().intValue()));
					bingoPosttaxTotal += Double.valueOf(DF.format(_post * cancelSum * ticket.getMultiple().intValue()));
				}
				prizeHashMap.put("prize" + passCount, bingoPosttaxTotal);
			}
		}
		/*
		 * if(resultSb.length() > 0){ resultSb.deleteCharAt(resultSb.length()
		 * -1); }
		 */
		this.buildBingoContent();
	}

	public void buildBingoContent() {
		bingoContent = new StringBuffer();
		bingoContent.append("prize1^").append(bingoHashMap.get("prize1")).append("^").append(Double.valueOf(DF.format(prizeHashMap.get("prize1"))))
				.append("#");
		bingoContent.append("prize2^").append(bingoHashMap.get("prize2")).append("^").append(Double.valueOf(DF.format(prizeHashMap.get("prize2"))))
				.append("#");
		;
		bingoContent.append("prize3^").append(bingoHashMap.get("prize3")).append("^").append(Double.valueOf(DF.format(prizeHashMap.get("prize3"))))
				.append("#");
		bingoContent.append("prize4^").append(bingoHashMap.get("prize4")).append("^").append(Double.valueOf(DF.format(prizeHashMap.get("prize4"))))
				.append("#");
		;
		bingoContent.append("prize5^").append(bingoHashMap.get("prize5")).append("^").append(Double.valueOf(DF.format(prizeHashMap.get("prize5"))))
				.append("#");
		bingoContent.append("prize6^").append(bingoHashMap.get("prize6")).append("^").append(Double.valueOf(DF.format(prizeHashMap.get("prize6"))))
				.append("#");
		bingoContent.append("prize7^").append(bingoHashMap.get("prize7")).append("^").append(Double.valueOf(DF.format(prizeHashMap.get("prize7"))))
				.append("#");
		bingoContent.append("prize8^").append(bingoHashMap.get("prize8")).append("^").append(Double.valueOf(DF.format(prizeHashMap.get("prize8"))))
				.append("#");
		bingoContent.append("prize9^").append(bingoHashMap.get("prize9")).append("^").append(Double.valueOf(DF.format(prizeHashMap.get("prize9"))))
				.append("#");
		bingoContent.append("prize10^").append(bingoHashMap.get("prize10")).append("^")
				.append(Double.valueOf(DF.format(prizeHashMap.get("prize10")))).append("#");
		bingoContent.append("prize11^").append(bingoHashMap.get("prize11")).append("^")
				.append(Double.valueOf(DF.format(prizeHashMap.get("prize11")))).append("#");
		bingoContent.append("prize12^").append(bingoHashMap.get("prize12")).append("^")
				.append(Double.valueOf(DF.format(prizeHashMap.get("prize12")))).append("#");
		bingoContent.append("prize13^").append(bingoHashMap.get("prize13")).append("^")
				.append(Double.valueOf(DF.format(prizeHashMap.get("prize13")))).append("#");
		bingoContent.append("prize14^").append(bingoHashMap.get("prize14")).append("^")
				.append(Double.valueOf(DF.format(prizeHashMap.get("prize14")))).append("#");
		bingoContent.append("prize15^").append(bingoHashMap.get("prize15")).append("^")
				.append(Double.valueOf(DF.format(prizeHashMap.get("prize15"))));
		if (matchResultMap.size() > 0) {
			bingoContent.append("%");
			StringBuffer sb = new StringBuffer();
			Iterator it = this.matchResultMap.keySet().iterator();
			while (it.hasNext()) {
				int matchNo = (Integer) it.next();
				int values = this.matchResultMap.get(matchNo);
				sb.append(matchNo).append("(").append(values).append(")").append(",");
			}
			if (sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
			bingoContent.append(sb.toString());
		}
	}

	// 返回上+单0 上+双 1 下+单 2 下+双 3
	public static int getResultByBF(String wholeScore) {
		// 比赛取消
		if ("*".equals(wholeScore)) {
			return 9999;
		}
		String[] socreArea = wholeScore.split(":");
		int wholeScoreNum = Integer.valueOf(socreArea[0]) + Integer.valueOf(socreArea[1]);

		if (wholeScoreNum >= 3 && wholeScoreNum % 2 != 0)
			return 0;
		else if (wholeScoreNum >= 3 && wholeScoreNum % 2 == 0)
			return 1;
		else if (wholeScoreNum < 3 && wholeScoreNum % 2 != 0)
			return 2;
		else
			return 3;
	}

	// 拿到括号里面的字符串
	private String getInKuoHao(String kuoHaoString) {
		return kuoHaoString.substring(kuoHaoString.indexOf("(") + 1, kuoHaoString.length() - 1);
	}

	private String getBeforeKuoHao(String kuoHaoString) {
		return kuoHaoString.substring(0, kuoHaoString.indexOf('('));
	}

	public String getBingoContent() {
		return this.bingoContent.toString();
	}

	public String getBingoContentTicket() {
		return this.bingoContent.toString().split("%")[0];
	}

	public HashMap<String, Long> getBingoHashMap() {
		return this.bingoHashMap;
	}

	public double getBingoPosttaxTotal() {
		return this.bingoPosttaxTotal;
	}

	public double getBingoPretaxTotal() {
		return this.bingoPretaxTotal;
	}

	public boolean isBingo() {
		return this.isBingo;
	}

	// 复制对象
	public BingoCheck clone() throws CloneNotSupportedException {
		return (BingoCheck) super.clone();
	}

	public HashMap<String, Double> getPrizeHashMap() {
		return prizeHashMap;
	}

	/*
	 * public StringBuffer getResultSb() { return resultSb; }
	 */
	public boolean isOpenAble() {
		return isOpenAble;
	}

	public HashMap<Integer, Integer> getMatchResultMap() {
		return matchResultMap;
	}

	public static void main(String[] ar) {
		DcSxdsBingoCheck check = new DcSxdsBingoCheck();
		HashMap<String, String> openResultMap = new HashMap<String, String>();
		openResultMap.put("spResult1", "1");
		openResultMap.put("spResult2", "2");
		openResultMap.put("spResult3", "10");

		openResultMap.put("wholeScore1", "*");
		openResultMap.put("wholeScore2", "4:0");
		openResultMap.put("wholeScore3", "1:0");

		openResultMap.put("concede1", "0");
		openResultMap.put("concede2", "0");
		openResultMap.put("concede3", "0");

		openResultMap.put("result", "1(1),2(3),3(0)");
		openResultMap.put("term", "100518");

		check.execute("101:1(0)", PlayType.DC_1, 1, openResultMap);

		LogUtil.info(check.getBingoContent());
	}

	public static double round(double v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException("The scale must be a positive integer or zero");

		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

}
