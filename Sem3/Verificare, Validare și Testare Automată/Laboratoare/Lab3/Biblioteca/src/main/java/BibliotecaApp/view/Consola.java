package BibliotecaApp.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import BibliotecaApp.model.Carte;

import BibliotecaApp.control.BibliotecaCtrl;

public class Consola {

	private BibliotecaCtrl bc;
	private BufferedReader reader;
	
	public Consola(BibliotecaCtrl bc){
		this.bc=bc;
	}
	
    // rutina principala de functionare a interfetei consola
	public void executa(){

		reader = new BufferedReader(new InputStreamReader(System.in));
		
		int opt = -1;
		try {
			while (opt != 0) {

				switch (opt) {
					case 1:
						adauga();
						break;
					case 2:
						cautaCartiDupaAutor();
						break;
					case 3:
						afiseazaCartiOrdonateDinAnul();
						break;
					case 4:
						afiseazaToateCartile();
						break;
				}

				afiseazaMeniu();
				String line;
				do {
					System.out.println("Introduceti un nr:");
					line = reader.readLine();
				} while (!line.matches("[0-4]"));
				opt = Integer.parseInt(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// afiseaza optiunile impreuna cu operatiile permise
	public void afiseazaMeniu(){
		System.out.println("\n\n\n");
		System.out.println("Evidenta cartilor dintr-o biblioteca");
		System.out.println("     1. Adaugarea unei noi carti");
		System.out.println("     2. Cautarea cartilor scrise de un anumit autor");
		System.out.println("     3. Afisarea cartilor din biblioteca care au aparut intr-un anumit an, ordonate alfabetic dupa titlu si autori");
		System.out.println("     4. Afisarea tuturor cartilor");
		System.out.println("     0. Exit");
	}

	// rutina se ocupa de preluarea datelor de la utilzator necesare adaugarii unei carti noi
	public void adauga(){
		Carte c = new Carte();
		try{
			System.out.println("\n\n\n");
			
			System.out.println("Titlu:");
			c.setTitlu(reader.readLine());
			
			String line;
			do{
				System.out.println("An aparitie:");
				line= reader.readLine();
			}while(!line.matches("[0-9]+"));
			c.setAnAparitie(line);

            System.out.println("Editura:");
            c.setEditura(reader.readLine());
			
			do{
				System.out.println("Nr. de autori:");
				line= reader.readLine();
			}while(!line.matches("[1-9]+"));
			int nrAutori= Integer.parseInt(line);
			for(int i=1;i<=nrAutori;i++){
				System.out.println("Autor "+i+": ");
				c.adaugaAutor(reader.readLine());
			}
			
			do{
				System.out.println("Nr. de cuvinte cheie:");
				line= reader.readLine();
			}while(!line.matches("[1-9]+"));
			int nrCuv= Integer.parseInt(line);
			for(int i=1;i<=nrCuv;i++){
				System.out.println("Cuvant "+i+": ");
				c.adaugaCuvantCheie(reader.readLine());
			}
			
			bc.adaugaCarte(c);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// rutina de afisare a cartilor persistate in fisier
	public void afiseazaToateCartile(){
		System.out.println("\n\n\n");
		try {
			for(Carte c:bc.getCarti())
				System.out.println(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// preia numele unui autor introdus de utilziator si afiseaza cartile filtrate dupa autorul introdus
	public void cautaCartiDupaAutor(){
	
		System.out.println("\n\n\n");
		System.out.println("Autor:");
		try {
			for(Carte c:bc.cautaCarte(reader.readLine())){
				System.out.println(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    // preia un an introdus de utilziator si afiseaza cartile filtrate dupa anul de aparitie respectiv
	public void afiseazaCartiOrdonateDinAnul(){
		System.out.println("\n\n\n");
		try{
			String line;
			do{
				System.out.println("An aparitie:");
				line= reader.readLine();
			}while(!line.matches("[0-9]+"));
			for(Carte c:bc.getCartiOrdonateDinAnul(line)){
				System.out.println(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
