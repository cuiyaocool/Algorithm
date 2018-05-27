package dp;

/**
 * @author cy
 * 时间复杂度O(N^2),空间复杂度O(N)
 */
public class Coins {
		/**
		 * 
		 * @param values
		 * @return boolean
		 * 
		 * 有 n 个硬币排成一条线，每一枚硬币有不同的价值。两个参赛者轮流从任意一边取一枚硬币,直到没有硬币为止。
		 * 计算拿到的硬币总价值，价值最高的获胜。请判定 第一个玩家 是输还是赢？
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
		 * 主要步骤：
		 * 在长度为k的一个区间判断dp[i]
		 * i从后向前走，假如是从前往后走，那么要求在计算dp[i]用到dp[i-1],但在本题中不是这样的，而是用到了dp[i+1]
		 * 整体动态思路为：在长度为k时，dp[i] = max(values[i] + sum(i+1~i+k) - dp[i+1],
		 *                                values[i + k] +　sum[i~i+k-1] - dp[i]);
		 * 比如有一个序列：1，4，3，5，在一个区间长度为2，即k为1，（i，i+k），那么i处为3，更新为5，接着i指向4，那么在计算dp[4]时为i处的值4
		 * 加上sum{i+1，i+k}=3,再减去dp[i+1],但dp[i+1]已经更新为5，所以应该在更新之前保存dp[i+1]。
		 * 理解为：若i处的值大于尾巴处的值，则选择i处的值，同时加上剩余长度里我方可以选择的最大数和，由于下一次是敌方选择，
		 * 所以是剩余长度和减去敌方下次得选择和。
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

