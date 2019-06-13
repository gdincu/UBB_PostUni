import java.util.Objects;

public class Anvelopa {
    private String nume;
    private String tip;
    private int stocI;
    private int vandut;
    private int pretUnit;

    /* Constructor fara nici un parametru */
    public Anvelopa(){
        nume=null;
        tip=null;
        stocI=0;
        vandut=0;
        pretUnit=0;
    }

    /* Constructor standard */
    public Anvelopa(String nume, String tip, int stocI, int vandut, int pretUnit) {
        this.nume = nume;
        this.tip = tip;
        this.stocI = stocI;
        this.vandut = vandut;
        this.pretUnit = pretUnit;
    }

    /* Getters & Setters */
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getStocI() {
        return stocI;
    }

    public void setStocI(int stocI) {
        this.stocI = stocI;
    }

    public int getVandut() {
        return vandut;
    }

    public void setVandut(int vandut) {
        this.vandut = vandut;
    }

    public int getPretUnit() {
        return pretUnit;
    }

    public void setPretUnit(int pretUnit) {
        this.pretUnit = pretUnit;
    }

    /* equals() & hashcode() */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anvelopa)) return false;
        Anvelopa anvelopa = (Anvelopa) o;
        return getStocI() == anvelopa.getStocI() &&
                getVandut() == anvelopa.getVandut() &&
                getPretUnit() == anvelopa.getPretUnit() &&
                getNume().equals(anvelopa.getNume()) &&
                getTip().equals(anvelopa.getTip());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNume(), getTip(), getStocI(), getVandut(), getPretUnit());
    }
}
