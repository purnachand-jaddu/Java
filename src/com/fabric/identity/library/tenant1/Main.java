package com.test.library.tenant1;

import com.test.library.UtilService;
import inc.fabric.repository.ITenantConfigurationRepository;
import inc.fabric.repository.models.dtos.EventData;
import inc.fabric.repository.models.dtos.SubscriptionConfiguration;
import inc.fabric.repository.models.dtos.SubscriptionDetail;
import inc.fabric.repository.models.dtos.SubscriptionStatus;
import inc.fabric.repository.models.dtos.TenantConfiguration;
import inc.fabric.repository.models.dtos.auth.AuthorizationDetail;
import inc.fabric.repository.models.dtos.auth.AuthorizationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootApplication(scanBasePackages = {"inc.fabric","com.test.library"})
public class Main implements CommandLineRunner {

    @Autowired private UtilService util;

    @Autowired private ITenantConfigurationRepository tenantConfigurationRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        util.createAuthTenantSubscription("60ad7e9d858eb50007abbb19","offers:bulk-upload:completed", "v1", "https://webhook.site/ea4636d4-8f70-45e6-8bdb-830825505010");
        SubscriptionDetail subscriptionDetail = new SubscriptionDetail();
        subscriptionDetail.setDeliveryType("WEBHOOK");
        subscriptionDetail.setTargetUrl("https://webhook.site/214803be-c064-440d-a7ed-20c6340f10e6");
        AuthorizationDetail authorizationDetail = new AuthorizationDetail();
        authorizationDetail.setConfig(
                Map.of("apiKeyName", "x-api-key", "apiKeyValue", "dpp-12345678")
        );
        authorizationDetail.setType(AuthorizationType.API_KEY);
        subscriptionDetail.setAuthorizationDetails(authorizationDetail);
        SubscriptionConfiguration subscriptionConfiguration = new SubscriptionConfiguration("PimSubByPhanindra", subscriptionDetail);
        EventData v1 = EventData.builder().specVersion("v2").eventType("pim:product:updated").build();
        EventData v2 = EventData.builder().specVersion("v2").eventType("pim:category:deleted").build();
        EventData v3 = EventData.builder().specVersion("v2").eventType("pim:product:created").build();
        EventData v4 = EventData.builder().specVersion("v2").eventType("pim:category:created").build();
        EventData v5 = EventData.builder().specVersion("v2").eventType("pim:category:updated").build();
        EventData v6 = EventData.builder().specVersion("v2").eventType("pim:product:deleted").build();
        tenantConfigurationRepository.addSubscription(subscriptionConfiguration, SubscriptionStatus.ACTIVE, "609ac75051f11a0007cf38b3", Set.of(v1,v2,v3,v4,v5,v6));
        System.out.println();
    }
}
