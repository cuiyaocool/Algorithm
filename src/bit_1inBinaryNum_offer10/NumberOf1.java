package bit_1inBinaryNum_offer10;

//二进制中1的个数

public class NumberOf1 {
	//在为负数的时候可能出现死循环
	public static int numberOf1_1(int n) {
		int count = 0;
		while (n > 0) {
			if ( 0!=(n & 1)) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
	
	public static int numberOf1_2(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ( 0!=(n & flag)) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	public static int numberOf1_3(int n) {
		int count = 0;
		while(n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}
}
