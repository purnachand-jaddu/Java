package com.test.library.offersdelete;

import com.test.library.UtilService;
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
      test.deleteAllSubscriptions(tenantId);
    }
  }
}
