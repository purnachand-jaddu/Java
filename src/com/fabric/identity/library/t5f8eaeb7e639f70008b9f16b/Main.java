package com.test.library.t5f8eaeb7e639f70008b9f16b;

import com.test.library.UtilService;
import inc.fabric.repository.models.dtos.SubscriptionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"inc.fabric","com.test.library"})
public class Main implements CommandLineRunner {

  @Autowired private UtilService util;

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    util.createAuthTenantSubscription("5f8eaeb7e639f70008b9f16b","loyalty:member:created", "v1", "https://webhook.site/af2a67bd-6dd7-435e-9e56-02c492a25aeb");
    util.createAuthTenantSubscription("5f8eaeb7e639f70008b9f16b","loyalty:member:created", "v1", "https://webhook.site/386dffc1-f137-4dbd-aabb-993308bb8c40");
//    util.createOauthProductSubscription("search",
//            "tenant1",
//            "loyalty:member:created",
//            "v1",
//            "https://webhook.site/23185ee2-c79f-4bd9-b00b-e98a6f4f85b1",
//            SubscriptionStatus.ACTIVE,
//            "0oa5bvw46poXHpRPl697",
//            "FaO6v9xeskXWupYF_Yl7fNUehi-C39tO-frqpVrh",
//            "https://copilot.login-sbx.fabric.inc/oauth2/ausopbo9srORwHcM5696/v1/token",
//            "access_token",
//            "Authorization"
//    );
  }
}
