package findPathInBT_offer25;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(10);
		Node node1 = new Node(5);
		Node node2 = new Node(12);
		Node node3 = new Node(4);
		Node node4 = new Node(7);
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node1.right = node4;
		
		FindPathInBT findPathInBT = new FindPathInBT();
		findPathInBT.FindPath(22, 0, node);
	}

}
