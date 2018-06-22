package largestRectangleInHistogram;

/**
 * ֱ��ͼ����������(Largest Rectangle in Histogram)
 * 
 * ��n���Ǹ�����������ֱ��ͼ��ÿ��bar�ĸ߶ȣ�ÿ��bar�Ŀ����1���ҵ���ֱ��ͼ��������ľ��Ρ�
 * 
 * @author cy
 *    ----
 *    |  |--
 *    |  |  |  ----
 * ---|  |  |--|  | 
 * |  |  |  |  |  |
 * ----------------
 * 
 * Ҫ���ҳ�������ľ��ε���߽���ұ߽磬���ǰѾ��ε���߽�������������ұ��ƶ���ÿ�ƶ�һ�Σ���һ�����������������ٶ����о�����������ֵ��
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
