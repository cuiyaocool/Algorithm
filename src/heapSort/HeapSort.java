package heapSort;
/**
 * 堆排序
 * @author cy
 *
 */

public class HeapSort {
	/**
	 * 一次调整，对low和high元素对low进行调整
	 * @param nums
	 * @param low
	 * @param high
	 */
	void Sift(int[] nums, int low, int high){
		//index is from 1
		int i = low, j = 2*i;
		int temp = nums[i];
		while (j <= high) {
			if (j+1<=high && nums[j]<nums[j+1]) {
				j++;
			}
			if (temp < nums[j]) {
				nums[i] = nums[j];
				i = j;
				j = 2*i;
			}else {
				break;
			}
		}
		nums[i] = temp;
	}
	
	
	void heapSort(int[] nums, int n){
		for (int i = n/2; i >= 1; i--) {
			Sift(nums, i, n);
		}
		for (int i = n; i >= 2; i--) {
			int temp = nums[1];
			nums[1] = nums[i];
			nums[i] = temp;
			Sift(nums, 1, i - 1);
		}
	}
}
