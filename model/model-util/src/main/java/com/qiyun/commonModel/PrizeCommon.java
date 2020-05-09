package com.qiyun.commonModel;


import com.qiyun.tools.DateTools;
import com.qiyun.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class PrizeCommon {

    static public List<PrizeBean> buildToList(int lotteryType, String prizeContent) {
        List<PrizeBean> ret = new ArrayList<PrizeBean>();
        String[] prizePiece = prizeContent.split("\\#");
        for (int i = 0; i < prizePiece.length; i++) {
            if (prizePiece[i].equals("")) {
                continue;
            }
            String[] areas = prizePiece[i].split("\\^");
            PrizeBean bean = new PrizeBean();
            bean.setLotteryType(lotteryType);
            bean.setPrizeName(areas[0]);
            bean.setCount(areas[1]);
            if (areas[2].indexOf("元") != -1) {
                areas[2] = areas[2].substring(0, areas[2].length() - 1);
            }
            bean.setAmount(areas[2]);
            ret.add(bean);
        }
        return ret;
    }

    static public List<PrizeBean> buildToListSfc14(int lotteryType, String prizeContent) {
        List<PrizeBean> ret = new ArrayList<PrizeBean>();
        String[] prizePiece = prizeContent.split("\\#");
        for (int i = 0; i < 3; i++) {
            if (prizePiece[i].equals("")) {
                continue;
            }
            String[] areas = prizePiece[i].split("\\^");
            PrizeBean bean = new PrizeBean();
            bean.setLotteryType(lotteryType);
            bean.setPrizeName(areas[0]);
            if(areas.length > 2){
                bean.setCount(areas[1]);
                if (areas[2].indexOf("元") != -1) {
                    areas[2] = areas[2].substring(0, areas[2].length() - 1);
                }
                bean.setAmount(areas[2]);
            }
            ret.add(bean);
        }
        return ret;
    }

    static public List<PrizeBean> buildToListJq4(int lotteryType, String prizeContent) {
        List<PrizeBean> ret = new ArrayList<PrizeBean>();
        String[] areas = prizeContent.split("\\^");
        PrizeBean bean = new PrizeBean();
        bean.setLotteryType(lotteryType);
        bean.setPrizeName(areas[0]);
        if(areas.length > 2){
            bean.setCount(areas[1]);
            if (areas[2].indexOf("元") != -1) {
                areas[2] = areas[2].substring(0, areas[2].length() - 1);
            }
            bean.setAmount(areas[2]);
        }
        ret.add(bean);
        return ret;
    }

    public static String formatPrizeBeanList(List<PrizeBean> prizeBeanList){
        StringBuffer resultBuffer=new StringBuffer();

        for(PrizeBean bean:prizeBeanList){
            resultBuffer.append("#");
            resultBuffer.append(bean.getPrizeName());
            resultBuffer.append("^");
            resultBuffer.append(bean.getCount());
            resultBuffer.append("^");
            resultBuffer.append(bean.getAmount());
        }
        return resultBuffer.substring(1);
    }

 /*   static public void buildDgspStatistics(List<TotalPrizeBean> prizeBeanList, String fileName) {
        try {
            StringBuffer sbV3 = new StringBuffer();
            if(prizeBeanList==null||prizeBeanList.isEmpty()){
            }else{
                int k=0;
                for (int i = 0; i < prizeBeanList.size(); i++) {
                    TotalPrizeBean prizeBean = (TotalPrizeBean) prizeBeanList.get(i);
                    String account=prizeBean.getAccount();
                    String tempAccount=getSecurityStr(account);
                    prizeBean.setAccount(tempAccount);
                    if (k < 10) {
                        if(!WebConstants.HIDE_ACCOUNTS.contains(account)){
                            sbV3.append("<tr>");
                            sbV3.append("<th >"+prizeBean.getAccount()+"</th>");
                            sbV3.append("<td >").append(prizeBean.getPrize()).append("</td>");
                            sbV3.append("</tr>");
                            k++;
                        }
                    }
                }
            }
            sbV3.append("<tr><th colspan=\"2\">数据最后变化："+DateTools.getNowDateYYYY_MM_DD_HH_MM_SS()+"</th></tr>");
            FileTools.setFileContent(sbV3.toString(), WebConstants.getWebPath() + fileName + ".html");
        } catch (Exception e) {
            LogUtil.error(e);
        }

    }

    public static void buildePrizeStatistics(List<TotalPrizeBean> prizeBeanList, String fileName){

        try {
            SAXBuilder sb = new SAXBuilder();
            Reader reader = new StringReader("<?xml version=\"1.0\" encoding=\"GB2312\" ?><xml></xml>");

            Document returnDoc = sb.build(reader);
            Element rootElement = returnDoc.getRootElement();
            StringBuffer sbu = new StringBuffer();
            StringBuffer sbV3 = new StringBuffer();

            if(prizeBeanList==null||prizeBeanList.isEmpty()){
                sbu.append("<tr></tr>");
                sbV3.append("<tr></tr>");
            }else{
                int k=0;
                for (int i = 0; i < prizeBeanList.size(); i++) {
                    TotalPrizeBean prizeBean = (TotalPrizeBean) prizeBeanList.get(i);
                    String account=prizeBean.getAccount();
                    String tempAccount=getSecurityStr(account);
                    prizeBean.setAccount(tempAccount);
                    Element row = new Element("row");
                    row.setAttribute("account", tempAccount);
                    row.setAttribute("prize", NumberTools.doubleToString(prizeBean.getPrize(),false));
                    rootElement.addContent(row);
                    if (i < 8) {
                        if (i % 2 == 0) {
                            sbu.append("<tr class=\"even\">");
                        } else {
                            sbu.append("<tr>");
                        }
                        sbu.append("<td>").append((i + 1)).append("</td>");
                        sbu.append("<td>").append(prizeBean.getAccount()).append("</td>");
                        sbu.append("<td>").append(NumberTools.doubleToString(prizeBean.getPrize(),false)).append("</td>");
                        sbu.append("</tr>");
                    }
                    if (k < 10) {
                        if(!WebConstants.HIDE_ACCOUNTS.contains(account)){
                            String index = "";
                            if (k == 9) {
                                index = "10";
                            } else {
                                index = String.valueOf((k + 1));
                            }
                            sbV3.append("<tr>");
                            //sbV3.append("<td >").append("<img src=\"/images/nh_num_" + index + ".gif\" />").append("</td>");
                            sbV3.append("<td >").append("<i id=\"rankIco"+ index +"\" class=\"rank_ico\"></i>").append("</td>");
                            sbV3.append("<td >").append(tempAccount).append("</td>");
                            sbV3.append("<td>").append(NumberTools.doubleToString(prizeBean.getPrize(),false)).append("</td>");
                            sbV3.append("</tr>");
                            k++;
                        }
                    }
                }
            }
            XMLOutputter xo = new XMLOutputter();

            Format format = xo.getFormat();
            format.setEncoding("GB2312");
            format.setLineSeparator("");
            xo.setFormat(format);

            String xmlContent = xo.outputString(returnDoc);
            FileTools.setFileContent(xmlContent, WebConstants.getWebPath() + fileName + ".xml");
            FileTools.setFileContent(sbu.toString(), WebConstants.getWebPath() + fileName + ".html");
            FileTools.setFileContent(sbV3.toString(), WebConstants.getWebPath() + fileName + "_v3.html");
        } catch (Exception e) {
            LogUtil.error(e);
        }
    }
    public static void buildePrizeStatistics20(List<TotalPrizeBean> prizeBeanList, String fileName){

        try {
            SAXBuilder sb = new SAXBuilder();
            Reader reader = new StringReader("<?xml version=\"1.0\" encoding=\"GB2312\" ?><xml></xml>");

            Document returnDoc = sb.build(reader);
            Element rootElement = returnDoc.getRootElement();
            StringBuffer sbu = new StringBuffer();
            StringBuffer sbV3 = new StringBuffer();
            StringBuffer phone = new StringBuffer();

            if(prizeBeanList==null||prizeBeanList.isEmpty()){
                sbu.append("<tr></tr>");
                sbV3.append("<tr></tr>");
                phone.append("<tr></tr>");
            }else{
                for (int i = 0; i < prizeBeanList.size(); i++) {
                    TotalPrizeBean prizeBean = (TotalPrizeBean) prizeBeanList.get(i);
                    String account=prizeBean.getAccount();
                    String tempAccount=getSecurityStr(account);
                    prizeBean.setAccount(tempAccount);
                    Element row = new Element("row");
                    row.setAttribute("account", tempAccount);
                    row.setAttribute("prize", NumberTools.doubleToString(prizeBean.getPrize(),false));
                    rootElement.addContent(row);
                    if (i < 8) {
                        if (i % 2 == 0) {
                            sbu.append("<tr class=\"even\">");
                        } else {
                            sbu.append("<tr>");
                        }
                        sbu.append("<td>").append((i + 1)).append("</td>");
                        sbu.append("<td>").append(prizeBean.getAccount()).append("</td>");
                        sbu.append("<td>").append(prizeBean.getPrize()).append("</td>");
                        sbu.append("</tr>");
                    }
                    if (i < 20) {
                        sbV3.append("<tr>");
                        if (i < 5 ) {
                            sbV3.append("<td>").append("<span style=\"color:red;font-weight: bolder;\">"+ (i + 1)+"</span>");
                        } else {
                            sbV3.append("<td>").append("<span style=\"font-weight: bolder;\">"+(i + 1)+"</span>");
                        }
                        sbV3.append("</td>");
                        sbV3.append("<td >").append(tempAccount).append("</td>");
                        sbV3.append("<td>").append(NumberTools.doubleToString(prizeBean.getPrize(),false)).append("</td>");
                        sbV3.append("</tr>");
                    }

                    //手机用户
                    if(i<15){
                        phone.append("<tr>");
                        if(i<3){
                            phone.append("<td>").append("<label class='orange'>"+(i+1)+"</label>");
                        }else{
                            phone.append("<td>").append("<label>"+(i+1)+"</label>");
                        }
                        phone.append("</td>");
                        phone.append("<td>").append(prizeBean.getAccount()).append("</td>");
                        phone.append("<td><b class='money'>").append(NumberTools.doubleToString(prizeBean.getPrize(),false)).append("</b></td>");
                        phone.append("</tr>");
                    }
                }
            }
            *//*页面显示增加最后更新时间*//*
            Date nowDate = new Date();
            phone.append("<tr><td colspan=\"3\"><p style=\"color:#f00;text-align:center;padding:5px 0 0;font-size:12px;\">数据最后变化："+DateTools.dateToString(nowDate, "MM-dd HH:mm")+"</p></td></tr>");

            XMLOutputter xo = new XMLOutputter();

            Format format = xo.getFormat();
            format.setEncoding("GB2312");
            format.setLineSeparator("");
            xo.setFormat(format);

            String xmlContent = xo.outputString(returnDoc);
            FileTools.setFileContent(xmlContent, WebConstants.getWebPath() + fileName + ".xml");
            FileTools.setFileContent(sbu.toString(), WebConstants.getWebPath() + fileName + ".html");
            FileTools.setFileContent(sbV3.toString(), WebConstants.getWebPath() + fileName + "_v3.html");
            FileTools.setFileContent(phone.toString(), WebConstants.getWebPath() + fileName + ".html");
        } catch (Exception e) {
            LogUtil.error(e);
        }
    }

    *//*2013国庆手机购彩优惠活动*//*
    public static void buildNationalDayMobileClientPromRanking(List<TotalPrizeBean> prizeBeanList,String dirPath, String fileName){
        StringBuffer sb = new StringBuffer();
        //建造table
        sb.append("<div class=\"ranking_title\"></div>");
        *//*页面显示增加最后更新时间*//*
        Date nowDate = new Date();
        sb.append("<div class=\"ranking_data\">数据最后变化:"+DateTools.dateToString(nowDate, "MM-dd HH:mm")+"</div>");
        sb.append("<div class=\"ranking_table\">");
        sb.append("<table class=\"table_2\">");
        sb.append("<tr>");
        sb.append("<th>排名</th>");
        sb.append("<th>用户名</th>");
        sb.append("<th>中奖总额</th>");
        sb.append("</tr>");
        for(int i = 0 ; i < prizeBeanList.size() ; i++){
            TotalPrizeBean prizeBean = prizeBeanList.get(i);
            String account=prizeBean.getAccount();
            String tempAccount=getSecurityStr(account);
            sb.append("<tr>");
            sb.append("<td>"+(i+1)+"</td>");
            sb.append("<td>"+tempAccount+"</td>");
            sb.append("<td>￥"+prizeBean.getPrize()+"元</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("</div>");
        try {
            FileTools.setFileContent(sb.toString(), WebConstants.getWebPath() + dirPath + fileName + ".html");
        } catch (Exception e) {
            LogUtil.error(e);
        }
    }

    //中奖风云榜上争当真英雄活动
    public static void buildePrizeRankStatistics(List<TotalPrizeBean> prizeBeanList,int rankType,String fileName){
        try {
            StringBuffer sb = new StringBuffer();
            if(prizeBeanList==null||prizeBeanList.isEmpty()){
                sb.append("<tr></tr>");
            }else{
                //期榜奖金并列情况处理
                int firstCount = 1;
                if(rankType == 0) {
                    //统计第一名的人数
                    for (int i = 1; i < prizeBeanList.size(); i++) {
                        Double prize1 = ((TotalPrizeBean) prizeBeanList.get(0)).getPrize();
                        Double prizeNext = ((TotalPrizeBean) prizeBeanList.get(i)).getPrize();

                        if(prize1.doubleValue() == prizeNext.doubleValue()) {
                            firstCount++;
                        }
                    }
                }

                //显示条数
                int showSize = 10;
                if(rankType == 0 || rankType == 1) {
                    showSize = 5;
                }

                for (int i = 0; i < prizeBeanList.size(); i++) {
                    TotalPrizeBean prizeBean = (TotalPrizeBean) prizeBeanList.get(i);
                    String account=prizeBean.getAccount();
                    String tempAccount=getSecurityStr(account);
                    prizeBean.setAccount(tempAccount);
                    if (i < showSize) {
                        sb.append("<tr>");
                        int orangeStyleCount = 0;
                        if(rankType == 0){
                            orangeStyleCount = 0;
                        }else{
                            orangeStyleCount = 2;
                        }
                        sb.append("<td>");
                        if(i <= orangeStyleCount){
                            sb.append("<label class='orange'>"+(i+1)+"</label>");
                        }else{
                            sb.append("<label>"+(i+1)+"</label>");
                        }
                        sb.append("</td>");
                        String prizeMoney = "";
                        switch (rankType) {
                            case 0://期榜
                                if(i <= (firstCount-1)){
                                    prizeMoney = "<i class=\"get\">￥"+ (10/firstCount) +"元</i>";
                                }
                                break;
                            case 1://日榜
                                if(i <= 2){
                                    if(i == 0){
                                        prizeMoney = "<i class=\"get\">￥88元</i>";
                                    }else if(i == 1){
                                        prizeMoney = "<i class=\"get\">￥58元</i>";
                                    }else if (i == 2){
                                        prizeMoney = "<i class=\"get\">￥28元</i>";
                                    }
                                }
                                break;
                            case 2://周榜
                                if(i == 0){
                                    prizeMoney = "<i class=\"get\">￥800元</i>";
                                }else if(i == 1){
                                    prizeMoney = "<i class=\"get\">￥500元</i>";
                                }else if (i == 2){
                                    prizeMoney = "<i class=\"get\">￥200元</i>";
                                }else {
                                    prizeMoney = "<i class=\"get\">￥100元</i>";
                                }
                                break;
                            case 3://月榜
							*//*if (i == 0) {
								prizeMoney = "<i class=\"get\">￥1680元</i>";
							} else if (i == 1) {
								prizeMoney = "<i class=\"get\">￥1080元</i>";
							} else if (i == 2) {
								prizeMoney = "<i class=\"get\">￥880元</i>";
							}else{
								prizeMoney = "<i class=\"get\">￥100元</i>";
							}*//*
                                break;
                            case 4://总榜
                                if (i == 0) {
                                    prizeMoney = "<i class=\"get\">￥3000元";
                                } else if (i == 1) {
                                    prizeMoney = "<i class=\"get\">￥2000元";
                                } else if (i == 2) {
                                    prizeMoney = "<i class=\"get\">￥1000元";
                                }else {
                                    prizeMoney = "<i class=\"get\">￥500元";
                                }
                                break;
                        }
                        sb.append("<td class=\"b_winner\"><a>"+tempAccount+"</a></td><td><b class='money'>"+prizeBean.getPrize()+"</b></td><td>"+prizeMoney+"</td>");
                        sb.append("</tr>");
                    }
                }
            }
            FileTools.setFileContent(sb.toString(), WebConstants.getWebPath() + fileName + ".html");
        } catch (Exception e) {
            LogUtil.error(e);
        }
    }*/
}

