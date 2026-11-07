
package com.ticketflow.eventservice;

import com.ticketflow.eventservice.entity.Event;
import com.ticketflow.eventservice.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class EventDataInitializer {

    @Bean
    CommandLineRunner initializeEvents(EventRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Event event = new Event(
                        "Spring Cloud Conference",
                        "Casablanca",
                        "Technology",
                        LocalDateTime.of(2027, 3, 15, 10, 0),
                        250.0,
                        100
                );

                repository.save(event);
            }
        };
    }
}
