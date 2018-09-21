package treeSameWithSubTree_offer_18;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node big = new Node(8);
		Node node1 = new Node(8);
		Node node2 = new Node(7);
		big.left = node1;
		big.right = node2;
		Node node3 = new Node(9);
		Node node4 = new Node(2);
		node1.left = node3;
		node1.right = node4;
		
		Node small = new Node(8);
		Node s1 = new Node(9);
		Node s2 = new Node(2);
		small.left = s1;
		small.right = s2;
		HaveSubTree haveSubTree = new HaveSubTree();
		boolean have = haveSubTree.haveTree(big, small);
		System.out.println(have);
	}

}
