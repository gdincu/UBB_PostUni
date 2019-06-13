package Domain;

import java.util.Objects;

public class DieselCar extends Entity {

    private String model;
    private double pret, consum;

    public DieselCar(String id, String model, double pret, double consum) {
        super(id);
        this.model = model;
        this.pret = pret;
        this.consum = consum;
    }

    public DieselCar(String model, double pret, double consum) {
        this.model = model;
        this.pret = pret;
        this.consum = consum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DieselCar dieselCar = (DieselCar) o;
        return Double.compare(dieselCar.pret, pret) == 0 &&
                Double.compare(dieselCar.consum, consum) == 0 &&
                model.equals(dieselCar.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model, pret, consum);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPret() {
        return pret + consum * 0.5;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public double getConsum() {
        return consum;
    }

    public void setConsum(double consum) {
        this.consum = consum;
    }

    public String toString() {
        return this.getModel()+"Diesel"+this.getPret();
    }
}
