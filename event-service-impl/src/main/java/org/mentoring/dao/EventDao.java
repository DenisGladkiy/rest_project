package org.mentoring.dao;

import org.mentoring.dto.Event;

import java.util.List;

public interface EventDao {

    Event saveEvent(Event event);

    Event updateEvent(Event event);

    Event findEvent(int id);

    void deleteEvent(int id);

    List<Event> findAllEvents();

    List<Event> findAllEventsByTitle(String title);
}
