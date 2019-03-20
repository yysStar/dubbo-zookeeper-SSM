package com.qiyun.model;

import java.util.Date;

import com.qiyun.commonModel.ErrorStatus;
import com.qiyun.commonModel.ErrorType;
import com.qiyun.commonModel.LotteryType;



/**
 * 系统错误抽象实体类.
 * 
 * @author sxh
 * @date 2011-11-30
 */
public class AbstractSystemError {

	// 流水编号
	private Integer id;
	
	// 错误类别
	private ErrorType type;
	
	// 彩种
	private LotteryType lotteryType;
	
	// 比对关键字(产生新记录时通过此关键字进行比对。按策略进行判断是否需要插入数据库)
	private String keyWords;
	
	// 错误等级
	private ErrorGrade grade;

	// 错误内容
	private String content;

	// 错误状态
	private ErrorStatus status;

	// 创建时间
	private Date createDateTime;

	// 创建人
	private String createBy;

	// 更新时间
	private Date updateDateTime;

	// 更新人
	private String updateBy;

	// 备注
	private String remark;
	
	//逻辑变量 ， 查找重复记录时限定的时段 分钟
	private int interval;

	/** default constructor */
	public AbstractSystemError() {
	}

	/** full constructor */
	public AbstractSystemError(Integer id, ErrorType type, ErrorGrade grade, String content, ErrorStatus status, Date createDateTime,
			String createBy, Date updateDateTime, String updateBy, String remark) {
		this.id = id;
		this.type = type;
		this.grade = grade;
		this.content = content;
		this.status = status;
		this.createDateTime = createDateTime;
		this.createBy = createBy;
		this.updateDateTime = updateDateTime;
		this.updateBy = updateBy;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ErrorType getType() {
		return type;
	}

	public void setType(ErrorType type) {
		this.type = type;
	}
	public ErrorGrade getGrade() {
		return grade;
	}

	public void setGrade(ErrorGrade grade) {
		this.grade = grade;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ErrorStatus getStatus() {
		return status;
	}

	public void setStatus(ErrorStatus status) {
		this.status = status;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

}
