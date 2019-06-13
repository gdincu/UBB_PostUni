package Domain;

import static org.junit.jupiter.api.Assertions.*;

class DrugTest {

    Drug A = new Drug(1,2,"A","A",true);

    @org.junit.jupiter.api.Test
    void toString1() {
        assertEquals(true,A.toString().equals(A.toString()));
    }

    @org.junit.jupiter.api.Test
    void getSearchableFields() {
        assertEquals(null,A.getSearchableFields());
    }

    @org.junit.jupiter.api.Test
    void getId() {
        assertEquals(1,A.getId());
    }

    @org.junit.jupiter.api.Test
    void setId() {
        A.setId(2);
        assertEquals(2,A.getId());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(2,A.getPrice());
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
        A.setPrice(3);
        assertEquals(3,A.getPrice());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("A",A.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        A.setName("B");
        assertEquals("B",A.getName());
    }

    @org.junit.jupiter.api.Test
    void getProducer() {
        assertEquals("A",A.getProducer());
    }

    @org.junit.jupiter.api.Test
    void setProducer() {
        A.setProducer("B");
        assertEquals("B",A.getProducer());
    }

    @org.junit.jupiter.api.Test
    void isReceiptNeeded() {
        assertEquals(true,A.isReceiptNeeded());
    }

    @org.junit.jupiter.api.Test
    void setReceiptNeeded() {
        A.setReceiptNeeded(false);
        assertEquals(false,A.isReceiptNeeded());
    }

    @org.junit.jupiter.api.Test
    void equals1() {
        assertEquals(true,A.equals(A));
    }

    @org.junit.jupiter.api.Test
    void hashCode1() {
        assertEquals(true,A.hashCode() == A.hashCode());
    }
}