package com.qiyun.model;

import com.qiyun.grabber.model.AbstractAward;

import java.util.Date;


public class HTAward extends AbstractAward {

	private static final long serialVersionUID = -2669391498938073804L;
	private Double sf_winOrBigAward;
	private Double sf_loseOrSmallAward;
	private Double rfsf_winOrBigAward;
	private Double rfsf_loseOrSmallAward;
	private Double dxf_winOrBigAward;
	private Double dxf_loseOrSmallAward;
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

	private Integer dxf_winOrBigChange;
	private Integer dxf_loseOrSmallChange;
	private Integer sf_winOrBigChange;
	private Integer sf_loseOrSmallChange;
	/** 大小分基数过关* */
	private Double baseBigOrSmall;
	private Integer bsChange;
	private Date handUpdateTime;
	private Date bsUpdateTime;
	/** 让分基数过关* */
	private Double handicap;
	private Integer handicapChange;
	private Integer rfsf_winOrBigChange;
	private Integer rfsf_loseOrSmallChange;

	public Double getHandicap() {
		return handicap;
	}

	public void setHandicap(Double handicap) {
		this.handicap = handicap;
	}

	public Integer getHandicapChange() {
		return handicapChange;
	}

	public void setHandicapChange(Integer handicapChange) {
		this.handicapChange = handicapChange;
	}

	public Date getHandUpdateTime() {
		return handUpdateTime;
	}

	public void setHandUpdateTime(Date handUpdateTime) {
		this.handUpdateTime = handUpdateTime;
	}

	public Double getBaseBigOrSmall() {
		return baseBigOrSmall;
	}

	public void setBaseBigOrSmall(Double baseBigOrSmall) {
		this.baseBigOrSmall = baseBigOrSmall;
	}

	public Integer getBsChange() {
		return bsChange;
	}

	public void setBsChange(Integer bsChange) {
		this.bsChange = bsChange;
	}

	public Date getBsUpdateTime() {
		return bsUpdateTime;
	}

	public void setBsUpdateTime(Date bsUpdateTime) {
		this.bsUpdateTime = bsUpdateTime;
	}

	public double getAward(String optionsValue) {
		return 0.0;
	}
	
	public String getHandicapDeal() {
		if (handicap == null) {
			return null;
		} else if (handicap > 0) {
			return "+" + handicap;
		} else {
			return handicap + "";
		}
	}

	public Double getHWawardOf1TO5() {
		return HWawardOf1TO5;
	}

	public void setHWawardOf1TO5(Double wawardOf1TO5) {
		HWawardOf1TO5 = wawardOf1TO5;
	}

	public Double getHWawardOf6TO10() {
		return HWawardOf6TO10;
	}

	public void setHWawardOf6TO10(Double wawardOf6TO10) {
		HWawardOf6TO10 = wawardOf6TO10;
	}

	public Double getHWawardOf11TO15() {
		return HWawardOf11TO15;
	}

	public void setHWawardOf11TO15(Double wawardOf11TO15) {
		HWawardOf11TO15 = wawardOf11TO15;
	}

	public Double getHWawardOf16TO20() {
		return HWawardOf16TO20;
	}

	public void setHWawardOf16TO20(Double wawardOf16TO20) {
		HWawardOf16TO20 = wawardOf16TO20;
	}

	public Double getHWawardOf21TO25() {
		return HWawardOf21TO25;
	}

	public void setHWawardOf21TO25(Double wawardOf21TO25) {
		HWawardOf21TO25 = wawardOf21TO25;
	}

	public Double getHWawardOf26() {
		return HWawardOf26;
	}

	public void setHWawardOf26(Double wawardOf26) {
		HWawardOf26 = wawardOf26;
	}

	public Double getGWawardOf1TO5() {
		return GWawardOf1TO5;
	}

	public void setGWawardOf1TO5(Double wawardOf1TO5) {
		GWawardOf1TO5 = wawardOf1TO5;
	}

	public Double getGWawardOf6TO10() {
		return GWawardOf6TO10;
	}

	public void setGWawardOf6TO10(Double wawardOf6TO10) {
		GWawardOf6TO10 = wawardOf6TO10;
	}

	public Double getGWawardOf11TO15() {
		return GWawardOf11TO15;
	}

	public void setGWawardOf11TO15(Double wawardOf11TO15) {
		GWawardOf11TO15 = wawardOf11TO15;
	}

	public Double getGWawardOf16TO20() {
		return GWawardOf16TO20;
	}

	public void setGWawardOf16TO20(Double wawardOf16TO20) {
		GWawardOf16TO20 = wawardOf16TO20;
	}

	public Double getGWawardOf21TO25() {
		return GWawardOf21TO25;
	}

	public void setGWawardOf21TO25(Double wawardOf21TO25) {
		GWawardOf21TO25 = wawardOf21TO25;
	}

	public Double getGWawardOf26() {
		return GWawardOf26;
	}

	public void setGWawardOf26(Double wawardOf26) {
		GWawardOf26 = wawardOf26;
	}

	public Double getRfsf_winOrBigAward() {
		return rfsf_winOrBigAward;
	}

	public void setRfsf_winOrBigAward(Double rfsf_winOrBigAward) {
		this.rfsf_winOrBigAward = rfsf_winOrBigAward;
	}

