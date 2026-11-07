
package com.ticketflow.bookingservice.dto;

import java.time.LocalDateTime;

public record EventResponse(
        Long id,
        String name,
        String location,
        String category,
        LocalDateTime eventDate,
        Double price,
        Integer capacity
) {
}
