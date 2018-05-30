package linkedListMeet;

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
	
	//������,�ж��ཻ2
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
	
	//�ж��Ƿ��л�
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
	 * �л�����µ��ཻ��
	 * �ཻʱfast����mȦ��slow����nȦ
	 * https://www.2cto.com/kf/201708/669326.html
	 * ��fast��slow����ʱ������slow�ڻ���ѭ����n�Σ�fast�ڻ���ѭ����m�Σ���Ȼm>n��
	 * ��slowָ���fastֱ������ʱ(�����ʱ�Ľڵ�Ϊ�������)����slowָ���߹��Ĳ���s�� ��ô����fastָ��Ķ��壬���߹��Ĳ���Ϊ2s��
	 * ��2s=a + n(x+y) + x; s = a+m(x+y) + x
	 * 2s-s = (n-m)(x+y) = s = a+m(x+y) + x
	 * a = (n-2m-1)(x+y) + y; (n-2m-1 ������)
	 * ���������ͷ�ֱ�һ���ߣ������ཻ�ڻ����
	 * @param args
	 */
	public static ListNode findCircleEntry(ListNode h) {
		//����hasCircle
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
	 * �����ཻ��
	 * 
	 * ���л�������£������������л��������ཻ
	 * 
	 * ���� A �����ΪmeetA������B�����ΪmeetB����meetA==meetB�����ڻ����������ཻ�������ڻ����ཻ
	 * 
	 * @param args
	 */
	public static ListNode findCircleMeetNode(ListNode first, ListNode second) {
		ListNode p1 = first, p2 = second, meetA =null, MeetB = null;
		meetA = findCircleEntry(first);
		MeetB = findCircleEntry(second);
		if (meetA == MeetB) {
			//�����ཻ
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
			//�����ཻ,��meetA��ʼ������������meetB�����ཻ���������MeetA����MeetB���ǣ������ཻ
			ListNode pListNode = meetA;
			while (pListNode != null && pListNode.next != meetA) {
				if (pListNode == MeetB) {
					return MeetB;
				}
			}
			return null;
		}
	}
	
	//ֻ�ཻ��ĳһ�㣬�󳤶�
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
