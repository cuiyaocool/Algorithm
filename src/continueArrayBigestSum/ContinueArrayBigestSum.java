package continueArrayBigestSum;

public class ContinueArrayBigestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,-2,3,10,-4,7,2,-5};
		System.out.println(clac(nums));
	}

	private static int clac(int[] nums) {
		// TODO Auto-generated method stub
		if(nums.length<=0 || nums == null) 
			return 0;
		int[] big = new int[nums.length];
		big[0] = nums[0];
		for (int i = 1; i < big.length; i++) {
			big[i] = Math.max(nums[i], big[i - 1] + nums[i]);
		}
		for (int i = 1; i < big.length; i++) {
			if (big[i] > big[0]) {
				big[0] = big[i];
			}
		}
		return big[0];
	}

}
