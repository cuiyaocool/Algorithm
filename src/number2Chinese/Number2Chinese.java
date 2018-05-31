package number2Chinese;

/**
 * 
 * @author cuiyao 18/5/31
 * 
 * ����Ǯ����תΪ����
 * 
 *
 */
public class Number2Chinese {

	public static final String[] chineseNum = {"��", "һ", "��", "��", "��", "��", "��", "��", "��", "��"};
	
	public static final String[] chineseUnitSection = {"","��", "��", "����"};
	
	public static final String[] chineseUnitChar = {"", "ʮ", "��", "ǧ"};
	
	public static String transferNum(int num) {
		String unit;
		String chString = "";
		boolean isNeedZero = false;
		int unitPos = 0;
		if (num == 0) {
			return "��";
		}
		while (num > 0) {
			int section = num % 10000;
			if (isNeedZero) {
				unit = chineseUnitSection[unitPos] + chineseNum[0];
			} else {
				unit = chineseUnitSection[unitPos];
			}
			chString = unit + chString;
			isNeedZero = (section < 1000) && (section > 0);
			chString = transferSection(section) + chString;
			num = num / 10000;
			++unitPos;
		}
		return chString;
	}
	
	public static String transferSection(int num) {
		String unit = "";
		boolean isNeedZero = false;
		int unitPos = 0;
		String chStr = "";
		while (num > 0) {
			unit = "";
			int v = num % 10;
			if (v == 0) {
				if (num == 0 || isNeedZero) {
					unit = chineseNum[0];
					chStr = unit + chStr;
					isNeedZero = false;
				} 
			} else {
				unit = chineseUnitChar[unitPos];
				chStr = chineseNum[v] + unit + chStr;
				isNeedZero = true;
			}
			num = num / 10;
			++unitPos;
		}
		return chStr;
	}
	public static void main(String[] args) {
		int[] nums = new int[]{304, 4006, 4000, 10003, 10030, 21010011, 101101101, 22111, 1910040908};
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
			System.out.println("myProgram:" + transferNum(nums[i]));
            System.out.println("othersPro:" + numberToChinese(nums[i]));
        }
	}
	//======================================================================
	public static String numberToChinese(int num) {
        String strIns;
        String chnStr = "";
        int unitPos = 0;
        boolean needZero = false;
        if (num == 0)
            return "��";
        while (num > 0) {
            strIns = "";
            int section = num % 10000;
            if (needZero) {
                chnStr = chineseNum[0] + chnStr;
            }
            // ��ӽ�Ȩ�����ڣ�
            strIns += (section != 0) ? chineseUnitSection[unitPos] : chineseUnitSection[0];
            chnStr = strIns + chnStr;
            // ����Ϊ��λ���������ڵ�Ȩλ
            chnStr = sectionToChinese(section, chnStr);
            needZero = (section < 1000) && (section > 0);
            num = num / 10000;
            unitPos++;
        }
        return chnStr;
    }
    private static String sectionToChinese(int section, String chnStr) {
        String strIns;
        int unitPos = 0;
        boolean zero = true;
        while (section > 0) {
            int v = section % 10;
            if (v == 0) {
                if (section == 0 || !zero) {
                    zero = true;// zeroȷ��������ֶ����
                    chnStr = chineseNum[v] + chnStr;
                }
            } else {
                zero = false;
                strIns = chineseNum[v]; // ��λ�ö�Ӧ����������
                strIns += chineseUnitChar[unitPos];// ��λ�ö�Ӧ��Ȩλ
                chnStr = strIns + chnStr;
            }
            unitPos++;
            section = section / 10;
        }
        return chnStr;
    }

}
