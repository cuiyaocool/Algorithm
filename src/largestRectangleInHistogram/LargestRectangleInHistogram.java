package largestRectangleInHistogram;

/**
 * 直方图最大矩形问题(Largest Rectangle in Histogram)
 * 
 * 有n个非负整数，代表直方图中每个bar的高度，每个bar的宽度是1。找到此直方图中面积最大的矩形。
 * 
 * @author cy
 *    ----
 *    |  |--
 *    |  |  |  ----
 * ---|  |  |--|  | 
 * |  |  |  |  |  |
 * ----------------
 * 
 * 要想找出面积最大的矩形的左边界和右边界，我们把矩形的左边界从数组的左边向右边移动，每移动一次，求一次最大矩形面积。最后再对所有矩形面积求最大值。
 *
 */
public class LargestRectangleInHistogram {
	
	public static int findMaxRectangle(int[] hist, int n) {
		int[] arr = new int[n];
		arr[0] = hist[0];
		int max = arr[0];
		for (int i = 1; i < hist.length; i++) {
			arr[i] = hist[i];
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					max = Math.max(max, arr[j] * (i - j));
					arr[j] = arr[i];
				} else {
					break;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (arr[i] * (n - i) > max) {
				max = arr[i] * (n - i);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int max = 0;
		int[] histogram = {1,4,3,1,2,1,1,1,1,1,1,1};
		
		max = findMaxRectangle(histogram, histogram.length);
		System.out.println("LargestRectangleInHistogram:" + max);
		
		max = findMaxRectangle2(histogram, histogram.length);
		System.out.println("LargestRectangleInHistogram:" + max);
	}

	public static int findMaxRectangle2(int[] hist, int n) {
		int[] arr = new int[n];
		arr[0] = hist[0];
		int max = arr[0];
		for (int i = 1; i < hist.length; i++) {
			arr[i] = hist[i];
			max = Math.max(max, arr[i]);
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					max = Math.max(max, arr[j] * (i - j));
					arr[j] = arr[i];
				} else {
					max = Math.max(max, arr[j] * (i + 1));
					break;
				}
			}
		}
		
		return max;
	}
}
