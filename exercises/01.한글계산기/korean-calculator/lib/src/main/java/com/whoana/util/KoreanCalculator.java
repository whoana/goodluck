/**
 * LICENSE : NOOGOONA 1.0
 */
package com.whoana.util;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author whoana
 * @since 2023
 * 한글 표현 숫자 다항식을 입력받아 더하기를 수행하고 결과를 한글 표현 숫자로 표시해 줍니다.
 */
public class KoreanCalculator {
	private static char arabicZero = '영';
	private static char arabicOne = '일';
	private static Map<Character, Integer> kor2ArabicMap = new HashMap<Character, Integer>();
	private static Map<Integer, Character> arabic2KorMap = new HashMap<Integer, Character>();

	public KoreanCalculator() {
		init();
	}
	
	private void init() {
		// -------------------------------------------
		// kor2ArabicMap values
		// -------------------------------------------
		{
			kor2ArabicMap.put('영', 0);
			kor2ArabicMap.put('일', 1);
			kor2ArabicMap.put('이', 2);
			kor2ArabicMap.put('삼', 3);
			kor2ArabicMap.put('사', 4);
			kor2ArabicMap.put('오', 5);
			kor2ArabicMap.put('육', 6);
			kor2ArabicMap.put('칠', 7);
			kor2ArabicMap.put('팔', 8);
			kor2ArabicMap.put('구', 9);
			kor2ArabicMap.put('십', 10);
			kor2ArabicMap.put('백', 100);
			kor2ArabicMap.put('천', 1000);
			kor2ArabicMap.put('만', 10000);
			kor2ArabicMap.put('억', 100000000);
		}
		// -------------------------------------------
		// arabic2KorMap values
		// -------------------------------------------
		{
			arabic2KorMap.put(0        , '영');
			arabic2KorMap.put(1        , '일');
			arabic2KorMap.put(2        , '이');
			arabic2KorMap.put(3        , '삼');
			arabic2KorMap.put(4        , '사');
			arabic2KorMap.put(5        , '오');
			arabic2KorMap.put(6        , '육');
			arabic2KorMap.put(7        , '칠');
			arabic2KorMap.put(8        , '팔');
			arabic2KorMap.put(9        , '구');
			arabic2KorMap.put(10       , '십');
			arabic2KorMap.put(100      , '백');
			arabic2KorMap.put(1000     , '천');
			arabic2KorMap.put(10000    , '만');
			arabic2KorMap.put(100000000, '억');
		}
	}

	/**
	 * 한글 표현 숫자들의 더하기 다항식을 계산하여 결과 값을 한글 표현 숫자로 리턴합니다.
	 * <block>
	 * 	<pre>
	 * 	example)
	 * 		KoreanCalculator kc = new KoreanCalculator();
	 * 		String param = "백이십 + 팔십";
	 * 		String result = kc.calculate(param);
	 * 		System.out.printf("%s = %s", param, result);
	 * 	</pre>
	 * </block>
	 * @param param String 예: "백이십 + 팔십"
	 * @return String 한글표현 숫자 값 예 : "이백"
	 * @throws Exception
	 * @author whoana
 	 * @since 2023
	 */
	public String calculate(String param) throws Exception {

		List<Integer> numbers = toNumbers(param);
		int sum = 0;
		for (Integer num : numbers) {
			sum += num;
		}
		return toKorNumber(sum);
	}

	/**
	 * 아라비아숫자를 한글표시 숫자로 변환합니다. 
	 * 예) 999 -> 구백구십구
	 * @param num 변환할 숫자
	 * @return
	 * @throws Exception
	 */
	public String toKorNumber(int num) throws Exception {
		String str = Integer.toString(num);	
		char[] chs = str.toCharArray();
		int pos = 1;
		String number = "";
		for(int i = chs.length - 1 ; i >= 0 ; i --){
			char ch = arabic2KorMap.get(Integer.parseInt(chs[i] + ""));
			if(ch != arabicZero){
				if(pos == 1){
					number = String.valueOf(ch).concat(number);	
				}else if(pos <= 1000){
					number = ((ch == arabicOne) ? 
					    String.valueOf(arabic2KorMap.get(pos)) :
						String.valueOf(ch) + String.valueOf(arabic2KorMap.get(pos))).concat(number);	
				}else{
					throw new Exception("본 한글 계산기는 일만 이상의 결과 값을 가지는 연산 기능은 제공하지 않습니다.");
				}  
			}
			pos = pos * 10;
		}
		return number;
	}
	
	/**
	 * 한글숫자와 더하기 연산자로 구성된 다항식에서 한글 숫자를 아라비아 숫자로 변환하여 리스트로 생성해 줍니다.
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<Integer> toNumbers(String param) throws Exception {
		
		if(param == null || param.trim().length() == 0) 
			throw new Exception("입력값이 NULL 이거나 공백입니다.");
		
		StringTokenizer st = new StringTokenizer(param, "+");
		if(st.countTokens() <= 1) 
			throw new Exception("입력값의 연산항이 2개 이상이어야 더하기 연산이 가능합니다.");
		
		List<Integer> numbers = new ArrayList<Integer>();
		
		while(st.hasMoreTokens()) {
			String korNum = st.nextToken().trim();
			Integer num = toNumber(korNum);
			numbers.add(num);
		}
		
		return numbers;
	}
	
	/**
	 * 	한글표현 숫자를 아라비아 숫자로 변경합니다.
	 * @param korNum
	 * @return
	 * @throws Exception
	 */
	public Integer toNumber(String korNum) throws Exception{
		int number = 0;
		int multiple = 1;
		char[] chars = korNum.toCharArray();
		for (int i = 0 ; i < chars.length ; i ++) {
			char ch = korNum.charAt(i);
			if(!kor2ArabicMap.containsKey(ch)) throw new Exception(ch +" 는 올바른 숫자가 아닙니다.");
			if(isUnitNumber(ch)) {
				number += multiple * kor2ArabicMap.get(ch);
				multiple = 1;
			}else {
				multiple = kor2ArabicMap.get(ch);
				if(i == chars.length - 1) {
					number += multiple;
				}
			}
		}
		
		return number;
	}
	
	/**
	 * 캐릭터 표현 숫자값이 단위 숫자 10, 100, 1000 ... 인지 체크합니다.
	 * @param ch
	 * @return
	 */
	private boolean isUnitNumber(char ch) {
		return (ch == '십' || ch == '백' || ch == '천' || ch == '만' || ch == '억');
	}
}
