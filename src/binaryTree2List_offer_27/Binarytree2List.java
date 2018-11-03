package binaryTree2List_offer_27;

/**
 * 
 * @author cuiyao
 *
 */

public class Binarytree2List {
	
	public class Node{
		int value;
		Node pre,next;
	}
	
	public static Node _Binary2List(Node head){
		Node returNode = null;
		Converter(head,returNode);
		Converter1(head, returNode);
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
	//repeated write for test
	private static void Converter1(Node head, Node returNode) {
		if (head == null) {
			return;
		}
		Node temp = head;
		if (temp.pre != null) {
			Converter1(temp.pre, returNode);
		}
		temp.pre = returNode;
		if (returNode != null) {
			returNode.next = temp;
		}
		returNode = temp;
		if (temp.next != null) {
			Converter1(temp.next, returNode);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
