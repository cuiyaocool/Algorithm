package bit_addUseBit_offer_47;

/**
 * 不用加减求和
 * 
 * 位运算
 * 
 * @author Administrator
 *
 */
public class AddUseBit {
	
	static int add(int n1, int n2) {
		int sum, carry;
		do {
			sum = n1^n2;
			carry = (n1 & n2) << 1;
			n1 = sum;
			n2 = carry;
		} while (n2!=0);
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=9,b=8;
		System.out.println("sum :　"+ add(a, b));
	}

}
