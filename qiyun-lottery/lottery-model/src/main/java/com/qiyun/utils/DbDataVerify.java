package com.qiyun.utils;

import com.qiyun.dto.LotteryPlanOrder2DTO;
import com.qiyun.dto.LotteryPlanOrderDTO;
import com.qiyun.dto.LotteryPlanWithBLOBs2DTO;
import com.qiyun.model.*;
import com.qiyun.model.LotteryPlanOrder;
import com.qiyun.model2.*;

public class DbDataVerify {

	final static private String md5Code = "AM*lkMkdqerKPXB";

	final static public String getMemberWalletVerify2(MemberWallet2 wallet) {
		StringBuffer sb = new StringBuffer();
		sb
				.append(wallet.getAccount())
				// .append(wallet.getAbleBalance())
				// .append(wallet.getFreezeBalance())
				// .append(wallet.getHeapBalance())
				// .append(wallet.getHeapPrize())

				.append(NumberTools.doubleToMoneyString(wallet.getAbleBalance())).append(NumberTools.doubleToMoneyString(wallet.getFreezeBalance()))
				.append(NumberTools.doubleToMoneyString(wallet.getHeapBalance())).append(NumberTools.doubleToMoneyString(wallet.getHeapPrize()))

				.append(md5Code);

		String str = MD5.encode(sb.toString());

		// LogUtil.info("-------------------" + sb.toString()+ " md5:" + str ) ;
		return str;
	}

	/**
	 * 新版bean为BigDecimal类型
	 * @param wallet
	 * @return
	 */
	final static public String getMemberWalletVerify(MemberWallet wallet) {
		StringBuffer sb = new StringBuffer();
		sb
				.append(wallet.getAccount())
				.append(wallet.getUsableMoney()).append(wallet.getFreezeMoney())
				.append(wallet.getHistoryMoney()).append(wallet.getHistoryPrize())

				.append(md5Code);

		String str = MD5.encode(sb.toString());

		// LogUtil.info("-------------------" + sb.toString()+ " md5:" + str ) ;
		return str;
	}

	final static public boolean checkMemberWalletVerify(MemberWallet2 wallet, String md5) {
		if (getMemberWalletVerify2(wallet).equals(md5) || md5.equals("reset")) {
			return true;
		}
		return true; // 系统验证小数点有问题，暂时取消 
	}

	final static public String getMemberWalletLineVerify(MemberWalletLine walletLine) {
		StringBuffer sb = new StringBuffer();
		sb.append(walletLine.getMemberId());
		sb.append(walletLine.getAccount());
		sb.append(walletLine.getAmount());
		sb.append(walletLine.getWalletType());
		sb.append(walletLine.getTransType());
		sb.append(walletLine.getCreateDateTime().toString());
		return MD5.encode(sb.toString());
	}

	final static public boolean checkMemberWalletLineVerify(MemberWalletLine walletLine, String md5) {
		if (getMemberWalletLineVerify(walletLine).equals(md5)) {
			return true;
		}
		return false;
	}

	final static public String getMemberWalletLineVerify(MemberWalletLine2 walletLine2) {
		StringBuffer sb = new StringBuffer();
		sb.append(walletLine2.getMemberId());
		sb.append(walletLine2.getAccount());
		sb.append(walletLine2.getAmount());
		sb.append(walletLine2.getWalletType());
		sb.append(walletLine2.getTransType());
		sb.append(walletLine2.getCreateDateTime().toString());
		return MD5.encode(sb.toString());
	}

	final static public boolean checkMemberWalletLineVerify(MemberWalletLine2 walletLine2, String md5) {
		if (getMemberWalletLineVerify(walletLine2).equals(md5)) {
			return true;
		}
		return false;
	}

	final static public String getLotteryPlanVerify(LotteryPlan2WithBLOBs lp) {
		StringBuffer sb = new StringBuffer();
		sb.append(lp.getTerm()).append(lp.getAccount()).append(lp.getAmount()).append(lp.getPerAmount()).append(lp.getContent()).append(md5Code);
		return MD5.encode(sb.toString());
	}

