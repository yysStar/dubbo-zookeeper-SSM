package com.qiyun.sporttery;

import com.qiyun.httpUtil.WebConstants;
import com.qiyun.item.MatchItem;
import com.qiyun.item.football.FootBallMatchItem;
import com.qiyun.tools.FileTools;
import com.qiyun.util.LogUtil;

public class SportteryFileUploadContentModel extends SportteryBetFilterContentModel<FootBallMatchItem> {
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
			LogUtil.error(e);
		}
		String formatContent=fileContent+"~"+this.optionMapText;
		if(isWithBoutIndex!=null&&!isWithBoutIndex){
			formatContent+="~"+takeFormatBoutIndexs();	
		}
		return formatContent;
	}
}
