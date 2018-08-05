package verifySquenceOfBST_offer24;

/**
 * 验证一个序列是不是二叉搜索树的后序遍历
 * @author cuiyao
 *
 */
public class VerifySquenceOfBST {
	
	public boolean VerifyBST(int[] squence, int start, int end) {
		
		if (squence == null || end < 0) {
			return false;
		}
		int root = squence[end];
		//左右子树的分割点下标
		int left = start;
		for (; left < end; left++) {
			if (squence[left] > root) {
				break;
			}
		}
		int right = left;
		for (; right <= end - 1; right++) {
			if (root > squence[right]) {
				return false;
			}
		}
		boolean leftResult = true;
		boolean rightResult = true;
		if (left - 1 > 0) {
			leftResult = VerifyBST(squence, 0, left - 1);
		}
		if (end - 1 > left) {
			rightResult = VerifyBST(squence, left, end - 1);
		}
		
		
		return leftResult && rightResult;
	}

}
