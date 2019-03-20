package com.qiyun.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExportExcle {

    public static Map exportExcle(List<Map> list, String titleName, HttpServletResponse response)throws Exception {
        Map<String,Object> map = list.get(0);
        HSSFWorkbook wb =  new HSSFWorkbook();
        //创建一个sheet
        HSSFSheet sheet = wb.createSheet("表格");
        HSSFRow row = sheet.createRow(0);
        row.setHeightInPoints(50);// 设备标题的高度
        // 第三步创建标题的单元格样式style2以及字体样式headerFont1
        HSSFCellStyle style2 = wb.createCellStyle();
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style2.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        HSSFFont headerFont1 = (HSSFFont) wb.createFont(); // 创建字体样式
        headerFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
        headerFont1.setFontName("宋体"); // 设置字体类型
        headerFont1.setFontHeightInPoints((short) 20); // 设置字体大小
        style2.setFont(headerFont1); // 为标题样式设置字体样式

        HSSFCell cell1 = row.createCell(0);// 创建标题第一列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,
                map.size() - 1)); // 合并列标题
        cell1.setCellValue(titleName); // 设置值标题
        cell1.setCellStyle(style2); // 设置标题样式

          //创建第一行
        HSSFRow row1 = sheet.createRow(1);
        row1.setHeightInPoints(37);// 设置表头高度

        // 第四步，创建表头单元格样式 以及表头的字体样式
        HSSFCellStyle style = wb.createCellStyle();

        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式

        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);

        HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
        headerFont.setFontName("黑体"); // 设置字体类型
        headerFont.setFontHeightInPoints((short) 10); // 设置字体大小
        style.setFont(headerFont); // 为标题样式设置字体样式
        //设置 表头

        itre(row1, map,style);
        //设置表数据
     for (int i = 0;i<list.size();i++){
         HSSFCellStyle style1 = style(wb);
         row = sheet.createRow( i + 2);
         row.setHeightInPoints(25);
            Map<String,Object> maps = list.get(i);
         Iterator it = maps.entrySet().iterator();
         int i1 = 0;
         while (it.hasNext()) {
             HSSFCell cell = row.createCell(i1);
             Map.Entry en = (Map.Entry) it.next();
             cell.setCellValue(en.getValue().toString());
             cell.setCellStyle(style1);
             i1++;
         }
        }
        sheet.autoSizeColumn((short)2,true); //调整第二列宽度
        String filename = titleName + ".xls";
        response.setContentType("application/ms-excel;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="
                .concat(String.valueOf(URLEncoder.encode(filename, "UTF-8"))));
        OutputStream out = response.getOutputStream();
        try {
            wb.write(out);// 将数据写出去
            String str = "导出" + titleName + "成功！";
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
            String str1 = "导出" + titleName + "失败！";
            System.out.println(str1);
        } finally {
            out.close();
        }
        return null;
    }

    private static HSSFCellStyle style(HSSFWorkbook wb) {
        HSSFCellStyle zidonghuanhang = wb.createCellStyle();
      /*  zidonghuanhang.setWrapText(true);// 设置自动换行*/
        zidonghuanhang
                .setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式

        // 设置边框
        zidonghuanhang.setBottomBorderColor(HSSFColor.BLACK.index);
        zidonghuanhang.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        zidonghuanhang.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        zidonghuanhang.setBorderRight(HSSFCellStyle.BORDER_THIN);
        zidonghuanhang.setBorderTop(HSSFCellStyle.BORDER_THIN);

        // 为数据内容设置特点新单元格样式2 自动换行 上下居中左右也居中

        zidonghuanhang
                .setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个上下居中格式
        zidonghuanhang.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中

        // 设置边框
        zidonghuanhang.setBottomBorderColor(HSSFColor.BLACK.index);
        zidonghuanhang.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        zidonghuanhang.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        zidonghuanhang.setBorderRight(HSSFCellStyle.BORDER_THIN);
        zidonghuanhang.setBorderTop(HSSFCellStyle.BORDER_THIN);
        return  zidonghuanhang;
    }

    private static void itre(HSSFRow row1, Map<String, Object> map, HSSFCellStyle style) {
        Iterator it = map.entrySet().iterator();
        int i1 = 0;
        while (it.hasNext()) {
        HSSFCell cell = row1.createCell(i1);
            Map.Entry en = (Map.Entry) it.next();
        cell.setCellValue(en.getKey().toString());
            cell.setCellStyle(style);
        i1++;
    }
    }
}
