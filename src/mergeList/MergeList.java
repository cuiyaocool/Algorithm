package mergeList;

public class MergeList {

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
		
		Node head= merge(n1, o1);
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public static Node merge(Node first, Node second) {
		Node p = first, q = second;
		if (p == null) {
			return q;
		} else if (q == null) {
			return p;
		}
		
		Node mergeHead = null;
		if (p.value < q.value) {
			mergeHead = p;
			mergeHead.next = merge(p.next, q);
		} else {
			mergeHead = q;
			mergeHead.next = merge(p, q.next);
		}
		return mergeHead;
	}

}
