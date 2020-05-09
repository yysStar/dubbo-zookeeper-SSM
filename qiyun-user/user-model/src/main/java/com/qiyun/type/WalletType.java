package com.qiyun.type;

import com.qiyun.util.IntegerBeanLabel;

public class WalletType extends IntegerBeanLabel {
	private static final long serialVersionUID = -1410849485815957495L;

	protected WalletType(String name, int value) {
		super(WalletType.class.getName(), name, value);
	}

	public static WalletType getItem(int value) {
		return (WalletType) WalletType.getResult(WalletType.class.getName(), value);
	}

	public static final WalletType DUOBAO = new WalletType("钱包", 1);
	public static final WalletType ZENGJIN = new WalletType("赠金钱包", 5);
}
