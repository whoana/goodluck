package example;

import java.lang.reflect.Array;
import java.util.*;
public class koreaCalculator {
// 문자열을 + 기준으로 나누고 배열에 재저장해서 다시 string으로 변환
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		String args2 = Arrays.toString(args);
		String args3=args2.replace("[","").replace("]","");
		args2 = args2.replace("[","").replace("]","").replace("+", "");
		String resultCh,s2 ="";
		int s = Skor(args2);
		resultCh = Integer.toString(s);
		s2 = Skor2(resultCh);
			System.out.println(args3 +" = "+s2);
	}

		public static int Skor(String args2) {
			int result = 0;
			int tmpR=0;
			int num = 0;
			final String num1 = "영일이삼사오육칠팔구";
			final String UNIT = "십백";
			final long[] UNIT_NUM = {10,100};
			StringTokenizer st = new StringTokenizer(args2,UNIT,true);
			while(st.hasMoreTokens()) {
				String token= st.nextToken();
//				System.out.println(st.hasMoreTokens());
//				System.out.println(token);
				int check = num1.indexOf(token);
				//숫자, 단위 체크
				if(check==-1) {
					//단위일 경우
					 tmpR+=num;
					 System.out.println();
					 result += (tmpR != 0 ? tmpR : 1) * UNIT_NUM[UNIT.indexOf(token)];
					 tmpR=0;
					 num=0;
			
				}else {
					//숫자일 경우
						num =check;
				}
			}
	
			return result+tmpR+num;
		}
		public static String Skor2(String resultCh) {
			String [] han = {"","일","이","삼","사","오","육","칠","팔","구"};
			String [] han2 = {"","십","백"};
			StringBuffer result = new StringBuffer();
//			append를 위한 stringbuffer이용 result
			int len = resultCh.length();
			int num = 0;
			
			for(int i=len-1;i>=0;i--) {
				num = Integer.parseInt(String.valueOf(resultCh.charAt(len-i-1)));
				//char 단위로 끊어서 num에 하나씩
				result.append(han[num]);
				System.out.println(han[num]);
				result.append(han2[i%3]); //자릿수
			}

			return result.toString();
		}
			
	}



