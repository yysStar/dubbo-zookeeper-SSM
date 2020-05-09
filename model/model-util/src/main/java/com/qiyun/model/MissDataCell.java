package com.qiyun.model;

/**
 * 遗漏数据单元格对象
 * @author ysh
 *
 */
public class MissDataCell extends Cell{
	
	private String num;//号码
	private int currCount;//当前出现次数
	private int liLun;//理论次数
	private String f;//出现频率
	private int preMiss;//上次遗漏
	private int currMiss;//当前遗漏
	private int maxMiss;//最大遗漏
	private String avgMiss;//平均遗漏
	private String o;//欲出几率
	private String v;//投资价值
	private String j;//回补几率
	
	private int perTermCount;//计算当期号码出现次数
	private boolean isChongHao;//是否是重号
	private boolean isLiangHao;//是否是连号
	private boolean isXieHao;//是否是斜号
	private boolean isXieTiaoHao;//是否是斜跳号
	public int getCurrMiss() {
		return currMiss;
	}
	public void setCurrMiss(int currMiss) {
		this.currMiss = currMiss;
	}
	public int getCurrCount() {
		return currCount;
	}
	public void setCurrCount(int currCount) {
		this.currCount = currCount;
	}

	public int getPerTermCount() {
		return perTermCount;
	}
	public void setPerTermCount(int perTermCount) {
		this.perTermCount = perTermCount;
	}
	public int getLiLun() {
		return liLun;
	}
	public void setLiLun(int liLun) {
		this.liLun = liLun;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public int getPreMiss() {
		return preMiss;
	}
	public void setPreMiss(int preMiss) {
		this.preMiss = preMiss;
	}
	public int getMaxMiss() {
		return maxMiss;
	}
	public void setMaxMiss(int maxMiss) {
		this.maxMiss = maxMiss;
	}
	public String getAvgMiss() {
		return avgMiss;
	}
	public void setAvgMiss(String avgMiss) {
		this.avgMiss = avgMiss;
	}
	public String getO() {
		return o;
	}
	public void setO(String o) {
		this.o = o;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getJ() {
		return j;
	}
	public void setJ(String j) {
		this.j = j;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public boolean isChongHao() {
		return isChongHao;
	}
	public void setChongHao(boolean isChongHao) {
		this.isChongHao = isChongHao;
	}
	public boolean isLiangHao() {
		return isLiangHao;
	}
	public void setLiangHao(boolean isLiangHao) {
		this.isLiangHao = isLiangHao;
	}
	public boolean isXieHao() {
		return isXieHao;
	}
	public void setXieHao(boolean isXieHao) {
		this.isXieHao = isXieHao;
	}
	public boolean isXieTiaoHao() {
		return isXieTiaoHao;
	}
	public void setXieTiaoHao(boolean isXieTiaoHao) {
		this.isXieTiaoHao = isXieTiaoHao;
	}
}
