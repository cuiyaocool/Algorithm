package pathInRectangle_offer_66;

/**
 * 用回溯法求矩阵中的路径
 * 
 * 判断矩阵中是否存在一条包含给定字符串所有字符的路径，可从任意一格开始，往上下左右走。
 * @author cuiyao
 *
 */
public class PathInRectangle_offer_66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{'s','r','g','v'},
						{'z','h','b','p'},
						{'o','g','d','u'},
						{'t','u','a','f'}};
		boolean[][] visited = new boolean[nums.length][nums[0].length];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = false;
			}
		}
		findPath(nums, visited,"hgdafupb");
	}

	private static void findPath(int[][] nums, boolean[][] visited, String s) {
		// TODO Auto-generated method stub
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				boolean res = findpathCore(nums, visited, s, i, j, 0);
				if (res) {
					System.out.println("yes");
					return;
				}
			}
		}
		System.out.println("no");
	}

	private static boolean findpathCore(int[][] nums,
			boolean[][] visited, String s, int i, int j, int sStart) {
		// TODO Auto-generated method stub
		if (sStart == s.length()) {
			return true;
		}
		if (nums == null || visited == null || s == null || sStart<0 || sStart > s.length()
				|| i < 0 || i >= nums.length || j < 0 || j >= nums[0].length) {
			return false;
		}
		if (nums[i][j] == s.charAt(sStart) && visited[i][j] == false) {
			
			visited[i][j] = true;
			sStart++;
			
			boolean res =
				   findpathCore(nums, visited, s, i+1, j, sStart) || 
				   findpathCore(nums, visited, s, i-1, j, sStart) ||
				   findpathCore(nums, visited, s, i, j+1, sStart) ||
				   findpathCore(nums, visited, s, i, j-1, sStart) ;
			if (res) {
				return true;
			}else {
				visited[i][j] = false;
				--sStart;
			}
		}
		return false;
		
	}

}
