package longestCommonSequence;

/**
 * 最长公共子序列
 * 
 * @author cuiyao
 *
 */

public class LongestCommonSequence {
	
	//递归解法
	private static int longest_recursion(String a, String b, int as, int bs) {
		int alen = a.length();
		int blen = b.length();
		
		if (as >= alen || bs >= blen) {
			return 0;
		}
		if (a.charAt(as) == b.charAt(bs)) {
			return longest_recursion(a, b, as + 1, bs + 1) + 1;
		}
		else {
			return Math.max(longest_recursion(a, b, as + 1, bs), longest_recursion(a, b, as, bs + 1));
		}
		
	}
	
	public static void main(String[] args) {
		String aString = "abcdef";
		String bString = "acdd";
		int[][] len = new int[aString.length() + 1][bString.length() + 1];
		//递归
		System.out.println("递归：");
		System.out.println(longest_recursion(aString, bString, 0, 0));
		//动态规划
		System.out.println("动规：");
		System.out.println(lingest_dp(aString, bString, len));
	}

	//动态规划
	private static int lingest_dp(String aString, String bString, int[][] len) {
		// TODO Auto-generated method stub
		for (int i = 0; i < aString.length() + 1; i++) {
			len[i][0] = 0;
		}
		for (int i = 0; i < bString.length() + 1; i++) {
			len[0][i] = 0;
		}
		for (int i = 0; i < aString.length(); i++) {
			for (int j = 0; j < bString.length(); j++) {
				if(aString.charAt(i) == bString.charAt(j)){
					len[i+1][j+1] = len[i][j] + 1;
				}
				else if (len[i][j + 1] > len[i + 1][j]) {
					len[i + 1][j + 1] = len[i][j + 1];
				}else {
					len[i + 1][j + 1] = len[i + 1][j];
				}
			}
		}
		return len[aString.length()][bString.length()];
	}


}
