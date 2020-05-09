package com.qiyun.model;

import java.io.Serializable;

public class DomainConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DomainConfig instance;
	public static String getSiteName(){
		return instance.siteName;
	}
	public static  String getWWW(){
		return instance.www;
	}
	
	public static  String getStatic(){
		return instance._static;
	}
	
	public static String getWap(){
		return instance.wap;
	}
	
	public DomainConfig(){
		instance=this;
	}
	
	private String siteName;
	public void setSiteName(String v){
		siteName=v;
	}
	
	private String www;
	public void setWww(String v){
		www=v;
	}
	
	private String _static;
	public void setStatic(String v){
		_static=v;
	}
	private String wap;
	public void setWap(String v){
		wap=v;
	}
	
}
