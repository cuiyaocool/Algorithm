package verifySquenceOfBST_offer24;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,7,6,9,11,10,8};
		VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
		boolean res = verifySquenceOfBST.VerifyBST(nums, 0, nums.length - 1);
		if (res) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
	}

}
