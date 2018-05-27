package dp;

/**
 * @author cy
 * ʱ�临�Ӷ�O(N^2),�ռ临�Ӷ�O(N)
 */
public class Coins {
		/**
		 * 
		 * @param values
		 * @return boolean
		 * 
		 * �� n ��Ӳ���ų�һ���ߣ�ÿһöӲ���в�ͬ�ļ�ֵ����������������������һ��ȡһöӲ��,ֱ��û��Ӳ��Ϊֹ��
		 * �����õ���Ӳ���ܼ�ֵ����ֵ��ߵĻ�ʤ�����ж� ��һ����� ���仹��Ӯ��
		 * https://mp.weixin.qq.com/s/tU1S7hpUZ2nJGKGaKW7Lpg
		 */
	public static boolean firstWillWin(int[] values) {
		
		int len = values.length;
		int[] sum = new int[len + 1];
		int[] dp = new int[len];
		
		sum[0] = 0;
		for (int i = 1; i <= len; ++i) {
			sum[i] = values[i - 1] + sum[i - 1];
		}
		
		for (int i = 0; i < len; i++) {
			dp[i] = values[i];
		}
		/**
		 * ��Ҫ���裺
		 * �ڳ���Ϊk��һ�������ж�dp[i]
		 * i�Ӻ���ǰ�ߣ������Ǵ�ǰ�����ߣ���ôҪ���ڼ���dp[i]�õ�dp[i-1],���ڱ����в��������ģ������õ���dp[i+1]
		 * ���嶯̬˼·Ϊ���ڳ���Ϊkʱ��dp[i] = max(values[i] + sum(i+1~i+k) - dp[i+1],
		 *                                values[i + k] +��sum[i~i+k-1] - dp[i]);
		 * ������һ�����У�1��4��3��5����һ�����䳤��Ϊ2����kΪ1����i��i+k������ôi��Ϊ3������Ϊ5������iָ��4����ô�ڼ���dp[4]ʱΪi����ֵ4
		 * ����sum{i+1��i+k}=3,�ټ�ȥdp[i+1],��dp[i+1]�Ѿ�����Ϊ5������Ӧ���ڸ���֮ǰ����dp[i+1]��
		 * ���Ϊ����i����ֵ����β�ʹ���ֵ����ѡ��i����ֵ��ͬʱ����ʣ�೤�����ҷ�����ѡ���������ͣ�������һ���ǵз�ѡ��
		 * ������ʣ�೤�Ⱥͼ�ȥ�з��´ε�ѡ��͡�
		 *                     
		 */
		for (int k = 1; k < len; k++) {
			int temp = dp[len - k];
			for (int i = len - k - 1; i >= 0; i--) {
				int temp1 = dp[i];
				dp[i] = Math.max(
						values[i] + (sum[i + k + 1] - sum[i + 1]) - temp, 
						values[i + k] + (sum[i + k] - sum[i]) - dp[i]
						);
				temp = temp1;
			}
		}
		if (dp[0] * 2 > sum[len]) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[] a = {1,9,3};
		int[] b = {3,2,2};
		int[] c = {1,2,4};
		int[] d = {1,2,2,1};
		System.out.println(firstWillWin(a));
		System.out.println(firstWillWin(b));
		System.out.println(firstWillWin(c));
		System.out.println(firstWillWin(d));
	}
}
/*
false
true
true
false
*/

