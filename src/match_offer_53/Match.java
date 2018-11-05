package match_offer_53;

/**
 * 题目：请实现一个函数用来匹配包含‘.’和‘’的正则表达式。
 * 模式中的字符’.’表示任意一个字符，
 * 而‘’表示它前面的字符可以出现任意次（含0次）。
 * 本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串“aaa”与模式“a.a”和“ab*ac*a”匹配，但与“aa.a”及“ab*a”均不匹配。
 * @author cy
 *
 */

public class Match {

	public static void main(String[] args) {
		String src = "aaa";
		String parntern1 = "a.a";
		String parntern2 = "ab*ac*a";
		String parntern3 = "aa.a";
		String parntern4 = "ab*a";
		
		System.out.println(match(src, parntern1));
		System.out.println(match(src, parntern2));
		System.out.println(match(src, parntern3));
		System.out.println(match(src, parntern4));
	}

	private static boolean match(String src, String parntern) {
		if (src == null || parntern == null) {
			return false;
		}
		return docore(src, parntern);
	}

	private static boolean docore(String src, String parntern) {
		// TODO Auto-generated method stub
		if (src.isEmpty() && parntern.isEmpty()) {
			return true;
		}else if (!src.isEmpty() && parntern.isEmpty()) {
			return false;
		}else if (src.isEmpty() && !parntern.isEmpty()) {
			return false;
		}
		boolean flag = src.charAt(0) == parntern.charAt(0) || parntern.charAt(0) == '.';
		if (parntern.length() > 2 && parntern.charAt(1) == '*') {
			return docore(src, parntern.substring(2)) ||
				   (flag && docore(src.substring(1), parntern));
		}else {
			return flag && docore(src.substring(1), parntern.substring(1));
		}
	}

}
