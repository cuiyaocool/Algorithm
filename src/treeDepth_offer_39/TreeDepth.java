package treeDepth_offer_39;

public class TreeDepth {
	private static class Node{
		@SuppressWarnings("unused")
		int value;
		Node left;
		Node right;
		Node(int v) {
			this.value = v;
		}
	}
	
	private static int getDepth(Node node) {
		if (node == null) {
			return 0;
		}
		int left = getDepth(node.left);
		int right = getDepth(node.right);
		return left>right ? left + 1 : right + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(1);
		node.left = new Node(2);
		System.out.println(getDepth(node));
	}

}
