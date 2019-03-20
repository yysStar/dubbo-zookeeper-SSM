package com.qiyun.util;

import com.qiyun.intface.CombCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 高效组合算法
 * 
 * @author ZhouHaiBin
 * 
 */
public class MathUtils {

	/**
	 * 计算组合数
	 * 
	 * @param r
	 *            取出元素个数
	 * @param n
	 *            可选个数
	 * @return 组合数
	 */
	public static int comp(int r, int n) {
		long C = 1;
		for (int i = n - r + 1; i <= n; i++) {
			C = C * i;
		}
		for (int i = 2; i <= r; i++) {
			C = C / i;
		}
		return (int) C;
	}

	public static List<String> combinResult(final List<Integer> dataList, int selectCount) {
		return combinResult(dataList, selectCount, true);
	}

	public static List<String> combinResult(final List<Integer> dataList, int selectCount, boolean doubleFlag) {
		final List<int[]> list = new ArrayList<int[]>();

		efficientComb(dataList.size(), selectCount, new CombCallBack() {
			public void callback(boolean[] comb, int m) {
				int[] tempArr = new int[m];
				int pos = 0;
				for (int i = 0; i < comb.length; i++) {
					if (comb[i] == true) {
						tempArr[pos] = dataList.get(i);
						pos++;
						if (pos == m)
							break;
					}
				}
				list.add(tempArr);
			}
		});

		List<String> retList = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		for (int[] arr1 : list) {
			for (int b : arr1) {
				if (doubleFlag) {
					sb.append(String.format("%02d", b) + ",");
				} else {
					sb.append(b + ",");
				}
			}
			retList.add(sb.toString().substring(0, sb.toString().length() - 1));
			sb.setLength(0);
		}

		return retList;
	}

	/**
	 * 高效的组合算法
	 *
	 * @param n
	 *            可选的数目
	 * @param m
	 *            取的数目
	 * @param callBack
	 *            每取出一个组合时的回调函数
	 */
	public static void efficientComb(int n, int m, CombCallBack callBack) {
		if (m > n) {
			return;
		}

		boolean[] bs = new boolean[n];
		for (int i = 0; i < m; i++) {
			bs[i] = true;
		}
		if (m == n) {
			callBack.callback(bs, m);
			return;
		}
		for (int i = m; i < n; i++) {
			bs[i] = false;
		}
		if (m == 0) {
			callBack.callback(bs, m);
			return;
		}

		boolean flag = true;
		boolean tempFlag = false;
		int pos = 0;
		int sum = 0;
		// 首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边
		do {
			sum = 0;
			pos = 0;
			tempFlag = true;
			callBack.callback(bs, m);

			// 找到第一个10组合，然后变成01
			for (int i = 0; i < n - 1; i++) {
				if (bs[i] == true && bs[i + 1] == false) {
					bs[i] = false;
					bs[i + 1] = true;
					pos = i;
					break;
				}
			}

			// 将左边的1全部移动到数组的最左边
			for (int i = 0; i < pos; i++) {
				if (bs[i] == true) {
					sum++;
				}
			}
			for (int i = 0; i < pos; i++) {
				if (i < sum) {
					bs[i] = true;
				} else {
					bs[i] = false;
				}
			}

			// 检查是否所有的1都移动到了最右边
			for (int i = n - m; i < n; i++) {
				if (bs[i] == false) {
					tempFlag = false;
					break;
				}
			}
			if (tempFlag == false) {
				flag = true;
			} else {
				flag = false;
			}

		} while (flag);
		callBack.callback(bs, m);
	}

}
