package Repository;
import Domain.Entity;
import java.util.*;

public interface IRepository<T extends Entity>  {

    T findById(int id);
    void upsert(T drug);
    void remove(int id);
    ArrayList<T> getAll();

}
