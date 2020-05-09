package com.qiyun.model;

import java.io.File;
import java.io.FilenameFilter;

public class ImageFilter implements FilenameFilter {
	
	public boolean isJpg(String filename){
		//把文件转成小写后看其后缀是否为.jpg
		if (filename.toLowerCase().endsWith(".jpg")){
			 return true; 
		} else {
			return false; 
		}  
		
	}  
	
	//覆写accept方法
	public boolean accept(File dir, String filename) {
		return isJpg(filename);
	}

}
