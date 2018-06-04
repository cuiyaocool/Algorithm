package russianDollEnvelopes;

import java.util.ArrayList;
import java.util.List;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope
 * is greater than the width and height of the other envelope.
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * 
 * This problem is similar to Longeset Increasing Subsequence.
 * @author cy
 *
 */
public class RussianDollEnvelopes {

	public static int maxEnvelopes1(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}
		int max[] = new int[envelopes.length];
		int result = 0;
		for (int i = 0; i < envelopes.length; i++) {
			max[i] = 1;
			for (int j = 0; j < i; j++) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					max[i] = Math.max(max[i], max[j] + 1);
				}
			}
			result = Math.max(result, max[i]);
		}
		return result;
	}
	
	public static int maxEnvelopes2(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < envelopes.length; i++) {
			if (list.isEmpty() || (envelopes[list.get(list.size() - 1)][0] < envelopes[i][0] && (envelopes[list.get(list.size() - 1)][1] < envelopes[i][1]))) {
				list.add(i);
			} else {
				int start = 0;
				int end = list.size() - 1;
				int mid = (start + end)/2;
				while (start < mid) {
					if (envelopes[i][0] > envelopes[mid][0] && envelopes[i][1] > envelopes[mid][1]) {
						start = mid + 1;
					} else {
						end = mid;
					}
				}
				list.set(end, i);
			}
		}
		return list.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] envelopes = {{1,2}, {3,2}, {4,5}, {4,6}, {5,7}};
		int result = maxEnvelopes1(envelopes);
		System.out.println(result);
		int result2 = maxEnvelopes2(envelopes);
		System.out.println(result2);
	}

}
