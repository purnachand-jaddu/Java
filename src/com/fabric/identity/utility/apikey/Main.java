package com.test.utility.apikey;

public class Main {
  //  private static List<String> tenantIds = List.of("63a123070cf218e178efda30");
  //  private static List<String> eventTypes =
  //      List.of(
  //          "offers:price-list:created",
  //          "offers:price-list:updated",
  //          "offers:price-list:deleted",
  //          "offers:coupon:created",
  //          "offers:coupon:deleted",
  //          "offers:coupon:updated",
  //          "offers:coupon:enabled",
  //          "offers:coupon:disabled",
  //          "offers:promo:created",
  //          "offers:promo:deleted",
  //          "offers:promo:updated",
  //          "offers:global-exclusion:created",
  //          "offers:global-exclusion:deleted",
  //          "offers:global-exclusion:updated",
  //          "offers:coupon:activated",
  //          "offers:coupon:deactivated",
  //          "offers:promo:activated",
  //          "offers:promo:deactivated");
  //
  //  private static String webhookUrl =
  // "https://webhook.site/e4eaed82-f0ee-4b20-a1d1-3b3c35dcd98f";
  //
  //  private static String apiKeyValue = "dpp-12345678";
  //
  //  private static String webhookData =
  //      """
  //                      {
  //                          "deliveryType": "WEBHOOK",
  //                          "deliveryConfig": {
  //                            "invocationEndpointUrl": "%s",
  //                            "httpMethod": "POST",
  //                            "authorisationType": "API_KEY",
  //                            "authConfig": {
  //                              "apiKeyName": "x-api-key",
  //                              "apiKeyValue": "%s"
  //                            }
  //                          }
  //                        }
  //                  """;
  //
  //  private static ISecurityStrategy securityStrategy = new SimpleSecurityStrategy();
  //
  //  private static IKeyStrategy keyStrategy = new RoundRobinStrategy();
  //
  //  private static DynamoDbClient dbClient =
  //      DynamoDbClient.builder()
  //          .endpointOverride(URI.create("https://dynamodb.us-east-1.amazonaws.com"))
  //          .region(Region.US_EAST_1)
  //          .credentialsProvider(
  //              DefaultCredentialsProvider.builder().profileName("multichannel-stg").build())
  //          .build();
  //
  //  private static DynamoDbEnhancedClient enhancedClient =
  //      DynamoDbEnhancedClient.builder().dynamoDbClient(dbClient).build();
  //
  //  public static void main(String[] args) {
  //    Set<String> uniqueTenants = new HashSet<>(tenantIds);
  //    Set<String> uniqueEvents = new HashSet<>(eventTypes);
  //    System.out.printf("Num tenants: %s\n", uniqueTenants.size());
  //    System.out.printf("Num events:  %s\n", uniqueEvents.size());
  //    System.out.printf(
  //        "Total number of configurations: %s\n", uniqueEvents.size() * uniqueTenants.size());
  //    int numUpdatesNeeded = uniqueTenants.size() * uniqueEvents.size();
  //    int numUpdatesMade = 0;
  //    DynamoDbTable<TenantConfiguration> table =
  //        enhancedClient.table(
  //            "TenantConfigurations", TableSchema.fromBean(TenantConfiguration.class));
  //    String createdAt =
  //        ISODateTimeFormat.dateTimeNoMillis().withZoneUTC().print(System.currentTimeMillis());
  //    System.out.println(createdAt);
  //    for (String tenantId : uniqueTenants) {
  //      for (String eventType : uniqueEvents) {
  //        String encryptedApiKeyValue = encrypt(apiKeyValue, tenantId, eventType, createdAt);
  //        System.out.printf("%s:%s:%s:%s\n", tenantId, eventType, createdAt,
  // encryptedApiKeyValue);
  //        String data = webhookData.formatted(webhookUrl, encryptedApiKeyValue);
  //        TenantConfiguration tenantConfiguration = new TenantConfiguration();
  //        tenantConfiguration.setTenantId(tenantId);
  //        tenantConfiguration.setEventType(eventType);
  //        tenantConfiguration.setStatus(SubscriptionStatus.ACTIVE);
  //        tenantConfiguration.setCreatedAt(createdAt);
  //        tenantConfiguration.setUpdatedAt(createdAt);
  //        tenantConfiguration.setCreatedBy("Purnachand");
  //        tenantConfiguration.setUpdatedBy("Purnachand");
  //        tenantConfiguration.setData(data);
  //        try {
  //          table.putItem(tenantConfiguration);
  //          numUpdatesMade = numUpdatesMade + 1;
  //        } finally {
  //          System.out.printf("Done with %s and %s\n\n", tenantId, eventType);
  //        }
  //      }
  //    }
  //    if (numUpdatesNeeded != numUpdatesMade) {
  //      throw new IllegalStateException();
  //    }
  //  }
  //
  //  private static String encrypt(String value, String tenantId, String eventType, String
  // createdAt) {
  //    String tenantHash = tenantId + "-" + eventType + ":" + createdAt;
  //    byte[] bytes = keyStrategy.generateKey(tenantHash);
  //    return securityStrategy.getEncryptedCipher(value, bytes);
  //  }
}
