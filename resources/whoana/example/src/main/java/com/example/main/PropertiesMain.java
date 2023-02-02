package com.example.main;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * <pre>
 *  Java 설치 후 체크 
 *  Main.java
 * </pre>
 */
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
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println("properties");
        System.out.println("------------------------------------------------------------------------");
        Properties properties = System.getProperties();
        properties.list(System.out);

        System.out.println("------------------------------------------------------------------------");
        System.out.println("user defined msg property");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("my.msg=%s".concat(System.lineSeparator()), properties.getProperty("my.msg"));

    }

}