package com.qiyun.ticket;

// Generated by MyEclipse Persistence Tools

/**
 * Ticket generated by MyEclipse Persistence Tools
 */
public class Ticket extends AbstractTicket implements Cloneable {
//
//	// Constructors
//	private String ticketInfo;//增加票面信息属性
//
//	/** default constructor */
//	public Ticket() {
//	}
//
//	/** minimal constructor */
//	public Ticket(Integer planNo, String term, Date createDateTime, Date dealDateTime, Integer multiple, PlayType playType, TicketStatus status,
//			String account) {
//		super(planNo, term, createDateTime, dealDateTime, multiple, playType, status, account);
//	}
//
//	/** full constructor */
//	public Ticket(Integer planNo, String content, String term, LotteryType lotteryType, Integer amount, Date createDateTime, Date sendDateTime,
//				  Date printDateTime, Date dealDateTime, Integer multiple, PlayType playType, Integer isBingo, Double bingoAmount, String bingoContent,
//				  TicketStatus status, String addAttribute, String account, String outId, Integer noInBatch, String batchNo, Integer isConvert,
//				  Date convertDateTime) {
//		super(planNo, content, term, lotteryType, amount, createDateTime, sendDateTime, printDateTime, dealDateTime, multiple, playType, isBingo,
//				bingoAmount, bingoContent, status, addAttribute, account, outId, noInBatch, batchNo, isConvert, convertDateTime);
//	}
//
//	public Ticket clone() throws CloneNotSupportedException {
//		return (Ticket) super.clone();
//	}
//
//	public String getContentShow() {
//		//票的内容显示.增加文字转换,如扑克3转换成点数
//		return BallCodeConverter.convert(getLotteryType().getValue(), getPlayType().getValue(), super.getContent().replaceAll("\\^", "^<br>"));
//	}
//
//	@SuppressWarnings("unchecked")
//	public static String getJcPlanContent(Ticket ticket,LotteryPlan plan) {
//		String content = ticket.getContent();
//		StringBuilder matchItemsStr=new StringBuilder("");
//		if (content != null && content.length() > 0) {
//			SportteryTicketModel comtent=null;
//			if(LotteryType.JCLQList.contains(plan.getLotteryType())){
//				comtent= CommonUtils.Object4TikectJson(content, SportteryTicketModel.class,
//						BasketBallMatchItem.class);
//	    	}else if(LotteryType.JCZQList.contains(plan.getLotteryType())){
//	    		comtent=CommonUtils.Object4TikectJson(content, SportteryTicketModel.class,
//						FootBallMatchItem.class);
//	    	}
//
//			List<MatchItem> matchItemList = comtent.getMatchItems();
//
//			boolean isPass = comtent.getPassMode() == 1;
//			if(ticket.getLotteryType()==LotteryType.JC_ZQ_BF){
//				isPass=comtent.getPassType()!=SportteryPassType.P1;
//			}
//			if (!isPass) {// 单关
//				matchItemsStr.append("单关:");
//			}else{
//				matchItemsStr.append("过关:");
//			}
//			for (MatchItem item : matchItemList) {
//				matchItemsStr.append(item.show2String(isPass, plan.getLotteryType()));
//			}
//		}
//		return matchItemsStr.toString();
//	}
//	public static String getGyjContent(Ticket ticket) {
//		String selectValue = "";
//		LotteryType lt = ticket.getLotteryType();
//		String content = ticket.getContent();
//		if (content != null && content.length() > 0) {
//			SportteryTicketModel comtent = CommonUtils.Object4TikectJson(ticket.getContent(), SportteryTicketModel.class, FootBallMatchItem.class);
//			List<FootBallMatchItem> matchItemList = comtent.getMatchItems();
//
//			if (comtent.getPassMode() == 0) {
//				selectValue = "单关:";
//			} else {
//				selectValue = "过关:";
//			}
//			for (int i = 0; i < matchItemList.size(); i++) {
//				FootBallMatchItem item = matchItemList.get(i);
//				List<SportteryOption> optionList = item.getOptions();
//				SportteryOption option = optionList.get(0);
//				selectValue += item.getGyjTeam() + "(";
//				selectValue+=option.getAward();
//				selectValue += ")";
//			}
//		}
//		return selectValue;
//	}
//
//	public String getTicketInfo() {
//		return ticketInfo;
//	}
//
//	public void setTicketInfo(String ticketInfo) {
//		this.ticketInfo = ticketInfo;
//	}

}
