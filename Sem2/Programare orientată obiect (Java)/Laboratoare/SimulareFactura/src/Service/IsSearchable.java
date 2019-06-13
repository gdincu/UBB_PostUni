package Service;
import Domain.*;
import java.util.*;

public class IsSearchable<T extends Entity> {

    /*
     * The logic used to search entities
     * */
    public void fullTextSearch(String terms, ArrayList<T> entities) {

        for (T entity : entities) {
            ArrayList<String> fields = entity.getSearchableFields();
            for (String field : fields)
                if (terms.toLowerCase().equals(field.toLowerCase()))
                    System.out.println(entity.toString());
        }
    }

}