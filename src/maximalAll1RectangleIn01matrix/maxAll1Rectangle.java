package maximalAll1RectangleIn01matrix;

import largestRectangleInHistogram.LargestRectangleInHistogram;

/**
 * ��һ��M * N�ľ����У����е�Ԫ��ֻ��0��1�� �ҳ�ֻ����1�������Ρ�
 * @author Administrator
 * ��Ϊ����Ҫ�ҵ��Ǿ��Σ�������һ������ ĳ��Ԫ�ؿ�ʼ�ģ������Ļ�����ʵ����Ҫ�ҵ���ĳ�����ξ�ת���� ĳ�п�ʼ�� histogram(ֱ��ͼ)�������������ˣ���largestRectangleInHistogram�У���
 * 
 * ����ÿһ�����ݣ����������飨0��0����Ϊ��0��M)����0��0����һ��������1�ĸ���
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
