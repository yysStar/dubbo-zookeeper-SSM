package com.qiyun.chaiPiao;

import com.qiyun.grabber.model.AbstractAward;
import net.sf.json.JSONObject;

public class MatchAwardOfJQS extends AbstractAward {

	private static final long serialVersionUID = -2356087704908245395L;
	private Double s0_award;
	private Double s1_award;
	private Double s2_award;
	private Double s3_award;
	private Double s4_award;
	private Double s5_award;
	private Double s6_award;
	private Double s7_award;

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

	public double getAward(String optionsValue) {
		if("0".equals(optionsValue)){
			return s0_award;
		}else if("1".equals(optionsValue)){
			return s1_award;
		}else if("2".equals(optionsValue)){
			return s2_award;
		}else if("3".equals(optionsValue)){
			return s3_award;
		}else if("4".equals(optionsValue)){
			return s4_award;
		}else if("5".equals(optionsValue)){
			return s5_award;
		}else if("6".equals(optionsValue)){
			return s6_award;
		}else if("7".equals(optionsValue)){
			return s7_award;
		}
		return 0.0;
	}
	
	public Double[] getAwardArr() {
		return new Double[] { s0_award, s1_award, s2_award, s3_award, s4_award, s5_award, s6_award, s7_award };
	}
	
	public double[] getAwardArrByDouble() {
		return new double[] { s0_award, s1_award, s2_award, s3_award, s4_award, s5_award, s6_award, s7_award };
	}
	
	public void setAwardArr(Double[] awards) {
		if (awards != null) {
			if (awards.length != 8)
				throw new RuntimeException("数组长度错误，请重新设值");
			this.setS0_award(awards[0]);
			this.setS1_award(awards[1]);
			this.setS2_award(awards[2]);
			this.setS3_award(awards[3]);
			this.setS4_award(awards[4]);
			this.setS5_award(awards[5]);
			this.setS6_award(awards[6]);
			this.setS7_award(awards[7]);
		}
	}
	public void setWbwAwardArr(Double[] awards) {
		setAwardArr(awards);
	}
	
}
