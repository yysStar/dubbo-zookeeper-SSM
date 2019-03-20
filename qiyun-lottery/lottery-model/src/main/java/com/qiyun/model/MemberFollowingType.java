package com.qiyun.model;

/**
 * 
 * @author liuxd
 *定制方案类型
 */
public class MemberFollowingType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = -1410849485815957495L;

	protected MemberFollowingType(String name, int value) {
		super(MemberFollowingType.class.getName(), name, value);
	}

	public static MemberFollowingType getItem(int value) {
		try {
			return (MemberFollowingType) MemberFollowingType.getResult(MemberFollowingType.class.getName(), value);
		}catch(Exception e){
			return null;
		}
	}
	
	public static final MemberFollowingType NONE = new MemberFollowingType("非自动跟单", 0);
	
	public static final MemberFollowingType TAOCAN = new MemberFollowingType("套餐", 1);

	public static final MemberFollowingType HEMAI = new MemberFollowingType("合买", 2);
	
	public static final MemberFollowingType EXPERT_TIPS = new MemberFollowingType("名家内幕", 11);
	
	public static final MemberFollowingType DGPEI = new MemberFollowingType("单关配",4);
	
	public static final MemberFollowingType SELECTX=new MemberFollowingType("双选",5);
	
	public static final MemberFollowingType JJYH = new MemberFollowingType("奖金优化",7);
	
	public static final MemberFollowingType SHARE = new MemberFollowingType("分享活动",9);

	public static final MemberFollowingType GENDAN = new MemberFollowingType("跟单",10);
}
