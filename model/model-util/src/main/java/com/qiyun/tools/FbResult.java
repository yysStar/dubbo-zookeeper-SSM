package com.qiyun.tools;

/**
 * 
 * @author Administrator 足球赛果类
 */
public class FbResult {
	public static final String[] bfResult = new String[] { "胜其他", "1:0", "2:0", "2:1", "3:0", "3:1", "3:2", "4:0", "4:1", "4:2", "平其他", "0:0", "1:1",
			"2:2", "3:3", "负其他", "0:1", "0:2", "1:2", "0:3", "1:3", "2:3", "0:4", "1:4", "2:4" };
	public static final String[] spfResult = new String[] { "负", "平", "", "胜" };
	public static final String[] sxdsResult = new String[] { "上单", "上双", "下单", "下双" };
	public static final String[] jqsResult = new String[] { "0", "1", "2", "3", "4", "5", "6", "7+" };
	public static final String[] bqcResult = new String[] { "胜-胜", "胜-平", "胜-负", "平-胜", "平-平", "平-负", "负-胜", "负-平", "负-负" };
	public static final String[] sfggResult = new String[] { "负", "平", "", "胜" };
	public static void main(String[] args) {
		String[] optionArr=bqcResult;
		for(int i=0;i<optionArr.length;i++){
			if(!StringTools.isNullOrBlank(optionArr[i])){
				System.out.println("OPTION_MAP.put(\""+i+"\",\""+optionArr[i]+"\");");
			}
			
		}
		
	}
}
