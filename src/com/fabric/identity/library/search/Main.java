package com.test.library.search;

import com.test.library.UtilService;
import inc.fabric.repository.models.dtos.SubscriptionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.test.library", "inc.fabric"})
public class Main implements CommandLineRunner {

  @Autowired private UtilService util;

  String accessTokenKey = "access_token";

  String resourceTokenKey = "Authorization";

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  public void run(String... args) {
    util.createOauthProductSubscription(
            "search",
            "*",
            "pim:product.item:updated",
            "v3",
            "https://us-east-1.sandbox.search.fabric.inc/events",
            SubscriptionStatus.ACTIVE,
            "0oa5bvw46poXHpRPl697",
            "FaO6v9xeskXWupYF_Yl7fNUehi-C39tO-frqpVrh",
            "https://copilot.login-sbx.fabric.inc/oauth2/ausopbo9srORwHcM5696/v1/token",
            accessTokenKey,
            resourceTokenKey
            );
  }
}
