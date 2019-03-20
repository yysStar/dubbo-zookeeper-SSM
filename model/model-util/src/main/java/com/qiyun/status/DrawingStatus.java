package com.qiyun.status;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class DrawingStatus extends IntegerBeanLabelItem {
    private static final long serialVersionUID = 1L;

    protected DrawingStatus(String name, int value) {
        super(DrawingStatus.class.getName(), name, value);
    }

    public static DrawingStatus getItem(int value) {
        return (DrawingStatus) DrawingStatus.getResult(DrawingStatus.class.getName(), value);
    }

    public static final DrawingStatus ALL = new DrawingStatus("全部", -1);

    /**
     * 用于会员中心提款记录查询条件
     */
    public static final DrawingStatus WAIT_ALL = new DrawingStatus("待审核", -2);

    /**
     * 用于会员中心提款记录查询条件
     */
    public static final DrawingStatus WAIT_FAILURE = new DrawingStatus("审核驳回", -3);

    /**
     * 用于O2O提款记录查询条件
     */
    public static final DrawingStatus ALL_FAILURE = new DrawingStatus("所有失败记录", -4);
    /**
     * 用于O2O提款记录查询条件
     */
    public static final DrawingStatus ALL_DRAWING = new DrawingStatus("所有进行中", -5);

    public static final DrawingStatus WAIT = new DrawingStatus("客服待审核", 1);
    public static final DrawingStatus FAILURE = new DrawingStatus("客服驳回", 2);
    public static final DrawingStatus WAIT_FINANCE = new DrawingStatus("财务待审核", 7);
    public static final DrawingStatus FAILURE_FINANCE = new DrawingStatus("财务驳回", 8);
    public static final DrawingStatus CHECKED = new DrawingStatus("待汇款", 3);
    public static final DrawingStatus CHECKED_FAILURE = new DrawingStatus("汇款驳回", 5);
    public static final DrawingStatus SUCCESS = new DrawingStatus("已汇出", 0);
    public static final DrawingStatus BANKRETURN = new DrawingStatus("银行退单", 4);
    public static final DrawingStatus SUCCESS_OVER = new DrawingStatus("已到帐", 6);

    public static final List<DrawingStatus> list = new ArrayList<DrawingStatus>();

    /**
     * 待审核list
     */
    public static final List<DrawingStatus> waitList = new ArrayList<DrawingStatus>();

    /**
     * 所有失败记录
     */
    public static final List<DrawingStatus> allFailureList = new ArrayList<DrawingStatus>();
    /**
     * 所有进行中的记录
     */
    public static final List<DrawingStatus> allDrawingList = new ArrayList<DrawingStatus>();

    /**
     * 审核驳回list
     */
    public static final List<DrawingStatus> waitFailureList = new ArrayList<DrawingStatus>();

    static {
        list.add(ALL);
        list.add(WAIT);
        list.add(FAILURE);
        list.add(WAIT_FINANCE);
        list.add(FAILURE_FINANCE);
        list.add(CHECKED);
        list.add(CHECKED_FAILURE);
        list.add(SUCCESS);
        list.add(BANKRETURN);
        list.add(SUCCESS_OVER);

        waitList.add(WAIT);
        waitList.add(WAIT_FINANCE);

        waitFailureList.add(FAILURE);
        waitFailureList.add(FAILURE_FINANCE);

        allFailureList.add(FAILURE);
        allFailureList.add(FAILURE_FINANCE);
        allFailureList.add(CHECKED_FAILURE);
        allFailureList.add(BANKRETURN);

        allDrawingList.add(WAIT);
        allDrawingList.add(WAIT_FINANCE);
        allDrawingList.add(CHECKED);
        allDrawingList.add(SUCCESS);
    }
}
