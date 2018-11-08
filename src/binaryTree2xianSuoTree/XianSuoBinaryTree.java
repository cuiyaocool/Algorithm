package binaryTree2xianSuoTree;

/**
 * 二叉树线索化
 * 参考：https://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 * 
 * O(1)空间复杂度遍历二叉树
 * 
 * @author cy
 *
 */

public class XianSuoBinaryTree {

	public static class Node {
		int value;
		Node left;
		Node right;

		public Node(int v) {
			// TODO Auto-generated constructor stub
			value = v;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;

		/**
		 * ...........1
		 * .......2....... 3
		 * .. 4......... 5.... 6
		 */

		// O(1)空间复杂度中序遍历二叉树，
		System.out.println("O(1)空间复杂度中序遍历二叉树");
		inorderMorrisTraversal(n1);

		// O(1)空间复杂度先序遍历二叉树，
		System.out.println("O(1)空间复杂度先序遍历二叉树");
		preorderMorrisTraversal(n1);

		// O(1)空间复杂度后序遍历二叉树，
		System.out.println("O(1)空间复杂度后序遍历二叉树");
		postorderMorrisTraversal(n1);
	}

	// O(1)空间复杂度后序遍历二叉树，
	private static void postorderMorrisTraversal(Node n) {
		// TODO Auto-generated method stub
		Node temp = new Node(0);
		temp.left = n;
		Node cur = temp;
		Node pre = null;
		while (cur != null) {
			if (cur.left == null) {
				cur = cur.right;
			}else {
				pre = cur.left;
				while (pre.right != cur && pre.right != null) {
					pre = pre.right;
				}
				
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				}else {
					printReverse(cur.left, pre);
					pre.right = null;
					cur = cur.right;
				}
			}
		}
	}

	private static void printReverse(Node curleft, Node pre) {
		// TODO Auto-generated method stub
		reverse(curleft, pre);
		Node p = pre;
		while (true) {
			System.out.print(p.value + " ");
			if (p == curleft) {
				break;
			}
			p = p.right;
		}
		reverse(curleft, pre);
		
	}

	private static void reverse(Node curleft, Node pre) {
		// TODO Auto-generated method stub
		Node from = curleft, nextNode = curleft.right, nnext;
		while (from != pre) {
			nnext = nextNode.right;
			nextNode.right = from;
			from = nextNode;
			nextNode = nnext;
		}
	}

	// O(1)空间复杂度先序遍历二叉树，
	private static void preorderMorrisTraversal(Node n) {
		// TODO Auto-generated method stub
		Node cur = n;
		Node pre = null;
		while (cur != null) {
			if (cur.left == null) {
				System.out.print(cur.value + " ");
				cur = cur.right;
			} else {
				pre = cur.left;
				while (pre.right != cur && pre.right != null) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = cur;
					System.out.print(cur.value + " ");
					cur = cur.left;
				} else {
					pre.right = null;
					cur = cur.right;
				}
			}
		}
		System.out.println();

	}

	// O(1)空间复杂度中序遍历二叉树，
	private static void inorderMorrisTraversal(Node n) {
		// TODO Auto-generated method stub
		Node cur = n;
		Node pre = null;
		while (cur != null) {
			if (cur.left == null) {
				System.out.print(cur.value + " ");
				cur = cur.right;
			} else {
				pre = cur.left;
				while (pre.right != cur && pre.right != null) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				} else {
					pre.right = null;
					System.out.print(cur.value + " ");
					cur = cur.right;
				}
			}
		}
		System.out.println();
	}

}
