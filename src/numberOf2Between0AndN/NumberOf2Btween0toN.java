package numberOf2Between0AndN;

public class NumberOf2Btween0toN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		System.out.println("1 ������ " + n + "����2�ĸ�����: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 10;
		System.out.println("1 ������ " + n + "����2�ĸ�����: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 1;
		System.out.println("1 ������ " + n + "����2�ĸ�����: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 121;
		System.out.println("1 ������ " + n + "����2�ĸ�����: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 32;
		System.out.println("1 ������ " + n + "����2�ĸ�����: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 210;
		System.out.println("1 ������ " + n + "����2�ĸ�����: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));
		n = 212;
		System.out.println("1 ������ " + n + "����2�ĸ�����: " + numberOf2(n, 0) + "   "
				+ numberOf2_(n));

	}

	/**
	 * 
	 * ��ÿһ������Ϊ�����֣�http://www.code123.cc/969.html ����121����λΪ1��֮ǰ��12�� ��ô��Ϊ֮ǰ��12
	 * ���¸�λ��2�ظ���12�Σ��жϸ�λ����λ������ڵ���2����ô��������һ�Σ�С��2��û�г��֣�
	 * �ڼ���12����ʱ��12��һ����������10����10λ��ʼ�ġ� ��Ϊ1��2����Ϊ����Ϊ10������ǰ���1����2�ظ���1*10=10��
	 * �ٷ���2����λΪ2�����ֵĴ��������ĵ�λ������������Ҫ�������ֵ121/10 = 1,�ټ�1
	 * �����λΪС��2����Ϊ0�Σ��������2�������10^1,��1Ϊ������������Ϊ12+10+1+1= 24
	 * 
	 * 1 ������ 12����2�ĸ�����: 2 2 
	 * 1 ������ 10����2�ĸ�����: 1 1 
	 * 1 ������ 1����2�ĸ�����: 0 0 
	 * 1 ������121����2�ĸ�����: 24 24 
	 * 1 ������ 32����2�ĸ�����: 14 14 
	 * 1 ������ 210����2�ĸ�����: 52 52 
	 * 1 ������ 212����2�ĸ�����: 55 55
	 * 
	 * @param n
	 *            nΪ���ֵ����1~n��n
	 * @param k
	 *            �ӵ�kλ��ʼ���㣬��λΪ0��ʮλΪ1
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

	// ������������ĸ��ӶȽϸߵ��㷨���ж�ÿһ������2�ĸ�����Ϊ���ж���һ�ַ����Ƿ�д���˲�д��
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
