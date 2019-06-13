package Domain;

import static org.junit.jupiter.api.Assertions.*;

class ClientCardTest {

    ClientCard A = new ClientCard(1,"1990223160043","A","A","12/12/2012","13/12/2012");

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
        assertEquals(true,A.getId() == A.getId());
    }

    @org.junit.jupiter.api.Test
    void setId() {
        A.setId(2);
        assertEquals(2,A.getId());
    }

    @org.junit.jupiter.api.Test
    void getCNP() {
        assertEquals("1990223160043",A.getCNP());
    }

    @org.junit.jupiter.api.Test
    void setCNP() {
        A.setCNP("9999999999999");
        assertEquals("9999999999999",A.getCNP());
    }

    @org.junit.jupiter.api.Test
    void getSurname() {
        assertEquals("A",A.getSurname());
    }

    @org.junit.jupiter.api.Test
    void setSurname() {
        A.setSurname("B");
        assertEquals("B",A.getSurname());
    }

    @org.junit.jupiter.api.Test
    void getForename() {
        assertEquals("A",A.getForename());
    }

    @org.junit.jupiter.api.Test
    void setForename() {
        A.setForename("B");
        assertEquals("B",A.getForename());
    }

    @org.junit.jupiter.api.Test
    void getDOB() {
        assertEquals("12/12/2012",A.getDOB());
    }

    @org.junit.jupiter.api.Test
    void setDOB() {
        A.setDOB("01/01/2001");
        assertEquals("01/01/2001",A.getDOB());
    }

    @org.junit.jupiter.api.Test
    void getRegDate() {
        assertEquals("13/12/2012",A.getRegDate());
    }

    @org.junit.jupiter.api.Test
    void setRegDate() {
        A.setRegDate("14/12/2012");
        assertEquals("14/12/2012",A.getRegDate());
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