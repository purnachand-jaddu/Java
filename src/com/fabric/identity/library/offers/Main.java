package com.test.library.offers;

import com.test.library.UtilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.test.library", "inc.fabric"})
public class Main implements CommandLineRunner {

  @Autowired private UtilService test;

  private List<String> tenantIds = List.of("63a123070cf218e178efda30");

  List<String> eventTypes =
      List.of(
          "offers:coupon:activated",
          "offers:coupon:created",
          "offers:coupon:deactivated",
          "offers:coupon:deleted",
          "offers:coupon:updated",
          "offers:price-list:created",
          "offers:price-list:deleted",
          "offers:price-list:updated",
          "offers:price:activated",
          "offers:price:created",
          "offers:price:deactivated",
          "offers:price:deleted",
          "offers:promo:activated",
          "offers:promo:created",
          "offers:promo:deactivated",
          "offers:promo:deleted",
          "offers:promo:updated",
          "offers:redemption:coupon:created",
          "offers:redemption:coupon:deleted",
          "offers:redemption:coupon:updated",
          "offers:redemption:promotion:created",
          "offers:redemption:promotion:deleted",
          "offers:redemption:promotion:updated");

  List<String> versions = List.of("v1");

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  public void run(String... args) {
    for (String tenantId : tenantIds) {
      for (String eventType : eventTypes) {
        for (String version : versions) {
//          test.updateWebhookUrl(
//              tenantId,
//              eventType,
//              version,
//              "https://webhook.site/3821f757-7ffe-4efc-ab14-432a3c9a33e7");
        }
      }
    }
  }
}
