package com.qiyun.model.football;


import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.item.*;

public class MatchAwardOfHT extends AbstractAward {

	private static final long serialVersionUID = -1161573967160079542L;
	private Double homeWinAward_rq;
	private Double guestWinAward_rq;
	private Double drawAward_rq;
	private Integer homeChange_rq = 0;
	private Integer drawChange_rq = 0;
	private Integer guestChange_rq = 0;

	private Double homeWinAward;
	private Double guestWinAward;
	private Double drawAward;
	private Integer homeChange = 0;
	private Integer drawChange = 0;
	private Integer guestChange = 0;
	private Double s0_award;
	private Double s1_award;
	private Double s2_award;
	private Double s3_award;
	private Double s4_award;
	private Double s5_award;
	private Double s6_award;
	private Double s7_award;
	private Double win_win_award;
	private Double win_draw_award;
	private Double win_lose_award;
	private Double draw_win_award;
	private Double draw_draw_award;
	private Double draw_lose_award;
	private Double lose_win_award;
	private Double lose_draw_award;
	private Double lose_lose_award;
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
	
	/**
	 * sp排列顺序对应 OptiomItemHT.java 
	 * 
	 * @return
	 */
	public Double[] getAwardArr()  {
		return new Double[] { 
				homeWinAward_rq, guestWinAward_rq, drawAward_rq, homeWinAward, guestWinAward, drawAward, s0_award, s1_award, s2_award,
				s3_award, s4_award, s5_award, s6_award, s7_award, win_win_award, win_draw_award, win_lose_award, draw_win_award, draw_draw_award,
				draw_lose_award, lose_win_award, lose_draw_award, lose_lose_award
				,s10award, s20award, s21award, s30award, s31award, s32award, s40award, s41award, s42award, s50award, s51award, s52award,
				s_win_award,
				s00award, s11award, s22award, s33award, s_draw_award,
				s01award, s02award, s12award, s03award, s13award, s23award, s04award, s14award, s24award, s05award, s15award, s25award, s_lose_award
		};
	}
	/**
	 * sp排列顺序对应 FBLimitOptionItem.java
	 * 平/让球平的位置 和getAwardArr 不一致
	 * @return
	 */
	public Double[] getLimitAwardArr()  {
		return new Double[] { 
				homeWinAward_rq, drawAward_rq,guestWinAward_rq, homeWinAward, drawAward,guestWinAward, s0_award, s1_award, s2_award,
				s3_award, s4_award, s5_award, s6_award, s7_award, win_win_award, win_draw_award, win_lose_award, draw_win_award, draw_draw_award,
				draw_lose_award, lose_win_award, lose_draw_award, lose_lose_award
				,s10award, s20award, s21award, s30award, s31award, s32award, s40award, s41award, s42award, s50award, s51award, s52award,
				s_win_award,
				s00award, s11award, s22award, s33award, s_draw_award,
				s01award, s02award, s12award, s03award, s13award, s23award, s04award, s14award, s24award, s05award, s15award, s25award, s_lose_award
		};
	}
	
	//获取胜平负的赔率
	public Double[] getSpfAwardArr() {
		return new Double[] {homeWinAward,drawAward,guestWinAward };
	}
	//获取让球胜平负的赔率
	public Double[] getRqspfAwardArr() {
		return new Double[] {homeWinAward_rq,drawAward_rq,guestWinAward_rq };
	}
	//获取半全场的赔率
	public Double[] getBQCAwardArr() {
		return new Double[] { win_win_award, win_draw_award, win_lose_award, draw_win_award, draw_draw_award, draw_lose_award, lose_win_award,
				lose_draw_award, lose_lose_award };
	}
	//获取进球数的赔率
	public Double[] getJQSAwardArr() {
		return new Double[] { s0_award, s1_award, s2_award, s3_award, s4_award, s5_award, s6_award, s7_award };
	}
	//获取比分的赔率
	public Double[] getBFAwardArr() {
		return new Double[] { s10award, s20award, s21award, s30award, s31award, s32award, s40award, s41award, s42award, s50award, s51award, s52award,
				s_win_award,

				s00award, s11award, s22award, s33award, s_draw_award,

				s01award, s02award, s12award, s03award, s13award, s23award, s04award, s14award, s24award, s05award, s15award, s25award, s_lose_award };
	}
	
