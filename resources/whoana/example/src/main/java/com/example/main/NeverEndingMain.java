package com.example.main;

public class NeverEndingMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("type Ctrl+c for breaking this program.");

        System.out.println("I'm " + Thread.currentThread().getName());
        
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("I'm " + Thread.currentThread().getName());
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) { 
                }   
            }

        }).start();
        
    }
 

}
