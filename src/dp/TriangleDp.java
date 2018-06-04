package dp;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below. 
 * For example, given the following triangle
 * 
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @author Administrator
 *
 */
public class TriangleDp {
	
	public static int minimumTotal(int[][] triangle) {
		int min = Integer.MAX_VALUE;
		int triangleHigh = triangle.length;
		int trangleLen = triangle[triangleHigh - 1].length;
		int dp[][] = new int[triangleHigh][trangleLen];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (j > i) {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j - 1 >= 0 && j + 1 <= i - 1) {
				dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i-1][j + 1]) + triangle[i][j]; 
				} else if (j - 1 >= 0) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i-1][j]) + triangle[i][j];
				} else if (j + 1 <= i-1) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i-1][j + 1]) + triangle[i][j];
				}else {
					dp[i][j] = dp[i-1][j]+triangle[i][j];
				}
				System.out.println(i+ "  " + j + "  "+ dp[i][j]);
			}
			
		}
		for (int i = 0; i < dp[triangleHigh - 1].length; i++) {
			if (min > dp[triangleHigh - 1][i]) {
				min =  dp[triangleHigh - 1][i];
				System.out.println(dp[triangleHigh - 1][i]);
			}
		}
		return min;
	}
	public static void main(String[] args) {
		int[][] triangle = new int [4][4];
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j <= i) {
					triangle[i][j] = (int)(Math.random() * 10);
					System.out.print(triangle[i][j] + "   ");
				}
			}
			System.out.println();
		}
		int min = minimumTotal(triangle);
		System.out.println(min);
	}
	
	public static void test() {
		int[][] accessibility  = new int[2][3];
		accessibility[1][2] = 1;
		accessibility[1][0] = 1;
		for (int i = 0; i < accessibility[1].length; i++) {
			System.out.println(accessibility[1][i]);
		}
		System.out.println(accessibility.length);
	}

}
