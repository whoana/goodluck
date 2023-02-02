package com.example.main;

public class NeverEndingMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("type Ctrl+c for breaking this program.");
        Thread.sleep(Integer.MAX_VALUE);         
    }

}
