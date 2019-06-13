package Repository;
import Domain.Entity;
import java.util.*;

public interface IRepository<T extends Entity>  {

    T findById(String id);
    void upsert(T drug);
    void remove(String id);
    ArrayList<T> getAll();

}
