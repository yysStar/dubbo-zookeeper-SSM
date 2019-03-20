package com.qiyun.support;

import com.qiyun.status.CommonStatus;

/**
 * AbstractAdminExpert entity provides the base persistence definition of the
 * AdminExpert entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractAdminExpert implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private CommonStatus status;
	private String summary;
	private ExpertType expertType;
	private String headPhoto;
	private String account;

	// Constructors

	/** default constructor */
	public AbstractAdminExpert() {
	}

	/** full constructor */
	public AbstractAdminExpert(String name, CommonStatus status, String summary, ExpertType expertType, String headPhoto,String account) {
		this.name = name;
		this.status = status;
		this.summary = summary;
		this.expertType = expertType;
		this.headPhoto = headPhoto;
		this.account=account;
		
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public ExpertType getExpertType() {
		return expertType;
	}

	public void setExpertType(ExpertType expertType) {
		this.expertType = expertType;
	}

	public String getHeadPhoto() {
		return this.headPhoto;
	}

	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}

	public CommonStatus getStatus() {
		return status;
	}

	public void setStatus(CommonStatus status) {
		this.status = status;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


}