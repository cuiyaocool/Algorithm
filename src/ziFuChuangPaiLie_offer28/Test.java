package ziFuChuangPaiLie_offer28;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] cs = {'a', 'b', 'c'};
		ZiFuChuangPaiLie ziFuChuangPaiLie = new ZiFuChuangPaiLie(cs);
		ziFuChuangPaiLie.Permutation();
		System.out.println("-------------");
		temp(cs, 0);
	}
	public static void temp(char[] cs, int start) {
//		if (cs == null || start < 0 || start >= cs.length) {
//			return;
//		}
		if (start == cs.length-1) {
			for (int i = 0; i < cs.length; i++) {
				System.out.print(cs[i]);
			}
			System.out.println();
		}
		int i = 0;
		while (start+i < cs.length) {
			
				char temp = cs[start];
				cs[start] = cs[start+i];
				cs[start+i] = temp;
				temp(cs, start+1);
				temp = cs[start];
				cs[start] = cs[start+i];
				cs[start+i] = temp;
				i++;
		}
	}

}
