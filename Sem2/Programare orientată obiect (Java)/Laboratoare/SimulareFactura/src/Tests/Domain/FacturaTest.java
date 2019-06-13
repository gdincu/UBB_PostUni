package Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacturaTest {

    Factura A = new Factura(1,2.2,"DD","12.12.2012");
    Factura B = new Factura(1,2.2,"DD","12.12.2012");

    @Test
    void equals1() {
        assertEquals(true,A.equals(B));
    }

    @Test
    void getId() {
        assertEquals(1,A.getId());
    }

    @Test
    void setId() {
        A.setId(3);
        assertEquals(3,A.getId());
    }

    @Test
    void getSuma() {
        assertEquals(2.2,A.getSuma());
    }

    @Test
    void setSuma() {
        A.setSuma(3.3);
        assertEquals(3.3,A.getSuma());
    }

    @Test
    void getDescriere() {
        assertEquals("DD",A.getDescriere());
    }

    @Test
    void setDescriere() {
        B.setDescriere("CC");
        assertEquals("CC",B.getDescriere());
    }

    @Test
    void getDate() {
        assertEquals("12.12.2012",A.getDate());
    }

    @Test
    void setData() {
        A.setData("10.10.2010");
        assertEquals("12.12.2012",A.getDate());
    }

    @Test
    void getSearchableFields() {
        assertEquals(A.getSearchableFields(),A.getSearchableFields());
    }
}