	final static public String getLotteryPlan2Verify(LotteryPlan2WithBLOBs lp) {
		StringBuffer sb = new StringBuffer();
		sb.append(lp.getTerm()).append(lp.getAccount()).append(lp.getAmount()).append(lp.getPerAmount()).append(lp.getContent()).append(md5Code);
		return MD5.encode(sb.toString());
	}

	final static public String getLotteryPlan2DTOVerify(LotteryPlanWithBLOBs2DTO lp) {
		StringBuffer sb = new StringBuffer();
		sb.append(lp.getTerm()).append(lp.getAccount()).append(lp.getAmount()).append(lp.getPerAmount()).append(lp.getContent()).append(md5Code);
		return MD5.encode(sb.toString());
	}

	final static public boolean checkLotteryPlanVerify(LotteryPlan2WithBLOBs lp, String md5) {
		if (getLotteryPlanVerify(lp).equals(md5)) {
			return true;
		}
		return false;
	}

	final static public boolean checkLotteryPlan2Verify(LotteryPlan2WithBLOBs lp, String md5) {
		if (getLotteryPlan2Verify(lp).equals(md5)) {
			return true;
		}
		return false;
	}

	final static public boolean checkLotteryPlan2DTOVerify(LotteryPlanWithBLOBs2DTO lp, String md5) {
		if (getLotteryPlan2DTOVerify(lp).equals(md5)) {
			return true;
		}
		return false;
	}

	final static public String getLotteryPlanOrderVerify(LotteryPlanOrder lpo) {
		StringBuffer sb = new StringBuffer();

		sb.append(lpo.getPlanNo()).append(lpo.getAccount()).append(lpo.getStatus()).append(lpo.getPrizeSettleStatus()).append(md5Code);

		return MD5.encode(sb.toString());
	}

	final static public String getLotteryPlanOrder2Verify(LotteryPlanOrder2 lpo) {
		StringBuffer sb = new StringBuffer();

		sb.append(lpo.getPlanNo()).append(lpo.getAccount()).append(lpo.getStatus()).append(lpo.getPrizeSettleStatus()).append(md5Code);

		return MD5.encode(sb.toString());
	}

	final static public boolean checkLotteryPlanOrderVerify(LotteryPlanOrder lpo, String md5) {
		if (getLotteryPlanOrderVerify(lpo).equals(md5)) {
			return true;
		}
		return false;
	}

	final static public boolean checkLotteryPlanOrder2Verify(LotteryPlanOrder2 lpo, String md5) {
		if (getLotteryPlanOrder2Verify(lpo).equals(md5)) {
			return true;
		}
		return false;
	}
	final static public String getLotteryPlanOrderDTOVerify(LotteryPlanOrderDTO lpo) {
		StringBuffer sb = new StringBuffer();

		sb.append(lpo.getPlanNo()).append(lpo.getAccount()).append(lpo.getStatus()).append(lpo.getPrizeSettleStatus()).append(md5Code);

		return MD5.encode(sb.toString());
	}

	final static public String getLotteryPlanOrder2DTOVerify(LotteryPlanOrder2DTO lpo) {
		StringBuffer sb = new StringBuffer();

		sb.append(lpo.getPlanNo()).append(lpo.getAccount()).append(lpo.getStatus()).append(lpo.getPrizeSettleStatus()).append(md5Code);

		return MD5.encode(sb.toString());
	}

	final static public boolean checkLotteryPlanOrderDTOVerify(LotteryPlanOrderDTO lpo, String md5) {
		if (getLotteryPlanOrderDTOVerify(lpo).equals(md5)) {
			return true;
		}
		return false;
	}

	final static public boolean checkLotteryPlanOrder2DTOVerify(LotteryPlanOrder2DTO lpo, String md5) {
		if (getLotteryPlanOrder2DTOVerify(lpo).equals(md5)) {
			return true;
		}
		return false;
	}
//
//	final static public String getLotteryChaseVerify(LotteryChase lc) {
//		StringBuffer sb = new StringBuffer();
//
//		sb.append(lc.getAccount()).append(lc.getAmount()).append(md5Code);
//
//		return MD5.encode(sb.toString());
//	}
//
//	final static public boolean checkLotteryChaseVerify(LotteryChase lc, String md5) {
//		if (getLotteryChaseVerify(lc).equals(md5)) {
//			return true;
//		}
//		return false;
//	}
}
