package dajiangExam;
/**
 * 大疆考题：输入数组，每个元素表示可以往后跳的步数，求跳到最后一个位置最少几步
 * 比如：输入2，3，1，1，4，输出2，从位置0跳到位置1，再跳到最后。
 */
import java.util.Scanner;

public class Mian {
	
	static int steps = 0;
	
	public static int find(int step[], int start, int end) {
		for (int i = start; i < end; i++) {
			if (step[i] >= end && end > 0) {
				steps++;
				find(step, start, i);
				break;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int stepLong[] = new int[n], step[] = new int[n];

			for (int index = 0; index<n;index++) {
				stepLong[index] = sc.nextInt();
			}
			for (int i = 0; i < stepLong.length; i++) {
				step[i] = i + stepLong[i];
			}
			find(step,0,step.length - 1);
			System.out.println(steps--);
	}
}

