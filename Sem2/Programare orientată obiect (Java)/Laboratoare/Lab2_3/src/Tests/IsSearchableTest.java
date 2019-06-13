package Tests;
import Domain.*;
import Service.IsSearchable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class IsSearchableTest {

    void testFTSearch() {
        IsSearchable temp = new IsSearchable();
        ArrayList<Drug> list = new ArrayList<>();
        temp.fullTextSearch("A",list);
    }
}
