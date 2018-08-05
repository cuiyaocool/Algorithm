package binaryTreeIsBalance_offer39;

public class IsBalance {
	boolean res = true;
	boolean isBalance(TreeNode node) {
		depth(node);
		return res;
	}
	int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int a = Math.max(depth(node.left), depth(node.right));
		if (Math.abs(depth(node.left) - depth(node.right)) > 1) {
			res = false;
		}
		return a + 1;
	}
}
