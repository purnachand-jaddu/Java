package com.fabric.identity.repository;

import com.fabric.identity.repository.models.dtos.SubscriptionConfiguration;
import com.fabric.identity.repository.models.dtos.SubscriptionStatus;

public interface IProductConfigurationRepository {

    void addSubscription(SubscriptionConfiguration config,
                        SubscriptionStatus status,
                        String tenantId,
                        String eventType,
                        String specVersion,
                        String domain);
}
