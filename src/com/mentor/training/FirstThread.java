package com.mentor.training;

public class FirstThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getId() + "jaddu");
        System.out.println(Thread.currentThread().getId() +"veera");
        System.out.println(Thread.currentThread().getId() +"venkata");
        System.out.println(Thread.currentThread().getId() +"durga");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
