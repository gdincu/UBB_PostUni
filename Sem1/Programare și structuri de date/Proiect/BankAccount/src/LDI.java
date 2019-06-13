import java.util.*; /* Folosita pentru Comparator si Iterator */

public class LDI {

    public Comparator<Tranzactie> comparator;
    private Nod prim;   //adresa primului nod
    private Nod ultim;  //adresa primului nod

    /* Constructor Standard cu Comparator ca si parametru */
    public LDI(Comparator<Tranzactie> comp) {
        this.comparator = comp;
        this.prim = null;
        this.ultim = null;
    }

    /* Adauga un element in functie de comparator */
    public void adauga(Tranzactie elem) {
        if (this.lungime() == 0)            //Daca lista nu are nici un element adauga la inceput
            adaugaInceput(elem);
        else if (this.comparator.compare(elem, this.getElement(this.lungime()-1))>= 0) //Daca elem este mai mare decat ultimul element adauga la sfarsit
            adaugaSfarsit(elem);
        else {
            int index = 0;
            while(index < this.lungime() && this.comparator.compare(elem, this.getElement(index)) > 0) {
                index++;
            }
            adaugaPozitie(elem,index);  //Adauga elem pe pozitia unde elem este mai mare decat elem de pe pozitia respectiva
        }
    }

    /* Adauga un element la inceputul listei */
    private void adaugaInceput(Tranzactie elem) {
        Nod n = new Nod();
        n.setElem(elem);
        n.setUrm(null);
        n.setAnt(null);

        if (this.prim == null) {
            //lista e vida
            this.prim = n;
            this.ultim = n;

        } else {
            n.urm = this.prim;
            this.prim.setAnt(n);
            this.prim = n;
        }
    }

    /* Adauga un element la sfarsitul listei */
    private void adaugaSfarsit(Tranzactie elem) {
        Nod n = new Nod();
        n.setElem(elem);
        n.setAnt(ultim);
        if (this.prim == null) {
            //lista e vida
            this.prim = n;
            this.ultim = n;
        } else {
            ultim.setUrm(n);
            ultim = n;
        }
    }

