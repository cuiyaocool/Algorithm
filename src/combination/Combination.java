package combination;

/**
 * 
 * @author Administrator
 * 输出所有的组合，比如输入abc,输出 a b c ab ac bc abc
 * 
 * boolean初始化默认为false，
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
		 * 步骤：
		 * 初始：              a b c 
		 * choose: 0 0 0
		 *         1 0 0   a
		 *         0 1 0   b
		 *         1 1 0   ab
		 *         0 0 1   c
		 *         1 0 1   ac
		 *         0 1 1   bc
		 *         1 1 1   abc
		 *         
		 *         要保证在后一个字符进来不能覆盖前一个字符，但个数一样时可以，比如a b ,但有了b,a进入时要在b之前
		 *         
		 *         
		 */
	}
}
