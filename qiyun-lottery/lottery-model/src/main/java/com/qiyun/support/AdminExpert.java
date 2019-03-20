package com.qiyun.support;


import com.qiyun.status.CommonStatus;

/**
 * AdminExpert entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class AdminExpert extends AbstractAdminExpert implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public AdminExpert() {
	}

	/** full constructor */
	public AdminExpert(String name, CommonStatus status, String summary, ExpertType expertType, String headPhoto, String account) {
		super(name, status, summary, expertType, headPhoto,account);
	}

}
