package Service;

import Domain.Event;
import Domain.EventValidator;
import Domain.IValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

    IValidator<Event> eventValidator = new EventValidator();
    IRepository<Event> eventRepository = new InMemoryRepository<>(eventValidator);
    EventService eventService = new EventService(eventRepository);

    @org.junit.jupiter.api.Test
    void addEvent() {
        eventService.addEvent("1","DD","12/12/2012","11:11","00:00");
        assertEquals(false,eventService.getAll().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void removeEvent() {
        eventService.addEvent("1","DD","12/12/2012","11:11","00:00");
        eventService.removeEvent("1");
        assertEquals(true,eventService.getAll().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        eventService.addEvent("1","DD","12/12/2012","11:11","00:00");
        eventService.removeEvent("1");
        assertEquals(true,eventService.getAll().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void fullTextSearch() {
        eventService.addEvent("1","DD","12/12/2012","11:11","00:00");
        assertEquals(true,eventService.fullTextSearch("DD").isEmpty());
    }
}