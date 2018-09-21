package preOrder_InOrder2Tree_offer_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildTree {
	class TreeNode{
		int value;
		public TreeNode() {
			// TODO Auto-generated constructor stub
		}
		TreeNode left;
		TreeNode right;
	}
	
	private static TreeNode buildTree(int[] pre, int[] in, int ps, int pe, int ins, int ine){
		int rootValue = pre[ps];
		TreeNode node = new BuildTree().new TreeNode();
		node.value = rootValue;
		node.left = node.right = null;
		if (ps == pe) {
			if (ins == ine && pre[ps] == in[ins]) {
				return node;
			}
		}
		int index = ins;
		while (index<=ine&&in[index]!=rootValue) {
			index++;
		}
		if (index-ins>0) {
			node.left=buildTree(pre, in, ps+1, ps+(index-ins), ins, index-1);
		}
		if (index < ine) {
			node.right=buildTree(pre, in, ps+(index-ins+1), pe, index+1, ine);
		}
		return node;
		
	}
	private static void printTree(TreeNode root){
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (root == null) {
			return;
		}
		list.add(root);
		while (!list.isEmpty()) {
			TreeNode node = list.get(0);
			System.out.println(list.get(0).value+" ");
			list.remove(0);
			if (node.left!=null) {
				list.add(node.left);
			}
			if (node.right!=null) {
				list.add(node.right);
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] In = {4,7,2,1,5,3,8,6};
		TreeNode root = buildTree(pre, In, 0, pre.length-1, 0, In.length-1);
		printTree(root);
		printTreeZhizi_offer_61(root);
	}
	
	private static void printTreeZhizi_offer_61(TreeNode root){
		Stack<TreeNode> first = new Stack<BuildTree.TreeNode>();
		Stack<TreeNode> second = new Stack<BuildTree.TreeNode>();
		if (root==null) {
			return;
		}
		first.push(root);
		int j = 1;
		while (!first.isEmpty()||!second.isEmpty()) {
			TreeNode tmpNode = first.pop();
			
			if (j==1) {
				System.out.println();
				j++;
			}
			System.out.print(tmpNode.value+" ");
			if (tmpNode.left!=null) {
				second.push(tmpNode.left);
			}
			if (tmpNode.right!=null) {
				second.push(tmpNode.right);
			}
			int i = 1;
			if (first.isEmpty()) {
				
				if (i==1) {
					System.out.println();
					i++;
				}
				while (!second.isEmpty()) {
					TreeNode tmpNode2 = second.pop();
					System.out.print(tmpNode2.value+" ");
					if (tmpNode2.right!=null) {
						first.push(tmpNode2.right);
					}
					if (tmpNode2.left!=null) {
						first.push(tmpNode2.left);
					}
				}
				
				j = 1;
			}
			
		}
	}

}
