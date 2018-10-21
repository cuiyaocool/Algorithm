package step_add1OrDouble;

/**
 * һ�����������ᣬ�����x����3���յ���y����10����x��ʼ�ߣ�ÿ�ο�����һ������x+1������2x������������߶��ٲ���
 * @author cy
 *
 */
public class BaiduStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculateSteps(3, 10));
		Integer aInteger = new Integer(3);
		System.out.println(aInteger == 3);
		System.out.println(aInteger.equals(3));
		System.out.println(dpCalculateSteps(3, 10));
	}
	
	public static int calculateSteps(int x, int y){
		int step = 0;
		while (y/2 > x) {
			y/=2;
			step++;
		}
		step+=(y-x);
		return step;
	}
	
	public static int dpCalculateSteps(int x, int y) {
		int[] steps = new int[y+1];
		steps[x] = 0;
		for (int i = 0; i < x; i++) {
			steps[i] = Integer.MAX_VALUE-1;
		}
		for (int i = x + 1; i < y+1; i++) {
			steps[i] = Math.min(steps[i-1]+1, steps[i/2]+1);
		}
		
		return steps[y];
		
	}

}
