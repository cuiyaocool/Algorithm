package print1ToMaxOfDigits_1_offer12;

/**
 * 打印1到最大的n位数
 * 
 * 要考虑数字越界的问题，比如输入的n很大，那么用int或者long会溢出，也就是要考虑  大数问题
 * 
 * @author cuiyao
 *
 */
public class Print1ToMaxOfDigits_1 {
	void Print1ToMaxDigits(int n) {
		if (n < 0) {
			return;
		}
		char[] chars = new char[n];
		for (int c = 0; c < chars.length; c++) {
			chars[c] = '0';
		}
		while (!Increment(chars)) {
			printChars(chars);
		}
		
	}
	void printChars(char[] chars) {
		boolean flag = false;
		for (char c : chars) {
			if (c == '0' && !flag) {
				continue;
			} else {
				System.out.print(c);
				flag = true;
			}
		}
		System.out.println();
	}
	//是否溢出，是否已经是最大值
	boolean Increment(char[] chars) {
		int carry = 0;//进位
		boolean isOverflow = false;
		for (int i = chars.length - 1; i >= 0; i--) {
			//第i位加进位，然后在加1，判断是否给上一位进位
			int nsum = chars[i] - '0' + carry;
			if (i == chars.length - 1) {
				nsum++;
			}
			if (nsum >= 10) {
				if (i == 0) {
					isOverflow = true;
				} else {
					nsum -= 10;
					carry = 1;
					chars[i] = (char)('0' + nsum);
				}
				
			}else {
				chars[i] = (char)('0' + nsum);
				break;
			}
			
		}
		return isOverflow;
	}
}
