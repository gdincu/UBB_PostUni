import java.util.Arrays;
import java.util.Random;

/*
 * Clasa care contine implementari pentru cele 3 variante de solutii pentru Bete
 * plus cod pentru a genera un vector cu elemente aleatoare si a masura 
 * timpul de rulare pentru cele 3 variante.
 */
public class Bete {

	//------------------VARIANTA 1 ----------------------------------------
	
	//cauta minimum dintre valori non-zero din vector
	public static int minimum(int[] bete) {
		int min = Integer.MAX_VALUE; 
		//Integer.MAX_VALUE e cea mai mare valoare posibila pentru un intreg
		for (int i = 0; i < bete.length; i++) {
			if (bete[i] > 0 && bete[i] < min) {
				min = bete[i];
			}
		}
		return min;
	}
	
	//reducem toate lungimile non-zero cu o valoare data 
	//si numaram cate valori non-zero raman
	public static int reduce(int[] bete, int valoare) {
		int nrNonZero = 0;
		for (int i = 0; i < bete.length; i++) {
			if (bete[i] > 0) {
				bete[i] = bete[i] - valoare;
			}
			if (bete[i] > 0) { // daca si dupa scadere e mai mare
				nrNonZero++;
			}
		}
		return nrNonZero;
	}
	
	public static void varianta1(int[] bete) {
		//aici vom retine numarul de elemente non-zero
		int elemente = bete.length;
		while (elemente > 0) {
			//prima data afisam numarul de elemente 
			//am comentat afisarea pentru ca la vectori mari, ne incurca afisarile
			//System.out.println(elemente);
			int min = minimum(bete);
			elemente = reduce(bete, min);
		}
	}
	//----------------------VARIANTA 2 ----------------------------------
	
	//algoritm pentr a sorta elementele unui vector
	public static void bubbleSort(int array[]){
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
	
	//o operatie de taiere. presupunem ca vectorul x este ordonat
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
	
	public static void varianta2(int[] bete) {
		bubbleSort(bete);
		int lungime = bete.length;
		while (lungime != 0) {
			//System.out.println(lungime);
			lungime = Taiere(bete);
		}
	}
	//--------------------VARIANTA 3-------------------------------
	//folosim bubbleSort si aici
	public static void varianta3(int[] bete) {
		bubbleSort(bete);
		//System.out.println(bete.length);
		int i = 0;
		int minCurent = bete[0]; //primul element e minimum 
		while (i < bete.length) {
			while(i < bete.length && minCurent == bete[i]) { //trecem prin toate elementele egale cu minim - toate o sa dispare deodata la o operatie de taiere
				i++;
			}
			if (i < bete.length) {
				int ramase = bete.length - i; //cate elemente raman 
				//System.out.println(ramase);
				minCurent = bete[i]; // resetam minimul curent				
				i++;
			}
		}
	}
	
	//functie care genereaza un vector random cu N elemente 
	//(fiecare elemente are valoare intre 1 si N)
	public static int[] genereazaVector(int N) {
		int[] vector = new int[N];
		Random r = new Random(); 
		//Random e o clasa din Java, care poate fi folosit pentru a genera 
		//numere random (aleatoare)
		
		for (int i = 0; i < N; i++) {
			vector[i] = r.nextInt(N) + 1; 
			//nextInt(N) ne da un numar intre 0 si N-1. 
			//Adunam 1 sa fim siguri ca avem o valoare intre 1 si N. 
		}
		return vector;
	}
	
	//---------------------------------------------------
	public static void main(String[] args) {
		int nrElemente = 10000; //cate elemente vrem sa aiba vectorul
		//generam un vector cu numere random
		int[] elemente = genereazaVector(nrElemente);
		//facem 3 copii dupa vectorul (algoritmii varianta1, varianta2, varianta3 
		//"distrug" vectorul - modifica elementele, trebuie sa avem cate un vector 
		//pentru fiecare).
		//Arrays.copyof e functie din Java, care copiaza un vector
		int[] copie1 = Arrays.copyOf(elemente, elemente.length);
		int[] copie2 = Arrays.copyOf(elemente, elemente.length);
		int[] copie3 = Arrays.copyOf(elemente, elemente.length);
		
		//System.nanoTime returneaza timpul curent (sub forma de nanosecunde)
		long startTime1 = System.nanoTime();
		varianta1(copie1);
		//am masurat timpul inainte de a incepe functia varianta1. 
		//Masuram si dupa (tot cu System.nanoTime), iar diferenta este numarul de 
		//nanosecunde care erau necesare pentru varianta1. Impartim diferenta la 
		//1.000.000.000 ca sa avem secunde, in loc de nanosecunde.
		double duration1 = (System.nanoTime()-startTime1) / 1000000000.0;
		
		//facem la fel cu pentru varianta2
		long startTime2 = System.nanoTime();
		varianta2(copie2);
		double duration2 = (System.nanoTime() - startTime2)/1000000000.0;
		
		//si varianta3
		long startTime3 = System.nanoTime();
		varianta3(copie3);
		double duration3 = (System.nanoTime() - startTime3)/1000000000.0;
		
		System.out.println("Varianta1: " + duration1);
		System.out.println("Varianta2: " + duration2);
		System.out.println("Varianta3: " + duration3);
	}
	
}
