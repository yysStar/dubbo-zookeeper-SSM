package com.qiyun.status;

import com.qiyun.hibernate.IntegerBeanLabelItem;
import com.qiyun.httpUtil.WebConstants;
import com.qiyun.lottery.LotteryPlan;

public class PublicStatus extends IntegerBeanLabelItem {

	protected PublicStatus(String name, int value) {
		super(PublicStatus.class.getName(), name, value);
	}

	public static PublicStatus getItem(int value) {
		return (PublicStatus) PublicStatus.getResult(PublicStatus.class.getName(), value);
	}

	public static final PublicStatus NOT_PUBLIC = new PublicStatus("不公开", 1);

	public static final PublicStatus PUBLIC = new PublicStatus("公开", 2);

	public static final PublicStatus AWARD_PUBLIC = new PublicStatus("截止公开", 3);
	
	public static final PublicStatus FOLLOW_PUBLIC = new PublicStatus("跟单公开", 4);

	/**
	 * 方案静态化是否公开
	 */
	public static boolean getIsPublic(LotteryPlan lPlan, boolean isPublic){
		if(!isPublic) {
			if (lPlan.getPublicStatus().equals(PublicStatus.PUBLIC)) {
				isPublic = true;
			} else if (lPlan.getPublicStatus().equals(PublicStatus.AWARD_PUBLIC)) {
				isPublic = true;
			}
		}
		return isPublic;
	}
	
	/**
	 * 方案静态化是否具有不公开的内容
	 */
	public static boolean getIsWithPrivate(LotteryPlan lPlan){
		boolean isPublic = true;
		if (lPlan.getPublicStatus().equals(PublicStatus.PUBLIC) || 
			lPlan.getPublicStatus().equals(PublicStatus.AWARD_PUBLIC)) {
			isPublic = false;
		} 
		return isPublic;
	}
	
	/**
	 * 方案静态化获得保存路径
	 */
	public static String getFilePath(String key,LotteryPlan lPlan,boolean isPublic){
		Integer planNo=lPlan.getPlanNo();
		String filePath="";
		String str="";
		if(isPublic)str="/public";
		if(key.equals("index")){
			filePath = WebConstants.getWebPath() + "static/sporttery/plan"+str+"/index_"+ planNo +".html";
		}else if(key.equals("show")){
			filePath = WebConstants.getWebPath() + "static/sporttery/plan"+str+"/show_"+ planNo +".html";
		}else if(key.equals("ticket")){
			filePath = WebConstants.getWebPath() + "static/sporttery/plan"+str+"/ticket_"+ planNo +".html";
		}
		return filePath;
	}


}