	public Double getRfsf_loseOrSmallAward() {
		return rfsf_loseOrSmallAward;
	}

	public void setRfsf_loseOrSmallAward(Double rfsf_loseOrSmallAward) {
		this.rfsf_loseOrSmallAward = rfsf_loseOrSmallAward;
	}

	public Integer getRfsf_winOrBigChange() {
		return rfsf_winOrBigChange;
	}

	public void setRfsf_winOrBigChange(Integer rfsf_winOrBigChange) {
		this.rfsf_winOrBigChange = rfsf_winOrBigChange;
	}

	public Integer getRfsf_loseOrSmallChange() {
		return rfsf_loseOrSmallChange;
	}

	public void setRfsf_loseOrSmallChange(Integer rfsf_loseOrSmallChange) {
		this.rfsf_loseOrSmallChange = rfsf_loseOrSmallChange;
	}

	public Double getSf_winOrBigAward() {
		return sf_winOrBigAward;
	}

	public void setSf_winOrBigAward(Double sf_winOrBigAward) {
		this.sf_winOrBigAward = sf_winOrBigAward;
	}

	public Double getSf_loseOrSmallAward() {
		return sf_loseOrSmallAward;
	}

	public void setSf_loseOrSmallAward(Double sf_loseOrSmallAward) {
		this.sf_loseOrSmallAward = sf_loseOrSmallAward;
	}

	public Integer getSf_winOrBigChange() {
		return sf_winOrBigChange;
	}

	public void setSf_winOrBigChange(Integer sf_winOrBigChange) {
		this.sf_winOrBigChange = sf_winOrBigChange;
	}

	public Integer getSf_loseOrSmallChange() {
		return sf_loseOrSmallChange;
	}

	public void setSf_loseOrSmallChange(Integer sf_loseOrSmallChange) {
		this.sf_loseOrSmallChange = sf_loseOrSmallChange;
	}

	public Double getDxf_winOrBigAward() {
		return dxf_winOrBigAward;
	}

	public void setDxf_winOrBigAward(Double dxf_winOrBigAward) {
		this.dxf_winOrBigAward = dxf_winOrBigAward;
	}

	public Double getDxf_loseOrSmallAward() {
		return dxf_loseOrSmallAward;
	}

	public void setDxf_loseOrSmallAward(Double dxf_loseOrSmallAward) {
		this.dxf_loseOrSmallAward = dxf_loseOrSmallAward;
	}

	public Integer getDxf_winOrBigChange() {
		return dxf_winOrBigChange;
	}

	public void setDxf_winOrBigChange(Integer dxf_winOrBigChange) {
		this.dxf_winOrBigChange = dxf_winOrBigChange;
	}

	public Integer getDxf_loseOrSmallChange() {
		return dxf_loseOrSmallChange;
	}

	public void setDxf_loseOrSmallChange(Integer dxf_loseOrSmallChange) {
		this.dxf_loseOrSmallChange = dxf_loseOrSmallChange;
	}

	@Override
	public Double[] getAwardArr() {
		return new Double[] { sf_winOrBigAward, sf_loseOrSmallAward, rfsf_winOrBigAward, rfsf_loseOrSmallAward, dxf_winOrBigAward,
				dxf_loseOrSmallAward, HWawardOf1TO5, HWawardOf6TO10, HWawardOf11TO15, HWawardOf16TO20, HWawardOf21TO25, HWawardOf26, GWawardOf1TO5,
				GWawardOf6TO10, GWawardOf11TO15, GWawardOf16TO20, GWawardOf21TO25, GWawardOf26 };

	}

	@Override
	public void setAwardArr(Double[] awardArr) {
		// TODO Auto-generated method stub

	}

	// 获取胜分差的赔率
	public Double[] getSFCAwardArr() {
		return new Double[] { HWawardOf1TO5, HWawardOf6TO10, HWawardOf11TO15, HWawardOf16TO20, HWawardOf21TO25, HWawardOf26, GWawardOf1TO5,
				GWawardOf6TO10, GWawardOf11TO15, GWawardOf16TO20, GWawardOf21TO25, GWawardOf26 };
	}

	public Double[] getSFAwardArr() {
		return new Double[] { sf_winOrBigAward, sf_loseOrSmallAward };
	}

	public Double[] getRFSFAwardArr() {
		return new Double[] { rfsf_winOrBigAward, rfsf_loseOrSmallAward };
	}

	public Double[] getDXFAwardArr() {
		return new Double[] { dxf_winOrBigAward, dxf_loseOrSmallAward };
	}
	
	@Override
	public Double getAwardByOption(OptionItem option) {
		Double award = null;
		try {
			if (option instanceof OptionItemSFC) {
				award = getSFCAwardArr()[option.getOrdinal()];
			} else if (option instanceof OptionItemSF) {
				award = getSFAwardArr()[option.getOrdinal()];
			} else if (option instanceof OptionItemRFSF) {
				award = getRFSFAwardArr()[option.getOrdinal()];
			} else if (option instanceof OptionItemDXF) {
				award = getDXFAwardArr()[option.getOrdinal()];
			}
		} catch (Exception e) {
		}
		return award;
	}
}
