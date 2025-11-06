package com.fabric.identity.repository;

import com.fabric.identity.repository.models.dtos.EventData;
import com.fabric.identity.repository.models.dtos.SubscriptionConfiguration;
import com.fabric.identity.repository.models.dtos.SubscriptionStatus;
import com.fabric.identity.repository.models.dtos.TenantConfiguration;

import java.util.Set;

public interface ITenantConfigurationRepository {

    TenantConfiguration getTenantConfiguration(String tenantId);

    TenantConfiguration getTenantConfigurations(String tenantId);

    void deleteSubscription(String tenantId, String subscriptionId);

    void addSubscription(SubscriptionConfiguration config,
                        SubscriptionStatus status,
                        String tenantId,
                        Set<EventData> eventData);
}
