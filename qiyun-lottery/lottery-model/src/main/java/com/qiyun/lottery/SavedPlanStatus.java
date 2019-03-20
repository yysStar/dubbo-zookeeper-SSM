package com.qiyun.lottery;

import com.qiyun.model.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>保存方案状态</p>
 * @author tangfeng
 */
public class SavedPlanStatus extends IntegerBeanLabelItem {
    
	private static final long serialVersionUID = 1L;
    
	public static final SavedPlanStatus ALL = new SavedPlanStatus("全部", -1);
    
	public static final SavedPlanStatus SAVED = new SavedPlanStatus("已保存", 1);
    
	public static final SavedPlanStatus DELETED = new SavedPlanStatus("已删除", 2);
	
	public static final SavedPlanStatus TRADED = new SavedPlanStatus("已购买", 3);
    
	public static List<SavedPlanStatus> list = new ArrayList<SavedPlanStatus>();
	
	protected SavedPlanStatus(String name, int value) {
		super(SavedPlanStatus.class.getName(), name, value);
	}
	
	public static SavedPlanStatus getItem(int value) {
		return (SavedPlanStatus) SavedPlanStatus.getResult(SavedPlanStatus.class.getName(), value);
	}
    
	static {
		list.add(ALL);
		list.add(SAVED);
		list.add(DELETED);
		list.add(TRADED);
	}
}
