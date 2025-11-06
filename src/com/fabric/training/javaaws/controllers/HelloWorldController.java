package com.fabric.training.javaaws.controllers;

import io.opentracing.Span;
import io.opentracing.util.GlobalTracer;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  private static int counter = 0;

  private List<String> ids  = List.of("id1","id2","id3","id4","id5","id6","id7","id8","id9","id10");

  @GetMapping(path = "/layer1")
  public String invokeLayer1() throws InterruptedException {
    Thread.sleep(1000);
    Span span = GlobalTracer.get().activeSpan();
    span.setTag("id",ids.get(counter));
    counter++;
    return "HelloWorld";
  }

  @GetMapping(path = "/layer2")
  public String invokeLayer2() throws InterruptedException {
    Thread.sleep(2000);
    Span span = GlobalTracer.get().activeSpan();
    span.setTag("ids", ids.toString());
    return "HelloWorld";
  }

}
