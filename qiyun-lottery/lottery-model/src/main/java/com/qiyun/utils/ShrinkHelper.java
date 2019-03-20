package com.qiyun.utils;

/**
 * 缩水帮助类
 * 
 * @author sxh 2011-10-12
 */
public class ShrinkHelper {

	public static String repalceTemplate(int index,String[] nums){
		String num = "";
		switch(index){
			case 1:
				num = ","+nums[0];
				break;
			case 2:
				num = ","+nums[1];
				break;
			case 3:
				num = ","+nums[2];
				break;
			case 4:
				num = ","+nums[3];
				break;
			case 5:
				num = ","+nums[4];
				break;
			case 6:
				num = ","+nums[5];
				break;
			case 7:
				num = ","+nums[6];
				break;
			case 8:
				num = ","+nums[7];
				break;
			case 9:
				num = ","+nums[8];
				break;
			case 10:
				num = ","+nums[9];
				break;
			case 11:
				num = ","+nums[10];
				break;
			case 12:
				num = ","+nums[11];
				break;
			case 13:
				num = ","+nums[12];
				break;
			case 14:
				num = ","+nums[13];
				break;
			case 15:
				num = ","+nums[14];
				break;
			case 16:
				num = ","+nums[15];
				break;
			case 17:
				num = ","+nums[16];
				break;
			case 18:
				num = ","+nums[17];
				break;
			case 19:
				num = ","+nums[18];
				break;
			case 20:
				num = ","+nums[19];
				break;
		}
		return num;
	} 
	
	//旋转矩阵保号法过滤数据
	public static String spiralFilter(String[] nums,String templates){
		String[] template = templates.split("\\|");
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<template.length; i++) {
			StringBuffer temp = new StringBuffer();
			String[] postion = template[i].split("\\,");
			for(int j=0; j<postion.length; j++){
				temp.append(repalceTemplate(Integer.parseInt(postion[j]),nums));
			}
			sb.append("|" + temp.toString().substring(1));
		}
		
		String result = sb.toString().substring(1);

		return result;
	}
}
