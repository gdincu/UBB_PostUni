
public class Applicatie {

	
	public static void main(String[] args) {
		
		LSI lista = new LSI();
		lista.adaugaInceput(7);	
		lista.adaugaInceput(12);
		lista.adaugaInceput(31);
		lista.adaugaInceput(66);
		
		System.out.println("Afisare inainte de stergere");
		for (int i = 0; i < lista.lungime(); i++) {
			System.out.println(lista.getElement(i));
		}
		System.out.println("Afisare dupa stergere");
		lista.stergeElement1(77);
		for (int i = 0; i < lista.lungime(); i++) {
			System.out.println(lista.getElement(i));
		}
	}
}
