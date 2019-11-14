package BibliotecaApp.control;

import BibliotecaApp.model.Carte;
import BibliotecaApp.repository.repoInterfaces.CartiRepoInterface;
import java.util.List;
import BibliotecaApp.util.Validator;

public class BibliotecaCtrl {

	private CartiRepoInterface cr;
	
	public BibliotecaCtrl(CartiRepoInterface cr){
		this.cr = cr;
	}

	/**
	 * adauga o carte in repository
	 * @param c - o carte cu atributele: titlu, lista de autori, anAparitie, editura,
	 *            lista de cuvinte cuvinteCheie
	 * @throws Exception - daca obiectul c nu este valid
	 */
	public void adaugaCarte(Carte c) throws Exception{
		Validator.validateCarte(c);
		cr.adaugaCarte(c);
	}
	
	public void modificaCarte(Carte nou, Carte vechi) throws Exception{
		//cr.modificaCarte(nou, vechi);
		cr.modificaCarte(vechi, nou);
	}
	
	public void deleteCarte(Carte c) throws Exception{
		cr.stergeCarte(c);
	}
	
	public List<Carte> cautaCarte(String autor) throws Exception{
		Validator.isStringOK(autor);
		return cr.cautaCarte(autor);
	}
	
	public List<Carte> getCarti() throws Exception{
		return cr.getCarti();
	}
	
	public List<Carte> getCartiOrdonateDinAnul(String an) throws Exception{
		if(!Validator.isNumber(an))
			throw new Exception("Nu e numar!");
		return cr.getCartiOrdonateDinAnul(an);
	}
	
	
}
