package matrixFindANum_offer3;

/** 
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������ 
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и������� 
 *  
 * ���ɣ�����ѡȡ���������Ͻǵ����֡���������ֵ���Ҫ���ҵ����֣����ҹ��̽����� 
 * ��������ִ���Ҫ���ҵ����֣��޳�����������ڵ��У����������С��Ҫ���ҵ����֣��޳�����������ڵ��С� 
 * Ҳ����˵���Ҫ���ҵ����ֲ�����������Ͻǣ���ÿ���ζ�������Ĳ��ҷ�Χ���޳����л���һ�У�����ÿһ����������С 
 * ���ҵķ�Χ��ֱ���ҵ�Ҫ���ҵ����֣����߲��ҷ�ΧΪ�ա� 
 * 
 * @param matrix �����ҵ����� 
 * @param number Ҫ���ҵ��� 
 * @return ���ҽ����true�ҵ���falseû���ҵ� 
 */  
public class MatrixFindNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {  
                {1, 2, 8, 9},  
                {2, 4, 9, 12},  
                {4, 7, 10, 13},  
                {6, 8, 11, 15}  
        };  
		System.out.print(find(matrix, 7));
		System.out.print(find(matrix, 5));
		System.out.print(find(matrix, 32));
	}
	public static boolean find(int[][] matrix, int num) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int row = 0;
		int col = rows - 1;
		while (row >= 0 && row < rows && col >= 0 && col < cols) {
			if (matrix[row][col] == num) { // ����ҵ��˾�ֱ���˳�  
                return true;  
            } else if (matrix[row][col] > num) { // ����ҵ�������Ҫ�ҵ�����˵��Ҫ�ҵ����ڵ�ǰ�������  
                col--; // ������һ�����������ƶ�  
            } else { // ����ҵ�������Ҫ�ҵ���С��˵��Ҫ�ҵ����ڵ�ǰ�����±�  
                row++; // ������һ�����������ƶ�  
            }  
        }  
        return false; 
	}

}
