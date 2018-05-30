package reverseSingleList;

/**
 * ͨ�����ַ�����ɷ�ת
 * 1��ͨ���ݹ�
 * 2��ͨ������
 * 
 * �ݹ��Ƿ�ת��ǰ�ڵ�ʱ����ʹ�ú���Ľ�㷴ת
 * 
 * �������Ǵ�ǰ���
 * 
 * @author Administrator
 *
 */
public class ReserveSingleList {

	//�ݹ�
	/**
	 * ����Ҳ��Ҫ�Ͽ�����
	 * ���磺 a b c ,����Ҫ����a,����Ҫ�ȴ���b���Ƴ����ȴ���c��
	 * c���أ�Ȼ��b.next��c, ��b.next.next = b;
	 * Ȼ���ַ���һ������ȥ�û���c����ʱ����a,a.next��b����a.next.next = a ,���a.next = null,��,����c
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
	//����
	/**
	 * ���ﷸ�Ĵ�����ʹ�ø���������һ�����Ծ�����ע�͵�������p.next = next;
	 * ֮ǰ����ǣ�a b c ���㣬a Ϊ��һ���㣬Ȼ��a.next = c;  b.next = a;  ���������������ŵģ��������ǣ��ҿ���һֱ�ߣ�
	 * �������ֻ�е�һ���ڵ㵽����󣬾���ð��һ����һ��ֻ�����һ����ͬʱ��b����һ��֮���ͷ��㣬�൱�ڳ��� b c a, ��ô������һ�˾�û�����ˣ����߾��� c a b ������ȷ
	 * ���ԣ���ȷ˼·��
	 * �������ϣ�ÿ��ʹ�ú�һ��ָ��ǰһ��
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
		//ԭʼֵ
		ListNode p = l0;
		while (p != null) {
			System.out.print(p.data + "  ");
			p = p.next;
		}
		System.out.println();
		//�ݹ鷴ת
		p = reverseSingleList2(l0);
		while (p != null) {
			System.out.print(p.data + "  ");
			p = p.next;
		}
		System.out.println();
		//������תΪԭʼֵ
		p = reverseSingleList(l3);
		while (p != null) {
			System.out.print(p.data + "  ");
			p = p.next;
		}
	}
}
