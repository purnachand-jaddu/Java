package com.fabric.identity.security.utils;

public class Utils {

    public static String generateId() {
        return java.util.UUID.randomUUID().toString();
    }

    public static String encodeBase64(String data) {
        return java.util.Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String decodeBase64(String encodedData) {
        return new String(java.util.Base64.getDecoder().decode(encodedData));
    }
}
