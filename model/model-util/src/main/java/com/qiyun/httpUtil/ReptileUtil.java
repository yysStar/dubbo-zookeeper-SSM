package com.qiyun.httpUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class ReptileUtil {

    public static String getHtml(String path){
        StringBuffer html = new StringBuffer();//保存整个html文档的数据

        try {
            //1.发起一个url网址的请求
            URL url = new URL(path);
            URLConnection connection = url.openConnection();

            //2.获取网页的数据流
            InputStream input = connection.getInputStream();                 //字节流  一个字节一个字节的读取  中文占用两个字节
            InputStreamReader reader = new InputStreamReader(input,"GBK");   //字符流  一个字符一个字符的读取  可指定字符集编码   ，常用字符集编码：GBK,GB2312,utf-8,ISO-8859-1
            BufferedReader bufferedReader = new BufferedReader(reader);      //字符流  一行一行的读取

            //3.解析并且获取InputStream中具体的数据，并且输出到控制台
            String line = "";
            while((line = bufferedReader.readLine()) != null)
            {
                html.append(line); //将所有读到的每行信息line追加到（拼接到）html对象上
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html.toString();
    }

    public static String parseHtml(String html) {
        // 2.解析html网页内容
        Document document = Jsoup.parse(html);
        // 获取赛事通知列表
        Elements sales = document.getElementsByClass("sales_L");
        Elements salesBox = sales.get(0).getElementsByClass("sales_box");
        String tit = salesBox.get(0).getElementsByClass("sales_tit").get(0).toString();
        String s = tit.substring(tit.indexOf(">") + 1,tit.indexOf("<",2));
        return s;
    }

//    public static void main(String[] args) {
//        String html = getHtml("http://info.sporttery.cn/iframe/lottery_notice.php");
//        Document document = Jsoup.parse(html);
////        Elements nav = document.getElementsByClass("g-nav");
//        Elements sales = document.getElementsByClass("sales_L");
//        Elements salesBox = sales.get(0).getElementsByClass("sales_box");
//        String tit = salesBox.get(0).getElementsByClass("sales_tit").get(0).toString();
//        String s = tit.substring(tit.indexOf(">") + 1,tit.indexOf("<",2));
//        int i = s.indexOf("&nbsp;") + 6;
//        String time = s.substring(i , s.length());
//        System.out.println(time);
//    }
}
