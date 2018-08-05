package bit_NumAppearOnce_offer40;

public class NumAppearOnce {
	//数组中只有两个数出现了一次，其他都出现两次，求出这两个出现一次的数字
	void findNumAppearOnce(int[] nums, int length) {
		if (nums == null || length < 2) {
			return;
		}
		int first, second;
		int temp = 0;
		for (int i : nums) {
			temp ^= i;
		}
		System.out.println(temp);
		int index = findFirstBit1(temp);
		System.out.println(index);
		first = second = 0;
		for (int i : nums) {
			if (is1(i, index)) {
				System.out.println(i);
				first ^= i;
			} else {
				System.out.println("2:" + i);
				second ^= i;
			}
		}
		System.out.println(first + "  " + second);
	}
	int findFirstBit1(int temp) {
		int index = 0;
		while ((temp & 1) == 0 && index < 8 * 4) {
			index++;
			temp = temp >> 1;
		}
		return index;
	}
	boolean is1(int num, int offset) {
		num = num >> offset;
		return (num & 1) == 0;
	}
}
