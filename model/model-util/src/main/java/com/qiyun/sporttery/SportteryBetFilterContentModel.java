package com.qiyun.sporttery;

import com.qiyun.item.MatchItem;
import com.qiyun.model.Conditions;

import java.util.List;


public class SportteryBetFilterContentModel<X extends MatchItem> extends SportteryBetContentModel<X> {
	private static final long serialVersionUID = 1L;
	private List<String> contentList;
	private Conditions conditions;

	public List<String> getContentList() {
		return contentList;
	}

	public void setContentList(List<String> contentList) {
		this.contentList = contentList;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Conditions getConditions() {
		return conditions;
	}

	public void setConditions(Conditions conditions) {
		this.conditions = conditions;
	}

}
