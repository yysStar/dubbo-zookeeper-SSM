package com.qiyun.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;


import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

public class FreeMarker {

	private static Configuration cfg; 

	public static void init(String path) throws Exception { 
		// 初始化FreeMarker配置

		// 创建一个Configuration实例

		cfg = new Configuration();

		// 设置FreeMarker的模版文件位置
		path = URLDecoder.decode(path, "utf-8");
		cfg.setDirectoryForTemplateLoading(new File(path));
	} 

	@SuppressWarnings("unchecked")
	public static void process(HashMap root,String templateFilePath, String htmlFilePath)throws Exception { 
		templateFilePath=URLDecoder.decode(templateFilePath,"utf-8");
		htmlFilePath = URLDecoder.decode(htmlFilePath,"utf-8");
		Template t = cfg.getTemplate(templateFilePath);

		File f = new File(htmlFilePath);
		if (!f.getParentFile().exists()) {
			f.getParentFile().mkdirs();
		}
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		root.put("tools", FreeMarkerStaticMethodTools.initStaticMethod());
		t.process(root, out);
	}
	
	@SuppressWarnings("unchecked")
	public static void process(String path,HashMap root,String templateFilePath, String htmlFilePath)throws Exception {
		path=URLDecoder.decode(path,"utf-8");
		htmlFilePath = URLDecoder.decode(htmlFilePath,"utf-8");
		Configuration config = new Configuration(); 

        //设置FreeMarker的模版文件位置 
		
		config.setDirectoryForTemplateLoading(new File(path)); 
		config.setDefaultEncoding("GBK");

        Template t = config.getTemplate(templateFilePath); 
        t.setEncoding("GBK");
        
        File f = new File(htmlFilePath);
        if(!f.getParentFile().exists()){
        	f.getParentFile().mkdirs();
        }
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"GBK"));
        root.put("tools", FreeMarkerStaticMethodTools.initStaticMethod());
        t.process(root, out);
} 
	@SuppressWarnings("unchecked")
	public static String process(Map root,Template template) throws Exception{
		root.put("tools", FreeMarkerStaticMethodTools.initStaticMethod());
		return FreeMarkerTemplateUtils.processTemplateIntoString(template, root);
	}

}
