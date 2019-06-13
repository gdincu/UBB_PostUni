import java.util.*;

public class Tranzactie {

    /*Clasa tranzactie include o data si o suma */
    private Date data;
    private int suma;

    /*Constructorul cu parametri*/
    public Tranzactie(Date data, int suma) {
        this.data = data;
        this.suma = suma;
    }

    /*Constructorul fara parametri*/
    public Tranzactie() {
        this(new java.util.Date(System.currentTimeMillis()), 0);
    }

    /* Getter & Setter pentru data si suma */
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    /* equals() si hashCode() pentru Tranzactie */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tranzactie)) return false;
        Tranzactie that = (Tranzactie) o;
        return getSuma() == that.getSuma() &&
                getData().equals(that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getSuma());
    }

    /* Comparator dupa suma tranzactionata */
    public static Comparator<Tranzactie> sortareSuma = new Comparator<Tranzactie>() {

        public int compare(Tranzactie a, Tranzactie b)
        {
            return a.suma - b.suma;
        }};

    /* Comparator dupa data tranzactionata */
    public static Comparator<Tranzactie> sortareData = new Comparator<Tranzactie>() {

        public int compare(Tranzactie a, Tranzactie b)
        {
            return a.data.compareTo(b.data);
        }};
}