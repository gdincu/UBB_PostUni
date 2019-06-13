package Service;
import Domain.DieselCar;
import Domain.ElectricCar;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DieselService {

    private IRepository<DieselCar> repository;

    public DieselService(IRepository<DieselCar> repository) {
        this.repository = repository;
    }

    public void add(String id, String model, double pret, double consum) {
        DieselCar temp = new DieselCar(id,model,pret,consum);
        repository.upsert(temp);
    }

    public List<DieselCar> sort() {

                List<DieselCar> diesels= new ArrayList<>(repository.getAll());
                Comparator<DieselCar> byPret = (d1 , d2) -> {
                    int t1=0,t2=0;
                    for(DieselCar t : repository.getAll()){
                        if(t.getModel().equals(d1.getModel()))
                            t1 += t.getPret();
                        if(t.getModel().equals(d2.getModel()))
                            t2 += t.getPret();
                    }
                    return t1-t2;
                };

        List<DieselCar> temp = new ArrayList<>(repository.getAll());
        temp.sort(byPret);
        return temp;
    }

    public List<DieselCar> cautareModel (String model) {

        List<DieselCar> temp = new ArrayList<>();
        for(DieselCar t:repository.getAll())
            if(t.getModel().contains(model))
                temp.add(t);

            return temp;
    }

    public List<DieselCar> getAll() {
        return repository.getAll();
    }



}
