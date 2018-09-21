package lengthOfLongestSubstringWithoutRepeat;

/**
 *  给定一个字符串，找出不含有重复字符的最长子串的长度。
 *  示例：
 *  给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3
 *  给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *  给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
import java.util.LinkedList;

public class LengthOfLongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "abcabcbb";

		int length = CalLengthOfLongestSubstringWithoutRepeat(ss);

		System.out.println(length);
	}

	private static int CalLengthOfLongestSubstringWithoutRepeat(String ss) {
		// TODO Auto-generated method stub

		int max = 0;// 记录最长子串长度

		int current = 0;// 记录当前子串长度

		char[] cs = ss.toCharArray();
		LinkedList<Character> list = new LinkedList<Character>();
		for (int i = 0; i < cs.length; i++) {
			if (!list.contains(cs[i])) {
				list.add(cs[i]);
				current = list.size();
				max = max > current ? max : current;
			} else {
				list.add(cs[i]);
				for (int j = 0; j <= list.indexOf(cs[i]); j++) {
					list.remove();
				}
			}

		}
		return max;
	}

}
