package com.qiyun.error;

import com.qiyun.commonModel.ErrorStatus;
import com.qiyun.commonModel.ErrorType;
import com.qiyun.model.AbstractSystemError;
import com.qiyun.model.ErrorGrade;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 系统错误实体类.
 * 
 * @author sxh 
 * @date   2011-11-30
 */
public class SystemError extends AbstractSystemError implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	/** default constructor */
	public SystemError() {
	}
	
	/** full constructor */
	public SystemError(Integer id, ErrorType type, ErrorGrade grade, String content, ErrorStatus status,
					   Date createDateTime, String createBy, Date updateDateTime, String updateBy, String remark) {
		super(id, type, grade, content, status, createDateTime, createBy, updateDateTime, updateBy, remark);
	}
	public Collection<ErrorRemark> getRemarkList(){
		if(this.getRemark()!=null&&!"".equals(this.getRemark())){
			return JSONArray.toCollection(JSONArray.fromObject(this.getRemark()),ErrorRemark.class);
		}
		return new ArrayList<ErrorRemark>();
	}
	
}
