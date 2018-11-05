package inversePairs_offer_36;



/**
 * 数组中逆序对
 * @author cy
 *
 */
public class InversePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,5,6,4};
		System.out.println(InversePairsInNums(nums));
		int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(InversePairsInNums(data)); // 3
	}

	private static int InversePairsInNums(int[] nums) {
		// TODO Auto-generated method stub
		if(nums == null || nums.length <= 0){
			return -1;
		}
		int[] temp = new int[nums.length];
		return docore(nums, 0, nums.length-1, temp);
	}

	private static int docore(int[] nums, int s, int e, int[] temp) {
		// TODO Auto-generated method stub
		if (s == e) {
			temp[s] = nums[s];
			return 0;
		}
		int mid = s + (e - s) / 2;
		int pre = docore(nums, s, mid, temp);
		int behind = docore(nums, mid + 1, e, temp);
		int i = mid, j = e, current = 0, indexcopy = e;
		while (i >= s && j >= mid + 1) {
			if(nums[i] > nums[j]){
				temp[indexcopy--] = nums[i--];
				current+=(j - mid);
			}else {
				temp[indexcopy--] = nums[j--];
			}
		}
		while (i >=s) {
			temp[indexcopy--] = nums[i--];
		}
		while (j >= mid + 1) {
			temp[indexcopy--] = nums[j--];
		}
		for (int k = s; k <= e; k++) {
			nums[k] = temp[k];
		}
		return pre + behind + current;
	}

}
