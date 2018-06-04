package longesetIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * For example, given [10, 9, 2, 5, 3, 7, 101, 18], the longest increasing subsequence is [2, 3, 7, 101]. 
 * 
 * Therefore the length is 4.
 * 
 * @author cy
 * https://www.programcreek.com/2014/04/leetcode-longest-increasing-subsequence-java/
 */
public class LongesetIncreasingSubsequence {

	public static int lengthOfLIS1(int[] nums) {
		int length = nums.length;
		if (length == 0 || nums == null) {
			return 0;
		}
		int max[] = new int[length];
		int maxLen = 0;
		Arrays.fill(max, 1);
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					max[i] = Math.max(max[i], max[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, max[i]);
		}
		return maxLen;
	}
	
	//second method
	public static int lengthOfLIS2(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		for (int num : nums) {
			if (list.isEmpty() || num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
				int i = 0;
				int j = list.size() - 1;
				while (i < j) {
					int mid = (i + j)/2;
					if (num > nums[mid]) {
						i = mid + 1;
					} else {
						j = mid;
					}
				}
				list.set(j, num);//用set替换掉在num之前且大于num的数
			}
		}
		return list.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2, 3, 5, 4, 7, 0, 9};
		int len = lengthOfLIS1(nums);
		System.out.println(len);
		int len2 = lengthOfLIS2(nums);
		System.out.println(len2);
	}

}
