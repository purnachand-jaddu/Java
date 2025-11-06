package com.test.library;

import inc.fabric.repository.DefaultTenantConfigurationRepository;
import inc.fabric.repository.IProductConfigurationRepository;
import inc.fabric.repository.ISubscriptionConfigurationRepository;
import inc.fabric.repository.models.daos.SubscriptionDataModel;
import inc.fabric.repository.models.dtos.EventData;
import inc.fabric.repository.models.dtos.SubscriptionConfiguration;
import inc.fabric.repository.models.dtos.SubscriptionDetail;
import inc.fabric.repository.models.dtos.SubscriptionInfo;
import inc.fabric.repository.models.dtos.SubscriptionStatus;
import inc.fabric.repository.models.dtos.TenantConfiguration;
import inc.fabric.repository.models.dtos.auth.AuthorizationDetail;
import inc.fabric.repository.models.dtos.auth.AuthorizationType;
import inc.fabric.security.ISecurityStrategy;
import inc.fabric.security.SimpleSecurityStrategy;
import inc.fabric.security.keystrategies.IKeyStrategy;
import inc.fabric.security.keystrategies.RoundRobinStrategy;
import inc.fabric.security.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Component
public class UtilService {

  private static final DateTimeFormatter dateTimeFormatter =
      ISODateTimeFormat.dateTimeNoMillis().withZoneUTC();

  @Autowired private DefaultTenantConfigurationRepository tenantConfigurationRepository;

  @Autowired private IProductConfigurationRepository productConfigurationRepository;

  @Autowired private ISubscriptionConfigurationRepository subscriptionConfigurationRepository;

  @Autowired private ISecurityStrategy strategy = new SimpleSecurityStrategy();

  @Autowired private IKeyStrategy keyStrategy = new RoundRobinStrategy();

  @Autowired private DynamoDbEnhancedClient enhancedClient;

  public UtilService() {}

  public void createAuthTenantSubscription(
      String tenantId, String eventType, String specVersion, String url) {
    String currentTime = dateTimeFormatter.print(System.currentTimeMillis());
    String encryptedValue = encryptString(tenantId, eventType, currentTime, "dpp-12345678");
    SubscriptionDetail detail = new SubscriptionDetail();
    detail.setTargetUrl(url);
    detail.setDeliveryType("WEBHOOK");
    AuthorizationDetail authDetail = new AuthorizationDetail();
    authDetail.setType(AuthorizationType.API_KEY);
    authDetail.setConfig(Map.of("apiKeyName", "x-api-key", "apiKeyValue", encryptedValue));
    detail.setAuthorizationDetails(authDetail);
    SubscriptionConfiguration config = new SubscriptionConfiguration("TestSubscription", detail);
    config.setCreatedAt(currentTime);
    config.setUpdatedAt(currentTime);
    tenantConfigurationRepository.addSubscription(
        config,
        SubscriptionStatus.ACTIVE,
        tenantId,
        Set.of(EventData.builder().eventType(eventType).specVersion(specVersion).build()));
  }

  public void createAuthTenantSubscriptionWithoutEncryption(
          String tenantId, String eventType, String specVersion, String url) {
    String currentTime = dateTimeFormatter.print(System.currentTimeMillis());
    SubscriptionDetail detail = new SubscriptionDetail();
    detail.setTargetUrl(url);
    detail.setDeliveryType("WEBHOOK");
    AuthorizationDetail authDetail = new AuthorizationDetail();
    authDetail.setType(AuthorizationType.API_KEY);
    authDetail.setConfig(Map.of("apiKeyName", "x-api-key", "apiKeyValue", "dpp-12345678"));
    detail.setAuthorizationDetails(authDetail);
    SubscriptionConfiguration config = new SubscriptionConfiguration("TestSubscription", detail);
    config.setCreatedAt(currentTime);
    config.setUpdatedAt(currentTime);
    tenantConfigurationRepository.addSubscription(
            config,
            SubscriptionStatus.ACTIVE,
            tenantId,
            Set.of(EventData.builder().eventType(eventType).specVersion(specVersion).build()));
  }

  public void createOauthProductSubscription(
      String domain,
      String tenantId,
      String eventType,
      String specVersion,
      String url,
      SubscriptionStatus status,
      String clientId,
      String clientSecret,
      String authorizationUrl,
      String accessTokenKey,
      String resourceTokenKey) {
    String currentTime = dateTimeFormatter.print(System.currentTimeMillis());
    SubscriptionDetail detail = new SubscriptionDetail();
    detail.setTargetUrl(url);
    detail.setDeliveryType("WEBHOOK");
    AuthorizationDetail authDetail = new AuthorizationDetail();
    Map<String, String> authConfig = new HashMap<>();
    authConfig.put("clientId", clientId);
    authConfig.put("clientSecret", clientSecret);
    authConfig.put("authUrl", authorizationUrl);
    authConfig.put("accessTokenKey", accessTokenKey);
    authConfig.put("resourceTokenKey", resourceTokenKey);
    authDetail.setType(AuthorizationType.OAUTH2);
    authDetail.setConfig(authConfig);
    detail.setAuthorizationDetails(authDetail);
    SubscriptionConfiguration config = new SubscriptionConfiguration("SearchSubscription", detail);
    config.setCreatedAt(currentTime);
    config.setUpdatedAt(currentTime);
    productConfigurationRepository.addSubscription(
        config, status, tenantId, eventType, specVersion, domain);
  }

