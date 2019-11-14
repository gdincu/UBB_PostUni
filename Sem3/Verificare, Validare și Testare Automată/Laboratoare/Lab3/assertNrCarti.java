package BibliotecaApp.repo;
?
import BibliotecaApp.model.Carte;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
?
import java.util.ArrayList;
?
import static org.junit.Assert.*;
?
public class CartiRepoTest {
    private CartiRepo cr;
?
    @Before
    public void setUp(){
        cr=new CartiRepo();
    }
?
    @After
    public void tearDown(){
        cr=null;
    }
?
    @Test
    public void TC1() {
        Carte c=new Carte();
        c.setTitlu("Herry Potter");
        ArrayList<String> a=new ArrayList<String>();
        a.add("J.K.Rowling");
        c.setAutori(a);
        c.setAnAparitie("1998");
        c.setEditura("Humanitas");
        ArrayList<String> cc=new ArrayList<String>();
        cc.add("fantastic");
        cc.add("aventura");
        c.setCuvinteCheie(cc);
        int nr_carti=cr.getCarti().size();
        cr.adaugaCarte(c);
        //verificam daca intr-adevar cartea s-a adaugat cu succes
        assertEquals(nr_carti+1,cr.getCarti().size());
    }
?
    @Test (expected=Exception.class)
    public void TC2() {
        Carte c=new Carte();
        c.setTitlu("");
        ArrayList<String> a=new ArrayList<String>();
        a.add("J.K.Rowling");
        c.setAutori(a);
        c.setAnAparitie("1998");
        c.setEditura("Humanitas");
        ArrayList<String> cc=new ArrayList<String>();
        cc.add("fantastic");
        cc.add("aventura");
        c.setCuvinteCheie(cc);
        int nr_carti=cr.getCarti().size();
        cr.adaugaCarte(c);
        //verificam daca intr-adevar cartea nu s-a adaugat
        assertEquals(nr_carti,cr.getCarti().size());
        //todo: de corectat validatorul cartii care nu are conditii cu privire la titlu, si de adaugat validarea cartii inainte de a o adauga in repository
    }
?
}