package binaryTreeSumIsK_offer_25;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		Node node = new Node(5);
		Node node1 = new Node(12);
		Node node2 = new Node(4);
		Node node3 = new Node(7);
		root.left = node;
		root.right = node1;
		node.left = node2;
		node.right = node3;
		BinaryTreeSumIsK_offer_25.findpath(root, 22);
	}

}
