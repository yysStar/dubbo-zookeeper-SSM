package com.qiyun.lottery;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qiyun.commonModel.LotteryType;

import com.qiyun.model.*;
import com.qiyun.model.basketball.BasketBallBetContent;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.status.CommonStatus;
import com.qiyun.tools.DateTools;
import com.qiyun.type.SelectType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * <p>保存方案</p>
 * @author tangfeng
 */
public class LotteryPlanSaved extends AbstractLotteryPlanSaved {
	
	private static final long serialVersionUID = 1L;
	
	private Member member;
	
	private String contentShow;
	
	/**
	 * <p>是否已过期</p>
	 * @return boolean true:已过期   false:未过期
	 */
	public boolean isExpired() {
		boolean isExpired = false;
		Date dealDateTime = getDealDateTime();
		
		if (new Date().compareTo(dealDateTime) >= 0) {
			isExpired = true;
		}
		
		return isExpired;
	}
	
	/**
	 * <p>数字彩方案内容</p>
	 * @return String
	 */
	public String getSzcContent() {
		return getContent().split("%")[0];
	}
	
	/**
	 * <p>北单方案内容</p>
	 * @return String
	 */
	public String getDcContent() {
		String content = getContent();
		
		// 单式上传
		if (getSelectType().getValue() == SelectType.UPLOAD.getValue()) {
			content = content.split("_")[0];
		} else { // 非单式上传
			content = content.split("!")[1].split("%")[0];
		}
		
		return content;
	}
	
	/**
	 * <p>北单单式上传文件路径</p>
	 * @return String
	 */
	public String getDcFilePath() {
		return getContent().split("_")[1].split("%")[0];
	}
	
	/**
	 * <p>北单单式上传是否带场次号</p>
	 * @return String
	 */
	public String getDcIsWithBoutIndex() {
		return getContent().split("&")[1];
	}
	
	/**
	 * <p>北单单式上传玩法</p>
	 * @return String
	 */
	public String getDcPlayType() {
		return getContent().split("!")[1].split("#")[0];
	}
	
	/**
	 * <p>竞彩足球和竞彩篮球内容转换（JSON字符串转成bean对象）</p>
	 * @return SportteryBetContentModel
	 */
	@SuppressWarnings("unchecked")
	public SportteryBetContentModel convertContentJJC() {
		SportteryBetContentModel bc = null;
		JSONObject jsonObject = JSONObject.fromObject(getContent());
		
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("passTypes", SportteryPassType.class);
		classMap.put("options", SportteryOption.class);
		
        if (LotteryType.JCZQList.contains(getLotteryType())||LotteryType.GYJ_ZQ_LIST.contains(getLotteryType())) {
        	classMap.put("matchItems", FootBallMatchItem.class);
        	bc = (FootBallBetContent)JSONObject.toBean(jsonObject, FootBallBetContent.class, classMap);
		} else if (LotteryType.JCLQList.contains(getLotteryType())) {
			classMap.put("matchItems", BasketBallMatchItem.class);
			bc = (BasketBallBetContent)JSONObject.toBean(jsonObject, BasketBallBetContent.class, classMap);
		}
        
        return bc;
	}
	
	/**
	 * <p>竞彩足球和竞彩篮球是否去除单一玩法</p>
	 * @return boolean
	 */
	public boolean getIsOnlyPlay() {
		return convertContentJJC().getIsOnlyPlay();
	}
	
	/**
	 * <p>竞彩足球和竞彩篮球过关类型</p>
	 * @return String
	 */
	public String getPassMode() {
		return convertContentJJC().getPassMode() == PassMode.PASS.ordinal() ? PassMode.PASS.name() : PassMode.SINGLE.name();
	}
	
	/**
	 * <p>竞彩足球和竞彩篮球赛事选项</p>
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List getMatchItems() {
		return convertContentJJC().getMatchItems();
	}
	
	/**
	 * <p>竞彩足球和竞彩篮球过关方式</p>
	 * @return List<SportteryPassType>
	 */
	@SuppressWarnings("unchecked")
	public List<SportteryPassType> getPassTypes() {
		return convertContentJJC().getPassTypes();
	}
	
	/**
	 * <p>竞彩足球和竞彩篮球单式上传内容转换（JSON字符串转成JSON对象）</p>
	 * @return JSONObject
	 */
	public JSONObject convertContentJJC_DS() {
		return JSONObject.fromObject(getContent());
	}
	
	/**
	 * <p>竞彩足球和竞彩篮球单式上传文件路径</p>
	 * @return String
	 */
	public String getFilePath() {
		return convertContentJJC_DS().getString("filePath");
	}
	
	/**
	 * <p>竞彩足球和竞彩篮球单式上传是否带场次号</p>
	 * @return boolean
	 */
	public boolean getIsWithBoutIndex() {
		return convertContentJJC_DS().getBoolean("isWithBoutIndex");
	}
	
	/**
	 * <p>竞彩足球和竞彩篮球单式上传过关方式</p>
	 * @return String
	 */
	public String getPassType() {
		JSONArray jsonArray = convertContentJJC_DS().getJSONArray("passTypes");
		return jsonArray.getString(0);
	}
	
	public String getLotteryPath() {
		String path = "";
		
		if (LotteryType.LOTTERY_PATH.containsKey(getLotteryType())) {
			path = "/lottery/" + LotteryType.LOTTERY_PATH.get(getLotteryType());
		}
		
		return path;
	}
	
	public List<PrizeBean> getPrizeBeanList() {
		return PrizeCommon.buildToList(getLotteryType().getValue(), getPrizeContent());
	}
	
	/**
	 * <p>是否已经上传方案(保存方案都是已上传方案)</p>
	 * @return Integer
	 */
	public Integer getIsUploadContent() {
		return CommonStatus.YES.getValue();
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getContentShow() {
		return contentShow;
	}

	public void setContentShow(String contentShow) {
		this.contentShow = contentShow;
	}
	
	public List<PlanStatusList> getPlanStatusList(){
		List<PlanStatusList> statusList = null;		
		statusList = new ArrayList<PlanStatusList>();
		statusList.add(new PlanStatusList("保存方案", DateTools.dateToString(this.getCreateDateTime()),null));
		if(isExpired()){
			statusList.add(new PlanStatusList("方案过期",DateTools.dateToString(this.getDealDateTime()),"已完成"));
		}
		if(this.getOpenResultTime() != null){
			statusList.add(new PlanStatusList("方案开奖",DateTools.dateToString(this.getOpenResultTime()),"已完成"));
		}		
		return statusList;
	}
}
