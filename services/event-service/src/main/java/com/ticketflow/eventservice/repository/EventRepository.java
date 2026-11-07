
package com.ticketflow.eventservice.repository;

import com.ticketflow.eventservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
