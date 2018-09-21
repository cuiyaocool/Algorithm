package totalNQueens;
/**
 * https://leetcode.com/problems/n-queens-ii/description/
 * 
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard 
 * such that no two queens attack each other.
 * 
 * @author cy
 *
 */

public class TotalNQueens {
	public static int total = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalNQueens(4));
		
	}
	public static int totalNQueens(int n) {
		int[] queens = new int[n];
		for (int i = 0; i < queens.length; i++) {
			queens[i] = i;
		}
		computerTotal(queens, 0);
		return total;
        
    }
	private static void computerTotal(int[] queens, int i) {
		// TODO Auto-generated method stub
		if (i == queens.length -1) {
			boolean isok = isOK(queens);
			if (isok) {
				total++;
			}
		}
		for (int j = i; j < queens.length; j++) {
			int temp = queens[i];
			queens[i] = queens[j];
			queens[j] = temp;
			computerTotal(queens, i+1);
			temp = queens[i];
			queens[i] = queens[j];
			queens[j] = temp;
			//computerTotal(queens, i+1);
		}
		
	}
	private static boolean isOK(int[] queens) {
		// TODO Auto-generated method stub
		for (int i = 0; i < queens.length - 1; i++) {
			for (int j = i + 1; j < queens.length; j++) {
				if (j - i == queens[j] - queens [i] || j - i == queens[i] - queens[j]) {
					return false;
				}
			}
		}
		return true;
	}
}
