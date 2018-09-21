package string2int;
/**
 * 将字符串转化为整数
 * @author cy
 *
 */

public class String2Int {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String src = "-123";
		int radix = 10;
		int srcInt = Integer.valueOf(src);
		System.out.println(srcInt);
		if (src == null) {
			throw new NumberFormatException("null");
		}
		int result = 0;
		boolean negative = false;
		int i = 0, max = src.length();
		int limit, multmin, digit;
		if (max > 0) {
			if (src.charAt(0) == '-') {
				negative = true;
				limit = Integer.MIN_VALUE;
				i++;
			}else {
				limit = -Integer.MAX_VALUE;
			}
			multmin = limit/10;
			if (i<max) {
				digit = Character.digit(src.charAt(i++), radix);
				if (digit<0) {
					throw new NumberFormatException();
				}
				else {
					result = -digit;
				}
			}
			while (i<max) {
				digit = Character.digit(src.charAt(i++),radix);
				if (digit < 0) {
				    
				}
				if (result < multmin) {
				   
				}
				result *= radix;
				if (result < limit + digit) {
				    
				}
				result -= digit;
			}
			
		}else {
		    throw new NumberFormatException(src);
		}
		if (negative) {
	        if (i > 1) {
	    	System.out.println(result);
	        } else {	/* Only got "-" */
	        }
	    } else {
	       System.out.println(-result);
	    }

}
}
