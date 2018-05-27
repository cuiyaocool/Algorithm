package binaryTreeMaxDistance;

public class BinaryTreeMaxDistanceDemo {

	public static void main(String[] args) {
		Node rootNode = new Node(2);
		Node leftNode = new Node(1);
		Node rightNode = new Node(3);
		rootNode.leftNode = leftNode;
		rootNode.rightNode = rightNode;
		BinaryTree binaryTree = new BinaryTree();
		System.out.println("maxDistance is :");
		System.out.println(binaryTree.findMaxDistance(rootNode));
	}
}
