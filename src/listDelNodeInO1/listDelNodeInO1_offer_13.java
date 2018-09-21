package listDelNodeInO1;

public class listDelNodeInO1_offer_13 {
	
	public static class Node{
		int v;
		Node next;
		public Node(int v, Node n){
			this.v=v;
			this.next = n;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(1, null);
		Node node2 = new Node(2, node1);
		Node node3 = new Node(3, node2);
		Node node4 = new Node(4, node3);
		Node tNode = node4;
		while (tNode!=null) {
			System.out.print(tNode.v + " ");
			tNode = tNode.next;
		}
		System.out.println();
		delO1(node4, node2);
		tNode = node4;
		while (tNode!=null) {
			System.out.print(tNode.v + " ");
			tNode = tNode.next;
		}
	}
	private static void delO1(Node node4, Node node2) {
		// TODO Auto-generated method stub
		if (node4 == null || node2 == null) {
			return;
		}
		if (node2.next!=null) {
			Node temp = node2.next;
			node2.v = temp.v;
			node2.next = temp.next;
		}
		//only one node
		else if (node2==node4) {
			node2=node4=null;
		}
		//for last node
		else {
			Node tmpNode = node4;
			while (tmpNode.next!=node2) {
				tmpNode=tmpNode.next;
			}
			tmpNode.next = null;
		}
	}

}
