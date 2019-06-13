import java.util.Scanner;


public class Applicatie {

	public static void printMeniu(){
		System.out.println("1. Adaugare ");
		System.out.println("2. Afisare Colectie: ");
		System.out.println("0. Exit");
		System.out.print("Alegeti o optiune:");
	}
	
	public static void adaugare(Colectie c) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Elementul de adaugat: ");
		String element = sc.nextLine();
		c.adauga(element);
	}
	
	public static void afisare(Colectie c){
		System.out.println("Continutul colectiei: ");
		Colectie.IteratorColectie ic = c.iterator();
		while (ic.valid()) {
			String elem = ic.element();
			System.out.println(elem);
			ic.urmator();
		}
	}
	
	public static void main(String[] args) {
		
		
		Colectie c = new Colectie();
		int optiune = 1;
		Scanner sc = new Scanner(System.in);
		while (optiune != 0) {
			printMeniu();
			optiune = sc.nextInt();
			if (optiune == 1) {
				adaugare(c);
			} else if (optiune == 2) {
				afisare(c);
			}
		}
	}
	
}
