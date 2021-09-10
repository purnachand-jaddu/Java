package com.mentor.training;

public class ThreadLearning {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        int counter = 0;
        MyRunnable runnable = new MyRunnable(counter);
//        Thread t1 = new Thread(runnable);
//        t1.start();
        runnable.run();
        MyRunnable runnable1 = new MyRunnable(runnable.getCounter());
        runnable1.run();
//        Thread t2 = new Thread(runnable1);
//        t2.start();
    }

    public static class MyRunnable implements Runnable {

        public int getCounter() {
            return counter;
        }

        private int counter;

        public MyRunnable(int i) {
            counter = i;
        }

        @Override
        public void run() {
            counter++;
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter);
        }
    }
}
