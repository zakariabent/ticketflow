
package com.ticketflow.eventservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String category;
    private LocalDateTime eventDate;
    private Double price;
    private Integer capacity;

    public Event() {
    }

    public Event(String name, String location, String category,
                 LocalDateTime eventDate, Double price, Integer capacity) {
        this.name = name;
        this.location = location;
        this.category = category;
        this.eventDate = eventDate;
        this.price = price;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
