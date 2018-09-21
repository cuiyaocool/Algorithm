package delRepeatedElementsInLinkedList;

/**
 * 如果不允许使用临时的缓存(即不能使用额外的存储空间)，
 * 那需要两个指针， 当第一个指针指向某个元素时，
 * 第二个指针把该元素后面与它相同的元素删除， 时间复杂度O(n2 )
 * @author cy
 *
 */
public class DelRepeatedEleInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedNode tailLinkedNode = new LinkedNode(1,null);
		LinkedNode node1 = new LinkedNode(2,tailLinkedNode);
		LinkedNode node2 = new LinkedNode(2,node1);
		LinkedNode node3 = new LinkedNode(3,node2);
		LinkedNode tempLinkedNode = node3;
		while (tempLinkedNode!=null) {
			System.out.print(tempLinkedNode.value + " ");
			tempLinkedNode = tempLinkedNode.next;
		}
		System.out.println();
		LinkedNode headLinkedNode = delRepeatedEle(node3);
		while (headLinkedNode!=null) {
			System.out.print(headLinkedNode.value + " ");
			headLinkedNode = headLinkedNode.next;
		}
	}

	/**
	 * 每次去除一个元素的重复元素
	 */
	private static LinkedNode delRepeatedEle(LinkedNode node3) {
		
		LinkedNode headLinkedNode = node3;
		LinkedNode p = headLinkedNode, q;
		while (headLinkedNode!=null) {
			int t = headLinkedNode.value;
			p =headLinkedNode;
			q = p.next;
			while (q!=null) {
				if (q.value == t) {
					p.next = q.next;
					q = q.next;
				}else {
					p = q;
					q = q.next;
				}
			}
			headLinkedNode = headLinkedNode.next;
		}
		// TODO Auto-generated method stub
		return node3;
	}

}
