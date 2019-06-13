package Repository;

import Domain.Event;
import Domain.EventValidator;
import Domain.IValidator;
import Service.EventService;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {

    IValidator<Event> eventValidator = new EventValidator();
    IRepository<Event> eventRepository = new InMemoryRepository<>(eventValidator);
    EventService eventService = new EventService(eventRepository);

    @org.junit.jupiter.api.Test
    void findById() {
        eventRepository.upsert(new Event("1","DD","12/12/2012","11:11","00:00"));
        assertEquals("1",eventRepository.findById("1").getId());
    }

    @org.junit.jupiter.api.Test
    void upsert() {
        eventRepository.upsert(new Event("1","DD","12/12/2012","11:11","00:00"));
        assertEquals("1",eventRepository.findById("1").getId());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        eventRepository.upsert(new Event("1","DD","12/12/2012","11:11","00:00"));
        eventRepository.remove("1");
        assertEquals(true,eventRepository.getAll().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void getAll() {
        assertEquals(true,eventRepository.getAll().isEmpty());
    }
}