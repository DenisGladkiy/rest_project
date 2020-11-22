package org.mentoring.service;

import org.mentoring.dto.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);

    Event updateEvent(Event event);

    Event getEvent(int id);

    void deleteEvent(int id);

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);
}
