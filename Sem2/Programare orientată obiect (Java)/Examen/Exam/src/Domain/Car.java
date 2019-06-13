package Domain;

import java.util.Objects;

public class Car extends Entity{

    private String id, model;
    private int km;
    private double pret;

    public Car(String id, String model, int km, double pret) {
        this.id = id;
        this.model = model;
        this.km = km;
        this.pret = pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return km == car.km &&
                Double.compare(car.pret, pret) == 0 &&
                id.equals(car.id) &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, model, km, pret);
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    /**
     * Used for the full text search functionality
     * @return all details of a Car concatenated into a String
     */
    @Override
    public String toString() {
        return "Car{" +
                "id='" + getId() + '\'' +
                ", Model='" + getModel() + '\'' +
                ", Km='" + getKm() + '\'' +
                ", Pret='" + getPret() + '\'' +
                '}';
    }
}
