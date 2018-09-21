package binaryTree2List_offer_27;

public class Binarytree2List {
	public static Node _Binary2List(Node head){
		Node returNode = null;
		Converter(head,returNode);
		return returNode;
		
	}
	private static void Converter(Node head, Node returNode) {
		// TODO Auto-generated method stub
		Node tNode = head;
		if (tNode==null) {
			return;
		}
		if (tNode.pre!=null) {
			Converter(tNode.pre, returNode);
		}
		head.pre=returNode;
		if (returNode!=null) {
			returNode.next = tNode;
		}
		returNode = tNode;
		if (tNode.next!=null) {
			Converter(tNode.next, returNode);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Node{
		int value;
		Node pre,next;
	}

}
