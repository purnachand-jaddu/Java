package com.test.library.test;

import com.test.library.UtilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.test.library", "inc.fabric"})
public class Main implements CommandLineRunner {

  @Autowired private UtilService test;

  private List<String> tenantIds = List.of("tenant1");

  List<String> eventTypes = List.of("loyalty:member:created");

  List<String> versions = List.of("v1");

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
              "https://webhook.site/af2a67bd-6dd7-435e-9e56-02c492a25aeb");
        }
      }
    }
  }
}
