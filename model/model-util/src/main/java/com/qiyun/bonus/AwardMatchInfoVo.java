package com.qiyun.bonus;

import java.util.List;
import java.util.Map;


/**
 * 赛事信息VO
 * 
 * @author wqs
 * 
 */
public class AwardMatchInfoVo {
	/**
	 * 最大奖金的选项组合
	 */
	private AwardOptionComineVo maxZh;
	/**
	 * 最小奖金的选项组合
	 */
	private AwardOptionComineVo minZh;
	/**
	 * 投注赛事
	 */
	private Sporttery3GMatchItem matchItem;
	
	/**
	 * 是否必中(全包某一玩法)
	 */
	private Boolean hasBingo;

	public AwardOptionComineVo getMaxZh() {
		return maxZh;
	}

	public void setMaxZh(AwardOptionComineVo maxZh) {
		this.maxZh = maxZh;
	}

	public AwardOptionComineVo getMinZh() {
		return minZh;
	}

	public void setMinZh(AwardOptionComineVo minZh) {
		this.minZh = minZh;
	}

	public Sporttery3GMatchItem getMatchItem() {
		return matchItem;
	}

	public void setMatchItem(Sporttery3GMatchItem matchItem) {
		this.matchItem = matchItem;
	}

	public Boolean getHasBingo() {
		if(hasBingo==null){
			if(matchItem!=null){
				boolean flag=false;
				Map<com.qiyun.commonModel.LotteryType, List<SportteryOption3G>> map=matchItem.getPlayTypes();
				for (Map.Entry<com.qiyun.commonModel.LotteryType, List<SportteryOption3G>> entry : map.entrySet()) {
					com.qiyun.commonModel.LotteryType key=entry.getKey();
					 int size=entry.getValue().size();
					 if(key==com.qiyun.commonModel.LotteryType.JC_ZQ_SPF || key==com.qiyun.commonModel.LotteryType.JC_ZQ_RQSPF){
						 flag=size==3;
					 }else if(key==com.qiyun.commonModel.LotteryType.JC_ZQ_JQS){
						 flag=size==8;
					 }else if(key==com.qiyun.commonModel.LotteryType.JC_ZQ_BQC){
						 flag=size==9;
					 }else if(key==com.qiyun.commonModel.LotteryType.JC_ZQ_BF){
						 flag=size==31;
					 }
					 else if(key==com.qiyun.commonModel.LotteryType.JC_LQ_SF || key==com.qiyun.commonModel.LotteryType.JC_LQ_RFSF || key==com.qiyun.commonModel.LotteryType.JC_LQ_DXF){
						 flag=size==2;
					 }else if(key==com.qiyun.commonModel.LotteryType.JC_LQ_SFC){
						 flag=size==12;
					 }
				}
				if(!flag){ //判断胜平负和让球胜平负的必中条件
					if(map.containsKey(com.qiyun.commonModel.LotteryType.JC_ZQ_SPF) && map.containsKey(com.qiyun.commonModel.LotteryType.JC_ZQ_RQSPF)){
						if(matchItem.getRqs()==1 || matchItem.getRqs()==-1){
							String[] arr=new String[2]; //0->spf,1->rqspf
							if(matchItem.getRqs()==1){ // spf_0 rqspf_3
								arr[0]="0";
								arr[1]="3";
							}else { // spf_3 rqspf_0
								arr[0]="3";
								arr[1]="0";
							}
							
							List<SportteryOption3G> list=map.get(com.qiyun.commonModel.LotteryType.JC_ZQ_SPF);
							boolean spfFlag=false;
							for (int i = 0; i < list.size(); i++) {
								if(list.get(i).getValue().equals(arr[0])){
									spfFlag=true;
									break;
								}
							}
							list=map.get(com.qiyun.commonModel.LotteryType.JC_ZQ_RQSPF);
							boolean rqspfFlag=false;
							for (int i = 0; i < list.size(); i++) {
								if(list.get(i).getValue().equals(arr[1])){
									rqspfFlag=true;
									break;
								}
							}
							if(spfFlag && rqspfFlag){
								flag=true;
							}
						}
					}
				}
				hasBingo=flag;
			}
		}
		return hasBingo;
	}

}
