package org.libertya.api.monitor;

import lombok.RequiredArgsConstructor;
import org.openXpertya.util.DB;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor
public class AppHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (DB.isConnected()) {
            return Health.up().withDetail("Connection", "OK").build();
        }
        return Health.down().withDetail("Connection", "KO").build();
    }
}
