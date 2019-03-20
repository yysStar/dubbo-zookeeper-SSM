package com.qiyun.chaiPiao;

import com.qiyun.model.MatchShowStatusFb;

import java.util.ArrayList;
import java.util.List;


public enum MatchShowStatusTextFb {
	// value,text,玩法过关组装字符
	SPF(0, "胜平负过关", MatchShowStatusFb.SPF), RQSPF(1, "让球胜平负过关", MatchShowStatusFb.RQSPF), BF(2, "比分过关", MatchShowStatusFb.BF), JQS(3, "进球数过关", MatchShowStatusFb.JQS), BQC(4, "半全场胜平负过关", MatchShowStatusFb.BQC),
	SPFSINGLE(5, "胜平负单场", MatchShowStatusFb.SPFSINGLE), RQSPFSINGLE(6, "让球胜平负单场", MatchShowStatusFb.RQSPFSINGLE), BFSINGLE(7, "比分单场", MatchShowStatusFb.BFSINGLE), JQSSINGLE(8, "进球数单场", MatchShowStatusFb.JQSSINGLE), BQCSINGLE(9, "半全场胜平负单场", MatchShowStatusFb.BQCSINGLE);

	private MatchShowStatusFb matchShowStatusFb;
	private String text;
	private Integer value;

	private MatchShowStatusTextFb(Integer value, String text,MatchShowStatusFb matchShowStatusFb) {
		this.value=value;
		this.text = text;
		this.matchShowStatusFb = matchShowStatusFb;
	}
	/**
	 * 对应后台停/开售排列顺序
	 * @return
	 */
	public static List<MatchShowStatusFb> getShowStatsuFbOrderList(){
		List<MatchShowStatusFb> fbList=new ArrayList<MatchShowStatusFb>();
		fbList.add(SPF.getMatchShowStatusFb());
		fbList.add(RQSPF.getMatchShowStatusFb());
		fbList.add(BF.getMatchShowStatusFb());
		fbList.add(JQS.getMatchShowStatusFb());
		fbList.add(BQC.getMatchShowStatusFb());
		fbList.add(SPFSINGLE.getMatchShowStatusFb());
		fbList.add(RQSPFSINGLE.getMatchShowStatusFb());
		fbList.add(BFSINGLE.getMatchShowStatusFb());
		fbList.add(JQSSINGLE.getMatchShowStatusFb());
		fbList.add(BQCSINGLE.getMatchShowStatusFb());
		return fbList;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	



	public MatchShowStatusFb getMatchShowStatusFb() {
		return matchShowStatusFb;
	}

	public void setMatchShowStatusFb(MatchShowStatusFb matchShowStatusFb) {
		this.matchShowStatusFb = matchShowStatusFb;
	}



	public Integer getValue() {
		return value;
	}



	public void setValue(Integer value) {
		this.value = value;
	}

}
