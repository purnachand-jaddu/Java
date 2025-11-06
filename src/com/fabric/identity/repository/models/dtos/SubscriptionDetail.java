package com.fabric.identity.repository.models.dtos;

import com.fabric.identity.repository.models.dtos.auth.AuthorizationDetail;

public class SubscriptionDetail {
    private String subscriptionId;
    private String tenantId;
    private String productId;
    private SubscriptionStatus status;
    private String targetUrl;
    private String deliveryType;
    private AuthorizationDetail authorizationDetails;

    public SubscriptionDetail() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
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

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public AuthorizationDetail getAuthorizationDetails() {
        return authorizationDetails;
    }

    public void setAuthorizationDetails(AuthorizationDetail authorizationDetails) {
        this.authorizationDetails = authorizationDetails;
    }
}
