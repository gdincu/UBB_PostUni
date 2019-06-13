package Service;
import Domain.ElectricCar;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElectricService {

    private IRepository<ElectricCar> repository;

    public ElectricService(IRepository<ElectricCar> repository) {
        this.repository = repository;
    }

    public void add(String id, String model, double pret, double autonomie) {
        ElectricCar temp = new ElectricCar(id,model,pret,autonomie);
        repository.upsert(temp);
    }

    public List<ElectricCar> sort() {

        List<ElectricCar> diesels= new ArrayList<>(repository.getAll());
        Comparator<ElectricCar> byPret = (d1 , d2) -> {
            int t1=0,t2=0;
            for(ElectricCar t : repository.getAll()){
                if(t.getModel().equals(d1.getModel()))
                    t1 += t.getPret();
                if(t.getModel().equals(d2.getModel()))
                    t2 += t.getPret();
            }
            return t1-t2;
        };

        List<ElectricCar> temp = new ArrayList<>(repository.getAll());
        temp.sort(byPret);
        return temp;
    }

    public List<ElectricCar> cautareModel (String model) {

        List<ElectricCar> temp = new ArrayList<>();
        for(ElectricCar t:repository.getAll())
            if(t.getModel().contains(model))
                temp.add(t);

        return temp;
    }

    public List<ElectricCar> getAll() {
        return repository.getAll();
    }

}
