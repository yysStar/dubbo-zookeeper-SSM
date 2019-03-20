package com.qiyun.model;

import java.util.List;

import com.qiyun.tools.StringTools;
import com.qiyun.util.LogUtil;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.HashAdapter;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModelException;

/**
 * FreeMarker 静态方法处理类(为了方便页面处理 减少页面的逻辑运算)
 * 页面调用方式<#if tools.isXieHao(blueResultMiss.rows,termNoItem_index,mykey)> ball02<#else>ball04</#if>
 * @author WangBin
 * @since 2016-5-5
 */
public class FreeMarkerStaticMethodTools {
	
	/**
	 * 判断第一行当前号码是否为斜号
	 * @param list
	 * @param index
	 * @param key
	 * @return
	 */
	public static boolean isXieHao(List<HashAdapter> list, int index, String key) {
		if (list != null) {
			HashAdapter nowrow = (HashAdapter)list.get(index);
			HashAdapter afterRow = (HashAdapter)list.get(index+1);

			MissDataCell nowCell = (MissDataCell) nowrow.get(key);
			int cellBeferKeyInt = Integer.valueOf(key) - 1;
			int cellAfterKeyInt = Integer.valueOf(key) + 1;
			String cellBeferKey = StringTools.appendStr(cellBeferKeyInt + "","0", true, 1);
			String cellAfterKey = StringTools.appendStr(cellAfterKeyInt + "","0", true, 1);
			MissDataCell beferCell = afterRow.containsKey(cellBeferKey) ? (MissDataCell)afterRow.get(cellBeferKey) : null;
			MissDataCell afterCell = afterRow.containsKey(cellAfterKey) ? (MissDataCell)afterRow.get(cellAfterKey) : null;
			if (nowCell.isXieHao() && ((beferCell != null && beferCell.isXieHao()) || (afterCell != null && afterCell.isXieHao()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断第一行,第二行当前号码是否为斜跳号
	 * @param list
	 * @param index
	 * @param key
	 * @return
	 */
	public static boolean isXieTiaoHao(List<HashAdapter> list, int index, String key) {
		if (list != null) {
			HashAdapter nowrow = (HashAdapter)list.get(index);
			HashAdapter afterRow = (HashAdapter)list.get(index+2);
			MissDataCell nowCell = (MissDataCell) nowrow.get(key);
			int cellBeferKeyInt = Integer.valueOf(key) - 2;
			int cellAfterKeyInt = Integer.valueOf(key) + 2;
			String cellBeferKey = StringTools.appendStr(cellBeferKeyInt + "","0", true, 1);
			String cellAfterKey = StringTools.appendStr(cellAfterKeyInt + "","0", true, 1);
			MissDataCell beferCell = afterRow.containsKey(cellBeferKey) ? (MissDataCell)afterRow.get(cellBeferKey) : null;
			MissDataCell afterCell = afterRow.containsKey(cellAfterKey) ? (MissDataCell)afterRow.get(cellAfterKey) : null;
			if (nowCell.isXieTiaoHao() && ((beferCell != null && beferCell.isXieTiaoHao()) || (afterCell != null && afterCell.isXieTiaoHao()))) {
				return true;
			}
		}
		return false;
	}
	
	public static TemplateHashModel initStaticMethod() {
		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
		TemplateHashModel staticModels = wrapper.getStaticModels();
		TemplateHashModel temp = null;
		try {
			temp = (TemplateHashModel) staticModels.get("com.cailele.lottery.tools.FreeMarkerStaticMethodTools");
		} catch (TemplateModelException e) {
			LogUtil.error(e);
		}
		return temp;
	}
}
