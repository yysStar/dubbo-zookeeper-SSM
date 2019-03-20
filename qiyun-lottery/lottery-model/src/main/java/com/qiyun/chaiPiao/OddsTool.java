package com.qiyun.chaiPiao;

import com.qiyun.utils.NumberTools;

public class OddsTool {
	public static Double getCommonReturnPercent(Double award, Double oddsValue) {
		if (award == 0 || oddsValue == 0) {
			return 100d;
		}
		double returnPercent = award / oddsValue * 0.9 * 100;
		return NumberTools.formatDouble(returnPercent, 1);
	}

	public static Double getSpfReturnPercent(Double award, Double betPercent) {
		if (award == 0 || betPercent == 0) {
			return 100d;
		}
		double returnPercent = betPercent * award;
		return NumberTools.formatDouble(returnPercent, 1);
	}

}
