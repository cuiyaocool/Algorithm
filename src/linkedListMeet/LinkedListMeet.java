package linkedListMeet;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author Administrator
 * ���������Ƿ��ཻ
 * �������������ͷָ�룬�����������ܴ���
 * 1: �ж������������Ƿ��ཻ
 * 2: ����ཻ�����������ཻ�ĵ�һ���ڵ㡣
 * 
 * ������������ô�ཻ֮�������������һ���ģ�
 */
public class LinkedListMeet {

	//������,�ж��ཻ1
	public static boolean isMeet(ListNode first, ListNode second) {
		ListNode p1 = first, p2 = second;
		boolean meet = false;
		if (p1 == null || p2 == null) {
			return false;
		}
		//first�ߵ�ͷ
		while (p1.next != null) {
			p1 = p1.next;
		}
		
		//�ӵ�secondͷ�����ཻ���ʹ��second�γɻ�
		p1.next = p2;
		
		//ѭ��second������first��β�������ཻ
		while (p2.next != null) {
			if (p2.next == p1.next) {
				meet = true;
				break;
			}
			p2 = p2.next;
		}
		return meet;
	}
	
	////������,�ж��ཻ2
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
	
	//�ཻ��
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
		//��һ���ཻ�ķ���
		//meet = isMeet(l1, l4);
		/*if (meet) {
			System.out.println("�ཻ������");
		} else {
			System.out.println("bu�ཻ������");
		}*/
		//�ڶ����ཻ�ķ���
		/*meet = isMeet2(l1, l4);
		if (meet) {
			System.out.println("�ཻ������");
		} else {
			System.out.println("bu�ཻ������");
		}*/
		//�ཻ��
		ListNode node = findFirstMeetNode(l1, l4);
		System.out.println(node.data);
	}
}
