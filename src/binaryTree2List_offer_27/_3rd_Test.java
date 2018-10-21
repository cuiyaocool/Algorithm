package binaryTree2List_offer_27;

public class _3rd_Test {
	
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
	
	public static Node _Binary2List(Node head){
		Node returNode = null;
		Converter(head,returNode);
		return returNode;
		
	}
	private static void Converter(Node head, Node returNode) {
		if (head == null) {
			return;
		}
		Converter(head.left, returNode);
		head.left = returNode;
		if (returNode!=null) {
			returNode.right = head;
		}
		returNode = head;
		Converter(head.right, returNode);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
