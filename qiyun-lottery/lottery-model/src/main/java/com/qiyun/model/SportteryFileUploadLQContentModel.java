package com.qiyun.model;

import com.qiyun.httpUtil.WebConstants;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.utils.CommonUtils;
import com.qiyun.utils.FileTools;
import net.sf.json.JSONObject;


public class SportteryFileUploadLQContentModel extends SportteryBetFilterContentModel<BasketBallMatchItem>{
	private String filePath;
	private Boolean isWithBoutIndex;
	private String optionMapText;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Boolean getIsWithBoutIndex() {
		return isWithBoutIndex;
	}

	public void setIsWithBoutIndex(Boolean isWithBoutIndex) {
		this.isWithBoutIndex = isWithBoutIndex;
	}

	public String getOptionMapText() {
		return optionMapText;
	}

	public void setOptionMapText(String optionMapText) {
		this.optionMapText = optionMapText;
	}
	public String takeFormatBoutIndexs(){
		String formatBoutIndexs="";
		for(MatchItem item:this.getMatchItems()){
			
			formatBoutIndexs+=","+item.genMatchShowKey();
		}
		formatBoutIndexs=formatBoutIndexs.substring(1);
		return formatBoutIndexs;
	}
	public String toFormatContent(){
		String fileContent="";
		try {
			fileContent= FileTools.getFileContent(WebConstants.getWebPath()+this.getFilePath());
		} catch (Exception e) {
		}
		String formatContent=fileContent+"~"+this.optionMapText;
		if(isWithBoutIndex!=null&&!isWithBoutIndex){
			formatContent+="~"+takeFormatBoutIndexs();	
		}
		return formatContent;
	}
	
	public static void main(String[] args) {
		String content="{\"matchItems\":[{\"intTime\":20111226,\"lineId\":301,\"options\":null,\"shedan\":false},{\"intTime\":20111226,\"lineId\":302,\"options\":null,\"shedan\":false},{\"intTime\":20111226,\"lineId\":303,\"options\":null,\"shedan\":false},{\"intTime\":20111226,\"lineId\":305,\"options\":null,\"shedan\":false}],\"passTypes\":[\"P4_1\"],\"passMode\":1,\"filePath\":\"/dsUpFile/111229/4yQDox3xfOa91Be6V4.txt\",\"multiple\":\"1\",\"optionMapText\":\"3:3,0:0\"}";
		 SportteryFileUploadLQContentModel model= CommonUtils.Object4Json(content, SportteryFileUploadLQContentModel.class, BasketBallMatchItem.class);
		 content=JSONObject.fromObject(model).toString();
	}

}
