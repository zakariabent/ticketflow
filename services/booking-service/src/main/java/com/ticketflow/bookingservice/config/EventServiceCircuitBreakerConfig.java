
package com.ticketflow.bookingservice.config;

import feign.FeignException;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configuration
public class EventServiceCircuitBreakerConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory>
    eventServiceCircuitBreakerCustomizer(
            EventServiceResilienceProperties properties) {

        return factory -> factory.configure(
                builder -> builder
                        .circuitBreakerConfig(
                                CircuitBreakerConfig.custom()
                                        .slidingWindowSize(properties.slidingWindowSize())
                                        .minimumNumberOfCalls(properties.minimumNumberOfCalls())
                                        .failureRateThreshold(properties.failureRateThreshold())
                                        .waitDurationInOpenState(properties.waitInOpenState())
                                        .permittedNumberOfCallsInHalfOpenState(
                                                properties.permittedCallsInHalfOpenState())
                                        .ignoreExceptions(
                                                FeignException.NotFound.class,
                                                FeignException.BadRequest.class)
                                        .build()
                        )
                        .timeLimiterConfig(
                                TimeLimiterConfig.custom()
                                        .timeoutDuration(properties.timeLimit())
                                        .build()
                        ),
                "EventClientgetByIdLong"
        );
    }
}
