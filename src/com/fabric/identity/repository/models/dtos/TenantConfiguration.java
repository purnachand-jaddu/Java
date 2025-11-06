package com.fabric.identity.repository.models.dtos;

import java.util.ArrayList;
import java.util.List;

public class TenantConfiguration {
    private String tenantId;
    private String name;
    private List<SubscriptionInfo> subscriptions;

    public TenantConfiguration() {
        this.subscriptions = new ArrayList<>();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubscriptionInfo> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<SubscriptionInfo> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
