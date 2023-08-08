package org.libertya.api.monitor;

import lombok.RequiredArgsConstructor;
import org.libertya.api.service.StartupLYService;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@Endpoint(id = "uptime")
@RequiredArgsConstructor
public class UptimeHealthContributor {

    protected final StartupLYService service;

    @ReadOperation
    public String contribute() {
        Instant startTime = service.getStartTime();
        Duration uptime = Duration.between(startTime, Instant.now());
        long seconds = uptime.getSeconds();
        long minutes = seconds / 60;
        long hours = minutes / 60;
        return hours + " horas, " + (minutes % 60) + " minutos, " + (seconds % 60) + " segundos";
    }
}
