package binaryTreeKthEle_offer_63;

/**
 * 二叉搜索树的第K个结点
 * 
 * 利用中序遍历即可
 * 
 * @author cuiyao
 *
 */
public class FindKthEle {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node tail1 = new Node(6, null, null);
		Node tail2 = new Node(8, null, null);
		Node node1 = new Node(7, tail1, tail2);
		Node tail3 = new Node(2, null, null);
		Node tail4 = new Node(4, null, null);
		Node node2 = new Node(3, tail3, tail4);
		Node head = new Node(5, node2, node1);
		InOrderVisit(head);
		System.out.println();
		//kth的作用其实就是存储计数器的，如下是找第四个结点，res才是存储最后的结果的。用int的话在findKthEle中，在左子树调用后减1，当前结点对应的k不变
		Node kth = new Node(4, null, null);
		Node res = findKthEle(head, kth);
		System.out.println(res.value);
	}

	private static Node findKthEle(Node head, Node kth) {
		// TODO Auto-generated method stub
		Node res = null;
		if (head == null || kth.value <= 0) {
			return null;
		}
		//System.out.println(head.value+" .left"+ " "+kth.value);
		res = findKthEle(head.left, kth);
		if (res == null) {
			//System.out.println(head.value + " " + kth.value);
			if (kth.value == 1) {
				res = head;
			} 
			kth.value = kth.value - 1;
		}
		if (res == null) {
			//System.out.println(head.value+" .right"+ " "+kth.value);
			res = findKthEle(head.right, kth);
		}
		return res;
	}
	
	
	private static void InOrderVisit(Node head) {
		if (head == null) {
			return;
		}
		InOrderVisit(head.left);
		System.out.print(head.value + " ");
		InOrderVisit(head.right);
	}

}
