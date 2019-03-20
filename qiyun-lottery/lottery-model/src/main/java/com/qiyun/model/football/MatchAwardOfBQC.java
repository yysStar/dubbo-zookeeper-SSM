package com.qiyun.model.football;

import com.qiyun.grabber.model.AbstractAward;

public class MatchAwardOfBQC extends AbstractAward {

	private static final long serialVersionUID = -1161573967160079542L;

	private Double win_win_award;
	private Double win_draw_award;
	private Double win_lose_award;
	private Double draw_win_award;
	private Double draw_draw_award;
	private Double draw_lose_award;
	private Double lose_win_award;
	private Double lose_draw_award;
	private Double lose_lose_award;

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

	public double getAward(String optionsValue) {
		if("33".equals(optionsValue)){
			return win_win_award;
		}else if("13".equals(optionsValue)){
			return draw_win_award;
		}else if("03".equals(optionsValue)){
			return lose_win_award;
		}else if("31".equals(optionsValue)){
			return win_draw_award;
		}else if("11".equals(optionsValue)){
			return draw_draw_award;
		}else if("01".equals(optionsValue)){
			return lose_draw_award;
		}else if("30".equals(optionsValue)){
			return win_lose_award;
		}else if("10".equals(optionsValue)){
			return draw_lose_award;
		}else if("00".equals(optionsValue)){
			return lose_lose_award;
		}
		return 0.0;
	}
	
	public Double[] getAwardArr() {
		return new Double[] { win_win_award, win_draw_award, win_lose_award, draw_win_award, draw_draw_award, draw_lose_award, lose_win_award,
				lose_draw_award, lose_lose_award };
	}

	public void setAwardArr(Double[] awards) {
		if (awards != null) {
			if (awards.length != 9)
				throw new RuntimeException("数组长度错误，请重新设值");

			this.setWin_win_award(awards[0]);
			this.setWin_draw_award(awards[1]);
			this.setWin_lose_award(awards[2]);

			this.setDraw_win_award(awards[3]);
			this.setDraw_draw_award(awards[4]);
			this.setDraw_lose_award(awards[5]);

			this.setLose_win_award(awards[6]);
			this.setLose_draw_award(awards[7]);
			this.setLose_lose_award(awards[8]);
		}
	}
	public void setWbwAwardArr(Double[] awards) {
		setAwardArr(awards);
	}
	
}
