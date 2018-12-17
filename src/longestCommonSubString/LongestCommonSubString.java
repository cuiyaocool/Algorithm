package longestCommonSubString;
/**
 * 最长公共子串
 * @author cy
 *
 */

public class LongestCommonSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String first = "okcuiyaoisme";
		String second = "iamcuiyao";
		int lenOfCommonSubstring = longestCommonSubstring(first, second);
		System.out.println(lenOfCommonSubstring);
	}

	private static int longestCommonSubstring(String first, String second) {
		// TODO Auto-generated method stub
		int flen = first.length();
		int slen = second.length();
		int[][] len = new int[flen+1][slen+1];
		int maxX = 0, maxY = 0;
		int max = -1;
		for (int i = 0; i <= flen; i++) {
			len[i][0] = 0;
		}
		for (int i = 0; i <= slen; i++) {
			len[0][i] = 0;
		}
		for (int i = 1; i <= flen; i++) {
			for (int j = 1; j <= slen; j++) {
				if (first.charAt(i - 1) == second.charAt(j - 1)) {
					len[i][j] = len[i-1][j-1] + 1;
				} else {
					len[i][j] = 0;
				}
				if (len[i][j] > max ) {
					max = len[i][j];
					maxX = i;
					maxY = j;
				}
			}
		}
		
		//print longest common substring
		String s = "";
		maxX--;
		maxY--;
		while (maxX >= 0 && maxY >= 0) {
			if (first.charAt(maxX) == second.charAt(maxY)) {
				s = first.charAt(maxX) + s;
				maxX--;
				maxY--;
			}else {
				break;
			}
		}
		System.out.println(s);
		return max;
	}

}
