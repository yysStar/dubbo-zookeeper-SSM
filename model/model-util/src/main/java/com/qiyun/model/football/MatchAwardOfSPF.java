package com.qiyun.model.football;

import com.qiyun.grabber.model.AbstractAward;

import java.text.DecimalFormat;

public class MatchAwardOfSPF extends AbstractAward {

	private static final long serialVersionUID = 8704204082202703942L;
	private Double homeWinAward;
	private Double guestWinAward;
	private Double drawAward;
	private Integer homeChange=0;
	private Integer drawChange=0;
	private Integer guestChange=0;
	
	private Double homeRate; //胜率
	
	private Double guestRate; //负率
	
	private Double drawRate; // 平率
	
	private String sportteryMatchId;//竞彩官网对阵ID,用于抓取概率不存放数据库
	
	

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
	
	public double getAward(String optionsValue) {
		if("3".equals(optionsValue)){
			return homeWinAward;
		}else if("1".equals(optionsValue)){
			return drawAward;
		}else if("0".equals(optionsValue)){
			return guestWinAward;
		}
		return 0.0;
	}
	
	@Override
	public void setAwardArr(Double[] awardArr) {
		if (awardArr != null) {
			if (awardArr.length != 3)
				throw new RuntimeException("数组长度错误，请重新设值");
			this.setHomeWinAward(awardArr[0]);
			this.setDrawAward(awardArr[1]);
			this.setGuestWinAward(awardArr[2]);
		}
	}
	public void setWbwAwardArr(Double[] awardArr) {
		setAwardArr(awardArr);
	}
	public Double[] getAwardArr() {
		return new Double[] { homeWinAward, drawAward, guestWinAward };
	}
	public void setAwardChangeStatus(Integer[] changeStatus){
		if(changeStatus!=null){
			if(changeStatus.length!=3){
				throw new RuntimeException("数组长度错误，请重新设值");
			}
			this.setHomeChange(changeStatus[0]);
			this.setDrawChange(changeStatus[1]);
			this.setGuestChange(changeStatus[2]);
		}
	}
	public Integer[] getAwardChangeStatus() {
		return new Integer[] { homeChange, drawChange, guestChange };
	}
	public boolean checkAwardIsChange(AbstractAward tempAward){
		MatchAwardOfSPF award=(MatchAwardOfSPF) tempAward;
		boolean flag=false;
		if(award==null){
			return flag;
		}
		Double[] awardArr=award.getAwardArr();
		Double[] thisAwardArr=getAwardArr();
		Integer[] changeStatus=award.getAwardChangeStatus();
		if(thisAwardArr.length!=awardArr.length){
			throw new RuntimeException("数组长度错误，不能比较");
		}
		for(int i=0;i<thisAwardArr.length;i++){
			if(!thisAwardArr[i].equals(0d)&&awardArr[i].equals(0d)){
				return false;
			}else if(!thisAwardArr[i].equals(awardArr[i])){
				if(thisAwardArr[i]>awardArr[i]){
					changeStatus[i]=-1;
				}else{
					changeStatus[i]=1;
				}
				flag= true;
			}
		}
		award.setAwardChangeStatus(changeStatus);
		return flag;
	}

	public Double getHomeRate() {
		return homeRate;
	}

	public void setHomeRate(Double homeRate) {
		this.homeRate = homeRate;
	}

	public Double getGuestRate() {
		return guestRate;
	}

	public void setGuestRate(Double guestRate) {
		this.guestRate = guestRate;
	}

	public Double getDrawRate() {
		return drawRate;
	}

	public void setDrawRate(Double drawRate) {
		this.drawRate = drawRate;
	}

	public String getSportteryMatchId() {
		return sportteryMatchId;
	}

	public void setSportteryMatchId(String sportteryMatchId) {
		this.sportteryMatchId = sportteryMatchId;
	}
	
	/** 计算胜平负率  **/
	public void MathRate(){
		try{
			if (homeWinAward == 0 || guestWinAward == 0 || drawAward == 0) {
				this.homeRate = 0d;
				this.guestRate = 0d;
				this.drawRate = 0d;
				return;
			}
			
			//D = A*B*C / （A*B+B*C+A*C）
			//返回还率
			double d =homeWinAward*drawAward*guestWinAward*100/(homeWinAward*drawAward+drawAward*guestWinAward+homeWinAward*guestWinAward);
			DecimalFormat df = new DecimalFormat("#.##");
			this.homeRate = Double.parseDouble(df.format(d / homeWinAward));
			this.guestRate = Double.parseDouble(df.format(d / guestWinAward));
			this.drawRate = Double.parseDouble(df.format(d / drawAward));
		}catch(Exception e){
			
		}
	}

	
}
