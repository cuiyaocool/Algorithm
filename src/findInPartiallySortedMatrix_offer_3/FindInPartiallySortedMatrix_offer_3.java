package findInPartiallySortedMatrix_offer_3;

public class FindInPartiallySortedMatrix_offer_3 {
	
	public static void findInPartiallySortedMatrix_offer_3(int[][] nums, int number){
		int length = nums.length;
		int rows = nums[0].length;
		
		int row = 0;
		int col = rows - 1;
		while (row < length && col >= 0) {
			if (nums[row][col] == number) {
				System.out.println("row: " + (row + 1) + "col: " + (col + 1));
				break;
			}
			if (nums[row][col] > number) {
				col--;
			} else {
				row++;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{1,3,5,7,9,67},
				        {2,5,8,9,21,68},
				        {4,6,9,10,22,69}
				       };
		findInPartiallySortedMatrix_offer_3(nums, 8);
		findInPartiallySortedMatrix_offer_3(nums, 88);
	}

}
