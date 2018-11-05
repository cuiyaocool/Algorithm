package maxSlideWindow_offer_65;
/**
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 */

import java.util.ArrayList;
import java.util.List;

public class MaxWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,4,1,4,6,8,5,3,4,6};
		int winLen = 3;
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		findMaxWin(nums, winLen, list, res);
		System.out.println("result is: ");
		for (Integer integer : res) {
			System.out.println(nums[integer]+" ");
		}
	}

	private static void findMaxWin(int[] nums, int winLen, List<Integer> list, List<Integer> res) {
		// TODO Auto-generated method stub
		for (int i = 0; i < winLen; i++) {
//			System.out.println(i);
			while (!list.isEmpty()) {
//				System.out.println("size"+list.size());
//				System.out.println(list.toString());
//				System.out.println("pp" + list.get(list.size()-1));
				if (nums[i] >= nums[list.get(list.size()-1)]) {
					
					list.remove(list.size()-1);
					
				}else {
					break;
				}
			}
			list.add(i);
		}
		for (int i = winLen; i < nums.length; i++) {
			res.add(list.get(0));
			while (!list.isEmpty() && nums[i] > nums[list.get(list.size()-1)]) {
				list.remove(list.size()-1);
			}
			if (!list.isEmpty() && (i - winLen)>=list.get(0) ) {
				list.remove(0);
			}
			list.add(i);
		}
		res.add(list.get(0));
	}

}
