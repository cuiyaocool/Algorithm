package numberOf2Between0AndN;

public class NumberOf2Btween0toN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		System.out.println("1 到数字 " + n + "　中2的个数是: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 10;
		System.out.println("1 到数字 " + n + "　中2的个数是: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 1;
		System.out.println("1 到数字 " + n + "　中2的个数是: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 121;
		System.out.println("1 到数字 " + n + "　中2的个数是: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 32;
		System.out.println("1 到数字 " + n + "　中2的个数是: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 210;
		System.out.println("1 到数字 " + n + "　中2的个数是: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 212;
		System.out.println("1 到数字 " + n + "　中2的个数是: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));

	}

	/**
	 * 
	 * 把每一个数分为两部分，http://www.code123.cc/969.html 比如121，个位为1，之前是12， 那么因为之前的12
	 * 导致个位的2重复了12次，判断个位，个位如果大于等于2，那么他出现了一次，小于2则没有出现，
	 * 在计算12，此时的12有一个基数就是10，从10位开始的。 分为1和2，因为基数为10，所以前面的1导致2重复了1*10=10次
	 * 再分析2，该位为2，出现的次数由它的低位决定，所以需要用最初的值121/10 = 1,再加1
	 * 如果该位为小于2，则为0次，如果大于2，则出现10^1,该1为基数，最后次数为12+10+1+1= 24
	 * 
	 * 1 到数字 12　中2的个数是: 2 2 
	 * 1 到数字 10　中2的个数是: 1 1 
	 * 1 到数字 1　中2的个数是: 0 0 
	 * 1 到数字121　中2的个数是: 24 24 
	 * 1 到数字 32　中2的个数是: 14 14 
	 * 1 到数字 210　中2的个数是: 52 52 
	 * 1 到数字 212　中2的个数是: 55 55
	 * 
	 * @param n
	 *            n为最大值，即1~n的n
	 * @param k
	 *            从第k位开始计算，各位为0，十位为1
	 * @return
	 */
	private static int numberOf2(int n, int k) {
		// TODO Auto-generated method stub
		int count = 0;

		int old = n;

		while (n != 0) {
			int high = n / 10;
			int low = n % 10;
			count += high * Math.pow(10, k);
			if (low > 2) {
				count += Math.pow(10, k);
			}
			if (low == 2 && k == 0) {
				count++;
			} else if (low == 2) {
				count += (old % (Math.pow(10, k))) + 1;
			}
			k++;
			n = high;
		}
		return count;
	}

	// 下面是最基本的复杂度较高的算法，判断每一个数中2的个数，为了判断上一种方法是否写对了才写的
	private static int numberOf2_(int n) {
		int count = 0;
		while (n >= 0) {
			count += numberOf2InNum(n);
			n--;
		}
		return count;

	}

	private static int numberOf2InNum(int n) {
		// TODO Auto-generated method stub
		int count = 0;
		while (n > 0) {
			if (n % 10 == 2) {
				count++;
			}
			n /= 10;
		}
		return count;
	}

}
