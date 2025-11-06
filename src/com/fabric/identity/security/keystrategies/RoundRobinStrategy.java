package com.fabric.identity.security.keystrategies;

public class RoundRobinStrategy implements IKeyStrategy {

    private int currentIndex = 0;
    private String[] keys = {"key1", "key2", "key3"};

    @Override
    public String getNextKey() {
        String key = keys[currentIndex];
        currentIndex = (currentIndex + 1) % keys.length;
        return key;
    }
}