	public double getAward(String optionsValue){
		return 0.0;
	}
	
	public void setAwardArr(Double[] awards) {

	}
	public Double getAwardByOption(OptionItem option){
		Double award=null;
		try{
			if(option instanceof OptionItemBF){
				award=getBFAwardArr()[option.getOrdinal()];
			}else if(option instanceof OptionItemBQC){
				award=getBQCAwardArr()[option.getOrdinal()];
			}else if(option instanceof OptionItemJQS){
				award=getJQSAwardArr()[option.getOrdinal()];
			}else if(option instanceof OptionItemSPF){
				award=getSpfAwardArr()[option.getOrdinal()];
			}else if(option instanceof OptionItemRQSPF){
				award=getRqspfAwardArr()[option.getOrdinal()];
			}
		}catch (Exception e) {
		}
		return award;
	}


	public Double getHomeWinAward_rq() {
		return homeWinAward_rq;
	}

	public void setHomeWinAward_rq(Double homeWinAward_rq) {
		this.homeWinAward_rq = homeWinAward_rq;
	}

	public Double getGuestWinAward_rq() {
		return guestWinAward_rq;
	}

	public void setGuestWinAward_rq(Double guestWinAward_rq) {
		this.guestWinAward_rq = guestWinAward_rq;
	}

	public Double getDrawAward_rq() {
		return drawAward_rq;
	}

	public void setDrawAward_rq(Double drawAward_rq) {
		this.drawAward_rq = drawAward_rq;
	}

	public Integer getHomeChange_rq() {
		return homeChange_rq;
	}

	public void setHomeChange_rq(Integer homeChange_rq) {
		this.homeChange_rq = homeChange_rq;
	}

	public Integer getDrawChange_rq() {
		return drawChange_rq;
	}

	public void setDrawChange_rq(Integer drawChange_rq) {
		this.drawChange_rq = drawChange_rq;
	}

	public Integer getGuestChange_rq() {
		return guestChange_rq;
	}

	public void setGuestChange_rq(Integer guestChange_rq) {
		this.guestChange_rq = guestChange_rq;
	}

	public Double getHomeWinAward() {
		return homeWinAward;
	}

	public void setHomeWinAward(Double homeWinAward) {
		this.homeWinAward = homeWinAward;
	}

	public Double getGuestWinAward() {
		return guestWinAward;
	}

	public void setGuestWinAward(Double guestWinAward) {
		this.guestWinAward = guestWinAward;
	}

	public Double getDrawAward() {
		return drawAward;
	}

	public void setDrawAward(Double drawAward) {
		this.drawAward = drawAward;
	}

	public Integer getHomeChange() {
		return homeChange;
	}

	public void setHomeChange(Integer homeChange) {
		this.homeChange = homeChange;
	}

	public Integer getDrawChange() {
		return drawChange;
	}

	public void setDrawChange(Integer drawChange) {
		this.drawChange = drawChange;
	}

	public Integer getGuestChange() {
		return guestChange;
	}

	public void setGuestChange(Integer guestChange) {
		this.guestChange = guestChange;
	}

	public Double getS0_award() {
		return s0_award;
	}

	public void setS0_award(Double s0_award) {
		this.s0_award = s0_award;
	}

	public Double getS1_award() {
		return s1_award;
	}

	public void setS1_award(Double s1_award) {
		this.s1_award = s1_award;
	}

	public Double getS2_award() {
		return s2_award;
	}

	public void setS2_award(Double s2_award) {
		this.s2_award = s2_award;
	}

	public Double getS3_award() {
		return s3_award;
	}

	public void setS3_award(Double s3_award) {
		this.s3_award = s3_award;
	}

	public Double getS4_award() {
		return s4_award;
	}

	public void setS4_award(Double s4_award) {
		this.s4_award = s4_award;
	}

	public Double getS5_award() {
		return s5_award;
	}

	public void setS5_award(Double s5_award) {
		this.s5_award = s5_award;
	}

	public Double getS6_award() {
		return s6_award;
	}

