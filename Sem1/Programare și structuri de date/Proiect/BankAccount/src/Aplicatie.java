import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class Aplicatie {

    /* Metoda pentru citirea unei sume de la tastatura (similar cu citirea unui intreg) */
    private static int citireSuma() {
        System.out.print("Suma tranzactionata : ");
        return (new Scanner(System.in).nextInt());       //Returnam un intreg citit de la tastatura folosind clasa Scanner
    }

    /* Metoda pentru transformarea unui String intr-o data */
    private static Date stringData(String A) throws Exception {
        return (new SimpleDateFormat("dd.MM.yyyy").parse(A));    //Returnam o daca convertita dintr-un String dat ca parametru
    }

    /* Metoda pentru citirea unei date de la tastatura */
    private static Date citireData() throws Exception {
        System.out.print("\nData tranzactiei (format data : dd.MM.yyyy) : "); //Cerem ca data sa fie introdusa intr-un format specific
        return (stringData( new Scanner(System.in).nextLine() ));     //Apelam functia stringData pentru a converti stringul intr-o data
    }

    /* Citeste exemplele data in cerinta din fisier folosind clasa Scanner - alternativ folosim adaugaExemple() */
    private static void citireFisier(LDI listA, String fisier) throws FileNotFoundException, Exception {

        Scanner citireData = new Scanner(new File(fisier));      														//Cream o noua instanta a clasei Scanner ce foloseste fisierul ca si input
        citireData.useDelimiter("[/\\r\\n]");         																//Setam delimitatorul ca si o noua linie - \r\n echivalentul Enter
        while(citireData.hasNext()) {           																		//Cat timp exista o linie urmatoare

            String s=citireData.nextLine();				//Un string temporar s ia valoarea intregii linii
            String[] tranzactii=s.split(",");      	 	//Un vector tranzactii ia valorile stringului s delimitate de virgula
            String dataTemp=tranzactii[0];          		//Data tranzactiei este salvata in tranzactii[0]
            String sumaTemp=tranzactii[1];          	//Suma tranzactiei este salvata in tranzactii[1]

            listA.adauga(new Tranzactie(stringData(dataTemp),Integer.parseInt(sumaTemp)));             				//Adaugam tranzactia temporara la lista de tranzactii
        }
    }

    /* Adauga exemplele din cerinta - alternativ folosim citireFisier() */
    private static void adaugaExemple(LDI lista) throws Exception {
        lista.adauga(new Tranzactie(stringData("01.11.2017"),42));
        lista.adauga(new Tranzactie(stringData("01.11.2017"),64));
        lista.adauga(new Tranzactie(stringData("02.11.2017"),66));
        lista.adauga(new Tranzactie(stringData("03.11.2017"),121));
        lista.adauga(new Tranzactie(stringData("04.11.2017"),70));
        lista.adauga(new Tranzactie(stringData("05.11.2017"),32));
        lista.adauga(new Tranzactie(stringData("07.11.2017"),101));
        lista.adauga(new Tranzactie(stringData("08.11.2017"),42));
        lista.adauga(new Tranzactie(stringData("09.11.2017"),79));
        lista.adauga(new Tranzactie(stringData("10.11.2017"),99));
        lista.adauga(new Tranzactie(stringData("11.11.2017"),132));
        lista.adauga(new Tranzactie(stringData("13.11.2017"),551));
    }

    /* Metoda pentru printarea liniilor folosite la tabel */
    private static void linii(int optiune) {
        if(optiune==1) System.out.print("\n===============================================\n");
        if(optiune==0) System.out.print("===============================================");
    }

    /* Metoda pentru afisarea listei de tranzactii  */
    private static void listaTranzactii(LDI listA) {
        //Afisam header-ul tabelului de tranzactii
        linii(1); System.out.print("Lista Tranzactii"); linii(1);
        System.out.print(new Formatter().format("%-5s|%-30s|%-10s","Index","Data","Suma"));
        linii(1);

        //Parcurgem lista cu un FOR si afisam valorile
        for(int i=0;i<listA.lungime();i++)
            System.out.print(new Formatter().format("%-5s|%-30s|%-10s", i, listA.getElement(i).getData(), listA.getElement(i).getSuma())+"\n");
        linii(0);
    }

    /* Metoda pentru a returna valoarea mediana dintr-o lista de tranzactii */
    private static int median(LDI listA, Tranzactie A, int d) {
        int pozitie=listA.pozitie(A);
        int rezultat;

        //Cream o a doua lista ce contine n-1 tranzactii in fata tranzactiei verificate sortate dupa suma
        if(pozitie-d<=0 || pozitie-1<0 || pozitie-(d/2)-1<0) return 999999; //Daca conditiile impuse sunt adevarate returnam o valoare foarte mare astfel incat sa nu avem o valoare mediana in main
        LDI temporar=new LDI(Tranzactie.sortareSuma);

        for(int i=0;i<listA.lungime();i++)
            if(i>=(pozitie-d) && i<=(pozitie-1)) //Parcurgem ListaOrdonata temporara si adaugam tranzactiile care respecta condiitile acesteia
                temporar.adauga(listA.getElement(i));

        if(d%2!=0) rezultat=temporar.getElement(d/2).getSuma();              					//Valoarea mediana in cazul in care nr de tranzactii verificate este impar
        else rezultat=(temporar.getElement(d/2).getSuma() + temporar.getElement(d/2-1).getSuma())/2; 	//Valoarea mediana in cazul in care nr de tranzactii verificate este par

        return rezultat;   															//Returnam valoarea mediana
    }

    /* Metoda pentru a verifica daca o tranzactie este frauduloasa */
    private static void verifica(LDI listA, int d) throws Exception {
        Tranzactie temp=new Tranzactie(citireData(),citireSuma());     	//Cream o tranzactie temporara
        int pozitia=listA.pozitie(temp);                									//Cream o variabila care sa retina pozitia

        if(pozitia-d<0) {                 												//Daca indexul pozitiei - nr de tranzactii de verificat este mai mic decat 0
            System.out.print("\nNu exista suficiente tranzactii pentru verificare !!\n"); //Afisam un mesaj corespunzator
            return;                   													//Si iesim din metoda
        }

        if( listA.getElement(pozitia).getSuma() < 2 * median(listA,listA.getElement(pozitia),d)) {//Daca suma tranzactiei de pe indexul gasit este mai mica decat 2 * valoarea mediana
            System.out.print("\nTranzactie OK\n");  										//Returnam un mesaj corespunzator
            return;        }
        System.out.print("\nTranzactie frauduloasa!!!\n");
    }

    /* Metoda pentru a returna nr total de tranzactii frauduloase */
    private static int nrFrauda(LDI listA, int d) throws Exception {

        int count=0;

        Iterator<Tranzactie> iter=listA.iterator();                  //Folosim un iterator pentru a parcurge lista
        while(iter.hasNext()) {           							//Cat timp exista o valoare urmatoare
            Tranzactie next=iter.next();        						//Iteratorul ia valoarea elementului urmator
            int pozitie=listA.pozitie(next);       			//Salvam indexul intr-o variabila pozitie

            if(pozitie-d>=0)            						//Daca pozitia este >= nr de tranzactii de verificat
                if(next.getSuma() > 2*median(listA,next,d))     		//Daca suma tranzactiei curente este mai mare de 2 ori decat valoarea mediana bazata pe pozitia curenta
                    count++;            								//Implementam count-ul care retine nr de tranzactii frauduloase
        }
        return count;             								//Returnam count-ul
    }

    /* Metoda de afisare a optiunilor si apelare a meniului */
    private static void optiuni(LDI lista, int d) throws Exception {
        System.out.print("\n(1) Adauga tranzactie");
        System.out.print("\n(2) Sterge tranzactie");
        System.out.print("\n(3) Lista tranzactii");
        System.out.print("\n(4) Verifica tranzactie");
        System.out.print("\n(5) Nr. total de tranzactii frauduloase");
        System.out.print("\n(6) Modifica nr de tranzactii verificate");
        System.out.print("\n(7) Iesire cont");

        int opt=-1;
        while(opt<1 || opt>7) {
            System.out.print("\n\nOptiune : ");
            opt=new Scanner(System.in).nextInt();
        }

        switch (opt) {

            case 1:
                lista.adauga(new Tranzactie(citireData(),citireSuma()));    //Adaugam listei o tranzactie noua cu valori citite de la tastatura
                optiuni(lista,d);   			                            //Afiseaza optiunile
                break;

            case 2:
                if(lista.isEmpty()) break;			//Daca lista nu are nici un element iese din switch
                lista.sterge(new Tranzactie(citireData(),citireSuma()));				//Sterge o tranzactie din lista
                optiuni(lista,d);   				//Afiseaza optiunile
                break;

            case 3:
                if(lista.isEmpty()) break;			//Daca lista nu are nici un element iese din switch
                listaTranzactii(lista);  			//Afiseaza lista de tranzactii
                optiuni(lista,d);   				//Afiseaza optiunile
                break;

            case 4:
                if(lista.isEmpty()) break;			//Daca lista nu are nici un element iese din switch
                verifica(lista,d);   				//Verifica daca o tranzactie este frauduloasa
                optiuni(lista,d);   				//Afiseaza optiunile
                break;

            case 5:
                if(lista.isEmpty()) break;			//Daca lista nu are nici un element iese din switch
                if(nrFrauda(lista, d)<=0) System.out.print("\nNu exista transactii frauduloase!!\n"); //Daca nr de tranzactii frauduloase e <= 0 afisam mesajul corespunzator
                else System.out.print("\nNr. de tranzactii frauduloase : "+nrFrauda(lista, d)+"\n"); 	//Altfel afisam nr. de tranzactii frauduloase
                optiuni(lista,d);                 													//Afiseaza optiunile
                break;

            case 6:
                System.out.print("\nNr. de tranzactii verificate (trebuie sa fie > 2) : ");
                optiuni(lista,new Scanner(System.in).nextInt()); //Afiseaza optiunile
                break;

            case 7:
                System.exit(0);    //Termina programul curent
                break;
        }
    }

    public static void main(String[] args) throws Exception {

        /* Cream un intreg d care sa retina nr de tranzactii anterioare ce trebuie verificare */
        int d=8;

        /* Cream o lista ordonata de tranzactii (ordonata dupa Data) */
        LDI lista = new LDI(Tranzactie.sortareData);

        /* Populam lista cu valori citite din fisier/ din functie (exemplele din cerinta) */
//      citireFisier(lista,"C:\\Users\\gadincu\\Desktop\\JAVA\\src\\listaTranzactii.txt"); - de modificat calea catre fisier daca este rulata pe alta sistem
        adaugaExemple(lista);

        /* Afisam header-ul programului */
        linii(1); System.out.print("Activitate Frauduloasa");
        linii(1); System.out.print("Nr minim de tranzactii : "+d+"\n");

        /* Apelam functia optiuni cu parametri lista si d */
        optiuni(lista,d);
    }
}