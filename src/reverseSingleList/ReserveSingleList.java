package reverseSingleList;

public class ReserveSingleList {

	public static ListNode reverseSingleList(ListNode head) {
		ListNode p = head;
		if (p == null || p.next == null) {
			return p;
		}
		ListNode backNode = reverseSingleList(p.next);
		p.next.next = p;
		p.next = null;
		return backNode;
	}
	
	public static ListNode reverseSingleList2(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode p = head;
		ListNode curListNode = p.next;
		ListNode next;
		while (curListNode != null) {
			next = curListNode.next;
			//p.next = next;
			curListNode.next = p;
			p = curListNode;
			curListNode = next;
		}
		head.next = null;
		
		return p;
	}
	public static void main(String[] args) {
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		
		ListNode p = l0;
		while (p != null) {
			System.out.print(p.data + "  ");
			p = p.next;
		}
		System.out.println();
		p = reverseSingleList2(l0);
		while (p != null) {
			System.out.print(p.data + "  ");
			p = p.next;
		}
		System.out.println();
		p = reverseSingleList(l3);
		while (p != null) {
			System.out.print(p.data + "  ");
			p = p.next;
		}
	}
}
