package com.fabric.identity.repository;

import com.fabric.identity.repository.models.dtos.EventData;
import com.fabric.identity.repository.models.dtos.SubscriptionConfiguration;
import com.fabric.identity.repository.models.dtos.SubscriptionStatus;
import com.fabric.identity.repository.models.dtos.TenantConfiguration;

import java.util.Set;

public class DefaultTenantConfigurationRepository implements ITenantConfigurationRepository {

    @Override
    public TenantConfiguration getTenantConfiguration(String tenantId) {
        // Stub implementation
        return new TenantConfiguration();
    }

    @Override
    public TenantConfiguration getTenantConfigurations(String tenantId) {
        // Stub implementation
        return new TenantConfiguration();
    }

    @Override
    public void deleteSubscription(String tenantId, String subscriptionId) {
        // Stub implementation
        System.out.println("Deleting subscription: " + subscriptionId + " for tenant: " + tenantId);
    }

    public void addSubscription(SubscriptionConfiguration config,
                               SubscriptionStatus status,
                               String tenantId,
                               Set<EventData> eventData) {
        // Stub implementation
        System.out.println("Adding subscription: " + config.getName() + " for tenant: " + tenantId);
    }
}
