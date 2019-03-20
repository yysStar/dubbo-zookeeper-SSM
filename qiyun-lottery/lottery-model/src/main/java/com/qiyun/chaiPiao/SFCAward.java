package com.qiyun.chaiPiao;


import com.qiyun.grabber.model.AbstractAward;

import java.util.HashMap;
import java.util.Map;

public class SFCAward extends AbstractAward {

	private static final long serialVersionUID = -317709165200760952L;
	/** 主胜赔率* */
	private Double HWawardOf1TO5;
	private Double HWawardOf6TO10;
	private Double HWawardOf11TO15;
	private Double HWawardOf16TO20;
	private Double HWawardOf21TO25;
	private Double HWawardOf26;
	/** 客胜赔率* */
	private Double GWawardOf1TO5;
	private Double GWawardOf6TO10;
	private Double GWawardOf11TO15;
	private Double GWawardOf16TO20;
	private Double GWawardOf21TO25;
	private Double GWawardOf26;

	public Double getHWawardOf1TO5() {
		return HWawardOf1TO5;
	}

	public void setHWawardOf1TO5(Double hWawardOf1TO5) {
		HWawardOf1TO5 = hWawardOf1TO5;
	}

	public Double getHWawardOf6TO10() {
		return HWawardOf6TO10;
	}

	public void setHWawardOf6TO10(Double hWawardOf6TO10) {
		HWawardOf6TO10 = hWawardOf6TO10;
	}

	public Double getHWawardOf11TO15() {
		return HWawardOf11TO15;
	}

	public void setHWawardOf11TO15(Double hWawardOf11TO15) {
		HWawardOf11TO15 = hWawardOf11TO15;
	}

	public Double getHWawardOf16TO20() {
		return HWawardOf16TO20;
	}

	public void setHWawardOf16TO20(Double hWawardOf16TO20) {
		HWawardOf16TO20 = hWawardOf16TO20;
	}

	public Double getHWawardOf21TO25() {
		return HWawardOf21TO25;
	}

	public void setHWawardOf21TO25(Double hWawardOf21TO25) {
		HWawardOf21TO25 = hWawardOf21TO25;
	}

	public Double getHWawardOf26() {
		return HWawardOf26;
	}

	public void setHWawardOf26(Double hWawardOf26) {
		HWawardOf26 = hWawardOf26;
	}

	public Double getGWawardOf1TO5() {
		return GWawardOf1TO5;
	}

	public void setGWawardOf1TO5(Double gWawardOf1TO5) {
		GWawardOf1TO5 = gWawardOf1TO5;
	}

	public Double getGWawardOf6TO10() {
		return GWawardOf6TO10;
	}

	public void setGWawardOf6TO10(Double gWawardOf6TO10) {
		GWawardOf6TO10 = gWawardOf6TO10;
	}

	public Double getGWawardOf11TO15() {
		return GWawardOf11TO15;
	}

	public void setGWawardOf11TO15(Double gWawardOf11TO15) {
		GWawardOf11TO15 = gWawardOf11TO15;
	}

	public Double getGWawardOf16TO20() {
		return GWawardOf16TO20;
	}

	public void setGWawardOf16TO20(Double gWawardOf16TO20) {
		GWawardOf16TO20 = gWawardOf16TO20;
	}

	public Double getGWawardOf21TO25() {
		return GWawardOf21TO25;
	}

	public void setGWawardOf21TO25(Double gWawardOf21TO25) {
		GWawardOf21TO25 = gWawardOf21TO25;
	}

	public Double getGWawardOf26() {
		return GWawardOf26;
	}

	public void setGWawardOf26(Double gWawardOf26) {
		GWawardOf26 = gWawardOf26;
	}

	public double getAward(String optionsValue) {
		if("0".equals(optionsValue)) {
			return HWawardOf1TO5;
		} else if("1".equals(optionsValue)) {
			return HWawardOf6TO10;
		} else if("2".equals(optionsValue)) {
			return HWawardOf11TO15;
		} else if("3".equals(optionsValue)) {
			return HWawardOf16TO20;
		} else if("4".equals(optionsValue)) {
			return HWawardOf21TO25;
		} else if("5".equals(optionsValue)) {
			return HWawardOf26;
		} else if("6".equals(optionsValue)) {
			return GWawardOf1TO5;
		} else if("7".equals(optionsValue)) {
			return GWawardOf6TO10;
		} else if("8".equals(optionsValue)) {
			return GWawardOf11TO15;
		} else if("9".equals(optionsValue)) {
			return GWawardOf16TO20;
		} else if("10".equals(optionsValue)) {
			return GWawardOf21TO25;
		} else if("11".equals(optionsValue)) {
			return GWawardOf26;
		}
		return 0.0;
	}
	
	@Override
	public Double[] getAwardArr() {
		Double[] awards = { HWawardOf1TO5, HWawardOf6TO10, HWawardOf11TO15, HWawardOf16TO20, HWawardOf21TO25, HWawardOf26, GWawardOf1TO5,
				GWawardOf6TO10, GWawardOf11TO15, GWawardOf16TO20, GWawardOf21TO25, GWawardOf26 };
		return awards;
	}

	@Override
	public void setAwardArr(Double[] awardArr) {

		Double temp1 = awardArr[0] == null ? 0.00 : awardArr[0];
		Double temp2 = awardArr[1] == null ? 0.00 : awardArr[1];
		Double temp3 = awardArr[2] == null ? 0.00 : awardArr[2];
		Double temp4 = awardArr[3] == null ? 0.00 : awardArr[3];
		Double temp5 = awardArr[4] == null ? 0.00 : awardArr[4];
		Double temp6 = awardArr[5] == null ? 0.00 : awardArr[5];
		Double temp7 = awardArr[6] == null ? 0.00 : awardArr[6];
		Double temp8 = awardArr[7] == null ? 0.00 : awardArr[7];
		Double temp9 = awardArr[8] == null ? 0.00 : awardArr[8];
		Double temp10 = awardArr[9] == null ? 0.00 : awardArr[9];
		Double temp11 = awardArr[10] == null ? 0.00 : awardArr[10];
		Double temp12 = awardArr[11] == null ? 0.00 : awardArr[11];

		this.HWawardOf1TO5 = temp1;
		this.HWawardOf6TO10 = temp2;
		this.HWawardOf11TO15 = temp3;
		this.HWawardOf16TO20 = temp4;
		this.HWawardOf21TO25 = temp5;
		this.HWawardOf26 = temp6;
		/** 客胜赔率* */
		this.GWawardOf1TO5 = temp7;
		this.GWawardOf6TO10 = temp8;
		this.GWawardOf11TO15 = temp9;
		this.GWawardOf16TO20 = temp10;
		this.GWawardOf21TO25 = temp11;
		this.GWawardOf26 = temp12;
	}

	public Map<String, String> getJsonMap() {
		Map<String, String> jsonMap = new HashMap<String, String>();
		Double[] awards = getAwardArr();
		for (int i = 0; i < awards.length; i++) {
			jsonMap.put("award_" + getIntTime() + "_" + getLineId() + "_" + i, awards[i] + "");
		}
		return jsonMap;
	}
}
