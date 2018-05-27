package FullPermutation;

/**
 * 
 * @author Administrator
 * 
 * ������ַ�����ȫ���У�����abc,����� abc acb bac bca cab cba
 *
 * ˼·���ֱ�ѡ��0��length-1��λ�õ�ֵΪ��һλ��Ȼ��Ժ���Ľ��еݹ顣
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
			System.out.println("");//�������
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
		System.out.println("ȫ��������: ");
		fullPermutation(cs, 0, cs.length-1);
	}
}
