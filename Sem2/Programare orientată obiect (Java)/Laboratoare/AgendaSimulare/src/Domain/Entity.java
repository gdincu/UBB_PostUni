package Domain;
import java.util.*;

public abstract class Entity {

    private String id;

    /**
     * Constructor
     * @param id
     */
    public Entity(String id) {
        this.id = id;
    }

    protected Entity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id.equals(entity.id);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract ArrayList<String> getSearchableFields();
}
