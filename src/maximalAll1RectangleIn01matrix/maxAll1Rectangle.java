package maximalAll1RectangleIn01matrix;

import largestRectangleInHistogram.LargestRectangleInHistogram;

/**
 * 在一个M * N的矩阵中，所有的元素只有0和1， 找出只包含1的最大矩形。
 * @author Administrator
 * 因为我们要找的是矩形，所以它一定是以 某行元素开始的，这样的话，其实我们要找到的某个矩形就转换成 某行开始的 histogram(直方图)的最大矩形问题了（在largestRectangleInHistogram中）。
 * 
 * 处理每一行数据，例如新数组（0，0）处为（0，M)到（0，0）这一列连续的1的个数
 */
public class maxAll1Rectangle {

	public static int[][] makeHistpgram(int[][] matrix, int[][] hist) {
		for(int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(matrix[j][i] == 1) {
					//System.out.println("ff");
					if(j != 0) {
						//System.out.println("dd");
						hist[j][i] = hist[j - 1][i] + 1;
					} else {
						//System.out.println("oo");
						hist[j][i]++;
					}
					
				} else {
					//System.out.println("ee");
					hist[j][i] = 0;
				}
			}
		}
		return hist;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0,1,0,1,0,0},{0,1,1,0,0,1},{1,1,1,0,1,0},{0,0,0,0,0,1}};
		int[][] hist = new int[matrix.length][matrix[0].length];
		int max = 0;
		hist = makeHistpgram(matrix, hist);
		for (int i = 0; i < hist.length; i++) {
			for (int j = 0; j < hist[i].length; j++) {
				System.out.print(hist[i][j] + "   ");
			}
			System.out.println();
		}
		for (int i = 0; i < hist.length; i++) {
			//System.out.println(LargestRectangleInHistogram.findMaxRectangle(hist[i],hist[i].length));
			max = Math.max(max, LargestRectangleInHistogram.findMaxRectangle(hist[i], hist[i].length));
		}
		System.out.println("max is :" + max);
	}

}
