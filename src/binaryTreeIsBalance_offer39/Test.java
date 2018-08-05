package binaryTreeIsBalance_offer39;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node5;
		IsBalance isBalance = new IsBalance();
		boolean res = isBalance.isBalance(node1);
		System.out.println(res);
		
	}

}
