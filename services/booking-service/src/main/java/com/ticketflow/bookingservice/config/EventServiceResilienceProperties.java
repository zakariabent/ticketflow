
package com.ticketflow.bookingservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "ticketflow.resilience.event-service")
public record EventServiceResilienceProperties(
        int slidingWindowSize,
        int minimumNumberOfCalls,
        float failureRateThreshold,
        Duration waitInOpenState,
        int permittedCallsInHalfOpenState,
        Duration timeLimit
) {
}
