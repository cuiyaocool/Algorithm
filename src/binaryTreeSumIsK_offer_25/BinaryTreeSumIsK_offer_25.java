package binaryTreeSumIsK_offer_25;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSumIsK_offer_25 {
	static List<Node> list = new ArrayList<Node>();
	static int sum = 0;
	public static void findpath(Node root, int k){
		
		list.add(root);
		sum+=root.value;
		
		if (sum == k) {
			printList();
			//findpath(root, k);
		}
	
		
		if (root.left!=null) {
			findpath(root.left, k);
			
		}
		
		if (root.right!=null) {
			findpath(root.right, k);
			
		}
		Node del = list.remove(list.size()-1);
		sum-=del.value;
		
	}
	private static void printList() {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).value+" ");
		}
		System.out.println();
	}
}
