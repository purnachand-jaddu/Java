package com.fabric.identity.security;

public class SimpleSecurityStrategy implements ISecurityStrategy {

    @Override
    public String encrypt(String data) {
        // Stub implementation
        return data;
    }

    @Override
    public String decrypt(String encryptedData) {
        // Stub implementation
        return encryptedData;
    }
}
