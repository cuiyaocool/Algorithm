package treeSameWithSubTree_offer_18;
/**
 * a tree include anothor tree 
 * @author cy
 *
 */
public class HaveSubTree {

	public boolean haveTree(Node big, Node small) {
		boolean res = false;
		if (big!=null && small!=null) {
			if (big.value == small.value) {
				res = doTree(big, small);
			}
			if (!res) {
				res = haveTree(big.left, small);
			}
			if (!res) {
				res = haveTree(big.right, small);
			}
		}
		return res;
	}

	private boolean doTree(Node big, Node small) {
		// TODO Auto-generated method stub
		//œ»≈–∂œsmall‘Ÿ≈–∂œbig
		if (small==null) {
			return true;
		}
		
		if (big==null) {
			return false;
		}
		
		if (big.value!=small.value) {
			return false;
		}
		return doTree(big.left, small.left)&&doTree(big.right, small.right);
	}

}
