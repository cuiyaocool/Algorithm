package useStackImplQueue_offer7;

import java.util.Stack;

public class _2stacksImplQueue {
	private static Stack<Integer> s1;
	private static Stack<Integer> s2;
	
	public _2stacksImplQueue() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	public int get() {
		if (s2.size() <= 0 && s1.size() <= 0) {
			return 0;
		}
		if (s2.size() > 0) {
			return s2.pop();
		} else if (s1.size() <=0) {
			return 0;
		} else {
			while (s1.size() > 0) {
				s2.push(s1.pop());
			}
			return s2.pop();
		}
	}
	public void put(int num) {
		s1.push(num);
	}
}
