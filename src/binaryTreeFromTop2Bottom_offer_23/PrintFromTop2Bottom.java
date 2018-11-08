package binaryTreeFromTop2Bottom_offer_23;

/**
 * 按层次遍历二叉树
 * 
 * 按层次遍历二叉树（不完全二叉树）节点为null的需要输出null
 */
import java.util.ArrayList;
import java.util.List;

public class PrintFromTop2Bottom {

	public static class Node{
		int value;
		Node left;
		Node right;
		Node(int v){
			value = v;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(8);
		Node n2 = new Node(6);
		Node n3 = new Node(10);
		Node n4 = new Node(5);
		Node n5 = new Node(7);
		Node n6 = new Node(9);
		Node n7 = new Node(11);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		
		System.out.println("层次遍历的结果为：");
		PrintFromTop2BottomWithoutNull(n1);
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		//非完全二叉树
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node3.right = node6;
		node4.right = node7;
		
		//正常的层次遍历
		System.out.println("层次遍历的结果为：");
		PrintFromTop2BottomWithoutNull(node1);
		
		//按层次遍历二叉树（不完全二叉树）节点为null的需要输出null
		System.out.println("层次遍历的结果为：");
		PrintFromTop2BottomWithNull(node1);
		
	}
	private static void PrintFromTop2BottomWithNull(Node n) {
		// TODO Auto-generated method stub
		if (n == null) {
			return;
		}
		List<Node> list = new ArrayList<Node>();
		list.add(n);
		while (!list.isEmpty()) {
			Node tNode = list.remove(0);
			if (tNode == null) {
				System.out.print("null ");
			}else {
				System.out.print(tNode.value + " ");
				
				list.add(tNode.left);
				list.add(tNode.right);
			}
			
		}
		System.out.println();
		
	}
	private static void PrintFromTop2BottomWithoutNull(Node n) {
		// TODO Auto-generated method stub
		if (n == null) {
			return;
		}
		List<Node> list = new ArrayList<Node>();
		list.add(n);
		while (!list.isEmpty()) {
			System.out.print(list.get(0).value + " ");
			Node tNode = list.remove(0);
			if (tNode.left != null) {
				list.add(tNode.left);
			}
			if (tNode.right != null) {
				list.add(tNode.right);
			}
		}
		System.out.println();
	}

}
