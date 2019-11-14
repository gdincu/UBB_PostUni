package ro.ntt.catalog.repository;

import ro.ntt.catalog.model.Student;


import java.util.Optional;

/**
 * Interface for CRUD operations on a Student.
 *
 * @author radu.
 */
public interface StudentRepository {
    /**
     * Find the entity with the given {@code id}.
     *
     * @param id must be not null.
     * @return a {@code Student}  with the given id.
     * @throws IllegalArgumentException if the given id is null.
     */
    Student findOne(Long id);

    /**
     * @return all entities.
     */
    Iterable<Student> findAll();

    /**
     * Saves the given entity.
     *
     * @param entity must not be null.
     * @return a {@code Student} - null if the entity was saved otherwise (e.g. id already exists) returns the entity.
     * @throws IllegalArgumentException if the given entity is null.
     */
    Student save(Student entity);

    /**
     * Removes the entity with the given id.
     *
     * @param id must not be null.
     * @return a {@code Student} - null if there is no entity with the given id, otherwise the removed entity.
     * @throws IllegalArgumentException if the given id is null.
     */
    Student delete(Long id);

    /**
     * Updates the given entity.
     *
     * @param entity must not be null.
     * @return a {@code Student} - null if the entity was updated otherwise (e.g. id does not exist) returns the
     * entity.
     * @throws IllegalArgumentException if the given entity is null.
     */
    Student update(Student entity);
}
