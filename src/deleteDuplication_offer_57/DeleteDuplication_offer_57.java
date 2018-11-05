package deleteDuplication_offer_57;

/**
 * 在一个排序的链表中，如何删除重复的结点？
 * @author cy
 *
 */

public class DeleteDuplication_offer_57 {
	
	public static class Node{
		int val;
		Node next; 
		public String toString(){
			return val + " ";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node();
		head.val = 1;
		Node n1 = new Node();
		head.next = n1;
		n1.val = 1;
		Node n2 = new Node();
		n1.next = n2;
		n2.val = 2;
		Node n3 = new Node();
		n2.next = n3;
		n3.val = 3;
		Node n4 = new Node();
		n3.next = n4;
		n4.val = 3;
		Node n5 = new Node();
		n4.next = n5;
		n5.val = 4;
		Node n6 = new Node();
		n5.next = n6;
		n6.val = 4;
		Node n7 = new Node();
		n6.next = n7;
		n7.val = 5;

		Node tempNode = head;
		while (tempNode!=null) {
			System.out.print(tempNode);
			tempNode = tempNode.next;
		}
		System.out.println();
		
		
		Node res = deleteDuplication(head);
		
		
		while (res!=null) {
			System.out.print(res);
			res = res.next;
		}
		System.out.println();
		System.out.println("=====方法2======");
		res = deleteDuplication2(head);
		
		
		while (res!=null) {
			System.out.print(res);
			res = res.next;
		}
	}

	private static Node deleteDuplication(Node head) {
		// TODO Auto-generated method stub
		if (head == null) {
			return null;
		}
		Node newhead = head;
		Node preNode = null;
		//找到新的头结点
		newhead = findnewhead(head);
		Node tNode = newhead;
		//递归找到新头结点之后的结点
		while (tNode != null) {
			preNode = tNode.next;
			tNode.next = findnewhead(preNode);
			tNode = tNode.next;
		}
		return newhead;
	}

	private static Node findnewhead(Node head) {
		// TODO Auto-generated method stub
		if (head == null) {
			return null;
		}
		Node temp = head;
		Node next = temp.next;
		if (next == null) {
			return temp;
		}else if (temp.val != next.val) {
			return temp;
		}else {
			while (temp.val == next.val) {
				next = next.next;
			}
			return findnewhead(next);
		}
	}
	
	//方法2：
	private static Node deleteDuplication2(Node head) {
		// TODO Auto-generated method stub
		if (head == null) {
			return null;
		}
		// 临时的头结点
		Node newhead = new Node();
		newhead.next = head;
		// 记录前驱结点
		Node pre = newhead;
		// 记录当前处理的结点
		Node node = head;
		while (node != null && node.next!=null) {
			if (node.val == node.next.val) {
				while (node.next != null && node.next.val == node.val) {
					node = node.next;
				}
				//pre.next = node.next;
			}else {
				pre.next = node;
				pre = node;
			}
			node = node.next;
		}
		return newhead.next;
	}
}
