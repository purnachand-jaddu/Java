package com.fabric.identity.library.pim;

import com.fabric.identity.library.UtilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.test.library", "inc.fabric"})
public class Main implements CommandLineRunner {

  @Autowired private UtilService test;

  private List<String> tenantIds = List.of("5f8eaeb7e639f70008b9f16b","60ac19ef893ab1000864b771","62604f4fec26950009532a3e");

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
              "https://webhook.site/3dba6584-8c89-4786-89b4-43a6d38baab3");
        }
      }
    }
  }
}
