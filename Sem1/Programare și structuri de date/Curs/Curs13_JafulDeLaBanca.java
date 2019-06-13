import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class JafulDeLaBanca {
	
	public static void main(String[] args) {	

		Suspect s5 = new Suspect (811, 750, 14, 12.4);
		Suspect s6 = new Suspect (731, 739, 12.3, 15.2);
		Suspect s7 = new Suspect (355, 750, 15.7, 11.9);
		Suspect s8 = new Suspect (811, 750, 14, 12.4);

		
		Set <Suspect> Multime1 = new HashSet <Suspect>();	
		Multime1.add(s5);
		Multime1.add(s6);
		Multime1.add(s7);
		Multime1.add(s8);
		
		for (Suspect s: Multime1) {
			System.out.println(s);
			System.out.println(s.hashCode());
		}
		
		
	}	
}
