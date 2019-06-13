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
    public static void capTabel(String h1,String h2,String h3,String h4,String h5){
        //Normal - Denumire\tTip\tStocInit\tVandute\tPretUnit"
        //1 - Denumire\tTip\tDisponibile\tPretUnit"
        String linii="========================================================================================";
        if(h5=="") System.out.print(linii+"\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s",h1,h2,h3,h4)+"\n"+linii);
        else System.out.print(linii+"\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s|%-15s",h1,h2,h3,h4,h5)+"\n"+linii);
    }

    /*Metoda de afisare a intregului stoc */
    public static void AfisTot(int n,Vin A[]){
        capTabel("Denumire","Tip","StocInit","Vandute","PretUnit");
        for(int i=0;i<n;i++)
            System.out.print("\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s|%-15s",A[i].getDenumire(),A[i].getTip(),A[i].getStocI(),A[i].getVandut(),A[i].getPretUnit()));
        System.out.println();
    }

    /* Metoda de afisare a stocului epuizat */
    public static void AfisEpuizate(int n, Vin A[]){
        capTabel("Denumire","Tip","StocInit","Vandute","PretUnit");
        for(int i=0;i<n;i++)
            if(A[i].getStocI()==A[i].getVandut())
                System.out.print("\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s|%-15s",A[i].getDenumire(),A[i].getTip(),A[i].getStocI(),A[i].getVandut(),A[i].getPretUnit()));
        System.out.println();
    }

    /* Metoda de afisare a stocului disponibil */
    public static void AfisDisponibile(int n, Vin A[]){
        capTabel("Denumire","Tip","Disponibile","PretUnit","");
        for(int j=0;j<n;j++)
            if(A[j].getStocI()>A[j].getVandut())
                System.out.print("\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s",A[j].getDenumire(),A[j].getTip(),A[j].getStocI()- A[j].getVandut(),A[j].getPretUnit()));
        System.out.println();
    }

    
    
    /* Metoda de citire din fisier */
    public static int CitireDinFisier(Vin A[]) throws FileNotFoundException, Exception{
    
    	Scanner citireData = new Scanner(new File("C:\\Users\\Pavilion\\Desktop\\Cursuri_FPA\\Examen\\1_Anvelope_CumparaSterge\\src\\fisier.txt"));      														//Cream o noua instanta a clasei Scanner ce foloseste fisierul ca si input
        citireData.useDelimiter("[/\\r\\n]");         																//Setam delimitatorul ca si o noua linie - \r\n echivalentul Enter
        int n=0;
        while(citireData.hasNext()) {           																		//Cat timp exista o linie urmatoare
        
         String s=citireData.nextLine();				//Un string temporar s ia valoarea intregii linii
         String felii[]=s.split(",");  
                A[n]=new Vin();
                
                A[n].setDenumire(felii[0]);
                A[n].setTip(felii[1]);
                A[n].setStocI(Integer.parseInt(felii[2]));
                A[n].setVandut(Integer.parseInt(felii[3]));
                A[n].setPretUnit(Integer.parseInt(felii[4]));

                n++;
            }
        return n;
    }

    /* */
    public static void sterge(int n, Vin[] A) {
    	capTabel("Denumire","Tip","StocInit","Vandute","PretUnit");
        for(int j=0;j<n;j++)
            if(A[j].getVandut() >= A[j].getStocI()/2)
                System.out.print("\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s",A[j].getDenumire(),A[j].getTip(),A[j].getStocI(),A[j].getVandut(),A[j].getPretUnit()));
        System.out.println();
    }

    /* Metoda de afisare a meniului */
    public static int Meniu(){
        System.out.println("\n1.Citire date din fisier");
        System.out.println("2.Afisare toata marfa");
        System.out.println("3.Afisare disponibile");
        System.out.println("4.Afisare epuizate");
        System.out.println("5.Afisare vanzari 50%+");
        System.out.println("0.Terminare program");
        return(CitIntreg("Optiune : "));
    }

    public static void main(String[] args) throws FileNotFoundException, Exception {

    	Vin A[] = new Vin[10];
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
                	sterge(lung,A);
                    break;
                default:
                    System.out.println("ai gresit optiunea, mai incearca!!!");
            }
            opt=Meniu();
        }
        System.out.println("Program terminat");
    }
}