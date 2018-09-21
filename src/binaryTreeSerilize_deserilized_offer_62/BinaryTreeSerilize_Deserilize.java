package binaryTreeSerilize_deserilized_offer_62;

/**
 * 序列化和反序列化
 * @author cy
 *
 */
public class BinaryTreeSerilize_Deserilize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n5 = new Node(5, null, null);
		Node n6 = new Node(6, null, null);
		Node n3 = new Node(3, n5, n6);
		Node n4 = new Node(4, null, null);
		Node n2 = new Node(2, n4, null);
		Node n1 = new Node(1, n2, n3);
		preOrder(n1);
		System.out.println();
		StringBuilder sb = new StringBuilder();
		serilize(n1, sb);
		String s = sb.toString().substring(0, sb.length() -1);
		System.out.println(s);
		int[] index = {0};
		System.out.println("反序列化顺序：");
		Node res = deserilize(s, index);
		System.out.println();
		System.out.println("result: ");
		preOrder(res);
	}

	private static Node deserilize(String s, int[] index) {
		// TODO Auto-generated method stub
		Node resNode = new Node(0, null, null);
		if (s.charAt(index[0]) != '#') {
			resNode.value = s.charAt(index[0]) - '0';
			System.out.print(resNode.value + " ");
			index[0] = index[0] + 2;
		}
		if (s.charAt(index[0]) == '#') {
			resNode.left = null;
			
		}else {
			resNode.left = deserilize(s, index);
		}
		if (s.charAt(index[0]+=2) == '#') {
			resNode.right = null;
		}else {
			resNode.right = deserilize(s, index);
		}
		return resNode;
	}

	private static void serilize(Node n1, StringBuilder sb) {
		// TODO Auto-generated method stub
		if (n1 == null) {
			sb.append("#,");
			return;
		}
		sb = sb.append(n1.value);
		sb.append(',');
		serilize(n1.left, sb);
		serilize(n1.right, sb);
	}
	
	private static void preOrder(Node head){
		if (head == null) {
			return;
		}
		System.out.print(head.value+" ");
		preOrder(head.left);
		preOrder(head.right);
	}

}
