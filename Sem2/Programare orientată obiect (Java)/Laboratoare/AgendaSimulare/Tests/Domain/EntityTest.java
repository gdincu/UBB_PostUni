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

    Entity B = new Entity() {
        @Override
        public ArrayList<String> getSearchableFields() {
            return null;
        }
    };

    @org.junit.jupiter.api.Test
    void equals1() {
        assertEquals(false,A.equals(B));
    }

    @org.junit.jupiter.api.Test
    void getId() {
        assertEquals(A.getId(),B.getId());
    }

    @org.junit.jupiter.api.Test
    void setId() {
        A.setId("1");
        assertEquals("1",A.getId());
    }
}