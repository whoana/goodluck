package com.whoana.app;

import com.whoana.util.KoreanCalculator;

public class Main {
    public static void main(String[] args) {
        
        if(args.length < 1) {
            System.out.println("입력된 파라메터가 없습니다.");
            System.out.println("더하기 연산으로 구성된 한글로 표시된 숫자 다항식을 파라메터로 입력해 주세요.");
            System.out.println("예) 사용법");
            System.out.println("\t java -cp ... com.whoana.util.Main \"일 + 십\"");
            System.out.println("");
            return;
        }

        // for(int i = 0 ; i < args.length; i ++){
        //     System.out.printf("args[%d] = %s\n", i, args[i]);
        // }

        try {
            KoreanCalculator kc = new KoreanCalculator();
            String param = args[0];
            String result = kc.calculate(param);
            System.out.printf("\"%s\" 는 \"%s\" 이지롱 ~ ~ \n", param, result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
