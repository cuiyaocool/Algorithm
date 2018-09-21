package reverseSentence_offer_42;

public class ReverseSentence_offer_42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence = "public static void main(String[] args).";
		System.out.println(sentence);
		String tString = reverse(sentence);
		System.out.println(tString);
	}

	private static String reverse(String sentence) {
		// TODO Auto-generated method stub
		String resString = null;
		resString = reverse(sentence, 0, sentence.length()-1);
		System.out.println(resString);
		int start = 0, end = 0;
		while (end<resString.length()) {
			if (resString.charAt(end) == ' ') {
				resString = reverse(resString, start, end - 1);
				System.out.println(resString);
				end+=1;
				start = end;
				//System.out.println(resString.charAt(start));
			}else {
				end++;
			}
		}
		resString = reverse(resString, start, end - 1);
		return resString;
	}

	private static String reverse(String sentence, int start, int end) {
		// TODO Auto-generated method stub
		if (start>=end || start < 0 || end >= sentence.length()) {
			return null;
		}
		char[] cs = sentence.toCharArray();
		while (start<end) {
			char temp = cs[start];
			cs[start] = cs[end];
			cs[end] = temp;
			start++;
			end--;
		}
		return new String(cs);
	}

}
