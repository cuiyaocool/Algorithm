package combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 * ������е���ϣ���������abc,��� a b c ab ac bc abc
 * 
 * boolean��ʼ��Ĭ��Ϊfalse��
 */
public class Combination {
	public static void combination1(char[] cs) {
		if (cs == null) {
			return;
		}
		List<Character> list = new ArrayList<Character>();
		for (int i = 1; i <= cs.length; i++) {
			_combination(cs,i,list,0);
		}
	}

	private static void _combination(char[] cs, int i, List<Character> list, int start) {
		// TODO Auto-generated method stub
		if (i <= 0) {
			System.out.println(list.toString());
			return;
		}
		if (start >= cs.length) {
			return;
		}
		list.add(cs[start]);
		_combination(cs, i - 1, list, start + 1);
		list.remove(list.size()-1);
		_combination(cs, i, list, start+1);
	}

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
		System.out.println("-------------------");
		combination1(cs);
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
