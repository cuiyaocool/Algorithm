package linkedListMeet;

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
	
	//不带环,判断相交2
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
	
	//判断是否有环
	public static boolean hasCircle(ListNode h) {
		ListNode fast = h, slow = h;
		while (fast != null && fast.next !=null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast && slow != null) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 有环情况下的相交点
	 * 相交时fast走了m圈，slow走了n圈
	 * https://www.2cto.com/kf/201708/669326.html
	 * 当fast与slow相遇时，假设slow在环内循环了n次，fast在环内循环了m次，显然m>n。
	 * 当slow指针和fast直接相遇时(定义此时的节点为相遇结点)，设slow指针走过的步长s， 那么根据fast指针的定义，其走过的步长为2s，
	 * 则2s=a + n(x+y) + x; s = a+m(x+y) + x
	 * 2s-s = (n-m)(x+y) = s = a+m(x+y) + x
	 * a = (n-2m-1)(x+y) + y; (n-2m-1 是整数)
	 * 从相遇点和头分别一起走，可以相交于环入口
	 * @param args
	 */
	public static ListNode findCircleEntry(ListNode h) {
		//改造hasCircle
		ListNode fast = h, slow = h, meetNode = null;
		while (fast != null && fast.next !=null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast && slow != null) {
				meetNode = slow;
				break;
			}
		}
		ListNode p = h;
		while (p !=null && meetNode != null) {
			if (p == meetNode) {
				return p;
			}
			p = p.next;
			meetNode = meetNode.next;
		}
		return meetNode;
	}
	
	/**
	 * 链表相交点
	 * 
	 * 在有环的情况下，两个链表都得有环，否则不相交
	 * 
	 * 链表 A 环入口为meetA，链表B环入口为meetB，若meetA==meetB，则在环外或者入口相交，否则在环内相交
	 * 
	 * @param args
	 */
	public static ListNode findCircleMeetNode(ListNode first, ListNode second) {
		ListNode p1 = first, p2 = second, meetA =null, MeetB = null;
		meetA = findCircleEntry(first);
		MeetB = findCircleEntry(second);
		if (meetA == MeetB) {
			//环外相交
			int Alen = findOneLen(first, meetA);
			int Blen = findOneLen(second, meetA);
			boolean isGt = Alen > Blen;
			int distance = isGt ? Alen - Blen : Blen - Alen;
			p1 = first;
			p2 = second;
			if (isGt) {
				while (distance >= 0) {
					first = first.next;
					distance--;
				}
			}else {
				while (distance >= 0) {
					second = second.next;
					distance--;
				}
			}
			ListNode outCircleNode = findFirstMeetNode(p1, p2);
			return outCircleNode;
		} else {
			//环内相交,从meetA开始遍历，若遇到meetB，则相交，交点就是MeetA或者MeetB都是，否则不相交
			ListNode pListNode = meetA;
			while (pListNode != null && pListNode.next != meetA) {
				if (pListNode == MeetB) {
					return MeetB;
				}
			}
			return null;
		}
	}
	
	//只相交的某一点，求长度
	public static int findOneLen(ListNode head, ListNode anyMeetNode) {
		ListNode p = head;
		int len = 0;
		while (p != null && p != anyMeetNode) {
			++len;
			p = p.next;
		}
		return len;
	}
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(9);
		ListNode l0 = new ListNode(0);
		
		l1.next = l2;
		l2.next = l3;
		l4.next = l5;
		l5.next = l3;
		
		//boolean meet;
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
		
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l2;
		
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		l9.next = l3;
		
		ListNode circleMeetNode = findCircleMeetNode(l0, l5);
		System.out.println(circleMeetNode.data);
	}
}
