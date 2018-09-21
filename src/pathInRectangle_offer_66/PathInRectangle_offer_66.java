package pathInRectangle_offer_66;

/**
 * �û��ݷ�������е�·��
 * 
 * �жϾ������Ƿ����һ�����������ַ��������ַ���·�����ɴ�����һ��ʼ�������������ߡ�
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
