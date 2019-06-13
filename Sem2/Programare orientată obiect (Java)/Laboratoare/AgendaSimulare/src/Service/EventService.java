package Service;

import Domain.Event;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class EventService extends IsSearchable<Event> {
    private IRepository<Event> repository;

    /**
     * Instantiates an Event service
     * @param repository
     */
    public EventService(IRepository<Event> repository) {
        this.repository = repository;
    }

    /**
     * Adds an event to the repository
     * @param id
     * @param name
     * @param date
     * @param length
     * @param startTime
     */
    public void addEvent(String id,String name,String date,String length,String startTime) {

        for (Event c : repository.getAll()) {
            if (c.getId().equals(id))
                throw new ServiceException("An event with the same ID already exists!");

            if (c.getStartTime().equals(startTime) && c.getDate().equals(date))
                throw new ServiceException("An event that starts at the same time already exists!");
        }
        Event temp = new Event(id,name,date,length,startTime);
        repository.upsert(temp);
    }

    /**
     * Removes an event from the repository
     * @param id
     */
    public void removeEvent(String id) {

        for (Event c : repository.getAll())
            if (c.getId().equals(id)) {
                repository.remove(id);
                return;
            }
        throw new ServiceException("There is no event for the given ID!");
    }

    /**
     * Returns a list of all events
     * @return
     */
    public List<Event> getAll(){
        return repository.getAll();
    }

    /**
     * Searches an event whose fields contain the given text.
     * @param text the text searched for
     * @return A list of events whose fields contain text.
     */
    public List<Event> fullTextSearch(String text) {
        List<Event> results = new ArrayList<>();
        for (Event c : repository.getAll())
            if (c.toString().contains(text))
                results.add(c);
        return results;
    }
}
