package lastReminInCircle_offer45;

import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * @author cuiyao
 * @param n 数字的个数
 * @param m 删除第几个
 *
 */
public class LastRemin {
	public static int lastRemin1(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		// 要删除元素的位置
	    int idx = 0;
	    while (list.size() > 1) {
	    	 // 只要移动m-1次就可以移动到下一个要删除的元素上   1 2 3 4 5 从1开始，删除第3个元素，移动两次即可
			for(int i = 0; i < m - 1; i++) {
				idx = (idx + 1) % list.size();
			}
			list.remove(idx);
		}
		return list.get(0);
	}
}
