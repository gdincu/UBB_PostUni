package Domain;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    Event A = new Event("1","DD","12/12/2012","11:11","00:00");
    Event B = new Event("1","DD","12/12/2012","11:11","00:00");

    @org.junit.jupiter.api.Test
    void equals1() {
        assertEquals(true,A.equals(B));
    }

    @org.junit.jupiter.api.Test
    void getId() {
        assertEquals(true,A.getId().equals(B.getId()));
    }

    @org.junit.jupiter.api.Test
    void setId() {
        A.setId("2");
        assertEquals("2",A.getId());
    }


    @org.junit.jupiter.api.Test
    void getName() {
        A.setName("AAA");
        assertEquals("AAA",A.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        A.setName("AAA");
        assertEquals("AAA",A.getName());
    }

    @org.junit.jupiter.api.Test
    void getDate() {
        A.setDate("13/12/2012");
        assertEquals("13/12/2012",A.getDate());
    }

    @org.junit.jupiter.api.Test
    void setDate() {
        A.setDate("13/12/2012");
        assertEquals("13/12/2012",A.getDate());
    }

    @org.junit.jupiter.api.Test
    void getLength() {
        A.setLength("12:00");
        assertEquals("12:00",A.getLength());
    }

    @org.junit.jupiter.api.Test
    void setLength() {
        A.setLength("12:00");
        assertEquals("12:00",A.getLength());
    }

    @org.junit.jupiter.api.Test
    void getStartTime() {
        A.setStartTime("00:00");
        assertEquals("00:00",A.getStartTime());
    }

    @org.junit.jupiter.api.Test
    void setStartTime() {
        A.setStartTime("00:00");
        assertEquals("00:00",A.getStartTime());
    }
}