package Domain;

public interface IValidator<T extends Entity> {

    void validate(T entity);
}
