package com.qiyun.chaiPiao;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.TicketStatus;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Ticket2WithBLOBs;
import com.qiyun.util.LogUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SetTicket {

	// ticket公有的属性设置， 传入的ticket需要设置价格、玩法、内容
	public static Ticket2WithBLOBs setTicket(Ticket2WithBLOBs ticket, LotteryPlan2WithBLOBs lotteryPlan) {
		ticket.setLotteryType(lotteryPlan.getLotteryType());
		ticket.setTerm(lotteryPlan.getTerm());
		ticket.setPlanNo(lotteryPlan.getPlanNo());
		ticket.setStatus(TicketStatus.WSP.getValue());
		ticket.setCreateDateTime(new Date());
		ticket.setDealDateTime(lotteryPlan.getDealDateTime());
		if(LotteryType.JC_ZQ_DGTZ.getValue() == lotteryPlan.getLotteryType() || LotteryType.JC_LQ_DGTZ.getValue() == lotteryPlan.getLotteryType()){
			//足球单关固定和篮球单关固定拆票已经计算好倍数,不需要再设置
		} else {
			ticket.setMultiple(lotteryPlan.getMultiple());
		}
		ticket.setIsBingo(new Integer(1));
		ticket.setIsConvert(new Integer(1));
		ticket.setAccount(lotteryPlan.getAccount());
		return ticket;
	}

	public static List processBeishu(List<Ticket2WithBLOBs> srcList, int currBeishu, int maxBeishu) {
		List<Ticket2WithBLOBs> newList = new ArrayList();
		 {
			try {
				
				// 如果倍数超过最大倍数时，拆分
				for (Ticket2WithBLOBs t : srcList) {

					//计算单背金额
					int singleAmount = t.getAmount()/t.getMultiple();
					//计算2万的倍数
					int bei2W = 20000/singleAmount;
					//以两者小的那个做为最大倍数
					int limitBeishu = bei2W < maxBeishu ? bei2W : maxBeishu;
					if (limitBeishu == 0 ) limitBeishu =1; // 最小1倍
					
					for (int i = 0; i < currBeishu / limitBeishu; i++) {
						Ticket2WithBLOBs newTicket = t.clone();
						newTicket.setMultiple(limitBeishu);
						// 重算金额
						newTicket.setAmount(t.getAmount() / currBeishu * limitBeishu);
						newList.add(newTicket);
					}
					// 处理倍数的尾数
					int wei = currBeishu % limitBeishu;
					if (wei != 0) {
						Ticket2WithBLOBs newTicket = t.clone();
						newTicket.setMultiple(wei);
						// 重算金额
						newTicket.setAmount(t.getAmount() / currBeishu * wei);
						newList.add(newTicket);
					}
				}

			} catch (Exception e) {
				LogUtil.error(e);
			}
			return newList;
		}
	}
}
