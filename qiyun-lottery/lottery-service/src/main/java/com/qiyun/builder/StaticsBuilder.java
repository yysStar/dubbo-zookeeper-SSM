package com.qiyun.builder;

import java.util.HashMap;

public interface StaticsBuilder {

	final public String TERM = "term";
	final public String DATE = "date";
	final public String CODE_LIST = "codeList";
	final public String POOL_AWARD = "poolAward";
	final public String LOTTERY_TYPE = "lotteryType";

	final public String DATA_LIST = "dataList";
	final public String DATA_ALL_SHOW = "dataAllShow";
	final public String DATA_TYPE = "dataType";

	final public String CODE = "code";

	final public String NEED_INIT = "needInit";

	public String make(HashMap<String, Object> map) throws Exception;

	public void setFilePath(String string);

}
