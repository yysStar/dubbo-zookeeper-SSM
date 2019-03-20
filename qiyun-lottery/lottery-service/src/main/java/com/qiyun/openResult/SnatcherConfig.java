
package com.qiyun.openResult;

import com.qiyun.httpUtil.WebConstants;
import com.qiyun.util.LogUtil;
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 数据源配置
 */
public class SnatcherConfig {
	private static SnatcherConfig instance;
	public static SnatcherConfig getInstance(){
		if(instance==null)instance=new SnatcherConfig();
		return instance;
	}
	private List<ConfigLottery> configs;
	/**
	 * 构造函数
	 * */
	private SnatcherConfig(){
		configs = new ArrayList<ConfigLottery>();
		try {
			SAXReader reader = new SAXReader();
			
			String path= WebConstants.getWebPath()+"WEB-INF/classes/snatcher.xml";
//			URL url= SnatcherConfig.class.getClassLoader().getResource("snatcher.xml");
			File file=new File(path);
//			if(url==null){
//				file=new File("../caipiao_web/src/snatcher.xml");
//			}
			org.dom4j.Document document = reader.read(file);
		    org.dom4j.Element root = document.getRootElement();
		    List<?> lotterys = root.elements("lottery");
		    for (Iterator<?> it = lotterys.iterator(); it.hasNext();) {
		    	List<ConfigSource> configSources=new ArrayList<ConfigSource>();
		    	org.dom4j.Element lotteryElm = (org.dom4j.Element)it.next();
		    	String type=lotteryElm.attribute("type").getText();
		    	String name=lotteryElm.attribute("name").getText();
		        List<?> sources=lotteryElm.elements("source");
		        for (Iterator<?> itSource = sources.iterator(); itSource.hasNext();) {
		        	org.dom4j.Element sourceElm = (org.dom4j.Element)itSource.next();
		        	ConfigSource configSource=new ConfigSource();
		        	configSource.href=sourceElm.attribute("href").getText();
		        	configSource.listQuery=sourceElm.attribute("listquery").getText();
		        	configSource.source=sourceElm.attribute("name").getText();
		        	configSource.type=type;
		        	configSource.name=name;
		        	Attribute dateFormat=sourceElm.attribute("dateformat");
		        	Attribute method=sourceElm.attribute("method");
		        	if(method!=null)configSource.method=method.getText();
		        	if(dateFormat!=null){
		        		configSource.dateFormat=dateFormat.getText() ;
		        	}
		        	List<?> items=sourceElm.elements("item");
		        	List<ConfigItem> configItems=new ArrayList<ConfigItem>();
		        	for (Iterator<?> itItem = items.iterator(); itItem.hasNext();) {
		        		org.dom4j.Element itemElm = (org.dom4j.Element)itItem.next();
		        		ConfigItem configItem=new ConfigItem();
		        		Attribute termformatAttr=itemElm.attribute("termformat");
		        		Attribute codeRepalceMap=itemElm.attribute("coderepalcemap");
		        		if(termformatAttr!=null)configItem.termFormat=termformatAttr.getText();
		        		if(codeRepalceMap!=null)configItem.codeRepalceMap=codeRepalceMap.getText();
		        		configItem.termQuery=itemElm.attribute("termquery").getText();
		        		configItem.termReg=itemElm.attribute("termreg").getText();
		        		configItem.codeQuery=itemElm.attribute("codequery").getText();
		        		configItem.codeReg=itemElm.attribute("codereg").getText();
		        		configItem.codeFormat=itemElm.attribute("codeformat").getText();
		        		configItems.add(configItem);
		        	}
		        	configSource.configItems=configItems;
		        	configSources.add(configSource);
		        }
		        ConfigLottery configLottery = new ConfigLottery();
		        configLottery.lotteryType=Integer.parseInt(type);
		        configLottery.configSources=configSources;
		        configs.add(configLottery);
		    }
		} catch (DocumentException e) {
			LogUtil.info("加载开奖配置文件失败:" + e.getMessage());
		}
	}
	
	
	public List<ConfigSource> getConfigSources(Integer lotteryType) {
		for(ConfigLottery configLottery :configs){
			if(configLottery.lotteryType.equals(lotteryType)){
				return configLottery.configSources;
			}
		}		
		return null;
	}

	public class ConfigSource{
		public String method;
		public String href;
		public String dateFormat;
		public String listQuery;
		public String name;
		public String source;
		public String type;
		public List<ConfigItem> configItems;
	}
	
	public class ConfigItem{
		public String termQuery;
		public String termReg;
		public String codeQuery;
		public String codeRepalceMap;
		public String codeReg;
		public String codeFormat;
		public String termFormat;
	}
	
	public class ConfigLottery{
		public Integer lotteryType;
		public List<ConfigSource> configSources;
	}
}

