package kthNodeFromEnd;

/**
 * 链表中倒数第k个结点
 * 
 * @author cy
 *
 */

public class KthNodeFromEnd {

	public static Node findKthFromEnd(Node node, int k) {
		if (node == null || k == 0) {
			return null;
		}
		Node tempNode = node;
		Node resultNode = null;
		for (int i = 0; i < k - 1; i++) {
			if (tempNode.m_pNext != null) {
				tempNode = tempNode.m_pNext;
			} else {
				return null;
			}
		}
		
		resultNode = node;
		while (tempNode.m_pNext != null) {
			tempNode = tempNode.m_pNext;
			resultNode = resultNode.m_pNext;
		}
		return resultNode;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n1.m_pNext = n2;
		n2.m_pNext = n3;
		n3.m_pNext = n4;
		n4.m_pNext = n5;
		n5.m_pNext = n6;
		n6.m_pNext = null;
		
		Node result = findKthFromEnd(n1, 3);
		System.out.print(result.m_nValue);
		result = findKthFromEnd(null, 3);
		System.out.print(result.m_nValue);
		
	}

}
