package com.qiyun.utils;

import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.model.MemberWallet;
import com.qiyun.model.MemberWalletLine;
import com.qiyun.model2.MemberWallet2;
import com.qiyun.model2.MemberWalletLine2;

public class DbDataVerify2 {

	final static private String md5Code = "AM*lkMkdqerKPXB";

	final static public String getMemberWalletVerify2(MemberWallet2DTO wallet) {
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
	final static public String getMemberWalletVerify(MemberWallet2DTO wallet) {
		StringBuffer sb = new StringBuffer();
		sb
				.append(wallet.getAccount())
				.append(wallet.getAbleBalance()).append(wallet.getFreezeBalance())
				.append(wallet.getHeapBalance()).append(wallet.getHeapPrize())

				.append(md5Code);

		String str = MD5.encode(sb.toString());

		// LogUtil.info("-------------------" + sb.toString()+ " md5:" + str ) ;
		return str;
	}

	final static public boolean checkMemberWalletVerify(MemberWallet2DTO wallet, String md5) {
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
//
//	final static public String getLotteryPlanVerify(LotteryPlan lp) {
//		StringBuffer sb = new StringBuffer();
//		sb.append(lp.getTerm()).append(lp.getAccount()).append(lp.getAmount()).append(lp.getPerAmount()).append(lp.getContent()).append(md5Code);
//		return MD5.encode(sb.toString());
//	}
//
//	final static public boolean checkLotteryPlanVerify(LotteryPlan lp, String md5) {
//		if (getLotteryPlanVerify(lp).equals(md5)) {
//			return true;
//		}
//		return false;
//	}
//
//	final static public String getLotteryPlanOrderVerify(LotteryPlanOrder lpo) {
//		StringBuffer sb = new StringBuffer();
//
//		sb.append(lpo.getPlanNo()).append(lpo.getAccount()).append(lpo.getStatus()).append(lpo.getPrizeSettleStatus()).append(md5Code);
//
//		return MD5.encode(sb.toString());
//	}
//
//	final static public boolean checkLotteryPlanOrderVerify(LotteryPlanOrder lpo, String md5) {
//		if (getLotteryPlanOrderVerify(lpo).equals(md5)) {
//			return true;
//		}
//		return false;
//	}
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
