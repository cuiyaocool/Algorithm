package printMatrixClockWisely;
/**
 * 顺时针 从外到内打印 矩阵
 * 
 * @author cuiyao
 * 
 * 时间： 2018/6/24
 *
 */
public class PrintMatrixClockWisely {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,4},{2,4,5},{4,2,4}};
		
		printMatrixClockWisely(matrix, 3, 3);
	}
	
	public static void printMatrixClockWisely(int[][] matrix, int columns, int rows) {
		if (matrix == null || columns <= 0 || rows <= 0) {
			return;
		}
		int start = 0;
		while (columns > start * 2 && rows > start * 2) {
			printMatrixInCircle(matrix, columns, rows, start);
			
			++start;
		}
	}
	
	private static void printMatrixInCircle(int[][] matrix, int columns, int rows, int start ) {
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;
		
		//左到右
		for (int i = start; i <= endX; ++i) {
			System.out.print(matrix[start][i] + "  ");
		}
		
		//上到下
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				System.out.print(matrix[i][endX] + "  ");
			}
		}
		
		//右到左
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				System.out.print(matrix[endY][i] + "  ");
			}
		}
		
		//下到上
		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i > start; i--) {
				System.out.print(matrix[i][start] + "  ");
			}
		}
		
	}

}
