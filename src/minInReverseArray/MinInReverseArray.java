package minInReverseArray;

public class MinInReverseArray {
	
	public static int minValue(int[] nums){
		if (nums == null || nums.length == 0) {
			throw new RuntimeException("Invalid input");
		}
		int low = 0;
		int high = nums.length - 1;
		int mi = low;
		while (nums[low] >= nums[high]) {
			if (low +1 == high) {
				return nums[high];
			}
			mi = low + (high - low) / 2;
			if (nums[low] == nums[mi] && nums[mi] == nums[high]) {
				return minOrder(nums, low, high);
			}
			if (nums[mi] >= nums[low]) {
				low = mi;
			}
			else {
				high = mi;
			}
			
		}
		return nums[mi];
	}

	private static int minOrder(int[] nums, int low, int high) {
		// TODO Auto-generated method stub
		int result = nums[low];
		for (int i = low + 1; i <= high; i++) {
			if (result > nums[i]) {
				result = nums[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 典型输入，单调升序的数组的一个旋转  
        int[] array1 = {3, 4, 5, 1, 2};  
        System.out.println(minValue(array1));  
        // 有重复数字，并且重复的数字刚好的最小的数字  
        int[] array2 = {3, 4, 5, 1, 1, 2};  
        System.out.println(minValue(array2));  
        // 有重复数字，但重复的数字不是第一个数字和最后一个数字  
        int[] array3 = {3, 4, 5, 1, 2, 2};  
        System.out.println(minValue(array3));  
        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字  
        int[] array4 = {1, 0, 1, 1, 1};  
        System.out.println(minValue(array4));  
        // 单调升序数组，旋转0个元素，也就是单调升序数组本身  
        int[] array5 = {1, 2, 3, 4, 5};  
        System.out.println(minValue(array5));  
        // 数组中只有一个数字  
        int[] array6 = {2};  
        System.out.println(minValue(array6));  
        // 数组中数字都相同  
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};  
        System.out.println(minValue(array7));  
        System.out.println(minValue(array6));  
        // 输入NULL  
        System.out.println(minValue(null));  
	}

}
