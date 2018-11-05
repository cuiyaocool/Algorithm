package maxSlideWindow_offer_65;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 * @author cy
 *
 */
public class RedoOnlyForStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,4,2,6,2,5,1};
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		int windowSize = 3;
		System.out.println(maxInWin(list, windowSize));
	}

	private static List<Integer> maxInWin(List<Integer> data, int size) {
		// TODO Auto-generated method stub
		List<Integer> windowMax = new LinkedList<Integer>();
        // 条件检查
        if (data == null || size < 1 || data.size() < 1) {
            return windowMax;
        }
        Deque<Integer> idx = new LinkedList<Integer>();
        // 窗口还没有被填满时，找最大值的索引
        for (int i = 0; i < size && i < data.size(); i++) {
            // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
            while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
                idx.removeLast();
            }
            //  添加索引
            idx.addLast(i);
        }
        
        // 窗口已经被填满了
        for (int i = size; i < data.size(); i++) {
        	// 第一个窗口的最大值保存
            windowMax.add(data.get(idx.getFirst()));
         // 如果索引对应的值比之前存储的索引值对应的值大或者相等，就删除之前存储的值
         while (!idx.isEmpty() && data.get(i) >= data.get(idx.getLast())) {
            idx.removeLast();
         }
         // 删除已经滑出窗口的数据对应的下标
         if (!idx.isEmpty() && idx.getFirst() <= (i - size)) {
             idx.removeFirst();
         }
         // 可能的最大的下标索引入队
         idx.addLast(i);
        }
        // 最后一个窗口最大值入队
        windowMax.add(data.get(idx.getFirst()));
		return windowMax;
		
	}

}
