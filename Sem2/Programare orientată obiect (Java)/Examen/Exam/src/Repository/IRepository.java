package Repository;
import Domain.Entity;

import java.util.List;

public interface IRepository<T extends Entity> {

    /**
     * Gets an entity with a given id.
     * @param id the given id.
     * @return the entity with the given id.
     */
    T findById(String id);

    /**
     * Adds or replaces an entity.
     * @param entity the entity to add or replace based on its id.
     */
    void upsert(T entity);

    /**
     * Removes an entity with the given id.
     * @param id the given id.
     */
    void remove(String id);

    /**
     * Gets a list of all entities.
     * @return the list with all the entities.
     */
    List<T> getAll();
}