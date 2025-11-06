package com.fabric.identity.library.autocado;

import com.fabric.identity.library.UtilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.test.library", "inc.fabric"})
public class Main implements CommandLineRunner {

  @Autowired private UtilService test;

  private List<String> tenantIds = List.of("63d3e1b25a1c0e0008c12a77");

  List<String> eventTypes =
      List.of(
          "pim:category:created",
          "pim:category:updated",
          "pim:category:deleted",
          "pim:product:created",
          "pim:product:updated",
          "pim:product:deleted");

  List<String> versions = List.of("v2");

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  public void run(String... args) {
    for (String tenantId : tenantIds) {
      for (String eventType : eventTypes) {
        for (String version : versions) {
          test.createAuthTenantSubscription(
              tenantId,
              eventType,
              version,
              "https://muzigcwyx6.execute-api.us-east-1.amazonaws.com/test/valid");
        }
      }
    }
  }
}
