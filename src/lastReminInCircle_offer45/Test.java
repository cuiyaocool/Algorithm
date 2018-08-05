package lastReminInCircle_offer45;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LastRemin.lastRemin1(5, 3));
		System.out.println("112".compareTo("111"));
		 boolean first=true;
		    int sum=0;
		    int value=1;
		     short i=(short) 0xFFFF;
		    for (;i>=0;--i)
		    {
		        if (first)
		        {
		            value=65536;
		            sum+=value%3;
		            first=false;
		        }
		        else{
		            sum+=--value%3;
		            if (value<=0)
		            {
		                System.out.println(sum +"   ,   "+i);
		                break;
		            }
		        }
		    }
		    //return 0;
	}
}
