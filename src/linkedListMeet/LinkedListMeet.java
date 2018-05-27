package linkedListMeet;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author Administrator
 * 两个链表是否相交
 * 两个单向链表的头指针，两个链表都可能带环
 * 1: 判断这两个链表是否相交
 * 2: 如果相交，给出他们相交的第一个节点。
 * 
 * 由于是链表，那么相交之后的所有数据是一样的，
 */
public class LinkedListMeet {

	//不带环,判断相交1
	public static boolean isMeet(ListNode first, ListNode second) {
		ListNode p1 = first, p2 = second;
		boolean meet = false;
		if (p1 == null || p2 == null) {
			return false;
		}
		//first走到头
		while (p1.next != null) {
			p1 = p1.next;
		}
		
		//接到second头，若相交则会使得second形成环
		p1.next = p2;
		
		//循环second，遇到first的尾部，则相交
		while (p2.next != null) {
			if (p2.next == p1.next) {
				meet = true;
				break;
			}
			p2 = p2.next;
		}
		return meet;
	}
	
	////不带环,判断相交2
	public static boolean isMeet2(ListNode first, ListNode second) {
		ListNode p1 = first, p2 = second;
		if (p1 == null || p2 == null) {
			return false;
		}
		while (p1.next != null) {
			p1 = p1.next;
		}
		while (p2.next != null) {
			p2 = p2.next;
		}
		if (p1 == p2) {
			return true;
		}
		return false;
	}
	
	//相交点
	public static ListNode findFirstMeetNode(ListNode first, ListNode second) {
		ListNode p1 = first, p2 = second;
		int firstLen = len(p1);
		int secondLen = len(p2);
		int steps = firstLen - secondLen;
		if (steps < 0) {
			while (Math.abs(steps) > 0) {
				p1 = p1.next;
				steps++;
			}
		} else {
			while (steps > 0) {
				p2 = p2.next;
				steps--;
			}
		}
		while (true) {
			if (p1 == p2) {
				return p1;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
	}
	private static int len(ListNode node) {
		int length = 0;
		while (node != null) {
			++length;
			node = node.next;
		}
		return length;
	}
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l1.next = l2;
		l2.next = l3;
		l4.next = l5;
		l5.next = l3;
		
		boolean meet;
		//第一种相交的方法
		//meet = isMeet(l1, l4);
		/*if (meet) {
			System.out.println("相交！！！");
		} else {
			System.out.println("bu相交！！！");
		}*/
		//第二种相交的方法
		/*meet = isMeet2(l1, l4);
		if (meet) {
			System.out.println("相交！！！");
		} else {
			System.out.println("bu相交！！！");
		}*/
		//相交点
		ListNode node = findFirstMeetNode(l1, l4);
		System.out.println(node.data);
	}
}
