package org.mentoring.dao.utils;

import org.mentoring.dto.Event;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;
import java.util.function.Predicate;

@Component
public class DaoUtils {

    public Predicate<Event> getEventByIdPredicate(int id) {
        return event -> event.getId() == id;
    }

    public void initStorage(Set<Event> storage) {
        storage.add(new Event(1, "JavaDay", "Epam", "Maxim", "Conf", LocalDate.now()));
        storage.add(new Event(2, "JavaNight", "Club", "Alex", "Party", LocalDate.now()));
    }

    public Event update(Event oldEvent, Event newEvent) {
        oldEvent.setTitle(newEvent.getTitle());
        oldEvent.setPlace(newEvent.getPlace());
        oldEvent.setSpeaker(newEvent.getSpeaker());
        oldEvent.setEventType(newEvent.getEventType());
        oldEvent.setDateTime(newEvent.getDateTime());
        return oldEvent;
    }
}
