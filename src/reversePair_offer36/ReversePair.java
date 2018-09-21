package reversePair_offer36;

/**
 * 
 * 题目描述： 
 * 数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * eg:7 5 6 4
 * output 5
 * @author cy
 *
 */
public class ReversePair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(inversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(inversePairs(data2)); //  15
        int[] data3 = {1, 2, 3, 4, 5, 6};
        System.out.println(inversePairs(data3)); // 0
        int[] data4 = {1};
        System.out.println(inversePairs(data4)); // 0
        int[] data5 = {1, 2};
        System.out.println(inversePairs(data5)); // 0
        int[] data6 = {2, 1};
        System.out.println(inversePairs(data6)); // 1
        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(inversePairs(data7)); // 3
	}

	private static int inversePairs(int[] arr) {
		// TODO Auto-generated method stub
		int[] copy = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		int count = inversePairs(arr, copy, 0, arr.length - 1);
		
		
		return count;
	}

	private static int inversePairs(int[] arr, int[] copy, int i, int j) {
		// TODO Auto-generated method stub
		if (i == j) {
			//copy[i] = arr[i];
			return 0;
		}
		int mid = i + (j - i)/2;
		//System.out.println(arr[mid]);
		int left = inversePairs(arr, copy, i, mid);
		int right = inversePairs(arr, copy, mid + 1, j);
		
		int start = mid;
		int end = j;
		int copyIndex = j;
		int count = 0;
		while(start >= i && end >= mid + 1) {
			if (arr[start] > arr[end]) {
				count += (end - mid - 1 + 1);
				copy[copyIndex--] = arr[start--];
			}else {
				copy[copyIndex--] = arr[end--];
			}
		}
		
		for (; start >= i; start--) {
			copy[copyIndex--] = arr[start];
		}
		for (; end >= mid + 1; end--) {
			copy[copyIndex--] = arr[end];
		}
		for (int ii = 0; ii < copy.length; ii++) {
			arr[ii] = copy[ii];
		}
		//System.out.println();
		return count + left + right;
	}

}
