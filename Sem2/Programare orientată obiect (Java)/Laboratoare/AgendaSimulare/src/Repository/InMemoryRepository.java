package Repository;
import Domain.*;
import Service.ServiceException;
import java.util.*;

public class InMemoryRepository<T extends Entity> implements IRepository<T> {

    private Map<String, T> storage = new HashMap<>();
    private IValidator<T> validator;

    /**
     * Constructor
     * @param validator
     */
    public InMemoryRepository(IValidator<T> validator) {this.validator = validator;}

    /**
     * Finds an event by an id
     * @param id
     * @return
     */
    public T findById(String id) {return storage.get(id);}

    /**
     * Updates/ Inserts an event
     * @param entity
     */
    public void upsert(T entity) {
        validator.validate(entity);
        storage.put(entity.getId(), entity);
    }

    /**
     * Removes an event
     * @param id
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new ServiceException("There are no entities with the given Id!");
        }
        storage.remove(id);
    }

    /**
     * Returns a list of all events
     * @return
     */
    public ArrayList<T> getAll() {
        return new ArrayList<>(storage.values());
    }
}
