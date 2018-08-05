package findPathInBT_offer25;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵树，求和为某一值的路径
 * @author cuiyao
 *
 */
public class FindPathInBT {
	List<Integer> list = new ArrayList<Integer>();
	public void FindPath(int sum, int currentSum, Node root) {
		if (root == null) {
			return;
		}
		boolean isLeaf = ((root.left == null) && (root.right == null));
		currentSum += root.value;
		System.out.println(currentSum + "  " + isLeaf);
		list.add(root.value);
		if (isLeaf && sum==currentSum) {
			System.out.println(list);

		}
		if (root.left != null) {
			FindPath(sum, currentSum, root.left);
		}
		if (root.right != null) {
			FindPath(sum, currentSum, root.right);
		}
		list.remove(list.size() - 1);
		currentSum -= root.value;
	}

}
