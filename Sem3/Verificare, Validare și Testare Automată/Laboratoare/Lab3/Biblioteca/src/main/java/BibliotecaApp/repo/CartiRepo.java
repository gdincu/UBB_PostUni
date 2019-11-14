package BibliotecaApp.repo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import BibliotecaApp.model.Carte;
import BibliotecaApp.repository.repoInterfaces.CartiRepoInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartiRepo implements CartiRepoInterface{
	
	private String file = "data/cartiBD.dat";
	
	public CartiRepo(){
		URL location = CartiRepo.class.getProtectionDomain().getCodeSource().getLocation();
//        System.out.println(location.getFile());
	}

	// scrie cartea transmisa ca parametru in fisier
	@Override
	public void adaugaCarte(Carte c) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(c.toString());
			bw.newLine();
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// returneaza toate cartile scrisa in fisier
	@Override
	public List<Carte> getCarti() {
		List<Carte> lc = new ArrayList<Carte>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=br.readLine())!=null){
				lc.add(Carte.getCarteFromString(line));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lc;
	}

	@Override
	public void modificaCarte(Carte nou, Carte vechi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stergeCarte(Carte c) {
		// TODO Auto-generated method stub
		
	}

	// returneaza toate cartile care au ca autor numele transmis ca parametru
	@Override
	public List<Carte> cautaCarte(String autor) {
		List<Carte> carti = getCarti();
		List<Carte> cartiGasite = new ArrayList<Carte>();
		int i=0;
		while (i<carti.size()){
			boolean flag = false;
			List<String> lautor = carti.get(i).getAutori();
			int j = 0;
			while(j<lautor.size()){
				if(lautor.get(j).toLowerCase().contains(autor.toLowerCase())){
					flag = true;
					break;
				}
				j++;
			}
			if(flag){
				cartiGasite.add(carti.get(i));
			}
			i++;
		}
		return cartiGasite;
	}

	@Override
	public List<Carte> getCartiOrdonateDinAnul(String an) {
		List<Carte> lc = getCarti();
		List<Carte> lca = new ArrayList<Carte>();
		for(Carte c:lc){
			//if(c.getAnAparitie().equals(an)){
			if(Integer.parseInt(c.getAnAparitie())<Integer.parseInt(an)){
				lca.add(c);
			}
		}
		
		Collections.sort(lca,new Comparator<Carte>(){

			@Override
			public int compare(Carte a, Carte b) {
				if(a.getTitlu().compareTo(b.getTitlu())==0){
					int i = 0;
                    while(a.getAutori().get(i).compareTo(b.getAutori().get(i)) == 0){i++;}
                    return a.getAutori().get(i).compareTo(b.getAutori().get(i));
				}
				
				return a.getTitlu().compareTo(b.getTitlu());
			}
		
		});

		return lca;
	}

}
