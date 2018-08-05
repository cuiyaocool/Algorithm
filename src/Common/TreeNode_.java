package Common;

public class TreeNode_<T> {
	private T value;
	private TreeNode_<T> left;
	private TreeNode_<T> right;
	public TreeNode_() {
		
	}
    public TreeNode_(T value) {
		this.value = value;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public TreeNode_<T> getLeft() {
		return left;
	}
	public void setLeft(TreeNode_<T> left) {
		this.left = left;
	}
	public TreeNode_<T> getRight() {
		return right;
	}
	public void setRight(TreeNode_<T> right) {
		this.right = right;
	}
    
}
