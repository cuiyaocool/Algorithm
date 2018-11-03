package verifySquenceOfBST;

public class VerifySquenceOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numsRight = {5,7,6,9,11,10,8};
		int[] numsWrong = {7,4,6,5};
		
		
		System.out.println(Verify(numsRight));
		System.out.println(Verify(numsWrong));
	}

	private static boolean Verify(int[] nums) {
		// TODO Auto-generated method stub
		if (nums == null) {
			return false;
		}
		return Verify(nums, 0, nums.length-1);
	}

	private static boolean Verify(int[] nums, int s, int e) {
		// TODO Auto-generated method stub
		if (s == e) {
			return true;
		}
		int root = nums[e];
		int i = s;
		for (; i < e; i++) {
			if (nums[i]>root) {
				break;
			}
		}
		int j = i;
		for (; j < e; j++) {
			if (nums[j] < root) {
				return false;
			}
		}
		boolean left = Verify(nums, s, i - 1);
		boolean right = Verify(nums, i, e - 1);
		return left && right;
	}

}
