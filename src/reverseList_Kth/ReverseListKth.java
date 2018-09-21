package reverseList_Kth;

/**
 * 每隔k个数反转链表，
 * 
 * 比如： 1 2 3 4 5 6 7
 * k： 3
 * result ： 3 2 1 6 5 4 7
 * 
 * @author 崔遥
 *
 */
public class ReverseListKth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		ListNode tmp = l0;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		int k = 3;
		System.out.println();
		ListNode resListNode = reserveKth(l0, k);
		while (resListNode != null) {
			System.out.print(resListNode.data + " ");
			resListNode = resListNode.next;
		}
	}

	private static ListNode reserveKth(ListNode l0, int k) {
		// TODO Auto-generated method stub
		ListNode from = l0, to = l0, fpre = null, fNext, toNext, toNextNext, tmp;
		int refer = 1;
		while (to != null) {
			while (to != null && refer < k - 1) {
				if (to.next == null) {
					return l0;
				}
				to = to.next;
				refer++;
			}
			
			refer = 1;
			toNext = to.next;
			if (toNext.next == null) {
				toNextNext = null;
			} else {
				toNextNext = toNext.next;
			}
			
			if (fpre == null) {
				l0 = toNext;
			}
			
			tmp = from;
			fNext = from.next;
			from = toNext;
			
			if (fpre != null) {
				fpre.next = from;
			}
			from.next = fNext;
			
			toNext = tmp;
			to.next = toNext;
			toNext.next = toNextNext;
			fpre = toNext;
			from = toNextNext;
			to = from;
		}
		return l0;
	}

}
