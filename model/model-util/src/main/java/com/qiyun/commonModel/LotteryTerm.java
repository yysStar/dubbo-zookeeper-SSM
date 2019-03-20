package com.qiyun.commonModel;

import com.qiyun.tools.StringTools;
import com.qiyun.util.LogUtil;
import com.qiyun.util.MathUtil;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class LotteryTerm implements java.io.Serializable {

    // Fields
    // 无逻辑id
    private Integer id;
    // 彩种
    private Integer lotteryType;
    // 彩期
    private String term;
    // 外部彩期
    private String outTerm;
    // 开奖时间
    private Date openDateTime;
    // 开始时间
    private Date startDateTime;
    // 结束时间
    private Date endDateTime;
    // 终端截止时间
    private Date terminalEndDateTime;
    // 是否可用
    private Integer isAble;
    // 是否当前期
    private Integer isCurrentTerm;
    // 彩期状态
    private Integer status;
    // 开奖结果
    private String result;
    // 开奖描述 奖级^中奖注数^每注奖金
    private String resultDetail;
    // 奖池
    private String awardPool;
    // 投注额
    private String totalAmount;
    // 试机号
    private String testMachineCode;

    private Integer isBooking;
    // 彩票管家是否可用
    private Integer lotMgrIsAble;

    // Constructors

    /** default constructor */
    public LotteryTerm() {
    }

    /** minimal constructor */
    public LotteryTerm(Integer id, Integer lotteryType, String term, Integer isAble, Integer isCurrentTerm,
                               Integer status) {
        this.id = id;
        this.lotteryType = lotteryType;
        this.term = term;
        this.isAble = isAble;
        this.isCurrentTerm = isCurrentTerm;
        this.status = status;
    }

    /** full constructor */
    public LotteryTerm(Integer id, Integer lotteryType, String term, Date openDateTime, Date startDateTime, Date endDateTime,
                               Date terminalEndDateTime, Integer isAble, Integer isCurrentTerm, Integer status, String result, String resultDetail,
                               String awardPool,String testMachineCode) {
        this.id = id;
        this.lotteryType = lotteryType;
        this.term = term;
        this.openDateTime = openDateTime;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.terminalEndDateTime = terminalEndDateTime;
        this.isAble = isAble;
        this.isCurrentTerm = isCurrentTerm;
        this.status = status;
        this.result = result;
        this.resultDetail = resultDetail;
        this.awardPool = awardPool;
        this.testMachineCode = testMachineCode;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLotteryType() {
        return this.lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getTerm() {
        return this.term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Date getOpenDateTime() {
        return this.openDateTime;
    }

    public void setOpenDateTime(Date openDateTime) {
        this.openDateTime = openDateTime;
    }

    public Date getStartDateTime() {
        return this.startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return this.endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Date getTerminalEndDateTime() {
        return this.terminalEndDateTime;
    }

    public void setTerminalEndDateTime(Date terminalEndDateTime) {
        this.terminalEndDateTime = terminalEndDateTime;
    }

    public Integer getIsAble() {
        return this.isAble;
    }

    public void setIsAble(Integer isAble) {
        this.isAble = isAble;
    }

    public Integer getIsCurrentTerm() {
        return this.isCurrentTerm;
    }

    public void setIsCurrentTerm(Integer isCurrentTerm) {
        this.isCurrentTerm = isCurrentTerm;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultDetail() {
        return this.resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }

    public String getAwardPool() {
        return this.awardPool;
    }

    public void setAwardPool(String awardPool) {
        this.awardPool = awardPool;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOutTerm() {
        return outTerm;
    }

    public void setOutTerm(String outTerm) {
        this.outTerm = outTerm;
    }

    public Integer getIsBooking() {
        return isBooking;
    }

    public void setIsBooking(Integer isBooking) {
        this.isBooking = isBooking;
    }

    public String getTestMachineCode() {
        return testMachineCode;
    }

    public void setTestMachineCode(String testMachineCode) {
        this.testMachineCode = testMachineCode;
    }

    public Integer getLotMgrIsAble() {
        return lotMgrIsAble;
    }

    public void setLotMgrIsAble(Integer lotMgrIsAble) {
        this.lotMgrIsAble = lotMgrIsAble;
    }

    private static final long serialVersionUID = 1L;
    public final static String POKER_TH="同花";
    public final static String POKER_THS="同花顺";
    public final static String POKER_SZ="顺子";
    public final static String POKER_BZ="豹子";
    public final static String POKER_DZ="对子";
    public final static String POKER_SBT="";//取消三不同形态

    // Constructors
    private Date hmEndDateTime; // 做为单式的截止时间

    private String codeShape = "";// 号码形态
    private String codeSum = "";// 号码和值


    /** default constructor */


    /** minimal constructor */


    public List<PrizeBean> getPrizeBeanList() {
        String results = this.getResultDetail();
        if (results == null || "".equals(results)) {
            return new ArrayList();
        }
        List<PrizeBean> prizeBeanList = PrizeCommon.buildToList(getLotteryType(), results);
        return prizeBeanList ;
    }

    public void setPrizeBeanList(List<PrizeBean> prizeBeanList) {
        String prizeText = PrizeCommon.formatPrizeBeanList(prizeBeanList);
        this.setResultDetail(prizeText);
    }

    public List getNewPrizeBeanList() {
        String results = this.getResultDetail();
        if (results == null || "".equals(results)) {
            return new ArrayList();
        }
        List<PrizeBean> ret = new ArrayList<PrizeBean>();
        String[] prizePiece = results.split("\\#");
        for (int i = 0; i < prizePiece.length; i++) {
            if (prizePiece[i].equals("")) {
                continue;
            }
            String[] areas = prizePiece[i].split("\\^");
            PrizeBean bean = new PrizeBean();
            bean.setLotteryType(getLotteryType());
            bean.setPrizeName(PrizeListDef.get(getLotteryType()).get(areas[0]));
            bean.setCount(areas[1]);
            bean.setAmount(areas[2]);
            ret.add(bean);
        }
        return ret;
    }

    public List<String> getPrizeList() {
        List<String> result = null;
        String totalContent = getResultDetail();
        String[] strTotalContent = totalContent.split("#");
        for (String temp : strTotalContent) {
            result.add(temp.split("\\^")[2]);
        }
        return result;
    }

    public List<String> getPrizeCountList() {
        List<String> result = null;
        String totalContent = getResultDetail();
        String[] strTotalContent = totalContent.split("#");
        for (String temp : strTotalContent) {
            String[] tempArr = temp.split("\\^");
            result.add(tempArr[1] + "注、每注奖金" + tempArr[2]);
        }
        return result;
    }

    public void setHmEndDateTime(Date time) {
        this.hmEndDateTime = time;
    }

    public Date getHmEndDateTime() {
        if (this.hmEndDateTime == null)
            return new Date(getEndDateTime().getTime() - 15 * 60 * 1000);
        else
            return this.hmEndDateTime;
    }

    public String[] getResults() {
        return getResult().split(",");
    }

    //格式化开奖结果供走势图调用
    public String getZstUseResult() {
        String result = getResult();
        if(getLotteryType() != null && getLotteryType() == LotteryType.SSQ.getValue()) {
            result = StringTools.isNullOrBlank(result) == true ? "" : result.substring(0,20);
        }
        return result;
    }

    //格式化开奖结果供走势图调用
    public String[] getZstUseResults() {
        return getZstUseResult().split(",");
    }

    public String[] getZstTestMachineCodeArr(){
        String result = this.getZstTestMachineCode();
        return result.split(",");
    }

    public String getZstTestMachineCode(){
        String result = this.getTestMachineCode();
        result = result.replaceAll("", ",");
        result = result.substring(1,result.length()-1);
        return result;
    }

    /*public Element termToXMLElement() {
        Element ele = new Element("lotteryTerm");

        Element termEle = new Element("term");
        termEle.setText(this.getTerm());
        ele.addContent(termEle);

        Element isCurrentTerm = new Element("isCurrentTerm");
        if (this.getIsCurrentTerm().getValue() == CommonStatus.YES.getValue()) {
            isCurrentTerm.setText("true");
        } else {
            isCurrentTerm.setText("false");
        }
        ele.addContent(isCurrentTerm);

        Element isAble = new Element("isAble");
        if (this.getIsAble().getValue() == CommonStatus.YES.getValue()) {
            isAble.setText("true");
        } else {
            isAble.setText("false");
        }
        ele.addContent(isAble);

        Element status = new Element("status");
        status.setText(getStatus().getValue() + "");
        ele.addContent(status);

        Element openDate = new Element("openDate");
        openDate.setText(DateTools.dateToString(getOpenDateTime(), "yyyy-MM-dd HH:mm"));
        ele.addContent(openDate);

        Element endDate = new Element("endDate");
        endDate.setText(DateTools.dateToString(getEndDateTime(), "yyyy-MM-dd HH:mm"));
        ele.addContent(endDate);

        return ele;

    }*/

    public String getCodeShape() {
        try {
            if (getLotteryType() == LotteryType.K3.getValue() ||
                    getLotteryType() == LotteryType.JL_K3.getValue() ||
                    getLotteryType() == LotteryType.HB_K3.getValue() ||
                    getLotteryType() == LotteryType.AH_K3.getValue() ||
                    getLotteryType() == LotteryType.JX_K3.getValue() ||
                    getLotteryType() == LotteryType.HB_K3.getValue()) {// 暂快3有号码形态
                if (getResult() != null && getResult().length() > 0) {
                    List<String> openResult = Arrays.asList(getResult().split(","));
                    Set<String> openResultSet = new HashSet<String>(openResult);
                    if (openResultSet.size() == 1) {
                        this.codeShape = "三同号";
                    } else if (openResultSet.size() == 2) {
                        this.codeShape = "二同号";
                    } else if (openResultSet.size() == 3) {
                        this.codeShape = "三不同";
                    }
                }
            } else if (getLotteryType().equals(LotteryType.POKER3)) {
                this.codeShape = getShape(getResult());
            } else if (getLotteryType().equals(LotteryType.FC3D) || getLotteryType().equals(LotteryType.PL3)){
                if (getResult() != null && getResult().length() > 0) {
                    List<String> openResult = Arrays.asList(getResult().split(","));
                    Set<String> openResultSet = new HashSet<String>(openResult);
                    if (openResultSet.size() < 3) {
                        this.codeShape = "组选3";
                    } else {
                        this.codeShape = "组选6";
                    }
                }
            } else{
                this.codeShape = "";
            }
        } catch (Exception e) {
            LogUtil.error(e);
        }
        return this.codeShape;
    }

    public String getCodeSum() {
        try {
            if (getResult() != null && getResult().length() > 0) {
                this.codeSum = MathUtil.getArraySum(getResults()) + "";
            } else {
                this.codeSum = "";
            }
        } catch (Exception e) {
            LogUtil.error(e);
        }
        return this.codeSum;
    }

    public String getResultShape() {
        if (getLotteryType() == LotteryType.POKER3.getValue()) {
            if (StringUtils.isEmpty(getResult())) {
                return getResult();
            }
            String[] codes = getResult().split(",");
            Map<String, Integer> colorMap = new HashMap<String, Integer>();// 花色集合
            Map<Integer, Integer> pokerMap = new HashMap<Integer, Integer>();// 点数出现次数集合
            int[] pokerArr = new int[3];
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < codes.length; i++) {
                String code = codes[i];
                String color = code.substring(0, 1);
                Integer poker = Integer.parseInt(code.substring(1));
                colorMap.put(color, poker);
                if (pokerMap.containsKey(poker)) {
                    int num = pokerMap.get(poker) + 1;
                    pokerMap.put(poker, num);
                } else {
                    pokerMap.put(poker, 1);
                }
                pokerArr[i] = poker;
                String className = "";
                if (color.equals("1")) {
                    className = "spades";
                } else if (color.equals("2")) {
                    className = "hearts";
                } else if (color.equals("3")) {
                    className = "clubs";
                } else if (color.equals("4")) {
                    className = "diamonds";
                }
                String pokerStr = "";
                switch (poker) {
                    case 1:
                        pokerStr = "A";
                        break;
                    case 11:
                        pokerStr = "J";
                        break;
                    case 12:
                        pokerStr = "Q";
                        break;
                    case 13:
                        pokerStr = "K";
                        break;
                    default:
                        pokerStr = poker + "";

                }
                pokerStr = pokerStr.replace("1;", "A").replace("11;", "J").replace("12;", "Q").replace("13;", "K").replace(";", "");
                sb.append("<span class=\"" + className + "\"><i></i><b>" + pokerStr + "</b></span>");
            }
            return sb.toString();
        } else if(getLotteryType()==LotteryType.SSQ.getValue()){
            String result=getResult();
            if(!StringTools.isNullOrBlank(result)){
                String[] arr=result.split(",");
                StringBuilder red=new StringBuilder("");
                StringBuilder blue=new StringBuilder("");

                for (int j = 0; j < arr.length; j++) {
                    if(j<6){
                        red.append(","+arr[j]);
                    }else{
                        blue.append(","+arr[j]);
                    }
                }
                red.delete(0, 1);
                blue.delete(0, 1);
                red.append("|").append(blue.toString());
                result=red.toString();
            }
            return result;
        }else if(getLotteryType()==LotteryType.DLT.getValue()){
            String result=getResult();
            if(!StringTools.isNullOrBlank(result)){
                String[] arr=result.split(",");
                StringBuilder red=new StringBuilder("");
                StringBuilder blue=new StringBuilder("");

                for (int j = 0; j < arr.length; j++) {
                    if(j<5){
                        red.append(","+arr[j]);
                    }else{
                        blue.append(","+arr[j]);
                    }
                }
                red.delete(0, 1);
                blue.delete(0, 1);
                red.append("|").append(blue.toString());
                result=red.toString();
            }
            return result;
        }

        else {
            return getResult();
        }
    }

    public int getOpenNumSUM(){
        if(StringTools.isNullOrBlank(this.getResult())){
            return 0;
        }
        int sum = 0;
        for(String num:this.getResults()){
            sum += Integer.valueOf(num);
        }
        return sum;
    }

    public static String getShape(String result) {
        if (StringUtils.isEmpty(result)) {
            return "";
        }
        String[] codes = result.split(",");
        Map<String, Integer> colorMap = new HashMap<String, Integer>();// 花色集合
        Map<Integer, Integer> pokerMap = new HashMap<Integer, Integer>();// 点数出现次数集合
        int[] pokerArr = new int[3];
        for (int i = 0; i < codes.length; i++) {
            String code = codes[i];
            String color = code.substring(0, 1);
            Integer poker = Integer.parseInt(code.substring(1));
            colorMap.put(color, poker);
            if (pokerMap.containsKey(poker)) {
                int num = pokerMap.get(poker) + 1;
                pokerMap.put(poker, num);
            } else {
                pokerMap.put(poker, 1);
            }
            pokerArr[i] = poker;
        }
        // 计算是什么玩法 同花/同花顺/顺子/对子/豹子/
        boolean isTH = false;// 同花
        boolean isSZ = true;// 顺子
        boolean isDZ = false;// 对子
        boolean isBZ = false;// 豹子
        if (colorMap.size() == 1) {
            isTH = true;
        }
        if (pokerMap.size() == 1) {
            isBZ = true;
        }
        if (pokerMap.size() == 2) {
            isDZ = true;
        }
        Arrays.sort(pokerArr);// 从小到大排列 计算是否顺子
        if (pokerArr[0] == 1 && pokerArr[1] == 12 && pokerArr[2] == 13) {// QKA也是顺子
            isSZ = true;
        } else {
            for (int i = 1; i < pokerArr.length; i++) {
                if (pokerArr[i] - pokerArr[i - 1] != 1) {// 不是顺子
                    isSZ = false;
                    break;
                }
            }
        }
        String shape ="";
        if (isTH && !isSZ) {
            shape =POKER_TH;
        } else if (isTH && isSZ) {
            shape = POKER_THS;
        } else if (!isTH && isSZ) {
            shape = POKER_SZ;
        } else if (isDZ) {
            shape = POKER_DZ;
        } else if (isBZ) {
            shape = POKER_BZ;
        } else {
            shape = POKER_SBT;
        }
        return shape;
    }

    public boolean termIsClose(TradeType tradeType){
        if(this.getIsAble() == 1 && tradeType == TradeType.TRADE_BALANCE){
            return true;
        }else if(this.getLotMgrIsAble() == 1 && tradeType == TradeType.SCORE_BET){
            return true;
        }
        return false;
    }

}
