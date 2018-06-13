package kthSmallest;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
 * find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * @author Administrator
 *
 */
public class KthSmallestNumInMatrix {

	public static int kthSmallest(int[][] matrix, int k) {
		int small = matrix[0][0];
		int big = matrix[matrix.length - 1][matrix.length - 1];
		int mid = 0;
		while (small < big) {
			mid = small + ((big - small)>>1);
			int count = count(matrix, mid);
			if (count >= k) {
				big = mid;
			} else {
				small = mid + 1;
			}
		}
		return big;
	}
	
	public static int count(int[][] matrix, int num) {
		int count = 0;
		int i = 0;
		int j = matrix.length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[j][i] <= num) {
				//如果matrix[j][i] <= num，则该列到j行处都小于num,所以加j+1
				count += (j + 1);
				i++;
			} else {
				j--;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1, 3, 5}, {2, 5, 7}, {4, 6, 9}};
		for(int i = 1; i <= 9; i++){
			int kthNum = kthSmallest(matrix, i);
			System.out.println(i + "  is:  " + kthNum);
		}
		
	}

}
//1  is:  1
//2  is:  2
//3  is:  3
//4  is:  4
//5  is:  5
//6  is:  5
//7  is:  6
//8  is:  7
//9  is:  9

