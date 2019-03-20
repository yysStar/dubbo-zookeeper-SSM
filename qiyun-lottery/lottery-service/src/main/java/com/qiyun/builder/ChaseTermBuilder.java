package com.qiyun.builder;

import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import com.qiyun.model.LotteryTerm;
import com.qiyun.tools.DateTools;
import com.qiyun.tools.FileTools;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.web.context.ServletContextAware;

public class ChaseTermBuilder implements StaticsBuilder, ServletContextAware {

	private ServletContext servletContext;
	private String filePath;
	
	@SuppressWarnings("unchecked")
	public String make(HashMap<String, Object> map) throws Exception {
		List termList = (List) map.get(DATE);
		String lotteryType = (String) map.get(LOTTERY_TYPE);

		SAXBuilder sb = new SAXBuilder();
		Reader reader = new StringReader("<?xml version=\"1.0\" encoding=\"GBK\" ?><xml></xml>");

		Document returnDoc = sb.build(reader);
		Element rootElement = returnDoc.getRootElement();
		for (int i = 0; i < termList.size(); i++) {
			LotteryTerm term = (LotteryTerm) termList.get(i);
			Element row = new Element("row");
			row.setAttribute(new Attribute("expect", term.getTerm()));
			row.setAttribute(new Attribute("endtime", DateTools.dateToString(term.getEndDateTime())));
			row.setAttribute(new Attribute("able", term.getIsAble().getValue()+""));
			row.setAttribute(new Attribute("s", term.getLotMgrIsAble().getValue()+""));
			rootElement.addContent(row);
		}
		XMLOutputter xo = new XMLOutputter();

		Format format = xo.getFormat();
		format.setEncoding("GBK");
		format.setLineSeparator("");
		xo.setFormat(format);

		String xmlContent = xo.outputString(returnDoc);
		FileTools.setFileContent(xmlContent, servletContext.getRealPath(filePath + lotteryType + ".xml"));
		return "0";
	}

	public void setFilePath(String string) {
		this.filePath = string;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	
}
