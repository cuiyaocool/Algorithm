package heapSort;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,3, 4,1,9,7,3,1,2};
		for (int i = 1; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		HeapSort heapSort = new HeapSort();
		heapSort.heapSort(nums, nums.length-1);
		for (int i = 1; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
