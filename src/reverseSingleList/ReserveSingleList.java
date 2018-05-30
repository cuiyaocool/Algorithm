package reverseSingleList;

/**
 * 通过两种方法完成反转
 * 1、通过递归
 * 2、通过遍历
 * 
 * 递归是反转当前节点时，先使得后面的结点反转
 * 
 * 遍历则是从前向后
 * 
 * @author Administrator
 *
 */
public class ReserveSingleList {

	//递归
	/**
	 * 这里也是要断开链表，
	 * 例如： a b c ,我们要处理a,则需要先处理b，推出得先处理c，
	 * c返回，然后b.next是c, 让b.next.next = b;
	 * 然后又返回一步，回去得还是c，此时处理a,a.next是b，将a.next.next = a ,最后a.next = null,结,返回c
	 * 
	 */
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
	//遍历
	/**
	 * 这里犯的错是总使得该链表连在一起，所以就有了注释掉的那行p.next = next;
	 * 之前想的是，a b c 三点，a 为第一个点，然后a.next = c;  b.next = a;  这样链表总是连着的，但问题是，我可以一直走，
	 * 但到最后只有第一个节点到了最后，就像冒泡一样，一趟只完成了一个，同时，b就是一趟之后的头结点，相当于成了 b c a, 这么看，下一趟就没法走了，再走就是 c a b ，不正确
	 * 所以，正确思路是
	 * 将链表打断，每次使得后一个指向前一个
	 * 
	 */
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
		//原始值
		ListNode p = l0;
		while (p != null) {
			System.out.print(p.data + "  ");
			p = p.next;
		}
		System.out.println();
		//递归反转
		p = reverseSingleList2(l0);
		while (p != null) {
			System.out.print(p.data + "  ");
			p = p.next;
		}
		System.out.println();
		//遍历反转为原始值
		p = reverseSingleList(l3);
		while (p != null) {
			System.out.print(p.data + "  ");
			p = p.next;
		}
	}
}
