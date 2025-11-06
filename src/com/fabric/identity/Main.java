package com.test;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriUtils;

public class Main {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) throws InterruptedException, IOException {
//    //    String text = "tenantId63ed3ba40cf2665bcd638839propertycountrymediumwebregion";
//    //    System.out.println(String.valueOf(LongHashFunction.xx3().hashChars(text)));
//    HttpUrl url1 =
//        HttpUrl.parse(
//            "https://gnc_dev:6j6G7%40oGdOm*Yr%5EP@gnc-ca.pwa.corralive.com/api/pim-webhook?key=HsJ01fCCHVqkems7BTRW");
//    System.out.println("Needed password " + url1.encodedPassword());
//    System.out.println(url1.password());
//    HttpUrl url2 =
//        HttpUrl.get(
//            "https://gnc_dev:6j6G7%40oGdOm*Yr%5EP@gnc-ca.pwa.corralive.com/api/pim-webhook?key=HsJ01fCCHVqkems7BTRW");
//    System.out.println(url2.password());
//    URI uri =
//        URI.create(
//            "https://gnc_dev:6j6G7%40oGdOm*Yr%5EP@gnc-ca.pwa.corralive.com/api/pim-webhook?key=HsJ01fCCHVqkems7BTRW");
//    HttpUrl url3 = HttpUrl.get(uri);
//    System.out.println(url3.password());
//    URI uri2 =
//        URI.create(
//            "https://gnc_dev:6j6G7%2540oGdOm%2AYr%255EP@gnc-ca.pwa.corralive.com/api/pim-webhook?key=HsJ01fCCHVqkems7BTRW");
//    HttpUrl url4 = HttpUrl.get(uri2);
//    System.out.println(url4.username());
//    System.out.println(url4.password());
//
//    String userInfo = uri.getUserInfo();
//    String s = UriUtils.encodeUserInfo(userInfo, StandardCharsets.UTF_8);
//    System.out.println(s);
//
//    Request request =
//        new Request.Builder()
//            .url(
//                "https://gnc_dev:6j6G7%40oGdOm*Yr%5EP@gnc-ca.pwa.corralive.com/api/pim-webhook?key=HsJ01fCCHVqkems7BTRW")
//            .post(RequestBody.create("{\"a\":\"b\"}".getBytes(StandardCharsets.UTF_8)))
//            .addHeader("a", "dpp")
//            .addHeader("Content-Type", "application/json; charset=utf-8")
//            //            .addHeader("Authorization", "Basic " + "Z25jX2Rldjo2ajZHN0BvR2RPbSpZcl5Q")
//            .build();
//    OkHttpClient okHttpClient = new OkHttpClient();
//    Response response = okHttpClient.newCall(request).execute();
//    System.out.println(response.body().string());
//    response.close();
//    System.out.println(
//        ISODateTimeFormat.dateTimeNoMillis().withZoneUTC().print(System.currentTimeMillis()));
    List<String> a = List.of("A", "B");
    System.out.println(String.join(",",a));
  }
}
