package isHouXuBianLi_offer_24;

public class IsBST {
	public static boolean isbst(int[] nums){
		if (nums==null) {
			return true;
		}
		boolean res = isbst(nums, 0, nums.length-1);
		return res;
	}
	private static boolean isbst(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		if (i>j||i<0||j>=nums.length) {
			return false;
		}
		if (i==j) {
			return true;
		}
		int temp = nums[j];
		int k=0, t;
		for (k = i; k <= j; k++) {
			if (nums[k]>temp) {
				break;
			}
		}
		t = k -1;
		for (; k < j; k++) {
			if (nums[k]<nums[j]) {
				return false;
			}
		}
		return isbst(nums, i, t)&&isbst(nums, t+1, j - 1);
		
	}
}
