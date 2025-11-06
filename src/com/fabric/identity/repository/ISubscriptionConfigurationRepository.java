package com.fabric.identity.repository;

import com.fabric.identity.repository.models.dtos.SubscriptionConfiguration;

public interface ISubscriptionConfigurationRepository {

    SubscriptionConfiguration getSubscriptionConfiguration(String subscriptionId);
}
