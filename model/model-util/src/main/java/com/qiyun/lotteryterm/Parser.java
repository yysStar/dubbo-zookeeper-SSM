package com.qiyun.lotteryterm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;

public class Parser extends ParserCallback {

	private Map<Integer, String> resultMap = new Hashtable<Integer, String>();
	private List<String> keyList = new ArrayList<String>();
	private boolean isResult = false;

	// private boolean isResult;

	public void handleComment(char[] data, int pos) {
	}

	public void handleEndTag(HTML.Tag t, int pos) {
		if (t == HTML.Tag.TR) {
			isResult = false;
		}
	}

	public void handleError(String errorMsg, int pos) {
	}

	public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, int pos) {
		handleStartTag(t, a, pos);
	}

	public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
		if (t == HTML.Tag.TR) {
			isResult = true;
		}
	}

	public void handleText(char[] data, int pos) {
		if (isResult) {
			keyList.add(String.valueOf(data));
			resultMap.put(Integer.valueOf(pos), String.valueOf(data));
		}
	}

	public Map<Integer, String> getResultMap() {
		return resultMap;
	}

	public List<String> getKeyList() {
		return keyList;
	}
}
