package Domain;
import java.util.*;

public abstract class Entity {

    private int id;

    public Entity(int id) {
        this.id = id;
    }

    protected Entity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract ArrayList<String> getSearchableFields();
}
