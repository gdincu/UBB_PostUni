package Domain;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    Transaction A = new Transaction(1,2,3,4,5,6,"12/12/2012","00:00");

    @org.junit.jupiter.api.Test
    void toString1() {
        assertEquals(true,A.toString().equals(A.toString()));
    }

    @org.junit.jupiter.api.Test
    void getSearchableFields() {
        assertEquals(null,A.getSearchableFields());
    }

    @org.junit.jupiter.api.Test
    void equals1() {
        assertEquals(true,A.equals(A));
    }

    @org.junit.jupiter.api.Test
    void hashCode1() {
        assertEquals(true,A.hashCode() == A.hashCode());
    }

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
    void getDrugId() {
        A.setDrugId(3);
        assertEquals(3,A.getDrugId());
    }

    @org.junit.jupiter.api.Test
    void setDrugId() {
        A.setDrugId(3);
        assertEquals(3,A.getDrugId());
    }

    @org.junit.jupiter.api.Test
    void getClientCardId() {
        A.setClientCardId(4);
        assertEquals(4,A.getClientCardId());
    }

    @org.junit.jupiter.api.Test
    void setClientCardId() {
        A.setClientCardId(4);
        assertEquals(4,A.getClientCardId());
    }

    @org.junit.jupiter.api.Test
    void getQuantity() {
        A.setQuantity(10);
        assertEquals(10,A.getQuantity());
    }

    @org.junit.jupiter.api.Test
    void setQuantity() {
        A.setQuantity(10);
        assertEquals(10,A.getQuantity());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        A.setPrice(100);
        assertEquals(100,A.getPrice());
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
        A.setPrice(100);
        assertEquals(100,A.getPrice());
    }

    @org.junit.jupiter.api.Test
    void getDate() {
        A.setDate("01/01/2010");
        assertEquals("01/01/2010",A.getDate());
    }

    @org.junit.jupiter.api.Test
    void setDate() {
        A.setDate("01/01/2010");
        assertEquals("01/01/2010",A.getDate());
    }

    @org.junit.jupiter.api.Test
    void getTime() {
        A.setTime("00:01");
        assertEquals("00:01",A.getTime());
    }

    @org.junit.jupiter.api.Test
    void setTime() {
        A.setTime("00:01");
        assertEquals("00:01",A.getTime());
    }
}