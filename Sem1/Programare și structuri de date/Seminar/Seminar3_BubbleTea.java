import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class BubbleTea {

	public static void main(String[] args) {
		//citim datele si le retine in 2 dictionare si un multidictionar
		Scanner sc = new Scanner(System.in);
		int nrCeaiuri = sc.nextInt();
		Map<Integer, Integer> pretCeai = new HashMap<Integer, Integer>();
		for (int i = 1; i <= nrCeaiuri; i++) {
			int pret = sc.nextInt();
			pretCeai.put(i, pret);
		}
		int nrTopping = sc.nextInt();
		Map<Integer, Integer> pretTopping = new HashMap<Integer, Integer>();
		for (int i = 1; i <= nrTopping; i++) {
			int pret = sc.nextInt();
			pretTopping.put(i,  pret);
		}
		
		MultiDictionar<Integer, Integer> compatibilitate = new MultiDictionarImpl<Integer, Integer>();
		for (int i = 1; i <= nrCeaiuri; i++) {
			int nrToppingCompatibil = sc.nextInt();
			for (int j = 1; j <= nrToppingCompatibil; j++) {
				int topping = sc.nextInt();
				compatibilitate.adauga(i, topping);
			}
		}
		int sumaBani = sc.nextInt();
		
		Iterator<Map.Entry<Integer, Integer>> it = compatibilitate.iterator();
		while (it.hasNext()) {
			//aici vine partea de a gasi ceaiul cu pretul minim - completati voi :)
			Map.Entry<Integer, Integer> element = it.next();
			System.out.println(element.getKey() + "  " + element.getValue());
		}
		
		//daca stiti pretul minim, mai trebuie sa aflati la cati studenti poate 
		//profesorul sa ia ceai.
		
	}
	
}
