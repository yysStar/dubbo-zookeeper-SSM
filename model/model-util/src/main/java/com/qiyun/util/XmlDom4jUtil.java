package com.qiyun.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

/**
 * xml 文件的解析工具类
 * 
 * @author yyx
 *
 */
public class XmlDom4jUtil {
	private static final Logger LOGGER = Logger.getLogger(XmlDom4jUtil.class);

	private static SAXReader saxReader;

	private XmlDom4jUtil() {
	}

	public static XmlDom4jUtil getInstance() {
		return EnumSingleton.INSTANCE.getTransportClient();
	}

	private static enum EnumSingleton {
		INSTANCE;
		private XmlDom4jUtil instance;

		private EnumSingleton() {
			saxReader = new SAXReader();
			instance = new XmlDom4jUtil();
		}

		private XmlDom4jUtil getTransportClient() {
			return instance;
		}
	}

	/**
	 * @param xmlContent
	 * @param xpathExpression
	 *            格式TimelineObject[0]/ContentObject/mediaList/media/thumb
	 * @return
	 */
	private synchronized String getValue(String xmlContent, String xpathExpression) {
		String value = null;
		if (CommonUtil.isEmpty(xmlContent)) {
			return value;
		}
		try {
			xmlContent = xmlContent.replaceAll("\\\\\"", "\"");
			xmlContent = xmlContent.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
			Document document = saxReader.read(new ByteArrayInputStream(xmlContent.getBytes("UTF-8")));
			Node node = document.selectSingleNode(xpathExpression);
			if (node != null) {
				value = node.getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("xml文档出错" + xmlContent);
			LOGGER.error(CommonUtil.getExceptionInfo(e));
			return value;
		}
		return value;
	};

	/**
	 * 获取内容
	 * 
	 * @param xmlContent
	 * @return
	 */
	public String getContent(String xmlContent, String node) {
		return getValue(xmlContent, node);
	}
	
	/**
	 * xml转map——获取根节点下的数据，解析回调数据使用
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,String> xml2Map(String xml) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Document doc = DocumentHelper.parseText(xml);//将xml转为dom对象
            Element element = doc.getRootElement();//获取根节点
            List<Element> elements = element.elements();
             for (Object obj : elements) {
                  element = (Element) obj;  
                  map.put(element.getName(), element.getTextTrim());
             } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }



    /**
     * 循环解析一层xml
     * @param filename
     * @return
     */
    public static List<Map<String, String>> iterateWholeXML1(String filename) {
        // 把所得的属性 值 都封装 集合里
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        // 得到解析器
        SAXReader reader = new SAXReader();
        // 第二步 得到当前XML 文档的Document对象
        try {
            Document document = DocumentHelper.parseText(filename);//将xml转为dom对象
            // 获取document 根目录下
            Element root = document.getRootElement();
            // 遍历根节点的所有子节点
            for (Iterator iter = root.elementIterator(); iter.hasNext();) {
                // 封装属性值到HashMap 集合里
                HashMap<String, String> map = new HashMap<String, String>();
                // 遍历所有节点
                Element element = (Element) iter.next();
                // 判断 element 不等于null
                if (element == null)
                    continue;
                String s = element.getText();
                // 封装map集合里 把属性和值
                map.put(element.getName(), s);
                // 封装list集合里
                list.add(map);
            }
            return list; // 返回list 集合里
        }
        catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return null;
    }

	/**
	 * iterateWholeXML:(循环解析2层XML)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * TODO(这里描述这个方法的执行流程 – 可选)
	 * TODO(这里描述这个方法的使用方法 – 可选)
	 * TODO(这里描述这个方法的注意事项 – 可选)
	 *
	 * @param @param filename
	 * @param @return 设定文件
	 * @return List<Map<String,String>> DOM对象
	 * @throws
	 * @since CodingExample　Ver 1.1
	 */
	public static List<Map<String, String>> iterateWholeXML(String filename) {
		// 把所得的属性 值 都封装 集合里
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// 得到解析器
		SAXReader reader = new SAXReader();
		// 第二步 得到当前XML 文档的Document对象
		try {
//			Document document = reader.read(new File(filename));
			Document document = DocumentHelper.parseText(filename);//将xml转为dom对象
			// 获取document 根目录下
			Element root = document.getRootElement();
			// 遍历根节点的所有子节点
			for (Iterator iter = root.elementIterator(); iter.hasNext();) {
				// 封装属性值到HashMap 集合里
				HashMap<String, String> map = new HashMap<String, String>();
				// 遍历所有节点
				Element element = (Element) iter.next();
				// 判断 element 不等于null
				if (element == null)
					continue;
				// 获取属性和它的值
				for (Iterator attrs = element.attributeIterator(); attrs
						.hasNext();) {
					// 获取属性
					Attribute attr = (Attribute) attrs.next();
					// 判断属性 null
					if (attr == null)
						continue;
					// 获取属性
					String attrName = attr.getName();
					// 获取值
					String attrValue = attr.getValue();
					// 封装map集合里 把属性和值
					map.put(attrName, attrValue);
				}
				// 判断 只读
				if (element.isReadOnly()) {
					String elementName = element.getName();
					String elementValue = element.getText();
					map.put(elementName, elementValue);
				}
				else {
					// 遍历节点的所有孩子节点，并进行处理

					for (Iterator iterInner = element.elementIterator(); iterInner
							.hasNext();) {

						Element elementInner = (Element) iterInner.next();

						// 如果没有孩子节点，则直接取值
						if (elementInner == null) {
							String elementName = element.getName();
							String elementValue = element.getText();

							map.put(elementName, elementValue);

						}
						// 孩子节点的属性
						for (Iterator innerAttrs = elementInner
								.attributeIterator(); innerAttrs.hasNext();) {
							Attribute innerAttr = (Attribute) innerAttrs.next();
							if (innerAttr == null)
								continue;
							String innerAttrName = innerAttr.getName();
							String innerAttrValue = innerAttr.getValue();
							map.put(innerAttrName, innerAttrValue);
						}
						// 假设没有第三层嵌套，获得第二层的值
						String innerName = elementInner.getName();
						String innerValue = elementInner.getText();
						map.put(innerName, innerValue);
					}
				}
				// 封装list集合里
				list.add(map);
			}
			return list; // 返回list 集合里
		}
		catch (DocumentException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;

	}



    /**
     * 将xml转换为JSON对象
     * @param xml xml字符串
     * @return
     * @throws Exception
     */
    public static JSONObject xmltoJson(String xml) throws Exception {
        JSONObject jsonObject = new JSONObject();
        Document document = DocumentHelper.parseText(xml);
        //获取根节点元素对象
        Element root = document.getRootElement();
        iterateNodes(root, jsonObject);
        return jsonObject;
    }

    /**
     * 遍历元素
     * @param node 元素
     * @param json 将元素遍历完成之后放的JSON对象
     */
    @SuppressWarnings("unchecked")
    public static void iterateNodes(Element node,JSONObject json){
        //获取当前元素的名称
        String nodeName = node.getName();
        //判断已遍历的JSON中是否已经有了该元素的名称
        if(json.containsKey(nodeName)){
            //该元素在同级下有多个
            Object Object = json.get(nodeName);
            JSONArray array = null;
            if(Object instanceof JSONArray){
                array = (JSONArray) Object;
            }else {
                array = new JSONArray();
                array.add(Object);
            }
            //获取该元素下所有子元素
            List<Element> listElement = node.elements();
            if(listElement.isEmpty()){
                //该元素无子元素，获取元素的值
                String nodeValue = node.getTextTrim();
                array.add(nodeValue);
                json.put(nodeName, array);
                return ;
            }
            //有子元素
            JSONObject newJson = new JSONObject();
            //遍历所有子元素
            for(Element e:listElement){
                //递归
                iterateNodes(e,newJson);
            }
            array.add(newJson);
            json.put(nodeName, array);
            return ;
        }
        //该元素同级下第一次遍历
        //获取该元素下所有子元素
        List<Element> listElement = node.elements();
        if(listElement.isEmpty()){
            //该元素无子元素，获取元素的值
            String nodeValue = node.getTextTrim();
            json.put(nodeName, nodeValue);
            return ;
        }
        //有子节点，新建一个JSONObject来存储该节点下子节点的值
        JSONObject object = new JSONObject();
        //遍历所有一级子节点
        for(Element e:listElement){
            //递归
            iterateNodes(e,object);
        }
        json.put(nodeName, object);
        return ;
    }

	/**
	 * 获取xml某个节点下的内容
	 * @param xml
	 * @param node
	 * @throws DocumentException
	 */
	public static void getNodeText(String xml,String node) throws DocumentException {
		Document document = DocumentHelper.parseText(xml);//将xml转为dom对象
		Element root = document.getRootElement();
		List nodes = root.elements(node);
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			Element elm = (Element) it.next();
			for(Iterator it2=elm.elementIterator();it2.hasNext();){
				Element elel=(Element)it2.next();
				System.out.println(elel.getName()+":"+elel.getText()+":");
			}
		}
	}

}
