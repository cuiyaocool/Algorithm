package ziFuChuangPaiLie_offer28;

/**
 * input abc output:
 * abc
 * acb
 * bac
 * bca
 * cba
 * cab
 * @author Administrator
 *
 */
public class ZiFuChuangPaiLie {
	
	char[] chs;
	public ZiFuChuangPaiLie(char[] cs) {
		chs = cs;
	}
	
	void Permutation() {
		Permutation(chs, 0);
	}

	public void Permutation(char[] cs, int i) {
		// TODO Auto-generated method stub
		if (cs == null || i < 0 || i >= cs.length) {
			return;
		}
		if (i == cs.length - 1) {
			PrintChars();
		}
		int index = i;
		while (index != chs.length) {
			char c = chs[i];
			chs[i] = chs[index];
			chs[index] = c;
			Permutation(cs, i + 1);
			c = chs[i];
			chs[i] = chs[index];
			chs[index] = c;
			++index;
		}
	}
	
	private void PrintChars() {
		for (int i = 0; i < chs.length; i++) {
			System.out.print(chs[i] + "");
		}
		System.out.println();
	}

}
