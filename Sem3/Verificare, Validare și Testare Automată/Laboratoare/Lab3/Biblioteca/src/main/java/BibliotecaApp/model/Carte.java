package BibliotecaApp.model;

import java.util.ArrayList;
import java.util.List;

public class Carte {
	
	private String titlu;
	private List<String> autori;
    private String anAparitie;
    private String editura;
	private List<String> cuvinteCheie;
	
	public Carte(){
		titlu = "";
		autori = new ArrayList<String>();
		anAparitie = "";
		editura = "";
		cuvinteCheie = new ArrayList<String>();
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public List<String> getAutori() {
		return autori;
	}

	public void setAutori(List<String> autor) {
		this.autori = autor;
	}

	public String getAnAparitie() {
		return anAparitie;
	}

	public void setAnAparitie(String anAparitie) {
		this.anAparitie = anAparitie;
	}

	public String getEditura(){return editura;}

    public void setEditura(String ed) {editura = ed;}

	public List<String> getCuvinteCheie() {
		return cuvinteCheie;
	}

	public void setCuvinteCheie(List<String> cuvinteCheie) {
		this.cuvinteCheie = cuvinteCheie;
	}
	

	public void deleteCuvantCheie(String cuvant){
			for(int i=0;i<cuvinteCheie.size();i++){
				if(cuvinteCheie.get(i).equals(cuvant)){
					cuvinteCheie.remove(i);
					return;
				}
			}
	}
	
	public void deleteAutor(String autor){
			for(int i = 0; i< autori.size(); i++){
				if(autori.get(i).equals(autor)){
					autori.remove(i);
					return;
				}
			}
	}
	
	public void deleteTotiAutorii(){
		autori.clear();
	}
	
	public void adaugaCuvantCheie(String cuvant){
		cuvinteCheie.add(cuvant);
	}
	
	public void adaugaAutor(String autor){
		autori.add(autor);
	}
	
	public boolean cautaDupaCuvinteCheie(List<String> cuvinte){
		for(String c:cuvinteCheie){
			for(String cuv:cuvinte){
				if(c.equals(cuv))
					return true;
			}
		}
		return false;
	}
	 
	public boolean cautaDupaAutor(String autor){
		for(String a: autori){
			if(a.contains(autor))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		String autor = "";
		String cuvCheie = "";
		
		for(int i = 0; i< autori.size(); i++){
			if(i== autori.size()-1)
				autor+= autori.get(i);
			else
				autor+= autori.get(i)+",";
		}
		
		for(int i=0;i<cuvinteCheie.size();i++){
			if(i==cuvinteCheie.size()-1)
				cuvCheie+=cuvinteCheie.get(i);
			else
				cuvCheie+=cuvinteCheie.get(i)+",";
		}
		
		return titlu+";"+autor+";"+anAparitie+";"+editura+";"+cuvCheie;
	}

	// returneaza un obiect de tip Carte construit din string-ul trimis ca parametru (care respecta formatul unei carti asa cum este ea prezenta in fisier)
	public static Carte getCarteFromString(String carte){
		Carte c = new Carte();
		String []atr = carte.split(";");
		String []autori = atr[1].split(",");
		String []cuvCheie = atr[4].split(",");
		
		c.titlu=atr[0];
        c.editura=atr[3];
		for(String s:autori){
			c.adaugaAutor(s);
		}
		c.anAparitie = atr[2];
		for(String s:cuvCheie){
			c.adaugaCuvantCheie(s);
		}
		
		return c;
	}
	
}
