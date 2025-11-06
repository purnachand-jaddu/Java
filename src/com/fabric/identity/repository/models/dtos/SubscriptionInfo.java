package com.fabric.identity.repository.models.dtos;

import java.util.List;

public class SubscriptionInfo {
    private String subscriptionId;
    private List<String> features;

    public SubscriptionInfo() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }
}
