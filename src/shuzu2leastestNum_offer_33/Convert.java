package shuzu2leastestNum_offer_33;

import java.util.Arrays;
import java.util.Comparator;

public class Convert{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {"3", "5", "1", "4", "2"};
        convert(data);
        String[] data2 = {"3", "32", "321"};
        convert(data2);
        String[] data3 = {"3", "323", "32123"};
        convert(data3);
        String[] data4 = {"1", "11", "111"};
        convert(data4);
        String[] data5 = {"321"};
        convert(data5);
	}
	public static void convert(String[] ss) {
		Arrays.sort(ss, new Comparator<String>() {

			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o1+o2).compareTo(o2+o1);
			}
		});
		StringBuilder builder = new StringBuilder(256);
        for (String s : ss) {
            builder.append(s);
        }
		System.out.println(builder.toString());
	}

}
