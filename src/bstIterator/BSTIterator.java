package bstIterator;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	 List<TreeNode> list = new ArrayList<TreeNode>(1);
	    public BSTIterator(TreeNode root) {
	        while(root!=null){
	            list.add(root);
	            root=root.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !list.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode top = list.get(list.size()-1);
	        int res = top.val;
	        top = top.right;
	        while(top!=null){
	            list.add(top);
	            top = top.right;
	        }
	        return res;
	    }

}
