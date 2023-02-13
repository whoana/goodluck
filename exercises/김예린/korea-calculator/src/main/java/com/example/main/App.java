package com.example.main;
import java.util.Arrays;

import example.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	koreaCalculator c = new koreaCalculator();
		String args2 = Arrays.toString(args);
//		전달받은 매개변수를 string으로 변환 후 담고
		String args3=args2.replace("[","").replace("]","");
//		특수문자 제거
		args2 = args2.replace("[","").replace("]","").replace("+", "");
//		결과에 띄우기 위한 더하기 한글
		String resultCh,s2 ="";
		int s = c.Skor(args2);
//      변수 s에 Skor메소드에서 리턴된 한글 변환값을 받는다
		if(s>1000)
			System.out.println("천보다 큽니다 다시 입력하세요");
//		만약 s(더한 값)가 1000보다 크면 천보다 크다고 출력
		else {
			//그렇지 않으면 s를 String으로 다시 형변환해서 숫자를 다시 한글로 변환해주는 메소드의 매개변수로 전달하고 
			//아까 만든 결과에 듸우기 위한 한글로 된 연산과 숫자에서 한글로 변환된 s2값을 출력하여 보여준더.
			resultCh = Integer.toString(s);
			s2 = c.Skor2(resultCh);
			System.out.println(args3 +" = "+s2);
		}
    }

}
