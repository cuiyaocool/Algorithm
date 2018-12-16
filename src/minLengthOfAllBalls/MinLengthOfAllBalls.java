package minLengthOfAllBalls;

/**
 * һ����β����������(m��)����N����ɫ(N<=10)
 * ���һ���㷨��ȡ������һ�Σ�Ҫ���������N����ɫ����ʹ������̡�������ʱ�临�Ӷ���ռ临�Ӷȡ�
 * 
 * @author cy
 *
 */
public class MinLengthOfAllBalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String balls = "aaabcbdccdab";
		int types = 4;
		System.out.println(solve(balls, types));
	}

	private static int solve(String balls, int types) {
		// TODO Auto-generated method stub
		int len = balls.length();
		balls += balls;
		int[] colors = new int[types];
		int tail = 0;
		int head = 0;
		int min = len;
		while(tail < len + 5) {
			while (!isFull(colors) && tail < len + 5) {
				colors[balls.charAt(tail) - 'a']++;
				tail++;
			}
			while(isFull(colors)) {
				colors[balls.charAt(head) - 'a']--;
				head ++;
			}
			int count = tail - head + 1;
			if (count < min) {
				min = count;
			}
		}
		
		return min;
	}
	
	private static boolean isFull(int[] colors) {
		int temp = 1;
		for (int i = 0; i < colors.length; i++) {
			temp *= colors[i];
		}
		return temp != 0 ? true : false;
	}

}
