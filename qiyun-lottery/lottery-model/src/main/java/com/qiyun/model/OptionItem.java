package com.qiyun.model;

import java.io.Serializable;

/**
 * 选项接口
 * 
 */
public interface OptionItem extends Serializable {
	/**
	 * @return 选项的表示符号
	 */
	String getValue();

	/**
	 * @return 选项的名称
	 */
	String getText();

	/**
	 * @return 选项的序号
	 */
	int getOrdinal();

	String getBozhongValue();

}
