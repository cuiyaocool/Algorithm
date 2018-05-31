package number2Chinese;

/**
 * 
 * @author cuiyao 18/5/31
 * 
 * 输入钱数，转为汉字
 * 
 *
 */
public class Number2Chinese {

	public static final String[] chineseNum = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
	
	public static final String[] chineseUnitSection = {"","万", "亿", "万亿"};
	
	public static final String[] chineseUnitChar = {"", "十", "百", "千"};
	
	public static String transferNum(int num) {
		String unit;
		String chString = "";
		boolean isNeedZero = false;
		int unitPos = 0;
		if (num == 0) {
			return "零";
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
            return "零";
        while (num > 0) {
            strIns = "";
            int section = num % 10000;
            if (needZero) {
                chnStr = chineseNum[0] + chnStr;
            }
            // 添加节权（万，亿）
            strIns += (section != 0) ? chineseUnitSection[unitPos] : chineseUnitSection[0];
            chnStr = strIns + chnStr;
            // 以万为单位，求万以内的权位
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
                    zero = true;// zero确保不会出现多个零
                    chnStr = chineseNum[v] + chnStr;
                }
            } else {
                zero = false;
                strIns = chineseNum[v]; // 此位置对应等中文数字
                strIns += chineseUnitChar[unitPos];// 此位置对应的权位
                chnStr = strIns + chnStr;
            }
            unitPos++;
            section = section / 10;
        }
        return chnStr;
    }

}
