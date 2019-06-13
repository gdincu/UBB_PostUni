package Tests.Domain;

import Domain.Booking;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    Booking temp = new Booking("1","2",2,3);

    @org.junit.jupiter.api.Test
    void equals1() {
    assertEquals(true,temp.equals(temp));
    }

    @org.junit.jupiter.api.Test
    void hashCode1() {
        assertEquals(true,temp.hashCode() == temp.hashCode());
    }

    @org.junit.jupiter.api.Test
    void getBookingId() {
        temp.setBookingId("1");
        assertEquals("1",temp.getBookingId());
    }

    @org.junit.jupiter.api.Test
    void setBookingId() {
        temp.setBookingId("1");
        assertEquals("1",temp.getBookingId());
    }

    @org.junit.jupiter.api.Test
    void getCarId() {
        temp.setCarId("2");
        assertEquals("2",temp.getCarId());
    }

    @org.junit.jupiter.api.Test
    void setCarId() {
        temp.setCarId("2");
        assertEquals("2",temp.getCarId());
    }

    @org.junit.jupiter.api.Test
    void getDays() {
        temp.setDays(2);
        assertEquals(2,temp.getDays());
    }

    @org.junit.jupiter.api.Test
    void setDays() {
        temp.setDays(2);
        assertEquals(2,temp.getDays());
    }

    @org.junit.jupiter.api.Test
    void getKm() {
        temp.setKm(3);
        assertEquals(3,temp.getKm());
    }

    @org.junit.jupiter.api.Test
    void setKm() {
        temp.setKm(3);
        assertEquals(3,temp.getKm());
    }

    @org.junit.jupiter.api.Test
    void toString1() {
        assertEquals(true,temp.toString().equals(temp.toString()));
    }
}