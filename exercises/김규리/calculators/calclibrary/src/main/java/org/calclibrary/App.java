package org.calclibrary;

import java.util.StringTokenizer;
/**
 * Hello world!
 *
 */
public class App
{

	/**
	 * @param args
	 */
	public static int calcLib(String str){
		// TODO Auto-generated method stub
		String[] strArr = str.split(" ");
		App toNum = new App();
		int Num1 = toNum.hangulToNum(strArr[0]);
		int Num2 = toNum.hangulToNum(strArr[2]);
		int Num3;
		if(strArr.length > 3) {
			Num3 = toNum.hangulToNum(strArr[4]);
		}else {
			Num3 = 0;
		}
		int sum = Num1 + Num2 + Num3;
		return sum;
	}

	public static int hangulToNum(String input) {
		int result = 0;
		int tempResult = 0;
		int num = 0;
		final String NUMBER = "영일이삼사오육칠팔구";
		final String UNIT = "십백";
		final int[] UNIT_NUM = {10, 100};
		StringTokenizer st = new StringTokenizer(input, UNIT, true);
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			int check = NUMBER.indexOf(token);
			if(check == -1) {
				if("십백".indexOf(token) != -1) {
					tempResult += (num != 0? num:1) * UNIT_NUM[UNIT.indexOf(token)];
				}
				num = 0;
			} else {
				num = check;
			}
		}
		return result + tempResult + num;
	}

	public static String numTohangul(int input) {
		String num = Integer.toString(input);
		String result = "";
		String[] unit = {"","십","백"};
		int n = num.length() - 1;
		for(int i = 0; i < num.length(); i++) {
			int x = num.charAt(i) - '0';

			if(read(x) != null) {
				System.out.print(read(x));
				System.out.print(unit[n]);
			}
			n--;
		}
		System.out.println();
		return result;
	}

	public static String read(int num) {
		switch(num) {
		case 1:
			return "일";
		case 2:
			return "이";
		case 3:
			return "삼";
		case 4:
			return "사";
		case 5:
			return "오";
		case 6:
			return "육";
		case 7:
			return "칠";
		case 8:
			return "팔";
		case 9:
			return "구";
		}
		return null;
	}

}