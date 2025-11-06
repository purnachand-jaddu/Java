package com.test.sleep;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Thread.sleep(15 * 1000);
    System.out.println("Application exited after some time");
  }
}
