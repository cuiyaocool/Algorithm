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
		// �������룬��������������һ����ת  
        int[] array1 = {3, 4, 5, 1, 2};  
        System.out.println(minValue(array1));  
        // ���ظ����֣������ظ������ָպõ���С������  
        int[] array2 = {3, 4, 5, 1, 1, 2};  
        System.out.println(minValue(array2));  
        // ���ظ����֣����ظ������ֲ��ǵ�һ�����ֺ����һ������  
        int[] array3 = {3, 4, 5, 1, 2, 2};  
        System.out.println(minValue(array3));  
        // ���ظ������֣������ظ������ָպ��ǵ�һ�����ֺ����һ������  
        int[] array4 = {1, 0, 1, 1, 1};  
        System.out.println(minValue(array4));  
        // �����������飬��ת0��Ԫ�أ�Ҳ���ǵ����������鱾��  
        int[] array5 = {1, 2, 3, 4, 5};  
        System.out.println(minValue(array5));  
        // ������ֻ��һ������  
        int[] array6 = {2};  
        System.out.println(minValue(array6));  
        // ���������ֶ���ͬ  
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};  
        System.out.println(minValue(array7));  
        System.out.println(minValue(array6));  
        // ����NULL  
        System.out.println(minValue(null));  
	}

}
