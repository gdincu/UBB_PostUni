import java.io.*;
import java.util.*;

public class Aplicatie {

	/* Metoda de citire a unui intreg de la tastatura */
	public static int CitIntreg(String A){
		System.out.println(A);
		return (new Scanner(System.in).nextInt());
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
	public static void AfisTot(int n,Anvelopa A[]){
		capTabel("Denumire","Tip","StocInit","Vandute","PretUnit");
		for(int i=0;i<n;i++)
			System.out.print("\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s|%-15s",A[i].getNume(),A[i].getTip(),A[i].getStocI(),A[i].getVandut(),A[i].getPretUnit()));
		System.out.println();
	}

	/* Metoda de afisare a stocului epuizat */
	public static void AfisEpuizate(int n, Anvelopa A[]){
		capTabel("Denumire","Tip","StocInit","Vandute","PretUnit");
		for(int i=0;i<n;i++)
			  if(A[i].getStocI()==A[i].getVandut())
				  System.out.print("\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s|%-15s",A[i].getNume(),A[i].getTip(),A[i].getStocI(),A[i].getVandut(),A[i].getPretUnit()));
		System.out.println();
	}

	/* Metoda de afisare a stocului disponibil */
	public static void AfisDisponibile(int n, Anvelopa A[]){
		capTabel("Denumire","Tip","Disponibile","PretUnit","");
		for(int j=0;j<n;j++)
			if(A[j].getStocI()>A[j].getVandut())
				System.out.print("\n"+new Formatter().format("%-30s|%-15s|%-15s|%-15s",A[j].getNume(),A[j].getTip(),A[j].getStocI()- A[j].getVandut(),A[j].getPretUnit()));
		System.out.println();
			}

	/* Metoda de citire din fisier */
	public static int CitireDinFisier(Anvelopa A[]){
		int n=0;
		try {
		      BufferedReader fisIn = 
			  new BufferedReader(new FileReader("C:\\Users\\gadincu\\Desktop\\Cursuri_FPA\\Examen\\MagazinAnvelope\\src\\Magazin.txt"));
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

	/* Metoda de afisare a meniului */
	public static int Meniu(){
		System.out.println("\n1.Citire date din fisier");
		System.out.println("2.Afisare toata marfa");
		System.out.println("3.Afisare disponibile");
		System.out.println("4.Afisare epuizate");
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
			default:
				   System.out.println("ai gresit optiunea, mai incearca!!!");
			}
			opt=Meniu();
		}
		System.out.println("Program terminat");
	}	
}