package Domain;

import java.util.Objects;

public class ElectricCar extends Entity {

private String model;
private double pret,autonomie;

    public ElectricCar(String id, String model, double pret, double autonomie) {
        super(id);
        this.model = model;
        this.pret = pret;
        this.autonomie = autonomie;
    }

    public ElectricCar(String model, double pret, double autonomie) {
        this.model = model;
        this.pret = pret;
        this.autonomie = autonomie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectricCar that = (ElectricCar) o;
        return Double.compare(that.pret, pret) == 0 &&
                Double.compare(that.autonomie, autonomie) == 0 &&
                model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model, pret, autonomie);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPret() {
        return pret + autonomie * 2.5;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public double getAutonomie() {
        return autonomie;
    }

    public void setAutonomie(double autonomie) {
        this.autonomie = autonomie;
    }

    public String toString() {
        return this.getModel()+"Electric"+this.getPret();
    }
}
