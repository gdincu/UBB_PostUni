package Tests.Domain;

import Domain.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car temp = new Car("1","M",1,1);

    @Test
    void equals1() {
        assertEquals(true,temp.equals(temp));
    }

    @Test
    void hashCode1() {
        assertEquals(true,temp.hashCode()==temp.hashCode());
    }

    @Test
    void getId() {
        temp.setId("1");
        assertEquals("1",temp.getId());

    }

    @Test
    void setId() {
        temp.setId("1");
        assertEquals("1",temp.getId());
    }

    @Test
    void getModel() {
        temp.setModel("M");
        assertEquals("M",temp.getModel());
    }

    @Test
    void setModel() {
        temp.setModel("M");
        assertEquals("M",temp.getModel());
    }

    @Test
    void getKm() {
        temp.setKm(1);
        assertEquals(1,temp.getKm());
    }

    @Test
    void setKm() {
        temp.setKm(1);
        assertEquals(1,temp.getKm());
    }

    @Test
    void getPret() {
        temp.setPret(1);
        assertEquals(1,temp.getPret());
    }

    @Test
    void setPret() {
        temp.setPret(1);
        assertEquals(1,temp.getPret());
    }

    @Test
    void toString1() {
        assertEquals(true,temp.toString().equals(temp.toString()));
    }
}