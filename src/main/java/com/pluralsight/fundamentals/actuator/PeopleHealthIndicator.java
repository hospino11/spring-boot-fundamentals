package com.pluralsight.fundamentals.actuator;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PeopleHealthIndicator implements HealthIndicator {

    private static final String MESSAGE_KEY = "PeopleService";

    @Value("${people.service.status}")
    private Boolean serviceStatus;

    @Override
    public Health health() {
        Health.Builder health;
        if (BooleanUtils.isTrue(serviceStatus)) {
            health = Health.up().withDetail(MESSAGE_KEY, "Available");
        } else {
            health = Health.down().withDetail(MESSAGE_KEY, "Not available");
        }

        return health.build();
    }
}
