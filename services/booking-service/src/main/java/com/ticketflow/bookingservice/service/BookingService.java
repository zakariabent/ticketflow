
package com.ticketflow.bookingservice.service;

import com.ticketflow.bookingservice.client.EventClient;
import com.ticketflow.bookingservice.dto.EventResponse;
import com.ticketflow.bookingservice.entity.Booking;
import com.ticketflow.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    private final EventClient eventClient;
    private final BookingRepository bookingRepository;

    public BookingService(EventClient eventClient,
                          BookingRepository bookingRepository) {
        this.eventClient = eventClient;
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    public Booking createBooking(Long eventId) {

        // Verify that the event exists through OpenFeign
        EventResponse event = eventClient.getById(eventId);

        // Save the booking only if the event exists
        Booking booking = new Booking(event.id());

        return bookingRepository.save(booking);
    }
}
