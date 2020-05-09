package com.qiyun.utils;

import org.apache.log4j.Logger;

public class LogUtil {
	private final static Logger log = Logger.getLogger("GL");

	public static void fatal(String format,Object... params){
		log.fatal(String.format(format, params));
	}
	
	public static void fatal(Object message){
		log.fatal(message);
	}
	
	public static void fatal(Object message,Throwable e){
		log.fatal(message, e);
	}
	
	public static void fatal(Throwable e){
		log.fatal(null, e);
	}
	
	public static void error(Object message){
		log.error(message);
	}
	public static void error(Object message,Throwable e){
		log.error(message, e);
	}
	
	public static void error(Throwable e){
		log.error(null, e);
	}
	
	public static void warn(Object message){
		log.warn(message);
	}
	
	public static void info(Object message){
		log.info(message);
	}
	
	public static void info(String format,Object... params){
		log.info(String.format(format, params));
	}

	public static void debug(String format,Object... params){
		log.debug(String.format(format, params));
	}
	
	public static void debug(Object message){
		log.debug(message);
	}
}