    /* Adauga un element pe o pozitie data ca parametru */
    private void adaugaPozitie(Tranzactie elem, int pozitie) {
        Nod n = new Nod();
        n.urm = null;
        n.ant = null;
        n.elem = elem;

        if (pozitie == 0) {
            if (this.prim == null) {
                this.prim = n;
                this.ultim = n;
            } else {
                n.urm = this.prim;
                this.prim.ant = n;
                this.prim = n;
            }

        } else {
            Nod nodCurent = new Nod();
            nodCurent = this.prim;
            int pozCurent = 0;

            while (pozCurent < pozitie - 1 && !(nodCurent.equals(null))) {
                pozCurent++;
                nodCurent = nodCurent.urm;
            }

            if (pozCurent == pozitie - 1 && !(nodCurent.equals(null))) {
                if (nodCurent.equals(this.ultim)) {
                    n.ant = nodCurent;
                    nodCurent.urm = n;
                    this.ultim = n;
                } else {
                    n.ant = nodCurent;
                    n.urm = nodCurent.urm;
                    nodCurent.urm.ant = n;
                    nodCurent.urm = n;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    /* Sterge ultimul element -> returneaza true daca s-a gasit si s-a sters elementul, false altfel */
    private void stergeElementultim() {

        if (!this.prim.equals(null))
            if (this.prim.equals(this.ultim)) {
                this.prim = null;
                this.ultim = null;
            } else {
                this.ultim = this.ultim.ant;
                this.ultim.urm = null;
            }
    }

    /* Sterge primul element -> returneaza true daca s-a gasit si s-a sters elementul, false altfel */
    private void stergeElementprim() {

        if (this.prim.equals(this.ultim)) {
            this.prim = null;
            this.ultim = null;
        } else
            this.prim.urm.ant=null;
        this.prim = this.prim.urm;
    }

    /* Sterge elementul de pe o pozitie data ca parametru */
    private void stergeElementpozitie(int pozitie) {
        if(pozitie<0 || pozitie>=this.lungime()) return;
        if (pozitie == 0) {
            this.stergeElementprim();
            return;
        }

        if (pozitie == this.lungime()-1) {
            this.stergeElementultim();
            return;
        }

        Nod nodCurent = this.prim;

        // parcurgem lista de la nodul 0 pana la nodul i
        for (int i = 0; !nodCurent.equals(null) && i < pozitie; i++)
            nodCurent = nodCurent.urm;

        // daca pozitie este mai mare decat nr de noduri din lista return
        if (nodCurent.equals(null)) return;

        // stergem nodul curent
        nodCurent.urm.ant = nodCurent.ant;
        nodCurent.ant.urm = nodCurent.urm;
    }

    /* Sterge prima aparitie a unui element dat ca parametru din lista */
    public void sterge(Tranzactie temp) throws Exception {
        int poz=this.pozitie(temp);
        if(poz!=-1) this.stergeElementpozitie(poz);
    }

    /* Verifica daca un element este prezent in lista -> returneaza true daca s-a gasit si elementul, false altfel */
    private boolean cauta(Tranzactie elem) {
        Nod nodCurent=this.prim;
        while(!nodCurent.elem.equals(elem))
            nodCurent=nodCurent.urm;
        if(nodCurent.equals(elem)) return true;
        return false;
    }

    /* Returneaza numarul de elemente din lista */
    public int lungime() {
        int count = 0;
        for (Nod n1 = prim; n1 != null; n1 = n1.getUrm())
            count++;
        return count;
    }

    /* Verifica daca lista este goala */
    public boolean isEmpty(){
        if(this.lungime()==0) return true;
        return false;
    }

    /* Returneaza elementul de pe o pozitie data ca parametru - arunca exceptie daca pozitia nu este valida */
    public Tranzactie getElement(int pozitie) {

        if (pozitie > 0) {
            Nod nodCurent=this.prim;
            int pozCurent=0;

            while(pozCurent < pozitie && nodCurent!=null) {
                pozCurent++;
                nodCurent=nodCurent.urm;
            }

            if(nodCurent!=null) return nodCurent.elem;
        }


        //luam un nod curent
        Nod nodCurent = this.prim;
        //folosim ciclu pentru, facem pozitie iteratii
        for (int i = 0; i < pozitie; i++) {
            //nodCurent = [nodCurent].urm
            nodCurent = nodCurent.getUrm();
        }
        //returnam elementul din nodul curent
        return nodCurent.getElem();
    } //Complexitate: O(lungime)

    /* Returneaza pozitia primei aparitii a unui element data ca parametru */
    public int pozitie(Tranzactie elem) {
        Nod nodCurent=this.prim;
        int index=0;
        while(!nodCurent.elem.equals(elem)) {
            nodCurent = nodCurent.urm;
            index++;
        }
        if(index>=0) return index;
        System.out.print("\nElementul nu a fost gasit!!\n");
        return -1;
    }

    /* Iterator */
    public Iterator<Tranzactie> iterator() {
        return new IteratorLDI<Tranzactie>(this);
    }

    /* Iterator */
    public class IteratorLDI<Tranzactie> implements Iterator<Tranzactie> {

        private LDI lista;
        private Nod nodCurent;

        /* Constructorul cu parametru pentru iterator */
        public IteratorLDI(LDI list) {
            this.lista = list;
            this.nodCurent = lista.prim;
        }

        /* Verifica daca se gaseste un element urmator -> returneaza true daca s-a gasit, false altfel */
        public boolean hasNext() {
            return this.nodCurent!=null;
        }

        /* Returneaza urmatorul element */
        public Tranzactie next() {
            Tranzactie elem =(Tranzactie) this.nodCurent.elem;
            this.nodCurent = this.nodCurent.urm;
            return elem;
        }

    }
}
