import java.util.*;
public class Problema1 {

	/*
	 * Algoritmul de bubbleSort, folosit sa sortam tabloul in ordine crescatoare
	 */
	private static void bubbleSort(int array[]){
		boolean flag = true;
		
		while(flag){
			flag = false;
			for(int i = 0; i < array.length-1; i++){
				if(array[i] > array[i+1]){
					int aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
					flag = true;
				}
			}
		}		
	}	
	
	/*
	 * Calculeaza suma elementelor din tabloul x
	 * A fost implementat sa verificam daca tabloul contine doar valori de 0 => suma trebuie sa fie 0
	 * In varianta finala a solutiei (nici in varianta 1 nici in varianta 2) nu a mai fost folosita
	 */
	public static int Suma(int x[]){
		int n=x.length,sum=0;
		for(int i=0;i<n;i++)
			sum+=x[i];
		return sum;
	}
	
	/*
	 * Face o operatie de taiere. Stim ca x este sortat, dar poate sa contina valori de 0 la inceput. Stim ca are macar o valoare non-zero
	 * Cautam prima valoare non-zero de la inceput (aceasta valoare va fi minimum non-zero) si scadem valoarea minimului din fiecare element de non-zero
	 * In timpul scaderii numaram cate elemente non-zero au ramas, si returnam acest numar
	 */
	public static int Taiere(int x[]) {
		int min,i=0,n=x.length;
		while(x[i]==0)
			i++;
		// i pozitia unde am primul element nonzero
		min=x[i]; // 
		int ramase=0;
		for(int j=i;j<n;j++) {
			x[j]-=min;
			if(x[j]>0) ramase++;
		}
		return ramase;
	}
	
	/*
	 * Functie care citeste un vector. Citeste prima data lungimea, dupa aceea elementele. Returneaza vectorul
	 */
	public static int[] citire(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Lungimea arrayului:");
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		return a;
	}
	
	/*
	 * Prima varianta de solutie:
	 * Sortam array-ul
	 * Repetam operatii de Taiere pana la un moment dat Taiere ne returneaza 0, insemnand ca mai sunt 0 elemente nenule
	 * Initial acest cod era in main, l-am mutat intr-o functie separate sa se vada cele 2 variante mai clar 
	 */
	public static void varianta1(int[] array) {
		bubbleSort(array);
		int lungime = array.length;
		while (lungime != 0) {
			System.out.println(lungime);
			lungime = Taiere(array);
		}
		
	}
	
	/*
	 * Putem observa ca la fiecare operatie de taiere dispar (adica devin 0) din vector elementele egale cu minim. Daca este un singur minim, dispare un singur element,
	 * daca sunt mai multe valori egale de minim, dispar toate.  
	 * Deci, nu trebuie sa facem efectiv operatii de taiere, e suficient sa vedem cate "minime" vor fi.
	 * Presupunem ca vectorul e sortat  
	 */
	public static void varianta2(int[] array) {
		bubbleSort(array);
		System.out.println(array.length);
		int i = 0;
		int minCurent = array[0]; //primul element e minimum 
		while (i < array.length) {
			while(i < array.length && minCurent == array[i]) { //trecem prin toate elementele egale cu minim - toate o sa dispare deodata la o operatie de taiere
				i++;
			}
			if (i < array.length) {
				int ramase = array.length - i; //cate elemente raman 
				System.out.println(ramase);
				minCurent = array[i]; // resetam minimul curent				
				i++;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] array = citire();
		varianta1(array);
		//varianta2(array);
		//rulati doar una dintre ele. Varianta1 "distruge" array-ul, dupa ce se ruleaza varianta1, in array sunt doar valori de 0. Deci degeaba mai rulam si varianta 2 dupa, nu vom
		//avea rezultatul corect pentru varianta2.
		
	}
}
