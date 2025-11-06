package com.fabric.identity.repository.models.dtos;

public class SubscriptionConfiguration {
    private String subscriptionId;
    private String productId;
    private SubscriptionStatus status;
    private String name;
    private SubscriptionDetail detail;
    private String createdAt;
    private String updatedAt;

    public SubscriptionConfiguration() {
    }

    public SubscriptionConfiguration(String name, SubscriptionDetail detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubscriptionDetail getDetail() {
        return detail;
    }

    public void setDetail(SubscriptionDetail detail) {
        this.detail = detail;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
