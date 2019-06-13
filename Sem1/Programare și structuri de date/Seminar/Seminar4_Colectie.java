
public class Colectie {

	private String[] elemente; //vector de elemente
	private int cap; // capacitatea
	private int len; // pozitii ocupate in vector
	private int[] frecvente; //vector de frecvente
	private int dim; // nr total de elemente din colectie  (suma frecventelor)
	
	public Colectie(){
		
		this.len = 0;
		this.dim = 0;
		this.cap = 6; //putem lua cat vrem noi
		this.elemente = new String[this.cap];
		this.frecvente = new int[this.cap];
	}
	
	public void adauga(String elem) {
		//verificam daca mai este spatiu
		//verificam daca exista elementul deja
		//daca exista incrementam frecventa
		//daca nu exista adaugam elementul cu frecventa 1
		//crestem vectorul
		boolean gasit = false;
		int index = 0;
		while (gasit == false && index < this.len) {
			if (elem.equals(this.elemente[index])) {
				this.frecvente[index] ++;
				this.dim++;
				gasit = true;
			} else {
				index ++; // mergem la pozitia urmatoare
			}
		} //O(len)
		
		if (gasit == false) { // nu am gasit elementul in vector
			if (this.len == this.cap) { //verificam daca avem spatiu
				String[] elementeN = new String[this.cap * 2];
				for (int i = 0; i < this.len; i++) {
					elementeN[i] = this.elemente[i];
				}
				int[] frecventeN = new int[this.cap * 2];
				for (int i = 0; i < this.len; i++) {
					frecventeN[i] = this.frecvente[i];
				}
				this.elemente = elementeN;
				this.frecvente = frecventeN;
				this.cap = this.cap * 2;
			} // Theta(len)
			//stim sigur ca avem spatiu
			this.elemente[this.len] = elem;
			this.frecvente[this.len] = 1;
			this.len++;
			this.dim++;
		}
	} //O(len)
	
	public int dimensiune(){
		return this.dim;
	}
	
	public void sterge(String elem) {
		//verificam daca elementul e in vectorul elemente
		//daca nu e => nu facem nimic
		//daca este => verificam frecventa
		//					- frecventa > 1 decrementam frecventa
		//					- frecventa = 1 - mutam ultimul element (element + frecventa) pe pozitia de unde stergem
		
	}
	
	public boolean cauta(String elem) {
		return false;
	}
	
	public  IteratorColectie   iterator(){
		return new IteratorColectie(this);
	}
	
	class IteratorColectie {
		
		private int pozitieCurenta;
		private int frecventaCurenta;
		private Colectie c;
		
		public IteratorColectie(Colectie c) {
			this.c = c;
			this.pozitieCurenta = 0;
			this.frecventaCurenta = 1;
		}
		
		public String element(){
			return this.c.elemente[this.pozitieCurenta];
		}
		
		public void urmator(){
			if (this.frecventaCurenta < this.c.frecvente[this.pozitieCurenta]) {
				this.frecventaCurenta++;
			} else {
				this.pozitieCurenta++;
				this.frecventaCurenta = 1;
			}
		}
		
		public boolean valid(){
			if (this.pozitieCurenta == this.c.len) {
				return false;
			} else {
				return true;
			}
		}
		
		
	}
	
	
}
