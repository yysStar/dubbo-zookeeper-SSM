package com.qiyun.serviceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import com.qiyun.util.LogUtil;
import com.qiyun.utils.FileTools;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

@Service("velocityFactory")
public class VelocityFactory implements ServletContextAware {

	private ServletContext servletContext;
	// 获取VM文件MAP[文件名][文件内容]
	private Map<String,String> vmFileNameMap = new HashMap<String,String>();
	// 从SPRING里获取要读取的文件路径
	private List<String> configPath = new ArrayList<String>();
	/**
	 * 功能： 重新载入配置文件 输入参数：无 输出参数：无 作者： 滕云 日期： 2008-2-28
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public void load() throws UnsupportedEncodingException, IOException {
		String pathPrefix=File.separator + "WEB-INF" + File.separator + "classes" + File.separator;
		for(String dir:configPath){
			String fullDir=servletContext.getRealPath(pathPrefix+dir);
			File floder = new File(fullDir);
			// 获取对应路径下的所有文件名，存入fileList
			File files[] = floder.listFiles();			
			if (files == null) continue;
			StringBuilder sb;
			for(File file:files){
				if(file.isDirectory())continue;
				if(!file.getName().endsWith(".vm"))continue;
				InputStreamReader insReader = new InputStreamReader(new FileInputStream(file.getAbsoluteFile()), "UTF-8");  
                BufferedReader br = new BufferedReader(insReader);
				String line = br.readLine();
				sb= new StringBuilder();
				while (line != null) {
					sb.append(line).append('\n');
					line = br.readLine();
				}
				br.close();
				insReader.close();
				this.vmFileNameMap.put(FileTools.getFileName(file.getName()), sb.toString());
			}
		}
		LogUtil.info("load vm File Success!");
	}

	/**
	 * 功能： 获取对应模板的String输出 输入参数：vmFileName ---输入的模板名称
	 * vmVarMap[当前模板对应的变量名][当前模板对应的变量值] 输出参数：boolean的结果值，用来判断是否成功 作者：滕云
	 * 日期：2008-2-28
	 */
	public String getStaticString(String vmFileName, Map vmVarMap) throws Exception {
		String fileContent = this.vmFileNameMap.get(vmFileName).toString();
		Velocity.init();
		VelocityContext context = new VelocityContext();
		// 将获取的变量放入context里面
		Set set = vmVarMap.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			context.put(entry.getKey().toString(), entry.getValue());
		}
		StringWriter writer = new StringWriter();
		Velocity.evaluate(context, writer, "evaluate...", fileContent);
		String ret = writer.toString();
		return ret;
	}

	public Map getVmFileNameMap() {
		return vmFileNameMap;
	}

	public void setVmFileNameMap(Map vmFileNameMap) {
		this.vmFileNameMap = vmFileNameMap;
	}

	public List getConfigPath() {
		return configPath;
	}

	public void setConfigPath(List configPath) {
		this.configPath = configPath;
	}

	public void setServletContext(ServletContext arg0) {
		servletContext = arg0;
	}
}
