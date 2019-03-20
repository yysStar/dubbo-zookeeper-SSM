package com.qiyun.jimi;

import com.qiyun.util.MD5;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {
        DecimalFormat decimalFormat = new DecimalFormat("000.0");
        String format = decimalFormat.format(1);
        System.out.println(format);
    }




}
