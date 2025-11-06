package com.mentor.training.multithreading;

public class DaemonThread {

    public static void main(String[] args) {
        Thread t1= new Thread(() -> {
            System.out.println("Thread running");
        });

        t1.setDaemon(true);

        t1.start();
        System.out.println(t1.isDaemon());
    }
}
