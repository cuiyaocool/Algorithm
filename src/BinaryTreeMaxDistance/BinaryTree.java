package binaryTreeMaxDistance;

public class BinaryTree {
	private int maxLen = 0;
	public int findMaxDistance(Node root) {
		if (null == root) {
			return 0;
		}
		if (root.leftNode == null) {
			root.leftMaxDistance = 0;
		}
		if (root.rightNode == null) {
			root.rightMaxDistance = 0;
		}
		if (root.leftNode != null) {
			findMaxDistance(root.leftNode);
		}
		if (root.rightNode != null) {
			findMaxDistance(root.rightNode);
		}
		if (root.leftNode != null) {
			root.leftMaxDistance = Math.max(root.leftNode.leftMaxDistance, root.leftNode.rightMaxDistance) + 1;
		}
		if (root.rightNode != null) {
			root.rightMaxDistance = Math.max(root.rightNode.leftMaxDistance, root.rightNode.rightMaxDistance) + 1;
		}
		maxLen = root.leftMaxDistance + root.rightMaxDistance;
		return maxLen;
	}
}
