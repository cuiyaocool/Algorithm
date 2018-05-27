package combination;

/**
 * 
 * @author Administrator
 * ������е���ϣ���������abc,��� a b c ab ac bc abc
 * 
 * boolean��ʼ��Ĭ��Ϊfalse��
 */
public class Combination {

	public static void combination(char[] cs) {
		int len = cs.length;
		boolean[] choosed = new boolean[len];
		char[] cache = new char[len];
		int result = len;
		int index = 0;
		while(true) {
			index = 0;
			while (choosed[index]) {
				choosed[index] = false;
				++result;
				if (++index == len) {
					return;
				}
			}
			choosed[index] = true;
			cache[--result] = cs[index];
			System.out.println(new String(cache).substring(result) + "  ");
		}
		
	}
	
	public static void main(String[] args) {
		String sourceString = "abc";
		char[] cs = sourceString.toCharArray();
		combination(cs);
		/*
	    a  
		b  
		ab  
		c  
		ac  
		bc  
		abc  
		 */
		/**
		 * ���裺
		 * ��ʼ��              a b c 
		 * choose: 0 0 0
		 *         1 0 0   a
		 *         0 1 0   b
		 *         1 1 0   ab
		 *         0 0 1   c
		 *         1 0 1   ac
		 *         0 1 1   bc
		 *         1 1 1   abc
		 *         
		 *         Ҫ��֤�ں�һ���ַ��������ܸ���ǰһ���ַ���������һ��ʱ���ԣ�����a b ,������b,a����ʱҪ��b֮ǰ
		 *         
		 *         
		 */
	}
}
