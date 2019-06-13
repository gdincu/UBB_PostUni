package Domain;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    Entity A = new Entity() {
        @Override
        public ArrayList<String> getSearchableFields() {
            return null;
        }
    };

    @org.junit.jupiter.api.Test
    void getId() {
        A.setId(2);
        assertEquals(2,A.getId());
    }

    @org.junit.jupiter.api.Test
    void setId() {
        A.setId(2);
        assertEquals(2,A.getId());
    }

    @org.junit.jupiter.api.Test
    void equals1() {
        assertEquals(true,A.equals(A));
    }

    @org.junit.jupiter.api.Test
    void toString1() {
        assertEquals(true,A.toString().equals(A.toString()));
    }
}