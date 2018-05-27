package binaryTreeMaxDistance;

public class Node {
	public int data;
	public Node leftNode;
	public Node rightNode;
	public int leftMaxDistance;
	public int rightMaxDistance;
	public Node(int data) {
		this.data = data;
		leftNode = null;
		rightNode = null;
	}
}
