package com.test.utility.oauth;

public class Main {
  //
  //    private static List<String> tenantIds =
  //            List.of(
  //                    "60b910a9b9d1b20008fae769",
  //                    "6209672ea36c7700110c45ba",
  //                    "60708c003dac0300070be6d9",
  //                    "614cb2978ec10b0008919d0c",
  //                    "636a9b6bf8d52000103e3a20",
  //                    "605375964934fe00086282be",
  //                    "61deeed790d559001085c24b",
  //                    "615f420c028f5d000979b15c",
  //                    "632a06a6eae5d900118ccb34",
  //                    "62096e9f43c2b7001105b5a5",
  //                    "63508dcb54ea59001122657a",
  //                    "62622a33220107001116475a",
  //                    "61c0a06ce5257700115a85c7",
  //                    "5f88b78f5159e900088a4eba",
  //                    "61ef7087d2f68100124b706d",
  //                    "61fc4e2a56b1050012bf9669",
  //                    "62095c9437d1c60011d8c3cf",
  //                    "60c91750fa8d3e000854e8ea",
  //                    "6243a5c8a4ab6700118655af",
  //                    "60b63d9e7ce90800085548cf",
  //                    "61e9c59278ceea0011249766",
  //                    "614bacaa4a74a70009d69d33",
  //                    "617c692229b61b000992a66e",
  //                    "62b9de8d9628e70011116d43",
  //                    "60f9d3d2616c7b0008862c6a",
  //                    "61bac86355d6d60011630de7",
  //                    "61a510fa37bb640009acf55e",
  //                    "62f52da75b5aa200116e93f4",
  //                    "6361859a0914340010a9ddb0",
  //                    "60ad7e9d858eb50007abbb19",
  //                    "61df3059adca6300119896fb",
  //                    "623c1baa26290c0012ae2d7f",
  //                    "619bad073a27d200096259ee",
  //                    "632dfd94b67f430014a1d3f3");
  //    private static List<String> eventTypes =
  //            List.of(
  //                    "pim:product:created",
  //                    "pim:product:updated",
  //                    "pim:product:deleted",
  //                    "pim:category:created",
  //                    "pim:category:updated",
  //                    "pim:category:deleted");
  //
  //    private static String webhookUrl = "https://us-east-1.sandbox.search.fabric.inc/events";
  //
  //    private static String authUrl =
  //            "https://copilot.login-sbx.fabric.inc/oauth2/ausopbo9srORwHcM5696/v1/token";
  //
  //    private static String clientId = "0oa5bvw46poXHpRPl697";
  //
  //    private static String clientSecret = "FaO6v9xeskXWupYF_Yl7fNUehi-C39tO-frqpVrh";
  //
  //    private static String accessTokenKey = "access_token";
  //
  //    private static String resourceTokenKey = "Authorization";
  //
  //    private static String webhookData =
  //            """
  //                  {
  //                      "deliveryType": "WEBHOOK",
  //                      "deliveryConfig": {
  //                        "invocationEndpointUrl": "%s",
  //                        "httpMethod": "POST",
  //                        "authorisationType": "OAUTH2",
  //                        "authConfig": {
  //                          "authUrl": "%s",
  //                          "clientId": "%s",
  //                          "clientSecret": "%s",
  //                          "accessTokenKey": "%s",
  //                          "resourceTokenKey": "%s"
  //                        }
  //                      }
  //                    }
  //                  """;
  //
  //    private static ISecurityStrategy securityStrategy = new SimpleSecurityStrategy();
  //
  //    private static IKeyStrategy keyStrategy = new RoundRobinStrategy();
  //
  //    private static DynamoDbClient dbClient =
  //            DynamoDbClient.builder()
  //                    .endpointOverride(URI.create("https://dynamodb.us-east-1.amazonaws.com"))
  //                    .region(Region.US_EAST_1)
  //                    .credentialsProvider(
  //
  // DefaultCredentialsProvider.builder().profileName("multichannel-sbx").build())
  //                    .build();
  //
  //    private static DynamoDbEnhancedClient enhancedClient =
  //            DynamoDbEnhancedClient.builder().dynamoDbClient(dbClient).build();
  //
  //    public static void main(String[] args) {
  //        Set<String> uniqueTenants = new HashSet<>(tenantIds);
  //        Set<String> uniqueEvents = new HashSet<>(eventTypes);
  //        System.out.printf("Num tenants: %s\n", uniqueTenants.size());
  //        System.out.printf("Num events:  %s\n", uniqueEvents.size());
  //        System.out.printf(
  //                "Total number of configurations: %s\n", uniqueEvents.size() *
  // uniqueTenants.size());
  //        int numUpdatesNeeded = uniqueTenants.size() * uniqueEvents.size();
  //        int numUpdatesMade = 0;
  //        DynamoDbTable<TenantConfiguration> table =
  //                enhancedClient.table(
  //                        "TenantConfigurations",
  // TableSchema.fromBean(TenantConfiguration.class));
  //        String createdAt =
  //
  // ISODateTimeFormat.dateTimeNoMillis().withZoneUTC().print(System.currentTimeMillis());
  //        System.out.println(createdAt);
  //        for (String tenantId : uniqueTenants) {
  //            for (String eventType : uniqueEvents) {
  //                String encryptedClientId = encrypt(clientId, tenantId, eventType, createdAt);
  //                String encryptedClientSecret = encrypt(clientSecret, tenantId, eventType,
  // createdAt);
  //                String data =
  //                        webhookData.formatted(
  //                                webhookUrl,
  //                                authUrl,
  //                                encryptedClientId,
  //                                encryptedClientSecret,
  //                                accessTokenKey,
  //                                resourceTokenKey);
  //                TenantConfiguration tenantConfiguration = new TenantConfiguration();
  //                tenantConfiguration.setTenantId(tenantId);
  //                tenantConfiguration.setEventType(eventType);
  //                tenantConfiguration.setStatus(SubscriptionStatus.ACTIVE);
  //                tenantConfiguration.setCreatedAt(createdAt);
  //                tenantConfiguration.setUpdatedAt(createdAt);
  //                tenantConfiguration.setCreatedBy("Purnachand");
  //                tenantConfiguration.setUpdatedBy("Purnachand");
  //                tenantConfiguration.setData(data);
  //                try {
  //                    table.putItem(tenantConfiguration);
  //                    numUpdatesMade = numUpdatesMade + 1;
  //                } finally {
  //                    System.out.printf("Done with %s and %s", tenantId, eventType);
  //                }
  //            }
  //        }
  //        if (numUpdatesNeeded != numUpdatesMade) {
  //            throw new IllegalStateException();
  //        }
  //    }
  //
  //    private static String encrypt(String value, String tenantId, String eventType, String
  // createdAt) {
  //        String tenantHash = tenantId + "-" + eventType + ":" + createdAt;
  //        byte[] bytes = keyStrategy.generateKey(tenantHash);
  //        return securityStrategy.getEncryptedCipher(value, bytes);
  //    }
}
