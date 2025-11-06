package com.test.authserver;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HttpPostExample {
    public static void main(String[] args) {
        try {
            // Target URL
            URL url = new URL("https://chicos.api.fabric.inc/v3/oauth2/aus2kirzi0J5K2qOd697/token");

            // Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            // Set headers
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("User-Agent", "asdasd");
            conn.setDoOutput(true);

            // Request body
            String formData = "client_id=0oa49ed752XgBseHR697" +
                              "&client_secret=knmxSs1R8wMdB69qmQ8tVMObkLQwNEl-PE5Hfzxx" +
                              "&grant_type=client_credentials" +
                              "&scope=service%20s2s";

            // Send the request
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = formData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Read the response
            int responseCode = conn.getResponseCode();
            Scanner scanner;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                scanner = new Scanner(conn.getInputStream(), StandardCharsets.UTF_8);
            } else {
                scanner = new Scanner(conn.getErrorStream(), StandardCharsets.UTF_8);
            }

            String responseBody = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
            scanner.close();

            // Output response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Body: " + responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
