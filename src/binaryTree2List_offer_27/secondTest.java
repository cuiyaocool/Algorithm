package binaryTree2List_offer_27;

/**
 * ¡∑œ∞‘Ÿ–¥“ª±È
 * 
 * @author cuiyao
 *
 */
public class secondTest {
	static class Node{
		int value;
		Node left;
		Node right;
		public Node(int v) {
			// TODO Auto-generated constructor stub
			value = v;
			left = right = null;
		}
		public Node(int v, Node l, Node r) {
			// TODO Auto-generated constructor stub
			value = v;
			left  = l;
			right  = r;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
	}
	static Node listHead = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node headNode = new Node(5);
		Node leftNode = new Node(2);
		Node rightNode = new Node(6);
		Node node1 = new Node(1);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		headNode.left = leftNode;
		headNode.right = rightNode;
		leftNode.left = node1;
		leftNode.right = node2;
		node2.right = node3;
		Inorder(headNode);
		System.out.println();
		
		toList(headNode);
		//System.out.println(listHead.value);
		while (listHead!=null) {
			System.out.println(listHead.value + " ");
			listHead = listHead.left;
		}
	}
	private static void toList(Node headNode) {
		// TODO Auto-generated method stub
		if (headNode == null) {
			return;
		}
		
		toList(headNode.left);
		headNode.left = listHead;
		listHead = headNode;
		toList(headNode.right);
	}
	
	
	private static void Inorder(Node head) {
		if (head == null) {
			return;
		}
		Inorder(head.left);
		System.out.print(head.value + " ");
		Inorder(head.right);
	}
}




