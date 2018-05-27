package FullPermutation;

/**
 * 
 * @author Administrator
 * 
 * 求给定字符串的全排列，给定abc,输出： abc acb bac bca cab cba
 *
 * 思路：分别选择0到length-1的位置的值为第一位，然后对后面的进行递归。
 */

public class FullPermutation {

	public static void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}
	public static void fullPermutation(char[] cs, int from, int to) {
		if (to < 0) {
			return;
		}
		if (from == to) {
			for (char c : cs) {
				System.out.print(c);
			}
			System.out.println("");//换行输出
		}
		if (from != to) {
			for (int i = from; i <= to; i++) {
				swap(cs, i, from);
				fullPermutation(cs, from+1, to);
				swap(cs, i, from);
			}
		}
	}
	
	public static void main(String[] args) {
		String cString = "abcd";
		char[] cs = cString.toCharArray();
		System.out.println("全排列如下: ");
		fullPermutation(cs, 0, cs.length-1);
	}
}
