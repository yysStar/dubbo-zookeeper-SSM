package com.qiyun.util;

/**
 * 生成随机数工具类：<br>
 * @author sxh
 */
public class RandomUtil {
	
    /**
     * 生成随机数
     */
    public final static int getRandom(int max,int min) {
    	int number = (int) (Math.random() * (max - min)) + min;
    	return number;
    }
}	
