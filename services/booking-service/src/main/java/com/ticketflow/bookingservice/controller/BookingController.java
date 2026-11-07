
package com.ticketflow.bookingservice.controller;

import com.ticketflow.bookingservice.entity.Booking;
import com.ticketflow.bookingservice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestParam Long eventId) {
        return bookingService.createBooking(eventId);
    }
}
