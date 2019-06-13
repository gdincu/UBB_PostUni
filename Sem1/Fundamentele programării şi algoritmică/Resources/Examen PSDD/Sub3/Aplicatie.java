
public class Aplicatie {
    public static void Citire(Secventa Secv){   // se initializeaza un tablou T
        long T[]={4,5,60,8,15,17};              // apoi se pun elementele in Secv
        Secv.setLung(T.length);		        // se reseteaza lungimea lui Secv
        for(int i=0;i<T.length;i++)		// se seteaza valorile lui Secv cu valorile lui T
          Secv.setSI(i,T[i]);

    } 
    public static void Afisare(Secventa Secv){
        for(int i=0; i<Secv.getLung();i++)
           System.out.print(Secv.getSI(i)+ " ");
    }
    public static void main( String a[]){
        Secventa Secv = new Secventa (1000);    //instantierea lui S cu o lungime maximala 
        Citire(Secv);
        System.out.print("\nSecventa inainte de prelucrare:");
        Afisare(Secv);
        Secv.GrupPrime();
        System.out.print("\nSecventa dupa prelucrare:");
        Afisare(Secv);
        System.out.println("\n Program terminat");
        
    }
}          
	

