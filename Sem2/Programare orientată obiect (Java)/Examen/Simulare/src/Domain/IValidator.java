package Domain;

public interface IValidator<T extends Entity> {

    /**
     * Validates an entity.
     * @param entity the entity to validate.
     */
    void validate(T entity);
}
