package Domain;

import org.junit.jupiter.api.Test;

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

    @Test
    void equals1() {
    assertEquals(false,A.equals(B));
    }

    @Test
    void getId() {
    assertEquals(A.getId(),B.getId());
    }

    @Test
    void setId() {
        A.setId(2);
        assertEquals(2,A.getId());
    }
}