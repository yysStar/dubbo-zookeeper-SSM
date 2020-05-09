package com.qiyun.model.football;

import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.OptionItem;
import com.qiyun.model.OptionItemBF;

public class MatchAwardOfBF extends AbstractAward {

	private static final long serialVersionUID = 4515569411686669414L;

	private Double s10award;
	private Double s20award;
	private Double s21award;
	private Double s30award;
	private Double s31award;
	private Double s32award;
	private Double s40award;
	private Double s41award;
	private Double s42award;
	private Double s50award;
	private Double s51award;
	private Double s52award;
	private Double s_win_award;

	private Double s00award;
	private Double s11award;
	private Double s22award;
	private Double s33award;
	private Double s_draw_award;

	private Double s01award;
	private Double s02award;
	private Double s12award;
	private Double s03award;
	private Double s13award;
	private Double s23award;
	private Double s04award;
	private Double s14award;
	private Double s24award;
	private Double s05award;
	private Double s15award;
	private Double s25award;
	private Double s_lose_award;

	public Double getS00award() {
		return s00award;
	}

	public void setS00award(Double s00award) {
		this.s00award = s00award;
	}

	public Double getS01award() {
		return s01award;
	}

	public void setS01award(Double s01award) {
		this.s01award = s01award;
	}

	public Double getS02award() {
		return s02award;
	}

	public void setS02award(Double s02award) {
		this.s02award = s02award;
	}

	public Double getS03award() {
		return s03award;
	}

	public void setS03award(Double s03award) {
		this.s03award = s03award;
	}

	public Double getS04award() {
		return s04award;
	}

	public void setS04award(Double s04award) {
		this.s04award = s04award;
	}

	public Double getS05award() {
		return s05award;
	}

	public void setS05award(Double s05award) {
		this.s05award = s05award;
	}

	public Double getS10award() {
		return s10award;
	}

	public void setS10award(Double s10award) {
		this.s10award = s10award;
	}

	public Double getS11award() {
		return s11award;
	}

	public void setS11award(Double s11award) {
		this.s11award = s11award;
	}

	public Double getS12award() {
		return s12award;
	}

	public void setS12award(Double s12award) {
		this.s12award = s12award;
	}

	public Double getS13award() {
		return s13award;
	}

	public void setS13award(Double s13award) {
		this.s13award = s13award;
	}

	public Double getS14award() {
		return s14award;
	}

	public void setS14award(Double s14award) {
		this.s14award = s14award;
	}

	public Double getS15award() {
		return s15award;
	}

	public void setS15award(Double s15award) {
		this.s15award = s15award;
	}

	public Double getS20award() {
		return s20award;
	}

	public void setS20award(Double s20award) {
		this.s20award = s20award;
	}

	public Double getS21award() {
		return s21award;
	}

	public void setS21award(Double s21award) {
		this.s21award = s21award;
	}

	public Double getS22award() {
		return s22award;
	}

	public void setS22award(Double s22award) {
		this.s22award = s22award;
	}

	public Double getS23award() {
		return s23award;
	}

	public void setS23award(Double s23award) {
		this.s23award = s23award;
	}

	public Double getS24award() {
		return s24award;
	}

	public void setS24award(Double s24award) {
		this.s24award = s24award;
	}

	public Double getS25award() {
		return s25award;
	}

	public void setS25award(Double s25award) {
		this.s25award = s25award;
	}

	public Double getS30award() {
		return s30award;
	}

	public void setS30award(Double s30award) {
		this.s30award = s30award;
	}

	public Double getS31award() {
		return s31award;
	}

	public void setS31award(Double s31award) {
		this.s31award = s31award;
	}

	public Double getS32award() {
		return s32award;
	}

	public void setS32award(Double s32award) {
		this.s32award = s32award;
	}

	public Double getS33award() {
		return s33award;
	}

	public void setS33award(Double s33award) {
		this.s33award = s33award;
	}

	public Double getS40award() {
		return s40award;
	}

	public void setS40award(Double s40award) {
		this.s40award = s40award;
	}

	public Double getS41award() {
		return s41award;
	}

	public void setS41award(Double s41award) {
		this.s41award = s41award;
	}

	public Double getS42award() {
		return s42award;
	}

	public void setS42award(Double s42award) {
		this.s42award = s42award;
	}

	public Double getS50award() {
		return s50award;
	}

	public void setS50award(Double s50award) {
		this.s50award = s50award;
	}

	public Double getS51award() {
		return s51award;
	}

	public void setS51award(Double s51award) {
		this.s51award = s51award;
	}

	public Double getS52award() {
		return s52award;
	}

	public void setS52award(Double s52award) {
		this.s52award = s52award;
	}

	public Double getS_win_award() {
		return s_win_award;
	}

	public void setS_win_award(Double s_win_award) {
		this.s_win_award = s_win_award;
	}

	public Double getS_draw_award() {
		return s_draw_award;
	}

	public void setS_draw_award(Double s_draw_award) {
		this.s_draw_award = s_draw_award;
	}

	public Double getS_lose_award() {
		return s_lose_award;
	}

	public void setS_lose_award(Double s_lose_award) {
		this.s_lose_award = s_lose_award;
	}
	
