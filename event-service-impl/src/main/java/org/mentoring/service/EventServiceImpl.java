package org.mentoring.service;

import org.mentoring.dao.EventDao;
import org.mentoring.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Override
    public Event createEvent(Event event) {
        return eventDao.saveEvent(event);
    }

    @Override
    public void updateEvent(Event event) {
        eventDao.updateEvent(event);
    }

    @Override
    public Event getEvent(int id) {
        return eventDao.findEvent(id);
    }

    @Override
    public void deleteEvent(int id) {
        eventDao.deleteEvent(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDao.findAllEvents();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return eventDao.findAllEventsByTitle(title);
    }
}
