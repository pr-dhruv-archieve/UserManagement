package com.soma.UserManagement.actuatorendpoints;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check();    // perform some task to get health
        if(errorCode != 0)
            return Health.down().withDetail("Error Code : ", errorCode).build();
        return Health.up().build(); //errorCode = 0
    }

    private int check() {
        // logic to check the health status
        return 0;   // for now
    }
}
