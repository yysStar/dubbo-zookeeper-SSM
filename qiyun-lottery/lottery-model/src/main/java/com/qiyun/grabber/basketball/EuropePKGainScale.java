package com.qiyun.grabber.basketball;


import com.qiyun.util.NumberTools;

/**
 * 欧洲盘口盈利比计算
 * 
 */
public class EuropePKGainScale {

	/**
	 * 
	 * @param spScale
	 *            奖金值 spScale[0](win); spScale[1](lose))
	 * @param waterLevel
	 *            盘口水位 waterLevel[0](host team); waterLevel[1](away team)
	 * @return
	 */
	public static String[] getGainScale(Double[] spScale, Double[] waterLevel) {
		String[] result = new String[3];
		Double[] ylbArr = new Double[2];
		if (waterLevel[0] == null || waterLevel[1] == null) {
			return result;
		}
		for (int i = 0; i < waterLevel.length; i++) {
			Double opDeal = getDealSFOp(waterLevel[i]);
			if (opDeal == null)
				continue;
			Double ylb = opDeal - waterLevel[i] / spScale[i] * 0.68;
			ylbArr[i] = ylb;
			result[i] = NumberTools.doubleToPercent(ylb, "0.0%");
		}
		result[2] = predictSF(ylbArr[1], ylbArr[0]);
		return result;
	}

	// 获得处理后的OP值，供胜负单关盈利比计算
	public static Double getDealSFOp(Double tempOP) {
		Double param;

		if (tempOP >= 1.01 && tempOP <= 1.20) {
			param = 0.97;
		} else if (tempOP >= 1.21 && tempOP <= 1.50) {
			param = 0.95;
		} else if (tempOP >= 1.51 && tempOP <= 1.80) {
			param = 0.90;
		} else if (tempOP >= 1.81 && tempOP <= 2.00) {
			param = 0.85;
		} else if (tempOP >= 2.01 && tempOP <= 2.50) {
			param = 0.80;
		} else if (tempOP >= 2.51 && tempOP <= 3.00) {
			param = 0.75;
		} else if (tempOP >= 3.01 && tempOP <= 3.50) {
			param = 0.70;
		} else if (tempOP >= 3.51 && tempOP <= 5.00) {
			param = 0.65;
		} else if (tempOP >= 5.00) {
			param = 0.60;
		} else {
			return null;
		}

		return param;
	}

	// 预测——>胜负单关
	public static String predictSF(Double gsYlb, Double hsYlb) {
		String ylb_yc = null;
		if (gsYlb == null || hsYlb == null || gsYlb == 0.0 || hsYlb == 0.0)
			return ylb_yc;
		if (gsYlb > 0.0 && hsYlb > 0.0) {
			if (gsYlb > hsYlb) {
				if (gsYlb - hsYlb > 0.05) {
					ylb_yc = "客胜";
				} else {
					ylb_yc = "双选";
				}
			} else if (hsYlb > gsYlb) {
				if (hsYlb - gsYlb > 0.05) {
					ylb_yc = "主胜";
				} else {
					ylb_yc = "双选";
				}
			}
		} else if (gsYlb < 0.0 && hsYlb < 0.0) {
			if (gsYlb > hsYlb) {
				if (gsYlb - hsYlb > 0.05) {
					ylb_yc = "客胜";
				} else {
					ylb_yc = "双选";
				}
			} else if (hsYlb > gsYlb) {
				if (hsYlb - gsYlb > 0.05) {
					ylb_yc = "主胜";
				} else {
					ylb_yc = "双选";
				}
			}
		} else if (gsYlb > 0.0 && hsYlb < 0.0) {
			ylb_yc = "客胜";
		} else if (gsYlb < 0.0 && hsYlb > 0.0) {
			ylb_yc = "主胜";
		}
		return ylb_yc;
	}

	/**
	 *
	 * @param spScale
	 *            投注比 betScale[0](win); betScale[1](tie); betScale[2](lose)
	 * @param waterLevel
	 *            盘口水位 waterLevel[0](host team); waterLevel[1](away team)
	 * @return
	 */
	public static Double[] getGainScale(Double[] spScale, Double[] waterLevel, int concede) {
		Double[] result = new Double[3];
		if (waterLevel[0] == null || waterLevel[1] == null || waterLevel[2] == null) {
			return result;
		}
		if (concede == 0) {
			result[0] = ((spScale[0] - waterLevel[0]) * 1 / spScale[0]);
			result[1] = ((spScale[1] - waterLevel[1]) * 1 / spScale[1]);
			result[2] = ((spScale[2] - waterLevel[2]) * 1 / spScale[2]);
		}
		return result;
	}
}