  private String encryptString(
      String tenantId, String eventType, String currentTime, String toBeEncrypted) {
//    byte[] bytes = Utils.generateKeyHash(tenantId, eventType, currentTime, keyStrategy);
//    return strategy.getEncryptedValue(toBeEncrypted, bytes);
    return "";
  }

  public void deleteSubscriptionId(String tenantId, String subscriptionId) {
    tenantConfigurationRepository.deleteSubscription(tenantId, subscriptionId);
  }

  public void deleteAllSubscriptions(String tenantId) {
    DynamoDbTable<SubscriptionDataModel> table = enhancedClient.table("SubscriptionConfigurations", TableSchema.fromBean(SubscriptionDataModel.class));
    List<TenantConfiguration> tenantConfigurations =
        tenantConfigurationRepository.getTenantConfigurations(tenantId);
    for (TenantConfiguration tenantConfiguration : tenantConfigurations) {
      for (SubscriptionInfo subscription : tenantConfiguration.getSubscriptions()) {
//        tenantConfigurationRepository.deleteSubscription(
//            tenantId, subscription.getSubscriptionId());
        table.deleteItem(Key.builder().partitionValue(subscription.getSubscriptionId()).sortValue("TENANT").build());
      }
    }
  }

  public void updateWebhookUrl(String tenantId, String eventType, String version, String url) {
//    TenantConfiguration tenantConfiguration =
//        tenantConfigurationRepository.getTenantConfiguration(tenantId, eventType, version);
//    for (SubscriptionInfo subscription : tenantConfiguration.getSubscriptions()) {
//      SubscriptionConfiguration tenantSubscription =
//          subscriptionConfigurationRepository.getTenantSubscription(
//              subscription.getSubscriptionId());
//      tenantSubscription.getData().setTargetUrl(url);
//      subscriptionConfigurationRepository.addTenantSubscription(tenantSubscription);
//    }
  }

  //      public void test(){
  //          SubscriptionConfiguration<String> sub1 = createSubscription("sub1","subName1",
  // "data1");
  //          SubscriptionConfiguration<String> sub2 = createSubscription("sub2", "subName2",
  //   "data2");
  //          SubscriptionConfiguration<String> sub3 = createSubscription("sub3", "subName3",
  //   "data3");
  //          SubscriptionConfiguration<String> sub4 = createSubscription("sub4", "subName4",
  //   "data4");
  //          EventData ed1 =
  //   EventData.builder().eventType("loyalty:member:created").specVersion("v1").build();
  //          EventData ed2 =
  //   EventData.builder().eventType("loyalty:member:updated").specVersion("v1").build();
  //          EventData ed3 =
  //   EventData.builder().eventType("loyalty:member:deleted").specVersion("v1").build();
  //          tenantConfigurationRepository.addSubscription(sub1, SubscriptionStatus.ACTIVE,
  //   "TENANT1", Set.of(ed1,ed2));
  //          tenantConfigurationRepository.addSubscription(sub2, SubscriptionStatus.ACTIVE,
  //   "TENANT1", Set.of(ed2,ed3));
  //          tenantConfigurationRepository.addSubscription(sub3, SubscriptionStatus.ACTIVE,
  //   "TENANT2", Set.of(ed1));
  //          tenantConfigurationRepository.addSubscription(sub4, SubscriptionStatus.INACTIVE,
  //   "TENANT3", Set.of(ed2));
  //
  //          List<TenantConfiguration> tenantConfigurations1 =
  //   tenantConfigurationRepository.getTenantConfigurations("TENANT1");
  //          System.out.printf("Tenant configurations for %s : %s", "TENANT1\n",
  //   gson.toJson(tenantConfigurations1));
  //          List<TenantConfiguration> tenantConfigurations2 =
  //   tenantConfigurationRepository.getTenantConfigurations("TENANT2");
  //          System.out.printf("Tenant configurations for %s : %s", "TENANT2\n",
  //   gson.toJson(tenantConfigurations2));
  //          List<TenantConfiguration> tenantConfigurations3 =
  //   tenantConfigurationRepository.getTenantConfigurations("TENANT3");
  //          System.out.printf("Tenant configurations for %s : %s", "TENANT3\n",
  //   gson.toJson(tenantConfigurations3));
  //
  //
  //
  //  //        tenantConfigurationRepository.updateSubscription(sub1, SubscriptionStatus.INACTIVE,
  //   "TENANT1", Set.of(ed3));
  //
  //          SubscriptionConfiguration<Object> subscriptionConfiguration1 =
  //   tenantConfigurationRepository.getSubscriptionById("TENANT1", sub2.getSubscriptionId());
  //          System.out.printf("Subscription for %s: %s\n", "TENANT1",
  //   gson.toJson(subscriptionConfiguration1));
  //
  //
  //          tenantConfigurationRepository.deleteSubscription("TENANT1", sub1.getSubscriptionId());
  //          tenantConfigurationRepository.deleteSubscription("TENANT1", sub2.getSubscriptionId());
  //
  //      }
  //
  //      @NotNull
  //      private SubscriptionConfiguration<String> createSubscription(String subId, String subName,
  //   String data) {
  //          SubscriptionConfiguration<String> sub1 = new SubscriptionConfiguration<>();
  //          sub1.setSubscriptionId(subId);
  //          sub1.setSubscriptionName(subName);
  //          sub1.setData(data);
  //          return sub1;
  //      }
}
