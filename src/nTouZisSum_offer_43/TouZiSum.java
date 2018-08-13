package nTouZisSum_offer_43;

/**
 * 递推公式分析：
 * n个骰子和为s，那么和为s的次数与n-1个骰子的和有关
 * 当最后骰子为1，那么前n-1个骰子和为s-1，同理，最后一个为6，前n-1和为s-6
 * 所以：
 * f(n,s) = f(n-1,s-1) + f(n-1, s-2) + ... + f(n - 1, s - 6)
 * 条件是： 6n>=s>=n
 * 当n>s或者s>6n 返回0
 * @author cuiyao
 *
 */

public class TouZiSum {
	//递归
	private static int getNSumCount(int n, int sum) {
		//1 和 2 的顺序不能错，比如（1，-2）是返回0，但如果1 和 2 颠倒就返回1了
		//1
		if (n > sum || sum > 6*n || n < 1) {
			return 0;
		}
		//2
		if (n == 1) {
			return 1;
		}
		return getNSumCount(n-1, sum-1) + 
			   getNSumCount(n-1, sum-2) +
			   getNSumCount(n-1, sum-3) +
			   getNSumCount(n-1, sum-4) +
			   getNSumCount(n-1, sum-5) +
			   getNSumCount(n-1, sum-6) ;
	}
	
	//非递归
	//nums为一个长度为6*n - n + 1 的数组
	private static void getNSumCount(int n, int[] nums) {
		if (n < 0) {
			return;
		}
		nums[0] = nums[1] = nums[2] = nums[3] = nums[4] = nums[5] = 1;
		//当和为j,i个骰子时，对应在数组的j-i下标
		//nums[j-i]=nums[j-1-(i-1)]+nums[j-2-(i-1)]+...+nums[j-6-(i-1)];
		//这里需要注意的是：
		//内层循环需要从6i到i，因为：nums[15]是num[14...9],如果从小到大，那么计算15时14到9已结被改变
		for (int i = 2; i <= n; i++) {
			for (int j = 6*i; j >=i; j--) {
				nums[j - i] = ((j-1-(i-1))<0?0:nums[j-1-(i-1)]) + 
						      ((j-2-(i-1))<0?0:nums[j-2-(i-1)]) +
						      ((j-3-(i-1))<0?0:nums[j-3-(i-1)]) + 
							  ((j-4-(i-1))<0?0:nums[j-4-(i-1)]) +
							  ((j-5-(i-1))<0?0:nums[j-5-(i-1)]) + 
							  ((j-6-(i-1))<0?0:nums[j-6-(i-1)]) ;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[16];
		for (int i = 3; i <= 18; i++) {
			System.out.print(getNSumCount(3, i) + " ");
		}
		System.out.println();
		getNSumCount(3, nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
/**
 * 1 3 6 10 15 21 25 27 27 25 21 15 10 6 3 1 
 * 1 3 6 10 15 21 25 27 27 25 21 15 10 6 3 1 
 */
}
