package Domain;

import java.util.Objects;

public abstract class Entity {

    private String id;

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
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

}
