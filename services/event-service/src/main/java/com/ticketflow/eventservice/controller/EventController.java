
package com.ticketflow.eventservice.controller;

import com.ticketflow.eventservice.dto.EventResponse;
import com.ticketflow.eventservice.entity.Event;
import com.ticketflow.eventservice.repository.EventRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> getById(@PathVariable Long id) {

        return eventRepository.findById(id)
                .map(event -> ResponseEntity.ok(toResponse(event)))
                .orElse(ResponseEntity.notFound().build());
    }

    private EventResponse toResponse(Event event) {
        return new EventResponse(
                event.getId(),
                event.getName(),
                event.getLocation(),
                event.getCategory(),
                event.getEventDate(),
                event.getPrice(),
                event.getCapacity()
        );
    }
}
