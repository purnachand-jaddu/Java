package com.example.learning.springlearnings.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello() throws InterruptedException {
    Thread.sleep(50);
    System.out.println("Hello world");
    return "Hello world";
  }

}
