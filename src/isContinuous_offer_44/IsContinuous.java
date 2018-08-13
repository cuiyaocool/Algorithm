package isContinuous_offer_44;

import java.util.Arrays;

public class IsContinuous {
	
	/**
	 * 
     * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。
     * 2～10为数字本身， A为1。 J为11、Q为12、 为13。小王可以看成任意数字。
     * @param nums
     * @return
     * 
	 */
	
	static boolean isContinuous(int[] nums) {
		if (nums == null || nums.length != 5) {
			return false;
		}
		Arrays.sort(nums);
		int numberOfZero = 0;
		int numberOfGap = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				numberOfZero++;
			} else {
				break;
			}
		}
		for (int i = numberOfZero; i < nums.length - 1; i++) {
			if ((nums[i + 1] - nums[i]) == 0) {
				return false;	
			}
			if (Math.abs(nums[i + 1] - nums[i]) > 0) {
				numberOfGap+=Math.abs(nums[i + 1] - nums[i]) - 1;	
			}
		}
		return numberOfGap <= numberOfZero;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {2, 3, 6, 0, 0};
		System.out.println(isContinuous(nums1));
		int[] nums2 = {2, 3, 4, 7, 0};
		System.out.println(isContinuous(nums2));
	}

}
