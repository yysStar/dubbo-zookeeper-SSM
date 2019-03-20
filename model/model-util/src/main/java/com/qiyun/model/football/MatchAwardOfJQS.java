package com.qiyun.model.football;

import com.qiyun.grabber.model.AbstractAward;

public class MatchAwardOfJQS extends AbstractAward {

	private static final long serialVersionUID = -2356087704908245395L;
	private Double s0Award;
	private Double s1Award;
	private Double s2Award;
	private Double s3Award;
	private Double s4Award;
	private Double s5Award;
	private Double s6Award;
	private Double s7Award;

	public Double getS0Award() {
		return s0Award;
	}

	public void setS0Award(Double s0Award) {
		this.s0Award = s0Award;
	}

	public Double getS1Award() {
		return s1Award;
	}

	public void setS1Award(Double s1Award) {
		this.s1Award = s1Award;
	}

	public Double getS2Award() {
		return s2Award;
	}

	public void setS2Award(Double s2Award) {
		this.s2Award = s2Award;
	}

	public Double getS3Award() {
		return s3Award;
	}

	public void setS3Award(Double s3Award) {
		this.s3Award = s3Award;
	}

	public Double getS4Award() {
		return s4Award;
	}

	public void setS4Award(Double s4Award) {
		this.s4Award = s4Award;
	}

	public Double getS5Award() {
		return s5Award;
	}

	public void setS5Award(Double s5Award) {
		this.s5Award = s5Award;
	}

	public Double getS6Award() {
		return s6Award;
	}

	public void setS6Award(Double s6Award) {
		this.s6Award = s6Award;
	}

	public Double getS7Award() {
		return s7Award;
	}

	public void setS7Award(Double s7Award) {
		this.s7Award = s7Award;
	}

	public double getAward(String optionsValue) {
		if("0".equals(optionsValue)){
			return s0Award;
		}else if("1".equals(optionsValue)){
			return s1Award;
		}else if("2".equals(optionsValue)){
			return s2Award;
		}else if("3".equals(optionsValue)){
			return s3Award;
		}else if("4".equals(optionsValue)){
			return s4Award;
		}else if("5".equals(optionsValue)){
			return s5Award;
		}else if("6".equals(optionsValue)){
			return s6Award;
		}else if("7".equals(optionsValue)){
			return s7Award;
		}
		return 0.0;
	}
	
	public Double[] getAwardArr() {
		return new Double[] { s0Award, s1Award, s2Award, s3Award, s4Award, s5Award, s6Award, s7Award };
	}
	
	public double[] getAwardArrByDouble() {
		return new double[] { s0Award, s1Award, s2Award, s3Award, s4Award, s5Award, s6Award, s7Award };
	}
	
	public void setAwardArr(Double[] awards) {
		if (awards != null) {
			if (awards.length != 8)
				throw new RuntimeException("数组长度错误，请重新设值");
			this.setS0Award(awards[0]);
			this.setS1Award(awards[1]);
			this.setS2Award(awards[2]);
			this.setS3Award(awards[3]);
			this.setS4Award(awards[4]);
			this.setS5Award(awards[5]);
			this.setS6Award(awards[6]);
			this.setS7Award(awards[7]);
		}
	}
	public void setWbwAwardArr(Double[] awards) {
		setAwardArr(awards);
	}
	
}
