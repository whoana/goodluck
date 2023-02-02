package com.example.main;

import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class PropertiesMain {

    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("args");
        System.out.println("------------------------------------------------------------------------");
        for (String arg : args) {
            System.out.println(arg);
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println("env");
        System.out.println("------------------------------------------------------------------------");
        Map<String, String> env = System.getenv();
        Set<String> keys = env.keySet();
        for (String key : keys) {
            System.out.printf("%s = %s".concat(System.lineSeparator()), key, env.get(key));
            // 변수 여러개를 쓰기 위하여
            // lineSeparator() 함수는 os에 상관없이 new line을 얻어오기 위해 사용하는 함수
            //환경변수의 키값과 그 value값을 꺼낸것
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println("properties");
        System.out.println("------------------------------------------------------------------------");
        Properties properties = System.getProperties(); //자바를 실행할때 줫던 환경변수값을 꺼냄
        //default 값으로 지정된 값들을 모두 꺼내옴

        properties.list(System.out);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("user defined msg property");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("my.msg=%s".concat(System.lineSeparator()), properties.getProperty("my.msg"));
            //getproperties를 꺼내오고 내가 지정한 key값도 가져옴
            //기준위치를 정하기 위해 따로 개인이 키값을 지정
            
    }

}