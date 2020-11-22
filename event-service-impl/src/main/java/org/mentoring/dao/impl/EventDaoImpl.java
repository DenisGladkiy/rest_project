package org.mentoring.dao.impl;

import org.mentoring.dao.EventDao;
import org.mentoring.dao.utils.DaoUtils;
import org.mentoring.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EventDaoImpl implements EventDao {

    private Set<Event> storage;

    @Autowired
    private DaoUtils daoUtils;

    public EventDaoImpl() {
        storage = new HashSet<>();
        daoUtils.initStorage(storage);
    }

    @Override
    public Event saveEvent(Event event) {
        storage.add(event);
        return event;
    }

    @Override
    public Event updateEvent(Event newEvent) {
        return storage.stream()
                .filter(daoUtils.getEventByIdPredicate(newEvent.getId()))
                .findFirst()
                .map(oldEvent -> daoUtils.update(oldEvent, newEvent))
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Event findEvent(int id) {
        return storage.stream()
                .filter(daoUtils.getEventByIdPredicate(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void deleteEvent(int id) {
        storage.removeIf(daoUtils.getEventByIdPredicate(id));
    }

    @Override
    public List<Event> findAllEvents() {
        return List.copyOf(storage);
    }

    @Override
    public List<Event> findAllEventsByTitle(String title) {
        return storage.stream()
                .filter(event -> (event.getTitle().equals(title)))
                .collect(Collectors.toList());
    }
}
