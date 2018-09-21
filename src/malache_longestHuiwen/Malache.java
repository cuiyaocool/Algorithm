package malache_longestHuiwen;

public class Malache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String string = "hjiukuilpliukuijhop";
		findLongestHuiwen(string);
	}

	private static void findLongestHuiwen(String string) {
		// TODO Auto-generated method stub
		char[] cs = preDo(string);
		int[] Length = new int[string.length()*2+1];
		int id = 0, toRight = 0, center = 0, maxLen = 0;
		for (int i = 0; i < Length.length; i++) {
			Length[i] = i < toRight ? Math.min(Length[2*id-i], toRight - i) : 1;
			int temp = i;
			int k = 1;
			while(temp-k>=0 && temp+k<cs.length && cs[temp-k] == cs[temp+k]){
				Length[i]++;
				k++;
			}
			if (Length[i]>toRight) {
				id = i;
				toRight = Length[i];
				center = i;
				maxLen = toRight;
			}
			
		}
		System.out.println("Length at every index is: ");
		for (int i = 0; i < Length.length; i++) {
			System.out.print(Length[i]+" ");
		}
		System.out.println();
		System.out.println("中心是字符 ： "+ string.charAt(center/2));
		System.out.println("length is:　" + (maxLen - 1));
		System.out.println("result is : " + string.substring((center-maxLen+1)/2, (center+maxLen-1)/2));
	}

	private static char[] preDo(String string) {
		// TODO Auto-generated method stub
		char[] cs = new char[string.length()*2+1];
		for (int i = 0; i < string.length(); i++) {
			cs[2*i] = '#';
			cs[2*i+1] = string.charAt(i);
		}
		cs[cs.length-1] = '#';
		System.out.println("String is: " + string);
		System.out.println("处理后是：");
		for (int i = 0; i < cs.length; i++) {
			System.out.print(cs[i] + " ");
		}
		System.out.println();
		return cs;
	}

}
