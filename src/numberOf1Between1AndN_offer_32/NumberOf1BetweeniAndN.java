package numberOf1Between1AndN_offer_32;

public class NumberOf1BetweeniAndN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 21345;
		int count = count1times(n, n, 1);
		System.out.println("num is: "+ " " + n+", "+"次数： " + count);
		n = 12;
		count = count1times(n, n, 1);
		System.out.println("num is: "+ " " + n+", "+"次数： " + count);
		n = 10000;
		count = count1times(n, n, 1);
		System.out.println("num is: "+ " " + n+", "+"次数： " + count);
		n = 10;
		count = count1times(n, n, 1);
		System.out.println("num is: "+ " " + n+", "+"次数： " + count);
		n = 99;
		count = count1times(n, n, 1);
		System.out.println("num is: "+ " " + n+", "+"次数： " + count);
	}

	private static int count1times(int n, int chushi, int weishu) {
		// TODO Auto-generated method stub
		int count = 0;
		if (n == 0) {
			return 0;
		}
		int high = n / 10;
		int low = n % 10;
		if (high>0) {
			count = (int) (count + high * Math.pow(10, weishu - 1));
			//System.out.println(count);
		}
		if (low > 1) {
			count+=Math.pow(10, weishu - 1);
		}
		if (low == 1) {
			count+=(chushi%(Math.pow(10, weishu-1))) + 1;
		}
		weishu++;
		return count+=count1times(high, chushi, weishu);
	}

}
