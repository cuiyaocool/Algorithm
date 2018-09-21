package dpSumIsK;
/**
 * 数组中是否包含和为K的一组解
 * 
 * dp:选和不选
 * 
 * 如果选最后一个数，则相当于求function（nums, n-1,k-nums[n-1]）
 * 
 * 如果不选最后一个数，则相当于function（nums, n - 1, k）
 * 
 * @author 崔遥
 *
 */

public class ShuZuHasEleSumIsK {
	
	public static boolean findSumIsK(int[] nums, int len, int k) {
		if (nums == null || len <= 0) {
			return false;
		}
		if (k == 0) {
			return true;
		}
		if (len == 1) {
			return k==nums[len - 1];
		}
		boolean res = findSumIsK(nums, len - 1, k - nums[len - 1]);
		if (res) {
			System.out.println(nums[len - 1]);
			return res;
		} else {
			res = findSumIsK(nums, len - 1, k);
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8,9,12};
		System.out.println(findSumIsK(nums, nums.length, 15));
		System.out.println(findSumIsK(nums, nums.length, 95));
	}

}
