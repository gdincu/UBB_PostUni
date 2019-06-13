import java.io.*;
import java.util.*;

public class Aplicatie {

    /* Metoda de citire a unui intreg de la tastatura */
    private static int CitIntreg(String A){
        System.out.print(A);
        return (new Scanner(System.in).nextInt());
    }

    /* Metoda de citire a unui String de la tastatura */
    private static String CitString(String A){
        System.out.print(A);
        return (new Scanner(System.in).nextLine());
    }

    /* Metoda de afisare a capului de tabel */
    private static void capTabel(String h1,String h2,String h3,String h4,String h5){
        //Normal - Denumire\tTip\tStocInit\tVandute\tPretUnit"
        //1 - Denumire\tTip\tDisponibile\tPretUnit"
        String linii="========================================================================================";
        if(h5=="") System.out.print(linii+"\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s",h1,h2,h3,h4)+"\n"+linii);
        else System.out.print(linii+"\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s|%-15s",h1,h2,h3,h4,h5)+"\n"+linii);
    }

    /*Metoda de afisare a intregului stoc */
    private static void AfisTot(int n,Anvelopa A[]){
        capTabel("Denumire","Tip","StocInit","Vandute","PretUnit");
        for(int i=0;i<n;i++)
            System.out.print("\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s|%-15s",A[i].getNume(),A[i].getTip(),A[i].getStocI(),A[i].getVandut(),A[i].getPretUnit()));
        System.out.println();
    }

    /* Metoda de afisare a stocului epuizat */
    private static void AfisEpuizate(int n, Anvelopa A[]){
        capTabel("Denumire","Tip","StocInit","Vandute","PretUnit");
        for(int i=0;i<n;i++)
            if(A[i].getStocI()==A[i].getVandut())
                System.out.print("\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s|%-15s",A[i].getNume(),A[i].getTip(),A[i].getStocI(),A[i].getVandut(),A[i].getPretUnit()));
        System.out.println();
    }

    /* Metoda de afisare a stocului disponibil */
    private static void AfisDisponibile(int n, Anvelopa A[]){
        capTabel("Denumire","Tip","Disponibile","PretUnit","");
        for(int j=0;j<n;j++)
            if(A[j].getStocI()>A[j].getVandut())
                System.out.print("\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s",A[j].getNume(),A[j].getTip(),A[j].getStocI()- A[j].getVandut(),A[j].getPretUnit()));
        System.out.println();
    }

    /* Metoda de citire din fisier */
    private static int CitireDinFisier(Anvelopa A[]){
        int n=0;
        try {
            BufferedReader fisIn =
                    new BufferedReader(new FileReader("C:\\Users\\gadincu\\Desktop\\Cursuri_FPA\\Examen\\2_Anvelope_ComparatorTip\\src\\Magazin.txt"));
            String s;
            while((s = fisIn.readLine())!= null){
                A[n]=new Anvelopa();

                String felii[]=s.split(",");
                A[n].setNume(felii[0]);
                A[n].setTip(felii[1]);
                A[n].setStocI(Integer.parseInt(felii[2]));
                A[n].setVandut(Integer.parseInt(felii[3]));
                A[n].setPretUnit(Integer.parseInt(felii[4]));

                n++;
            }
            fisIn.close();
        } // try
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } // catch									//citiri valorile vectorului
        return n;
    }

    /* Metoda de cumparare */
    private static void cumpara(int n,Anvelopa[] A) {
        String tip=CitString("\nTip de anvelope cumparate : ");
        String denumire=CitString("Denumire : ");
        int cantitate=CitIntreg("Cantitate : ");
        for(int i=0;i<n;i++) {
            if (i==n-1 && !tip.equals(A[i].getTip()) && !denumire.equals(A[i].getNume())) {
                System.out.print("\nProdusul nu exista in stoc!!!\n");
                return;
            }

            if (tip.equals(A[i].getTip()) && denumire.equals(A[i].getNume()) && cantitate > (A[i].getStocI() - A[i].getVandut())) {
                System.out.print("\nStoc insuficient!!!\n");
                return;
            }

            if (tip.equals(A[i].getTip()) && denumire.equals(A[i].getNume()) && cantitate <= (A[i].getStocI() - A[i].getVandut())) {
                A[i].setVandut(A[i].getVandut() + cantitate);
                System.out.print("\nCumparatura finalizata cu success!!\n");
                return;
            }
        }
    }

    /* Metoda de actualizare a BD */
    private static Anvelopa[] actualizareBD(int n,Anvelopa[] A) {
    int count=0,index =0;
        Set<Anvelopa> temp=new HashSet<Anvelopa>();
        for(int i=0;i<n;i++)
        if(A[i].getStocI()-A[i].getVandut()>0) {
            count++;
            temp.add(A[i]);
        }

        Anvelopa[] temp2=new Anvelopa[count];
        Iterator<Anvelopa> i=temp.iterator();
        while(i.hasNext()) {
            temp2[index]=i.next();
            index++;
        }
        return temp2;
    }

    /* Metoda de stergere */
    private static Anvelopa[] sterge(int n, Anvelopa[] A) {
        int prag=CitIntreg("\nProcent minim de vanzari : ");
        int count=0,index =0;
        Set<Anvelopa> temp=new HashSet<Anvelopa>();
        for(int i=0;i<n;i++)
            if(A[i].getVandut()/A[i].getStocI() >= prag/100) {
                temp.add(A[i]);
                count++;
            }

        Anvelopa[] temp2=new Anvelopa[count];
        Iterator<Anvelopa> i=temp.iterator();
        while(i.hasNext()) {
            temp2[index]=i.next();
            index++;
        }
        return temp2;
    }

    /* Metoda de sortare dupa n */
    private static void sortareNume(int n,Anvelopa[] A) {
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                if(A[i].getNume().compareTo(A[j].getNume()) > 0) {
                    String temp=A[i].getNume();
                    A[i].setNume(A[j].getNume());
                    A[j].setNume(temp);
                }
    }

    /* Metoda de afisare dupa tip */
    private static void afiseazaDupaTip(int n,Anvelopa[] A) {
    //Salvam valorile tip intr-un set pentru a elimina duplicatele
    Set<String> t1=new HashSet<String>();
    for(int i=0;i<n;i++) t1.add(A[i].getTip());

    Set<Anvelopa> t2=new HashSet<Anvelopa>();
    Iterator<String> i=t1.iterator();
    while(i.hasNext())
        t2.add(new Anvelopa("",i.next(),0,0,0));

    Iterator<Anvelopa> t3=t2.iterator();
    while(t3.hasNext()) {
        Anvelopa temporar = t3.next();
        for (int j = 0; j < n; j++)
            if (A[j].getTip().equals(temporar.getTip())) {
                temporar.setVandut(temporar.getVandut() + A[j].getVandut());
                temporar.setStocI(temporar.getStocI() + A[j].getStocI());
                temporar.setPretUnit(temporar.getPretUnit() + A[j].getPretUnit() * A[j].getVandut());
            }
    }

    Iterator<Anvelopa> t4=t2.iterator();
    while(t4.hasNext()) {
     Anvelopa finala=t4.next();
        System.out.print("\n" +finala.getTip()+" - "+finala.getStocI()+" - "+finala.getVandut()+" - "+finala.getPretUnit());
    }
        System.out.println();
    }

    /* Metoda de afisare a meniului */
    private static int Meniu(){
        System.out.println("\n1.Citire date din fisier");
        System.out.println("2.Afisare toata marfa");
        System.out.println("3.Afisare disponibile");
        System.out.println("4.Afisare epuizate");
        System.out.println("5.Cumpara");
        System.out.println("6.Actualizeaza BD");
        System.out.println("7.Sterge produsele cu vanzari slabe");
        System.out.println("8.Sortare dupa nume");
        System.out.println("0.Terminare program");
        return(CitIntreg("Optiune : "));
    }

    public static void main(String[] args) {

        Anvelopa A[] = new Anvelopa[10];
        int lung=0;	   //numarul de elemente al vectorului A

        int opt=Meniu();
        while(opt!=0){
            switch(opt){
                case 1:lung=CitireDinFisier(A);
                    System.out.println("am citit corect datele din fisier");
                    break;
                case 2:AfisTot(lung,A); 		//Afiseaza tot tabelul
                    break;
                case 3:AfisDisponibile(lung,A);	//Afiseaza marfa existenta
                    break;
                case 4:AfisEpuizate(lung,A);	//Afisare marfa epuizata
                    break;
                case 5:
                    cumpara(lung,A);
                    break;
                case 6:
                    A=actualizareBD(lung,A);
                    lung=A.length;
                    break;
                case 7:
                    A=sterge(lung,A);
                    lung=A.length;
                    break;
                case 8:
                    sortareNume(lung,A);
                    break;
                case 9:
                    afiseazaDupaTip(lung,A);
                    break;
                default:
                    System.out.println("ai gresit optiunea, mai incearca!!!");
            }
            opt=Meniu();
        }
        System.out.println("Program terminat");
    }
}