	public void setS6_award(Double s6_award) {
		this.s6_award = s6_award;
	}

	public Double getS7_award() {
		return s7_award;
	}

	public void setS7_award(Double s7_award) {
		this.s7_award = s7_award;
	}

	public Double getWin_win_award() {
		return win_win_award;
	}

	public void setWin_win_award(Double win_win_award) {
		this.win_win_award = win_win_award;
	}

	public Double getWin_draw_award() {
		return win_draw_award;
	}

	public void setWin_draw_award(Double win_draw_award) {
		this.win_draw_award = win_draw_award;
	}

	public Double getWin_lose_award() {
		return win_lose_award;
	}

	public void setWin_lose_award(Double win_lose_award) {
		this.win_lose_award = win_lose_award;
	}

	public Double getDraw_win_award() {
		return draw_win_award;
	}

	public void setDraw_win_award(Double draw_win_award) {
		this.draw_win_award = draw_win_award;
	}

	public Double getDraw_draw_award() {
		return draw_draw_award;
	}

	public void setDraw_draw_award(Double draw_draw_award) {
		this.draw_draw_award = draw_draw_award;
	}

	public Double getDraw_lose_award() {
		return draw_lose_award;
	}

	public void setDraw_lose_award(Double draw_lose_award) {
		this.draw_lose_award = draw_lose_award;
	}

	public Double getLose_win_award() {
		return lose_win_award;
	}

	public void setLose_win_award(Double lose_win_award) {
		this.lose_win_award = lose_win_award;
	}

	public Double getLose_draw_award() {
		return lose_draw_award;
	}

	public void setLose_draw_award(Double lose_draw_award) {
		this.lose_draw_award = lose_draw_award;
	}

	public Double getLose_lose_award() {
		return lose_lose_award;
	}

	public void setLose_lose_award(Double lose_lose_award) {
		this.lose_lose_award = lose_lose_award;
	}

	public Double getS10award() {
		return s10award;
	}

	public void setS10award(Double s10award) {
		this.s10award = s10award;
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

	public Double getS00award() {
		return s00award;
	}

	public void setS00award(Double s00award) {
		this.s00award = s00award;
	}

	public Double getS11award() {
		return s11award;
	}

	public void setS11award(Double s11award) {
		this.s11award = s11award;
	}

	public Double getS22award() {
		return s22award;
	}

	public void setS22award(Double s22award) {
		this.s22award = s22award;
	}

	public Double getS33award() {
		return s33award;
	}

	public void setS33award(Double s33award) {
		this.s33award = s33award;
	}

	public Double getS_draw_award() {
		return s_draw_award;
	}

	public void setS_draw_award(Double s_draw_award) {
		this.s_draw_award = s_draw_award;
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

	public Double getS12award() {
		return s12award;
	}

	public void setS12award(Double s12award) {
		this.s12award = s12award;
	}

	public Double getS03award() {
		return s03award;
	}

	public void setS03award(Double s03award) {
		this.s03award = s03award;
	}

	public Double getS13award() {
		return s13award;
	}

	public void setS13award(Double s13award) {
		this.s13award = s13award;
	}

	public Double getS23award() {
		return s23award;
	}

	public void setS23award(Double s23award) {
		this.s23award = s23award;
	}

	public Double getS04award() {
		return s04award;
	}

	public void setS04award(Double s04award) {
		this.s04award = s04award;
	}

	public Double getS14award() {
		return s14award;
	}

	public void setS14award(Double s14award) {
		this.s14award = s14award;
	}

	public Double getS24award() {
		return s24award;
	}

	public void setS24award(Double s24award) {
		this.s24award = s24award;
	}

	public Double getS05award() {
		return s05award;
	}

	public void setS05award(Double s05award) {
		this.s05award = s05award;
	}

	public Double getS15award() {
		return s15award;
	}

	public void setS15award(Double s15award) {
		this.s15award = s15award;
	}

	public Double getS25award() {
		return s25award;
	}

	public void setS25award(Double s25award) {
		this.s25award = s25award;
	}

	public Double getS_lose_award() {
		return s_lose_award;
	}

	public void setS_lose_award(Double s_lose_award) {
		this.s_lose_award = s_lose_award;
	}

}
