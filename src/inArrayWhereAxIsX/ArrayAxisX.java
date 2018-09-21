package inArrayWhereAxIsX;

/**
 * 严格递增数组中A[x]=x的所有元素
 * 
 * @author cy
 *
 */

public class ArrayAxisX {
	
	public static void findAx(int[] nums){
		if (nums == null) {
			return;
		}
		findAxCore(nums, 0, nums.length-1);
	}

	private static void findAxCore(int[] nums, int s, int e) {
		// TODO Auto-generated method stub
		if (s<0||e>nums.length-1||s>e) {
			return;
		}
		int mid = s + (e - s) / 2;
		if (nums[mid] == mid) {
			System.out.println(mid + " ");
			findAxCore(nums, s, mid - 1);
			findAxCore(nums, mid + 1, e);
		}
		if (nums[mid] < mid) {
			findAxCore(nums, mid + 1, e);
		} 
		if (nums[mid] > mid){
			findAxCore(nums, s, mid - 1);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,4,5};
		findAx(nums);
	}

}
