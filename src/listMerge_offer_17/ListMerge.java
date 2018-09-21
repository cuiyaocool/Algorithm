package listMerge_offer_17;


public class ListMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(1);
		Node n2 = new Node(3);
		Node n3 = new Node(5);
		Node n4 = new Node(6);
		Node n5 = new Node(9);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		Node o1 = new Node(2);
		Node o2 = new Node(4);
		Node o3 = new Node(6);
		Node o4 = new Node(7);
		o1.next = o2;
		o2.next = o3;
		o3.next = o4;
		
		Node mergeNode = mergeList(o1,n1);
		while (mergeNode!=null) {
			System.out.println(mergeNode.value);
			mergeNode = mergeNode.next;
		}
	}

	private static Node mergeList(Node o1, Node n1) {
		// TODO Auto-generated method stub
		if (o1 == null) {
			return n1;
		}
		if (n1 == null) {
			return o1;
		}
		Node mergeNode;
		if (o1.value<n1.value) {
			mergeNode = o1;
			mergeNode.next = mergeList(o1.next, n1);
		} else {
			mergeNode = n1;
			mergeNode.next = mergeList(o1, n1.next);
		}
		return mergeNode;
	}
	

}
