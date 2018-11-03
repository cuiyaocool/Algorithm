package reverseList_offer16;

public class RreverseList_offer16 {
	
	private static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int v, ListNode n) {
			// TODO Auto-generated constructor stub
			setValue(v);
			setNext(n);
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		
		public void setNext(ListNode next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode headListNode = new ListNode(1, null);
		ListNode two = new ListNode(2, null);
		ListNode three = new ListNode(3, null);
		ListNode four = new ListNode(4, null);
		
		headListNode.setNext(two);
		two.setNext(three);
		three.setNext(four);
		
		printList(headListNode);
		headListNode= ReverseList(headListNode);
		printList(headListNode);
	}

	private static ListNode ReverseList(ListNode headListNode) {
		if (headListNode == null) {
			return null;
		}
		// TODO Auto-generated method stub
		ListNode newHead = null;
		ListNode node= headListNode;
		ListNode next = node;
		ListNode pre = null;
		while (node != null) {
			next = next.next;
			if (next == null) {
				newHead = node;
			}
			node.next = pre;
			pre = node;
			node = next;
		}
		
		return newHead;
	}

	private static void printList(ListNode headListNode) {
		ListNode p = headListNode;
		// TODO Auto-generated method stub
		while(p != null){
			System.out.print(p.getValue()  + " ");
			p = p.next;
		}
		System.out.println();
		
	}

}
