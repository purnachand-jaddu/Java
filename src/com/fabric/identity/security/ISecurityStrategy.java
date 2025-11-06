package com.fabric.identity.security;

public interface ISecurityStrategy {

    String encrypt(String data);

    String decrypt(String encryptedData);
}
