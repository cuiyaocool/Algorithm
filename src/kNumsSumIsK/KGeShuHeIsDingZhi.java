package kNumsSumIsK;

import java.util.ArrayList;
import java.util.List;

/**
 * k个数的和为定值
 * 
 * @author cy
 *
 */
public class KGeShuHeIsDingZhi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2 ,3, 4 ,5,6,7,8};
		int sum = 15;
		List<Integer> list = new ArrayList<Integer>();
		findNums(nums, sum, list, 0);
	}

	private static void findNums(int[] nums, int sum, List<Integer> list, int s) {
//		System.out.println(sum + " " + list.toString() + " " + s);
		if (sum == 0) {
			System.out.println(list.toString());
			return;
		}
		if (s >= nums.length || sum < 0) {
			return;
		}	
		list.add(nums[s]);
		findNums(nums, sum - nums[s], list, s + 1);
		list.remove(list.size() - 1);
		findNums(nums, sum, list, s + 1);

	}

}
