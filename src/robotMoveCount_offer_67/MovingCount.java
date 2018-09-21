package robotMoveCount_offer_67;


public class MovingCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = new int[2][2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				nums[i][j] = 0;
			}
		}
		int count = countMovingStep(nums,0,0,1);
		System.out.println(count);
	}

	private static int countMovingStep(int[][] nums,int i, int j, int k) {
		// TODO Auto-generated method stub
		int count = 0;
		if (Check(nums,i,j,k)) {
			count++;
			nums[i][j] = 1;
			count+=(countMovingStep(nums, i+1, j, k)+countMovingStep(nums, i-1, j, k)+
					countMovingStep(nums, i, j+1, k)+countMovingStep(nums, i, j-1, k));
			
		}
		return count;
	}

	private static boolean Check(int[][] nums, int i, int j, int k) {
		// TODO Auto-generated method stub
		if (DigtalNum(i) + DigtalNum(j) <= k && nums != null && i >=0 && i <nums.length
				&& j >= 0 && j < nums.length && nums[i][j] == 0) {
			return true;
		}
		return false;
	}

	private static int DigtalNum(int i) {
		// TODO Auto-generated method stub
		int sum = 0;
		while(i != 0){
			sum+=(i%10);
			i = i/10;
		}
		return sum;
	}
	

}
