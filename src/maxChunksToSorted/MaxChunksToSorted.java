package maxChunksToSorted;

import java.util.Stack;

/**
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], 
 * we split the array into some number of "chunks" (partitions), 
 * and individually sort each chunk. After concatenating them, the result equals the sorted array.
 * What is the most number of chunks we could have made?
 * For example, given [2,0,1], the method returns 0, as there can only be one chunk.
 * Analysis
 * The key to solve this problem is using a stack to track the existing chunk. Each chunk is represented a min and max number.
 * Each chunk is essentially an interval and the interval can not overlap.
 * @author cy
 * https://www.programcreek.com/2016/01/leetcode-max-chunks-to-make-sorted-java/
 */
public class MaxChunksToSorted {

	public static int maxChunksToSorted(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		int count = 0, temp = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (temp < nums[i]) {
				count++;
				temp = nums[i];
			}
		}
		return count;
	}
	
	public static int maxChunksToSorted2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Stack<Element> stack = new Stack<MaxChunksToSorted.Element>();
		
		for (int i = 0; i < nums.length; i++) {
			int max = nums[i];
			int min = nums[i];
			while (!stack.isEmpty()) {
				MaxChunksToSorted.Element temp = stack.peek(); 
				if (nums[i] <= temp.max) {
					max = Math.max(max, temp.max);
					min = Math.min(min, temp.min);
					stack.pop();
				} else {
					break;
				}
			}
			stack.push(new MaxChunksToSorted.Element(max, min));
		}
		return stack.size() - 1;
	}
	
	static class Element{
		int max;
		int min;
		public Element(int max, int min) {
			// TODO Auto-generated constructor stub
			this.max = max;
			this.min = min;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] first = {2, 0, 1};
		int[] second = {3, 1, 2, 3, 5, 4, 8, 9};
		System.out.println(maxChunksToSorted2(first));
		System.out.println(maxChunksToSorted2(second));
		System.out.println(maxChunksToSorted(first));
		System.out.println(maxChunksToSorted(second));
		
	}

}
