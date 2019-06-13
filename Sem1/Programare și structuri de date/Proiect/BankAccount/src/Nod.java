import java.util.Objects;

public class Nod {

    public Tranzactie elem; //informatia din nod
    public Nod urm;         // urm e adresa nodului urmator (pointer)
    public Nod ant;         // urm e adresa nodului urmator (pointer)

    /* Getter & Setter pentru elem, urm si ant */
    public Tranzactie getElem() {
        return elem;
    }

    public void setElem(Tranzactie elem) {
        this.elem = elem;
    }

    public Nod getUrm() {
        return urm;
    }

    public void setUrm(Nod urm) {
        this.urm = urm;
    }

    public Nod getAnt() {
        return ant;
    }

    public void setAnt(Nod ant) {
        this.ant = ant;
    }

    /* equals() & hashcode() */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nod)) return false;
        Nod nod = (Nod) o;
        return getElem().equals(nod.getElem()) &&
                getUrm().equals(nod.getUrm()) &&
                getAnt().equals(nod.getAnt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElem(), getUrm(), getAnt());
    }
}