	public double getAward(String optionsValue){
		if("WW".equals(optionsValue)) {				//胜其它
			return s_win_award;
		} else if("DD".equals(optionsValue)){		//平其它
			return s_draw_award;
		} else if("LL".equals(optionsValue)){		//负其它
			return s_lose_award;
		} else if("10".equals(optionsValue)){
			return s10award;
		} else if("20".equals(optionsValue)){
			return s20award;
		} else if("21".equals(optionsValue)){
			return s21award;
		} else if("30".equals(optionsValue)){
			return s30award;
		} else if("31".equals(optionsValue)){
			return s31award;
		} else if("32".equals(optionsValue)){
			return s32award;
		} else if("40".equals(optionsValue)){
			return s40award;
		} else if("41".equals(optionsValue)){
			return s41award;
		} else if("42".equals(optionsValue)){
			return s42award;
		} else if("50".equals(optionsValue)){
			return s50award;
		} else if("51".equals(optionsValue)){
			return s51award;
		} else if("52".equals(optionsValue)){
			return s52award;
		} else if("00".equals(optionsValue)){
			return s00award;
		} else if("11".equals(optionsValue)){
			return s11award;
		} else if("22".equals(optionsValue)){
			return s22award;
		} else if("33".equals(optionsValue)){
			return s33award;
		} else if("01".equals(optionsValue)){
			return s01award;
		} else if("02".equals(optionsValue)){
			return s02award;
		} else if("12".equals(optionsValue)){
			return s12award;
		} else if("03".equals(optionsValue)){
			return s03award;
		} else if("13".equals(optionsValue)){
			return s13award;
		} else if("23".equals(optionsValue)){
			return s23award;
		} else if("04".equals(optionsValue)){
			return s04award;
		} else if("14".equals(optionsValue)){
			return s14award;
		} else if("24".equals(optionsValue)){
			return s24award;
		} else if("05".equals(optionsValue)){
			return s05award;
		} else if("15".equals(optionsValue)){
			return s15award;
		} else if("25".equals(optionsValue)){
			return s25award;
		}
		return 0.0;
	}
	
	public Double getAwardByOption(OptionItem option){
		Double award=null;
		try{
			OptionItemBF bfOption=(OptionItemBF) option;
			award=getAwardArr()[bfOption.ordinal()];
		}catch (Exception e) {
		}
		return award;
	}
	
	public Double[] getAwardArr() {
		return new Double[] { s10award, s20award, s21award, s30award, s31award, s32award, s40award, s41award, s42award, s50award, s51award, s52award,
				s_win_award,

				s00award, s11award, s22award, s33award, s_draw_award,

				s01award, s02award, s12award, s03award, s13award, s23award, s04award, s14award, s24award, s05award, s15award, s25award, s_lose_award };
	}

	public void setAwardArr(Double[] awards) {
		if (awards != null) {
			if (awards.length != 31)
				throw new RuntimeException("数组长度错误，请重新设值");
			this.setS10award(awards[0]);
			this.setS20award(awards[1]);
			this.setS21award(awards[2]);
			this.setS30award(awards[3]);
			this.setS31award(awards[4]);
			this.setS32award(awards[5]);
			this.setS40award(awards[6]);
			this.setS41award(awards[7]);
			this.setS42award(awards[8]);
			this.setS50award(awards[9]);
			this.setS51award(awards[10]);
			this.setS52award(awards[11]);
			this.setS_win_award(awards[12]);

			this.setS00award(awards[13]);
			this.setS11award(awards[14]);
			this.setS22award(awards[15]);
			this.setS33award(awards[16]);
			this.setS_draw_award(awards[17]);

			this.setS01award(awards[18]);
			this.setS02award(awards[19]);
			this.setS12award(awards[20]);
			this.setS03award(awards[21]);
			this.setS13award(awards[22]);
			this.setS23award(awards[23]);
			this.setS04award(awards[24]);
			this.setS14award(awards[25]);
			this.setS24award(awards[26]);
			this.setS05award(awards[27]);
			this.setS15award(awards[28]);
			this.setS25award(awards[29]);
			this.setS_lose_award(awards[30]);
		}
	}
	public void setWbwAwardArr(Double[] awards) {
		if (awards != null) {
			if (awards.length != 31)
				throw new RuntimeException("数组长度错误，请重新设值");
			this.setS_win_award(awards[0]);
			this.setS10award(awards[1]);
			this.setS20award(awards[2]);
			this.setS21award(awards[3]);
			this.setS30award(awards[4]);
			this.setS31award(awards[5]);
			this.setS32award(awards[6]);
			this.setS40award(awards[7]);
			this.setS41award(awards[8]);
			this.setS42award(awards[9]);
			this.setS50award(awards[10]);
			this.setS51award(awards[11]);
			this.setS52award(awards[12]);
			
			this.setS_draw_award(awards[13]);
			this.setS00award(awards[14]);
			this.setS11award(awards[15]);
			this.setS22award(awards[16]);
			this.setS33award(awards[17]);

			this.setS_lose_award(awards[18]);
			this.setS01award(awards[19]);
			this.setS02award(awards[20]);
			this.setS12award(awards[21]);
			this.setS03award(awards[22]);
			this.setS13award(awards[23]);
			this.setS23award(awards[24]);
			this.setS04award(awards[25]);
			this.setS14award(awards[26]);
			this.setS24award(awards[27]);
			this.setS05award(awards[28]);
			this.setS15award(awards[29]);
			this.setS25award(awards[30]);
		}
	}
}
