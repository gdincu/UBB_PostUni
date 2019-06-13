
public class LSI {
	
	private Nod prim; //adresa primului nod
	private int lungime; //numarul de noduri din lista

	public LSI(){
		this.prim = null;
		this.lungime = 0;
	} // Complexitate: Theta(1)
	
	//adauga la inceput un element
	public void adaugaInceput(int elem) {
		Nod n = new Nod();
		n.setElem(elem);
		n.setUrm(null);
		
		if (this.prim == null) {
			//lista e vida
			this.prim = n;
			
		} else {		
			// n.urm = prim
			n.setUrm(this.prim);
			this.prim = n;
		}
		this.lungime++;
	} //Complexitate: Theta(1)
	
	//adauga la sfarsit un element
	public void adaugaSfarsit(int elem) {
		
	}
	
	//adauga pe o pozitie un element
	public void adaugaPozitie(int elem, int pozitie) {
		
	}
	
	//sterge un element -> returneaza true daca s-a gasit si s-a sters 
	//elementul, false altfel
	//varianta in care facem parcurgere cu un singur nod
	public boolean stergeElement1(int elem) {
		Nod nodCurent = this.prim;
		// nodCurent.getUrm().getElem() elementul din nodul de dupa nodCurent
		// nodCurent == null
		//nodCurent e ultimul nod => nodCurent.getUrm() == null
		//nodCurent.getUrm() == null
		if (this.prim == null) {
			return false;
		}
		
		if (nodCurent.getElem() == elem) {
			//trebuie sa sterg primul element
			this.prim = this.prim.getUrm();
			this.lungime--;
			return true;
		}
		
		while (nodCurent.getUrm() != null && nodCurent.getUrm().getElem() != elem) {
			nodCurent = nodCurent.getUrm();
		}
		if (nodCurent.getUrm() == null) {
			//s-a terminat lista, nu am gasit elementul
			return false;
		}
		nodCurent.setUrm(nodCurent.getUrm().getUrm());
		this.lungime--;
		return true;
	}
	
	//sterge un element -> returneaza true daca s-a gasit si s-a sters 
	//elementul, false altfel
	//varianta in care facem parcurgere cu doua noduri
	// e OPTIONALA
	public boolean stergeElement2(int elem) {
			//cautam elementul
			//
			return false;
		}
	
	//verifica daca un element este sau nu in lista
	public boolean cauta(int elem) {
		return false;
	}
	
	//returneaza numarul de elemente din lista
	public int lungime(){
		return this.lungime;
	} //Complexitate: Theta(1)
	
	//verifica daca lista e vida
	public boolean vida(){
		return false;
	}
	
	//returneaza un element de pe o pozitie (aruncam exceptie daca pozitia
	//nu e valida)
	public int getElement(int pozitie) {
		//verificam daca pozitia e buna
		//daca pozitia nu e valida aruncam exceptie
		if (pozitie < 0 || pozitie >= this.lungime) {
			throw new RuntimeException();
		}

		//luam un nod curent 
		Nod nodCurent = this.prim;
		//folosim ciclu pentru, facem pozitie iteratii
		for (int i =0; i < pozitie; i++) {
			//nodCurent = [nodCurent].urm
			nodCurent = nodCurent.getUrm();
		}
		//returnam elementul din nodul curent		
		return nodCurent.getElem();
	} //Complexitate: O(lungime) 
	
}
