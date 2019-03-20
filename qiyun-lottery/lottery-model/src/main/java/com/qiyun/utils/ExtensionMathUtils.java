package com.qiyun.utils;

import com.qiyun.model.CombCallBack;
import com.qiyun.model.ExtensionCombCallBack;

/**
 * 高效的组合算法扩展，支持设胆
 * 
 * @author zkr
 */
public final class ExtensionMathUtils {
	/**
	 * 扩展的组合算法，支持设胆
	 * 
	 * @param needs
	 *            所需要的数目
	 * @param danSize
	 *            胆码的数目
	 * @param unDanSize
	 *            拖码的数目
	 * @param callBack
	 *            回调函数
	 */
	public static void efficientCombExtension(final int needs, final int danSize, final int unDanSize, final ExtensionCombCallBack callBack) {
		efficientCombExtension(needs, danSize, -1, -1, unDanSize, callBack);
	}

	/**
	 * 扩展的组合算法，支持模糊设胆
	 * 
	 * @param needs
	 *            所需要的数目
	 * @param danSize
	 *            胆码的数目
	 * @param danMin
	 *            模糊设胆，胆至少选几个
	 * @param danMax
	 *            模糊设胆，胆至多选几个
	 * @param unDanSize
	 *            拖码的数目
	 * @param callBack
	 *            回调函数
	 */
	public static void efficientCombExtension(final int needs, final int danSize, int danMin, int danMax, final int unDanSize,
			final ExtensionCombCallBack callBack) {
		// 检查模糊设胆，兼容非模糊设胆
		if (danMin < 0)
			danMin = danSize;
		if (danMax < 0 || danMax > danSize)
			danMax = danSize;

		if (unDanSize + danMax >= needs) {
			for (int danNum = danMin; danNum <= danMax; danNum++) {
				final int alsoNeeds = needs - danNum;
				if (unDanSize >= alsoNeeds) {
					// 先从胆码中选择指定的数目
					MathUtils.efficientComb(danSize, danNum, new CombCallBack() {
						public void callback(final boolean[] comb1, final int m1) {
							// 再从拖胆中选取还需要的数目
							MathUtils.efficientComb(unDanSize, alsoNeeds, new CombCallBack() {
								public void callback(final boolean[] comb2, int m2) {
									// 已完整拆了一个组合，调用回调函数进行处理，
									callBack.run(comb1, m1, comb2, m2);
								}
							});
						}

					});
				}
			}
		}
	}
}
