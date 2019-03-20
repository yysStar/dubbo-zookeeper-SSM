package com.qiyun.lottery;

/**
 * 战绩等级
 * 
 * @author wb
 * @since 2015.04.07
 */
public enum RecordLevel {
	GOLD_BRICK("金砖",1), GOLD_DIAMOND("钻石",2), GOLD_CROWN("银冠",3), CROWN("皇冠",4);

	private String name;
	private int value;

	private RecordLevel( String name,int value) {
		this.value = value;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
		
}
