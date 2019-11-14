package ro.ntt.catalog.model;

/**
 * @author radu.
 */
public class BaseEntity<ID> {
    private ID id;


    BaseEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                '}';
    }
}
