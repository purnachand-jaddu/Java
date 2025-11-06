package com.test.library.offerschicos;

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
        util.createAuthTenantSubscription("63a123070cf218e178efda30","offers:bulk-upload:completed", "v1", "https://webhook.site/eb2e3b93-0072-4ee6-b021-1687d9fa1303");
//        util.createAuthTenantSubscription("tenant1","loyalty:member:created", "v1", "https://webhook.site/386dffc1-f137-4dbd-aabb-993308bb8c40");
    }
}
