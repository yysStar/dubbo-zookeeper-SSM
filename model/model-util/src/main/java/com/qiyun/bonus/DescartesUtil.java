package com.qiyun.bonus;

import java.util.ArrayList;
import java.util.List;

/**
 * 笛卡尔积工具
 * @author Administrator
 *
 */
public class DescartesUtil {
	public static List<List> cross(List<List> crossArgs) {

	    // 计算出笛卡尔积行数
	    int rows = crossArgs.size() > 0 ? 1 : 0;

	    for (List<Object> data : crossArgs) {
	      rows *= data.size();
	    }

	    // 笛卡尔积索引记录
	    int[] record = new int[crossArgs.size()];

	    List<List> results = new ArrayList<List>();

	    // 产生笛卡尔积
	    for (int i = 0; i < rows; i++) {
	      List<Object> row = new ArrayList<Object>();
	     
	      // 生成笛卡尔积的每组数据
	      for (int index = 0; index < record.length; index++) {
	        row.add(crossArgs.get(index).get(record[index]));
	      }
	     
	      results.add(row);
	      crossRecord(crossArgs, record, crossArgs.size() - 1);
	    }

	    return results;
	  }

	  private static void crossRecord(List<List> sourceArgs, int[] record, int level) {
	    record[level] = record[level] + 1;

	    if (record[level] >= sourceArgs.get(level).size() && level > 0) {
	      record[level] = 0;
	      crossRecord(sourceArgs, record, level - 1);
	    }
	  }
}
