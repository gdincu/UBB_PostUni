package Tests.Domain;

import Domain.DieselCar;

import static org.junit.jupiter.api.Assertions.*;

class DieselCarTest {

    DieselCar A = new DieselCar("1","A",12,12);

    @org.junit.jupiter.api.Test
    void equals1() {
    assertEquals(true,A.equals(A));
    }

    @org.junit.jupiter.api.Test
    void hashCode1() {
        assertEquals(true,A.hashCode() == A.hashCode());
    }

    @org.junit.jupiter.api.Test
    void getModel() {
        A.setModel("B");
        assertEquals("B",A.getModel());
    }

    @org.junit.jupiter.api.Test
    void setModel() {
        A.setModel("B");
        assertEquals("B",A.getModel());
    }

    @org.junit.jupiter.api.Test
    void getPret() {
        A.setPret(22);
        assertEquals(28,A.getPret());
    }

    @org.junit.jupiter.api.Test
    void setPret() {
        A.setPret(22);
        assertEquals(28,A.getPret());
    }

    @org.junit.jupiter.api.Test
    void getConsum() {
        A.setConsum(12);
        assertEquals(12,A.getConsum());
    }

    @org.junit.jupiter.api.Test
    void setConsum() {
        A.setConsum(12);
        assertEquals(12,A.getConsum());
    }

    @org.junit.jupiter.api.Test
    void toString1() {
        assertEquals(true,A.toString().equals(A.toString()));
    }
}