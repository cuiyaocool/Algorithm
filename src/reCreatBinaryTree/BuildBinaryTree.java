package reCreatBinaryTree;

/**
 * ��֪һ�Ŷ�������ǰ�򣨺��򣩱������к�����������У���ι�����ö�������
 * ��ǰ��Ϊ���ӣ�
 * ǰ��������У�ABCDEF
 * ����������У�CBDAEF
 * @author cuiyao
 */
public class BuildBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] preOrder = {'A', 'B', 'C', 'D', 'E', 'F'};
		char[] inOrder = {'C', 'B', 'D', 'A', 'E', 'F'};
		Node treeNode = buildTree(preOrder, inOrder);
		System.out.println(treeNode.value);
	}
	
	public static Node buildTree(char[] preOrder, char[] inOrder) {
		return buildTree(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
	}
	
	public static Node buildTree(char[] preOrder, char[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) { 
			return null;
		}
		Node node = new Node();
		node.value = preOrder[preStart];
		int temp = 0;
		for (int i = inStart; i < inOrder.length; i++) {
			if (inOrder[i] != preOrder[preStart]) {
				temp++;
			} else {
				break;
			}
		}
		node.leftChild = buildTree(preOrder, inOrder, preStart + 1, preStart + temp, inStart, inStart + temp);
		node.rightNode = buildTree(preOrder, inOrder, preStart + temp + 1, preEnd, inStart + temp + 1, inEnd);
		return node;
	}
	static class Node {
		char value;
		Node leftChild;
		Node rightNode;
	}
}