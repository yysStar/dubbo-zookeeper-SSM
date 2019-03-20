package com.qiyun.dto;

public class DaiFu {

    private String order_Id; //订单号
    private String bank_Code; //收款银行编号
    private String cnaps; //联行号
    private String bank_Name; //收款银行全称
    private String branch_Bank_Name; //收款银行支行名称
    private String amount; //打款金额
    private String account_Name; //帐户名称
    private String account_Number; //帐户号
    private String account_Type; //账户类型
    private String province; //收款行省份编码
    private String city; //收款行城市编码
    private String fee_Type; //手续费收取方式
    private String payee_Email; //收款人邮箱
    private String urgency; //加急
    private String payee_Mobile; //收款人手机号
    private String leave_Word; //留言
    private String abstractInfo; //摘要
    private String remarksInfo; //备注

    public String getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(String order_Id) {
        this.order_Id = order_Id;
    }

    public String getBank_Code() {
        return bank_Code;
    }

    public void setBank_Code(String bank_Code) {
        this.bank_Code = bank_Code;
    }

    public String getCnaps() {
        return cnaps;
    }

    public void setCnaps(String cnaps) {
        this.cnaps = cnaps;
    }

    public String getBank_Name() {
        return bank_Name;
    }

    public void setBank_Name(String bank_Name) {
        this.bank_Name = bank_Name;
    }

    public String getBranch_Bank_Name() {
        return branch_Bank_Name;
    }

    public void setBranch_Bank_Name(String branch_Bank_Name) {
        this.branch_Bank_Name = branch_Bank_Name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccount_Name() {
        return account_Name;
    }

    public void setAccount_Name(String account_Name) {
        this.account_Name = account_Name;
    }

    public String getAccount_Number() {
        return account_Number;
    }

    public void setAccount_Number(String account_Number) {
        this.account_Number = account_Number;
    }

    public String getAccount_Type() {
        return account_Type;
    }

    public void setAccount_Type(String account_Type) {
        this.account_Type = account_Type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFee_Type() {
        return fee_Type;
    }

    public void setFee_Type(String fee_Type) {
        this.fee_Type = fee_Type;
    }

    public String getPayee_Email() {
        return payee_Email;
    }

    public void setPayee_Email(String payee_Email) {
        this.payee_Email = payee_Email;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getPayee_Mobile() {
        return payee_Mobile;
    }

    public void setPayee_Mobile(String payee_Mobile) {
        this.payee_Mobile = payee_Mobile;
    }

    public String getLeave_Word() {
        return leave_Word;
    }

    public void setLeave_Word(String leave_Word) {
        this.leave_Word = leave_Word;
    }

    public String getAbstractInfo() {
        return abstractInfo;
    }

    public void setAbstractInfo(String abstractInfo) {
        this.abstractInfo = abstractInfo;
    }

    public String getRemarksInfo() {
        return remarksInfo;
    }

    public void setRemarksInfo(String remarksInfo) {
        this.remarksInfo = remarksInfo;
    }
}
