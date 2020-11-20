package org.mentoring.controller;

import org.mentoring.dto.Event;
import org.mentoring.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventServiceController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping(value = "/{id}")
    public void updateEvent(@RequestBody Event event) {
        eventService.updateEvent(event);
    }

    @GetMapping(value = "/id/{id}")
    public Event getEvent(@PathVariable int id) {
        return eventService.getEvent(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/title/{title}")
    public List<Event> getAllEventsByTitle(@PathVariable String title) {
        return eventService.getAllEventsByTitle(title);
    }
}
