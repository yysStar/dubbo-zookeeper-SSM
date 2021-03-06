package com.qiyun.grabber;

import java.util.Date;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.status.ChaseTermStatus;
import net.sf.json.JSONObject;
import static com.qiyun.model.PlatformConstant.*;

/**
 * AbstractLotteryChaseTerm generated by MyEclipse Persistence Tools
 */
public abstract class AbstractLotteryChaseTerm implements java.io.Serializable {

	// Fields
	// 追号流水编号
	private Integer id;
	// 追号编号
	private Integer chaseNo;
	// 彩种
	private LotteryType lotteryType;
	// 彩期
	private String term;
	// 追号流水的状态
	private ChaseTermStatus status;
	// 倍数
	private Integer multiple;
	// 金额
	private Integer amount;
	// 方案编号
	private Integer planNo;
	//撤销类型
	private ChaseTermCancelType cancelType;//1.系统撤销  2.客服撤销 3.用户撤销
	//撤销时间
	private Date cancelDateTime;

	private LotteryChase chase;
	
	public JSONObject getJsonObject(){
		JSONObject obj = new JSONObject();
		obj.put(CHASE_NO, chaseNo);
		obj.put(LOTTERY_TYPE, lotteryType.getValue());
		obj.put(TERM, term);
		obj.put(CHASE_TERM_STATUS, status.getValue());
		obj.put(CHASE_TERM_STATUS_NAME, status.getName());
		obj.put(CHASE_STATUS, chase.getStatus().getValue());
		obj.put(CHASE_STATUS_NAME, chase.getStatus().getName());
		obj.put(MULTIPLE, multiple);
		obj.put(AMOUNT, amount);
		obj.put(PLAN_NO, planNo == null?0:planNo);
		return obj;
	}
	// Constructors

	/** default constructor */
	public AbstractLotteryChaseTerm() {
	}

	/** minimal constructor */
	public AbstractLotteryChaseTerm(Integer chaseNo, LotteryType lotteryType, String term, ChaseTermStatus status, Integer multiple, Integer amount) {
		this.chaseNo = chaseNo;
		this.lotteryType = lotteryType;
		this.term = term;
		this.status = status;
		this.multiple = multiple;
		this.amount = amount;
	}

	/** full constructor */
	public AbstractLotteryChaseTerm(Integer chaseNo, LotteryType lotteryType, String term, ChaseTermStatus status, Integer multiple, Integer amount,
			Integer planNo) {
		this.chaseNo = chaseNo;
		this.lotteryType = lotteryType;
		this.term = term;
		this.status = status;
		this.multiple = multiple;
		this.amount = amount;
		this.planNo = planNo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChaseNo() {
		return this.chaseNo;
	}

	public void setChaseNo(Integer chaseNo) {
		this.chaseNo = chaseNo;
	}

	public LotteryType getLotteryType() {
		return this.lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public ChaseTermStatus getStatus() {
		return this.status;
	}

	public void setStatus(ChaseTermStatus status) {
		this.status = status;
	}

	public Integer getMultiple() {
		return this.multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPlanNo() {
		return this.planNo;
	}

	public void setPlanNo(Integer planNo) {
		this.planNo = planNo;
	}

	public LotteryChase getChase() {
		return chase;
	}

	public void setChase(LotteryChase chase) {
		this.chase = chase;
	}

	public ChaseTermCancelType getCancelType() {
		return cancelType;
	}

	public void setCancelType(ChaseTermCancelType cancelType) {
		this.cancelType = cancelType;
	}

	public Date getCancelDateTime() {
		return cancelDateTime;
	}

	public void setCancelDateTime(Date cancelDateTime) {
		this.cancelDateTime = cancelDateTime;
	}

}