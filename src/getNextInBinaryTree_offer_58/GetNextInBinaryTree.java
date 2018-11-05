package getNextInBinaryTree_offer_58;
/**
 * 题目：给定一棵二叉树和其中的一个结点，
 * 如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父节点的指针
 * 
 * 解题思路
 * 如果一个结点有右子树，那么它的下一个结点就是它的右子树中的左子结点。
 * 也就是说右子结点出发一直沿着指向左子结点的指针，我们就能找到它的下一个结点。
 * 
 * 接着我们分析一个结点没有右子树的情形。如果结点是它父节点的左子结点，那么它的下一个结点就是它的父结点。
 * 
 * 如果一个结点既没有右子树，并且它还是它父结点的右子结点，这种情形就比较复杂。
 * 我们可以沿着指向父节点的指针一直向上遍历，直到找到一个是它父结点的左子结点的结点。如果这样的结点存在，
 * 那么这个结点的父结点就是我们要找的下一个结点。
 * @author cy
 *
 */

public class GetNextInBinaryTree {
	
	 private static class BinaryTreeNode {
	        private char val;
	        private BinaryTreeNode left;
	        private BinaryTreeNode right;
	        private BinaryTreeNode parent;
//	        public BinaryTreeNode() {
//	        }
	        public BinaryTreeNode(char val) {
	            this.val = val;
	        }
	        @Override
	        public String toString() {
	            return val + " ";
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode b1 = new BinaryTreeNode('a');
		BinaryTreeNode b2 = new BinaryTreeNode('b');
		BinaryTreeNode b3 = new BinaryTreeNode('c');
		BinaryTreeNode b4 = new BinaryTreeNode('d');
		BinaryTreeNode b5 = new BinaryTreeNode('e');
		BinaryTreeNode b6 = new BinaryTreeNode('f');
		BinaryTreeNode b7 = new BinaryTreeNode('g');
		BinaryTreeNode b8 = new BinaryTreeNode('h');
		BinaryTreeNode b9 = new BinaryTreeNode('i');
		
		b1.left = b2;
		b1.right = b3;
		
		b2.left = b4;
		b2.right = b5;
		
		b3.left = b6;
		b3.right = b7;
		
		b5.left = b8;
		b5.right = b9;
		
		b2.parent = b1;
		b3.parent = b1;
		b4.parent = b2;
		b5.parent = b2;
		b6.parent = b3;
		b7.parent = b3;
		b8.parent = b5;
		b9.parent = b5;
		
		InOrderTree(b1);
		
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("node" + ": " + b1 + "  next is : " + getNext(b1));
		System.out.println("node" + ": " + b3 + "  next is : " + getNext(b3));
		System.out.println("node" + ": " + b7 + "  next is : " + getNext(b7));
		System.out.println("node" + ": " + b8 + "  next is : " + getNext(b8));
		
		/**
		 * d b h e i a f c g 
		 * -------------------------
		 * node: a   next is : f 
		 * node: c   next is : g 
		 * node: g   next is : null
		 * node: h   next is : e 
		 */
	}

	private static BinaryTreeNode getNext(BinaryTreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return null;
		}
		
		if (node.right != null) {
			BinaryTreeNode temp = node.right;
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp;
		}
		
		
		if (node.parent != null && node.parent.left == node && node.right == null) {
			return node.parent;
		}
		
		if (node.parent != null && node.parent.right == node && node.right == null) {
			BinaryTreeNode temp = node.parent;
			while (temp.parent != null && temp.parent.left != temp) {
				temp = temp.parent;
			}
			if (temp.parent == null) {
				return null;
			}else {
				return temp.parent;
			}
		}
		return null;
	}

	private static void InOrderTree(BinaryTreeNode b1) {
		// TODO Auto-generated method stub
		if (b1 == null) {
			return;
		}
		InOrderTree(b1.left);
		System.out.print(b1);
		InOrderTree(b1.right);
	}

}
