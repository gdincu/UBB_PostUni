package Domain;

import java.util.ArrayList;
import java.util.Objects;

public class Factura extends Entity{

private int id;
private double price;
private String description, date;

    public Factura(int id, double price, String description, String date) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return id == factura.id &&
                Double.compare(factura.price, price) == 0 &&
                description.equals(factura.description) &&
                date.equals(factura.date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSuma() {
        return price;
    }

    public void setSuma(double suma) {
        this.price = suma;
    }

    public String getDescriere() {
        return description;
    }

    public void setDescriere(String descriere) {
        this.description = descriere;
    }

    public String getDate() {
        return date;
    }

    public void setData(String data) {
        this.date = date;
    }

    /**
     * Used for the full text search functionality
     * @return
     */
    @Override
    public ArrayList<String> getSearchableFields() {
        return null;
    }
}